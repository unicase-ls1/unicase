/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.update;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.Project;

/**
 * @author schroech
 *
 */
public abstract class UpdateStepImpl implements UpdateStep {

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStep#updateProjectHistory(org.unicase.emfstore.esmodel.ProjectHistory)
	 */
	public int updateProjectHistory(ProjectHistory projectHistory) {
		EList<Version> versions = projectHistory.getVersions();
		int numberOfUpdatedItems = 0;
		for (Version version : versions) {
			Project projectState = version.getProjectState();
			try {
				numberOfUpdatedItems += updateProjectState(projectState);
			} catch (EmfStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return numberOfUpdatedItems;
	}

	/**
	 * @param state
	 * The project state to be updated
	 * @return
	 * The number of model elements updated during execution
	 * @throws EmfStoreException
	 * Throws an EMFStoreException if an update could not be performed for randomn reasons
	 */
	public abstract int updateProjectState(Project state) throws EmfStoreException;
}
