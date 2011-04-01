/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.model;

import org.eclipse.emf.ecp.model.workSpaceModel.ECPWorkspace;

public interface PostECPWorkspaceInitiator {

	void workspaceInitComplete(ECPWorkspace currentWorkspace);

}
