package org.unicase.xmi.exceptions;

import org.unicase.ecp.model.Activator;

public abstract class XMIException extends Throwable {

	/**
	 * Generated ID for serialization
	 */
	private static final long serialVersionUID = 3140461347714378143L;

	/**
	 * Message to be displayed.
	 */
	protected String message;
	
	/**
	 * Exception that has been thrown
	 */
	protected Exception exception;
	
	/**
	 * Writes the events to the message-log.
	 */
	protected void log() {
		Activator.getDefault().logException(message, exception);
	}
}
