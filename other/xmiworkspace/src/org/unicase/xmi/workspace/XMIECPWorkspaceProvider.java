package org.unicase.xmi.workspace;

import org.unicase.ui.navigator.workSpaceModel.ECPWorkspace;
import org.unicase.ui.navigator.workSpaceModel.util.ECPWorkspaceProvider;

public class XMIECPWorkspaceProvider implements ECPWorkspaceProvider {

	/** 
     * {@inheritDoc} 
     * 
     * @see org.unicase.ui.navigator.workSpaceModel.util.ECPWorkspaceProvider#getECPWorkspace() 
     */
	public ECPWorkspace getECPWorkspace() {
		return new XMIECPWorkspace();
	}

}
