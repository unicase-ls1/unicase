/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.diagram.impl;

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
