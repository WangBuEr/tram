package me.king.admin.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import me.king.admin.domain.Customer;
import me.king.admin.service.CustomerService;
import me.king.admin.service.ReleasePaymentsService;
import me.king.admin.util.ConfigProperties;
import me.king.admin.web.vo.BusinessExecutionResult;
import me.king.admin.web.vo.DataTablesRsp;
import me.king.util.qiniu.QiNiuUtil;
/**
 * 放款管理
 * @author BuEr
 *
 */
@Controller
@RequestMapping("release")
public class ReleasePaymentsController {
	@Resource
	private ConfigProperties config;
	@Resource
	private CustomerService customerService;
	@Resource
	private ReleasePaymentsService releasePaymentsService;
	@RequestMapping("search")
	public ModelAndView search(){
		ModelAndView result = new ModelAndView();
		getUploadToken(result);
		result.setViewName("/release/search");
		return result;
	}
	@RequestMapping("query")
	@ResponseBody
	public DataTablesRsp<Customer> query(Customer queryParam){
		DataTablesRsp<Customer> result = new DataTablesRsp<>(queryParam.getDraw());
		queryParam.setStatus(3);
		List<Customer> datas =  customerService.queryList(queryParam);
		int count =  customerService.queryCount(queryParam);
		result.setData(datas);
		result.setRecordsTotal(count);
		result.setRecordsFiltered(count);
		return result;
	}
	@RequestMapping("loan")
	@ResponseBody
	public BusinessExecutionResult loan(Integer customerId,String imageId,String releasePaymentsNumber){
		if (releasePaymentsService.loan(customerId, imageId, releasePaymentsNumber,
				SecurityUtils.getSubject().getPrincipal().toString())) {
			return BusinessExecutionResult.success();
		} else {
			return BusinessExecutionResult.illegalOperation("非法操作");
		}
	}
	private void getUploadToken(ModelAndView result) {
		QiNiuUtil qiNiuUtil = QiNiuUtil.getInstance(config.getQiNiuAecretKey(), config.getQiNiuSecretKey());
		result.addObject("uploadToken", qiNiuUtil.getUpToken(config.getQiNiuBucketName()));
	}
}
