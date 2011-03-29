/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.migration;

/**
 * Represents a failure in migrating models to more recent versions.
 * 
 * @author mkoegel
 *
 */
@SuppressWarnings("serial")
public class EMFStoreMigrationException extends Exception {

	/**
	 * Default constructor.
	 * @param message the message.
	 * @param cause the cause
	 */
	public EMFStoreMigrationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Default constructor.
	 * @param message the message.
	 */
	public EMFStoreMigrationException(String message) {
		super(message);
	}
	
}
