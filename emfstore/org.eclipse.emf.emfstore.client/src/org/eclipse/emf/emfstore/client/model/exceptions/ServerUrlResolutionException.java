/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.model.exceptions;

/**
 * Represents exception in resolving server url, the server has never been used to check out a project yet probably.
 * 
 * @author koegel
 */
@SuppressWarnings("serial")
public class ServerUrlResolutionException extends Exception {

	private static final String EXCEPTION_MESSAGE = "Server Url cannot be resolved. Server has never been used for check out.";

	/**
	 * Constructor.
	 */
	public ServerUrlResolutionException() {
		super(EXCEPTION_MESSAGE);
	}

}
