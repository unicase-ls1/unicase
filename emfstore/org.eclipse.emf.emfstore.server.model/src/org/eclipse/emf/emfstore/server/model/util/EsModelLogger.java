/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.util;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;

/**
 * Logger for log messages from esmodel.
 * 
 * @author koegel
 */
public final class EsModelLogger {

	private EsModelLogger() {
		// private constructor for helper class
	}

	/**
	 * This will add a new entry to error log view of eclipse.
	 * 
	 * @param message message
	 * @param exception exception
	 * @param statusInt severity. Use one of constants in org.eclipse.core.runtime.Status class.
	 */
	public static void log(String message, Exception exception, int statusInt) {
		Status status = new Status(statusInt, Platform.getBundle("org.eclipse.emf.ecp.model").getSymbolicName(),
			statusInt, message, exception);
		Platform.getLog(Platform.getBundle("org.eclipse.emf.emfstore.server.model")).log(status);
	}

	/**
	 * Log an exception to the platform log. This will create a popup in the ui.
	 * 
	 * @param message the message
	 * @param exception the exception
	 */
	public static void logException(String message, Exception exception) {
		log(message, exception, IStatus.ERROR);
	}

	/**
	 * Log an exception to the platform log. This will create a popup in the ui.
	 * 
	 * @param message the message
	 * @param exception the exception
	 */
	public static void logWarning(String message, Exception exception) {
		log(message, exception, IStatus.WARNING);
	}
}
