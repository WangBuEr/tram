package me.king.admin.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.king.admin.domain.Customer;
import me.king.admin.domain.CustomerPaymentPlan;
import me.king.admin.domain.Image;
import me.king.admin.persistence.CustomerMapper;
import me.king.admin.persistence.CustomerPaymentPlanMapper;
import me.king.admin.persistence.ImageMapper;
import me.king.admin.service.ReleasePaymentsService;
import me.king.admin.util.DateTimeUtil;
@Service
@Transactional
public class ReleasePaymentsServiceImpl implements ReleasePaymentsService {
	@Resource
	private CustomerMapper customerDao;
	@Resource
	private ImageMapper imageDao;
	@Resource
	private CustomerPaymentPlanMapper cppDao;
	@Override
	public boolean loan(Integer customerId, String imageId, String releasePaymentsNumber,String releasePaymentsUser) {
		Customer customer = customerDao.selectByPrimaryKey(customerId);
		if(customer == null || customer.getStatus() != 3){
			return false;
		}
		customer.setPreStatus(customer.getStatus());
		customer.setStatus(4);
		customer.setReleasePaymentsNumber(releasePaymentsNumber);
		customer.setReleasePaymentsUserName(releasePaymentsUser);
		customer.setReleasePaymentsTime(new Date());
		customerDao.updateByPrimaryKeySelective(customer);
		Image image = new Image();
		image.setCustomerId(customer.getId());
		image.setUploadTime(new Date());
		image.setUploadUser(releasePaymentsUser);
		image.setUrl(imageId);
		image.setType(7);
		imageDao.insert(image);
		//放款计划
		Date actualPaymentDay = DateTimeUtil.getNextMonthDate(customer.getReleasePaymentsTime());
		double loanAmount = new BigDecimal(customer.getLoan().getAmount())
				.divide(new BigDecimal(customer.getLoan().getStageNumber()), 2, BigDecimal.ROUND_HALF_UP).doubleValue();
		for(int periods = 1; periods <= customer.getLoan().getStageNumber(); periods++){
			CustomerPaymentPlan cpp = new CustomerPaymentPlan(customer.getId(), periods,
					loanAmount, actualPaymentDay);
			cpp.setStatus(0);
			cpp.setWhetherOverdue(0);
			cppDao.insert(cpp);
			actualPaymentDay = DateTimeUtil.getNextMonthDate(actualPaymentDay);
		}
		return true;
	}
	
}
