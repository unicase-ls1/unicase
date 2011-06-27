package org.unicase.ecp.model;

import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;

public interface PostECPWorkspaceInitiator {

	void workspaceInitComplete(ECPWorkspace currentWorkspace);

}
