/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package scrm.impl;

/**
 * @author koegel
 */
@SuppressWarnings("serial")
public class DiagramStoreException extends Exception {

	/**
	 * Constructor.
	 * 
	 * @param message thew message
	 * @param cause the cause
	 */
	public DiagramStoreException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param message the message
	 */
	public DiagramStoreException(String message) {
		super(message);
	}

}
