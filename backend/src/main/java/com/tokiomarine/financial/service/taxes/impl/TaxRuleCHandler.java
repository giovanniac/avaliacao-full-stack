package com.tokiomarine.financial.service.taxes.impl;

import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.stereotype.Component;

import com.tokiomarine.financial.enums.OperationType;
import com.tokiomarine.financial.service.taxes.TaxRuleHandler;
import com.tokiomarine.financial.utils.CalendarUtils;

@Component
public class TaxRuleCHandler implements TaxRuleHandler {

	@Override
	public boolean canHandle(OperationType operationType) {
		return operationType.equals(OperationType.C);
	}

	@Override
	public BigDecimal calculateTax(BigDecimal value, Calendar transferDate) {
		Calendar tenDaysFromToday = CalendarUtils.getCalendarPlusDays(10);
		Calendar twentyDaysFromToday = CalendarUtils.getCalendarPlusDays(20);
		Calendar thirtyDaysFromToday = CalendarUtils.getCalendarPlusDays(30);
		Calendar fortyDaysFromToday = CalendarUtils.getCalendarPlusDays(40);
		
		if (transferDate.after(tenDaysFromToday) && transferDate.before(twentyDaysFromToday))
			return value.multiply(BigDecimal.valueOf(1.082));
		if (transferDate.after(twentyDaysFromToday) && transferDate.before(thirtyDaysFromToday))
			return value.multiply(BigDecimal.valueOf(1.069));
		if (transferDate.after(thirtyDaysFromToday) && transferDate.before(fortyDaysFromToday))
			return value.multiply(BigDecimal.valueOf(1.047));	
		
		return value.multiply(BigDecimal.valueOf(1.017));
	}

}
