/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.exceptions;

/**
 * Is thrown in case of an invalid property.
 * 
 * @author wesendonk
 */
@SuppressWarnings("serial")
public class InvalidPropertyException extends FatalEmfStoreException {

	/**
	 * Default constructor.
	 */
	public InvalidPropertyException() {
		super("Invalid property.");
	}

	/**
	 * Default constructor.
	 * 
	 * @param message the message
	 * @param cause underlying exception
	 */
	public InvalidPropertyException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Default constructor.
	 * 
	 * @param message the message
	 */
	public InvalidPropertyException(String message) {
		super(message);
	}

}