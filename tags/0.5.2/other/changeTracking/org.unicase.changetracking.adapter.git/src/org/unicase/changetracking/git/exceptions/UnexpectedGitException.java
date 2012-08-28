/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.exceptions;

import org.unicase.changetracking.exceptions.UnexpectedChangeTrackingException;

/**
 * This exception may be thrown by all parts of the git plugin. It signalizes
 * that something has gone wrong which shouldn't under usual circumstances.
 * Because it is not usual that this will ever happen, this exception is a
 * runtime exception.
 * 
 * @author jfinis
 * 
 */
public class UnexpectedGitException extends UnexpectedChangeTrackingException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * .
	 */
	public UnexpectedGitException() {
		super();
	}

	/**
	 * .
	 * 
	 * @param arg0 exception message
	 * @param arg1 cause
	 */
	public UnexpectedGitException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * .
	 * 
	 * @param arg0 Exception message
	 */
	public UnexpectedGitException(String arg0) {
		super(arg0);
	}

	/**
	 * .
	 * 
	 * @param arg0 cause
	 */
	public UnexpectedGitException(Throwable arg0) {
		super(arg0);
	}

}
