/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.model.exceptions;

/**
 * Represents exception in project url resolution. The project cannot be resolved in the current workspace content. The
 * project the url refers to has not been checked out yet probably.
 * 
 * @author koegel
 */
@SuppressWarnings("serial")
public class ProjectUrlResolutionException extends Exception {

	private static final String EXCEPTION_MESSAGE = "Project Url cannot be resolved, project is not in local workspace, checkout project first.";

	/**
	 * Constructor.
	 */
	public ProjectUrlResolutionException() {
		super(EXCEPTION_MESSAGE);
	}

}
