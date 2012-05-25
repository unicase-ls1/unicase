/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.exceptions;

/**
 * Exception stating that the communication with the remote repository could not
 * be conducted.
 * 
 * @author jfinis
 * 
 */
public class RemoteRepositoryNotReachableException extends Exception {

	/**
	 * .
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 * 
	 * @param message problem message
	 */
	public RemoteRepositoryNotReachableException(String message) {
		super(message);
	}
}
