package com.tokiomarine.financial.utils;

import java.util.Calendar;

public class CalendarUtils {

	public CalendarUtils() { }
	
	public static Calendar getCalendarPlusDays(Integer daysToSum, Calendar currentDate) {
		Calendar calendar = (Calendar) currentDate.clone();
		calendar.add(Calendar.DAY_OF_MONTH, daysToSum);
		return calendar;
	}
	
	public static Calendar getCalendarOnlyDate(Calendar currentDate) {
		// Utilizado somente para facilitar os testes
		// quando o imposto incide somente quando a
		// data de agendamento e de transferencia sao iguais
		Calendar calendar = currentDate;
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}
}
