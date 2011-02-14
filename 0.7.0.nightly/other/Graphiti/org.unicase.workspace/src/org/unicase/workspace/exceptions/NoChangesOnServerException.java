/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.exceptions;

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
