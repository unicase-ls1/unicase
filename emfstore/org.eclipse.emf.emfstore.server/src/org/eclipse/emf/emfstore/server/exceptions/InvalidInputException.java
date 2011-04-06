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
 * Is thrown when the input parameters of a method are null.
 * 
 * @author wesendonk
 */
@SuppressWarnings("serial")
public class InvalidInputException extends EmfStoreException {

	/**
	 * Default constructor.
	 */
	public InvalidInputException() {
		super("");
	}

	/**
	 * Default constructor.
	 * 
	 * @param message the exception's message
	 */
	public InvalidInputException(String message) {
		super(message);
	}

}
