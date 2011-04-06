/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.exceptions;

/**
 * Represents a access control violation. Access to a server resource may not be allowed for current user or user name
 * or password might be wrong.
 * 
 * @author koegel
 */
@SuppressWarnings("serial")
public class AccessControlException extends EmfStoreException {

	/**
	 * Constructor.
	 * 
	 * @param string message
	 */
	public AccessControlException(String string) {
		super(string);
	}

	/**
	 * Default Constructor.
	 */
	public AccessControlException() {
		super("Access denied!");
	}

	/**
	 * Constructor.
	 * 
	 * @param string message
	 * @param e cause
	 */
	public AccessControlException(String string, Exception e) {
		super(string, e);
	}

}
