/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.ecp.xmiworkspace.exceptions;

import org.eclipse.emf.ecp.xmiworkspace.Activator;


/**
 * General Exception for the XMIECPWorkspace.
 * @author matti, markus
 *
 */
public abstract class XMIException extends Throwable {

	/**
	 * Generated ID for serialization.
	 */
	private static final long serialVersionUID = 3140461347714378143L;

	/**
	 * Message to be displayed.
	 */
	private String message;
	
	/**
	 * Exception that has been thrown.
	 */
	private Exception exception;
	
	/**
	 * Writes the events to the message-log.
	 */
	protected void log() {
		Activator.getDefault().logException(message, exception);
	}

	/**
	 * Gets the exception's message.
	 * @return human readable message.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Set's the exception's message.
	 * @param message Human readable message.
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the full exception.
	 * @return Full exception for the error.
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * Sets the exception.
	 * @param exception Full exception for the occured error.
	 */
	public void setException(Exception exception) {
		this.exception = exception;
	}
	
	
}
