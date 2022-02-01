package com.tokiomarine.financial.service.transfer;

import java.util.List;

import com.tokiomarine.financial.model.Transfer;

public interface TransferService {

	void save(Transfer transfer);
	
	List<Transfer> getAll();
}
