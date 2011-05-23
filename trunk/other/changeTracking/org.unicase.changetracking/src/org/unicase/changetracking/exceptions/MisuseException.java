/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.exceptions;

/**
 * A misuse exception is an exception which may occur during command execution
 * and is caused by a misuse of the program. Thus, it is no real exception to be
 * logged but rather only be displayed to the user in a message box.
 * 
 * @author jfinis
 * 
 */
public class MisuseException extends RuntimeException {

	/**
	 * .
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Standard exception constructor.
	 */
	public MisuseException() {
		super();
	}

	/**
	 * Standard exception constructor.
	 * 
	 * @param arg0 message
	 * @param arg1 cause
	 */
	public MisuseException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Standard exception constructor.
	 * 
	 * @param arg0 message
	 */
	public MisuseException(String arg0) {
		super(arg0);
	}

	/**
	 * Standard exception constructor.
	 * 
	 * @param arg0 cause
	 */
	public MisuseException(Throwable arg0) {
		super(arg0);
	}

}
