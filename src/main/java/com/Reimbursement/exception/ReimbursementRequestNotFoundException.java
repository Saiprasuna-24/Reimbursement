package com.Reimbursement.exception;

public class ReimbursementRequestNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ReimbursementRequestNotFoundException() {
		super();
	
	}

	public ReimbursementRequestNotFoundException(String message) {
		super(message);
		
	}
}
