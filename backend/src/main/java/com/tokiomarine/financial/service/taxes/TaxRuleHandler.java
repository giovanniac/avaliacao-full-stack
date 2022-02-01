package com.tokiomarine.financial.service.taxes;

import java.math.BigDecimal;
import java.util.Calendar;

import com.tokiomarine.financial.enums.OperationType;

public interface TaxRuleHandler {

	boolean canHandle(OperationType operationType);
	
	BigDecimal calculateTax(BigDecimal value, Calendar transferDate, Calendar currentDate);
}
