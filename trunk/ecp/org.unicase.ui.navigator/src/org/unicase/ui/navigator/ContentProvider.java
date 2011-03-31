/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.unicase.ui.navigator;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

/**
 * Replacement for the project space provider. Influences the root level of the navigator.
 * 
 * @author helming
 */
public interface ContentProvider {
	/**
	 * if the root object has children.
	 * 
	 * @param rootObject the project space
	 * @return i it has children
	 */
	boolean hasChildren(EObject rootObject);

	/**
	 * Returns the children of a root object.
	 * 
	 * @param rootObject The root object
	 * @return the children
	 */
	Collection<?> getChildren(EObject rootObject);
}
