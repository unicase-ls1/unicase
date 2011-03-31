/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.model.exceptions;

import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;

/**
 * Indicates that an exception occured in the workspace.
 * 
 * @author koegel
 */
@SuppressWarnings("serial")
public class WorkspaceException extends EmfStoreException {

	/**
	 * Constructor.
	 * 
	 * @param message the message
	 * @param cause the cause
	 */
	public WorkspaceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param message the message
	 */
	public WorkspaceException(String message) {
		super(message);
	}

}
