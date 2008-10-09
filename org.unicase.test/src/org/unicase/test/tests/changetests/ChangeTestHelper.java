package org.unicase.test.tests.changetests;

import java.util.Date;
import java.util.List;

import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;

public class ChangeTestHelper {

	public static ProjectSpace createEmptyProjectSpace(String name) {
		Workspace workSpace = WorkspaceManager.getInstance().getCurrentWorkspace();
		List<ProjectSpace> projectSpaces = workSpace.getProjectSpaces();
		for(ProjectSpace ps : projectSpaces){
			if(ps.getProjectName().equalsIgnoreCase(name)){
				return ps;
			}
		}
		
		ProjectSpace projectSpace = WorkspaceFactory.eINSTANCE
				.createProjectSpace();
		ProjectId projectId = EsmodelFactory.eINSTANCE.createProjectId();
		projectId.setId(name);
		projectSpace.setIdentifier(name);
		projectSpace.setProjectId(projectId);
		projectSpace.setProjectName(name);
		projectSpace.setProjectDescription("description");
		PrimaryVersionSpec versionSpec = VersioningFactory.eINSTANCE
				.createPrimaryVersionSpec();
		versionSpec.setIdentifier(0);
		projectSpace.setBaseVersion(versionSpec);
		projectSpace.setLastUpdated(new Date());
		projectSpace.setUsersession(null);
		//projectSpace.setProject(ModelFactory.eINSTANCE.createProject());
		projectSpace.setResourceCount(0);
		return projectSpace;
	}
}
