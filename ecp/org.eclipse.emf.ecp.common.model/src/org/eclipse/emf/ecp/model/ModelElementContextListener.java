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

import org.eclipse.emf.ecore.EObject;

/**
 * Listens to the changes of a context.
 * 
 * @author helming
 */
public abstract class ModelElementContextListener {
	
	/**
	 * Called if a model element is deleted. Is only called for the root node if a tree of model elements is deleted.
	 */
	public abstract void onModelElementDeleted(EObject deleted);

	/**
	 * Call if the context gets deleted.
	 */
	public abstract void onContextDeleted();
	
}
