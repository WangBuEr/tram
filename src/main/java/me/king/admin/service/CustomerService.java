package me.king.admin.service;

import java.util.List;

import me.king.admin.domain.Customer;
import me.king.admin.domain.CustomerLoan;

public interface CustomerService {
	List<Customer> queryList(Customer customer);
	int queryCount(Customer customer);
	//	查询客户详情
	Customer queryDetails(Integer customerId);
	//查询审批失败意见
	String queryApprovalFailure(Integer customerId);
	/**
	 * 查询客户贷款信息
	 * @param customerId
	 * @return
	 */
	CustomerLoan queryCustomerLoan(Integer customerId);
	
	Boolean verifyIdOnly(Integer customerId,String cardNumber);
}
