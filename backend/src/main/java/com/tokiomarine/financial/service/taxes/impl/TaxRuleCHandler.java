package com.tokiomarine.financial.service.taxes.impl;

import org.springframework.stereotype.Component;

import com.tokiomarine.financial.enums.OperationType;
import com.tokiomarine.financial.service.taxes.TaxRuleHandler;

@Component
public class TaxRuleCHandler implements TaxRuleHandler {

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
