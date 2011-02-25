/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;

public interface IdProvider {

	/**
	 * Retrieve the {@link ModelElementId} for an EObject.
	 * 
	 * @param eObject the eObject
	 * @return the {@link ModelElementId} or null if the model element isn't contained in the project
	 */
	ModelElementId getModelElementId(EObject child);

	/**
	 * Get all model element IDs of this project.
	 * 
	 * @return a set of model element IDs
	 */
	Set<ModelElementId> getAllModelElementIds();

	/**
	 * Returns whether the project contains a model element with the same id.
	 * 
	 * @param modelElementId the id
	 * @return true if the project contains such a model element
	 */
	boolean contains(ModelElementId modelElementId);

	public ModelElementId getDeletedModelElementId(EObject deletedModelElement);

}
