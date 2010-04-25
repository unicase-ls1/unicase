/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator;

import java.util.Collection;

import org.unicase.workspace.ProjectSpace;

/**
 * Replacement for the project space provider. Influences the root level of the navigator.
 * 
 * @author helming
 */
public interface ProjectSpaceContentProvider {
	/**
	 * if the project spac has children.
	 * 
	 * @param projectSpace the project space
	 * @return i it has children
	 */
	boolean hasChildren(ProjectSpace projectSpace);

	/**
	 * Returns the children of a project space.
	 * 
	 * @param projectSpace The project space
	 * @return the children
	 */
	Collection<?> getChildren(ProjectSpace projectSpace);
}
