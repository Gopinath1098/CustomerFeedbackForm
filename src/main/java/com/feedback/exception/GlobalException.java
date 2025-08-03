package com.feedback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
		@ExceptionHandler(value = CustomerDetailsNotValidException.class)
	    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	    public @ResponseBody ErrorResponse handleException(CustomerDetailsNotValidException ex) {
	        return new ErrorResponse(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE.value());
	    }

}
