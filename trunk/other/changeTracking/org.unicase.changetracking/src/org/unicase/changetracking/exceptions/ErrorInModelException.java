/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.exceptions;

/**
 * This exception is thrown if an error in the unicase
 * model is found (like a stream without a corresponding
 * repository stream or a release without a stream).
 * 
 * @author gex
 *
 */
public class ErrorInModelException extends Exception{
	
	/**
	 * .
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 * 
	 * @param message problem message
	 */
	public ErrorInModelException(String message) {
		super(message);
	}

}
