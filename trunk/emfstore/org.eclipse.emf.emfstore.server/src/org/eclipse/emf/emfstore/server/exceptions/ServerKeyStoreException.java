/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.exceptions;

/**
 * This exception is thrown whenever there occurs a problem while performing
 * decryption.
 * 
 * @author emueller
 */
@SuppressWarnings("serial")
public class ServerKeyStoreException extends AccessControlException {

	/**
	 * Constructor for wrapping an already existing exception.
	 * 
	 * @param exception
	 *            the exception that should get wrapped
	 */
	public ServerKeyStoreException(Exception exception) {
		super("A server keystore related problem occured.", exception);
	}

	/**
	 * Constructor with an additional error message.
	 * 
	 * @param message
	 *            an error message
	 */
	public ServerKeyStoreException(String message) {
		super(message);
	}

}
