package com.tokiomarine.financial.handler.tax;

import java.math.BigDecimal;
import java.util.Calendar;

import com.tokiomarine.financial.enums.OperationType;

public interface OperationTaxHandler {

	boolean canHandle(OperationType operationType);
	
	BigDecimal calculateTax(BigDecimal value, Calendar transferDate, Calendar currentDate);
}
