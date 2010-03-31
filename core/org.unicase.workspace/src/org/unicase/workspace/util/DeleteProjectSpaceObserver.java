/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.util;

import org.unicase.workspace.ProjectSpace;

/**
 * Receives a notification when a project is deleted from the workspace
 * 
 * @author Shterev
 */
public interface DeleteProjectSpaceObserver {

	/**
	 * Notifies that the project space has been deleted. This is a
	 * <b>PRE-DELETE</b> event.
	 */
	public void projectDeleted(ProjectSpace projectSpace);
}
