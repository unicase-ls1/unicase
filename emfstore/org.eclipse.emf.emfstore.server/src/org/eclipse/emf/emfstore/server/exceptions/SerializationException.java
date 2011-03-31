/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.exceptions;

/**
 * Is thrown in case of serialization problems.
 * 
 * @author wesendon
 */
public class SerializationException extends EmfStoreException {

	private static final String DEFAULTMESSAGE = "(De-)Serialization failed. The reason for this might be that the server does not support the used model or the data is corrupted.";

	/**
	 * Default constructor.
	 * 
	 * @param message message
	 * @param cause exception
	 */
	public SerializationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Default constructor. Default message is set.
	 * 
	 * @param cause exception
	 */
	public SerializationException(Throwable cause) {
		super(DEFAULTMESSAGE, cause);
	}

	/**
	 * Default constructor.
	 * 
	 * @param message error message
	 */
	public SerializationException(String message) {
		super(message);
	}

	/**
	 * Exception with default message.
	 */
	public SerializationException() {
		super(DEFAULTMESSAGE);
	}

	private static final long serialVersionUID = 7320159931158908702L;

}
