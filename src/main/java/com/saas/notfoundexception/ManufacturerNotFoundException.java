package com.saas.notfoundexception;

public class ManufacturerNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ManufacturerNotFoundException(long id) {
		super("  Can not find Manufacturer " + id);
	}
}
