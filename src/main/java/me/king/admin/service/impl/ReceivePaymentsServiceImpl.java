package me.king.admin.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.king.admin.domain.Customer;
import me.king.admin.domain.CustomerPaymentPlan;
import me.king.admin.persistence.CustomerMapper;
import me.king.admin.persistence.CustomerPaymentPlanMapper;
import me.king.admin.service.ReceivePaymentsService;
@Service
@Transactional
public class ReceivePaymentsServiceImpl implements ReceivePaymentsService {
	private static final Logger LOG = LoggerFactory.getLogger(ReceivePaymentsServiceImpl.class);
	@Resource
	private CustomerMapper customerDao;
	@Resource
	private CustomerPaymentPlanMapper cppDao;
	
	
	
	@Override
	public boolean manualReceivePayment(String userName, Integer customerId, Integer stageNumber,
			Integer remainingPeriod,Integer periods) {
		Customer customer = customerDao.selectByPrimaryKey(customerId);
		Date currentTime = new Date();
		Integer beginPeriods = 0;
		if(stageNumber > remainingPeriod){
			beginPeriods = stageNumber - remainingPeriod;
		}
		Integer endPeriods = beginPeriods + periods;
		List<CustomerPaymentPlan> cppList = cppDao.selectRangePeriod(customerId, beginPeriods,endPeriods);
		for(CustomerPaymentPlan cpp : cppList){
			cpp.setStatus(2);
			cpp.setActualPaymentDay(currentTime);
			cpp.setManualPaymentUser(userName);
			cpp.setPaymentType(1);
			cppDao.updateByPrimaryKeySelective(cpp);
		}
		if(periods == customer.getLoan().getStageNumber() 
				|| (remainingPeriod - periods) == 0){
			customer.setStatus(6);
			customerDao.updateByPrimaryKeySelective(customer);
		}
		return true;
	}

	@Override
	public void automaticDeduction() {
		LOG.info("自动划款 begin");
		//查询需要还款的计划
		List<Customer> customerList = customerDao.selectCurrentAccount(new Customer()); 
		if(customerList != null && !customerList.isEmpty()){
			for(Customer customer : customerList){
				List<CustomerPaymentPlan> cppList = customer.getPaymentPlanList();
				for(CustomerPaymentPlan cpp : cppList){
					LOG.info("客户{}-{}还款，还款期数为：{}，还款金额为{}",customer.getId(),
							customer.getName(),cpp.getPeriods(),cpp.getAmount());
					//TODO 扣款接口
					boolean isDeductionsSuccess = true;
					
					if(isDeductionsSuccess){
						//更新回款计划
						cpp.setActualPaymentDay(new Date());
						cpp.setPaymentType(0);
						cpp.setStatus(2);
						cppDao.updateByPrimaryKeySelective(cpp);
						//是否需要变更用户状态
						if(cpp.getPeriods() == customer.getLoan().getStageNumber()){
							customer.setStatus(6);
							customerDao.updateByPrimaryKeySelective(customer);
						}
					}else{
						//设置逾期原因
						cpp.setWhetherOverdue(1);
						cpp.setOverdueReason(0);
						cpp.setStatus(1);
						customer.setStatus(5);
						customerDao.updateByPrimaryKeySelective(customer);
					}
					cppDao.updateByPrimaryKeySelective(cpp);
				}
			}
		}else{
			LOG.info("没有需要划款的客户");
		}
		
		LOG.info("自动划款 end");
	}
}
