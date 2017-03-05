package me.king.admin.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import me.king.admin.domain.Customer;
import me.king.admin.service.CustomerService;
import me.king.admin.service.ReceivePaymentsService;
import me.king.admin.web.vo.BusinessExecutionResult;
import me.king.admin.web.vo.DataTablesRsp;

/**
 * 收款管理
 * 
 * @author BuEr
 *
 */
@Controller
@RequestMapping("receive")
public class ReceivePaymentsController {
	@Resource
	private ReceivePaymentsService receivePaymentsService;
	@Resource
	private CustomerService customerService;
	@RequiresRoles(value = { "rp","admin"},logical = Logical.OR)
	@RequestMapping("search/{receiveType}")
	public ModelAndView search(@PathVariable String receiveType) {
		ModelAndView result = new ModelAndView();
		if(!"0".equals(receiveType)&&!"1".equals(receiveType)
				&&!"2".equals(receiveType)
				&&!"3".equals(receiveType)){
			result.setViewName("/error/401");
			return result;
		}
		result.addObject("receiveType", receiveType);
		result.setViewName("/receive/search");
		return result;
	}
	@RequiresRoles(value = { "rp","admin"},logical = Logical.OR)
	@RequestMapping("query")
	@ResponseBody
	public DataTablesRsp<Customer> query(Customer queryParam) {
		DataTablesRsp<Customer> result = new DataTablesRsp<>(queryParam.getDraw());
		if (queryParam.getReceivePaymentsStatus() == null) {
			List<Integer> statusList = new ArrayList<>();
			statusList.add(4);
			statusList.add(5);
			queryParam.setStatusList(statusList);
		}
		List<Customer> datas = customerService.queryList(queryParam);
		int count = customerService.queryCount(queryParam);
		result.setData(datas);
		result.setRecordsTotal(count);
		result.setRecordsFiltered(count);
		return result;
	}
	@RequiresRoles(value = { "rp","admin"},logical = Logical.OR)
	@RequestMapping("totalPayment")
	@ResponseBody
	public BusinessExecutionResult totalPayment(Customer queryParam){
		if (queryParam.getReceivePaymentsStatus() == null) {
			List<Integer> statusList = new ArrayList<>();
			statusList.add(4);
			statusList.add(5);
			queryParam.setStatusList(statusList);
		}
		queryParam.setStart(0);
		queryParam.setLength(Integer.MAX_VALUE);
		List<Customer> customerList = customerService.queryList(queryParam);
		BigDecimal result =  new BigDecimal(0);
		if(customerList != null && !customerList.isEmpty()){
			for(Customer customer : customerList){
				BigDecimal remainingSum = BigDecimal.valueOf(customer.getCurrentRepayment())
						.multiply(BigDecimal.valueOf(customer.getRemainingPeriod()));
				result = result.add(remainingSum);
			}
		}
		return BusinessExecutionResult.success(result.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
	}
	/**
	 * 手动回款
	 * @param customerId
	 * @param stageNumber 分期数
	 * @param remainingPeriod 已还期数
	 * @param periods 还款期数
	 * @return
	 */
	@RequiresRoles(value = { "rp","admin"},logical = Logical.OR)
	@RequestMapping("manualReceivePayment")
	@ResponseBody
	public BusinessExecutionResult manualReceivePayment(Integer customerId, Integer stageNumber, Integer remainingPeriod,
			Integer periods) {
		if (receivePaymentsService.manualReceivePayment(SecurityUtils.getSubject().getPrincipal().toString(), customerId, stageNumber, remainingPeriod, periods)) {
			return BusinessExecutionResult.success(null);
		} else {
			return BusinessExecutionResult.illegalOperation("非法操作");
		}
	}
	
	
}
