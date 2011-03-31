/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.exceptions;

/**
 * An EmfStore Exception expresses that any exceptional condition in the EmfStore occurred that prevented the store from
 * processing the requested operation. There are subclasses of EmfStore that can be caught to get a more detailed
 * picture of what went wrong and to be able react more specific to different conditions.
 * 
 * @author Maximilian Koegel
 * @generated NOT
 */
@SuppressWarnings("serial")
public class EmfStoreException extends Exception {

	/**
	 * Constructor.
	 * 
	 * @param message the message
	 * @param cause the causing exception
	 * @generated NOT
	 */
	public EmfStoreException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param message the message
	 * @generated NOT
	 */
	public EmfStoreException(String message) {
		super(message);
	}

	/**
	 * Default constructor.
	 * 
	 * @param cause the causing exception
	 */
	public EmfStoreException(Throwable cause) {
		super(cause);
	}
}
