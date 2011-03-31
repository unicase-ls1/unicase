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

/**
 * Represents an exception where a composite operation handle is not valid any more. The operation is already completed
 * or was aborted.
 * 
 * @author koegel
 */
@SuppressWarnings("serial")
public class InvalidHandleException extends Exception {

	/**
	 * Default constructor.
	 */
	public InvalidHandleException() {
		super("The composite operation was already aborted or completed!");
	}

}
