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
package org.eclipse.emf.emfstore.client.model.util;

import org.eclipse.emf.emfstore.client.model.ProjectSpace;

/**
 * Interface for a class, usually a view, that can provide a project space, usually the project space it displays.
 * 
 * @author koegel
 */
public interface ProjectSpaceContainer {

	/**
	 * Retrieve the project space of the container.
	 * 
	 * @return the project space
	 */
	ProjectSpace getProjectSpace();
}
