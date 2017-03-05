package me.king.admin.service;

public interface ReleasePaymentsService {
	/**
	 * 放款
	 * @param customerId
	 * @param imageId
	 * @param releasePaymentsNumber
	 * @param releasePaymentsUser
	 * @return
	 */
	boolean loan(Integer customerId, String imageId, String releasePaymentsNumber, String releasePaymentsUser);
}
