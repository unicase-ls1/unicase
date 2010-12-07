package org.unicase.xmi.workspace;

import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.ecp.model.workSpaceModel.util.ECPWorkspaceProvider;

public class XMIECPWorkspaceProvider implements ECPWorkspaceProvider {

	/** 
     * {@inheritDoc} 
     * 
     * @see org.unicase.ui.navigator.workSpaceModel.util.ECPWorkspaceProvider#getECPWorkspace() 
     */
	public ECPWorkspace getECPWorkspace() {
		
		//return new XMIECPWorkspaceDraft();
		return new XMIECPWorkspace();
	}

}
