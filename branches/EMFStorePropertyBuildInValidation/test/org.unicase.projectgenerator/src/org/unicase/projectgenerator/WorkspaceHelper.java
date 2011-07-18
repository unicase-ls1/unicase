/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.projectgenerator;

import java.io.File;
import java.util.Date;

import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceFactory;

/**
 * Helper class for workspace related operations, e.g. creating a temporary project space.
 * 
 * @author Hodaie
 */
public final class WorkspaceHelper {

	private static final String TEMP_PATH = Configuration.getWorkspaceDirectory() + File.separator + "tmp";

	private WorkspaceHelper() {

	}

	/**
	 * creates an empty project space in "tmp" folder under current workspace.
	 * 
	 * @param name project space name
	 * @return an empty project space
	 */
	public static ProjectSpace createEmptyProjectSpace(String name) {

		ProjectSpace projectSpace = WorkspaceFactory.eINSTANCE.createProjectSpace();
		ProjectId projectId = EsmodelFactory.eINSTANCE.createProjectId();
		projectId.setId(name);
		projectSpace.setIdentifier(name);
		projectSpace.setProjectId(projectId);
		projectSpace.setProjectName(name);
		projectSpace.setProjectDescription("description");
		PrimaryVersionSpec versionSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		versionSpec.setIdentifier(0);
		projectSpace.setBaseVersion(versionSpec);
		projectSpace.setLastUpdated(new Date());
		projectSpace.setUsersession(null);
		// projectSpace.setProject(ModelFactory.eINSTANCE.createProject());
		projectSpace.setResourceCount(0);

		File file = new File(TEMP_PATH);
		if (!file.exists()) {

			new File(TEMP_PATH).mkdir();
		}

		return projectSpace;

	}

}
