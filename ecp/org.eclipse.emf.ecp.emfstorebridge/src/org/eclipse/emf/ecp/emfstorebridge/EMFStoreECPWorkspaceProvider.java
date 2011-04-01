/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.emfstorebridge;

import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.ecp.model.workSpaceModel.util.ECPWorkspaceProvider;

/**
 * Provides an ECPWorkspace based on an EMFStore Workspace.
 * 
 * @author koegel
 */
public class EMFStoreECPWorkspaceProvider implements ECPWorkspaceProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ecp.model.workSpaceModel.util.ECPWorkspaceProvider#getECPWorkspace()
	 */
	public ECPWorkspace getECPWorkspace() {
		return new org.eclipse.emf.ecp.emfstorebridge.EMFECPWorkspace();
	}

}
