package com.feedback.exception;


public class CustomerDetailsNotValidException extends RuntimeException {
	
	private String msg;

	public CustomerDetailsNotValidException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
}
