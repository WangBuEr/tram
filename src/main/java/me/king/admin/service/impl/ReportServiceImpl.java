package me.king.admin.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import me.king.admin.domain.Customer;
import me.king.admin.domain.CustomerPaymentPlan;
import me.king.admin.persistence.CustomerMapper;
import me.king.admin.persistence.CustomerPaymentPlanMapper;
import me.king.admin.service.ReportService;
@Service
public class ReportServiceImpl implements ReportService {
	@Resource
	private CustomerMapper customerDao;
	@Resource
	private CustomerPaymentPlanMapper customerPaymentPlanDao;
	@Override
	public Map<String, Object> statistics(String endReleasePaymentsDate, String beginReleasePaymentsDate) {
		Customer queryParam = new Customer();
		Map<String, Object> result = new HashMap<>();
		queryParam.setBeginReleasePaymentsDate(beginReleasePaymentsDate);
		queryParam.setEndReleasePaymentsDate(endReleasePaymentsDate);
		BigDecimal totalLoan = BigDecimal.valueOf(0);
		BigDecimal totalPlanReceivedAmount = BigDecimal.valueOf(0);
		BigDecimal totalReceivedAmount = BigDecimal.valueOf(0);
		BigDecimal totalOverdueAmount = BigDecimal.valueOf(0);
		BigDecimal totalToBeOverdueAmount = BigDecimal.valueOf(0);
		BigDecimal endTotalLoan = BigDecimal.valueOf(0);
		List<Integer> statusList = new ArrayList<>();
		statusList.add(4);
		statusList.add(5);
		statusList.add(6);
		queryParam.setStatusList(statusList);
		queryParam.setStart(0);
		queryParam.setLength(Integer.MAX_VALUE);
		List<Customer> customerList = customerDao.selectSelective(queryParam);
		for(Customer customer : customerList){
			if(customer.getLoan() != null && customer.getLoan().getAmount() != null){
				//放款总金额
				totalLoan = totalLoan.add(BigDecimal.valueOf(customer.getLoan().getAmount()));
				if(6 == customer.getStatus()){
					//完结放款总金额
					endTotalLoan = endTotalLoan.add(BigDecimal.valueOf(customer.getLoan().getAmount()));
				}
			}
		}
		
		List<CustomerPaymentPlan> cppList = customerPaymentPlanDao.selectRangePlanDate(beginReleasePaymentsDate, endReleasePaymentsDate);
		for(CustomerPaymentPlan cpp : cppList){
			BigDecimal amount = BigDecimal.valueOf(cpp.getAmount());
			if(0 == cpp.getStatus()){
				totalToBeOverdueAmount = totalToBeOverdueAmount.add(amount);
			}else if(1 == cpp.getStatus()){
				totalOverdueAmount = totalOverdueAmount.add(amount);
			}else{
				totalReceivedAmount = totalReceivedAmount.add(amount);
			}
			totalPlanReceivedAmount = totalPlanReceivedAmount.add(amount);
		}
		result.put("totalLoan", totalLoan.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
		result.put("totalPlanReceivedAmount", totalPlanReceivedAmount.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
		result.put("totalReceivedAmount", totalReceivedAmount.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
		result.put("totalOverdueAmount", totalOverdueAmount.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
		result.put("totalToBeOverdueAmount", totalToBeOverdueAmount.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
		result.put("endTotalLoan",endTotalLoan.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
		result.put("releaseCustomerSum", customerList.size());
		return result;
	}

}
