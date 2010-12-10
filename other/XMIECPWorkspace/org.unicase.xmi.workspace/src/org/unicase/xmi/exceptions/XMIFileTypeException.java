package org.unicase.xmi.exceptions;

public class XMIFileTypeException extends XMIException {

	/**
	 * Generated ID
	 */
	private static final long serialVersionUID = -2992360783606499261L;
	
	public XMIFileTypeException(String message, Exception e) {
		this.message = message;
		this.exception = e;
		
		log();
	}
	
	public XMIFileTypeException(String message) {
		this.message = message;
		this.exception = new Exception(message);
		
		log();
	}

	
}
