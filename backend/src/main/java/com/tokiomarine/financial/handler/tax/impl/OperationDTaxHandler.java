package com.tokiomarine.financial.handler.tax.impl;

import static com.tokiomarine.financial.enums.OperationType.D;
import static com.tokiomarine.financial.utils.CalendarUtils.getCalendarPlusDays;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tokiomarine.financial.enums.OperationType;
import com.tokiomarine.financial.handler.tax.OperationTaxHandler;

@Component
public class OperationDTaxHandler implements OperationTaxHandler {

	@Autowired
	List<OperationTaxHandler> taxRule;
	
	@Override
	public boolean canHandle(OperationType operationType) {
		return operationType.equals(D);
	}

	@Override
	public BigDecimal calculateTax(BigDecimal value, Calendar transferDate, Calendar currentDate) {
		BigDecimal oneThousand = BigDecimal.valueOf(1000);
		BigDecimal twoThousand = BigDecimal.valueOf(1000);
		
		if (value.compareTo(oneThousand) <= 0)
			return upToOneThousand(value, transferDate, currentDate);
		
		if (value.compareTo(oneThousand) > 0 && value.compareTo(twoThousand) <= 0)
			return betweenOneAndTwoThousand(value, transferDate, currentDate);
		
		return aboveTwoThousand(value, transferDate, currentDate);
	}
	
	private BigDecimal upToOneThousand(BigDecimal value, Calendar transferDate, Calendar currentDate) {
		if (transferDate.equals(currentDate)) {
			return BigDecimal.valueOf(3).add(value.multiply(BigDecimal.valueOf(0.03)));
		}
		return BigDecimal.ZERO;
	}
	
	private BigDecimal betweenOneAndTwoThousand(BigDecimal value, Calendar transferDate, Calendar currentDate) {
		Calendar tenDaysFromToday = getCalendarPlusDays(10, currentDate);
		if (transferDate.before(tenDaysFromToday)) {
			return BigDecimal.valueOf(12);
		}
		return BigDecimal.ZERO;
	}
	
	private BigDecimal aboveTwoThousand(BigDecimal value, Calendar transferDate, Calendar currentDate) {
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
