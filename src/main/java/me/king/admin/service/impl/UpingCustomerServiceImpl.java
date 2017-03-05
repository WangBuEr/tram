package me.king.admin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.king.admin.domain.BaseQuery;
import me.king.admin.domain.Customer;
import me.king.admin.domain.CustomerEmergencyContact;
import me.king.admin.domain.CustomerLoan;
import me.king.admin.domain.CustomerShare;
import me.king.admin.domain.Image;
import me.king.admin.domain.Video;
import me.king.admin.persistence.CustomerEmergencyContactMapper;
import me.king.admin.persistence.CustomerLoanMapper;
import me.king.admin.persistence.CustomerMapper;
import me.king.admin.persistence.CustomerShareMapper;
import me.king.admin.persistence.ImageMapper;
import me.king.admin.persistence.VideoMapper;
import me.king.admin.service.UpingCustomerService;
import me.king.admin.util.ConfigProperties;
import me.king.util.qiniu.QiNiuUtil;
@Service
@Transactional
public class UpingCustomerServiceImpl implements UpingCustomerService {
	@Resource
	private CustomerMapper customerDao;
	@Resource 
	private CustomerEmergencyContactMapper emergencyContactDao;
	@Resource
	private ImageMapper imageDao;
	@Resource
	private VideoMapper videoDao;
	@Resource
	private CustomerShareMapper shareDao;
	@Resource
	private CustomerLoanMapper customerLoanDao;
	@Resource
	private ConfigProperties config;
	@Override
	public BaseQuery upinCustomergBasic(Customer customer) {
		if(customer.getId() == null){
			customer.setUpingTime(new Date());
			customer.setStatus(0);
			customerDao.insertSelective(customer);
		}else{
			customerDao.updateByPrimaryKeySelective(customer);
		}
		
		
		CustomerShare share = customer.getShare();
		share.setCustomerId(customer.getId());
		if(share.getId() == null){
			shareDao.insert(share);
		}else{
			shareDao.updateByPrimaryKeySelective(share);
		}
		emergencyContactDao.deleteByCustomerId(customer.getId());
		List<CustomerEmergencyContact> emergencyContactList = customer.getEmergencyContactList();
		if(emergencyContactList != null && !emergencyContactList.isEmpty()){
			for(CustomerEmergencyContact emergencyContact : emergencyContactList){
				emergencyContact.setCustomerId(customer.getId());
				emergencyContactDao.insert(emergencyContact);
			}
		}
		List<Integer> types = new ArrayList<>();
		types.add(0);
		types.add(1);
		types.add(2);
		types.add(3);
		imageDao.deleteByCustomerIdIdAndTypes(customer.getId(), types);
		List<Image> imageList = customer.getImageList();
		if(imageList != null && !imageList.isEmpty()){
			for(Image image : imageList){
				image.setCustomerId(customer.getId());
				image.setUploadTime(new Date());
				imageDao.insert(image);
			}
		}
		return customer;
	}
	@Override
	public CustomerLoan upinCustomergLoan(CustomerLoan customerLoan) {
		if(customerLoan.getId() != null){
			customerLoanDao.updateByPrimaryKeySelective(customerLoan);
		}else{
			customerLoanDao.insertSelective(customerLoan);
		}
		List<Integer> types = new ArrayList<>();
		types.add(4);
		types.add(5);
		imageDao.deleteByCustomerIdIdAndTypes(customerLoan.getCustomerId(), types);
		Image bankImage = customerLoan.getBankCardImg();
		bankImage.setCustomerId(customerLoan.getCustomerId());
		bankImage.setUploadTime(new Date());
		imageDao.insertSelective(bankImage);
		Image holdBankImage = customerLoan.getHoldBankCardImg();
		holdBankImage.setCustomerId(customerLoan.getCustomerId());
		holdBankImage.setUploadTime(new Date());
		imageDao.insertSelective(holdBankImage);
		return customerLoan;
	}
	
	@Override
	public BaseQuery upinCustomergContract(Customer customer) {
		customer.setUpingTime(new Date());
		customerDao.updateByPrimaryKeySelective(customer);
		videoDao.deleteByCustomerId(customer.getId());
		for(Video video : customer.getContractVideoList()){
			video.setCustomerId(customer.getId());
			video.setUploadTime(new Date());
			videoDao.insertSelective(video);
		}
		List<Integer> imageTypes = new ArrayList<>();
		imageTypes.add(6);
		imageDao.deleteByCustomerIdIdAndTypes(customer.getId(), imageTypes);
		for(Image image : customer.getContractImageList()){
			image.setCustomerId(customer.getId());
			image.setUploadTime(new Date());
			imageDao.insertSelective(image);
		}
		return customer;
	}
	@Override
	public boolean deleteCustomer(Integer customerId) {
		Customer customer = customerDao.selectByPrimaryKey(customerId);
		if(customer.getStatus() != 0 && customer.getStatus() != 1 && customer.getStatus() != 2){
			return false;
		}
		
		if(!SecurityUtils.getSubject().getPrincipal().equals(customerId)){
			return false;
		}
		//删除图片
		List<Image> imageList = imageDao.selectByCustomerId(customerId);
		if(!imageList.isEmpty()){
			for(Image image : imageList){
				QiNiuUtil.getInstance(config.getQiNiuAecretKey(), config.getQiNiuSecretKey())
						.deleteResources(config.getQiNiuBucketName(), image.getUrl());
			}
			imageDao.deleteByCustomerId(customerId);
		}
		//删除视频
		List<Video> videoList = videoDao.selectByCustomerId(customerId);
		if(!videoList.isEmpty()){
			for(Video video : videoList){
				QiNiuUtil.getInstance(config.getQiNiuAecretKey(), config.getQiNiuSecretKey())
				.deleteResources(config.getQiNiuBucketName(), video.getUrl());
			}
			videoDao.deleteByCustomerId(customerId);
		}
		
		//删除贷款信息
		customerLoanDao.deleteByCustomerId(customerId);
		customerDao.deleteByPrimaryKey(customerId);
		return true;
	}
	@Override
	public boolean upingCustomer(Integer customerId) {
		Customer customer = customerDao.selectByPrimaryKey(customerId);
		if(customer == null || (customer.getStatus() != 0 && customer.getStatus() != 2)
				|| !customer.getUpingUserName().equals(SecurityUtils.getSubject().getPrincipal())){
			return false;
		}
		customer.setPreStatus(customer.getStatus());
		customer.setStatus(1);
		customerDao.updateByPrimaryKeySelective(customer);
		return true;
	}
	
	
}
