package me.king.admin.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import me.king.admin.domain.BaseQuery;
import me.king.admin.domain.Customer;
import me.king.admin.domain.CustomerLoan;
import me.king.admin.service.CustomerService;
import me.king.admin.util.ConfigProperties;
import me.king.admin.web.vo.BusinessExecutionResult;
import me.king.admin.web.vo.DataTablesRsp;
import me.king.util.qiniu.QiNiuUtil;

@Controller
@RequestMapping("customer")
public class CustomerController {
	@Resource
	private ConfigProperties config;
	@Resource
	private CustomerService customerService;
	@RequestMapping("search")
	public String search(){
		return "/customer/search";
	}
	@RequestMapping("query")
	@ResponseBody
	public DataTablesRsp<Customer> query(Customer queryParam){
		DataTablesRsp<Customer> result = new DataTablesRsp<>(queryParam.getDraw());
		List<Customer> datas =  customerService.queryList(queryParam);
		int count =  customerService.queryCount(queryParam);
		result.setData(datas);
		result.setRecordsTotal(count);
		result.setRecordsFiltered(count);
		return result;
	}
	@RequiresRoles(value = { "sc","admin"},logical = Logical.OR)
	@RequestMapping("addOrUpdateBasic")
	public ModelAndView addOrUpdateBasic(Integer customerId) throws Exception{
		ModelAndView result = new ModelAndView();
		getUploadToken(result);
		if(customerId != null){
			BaseQuery customer = customerService.queryDetails(customerId);
			result.addObject("customer", customer);
		}
		result.setViewName("/customer/addOrUpdateBasic");
		return result;
	}
	@RequiresRoles(value = { "sc","admin"},logical = Logical.OR)
	@RequestMapping("addOrUpdateLoan")
	public ModelAndView addOrUpdateLoan(Integer customerId){
		ModelAndView result = new ModelAndView();
		getUploadToken(result);
		if(customerId != null){
			CustomerLoan loan = customerService.queryCustomerLoan(customerId);
			result.addObject("loan", loan);
		}
		result.setViewName("/customer/addOrUpdateLoan");
		return result;
	}
	@RequiresRoles(value = { "sc","admin"},logical = Logical.OR)
	@RequestMapping("addOrUpdateContract")
	public ModelAndView addOrUpdateContract(Integer customerId){
		ModelAndView result = new ModelAndView();
		getUploadToken(result);
		if(customerId != null){
			BaseQuery customer = customerService.queryDetails(customerId);
			result.addObject("customer", customer);
		}
		result.setViewName("/customer/addOrUpdateContract");
		return result;
	}
	@RequestMapping("details/{customerId}")
	public ModelAndView details(@PathVariable Integer customerId,Integer see){
		ModelAndView result = new ModelAndView();
		Customer customer = customerService.queryDetails(customerId);
		result.addObject("customer", customer);
		result.setViewName("/customer/details");
		
		if(see != null && see == 1 
				&& customer.getPreStatus() != null
				&& customer.getPreStatus() == 2){
			String failComments = customerService.queryApprovalFailure(customerId);
			result.addObject("failComments", failComments);
		}
		
		return result;
	}
	@RequiresRoles(value = { "sc","em","admin"},logical = Logical.OR)
	@RequestMapping("queryApprovalFailure/{customerId}")
	@ResponseBody
	public BusinessExecutionResult queryApprovalFailure(@PathVariable Integer customerId){
		return BusinessExecutionResult.success(customerService.queryApprovalFailure(customerId));
	}
	/**
	 * 验证身份证号是否唯一
	 * @param cardNumber
	 * @return
	 */
	@RequestMapping("validate/cardNumber")
	@ResponseBody
	public Map<String, Boolean> validateCardNumber(Integer customerId,String cardNumber){
		Map<String, Boolean> result = new HashMap<>();
		result.put("valid", customerService.verifyIdOnly(customerId, cardNumber));
		return result;
	}
	private void getUploadToken(ModelAndView result) {
		QiNiuUtil qiNiuUtil = QiNiuUtil.getInstance(config.getQiNiuAecretKey(), config.getQiNiuSecretKey());
		result.addObject("uploadToken", qiNiuUtil.getUpToken(config.getQiNiuBucketName()));
	}
}
