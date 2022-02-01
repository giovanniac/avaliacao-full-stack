package com.tokiomarine.financial.enums;

public enum OperationType {

	A("A"), B("B"), C("C"), D("D");

	private String code;

	OperationType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
