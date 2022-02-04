package com.tokiomarine.financial.handler.tax.impl;

import static com.tokiomarine.financial.enums.OperationType.B;
import static com.tokiomarine.financial.utils.CalendarUtils.getCalendarPlusDays;
import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.stereotype.Component;

import com.tokiomarine.financial.enums.OperationType;
import com.tokiomarine.financial.handler.tax.OperationTaxHandler;

@Component
public class OperationBTaxHandler implements OperationTaxHandler {

	@Override
	public boolean canHandle(OperationType operationType) {
		return operationType.equals(B);
	}

	@Override
	public BigDecimal calculateTax(BigDecimal value, Calendar transferDate, Calendar currentDate) {
		Calendar tenDaysFromToday = getCalendarPlusDays(11, currentDate);
		
		if (transferDate.before(tenDaysFromToday))
			return BigDecimal.valueOf(12);

		return ZERO;
	}
	

}
