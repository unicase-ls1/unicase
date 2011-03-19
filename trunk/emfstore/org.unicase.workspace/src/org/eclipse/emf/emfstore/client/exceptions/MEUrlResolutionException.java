/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.exceptions;

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
