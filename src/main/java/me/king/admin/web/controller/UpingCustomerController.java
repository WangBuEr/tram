package me.king.admin.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import me.king.admin.domain.Customer;
import me.king.admin.domain.CustomerLoan;
import me.king.admin.service.CustomerService;
import me.king.admin.service.UpingCustomerService;
import me.king.admin.web.vo.BusinessExecutionResult;
import me.king.admin.web.vo.DataTablesRsp;

@Controller
@RequestMapping("uping")
public class UpingCustomerController {
	private static final Logger LOG = LoggerFactory.getLogger(UpingCustomerController.class);
	@Resource
	private UpingCustomerService upingCustomerService;
	@Resource
	private CustomerService customerService;
	@RequestMapping("search")
	@RequiresRoles(value = { "sc","admin"},logical = Logical.OR)
	public String search(){
		return "/uping/search";
	}
	@RequiresRoles(value = { "sc","admin"},logical = Logical.OR)
	@RequestMapping("query")
	@ResponseBody
	public DataTablesRsp<Customer> query(Customer queryParam){
		DataTablesRsp<Customer> result = new DataTablesRsp<>(queryParam.getDraw());
		queryParam.setUpingUserName(SecurityUtils.getSubject().getPrincipal().toString());
		List<Customer> datas =  customerService.queryList(queryParam);
		int count =  customerService.queryCount(queryParam);
		result.setData(datas);
		result.setRecordsTotal(count);
		result.setRecordsFiltered(count);
		return result;
	}
	@RequiresRoles(value = { "sc","admin"},logical = Logical.OR)
	@RequestMapping("upinCustomergBasic")
	@ResponseBody
	public BusinessExecutionResult upinCustomergBasic(String paramJson){
		Customer customer = JSON.parseObject(paramJson, Customer.class);
		customer.setUpingUserName(SecurityUtils.getSubject().getPrincipal().toString());
		LOG.debug("上报客户基本信息，客户信息：{}",customer);
		return BusinessExecutionResult.success(upingCustomerService.upinCustomergBasic(customer));
	}
	@RequiresRoles(value = { "sc","admin"},logical = Logical.OR)
	@RequestMapping("upinCustomergLoan")
	@ResponseBody
	public BusinessExecutionResult upinCustomergLoan(String paramJson){
		CustomerLoan customerLoan = JSON.parseObject(paramJson, CustomerLoan.class);
		LOG.debug("上报客户贷款信息，客户贷款信息：{}",customerLoan);
		return BusinessExecutionResult.success(upingCustomerService.upinCustomergLoan(customerLoan));
	}
	@RequiresRoles(value = { "sc","admin"},logical = Logical.OR)
	@RequestMapping("upinCustomergContract")
	@ResponseBody
	public BusinessExecutionResult upinCustomergContract(String paramJson){
		Customer customer = JSON.parseObject(paramJson, Customer.class);
		if(customer.getStatus() != null && customer.getStatus() != 1){
			return BusinessExecutionResult.illegalOperation("非法操作");
		}
		LOG.debug("上报客户合同信息，客户合同信息：{}",customer);
		return BusinessExecutionResult.success(upingCustomerService.upinCustomergContract(customer));
	}
	@RequiresRoles(value = { "sc","admin"},logical = Logical.OR)
	@RequestMapping("deleteCustomer/{customerId}")
	@ResponseBody
	public BusinessExecutionResult deleteCustomer(@PathVariable Integer customerId){
		LOG.debug("删除客户信息：{}",customerId);
		if(upingCustomerService.deleteCustomer(customerId)){
			return BusinessExecutionResult.success(null);
		}else{
			return BusinessExecutionResult.illegalOperation("非法操作");
		}
		
	}
	@RequiresRoles(value = { "sc","admin"},logical = Logical.OR)
	@RequestMapping("upingCustomer/{customerId}")
	@ResponseBody
	public BusinessExecutionResult upingCustomer(@PathVariable Integer customerId){
		LOG.debug("上报客户：{}",customerId);
		if(upingCustomerService.upingCustomer(customerId)){
			return BusinessExecutionResult.success();
		}else{
			return BusinessExecutionResult.illegalOperation("非法操作");
		}
	}
}
