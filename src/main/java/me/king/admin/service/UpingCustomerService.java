package me.king.admin.service;

import me.king.admin.domain.BaseQuery;
import me.king.admin.domain.Customer;
import me.king.admin.domain.CustomerLoan;

public interface UpingCustomerService {
	
	BaseQuery upinCustomergBasic(Customer customer);
	
	CustomerLoan upinCustomergLoan(CustomerLoan customer);
	
	BaseQuery upinCustomergContract(Customer customer);
	
	boolean deleteCustomer(Integer customerId);
	
	boolean upingCustomer(Integer customerId);
}
