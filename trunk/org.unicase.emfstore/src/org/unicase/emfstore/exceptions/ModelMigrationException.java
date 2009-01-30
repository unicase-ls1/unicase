/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.exceptions;

/**
 * Indicates an exception while migrating model instance due to model changes.
 * 
 * @author koegel
 */
@SuppressWarnings("serial")
public class ModelMigrationException extends Exception {

	private static final String DEFAULT_MESSAGE = "Model migration failed!";

	/**
	 * Default constructor.
	 * 
	 * @param cause the causing exception.
	 */
	public ModelMigrationException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

}
