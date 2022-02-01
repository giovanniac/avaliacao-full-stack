package com.tokiomarine.financial.service.taxes.impl;

import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.stereotype.Component;

import com.tokiomarine.financial.enums.OperationType;
import com.tokiomarine.financial.service.taxes.TaxRuleHandler;

@Component
public class TaxRuleAHandler implements TaxRuleHandler {

	@Override
	public boolean canHandle(OperationType operationType) {
		return operationType.equals(OperationType.A);
	}

	@Override
	public BigDecimal calculateTax(BigDecimal value, Calendar transferDate) {
		if (transferDate.equals(Calendar.getInstance())) {
			return BigDecimal.valueOf(3).add(value.multiply(BigDecimal.valueOf(0.03)));
		}
		return BigDecimal.ZERO;
	}

}
