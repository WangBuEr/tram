package me.king.admin.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.king.admin.domain.Customer;
import me.king.admin.domain.CustomerExamineComments;
import me.king.admin.service.CustomerService;
import me.king.admin.service.ExamineCustomerService;
import me.king.admin.web.vo.BusinessExecutionResult;
import me.king.admin.web.vo.DataTablesRsp;

@Controller
@RequestMapping("examine")
public class ExamineCustomerController {
	@Resource
	private CustomerService customerService;
	@Resource
	private ExamineCustomerService examineCustomerService;
	@RequestMapping("search")
	public String search(){
		return "/examine/search";
	}
	@RequestMapping("query")
	@ResponseBody
	public DataTablesRsp<Customer> query(Customer queryParam){
		DataTablesRsp<Customer> result = new DataTablesRsp<>(queryParam.getDraw());
		queryParam.setStatus(1);
		List<Customer> datas =  customerService.queryList(queryParam);
		int count =  customerService.queryCount(queryParam);
		result.setData(datas);
		result.setRecordsTotal(count);
		result.setRecordsFiltered(count);
		return result;
	}
	/**
	 * 审批客户
	 * @param comments
	 * @return
	 */
	@RequestMapping("approve")
	@ResponseBody
	public BusinessExecutionResult approve(CustomerExamineComments comments){
		if(examineCustomerService.approve(comments)){
			return BusinessExecutionResult.success(null);
		}else{
			return BusinessExecutionResult.illegalOperation("非法操作");
		}
	}
}
