/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.util;

import org.unicase.workspace.ProjectSpace;

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
