package com.tokiomarine.financial.service.transfer.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokiomarine.financial.handler.tax.OperationTaxHandler;
import com.tokiomarine.financial.model.Transfer;
import com.tokiomarine.financial.repository.transfer.TransferRepository;
import com.tokiomarine.financial.service.transfer.TransferService;

@Service
public class TransferServiceImpl implements TransferService {
	
	@Autowired 
	List<OperationTaxHandler> taxRules;

	@Autowired 
	TransferRepository repository;
	
	@Override
	public void save(Transfer transfer) {
		// Mover iteracao do design pattern para facade 
		for (OperationTaxHandler taxRule : taxRules) {
			if (taxRule.canHandle(transfer.getOperationType())) {
				BigDecimal value = transfer.getValue();
				Calendar scheduledDate = transfer.getSchedulingDate();
				Calendar transferDate = transfer.getTransferDate();
				transfer.setTaxes(taxRule.calculateTax(value, scheduledDate, transferDate));
			}			
		}
		repository.save(transfer);
	}
	
	@Override
	public List<Transfer> getAll() {
		return repository.findAll();
	}

}
