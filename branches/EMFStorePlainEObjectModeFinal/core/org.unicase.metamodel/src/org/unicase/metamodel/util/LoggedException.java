/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel.util;

/**
 * @author emueller
 */
public class LoggedException extends RuntimeException {

	private Throwable exception;

	/**
	 * @param exception
	 */
	public LoggedException(Throwable exception) {
		this.exception = exception;
	}

	/**
	 * @param exception2
	 * @param stackTrace
	 */
	public LoggedException(Throwable exception2, String message) {
		super(message, exception2);
	}

	private static final long serialVersionUID = 2575497213330248095L;

}
