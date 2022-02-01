package com.tokiomarine.financial.utils;

import java.util.Calendar;

public class CalendarUtils {

	public CalendarUtils() { }
	
	public static Calendar getCalendarPlusDays(Integer daysToSum, Calendar currentDate) {
		Calendar calendar = currentDate;
		calendar.add(Calendar.DAY_OF_MONTH, daysToSum);
		return calendar;
	}
}
