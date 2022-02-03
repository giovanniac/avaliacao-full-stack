package com.tokiomarine.financial.mapper;

import org.springframework.stereotype.Component;

import com.tokiomarine.financial.model.Transfer;
import com.tokiomarine.financial.vo.transfer.SaveTransferVO;

@Component
public class TransferMapper {

	public Transfer fromSendTransferVO(SaveTransferVO sendTransferVO) {
		Transfer transfer = new Transfer();
		transfer.setFromAccount(sendTransferVO.getFromAccount());
		transfer.setSchedulingDate(sendTransferVO.getSchedulingDate());
		transfer.setToAccount(sendTransferVO.getToAccount());
		transfer.setValue(sendTransferVO.getValue());
		return transfer;
	}
}
