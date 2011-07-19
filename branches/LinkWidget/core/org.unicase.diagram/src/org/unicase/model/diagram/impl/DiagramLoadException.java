/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.diagram.impl;

/**
 * Represents a failure on diagram load.
 * 
 * @author koegel
 */
@SuppressWarnings("serial")
public class DiagramLoadException extends Exception {

	/**
	 * Constructor.
	 * 
	 * @param message the message
	 * @param cause the cause
	 */
	public DiagramLoadException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param message the message
	 */
	public DiagramLoadException(String message) {
		super(message);
	}

}
