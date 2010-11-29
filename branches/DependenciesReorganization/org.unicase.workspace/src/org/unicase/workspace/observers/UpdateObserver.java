/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.observers;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.workspace.ProjectSpace;

/**
 * Notifies the UI that a list of changes will be automatically merged with the current model state.
 */
public interface UpdateObserver extends AbstractObserver {

	/**
	 * Called to notify the observer about the changes that will be merged into the project space.
	 * 
	 * @param projectSpace the project ppace that should be updated
	 * @param changePackages a list of change packages
	 * @return false if the observer wants to cancel the update
	 */
	boolean inspectChanges(ProjectSpace projectSpace, List<ChangePackage> changePackages);

	/**
	 * Called after the changes have been applied to the project and the update is completed.
	 * 
	 * @param projectSpace
	 */
	void updateCompleted(ProjectSpace projectSpace);

}
