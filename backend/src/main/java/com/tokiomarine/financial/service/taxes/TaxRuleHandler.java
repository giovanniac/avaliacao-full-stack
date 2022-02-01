package com.tokiomarine.financial.service.taxes;

import com.tokiomarine.financial.enums.OperationType;

public interface TaxRuleHandler {

	boolean canHandle(OperationType operationType);
	
	Long calculateTax(Long value);
}
