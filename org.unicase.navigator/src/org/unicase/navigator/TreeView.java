package org.unicase.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.navigator.CommonNavigator;
import org.unicase.esmodel.ProjectInfo;
import org.unicase.model.Project;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ConnectionException;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.impl.WorkspaceFactoryImpl;

public class TreeView extends CommonNavigator {

	@Override
	protected IAdaptable getInitialInput() {

		Usersession usersession = WorkspaceFactoryImpl.eINSTANCE
				.createUsersession();
		usersession.setServerInfo(Configuration.getDefaultServerInfo());
		usersession.setUsername("user");
		usersession.logIn("password");

		Workspace workspace = WorkspaceManager.getInstance()
				.getCurrentWorkspace();
		ProjectInfo projectInfo;
		try {
			projectInfo = usersession.getRemoteProjectList().get(0);
			ProjectSpace projectSpace;
			projectSpace = usersession.checkout(projectInfo.getProjectId(),
					projectInfo.getVersion());
			Project project = projectSpace.getProject();
			return project;
		} catch (ConnectionException e) {
			// MK Auto-generated catch block
			e.printStackTrace();
			throw new IllegalStateException();
		}
		
	}

}
