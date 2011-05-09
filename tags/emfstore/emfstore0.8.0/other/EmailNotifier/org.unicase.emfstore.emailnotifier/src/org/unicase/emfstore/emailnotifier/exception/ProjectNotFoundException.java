/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.emfstore.emailnotifier.exception;

import org.unicase.emfstore.esmodel.ProjectId;

/**
 * 
 * @author staudta
 *
 */
public class ProjectNotFoundException extends Exception {

	private static final long serialVersionUID = 7487536187395593940L;
	
	/**
	 * Constructor.
	 * 
	 * @param projectId project id that hasn't been found
	 */
	public ProjectNotFoundException(ProjectId projectId) {
		super("Project with projectID "+ projectId +" not found.");
	}

}
