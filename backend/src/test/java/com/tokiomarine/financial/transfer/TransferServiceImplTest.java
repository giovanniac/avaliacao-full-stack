package com.tokiomarine.financial.transfer;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	void shouldNotCalculateTaxes() {
		Assertions.assertThrows(InvalidInputException.class, () -> {
			Calendar schedulingDate = Calendar.getInstance();
			Calendar transferDate = schedulingDate;

			Transfer transfer = new Transfer();
			transfer.setValue(BigDecimal.valueOf(100));
			transfer.setSchedulingDate(schedulingDate);
			transfer.setTransferDate(transferDate);

			service.save(transfer, "NOT_EXISTENT");
		});
	}

//	@Test
//	void shouldCalculateOperationATax() throws Exception {
//		Calendar schedulingDate = Calendar.getInstance();
//		Calendar transferDate = schedulingDate;
//		BigDecimal value = BigDecimal.valueOf(100);
//		BigDecimal calculatedTaxes = BigDecimal.valueOf(3).add(value.multiply(BigDecimal.valueOf(0.03)));
//
//		Transfer transfer = new Transfer();
//		transfer.setValue(BigDecimal.valueOf(100));
//		transfer.setSchedulingDate(schedulingDate);
//		transfer.setTransferDate(transferDate);
//
//		service.save(transfer, "A");
//		assertEquals(calculatedTaxes, transfer.getTaxes());
//	}

}
