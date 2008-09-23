package org.unicase.emfstore.update;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.versioning.Version;
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
			numberOfUpdatedItems += updateProjectState(projectState);
		}
		return numberOfUpdatedItems;
	}

	/**
	 * @param state
	 * The project state to be updated
	 * @return
	 * The number of model elements updated during execution
	 */
	public abstract int updateProjectState(Project state);
}
