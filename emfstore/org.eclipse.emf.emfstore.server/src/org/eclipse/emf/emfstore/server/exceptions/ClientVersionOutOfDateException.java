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
 * Is thrown if the client's version is not compatible to the server.
 * 
 * @author wesendonk
 */

@SuppressWarnings("serial")
public class ClientVersionOutOfDateException extends AccessControlException {

	private static final String MESSAGE = "The client's version is not compatible to the server and probably out of date.";

	/**
	 * Default constructor.
	 */
	public ClientVersionOutOfDateException() {
		super(MESSAGE);
	}

	/**
	 * Default constructor.
	 * 
	 * @param msg message
	 */
	public ClientVersionOutOfDateException(String msg) {
		super(msg);
	}

}
