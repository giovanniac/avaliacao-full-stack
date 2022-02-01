package com.tokiomarine.financial.service.taxes.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tokiomarine.financial.enums.OperationType;
import com.tokiomarine.financial.service.taxes.TaxRuleHandler;

@Component
public class TaxRuleDHandler implements TaxRuleHandler {

	@Autowired
	List<TaxRuleHandler> taxRule;
	
	@Override
	public boolean canHandle(OperationType operationType) {
		return operationType.equals(OperationType.D);
	}

	@Override
	public BigDecimal calculateTax(BigDecimal value, Calendar transferDate) {
		return null;
	}

}
