/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.exceptions;

/**
 * This exception states that an unexpected error has happened during command
 * execution. Since this usually should not happen, this exception is a subclass
 * of runtime exception and does not have to be declared.
 * 
 * It is thrown for example when an underlying system (like the version control
 * system) raises an unexpected error.
 * 
 * @author jfinis
 * 
 */
public class UnexpectedChangeTrackingException extends RuntimeException {

	/**
	 * .
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Standard exception constructor.
	 */
	public UnexpectedChangeTrackingException() {
		super();
	}

	/**
	 * Standard exception constructor.
	 * 
	 * @param arg0 message
	 * @param arg1 cause
	 */
	public UnexpectedChangeTrackingException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Standard exception constructor.
	 * 
	 * @param arg0 message
	 */
	public UnexpectedChangeTrackingException(String arg0) {
		super(arg0);
	}

	/**
	 * Standard exception constructor.
	 * 
	 * @param arg0 cause
	 */
	public UnexpectedChangeTrackingException(Throwable arg0) {
		super(arg0);
	}

}
