package me.king.admin.util;

import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {
	public static Date getNextMonthDate(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 1);
		return cal.getTime();
	}
	public static Date getUpMonthDate(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -1);
		return cal.getTime();
	}
}
