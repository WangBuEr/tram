package me.king.admin.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.king.admin.domain.CustomerPaymentPlan;

public interface CustomerPaymentPlanMapper {
	/**
	 * 此方法是由MyBatis Generator自动生成不要修改。 这个方法对应于数据库表。 customer_payment_plan
	 *
	 * @mbggenerated Tue Feb 07 16:47:39 CST 2017
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * 此方法是由MyBatis Generator自动生成不要修改。 这个方法对应于数据库表。 customer_payment_plan
	 *
	 * @mbggenerated Tue Feb 07 16:47:39 CST 2017
	 */
	int insert(CustomerPaymentPlan record);

	/**
	 * 此方法是由MyBatis Generator自动生成不要修改。 这个方法对应于数据库表。 customer_payment_plan
	 *
	 * @mbggenerated Tue Feb 07 16:47:39 CST 2017
	 */
	int insertSelective(CustomerPaymentPlan record);

	/**
	 * 此方法是由MyBatis Generator自动生成不要修改。 这个方法对应于数据库表。 customer_payment_plan
	 *
	 * @mbggenerated Tue Feb 07 16:47:39 CST 2017
	 */
	CustomerPaymentPlan selectByPrimaryKey(Integer id);

	/**
	 * 此方法是由MyBatis Generator自动生成不要修改。 这个方法对应于数据库表。 customer_payment_plan
	 *
	 * @mbggenerated Tue Feb 07 16:47:39 CST 2017
	 */
	int updateByPrimaryKeySelective(CustomerPaymentPlan record);

	/**
	 * 此方法是由MyBatis Generator自动生成不要修改。 这个方法对应于数据库表。 customer_payment_plan
	 *
	 * @mbggenerated Tue Feb 07 16:47:39 CST 2017
	 */
	int updateByPrimaryKey(CustomerPaymentPlan record);

	// biz begin
	List<CustomerPaymentPlan> selectByCustomerId(Integer customerId);
	
	List<CustomerPaymentPlan> selectRangePeriod(@Param("customerId")Integer customerId,@Param("beginPeriods")Integer beginPeriods,@Param("endPeriods")Integer endPeriods);
	
	List<CustomerPaymentPlan> selectRangePlanDate(@Param("beginPlanPaymentDay")String beginPlanPaymentDay,@Param("endPlanPaymentDay")String endPlanPaymentDay);
	// biz end
}