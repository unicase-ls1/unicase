package org.unicase.xmi.workspace;

import org.unicase.ui.navigator.workSpaceModel.ECPWorkspace;
import org.unicase.ui.navigator.workSpaceModel.util.ECPWorkspaceProvider;

public class XMIECPWorkspaceProvider implements ECPWorkspaceProvider {

	@Override
	public ECPWorkspace getECPWorkspace() {
		return new XMIECPWorkspace();
	}

}
