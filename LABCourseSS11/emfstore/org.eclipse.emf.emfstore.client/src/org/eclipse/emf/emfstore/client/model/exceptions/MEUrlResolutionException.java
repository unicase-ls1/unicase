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
package org.eclipse.emf.emfstore.client.model.exceptions;

/**
 * Represents an exception in model element url resolution. Probably the model element does not exist.
 * 
 * @author koegel
 */
@SuppressWarnings("serial")
public class MEUrlResolutionException extends Exception {

	private static final String MESSAGE = "URL cannot be resolved: Probably the model element does not exist.";

	/**
	 * Constructor.
	 */
	public MEUrlResolutionException() {
		super(MESSAGE);
	}
}
