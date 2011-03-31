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
 * Indicates that there are no changes on the server.
 * 
 * @author koegel
 */
@SuppressWarnings("serial")
public class NoChangesOnServerException extends WorkspaceException {

	private static final String MESSAGE = "No need to update. No changes on Server.";

	/**
	 * Constructor.
	 */
	public NoChangesOnServerException() {
		super(MESSAGE);
	}

}
