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
package org.eclipse.emf.ecp.common.util;

import org.eclipse.emf.emfstore.common.ILog;
import org.eclipse.emf.emfstore.common.LogAdapter;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Base class for ECP plugin. Provides logging capabilities.
 * 
 * @author emueller
 *
 */
public abstract class AbstractECPPlugin extends AbstractUIPlugin implements ILog {
	
	private LogAdapter logAdapter;
	
	/**
	 * Default constructor.
	 */
	public AbstractECPPlugin() {
		logAdapter = new LogAdapter();
	}

	/**
	 * Logs the given exception with the given message and an additional status code to the error log.
	 * 
	 * @param message the message to log
	 * @param exception the exception to log
	 * @param statusInt a status code
	 */
	public void log(String message, Exception exception, int statusInt) {
		logAdapter.log(message, exception, statusInt);
	}

	/**
	 * Logs an exception to the error log.
	 * 
	 * @param message the message
	 * @param e the exception
	 */
	public void logException(String message, Exception e) {
		logAdapter.logException(message, e);
	}

	/**
	 * Logs a warning to the error log.
	 * 
	 * @param message the message
	 * @param e the exception
	 */
	public void logWarning(String message, Exception e) {
		logAdapter.logWarning(message, e);
	}
}
