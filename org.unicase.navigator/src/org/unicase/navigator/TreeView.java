package org.unicase.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.navigator.CommonNavigator;
import org.unicase.esmodel.ProjectInfo;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ConnectionException;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;


public class TreeView extends CommonNavigator {

	@Override
	protected IAdaptable getInitialInput() {

		Usersession usersession = WorkspaceFactory.eINSTANCE
				.createUsersession();
		usersession.setServerInfo(Configuration.getDefaultServerInfo());
		usersession.setUsername("user");
		Workspace workspace = WorkspaceManager.getInstance()
				.getCurrentWorkspace();
		if (workspace.getProjectSpaces().size() < 2) {

			ProjectInfo projectInfo;
			try {
				usersession.logIn("password");
				projectInfo = usersession.getRemoteProjectList().get(0);
				usersession.checkout(projectInfo.getProjectId(), projectInfo
						.getVersion());
				usersession.checkout(projectInfo.getProjectId(), projectInfo
						.getVersion());

			} catch (ConnectionException e) {
				// MK Auto-generated catch block
				e.printStackTrace();
				throw new IllegalStateException();
			}
		}

		return workspace;

	}

}
