/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.exceptions;

/**
 * This exception is thrown if a user has manually cancelled an action.
 * 
 * @author jfinis
 * 
 */
public class CancelledByUserException extends Exception {

	/**
	 * .
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CancelledByUserException() {
		super("User has canceled the process");
	}

	/**
	 * Skip stack trace assembling. Since this exception is not used for
	 * debugging, stack trace assembling would just lower performance.
	 * @return this
	 */
	public synchronized Throwable fillInStackTrace() {
		return this;
	}
}
