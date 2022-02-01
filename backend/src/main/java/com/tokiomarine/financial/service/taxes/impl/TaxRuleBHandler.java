package com.tokiomarine.financial.service.taxes.impl;

import static com.tokiomarine.financial.utils.CalendarUtils.getCalendarPlusDays;

import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.stereotype.Component;

import com.tokiomarine.financial.enums.OperationType;
import com.tokiomarine.financial.service.taxes.TaxRuleHandler;

@Component
public class TaxRuleBHandler implements TaxRuleHandler {

	@Override
	public boolean canHandle(OperationType operationType) {
		return operationType.equals(OperationType.B);
	}

	@Override
	public BigDecimal calculateTax(BigDecimal value, Calendar transferDate, Calendar currentDate) {
		Calendar tenDaysFromToday = getCalendarPlusDays(10, currentDate);
		if (transferDate.before(tenDaysFromToday)) {
			return BigDecimal.valueOf(12);
		}
		return BigDecimal.ZERO;
	}
	

}
