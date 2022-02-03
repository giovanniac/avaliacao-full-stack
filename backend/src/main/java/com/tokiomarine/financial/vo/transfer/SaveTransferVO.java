package com.tokiomarine.financial.vo.transfer;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Objects;

public class SaveTransferVO {

	private String fromAccount;

	private String toAccount;

	private BigDecimal value;
	
	private Calendar schedulingDate;

	private String operationType;

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Calendar getSchedulingDate() {
		return schedulingDate;
	}

	public void setSchedulingDate(Calendar schedulingDate) {
		this.schedulingDate = schedulingDate;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fromAccount, operationType, schedulingDate, toAccount, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaveTransferVO other = (SaveTransferVO) obj;
		return Objects.equals(fromAccount, other.fromAccount) && Objects.equals(operationType, other.operationType)
				&& Objects.equals(schedulingDate, other.schedulingDate) && Objects.equals(toAccount, other.toAccount)
				&& Objects.equals(value, other.value);
	}

	 
}
