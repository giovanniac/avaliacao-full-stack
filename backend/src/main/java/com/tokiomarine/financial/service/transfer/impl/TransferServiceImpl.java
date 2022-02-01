package com.tokiomarine.financial.service.transfer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokiomarine.financial.enums.OperationType;
import com.tokiomarine.financial.exception.InvalidInputException;
import com.tokiomarine.financial.facade.OperationTaxFacade;
import com.tokiomarine.financial.model.Transfer;
import com.tokiomarine.financial.repository.transfer.TransferRepository;
import com.tokiomarine.financial.service.transfer.TransferService;

@Service
public class TransferServiceImpl implements TransferService {
	
	@Autowired 
	OperationTaxFacade operationTaxFacade;

	@Autowired 
	TransferRepository repository;
	
	@Override
	public void save(Transfer transfer, String operationType) throws InvalidInputException {
		OperationType operationTypeEnum = OperationType.forName(operationType);
		
		if (operationTypeEnum == null)
			throw new InvalidInputException("Invalid operation type");
		
		transfer.setOperationType(operationTypeEnum);
		transfer.setTaxes(operationTaxFacade.calculateOperationTax(transfer));
		repository.save(transfer);
	}
	
	@Override
	public List<Transfer> getAll() {
		return repository.findAll();
	}

}
