package me.king.admin.service;

import me.king.admin.domain.CustomerExamineComments;

public interface ExamineCustomerService {
	boolean approve(CustomerExamineComments comments);
}
