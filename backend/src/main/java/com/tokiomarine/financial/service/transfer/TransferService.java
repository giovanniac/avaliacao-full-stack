package com.tokiomarine.financial.service.transfer;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.tokiomarine.financial.exception.InvalidInputException;
import com.tokiomarine.financial.model.Transfer;

public interface TransferService {

	void save(Transfer transfer, String operationType) throws InvalidInputException;
	
	HashMap<String, BigDecimal> cotate(Transfer transfer) throws InvalidInputException;
	
	List<Transfer> getAll();
}
