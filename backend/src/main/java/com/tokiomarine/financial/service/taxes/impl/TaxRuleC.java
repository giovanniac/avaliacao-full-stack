package com.tokiomarine.financial.service.taxes.impl;

import com.tokiomarine.financial.enums.OperationType;
import com.tokiomarine.financial.service.taxes.TaxRule;

public class TaxRuleC implements TaxRule {

	@Override
	public boolean canHandle(OperationType operationType) {
		return operationType.equals(OperationType.C);
	}

	@Override
	public Long calculateTax(Long value) {
		// TODO Auto-generated method stub
		return null;
	}

}
