package com.tokiomarine.financial.facade;

import static com.tokiomarine.financial.utils.CalendarUtils.getCalendarOnlyDate;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tokiomarine.financial.enums.OperationType;
import com.tokiomarine.financial.exception.InvalidInputException;
import com.tokiomarine.financial.handler.tax.OperationTaxHandler;
import com.tokiomarine.financial.model.Transfer;

@Component
public class OperationTaxFacade {

	@Autowired 
	List<OperationTaxHandler> taxRules;
	
	public BigDecimal calculateOperationTax(Transfer transfer) throws InvalidInputException {	
		BigDecimal value = transfer.getValue();
		
		Calendar transferDate = getCalendarOnlyDate(transfer.getTransferDate());
		Calendar currentDate = getCalendarOnlyDate(transfer.getScheduleDate());
		currentDate.setTimeZone(transferDate.getTimeZone());
		
		OperationType operationType = transfer.getOperationType();
		
		for (OperationTaxHandler taxRule : taxRules) {
			if (taxRule.canHandle(operationType)) {
				return taxRule.calculateTax(value, transferDate, currentDate);
			}			
		}
		
		throw new InvalidInputException("Cannot handle operation type");	
	}
}
