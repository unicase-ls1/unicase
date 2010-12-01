package org.unicase.xmi.exceptions;

public class XMIFileTypeException extends Throwable {

	/**
	 * Generated ID
	 */
	private static final long serialVersionUID = -2992360783606499261L;

	private String message;
	private Exception exception;
	
	public XMIFileTypeException(String message, Exception e) {
		this.message = message;
		this.exception = e;
	}
	
	public XMIFileTypeException(String message) {
		this.message = message;
		this.exception = new Exception(message);
	}
}
