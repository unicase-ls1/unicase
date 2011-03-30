/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.common.model.util;

/**
 * Represents an exception of a malformed version or non existing model version.
 * 
 * @author koegel
 */
@SuppressWarnings("serial")
public class MalformedModelVersionException extends Exception {

	/**
	 * Constructor.
	 * 
	 * @param message the message
	 * @param cause the cause
	 */
	public MalformedModelVersionException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param message the message
	 */
	public MalformedModelVersionException(String message) {
		super(message);
	}

}
