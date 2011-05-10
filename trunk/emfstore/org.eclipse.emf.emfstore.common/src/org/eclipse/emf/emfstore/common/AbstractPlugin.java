/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.common;

import org.eclipse.core.runtime.Plugin;

/**
 * Plugin class for emfstore common.
 * 
 * @author Koegel
 *
 */
public abstract class AbstractPlugin extends Plugin {
	
	private LogAdapter logAdapter;
	
	/**
	 * Constructor.
	 */
	public AbstractPlugin() {
		logAdapter = new LogAdapter();
	}

	/**
	 * Log an error.
	 * @param message the message
	 * @param exception the causing exception
	 * @param statusInt a status code
	 */
	public void log(String message, Exception exception, int statusInt) {
		logAdapter.log(message, exception, statusInt);
	}

	/**
	 * Log an exception to the error log.
	 * 
	 * @param message the message
	 * @param e the exception
	 */
	public void logException(String message, Exception e) {
		logAdapter.logException(message, e);
	}

	/**
	 * Log a warning to the error log.
	 * 
	 * @param message the message
	 * @param e the exception
	 */
	public void logWarning(String message, Exception e) {
		logAdapter.logWarning(message, e);
	}
}
