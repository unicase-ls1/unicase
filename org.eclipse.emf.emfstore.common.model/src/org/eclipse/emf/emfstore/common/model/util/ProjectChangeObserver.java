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
package org.eclipse.emf.emfstore.common.model.util;

import org.eclipse.emf.emfstore.common.model.IdEObjectCollection;
import org.eclipse.emf.emfstore.common.model.Project;

/**
 * Observes changes to a Project. Can be registered with {@link Project}.
 * 
 * @author koegel
 */
public interface ProjectChangeObserver extends EObjectChangeObserver {

	/**
	 * The project of has been deleted including all contained model elements.
	 * 
	 * @param project
	 *            the deleted project
	 */
	void projectDeleted(IdEObjectCollection project);

}
