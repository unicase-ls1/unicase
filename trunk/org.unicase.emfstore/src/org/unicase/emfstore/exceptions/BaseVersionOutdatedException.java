/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.exceptions;

/**
 * Represents an exception because the base version of a project space is not up
 * to date.
 * 
 * @author koegel
 * 
 */
//FIXME: move to workspace
@SuppressWarnings("serial")
public class BaseVersionOutdatedException extends EmfStoreException {

	/**
	 * @param message the message 
	 * @param cause underlying exception
	 */
	public BaseVersionOutdatedException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Default constructor.
	 * @param message the message
	 */
	public BaseVersionOutdatedException(String message) {
		super(message);
	}

}
