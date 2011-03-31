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
 * Represents a condition the server or one of its components can not recover from and where a server shutdown is
 * inevitable.
 * 
 * @author Maximilian Koegel
 * @generated NOT
 */
@SuppressWarnings("serial")
public class FatalEmfStoreException extends Exception {

	/**
	 * Default constructor.
	 * 
	 * @param message the message
	 * @param cause underlying exception
	 */
	public FatalEmfStoreException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Default constructor.
	 * 
	 * @param message the message
	 */
	public FatalEmfStoreException(String message) {
		super(message);
	}

	/**
	 * Default constructor.
	 * 
	 * @param cause the cause
	 */
	public FatalEmfStoreException(Throwable cause) {
		super(cause);
	}

	/**
	 * Default constructor.
	 */
	public FatalEmfStoreException() {
		this("Fatal exception");
	}

}
