package com.saas.notfoundexception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class CustomerNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(long id) {
		super("  Can not find Customer " + id);
	}
}
