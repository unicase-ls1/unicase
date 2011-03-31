/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.common.model.util;

/**
 * Utility class for catching exceptions in tests.
 * 
 * @author emueller
 */
public class LoggedException extends RuntimeException {

	private static final long serialVersionUID = 2575497213330248095L;

	/**
	 * @param exception cause
	 */
	public LoggedException(Throwable exception) {
		super(exception);
	}

	/**
	 * @param exception cause
	 * @param message message
	 */
	public LoggedException(Throwable exception, String message) {
		super(message, exception);
	}
}
