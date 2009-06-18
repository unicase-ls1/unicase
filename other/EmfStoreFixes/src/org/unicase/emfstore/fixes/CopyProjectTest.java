package org.unicase.emfstore.fixes;

import java.io.File;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;

public class CopyProjectTest extends AbstractFix {

	@Override
	void fix() throws FatalEmfStoreException {
		ProjectHistory projectHistory = (ProjectHistory) EcoreUtil.copy(this.projectHistory);
		createResourceForProjectHistory(projectHistory);
		for (Version version : projectHistory.getVersions()) {

			// if (version.getProjectState() != null) {
			// createResourceForProject(version.getProjectState(), version.getPrimarySpec(), projectHistory
			// .getProjectId());
			// }
			String filename = getProjectFolder(this.projectHistory.getProjectId())
				+ getChangePackageFile(version(version));
			File file = new File(filename);
			// if (!file.exists() && version.getChanges() != null) {
			if (between(version, 0, 2)) {
				ChangePackage changes = version.getChanges();
				version.setChanges(null);
				save(version);
				// createResourceForChangePackage(changes, version.getPrimarySpec(), projectHistory.getProjectId());
				// version.setChanges(changes);
				// save(version);
			}

			// createResourceForVersion(version, projectHistory.getProjectId());
		}
		// save(projectHistory);
		// for (Version version : projectHistory.getVersions()) {
		// save(version.getChanges());
		// save(version.getProjectState());
		// save(version);
		// }
	}

	@Override
	String getFixName() {
		return "Copy project test";
	}

	private void createResourceForProjectHistory(ProjectHistory projectHistory) throws FatalEmfStoreException {
		String fileName = getProjectFolder(projectHistory.getProjectId()) + "projectHistory"
			+ ServerConfiguration.FILE_EXTENSION_PROJECTHISTORY;
		saveInResource(projectHistory, fileName);
	}

	private void createResourceForVersion(Version version, ProjectId projectId) throws FatalEmfStoreException {
		String fileName = getProjectFolder(projectId) + ServerConfiguration.FILE_PREFIX_VERSION
			+ version.getPrimarySpec().getIdentifier() + ServerConfiguration.FILE_EXTENSION_VERSION;
		saveInResource(version, fileName);
	}
}
