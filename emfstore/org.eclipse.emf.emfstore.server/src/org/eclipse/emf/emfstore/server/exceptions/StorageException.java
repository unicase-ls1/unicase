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
 * Represents a problem with data storage. This is a condition the server or one of its components can not recover from
 * and where a server shutdown is inevitable.
 * 
 * @author Otto Wesendonk
 */
@SuppressWarnings("serial")
public class StorageException extends EmfStoreException {

	/**
	 * String constant for loading problem message.
	 */
	public static final String NOLOAD = "Couldn't load data from database.";

	/**
	 * String constant for saving problem message.
	 */
	public static final String NOSAVE = "Couldn't save data in database.";

	/**
	 * Default constructor.
	 * 
	 * @param message the message
	 * @param cause underlying exception
	 */
	public StorageException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Default constructor.
	 * 
	 * @param message the message
	 */
	public StorageException(String message) {
		super(message);
	}
}
