/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.util;

/**
 * Represents an exception during the initialization of {@link AutoSaveContainer}.
 * 
 * @author koegel
 */
@SuppressWarnings("serial")
public class AutoSaveContainerInitilizationException extends Exception {

	/**
	 * Constructor.
	 * 
	 * @param message the message
	 * @param cause the cause
	 */
	public AutoSaveContainerInitilizationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param message the message
	 */
	public AutoSaveContainerInitilizationException(String message) {
		super(message);
	}

}
