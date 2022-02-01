package com.tokiomarine.financial.service.taxes.impl;

import com.tokiomarine.financial.enums.OperationType;
import com.tokiomarine.financial.service.taxes.TaxRule;

public class TaxRuleD implements TaxRule {

	@Override
	public boolean canHandle(OperationType operationType) {
		return operationType.equals(OperationType.D);
	}

	@Override
	public Long calculateTax(Long value) {
		// TODO Auto-generated method stub
		return null;
	}

}
