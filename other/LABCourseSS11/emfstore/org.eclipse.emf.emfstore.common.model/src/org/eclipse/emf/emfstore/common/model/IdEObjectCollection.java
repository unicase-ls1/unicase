/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.common.model;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * A collection of {@link EObject}s where each one can be identified via a
 * {@link ModelElementId}. {@link EObject}s can be added and deleted and checked
 * whether they are part of the collection.
 * 
 * @author emueller
 * 
 */
public interface IdEObjectCollection extends EObject {

	/**
	 * Adds the given {@link EObject} to the collection.
	 * 
	 * @param eObject
	 *            the {@link EObject} that should get added to the collection
	 */
	void addModelElement(EObject eObject);

	/**
	 * Adds the given {@link EObject} to the collection. An additional map can
	 * be passed in, in order to assign the {@link EObject}(s) pre-defined
	 * {@link ModelElementId}s.
	 * 
	 * @param eObject
	 *            the {@link EObject} that should get added to the collection
	 * @param eObjectToIdMap
	 *            A map containing {@link ModelElementId}s for the
	 *            {@link EObject}s that should get added to the collection.
	 */
	void addModelElement(EObject eObject,
			Map<EObject, ModelElementId> eObjectToIdMap);

	/**
	 * 
	 * @param eObject
	 *            the {@link EObject} that should get checked, whether it is
	 *            contained in the collection
	 * @return true, if the {@link EObject} in question is contained in the
	 *         collection
	 */
	boolean containsInstance(EObject eObject);

	/**
	 * Checks whether the {@link EObject} with the given {@link ModelElementId}
	 * is contained in the collection.
	 * 
	 * @param eObjectId
	 *            the {@link ModelElementId} of the {@link EObject}, which
	 *            should get checked, whether it is contained in the collection
	 * @return true, if the {@link EObject} with the {@link ModelElementId} in
	 *         question is contained in the collection
	 */
	boolean contains(ModelElementId eObjectId);

	/**
	 * Retrieve the {@link ModelElementId} of the deleted {@link EObject}.
	 * 
	 * @param eObject
	 *            the deleted {@link EObject}
	 * @return the {@link ModelElementId} of the deleted {@link EObject}
	 */
	ModelElementId getDeletedModelElementId(EObject eObject);

	/**
	 * Retrieve the {@link ModelElementId} of the given {@link EObject}.
	 * 
	 * @param eObject
	 *            the {@link EObject}
	 * @return the {@link ModelElementId} of the {@link EObject}
	 */
	ModelElementId getModelElementId(EObject eObject);

	/**
	 * Returns the {@link EObject} with the given {@link ModelElementId}.
	 * 
	 * @param modelElementId
	 *            the ID of the {@link EObject}, that should get retrieved
	 * @return the {@link EObject} that has the given {@link ModelElementId}
	 *         assigned
	 */
	EObject getModelElement(ModelElementId modelElementId);

	/**
	 * Deletes the given {@link EObject} from the collection.
	 * 
	 * @param eObject
	 *            the {@link EObject} that should get deleted
	 */
	void deleteModelElement(EObject eObject);
}
