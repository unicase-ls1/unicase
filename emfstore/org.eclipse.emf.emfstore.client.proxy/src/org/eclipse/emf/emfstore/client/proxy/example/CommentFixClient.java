package org.eclipse.emf.emfstore.client.proxy.example;

import java.util.Date;

import org.eclipse.emf.emfstore.client.model.impl.ProjectSpaceImpl;
import org.eclipse.emf.emfstore.client.proxy.ProxyClient;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.InvalidVersionSpecException;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersioningFactory;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;

public class CommentFixClient extends ProxyClient {

	public void run() throws Exception {

		loginServer("super", "blub", "unicase.in.tum.de", "0.3.40", "unicase.org 2009#1", 443);

		// ProjectInfo projectInfo = getProjectInfo("unicase", false);

		for (ProjectInfo projectInfo : getConnectionManager().getProjectList(getSessionId())) {
			fixProject(projectInfo);
		}

	}

	private void fixProject(ProjectInfo projectInfo) throws EmfStoreException, InvalidVersionSpecException {
		System.out.println("Checking project: " + projectInfo.getName());

		ProjectSpaceImpl projectSpace = createTransientProjectSpace(getConnectionManager().getProject(getSessionId(),
			projectInfo.getProjectId(), projectInfo.getVersion()));

		// for (ModelElement me : projectSpace.getProject().getAllModelElements()) {
		// if (me instanceof UnicaseModelElement) {
		// UnicaseModelElement modelElement = (UnicaseModelElement) me;
		// if (modelElement instanceof Comment) {
		// if (modelElement.getDescription() == null
		// || modelElement.getDescription().equals("")) {
		// String name = modelElement.getName();
		// if (name == null) {
		// continue;
		// }
		// modelElement.setDescription(name);
		// if (20 < (name.length())) {
		// name = name.substring(0, 20) + "...";
		// }
		// modelElement.setName(name);
		// }
		// }
		// }
		// }

		ChangePackage localChangePackage = projectSpace.getLocalChangePackage(true);
		for (AbstractOperation ao : localChangePackage.getOperations()) {
			System.out.println(ao);
		}

		if (localChangePackage.getOperations().size() == 0) {
			System.out.println("no changes...");
			return;
		}

		PrimaryVersionSpec versionSpec = getConnectionManager().createVersion(
			getSessionId(),
			projectInfo.getProjectId(),
			projectInfo.getVersion(),
			localChangePackage,
			createLogMessage("super",
				"automatic commit: copied name from comment to description, if description was empty.", new Date()));

		System.out.println("new version: " + versionSpec.getIdentifier());

		getConnectionManager()
			.addTag(getSessionId(), projectInfo.getProjectId(), versionSpec, createTag("Comment fix"));
	}

	private TagVersionSpec createTag(String string) {
		TagVersionSpec tagVersionSpec = VersioningFactory.eINSTANCE.createTagVersionSpec();
		tagVersionSpec.setName(string);
		return tagVersionSpec;
	}
}
