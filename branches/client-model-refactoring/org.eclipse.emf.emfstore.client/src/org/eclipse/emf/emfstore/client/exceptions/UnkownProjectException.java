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
package org.eclipse.emf.emfstore.client.exceptions;

/**
 * Indicates that a project is not part of the current workspace.
 * 
 * @author koegel
 */
@SuppressWarnings("serial")
public class UnkownProjectException extends WorkspaceException {

	private static final String MESSAGE = "Unkown project, not part of the workspace";

	/**
	 * Constructor.
	 */
	public UnkownProjectException() {
		super(MESSAGE);
	}

}
