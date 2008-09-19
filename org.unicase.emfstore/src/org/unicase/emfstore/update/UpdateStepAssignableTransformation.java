package org.unicase.emfstore.update;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.classes.ClassesPackage;

public class UpdateStepAssignableTransformation implements UpdateStep {

	protected org.osgi.framework.Version sourceVersion = new org.osgi.framework.Version("0.0.1");
	protected org.osgi.framework.Version targetVersion = new org.osgi.framework.Version("0.0.2");
	
	public org.osgi.framework.Version getSourceVersion() {
		return sourceVersion;
	}

	public org.osgi.framework.Version getTargetVersion() {
		return targetVersion;
	}

	public void updateProjectHistory(ProjectHistory projectHistory) {
		EList<Version> versions = projectHistory.getVersions();
		
		for (Version version : versions) {
			Project projectState = version.getProjectState();
//			projectState.getAllModelElementsbyClass(
		}
	}

}
