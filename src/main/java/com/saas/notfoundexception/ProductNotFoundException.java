package com.saas.notfoundexception;

public class ProductNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(long id) {
		super("  Can not find Product " + id);
	}
}
