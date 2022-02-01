package com.tokiomarine.financial.model;

import java.util.Calendar;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tokiomarine.financial.enums.OperationType;

@Entity
@Table(name = "TRANSFER")
public class Transfer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "FROM_ACCOUNT")
	private String fromAccount;

	@Column(name = "TO_ACCOUNT")
	private String toAccount;
	
	@Column(name = "TAXES")
	private Long taxes;
	
	@Column(name = "VALUE")
	private Long value;
	
	@Column(name = "TRANSFER_DATE")
	private Calendar transferDate;
	
	@Column(name = "SCHEDULING_DATE")
	private Calendar schedulingDate;
	
	@Column(name = "OPERATION_TYPE")
	private OperationType operationType;

	public Transfer(long id, String fromAccount, String toAccount, Long taxes, Long value, Calendar transferDate,
			Calendar schedulingDate) {
		super();
		this.id = id;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.taxes = taxes;
		this.value = value;
		this.transferDate = transferDate;
		this.schedulingDate = schedulingDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Long getTaxes() {
		return taxes;
	}

	public void setTaxes(Long taxes) {
		this.taxes = taxes;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public Calendar getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Calendar transferDate) {
		this.transferDate = transferDate;
	}

	public Calendar getSchedulingDate() {
		return schedulingDate;
	}

	public void setSchedulingDate(Calendar schedulingDate) {
		this.schedulingDate = schedulingDate;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(fromAccount, id, schedulingDate, taxes, toAccount, transferDate, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transfer other = (Transfer) obj;
		return Objects.equals(fromAccount, other.fromAccount) && id == other.id
				&& Objects.equals(schedulingDate, other.schedulingDate) && Objects.equals(taxes, other.taxes)
				&& Objects.equals(toAccount, other.toAccount) && Objects.equals(transferDate, other.transferDate)
				&& Objects.equals(value, other.value);
	}
	
}
