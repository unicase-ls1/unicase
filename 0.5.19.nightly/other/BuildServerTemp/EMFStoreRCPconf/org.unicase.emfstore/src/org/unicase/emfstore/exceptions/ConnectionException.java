/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.exceptions;

/**
 * Represents a connection problem.
 * 
 * @author koegel
 */
// MK: move to workspace
public class ConnectionException extends EmfStoreException {

	private static final long serialVersionUID = -2839606769454873809L;

	/**
	 * Default constructor.
	 * 
	 * @param message the message
	 * @param cause underlying exception
	 */
	public ConnectionException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Default constructor.
	 * 
	 * @param message the message
	 */
	public ConnectionException(String message) {
		super(message);
	}

}
