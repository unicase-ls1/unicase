/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.common.model;

import org.eclipse.emf.ecore.EObject;

/**
 * Interface for mapping {@link ModelElementId}s to singleton objects and vice versa.
 * 
 * @author emueller
 */
public interface SingletonIdResolver {

	/**
	 * Returns the ID for the given singleton {@link EObject}.
	 * 
	 * @param singleton the singleton {@link EObject} whose {@link ModelElementId} should get retrieved
	 * @return the {@link ModelElementId} of the the singleton object or <code>null</code> if the given {@link EObject}
	 *         is not a singleton or if it is <code>null</code>
	 */
	ModelElementId getSingletonModelElementId(EObject singleton);

	/**
	 * Returns the singleton which belongs to the given {@link ModelElementId}.
	 * 
	 * @param singletonId a {@link ModelElementId}
	 * @return the singleton {@link EObject} that belongs to the given {@link ModelElementId}
	 */
	EObject getSingleton(ModelElementId singletonId);

	/**
	 * Determines whether the given {@link EObject} is a singleton.
	 * 
	 * @param eObject the EObject to check
	 * @return true, iff the given {@link EObject} is a singleton
	 */
	boolean isSingleton(EObject eObject);
}
