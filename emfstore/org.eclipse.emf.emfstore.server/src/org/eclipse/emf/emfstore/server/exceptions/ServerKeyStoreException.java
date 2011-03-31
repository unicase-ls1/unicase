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
 * This exception is throw if there is a problem with the decryption.
 * 
 * @author hamidmomeny
 */
@SuppressWarnings("serial")
public class ServerKeyStoreException extends AccessControlException {

	/**
	 * Default constructor.
	 * 
	 * @param e exception
	 */
	public ServerKeyStoreException(Exception e) {
		super("A server keystore related problem occured.", e);
	}

	/**
	 * Constructor with message.
	 * 
	 * @param message message.
	 */
	public ServerKeyStoreException(String message) {
		super(message);
	}

}
