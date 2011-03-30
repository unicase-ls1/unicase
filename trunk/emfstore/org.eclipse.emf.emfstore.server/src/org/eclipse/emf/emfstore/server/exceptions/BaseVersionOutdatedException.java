/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.exceptions;

/**
 * Represents an exception because the base version of a project space is not up to date.
 * 
 * @author koegel
 */
// MK: move to workspace
@SuppressWarnings("serial")
public class BaseVersionOutdatedException extends EmfStoreException {

	private static final String MESSAGE = "BaseVersion outdated, please update before commit.";

	/**
	 * Default constructor.
	 */
	public BaseVersionOutdatedException() {
		super(MESSAGE);
	}

}
