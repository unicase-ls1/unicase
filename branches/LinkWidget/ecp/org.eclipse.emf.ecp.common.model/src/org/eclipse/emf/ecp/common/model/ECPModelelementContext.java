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
package org.eclipse.emf.ecp.common.model;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Context for a modelelement.
 * 
 * @author helming
 */
public interface ECPModelelementContext {

	/**
	 * Adds a {@link ModelElementContextListener}.
	 * 
	 * @param modelElementContextListener the {@link ModelElementContextListener}
	 */
	void addModelElementContextListener(ModelElementContextListener modelElementContextListener);

	/**
	 * Removes a {@link ModelElementContextListener}.
	 * 
	 * @param modelElementContextListener the {@link ModelElementContextListener}
	 */
	void removeModelElementContextListener(ModelElementContextListener modelElementContextListener);

	/**
	 * Returns all model elements in this context.
	 * 
	 * @return a list of model elements
	 */
	Collection<EObject> getAllModelElements();

	/**
	 * Returns all {@link EObject} in the context, which are of a certain type. Could exclude
	 * {@link AssociationClassElement}'s.
	 * 
	 * @param clazz the type
	 * @param association whether to include {@link AssociationClassElement}
	 * @return a {@link Collection} of {@link EObject}
	 */
	Collection<EObject> getAllModelElementsbyClass(EClass clazz, boolean association);

	/**
	 * Returns the editing domain.
	 * 
	 * @return the editing domain
	 */
	EditingDomain getEditingDomain();

	/**
	 * Returns the {@link ECPMetaModelElementContext}.
	 * 
	 * @return the {@link ECPMetaModelElementContext}.
	 */
	ECPMetaModelElementContext getMetaModelElementContext();

	/**
	 * If a {@link EObject} is contained in this context and can be therefore referenced by the {@link EObject} defining
	 * the context.
	 * 
	 * @param eObject the {@link EObject}
	 * @return if the {@link EObject} is contained in the context
	 */
	boolean contains(EObject eObject);

	/**
	 * Called if the context is not used anymore. Use for cleanup.
	 */
	void dispose();
	
	/**
	 * Returns all {@link ECPModelelementContext} that are neighbor with this context.
	 * 
	 * @return Collection of all neighboring contexts
	 */
	Collection<ECPModelelementContext> getNeighbors();
}
