package org.unicase.xmi.exceptions;

/**
 * All exceptions related with the files or their types are thrown as this exception.
 * @author matti, markus
 */
public class XMIFileTypeException extends XMIException {

	/**
	 * Generated ID
	 */
	private static final long serialVersionUID = -2992360783606499261L;
	
	/**
	 * Create an exception with a custom message an the exception stack.
	 * @param message Custom message to inform the user.
	 * @param e Exception thrown
	 */
	public XMIFileTypeException(String message, Exception e) {
		this.message = message;
		this.exception = e;
		
		log();
	}
	
	/**
	 * Create an exception only with a message.
	 * @param message Custom message to inform the user.
	 */
	public XMIFileTypeException(String message) {
		this.message = message;
		this.exception = new Exception(message);
		
		log();
	}

	
}
