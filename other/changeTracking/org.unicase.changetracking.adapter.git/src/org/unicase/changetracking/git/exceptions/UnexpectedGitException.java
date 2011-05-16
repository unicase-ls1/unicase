/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.exceptions;

import org.unicase.changetracking.exceptions.UnexpectedChangeTrackingException;


/**
 * This exception may be thrown by all parts of the git plugin.
 * It signalizes that something has gone wrong which shouldn't under normal
 * circumstances. Because it is not usual that this will ever happen,
 * this exception is a runtime exception.
 * @author jfinis
 *
 */
public class UnexpectedGitException extends UnexpectedChangeTrackingException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnexpectedGitException() {
		super();
	}

	public UnexpectedGitException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UnexpectedGitException(String arg0) {
		super(arg0);
	}

	public UnexpectedGitException(Throwable arg0) {
		super(arg0);
	}

	
	
}
