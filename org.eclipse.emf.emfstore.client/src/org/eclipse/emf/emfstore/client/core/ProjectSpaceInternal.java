/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.core;

import org.eclipse.emf.emfstore.client.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal;

public interface ProjectSpaceInternal extends ProjectSpace,
		ProjectSpaceDataInternal, ProjectSpaceControllerInternal {

	ProjectSpaceDataInternal getProjectSpaceDataInternal();

	ProjectSpaceControllerInternal getProjectSpaceControllerInternal();

} // ProjectContainer
