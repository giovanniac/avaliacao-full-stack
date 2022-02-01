package com.tokiomarine.financial.service.transfer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokiomarine.financial.model.Transfer;
import com.tokiomarine.financial.repository.transfer.TransferRepository;
import com.tokiomarine.financial.service.taxes.TaxRuleHandler;
import com.tokiomarine.financial.service.transfer.TransferService;

@Service
public class TransferServiceImpl implements TransferService {
	
	@Autowired 
	List<TaxRuleHandler> taxRules;

	@Autowired 
	TransferRepository repository;
	
	@Override
	public void save(Transfer transfer) {
		// Mover iteracao do design pattern para facade 
		for (TaxRuleHandler taxRule : taxRules) {
			if (taxRule.canHandle(transfer.getOperationType())) {
				transfer.setTaxes(taxRule.calculateTax(transfer.getValue(), transfer.getSchedulingDate()));
			}			
		}
		repository.save(transfer);
	}
	
	@Override
	public List<Transfer> getAll() {
		return repository.findAll();
	}

}
