package me.king.admin.service;

import java.util.Map;

public interface ReportService {
	Map<String, Object> statistics(String endReleasePaymentsDate,String beginReleasePaymentsDate);
}
