package com.tokiomarine.financial.handler.tax.impl;

import static com.tokiomarine.financial.enums.OperationType.C;
import static com.tokiomarine.financial.utils.CalendarUtils.getCalendarPlusDays;

import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.stereotype.Component;

import com.tokiomarine.financial.enums.OperationType;
import com.tokiomarine.financial.handler.tax.OperationTaxHandler;

@Component
public class OperationCTaxHandler implements OperationTaxHandler {

	@Override
	public boolean canHandle(OperationType operationType) {
		return operationType.equals(C);
	}

	@Override
	public BigDecimal calculateTax(BigDecimal value, Calendar transferDate, Calendar currentDate) {
		Calendar tenDaysFromToday = getCalendarPlusDays(10, currentDate);
		Calendar twentyDaysFromToday = getCalendarPlusDays(20, currentDate);
		Calendar thirtyDaysFromToday = getCalendarPlusDays(30, currentDate);
		Calendar fortyDaysFromToday = getCalendarPlusDays(40, currentDate);
		
		if (transferDate.after(tenDaysFromToday) && transferDate.before(twentyDaysFromToday))
			return value.multiply(BigDecimal.valueOf(0.082));
		if (transferDate.after(twentyDaysFromToday) && transferDate.before(thirtyDaysFromToday))
			return value.multiply(BigDecimal.valueOf(0.069));
		if (transferDate.after(thirtyDaysFromToday) && transferDate.before(fortyDaysFromToday))
			return value.multiply(BigDecimal.valueOf(0.047));	
		
		return value.multiply(BigDecimal.valueOf(0.017));
	}

}
