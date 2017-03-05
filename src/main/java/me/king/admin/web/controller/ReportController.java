package me.king.admin.web.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import me.king.admin.service.ReportService;
import me.king.admin.util.DateTimeUtil;
import me.king.admin.web.vo.BusinessExecutionResult;

@Controller
@RequestMapping("report")
public class ReportController {
	@Resource
	private ReportService reportService;
	
	@RequestMapping("index")
	public ModelAndView index(){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		ModelAndView result = new ModelAndView();
		Date currentTime = new Date();
		result.addObject("endReleasePaymentsDate", df.format(currentTime));
		result.addObject("beginReleasePaymentsDate", df.format(DateTimeUtil.getUpMonthDate(currentTime)));
		result.setViewName("/report/index");
		return result;
	}
	@RequestMapping("statistics")
	@ResponseBody
	public BusinessExecutionResult statistics(String endReleasePaymentsDate,String beginReleasePaymentsDate){
		return BusinessExecutionResult
				.success(reportService.statistics(endReleasePaymentsDate, beginReleasePaymentsDate));
	}
}
