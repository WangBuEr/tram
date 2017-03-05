package me.king.admin.service;

/**
 * 筹款服务
 * 
 * @author BuEr
 *
 */
public interface ReceivePaymentsService {
	/**
	 * 手动还款
	 * @param userName 用户名
	 * @param customerId 客户id
	 * @param stageNumber 分期数
	 * @param remainingPeriod 剩余分期数
	 * @param periods 还分期数
	 * @return
	 */
	boolean manualReceivePayment(String userName, Integer customerId, Integer stageNumber, Integer remainingPeriod,
			Integer periods);

	/**
	 * 自动划款
	 */
	void automaticDeduction();
}
