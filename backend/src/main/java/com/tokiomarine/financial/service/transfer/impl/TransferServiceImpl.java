package com.tokiomarine.financial.service.transfer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void saveTransfer() {
		

	}

}
