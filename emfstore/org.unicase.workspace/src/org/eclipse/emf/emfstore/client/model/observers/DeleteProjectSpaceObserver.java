/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.model.observers;

import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.unicase.util.observer.IObserver;

/**
 * Receives a notification when a project is deleted from the workspace.
 * 
 * @author Shterev
 */
public interface DeleteProjectSpaceObserver extends IObserver {

	/**
	 * Notifies that the project space has been deleted. This is a <b>PRE-DELETE</b> event.
	 * 
	 * @param projectSpace the project space
	 */
	void projectDeleted(ProjectSpace projectSpace);
}
