/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecp.model.workSpaceModel.util;

import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;

/**
 * An ECPWorkspace provider is expected to provide the ECPWorkspace and to save the workspace upon change automatically.
 * Changes can be changes to the ECPProjects contained in thew workspace or to any EObject contained in the ECPProjects.
 * 
 * @author koegel
 */
public interface ECPWorkspaceProvider {

	/**
	 * Retrieve the ECP Workspace.
	 * 
	 * @return the ECPWorkspace
	 */
	ECPWorkspace getECPWorkspace();
}
