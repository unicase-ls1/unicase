/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
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
