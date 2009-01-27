/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exceptions;

/**
 * @author Sebastian Hoecht
 */
@SuppressWarnings("serial")
public class TemplateSaveException extends Exception {

	/**
	 * default constructor.
	 */
	public TemplateSaveException() {
		super();
	}

	/**
	 * calls super method.
	 * 
	 * @param message the message which shall be shown.
	 * @param cause the exception which has caused this exception
	 */
	public TemplateSaveException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * calls super method.
	 * 
	 * @param message the message which shall be shown.
	 */
	public TemplateSaveException(String message) {
		super(message);
	}

	/**
	 * calls super method.
	 * 
	 * @param cause the Exception which has caused this exception
	 */
	public TemplateSaveException(Throwable cause) {
		super(cause);
	}

}
