package me.king.admin.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.king.admin.domain.Customer;
import me.king.admin.domain.CustomerExamineComments;
import me.king.admin.domain.CustomerLoan;
import me.king.admin.domain.CustomerPaymentPlan;
import me.king.admin.domain.CustomerShare;
import me.king.admin.domain.Image;
import me.king.admin.domain.Video;
import me.king.admin.persistence.CustomerExamineCommentsMapper;
import me.king.admin.persistence.CustomerLoanMapper;
import me.king.admin.persistence.CustomerMapper;
import me.king.admin.persistence.ImageMapper;
import me.king.admin.service.CustomerService;
import me.king.admin.util.ConfigProperties;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Resource
	private CustomerMapper customerDao;
	@Resource
	private ConfigProperties config;
	@Resource
	private CustomerExamineCommentsMapper commentsDao;
	@Resource
	private CustomerLoanMapper loanDao;
	@Resource
	private ImageMapper imageDao;
	@Override
	public List<Customer> queryList(Customer customer) {
		return customerDao.selectSelective(customer);
	}
    
	@Override
	public int queryCount(Customer customer) {
		return customerDao.selectSelectiveCount(customer);
	}

	@Override
	public Customer queryDetails(Integer customerId) {
		Customer customer = customerDao.selectDetailsByPrimaryKey(customerId);
		setCustomerImage(customer);
		setCustomerVideo(customer);
		if(customer.getLoan() != null && customer.getLoan().getStageNumber() != null){
			List<CustomerPaymentPlan> cppList = customer.getPaymentPlanList();
			List<CustomerPaymentPlan> receivePaymentList = new ArrayList<>();
			List<CustomerPaymentPlan> overdubPaymentList = new ArrayList<>();
			BigDecimal repaymentAmount = new BigDecimal(0);
			BigDecimal totalRecoveredAmount = new BigDecimal(0);
			BigDecimal totalToBeRecoveredOverdueAmount = new BigDecimal(0);
			if(!cppList.isEmpty()){
				for(CustomerPaymentPlan cpp : cppList){
					if(2 == cpp.getStatus()){
						receivePaymentList.add(cpp);
						if(cpp.getWhetherOverdue() == 1){
							overdubPaymentList.add(cpp);
							totalRecoveredAmount = totalRecoveredAmount.add(BigDecimal.valueOf(cpp.getAmount()));
							Integer sumOverdueDay = Days.daysBetween(new DateTime(cpp.getPlanPaymentDay()),
									new DateTime(cpp.getActualPaymentDay())).getDays();
							cpp.setSumOverdueDay(sumOverdueDay);
						}
						repaymentAmount = repaymentAmount.add(BigDecimal.valueOf(cpp.getAmount()));
					}else if(1 == cpp.getStatus()){
						overdubPaymentList.add(cpp);
						totalToBeRecoveredOverdueAmount = totalToBeRecoveredOverdueAmount
								.add(BigDecimal.valueOf(cpp.getAmount()));
						Integer sumOverdueDay = Days
								.daysBetween(new DateTime(cpp.getPlanPaymentDay()),new DateTime(new Date()))
								.getDays();
						cpp.setSumOverdueDay(sumOverdueDay);
					}
				}
				
			}
			customer.setReceivePaymentList(receivePaymentList);
			//设置待还期数
			customer.setRemainingPeriod(customer.getLoan().getStageNumber() - receivePaymentList.size());
			if(customer.getRemainingPeriod() == 0){
				customer.setTotalRepaymentAmount(customer.getLoan().getAmount());
				customer.setTotalSurplusPaymentAmount(Double.valueOf(0));
			}else{
				//设置共回款
				customer.setTotalRepaymentAmount(repaymentAmount.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
				//设置待还款总金额
				customer.setTotalSurplusPaymentAmount(BigDecimal.valueOf(customer.getLoan().getAmount())
						.subtract(BigDecimal.valueOf(customer.getTotalRepaymentAmount()))
						.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
			}
			
			
			customer.setOverdubPaymentList(overdubPaymentList);
			
			
			customer.setTotalRecoveredAmount(totalRecoveredAmount.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
			customer.setTotalToBeRecoveredOverdueAmount(
					totalToBeRecoveredOverdueAmount.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
		}
		return customer;
	}
	/**
	 * 设置客户视频
	 * @param customer
	 */
	private void setCustomerVideo(Customer customer) {
		List<Video> contractVideoList = customer.getContractVideoList();
		if(!contractVideoList.isEmpty()){
			for(Video video : contractVideoList){
				StringBuffer fullUrl = new StringBuffer(config.getQiNiuLink());
				fullUrl.append(video.getUrl());
				video.setFullUrl(fullUrl.toString());
			}
		}
	}
	/**
	 * 设置客户图片
	 * @param customer
	 */
	private void setCustomerImage(Customer customer) {
		List<Image> imageList = customer.getImageList();
		if(!imageList.isEmpty()){
			if(customer.getShare() == null){
				customer.setShare(new CustomerShare());
			}
			if(customer.getLoan() == null){
				customer.setLoan(new CustomerLoan());
			}
			for(Image image : imageList){
				StringBuffer fullUrl = new StringBuffer(config.getQiNiuLink());
				fullUrl.append(image.getUrl());
				image.setFullUrl(fullUrl.toString());
				switch (image.getType()) {
				case 0:
					customer.setIdCardFaceImg(image);
					break;
				case 1:
					customer.setIdCardSideImg(image);
					break;
				case 2:
					customer.getShare().setIdCardFaceImg(image);
					break;
				case 3:
					customer.getShare().setIdCardSideImg(image);
					break;
				case 4:
					customer.getLoan().setBankCardImg(image);
					break;
				case 5:
					customer.getLoan().setHoldBankCardImg(image);
					break;
				case 6:
					List<Image> contractImageList = customer.getContractImageList();
					if(contractImageList == null){
						contractImageList = new ArrayList<>();
						customer.setContractImageList(contractImageList);
					}
					contractImageList.add(image);
					break;
				case 7:
					customer.setReleasePaymentsImg(image);
					break;
				}
			}
		}
	}

	@Override
	public String queryApprovalFailure(Integer customerId) {
		List<CustomerExamineComments> commentsList = commentsDao.selectByCustomerId(customerId);
		if(commentsList != null && !commentsList.isEmpty()){
			for(CustomerExamineComments comments : commentsList){
				if(comments.getAgree() == 0){
					return comments.getExamineComments();
				}
			}
		}
		return "";
	}
	
	@Override
	public CustomerLoan queryCustomerLoan(Integer customerId) {
		CustomerLoan loan = loanDao.selectByCustomerId(customerId);
		List<Integer> types = new ArrayList<>();
		types.add(4);
		types.add(5);
		List<Image> imageList = imageDao.selectByCustomerIdAndTypes(customerId, types);
		if(!imageList.isEmpty()){
			for(Image image : imageList){
				StringBuffer fullUrl = new StringBuffer(config.getQiNiuLink());
				fullUrl.append(image.getUrl());
				image.setFullUrl(fullUrl.toString());
				switch (image.getType()) {
				case 4:
					loan.setBankCardImg(image);
					break;
				case 5:
					loan.setHoldBankCardImg(image);
					break;
				}
			}
		}
		return loan;
	}

	@Override
	public Boolean verifyIdOnly(Integer customerId,String cardNumber) {
		if(customerId != null){
			Customer customer = customerDao.selectByPrimaryKey(customerId);
			if(customer != null && cardNumber.equals(customer.getCardNumber())){
				return true;
			}
		}
		return customerDao.queryByCardNumber(cardNumber) == null;
	}
}
