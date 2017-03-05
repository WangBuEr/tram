package me.king.admin.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.king.admin.domain.Customer;
import me.king.admin.domain.CustomerExamineComments;
import me.king.admin.persistence.CustomerExamineCommentsMapper;
import me.king.admin.persistence.CustomerMapper;
import me.king.admin.service.ExamineCustomerService;
@Service
@Transactional
public class ExamineCustomerServiceImpl implements ExamineCustomerService {
	@Resource
	private CustomerMapper customerDao;
	@Resource
	private CustomerExamineCommentsMapper examineCommentsDao;
	@Override
	public boolean approve(CustomerExamineComments comments) {
		Customer customer = customerDao.selectByPrimaryKey(comments.getCustomerId());
		if(customer == null || customer.getStatus() != 1){
			return false;
		}
		customer.setExamineTime(new Date());
		customer.setExamineUserName(SecurityUtils.getSubject().getPrincipal().toString());
		customer.setPreStatus(customer.getStatus());
		if(1 == comments.getAgree()){
			//审批通过
			customer.setStatus(3);
		}else{
			//审批拒绝
			customer.setStatus(2);
		}
		customerDao.updateByPrimaryKeySelective(customer);
		comments.setExamineTime(new Date());
		examineCommentsDao.insert(comments);
		return true;
	}

	

}
