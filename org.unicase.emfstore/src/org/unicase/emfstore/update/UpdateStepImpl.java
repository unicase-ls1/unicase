package org.unicase.emfstore.update;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.model.Project;

public abstract class UpdateStepImpl implements UpdateStep {

	public int updateProjectHistory(ProjectHistory projectHistory) {
		EList<Version> versions = projectHistory.getVersions();
		int numberOfUpdatedItems = 0;
		for (Version version : versions) {
			Project projectState = version.getProjectState();
			numberOfUpdatedItems += updateProjectState(projectState);
		}
		return numberOfUpdatedItems;
	}

	public int updateProjectState(Project state){
		return 0;
	}
}
