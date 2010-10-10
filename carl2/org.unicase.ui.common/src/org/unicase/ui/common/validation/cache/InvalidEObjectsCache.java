/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.validation.cache;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.unicase.ui.common.validation.ValidationResultProviderRegistry;
import org.unicase.ui.common.validation.listeners.ValidationListener;
import org.unicase.ui.common.validation.providers.ValidationResultProvider;

/**
 * Caches all modified model elements.
 * 
 * @author pfeifferc
 */
public class InvalidEObjectsCache implements ValidationListener {

	/**
	 * Contains the invalid {@link EObject}s.
	 */
	private Set<EObject> invalidEObjects;

	/**
	 * Direct parents of {@link EObject}s that are invalid.
	 */
	private Map<EObject, Integer> invalidEObjectParents;

	/**
	 * The {@link ValidationResultProvider} to provide the violations.
	 */
	private ValidationResultProvider validationResultProvider;

	/**
	 * Constructor.
	 * 
	 * @param root the root {@link EObject}
	 */
	public InvalidEObjectsCache(EObject root) {
		invalidEObjects = new HashSet<EObject>();
		invalidEObjectParents = new HashMap<EObject, Integer>();
		validationResultProvider = ValidationResultProviderRegistry.getInstance().getValidationResultProvider(root);
		if (validationResultProvider == null) {
			return;
		}
		Set<IConstraintStatus> constraintStati = validationResultProvider.getViolations();
		Set<EObject> eObjects = getEObjects(constraintStati);
		invalidate(eObjects);
		validationResultProvider.registerListener(this);
	}

	private Set<EObject> getEObjects(Set<IConstraintStatus> constraintStati) {
		Set<EObject> eObjects = new HashSet<EObject>();
		for (IConstraintStatus constraintStatus : constraintStati) {
			eObjects.add(constraintStatus.getTarget());
		}
		return eObjects;
	}

	/**
	 * If this model element has been modified.
	 * 
	 * @param eObject model element id
	 * @return If this model element has been modified.
	 */
	public int isEObjectInvalid(EObject eObject) {
		if (invalidEObjectParents.containsKey(eObject) || invalidEObjects.contains(eObject)) {
			return Status.WARNING;
		}
		return Status.CANCEL;
	}

	/**
	 * Invalidates a set of {@link EObject}s.
	 * 
	 * @param eObjects the invalid {@link EObject}s
	 */
	private void invalidate(Set<EObject> eObjects) {
		for (EObject eObject : eObjects) {
			invalidate(eObject);
		}
	}

	/**
	 * Invalidate the {@link EObject}.
	 * 
	 * @param eObject the invalid {@link EObject}
	 */
	private void invalidate(EObject eObject) {
		if (eObject == null) {
			return;
		}
		if (!invalidEObjects.contains(eObject)) {
			EObject nextParentEObject = getNextParentEObject(eObject);
			if (nextParentEObject != null) {
				addOneToParent(nextParentEObject);
			}
		}
		invalidEObjects.add(eObject);
	}

	/**
	 * Adds one to the parent.
	 * 
	 * @param parentEObject the
	 */
	private void addOneToParent(EObject parentEObject) {
		Integer number = invalidEObjectParents.get(parentEObject);
		if (number == null || number < 1) {
			number = 1;
			if (!invalidEObjects.contains(parentEObject)) {
				EObject nextParentEObject = parentEObject.eContainer();
				if (nextParentEObject != null) {
					addOneToParent(nextParentEObject);
				}
			}
		} else {
			number++;
		}
		invalidEObjectParents.put(parentEObject, number);
	}

	/**
	 * Returns the next parent eObject.
	 * 
	 * @param childEObject the
	 * @return the model element id of the parent of the model element id passed as reference, or null if there is none
	 */
	private EObject getNextParentEObject(EObject childEObject) {
		EObject parentEObject = childEObject.eContainer();
		if (parentEObject == null) {
			return null;
		} else {
			return parentEObject;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.validation.listeners.ValidationListener#objectValidated(org.unicase.metamodel.Project,
	 *      org.eclipse.emf.ecore.EObject, java.util.Set)
	 */
	public void objectValidated(EObject project, EObject eObject, Set<IConstraintStatus> constraintStati) {
		invalidEObjects.clear();
		invalidEObjectParents.clear();
		if (validationResultProvider == null) {
			return;
		}
		constraintStati = validationResultProvider.getViolations();
		Set<EObject> eObjects = getEObjects(constraintStati);
		invalidate(eObjects);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.validation.listeners.ValidationListener#rootRemoved(org.eclipse.emf.ecore.EObject)
	 */
	public void rootRemoved(EObject rootElement) {
		if (validationResultProvider != null) {
			validationResultProvider.unregisterListener(this);
		}
		invalidEObjects.clear();
		invalidEObjectParents.clear();
	}
}