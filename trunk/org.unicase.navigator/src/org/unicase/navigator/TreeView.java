package org.unicase.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.navigator.CommonNavigator;
import org.unicase.model.Project;
import org.unicase.model.impl.ProjectImpl;
import org.unicase.workspace.PrimaryVersionSpec;
import org.unicase.workspace.ProjectInfo;
import org.unicase.workspace.UCUserSession;
import org.unicase.workspace.UCWorkspace;

public class TreeView extends CommonNavigator {

	@Override
	protected IAdaptable getInitialInput() {

		UCUserSession session = new UCUserSession(UCUserSession
				.getDefaultServerInfo());
		session.logIn("", "");
		ProjectInfo projectInfo = session.getRemoteProjectList().get(0);
		UCWorkspace checkOut = session.checkOut(projectInfo.getProjectId(),
				projectInfo.getVersion());
		Project project = checkOut.getProject();

		return project;
	}

}
