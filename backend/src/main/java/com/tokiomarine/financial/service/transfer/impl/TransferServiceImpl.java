package com.tokiomarine.financial.service.transfer.impl;

import static java.math.BigDecimal.ZERO;

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
		
		validateTransfer(transfer, operationTypeEnum);
		
		transfer.setOperationType(operationTypeEnum);
		transfer.setTaxes(operationTaxFacade.calculateOperationTax(transfer));
		repository.save(transfer);
	}
	
	@Override
	public List<Transfer> getAll() {
		return repository.findAll();
	}
	
	private void validateTransfer(Transfer transfer, OperationType operationTypeEnum) throws InvalidInputException {
		if (operationTypeEnum == null)
			throw new InvalidInputException("Invalid operation type");
		
		if (transfer.getFromAccount() == null)
			throw new InvalidInputException("Invalid origin account");
		
		if (transfer.getToAccount() == null)
			throw new InvalidInputException("Invalid destiny account");
		
		if (transfer.getTransferDate() == null)
			throw new InvalidInputException("Invalid transfer date");
		
		if (transfer.getValue() == null || transfer.getValue() == ZERO)
			throw new InvalidInputException("Invalid transfer value");
	}

}
