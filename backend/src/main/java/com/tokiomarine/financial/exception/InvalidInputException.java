package com.tokiomarine.financial.exception;

public class InvalidInputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String customMessage;
	
	public InvalidInputException(String customMessage) {
		super();
		this.setCustomMessage(customMessage);
	}

	public String getCustomMessage() {
		return customMessage;
	}

	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}
	
}
