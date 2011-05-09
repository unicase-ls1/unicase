/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.ecp.xmiworkspace;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace;
import org.eclipse.emf.ecp.common.model.workSpaceModel.util.ECPWorkspaceProvider;
import org.eclipse.emf.ecp.xmiworkspace.exceptions.XMIWorkspaceException;

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
		String path = Platform.getLocation() + "/xmiworkspace.ucw";
		try {
			return XMIECPWorkspaceManager.loadWorkspace(path);
		} catch (XMIWorkspaceException e) {
		}
		return null;
	}

}
