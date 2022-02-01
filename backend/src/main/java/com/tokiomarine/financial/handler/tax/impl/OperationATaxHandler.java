package com.tokiomarine.financial.handler.tax.impl;

import static com.tokiomarine.financial.enums.OperationType.A;
import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.stereotype.Component;

import com.tokiomarine.financial.enums.OperationType;
import com.tokiomarine.financial.handler.tax.OperationTaxHandler;

@Component
public class OperationATaxHandler implements OperationTaxHandler {

	@Override
	public boolean canHandle(OperationType operationType) {
		return operationType.equals(A);
	}

	@Override
	public BigDecimal calculateTax(BigDecimal value, Calendar transferDate, Calendar currentDate) {
		if (transferDate.equals(currentDate))
			return BigDecimal.valueOf(3).add(value.multiply(BigDecimal.valueOf(0.03)));
		
		return ZERO;
	}

}
