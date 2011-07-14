/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecpemfstorebridge;

import org.unicase.ui.navigator.workSpaceModel.ECPWorkspace;
import org.unicase.ui.navigator.workSpaceModel.util.ECPWorkspaceProvider;

/**
 * Provides an ECPWorkspace based on an EMFStore Workspace.
 * 
 * @author koegel
 */
public class EMFStoreECPWorkspaceProvider implements ECPWorkspaceProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.navigator.workSpaceModel.util.ECPWorkspaceProvider#getECPWorkspace()
	 */
	public ECPWorkspace getECPWorkspace() {
		return new org.unicase.ecpemfstorebridge.EMFECPWorkspace();
	}

}
