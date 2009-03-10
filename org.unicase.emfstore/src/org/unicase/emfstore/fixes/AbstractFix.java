package org.unicase.emfstore.fixes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.exceptions.StorageException;

public abstract class AbstractFix {

	protected ProjectHistory projectHistory;

	abstract String getFixName();

	public void runFix(ProjectHistory projectHistory) {
		this.projectHistory = projectHistory;
		fix();
	}

	abstract void fix();

	protected void save(EObject object) {
		try {
			object.eResource().save(null);
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (Exception e) {
			System.out.println(StorageException.NOSAVE);
			System.exit(0);
		}
		// END SUPRESS CATCH EXCEPTION
	}

	protected List<Version> getVersionsWithProjectState() {
		List<Version> result = new ArrayList<Version>();
		for (Version version : projectHistory.getVersions()) {
			if (version.getProjectState() != null) {
				result.add(version);
			}
		}
		return result;
	}
}