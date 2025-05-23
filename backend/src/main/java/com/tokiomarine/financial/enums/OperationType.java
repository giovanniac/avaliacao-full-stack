package com.tokiomarine.financial.enums;

import java.io.Serializable;

public enum OperationType implements Serializable {

	A("A"), B("B"), C("C"), D("D");

	private String code;

	OperationType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static OperationType forName(String name) {
		for (OperationType value : OperationType.values()) {
			if (value.name().equals(name)) {
				return value;
			}
		}
		return null;
	}
}
