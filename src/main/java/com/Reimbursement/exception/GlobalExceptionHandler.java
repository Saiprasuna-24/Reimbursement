package com.Reimbursement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ReimbursementRequestNotFoundException.class)
	public ResponseEntity<String> reportNotFound(ReimbursementRequestNotFoundException ex) {
		ResponseEntity<String> res = new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
		return res;
	}
}
