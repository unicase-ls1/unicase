/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.exceptions;

/**
 * This general exception class depicts any exception which may happen when a
 * VCSAdapter's method is called.
 * 
 * @author jfinis
 * 
 */
public class VCSException extends Exception {

	/**
	 * .
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Standard exception constructor.
	 */
	public VCSException() {
		super();
	}

	/**
	 * Standard exception constructor.
	 * 
	 * @param arg0 message
	 * @param arg1 cause
	 */
	public VCSException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Standard exception constructor.
	 * 
	 * @param arg0 message
	 */
	public VCSException(String arg0) {
		super(arg0);
	}

	/**
	 * Standard exception constructor.
	 * 
	 * @param arg0 cause
	 */
	public VCSException(Throwable arg0) {
		super(arg0);
	}

}
