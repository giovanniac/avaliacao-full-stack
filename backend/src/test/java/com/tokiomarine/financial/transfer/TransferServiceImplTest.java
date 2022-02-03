package com.tokiomarine.financial.transfer;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tokiomarine.financial.exception.InvalidInputException;
import com.tokiomarine.financial.facade.OperationTaxFacade;
import com.tokiomarine.financial.model.Transfer;
import com.tokiomarine.financial.repository.transfer.TransferRepository;
import com.tokiomarine.financial.service.transfer.impl.TransferServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TransferServiceImplTest {

	@Mock
	private TransferRepository repository;
	
	@Mock
	private OperationTaxFacade facade;

	@InjectMocks
	private TransferServiceImpl service;

	@Test
	void shouldThrowsInvalidOperation() {
		Assertions.assertThrows(InvalidInputException.class, () -> {
			Calendar schedulingDate = Calendar.getInstance();
			Calendar transferDate = schedulingDate;

			Transfer transfer = new Transfer();
			transfer.setValue(BigDecimal.valueOf(100));
			transfer.setSchedulingDate(schedulingDate);
			transfer.setTransferDate(transferDate);
			transfer.setFromAccount("12312");
			transfer.setToAccount("12312");

			service.save(transfer, "NOT_EXISTENT");
		});
	}
	
	@Test
	void shouldThrowsInvalidValue() {
		Assertions.assertThrows(InvalidInputException.class, () -> {
			Calendar schedulingDate = Calendar.getInstance();
			Calendar transferDate = schedulingDate;

			Transfer transfer = new Transfer();
			transfer.setValue(BigDecimal.ZERO);
			transfer.setSchedulingDate(schedulingDate);
			transfer.setTransferDate(transferDate);
			transfer.setFromAccount("12312");
			transfer.setToAccount("12312");

			service.save(transfer, "A");
		});
	}
	
	@Test
	void shouldThrowsInvalidTransferDate() {
		Assertions.assertThrows(InvalidInputException.class, () -> {
			Calendar schedulingDate = Calendar.getInstance();

			Transfer transfer = new Transfer();
			transfer.setValue(BigDecimal.valueOf(100));
			transfer.setTransferDate(null);
			transfer.setSchedulingDate(schedulingDate);
			transfer.setFromAccount("12312");
			transfer.setToAccount("12312");

			service.save(transfer, "A");
		});
	}
	
	@Test
	void shouldThrowsInvalidToAccount() {
		Assertions.assertThrows(InvalidInputException.class, () -> {
			Calendar schedulingDate = Calendar.getInstance();
			Calendar transferDate = schedulingDate;

			Transfer transfer = new Transfer();
			transfer.setValue(BigDecimal.valueOf(100));
			transfer.setSchedulingDate(schedulingDate);
			transfer.setTransferDate(transferDate);
			transfer.setFromAccount("12312");
			transfer.setToAccount(null);

			service.save(transfer, "A");
		});
	}
	
	@Test
	void shouldThrowsInvalidFromAccount() {
		Assertions.assertThrows(InvalidInputException.class, () -> {
			Calendar schedulingDate = Calendar.getInstance();
			Calendar transferDate = schedulingDate;

			Transfer transfer = new Transfer();
			transfer.setValue(BigDecimal.valueOf(100));
			transfer.setSchedulingDate(schedulingDate);
			transfer.setTransferDate(transferDate);
			transfer.setFromAccount(null);
			transfer.setToAccount("12312");

			service.save(transfer, "A");
		});
	}

}
