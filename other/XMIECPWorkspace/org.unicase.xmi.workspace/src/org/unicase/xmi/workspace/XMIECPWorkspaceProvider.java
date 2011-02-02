package org.unicase.xmi.workspace;

import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.ecp.model.workSpaceModel.util.ECPWorkspaceProvider;

/**
 * The sole purpose of this provider is to return the correct workspace.
 * @author matti, markus
 *
 */
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
