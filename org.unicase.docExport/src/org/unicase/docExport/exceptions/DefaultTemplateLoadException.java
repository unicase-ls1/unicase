/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exceptions;

/**
 * A default template could not be loaded successfuyll.
 * 
 * @author Sebastian Hoecht
 */
public class DefaultTemplateLoadException extends Exception {

	private static final long serialVersionUID = 5538721749489300346L;

	/**
	 * default constructor.
	 */
	public DefaultTemplateLoadException() {
		super();
	}

	/**
	 * calls super method.
	 * 
	 * @param message the message which shall be shown.
	 * @param cause the exception which has caused this exception
	 */
	public DefaultTemplateLoadException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * calls super method.
	 * 
	 * @param message the message which shall be shown.
	 */
	public DefaultTemplateLoadException(String message) {
		super(message);
	}

	/**
	 * calls super method.
	 * 
	 * @param cause the Exception which has caused this exception
	 */
	public DefaultTemplateLoadException(Throwable cause) {
		super(cause);
	}

}
