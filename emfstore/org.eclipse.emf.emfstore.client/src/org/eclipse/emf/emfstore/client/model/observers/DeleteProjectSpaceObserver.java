/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.model.observers;

import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.common.observer.IObserver;

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
