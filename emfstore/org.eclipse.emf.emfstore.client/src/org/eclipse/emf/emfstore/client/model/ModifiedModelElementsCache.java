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
package org.eclipse.emf.emfstore.client.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.model.observers.CommitObserver;
import org.eclipse.emf.emfstore.client.model.observers.OperationListener;
import org.eclipse.emf.emfstore.client.model.observers.ShareObserver;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;

/**
 * Caches all modified model elements.
 * 
 * @author pfeifferc
 */
public class ModifiedModelElementsCache implements OperationListener, CommitObserver, ShareObserver {

	/**
	 * Contains the model elements that were changed, and a list of operations
	 * that need to be remembered for undone's.
	 */
	private Map<String, List<AbstractOperation>> modifiedModelElements;

	/**
	 * Direct parents of model elements who were affected of changes.
	 */
	private Map<String, Integer> modifiedModelElementParents;

	/**
	 * Maps child to parent elements to be able to retrieve hierarchies already
	 * deconstructed in the project space.
	 */
	private HashMap<String, String> childParentMapping;

	/**
	 * The project space.
	 */
	private ProjectSpace projectSpace;

	/**
	 * Constructor.
	 * 
	 * @param projectSpace
	 *            the project space
	 */
	public ModifiedModelElementsCache(ProjectSpace projectSpace) {
		this.projectSpace = projectSpace;
		modifiedModelElements = new HashMap<String, List<AbstractOperation>>();
		modifiedModelElementParents = new HashMap<String, Integer>();
		childParentMapping = new HashMap<String, String>();
	}

	/**
	 * Initialize the cache after restart.
	 */
	public void initializeCache() {
		if (projectSpace != null && projectSpace.getOperations() != null) {
			for (AbstractOperation abstractOperation : projectSpace.getOperations()) {
				operationExecuted(abstractOperation);
			}
		}
	}

	/**
	 * If this model element has been modified.
	 * 
	 * @param modelElementId
	 *            model element id
	 * @return If this model element has been modified.
	 */
	public boolean isModelElementDirty(ModelElementId modelElementId) {
		return modifiedModelElementParents.containsKey(modelElementId.getId())
			|| modifiedModelElements.containsKey(modelElementId.getId());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.observers.OperationListener#operationExecuted(org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation)
	 */
	public void operationExecuted(AbstractOperation abstractOperation) {
		// cache the model element and the operation, as well as the modified
		// parents recursively
		for (ModelElementId modelElementId : abstractOperation.getAllInvolvedModelElements()) {
			if (modifiedModelElements.containsKey(modelElementId.getId())) {
				modifiedModelElements.get(modelElementId.getId()).add(abstractOperation);
			} else {
				List<AbstractOperation> abstractOperations = new ArrayList<AbstractOperation>();
				abstractOperations.add(abstractOperation);
				modifiedModelElements.put(modelElementId.getId(), abstractOperations);
				ModelElementId nextParentModelElementId = getNextParentModelElementId(modelElementId.getId());
				if (nextParentModelElementId != null) {
					childParentMapping.put(modelElementId.getId(), nextParentModelElementId.getId());
					addOneToParent(nextParentModelElementId);
				}
			}
		}
	}

	/**
	 * Removes one from the number of dirty children a parent has. Moves through
	 * the hierarchy recursively.
	 * 
	 * @param parentModelElementId
	 */
	private void removeOneFromParent(String parentModelElementId) {
		Integer number = modifiedModelElementParents.get(parentModelElementId);
		if (number == null || number - 1 == 0) {
			modifiedModelElementParents.remove(parentModelElementId);
			if (!modifiedModelElements.containsKey(parentModelElementId)) {
				ModelElementId nextParentModelElementId = getNextParentModelElementId(parentModelElementId);
				if (nextParentModelElementId != null) {
					removeOneFromParent(nextParentModelElementId.getId());
				}
			}
		} else {
			modifiedModelElementParents.put(parentModelElementId, number - 1);
		}
	}

	private void addOneToParent(ModelElementId parentModelElementId) {
		Integer number = modifiedModelElementParents.get(parentModelElementId);
		if (number == null || number < 1) {
			number = 1;
			if (!modifiedModelElements.containsKey(parentModelElementId.getId())) {
				EObject nextParentModelElement = getModelElementForId(parentModelElementId.getId()).eContainer();
				if (nextParentModelElement != null && nextParentModelElement != this.projectSpace.getProject()) {
					addOneToParent(this.projectSpace.getProject().getModelElementId(nextParentModelElement));
				}
			}
		} else {
			number++;
		}
		modifiedModelElementParents.put(parentModelElementId.getId(), number);
	}

	/**
	 * @param childModelElementId
	 *            the
	 * @return the model element id of the parent of the model element id passed
	 *         as reference, or null if there is none
	 */
	private ModelElementId getNextParentModelElementId(String childModelElementId) {
		EObject childModelElement = getModelElementForId(childModelElementId);
		if (childModelElement == null) {
			return null;
		}
		EObject nextParentModelElement = childModelElement.eContainer();
		if (nextParentModelElement == null || nextParentModelElement == this.projectSpace.getProject()) {
			return null;
		} else {
			return this.projectSpace.getProject().getModelElementId(nextParentModelElement);
		}
	}

	/**
	 * @param modelElementId
	 *            the
	 * @return the model element for the model element id passed as reference
	 */
	private EObject getModelElementForId(String modelElementIdString) {
		ModelElementId modelElementId = org.eclipse.emf.emfstore.common.model.ModelFactory.eINSTANCE
			.createModelElementId();
		modelElementId.setId(modelElementIdString);
		return projectSpace.getProject().getModelElement(modelElementId);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.observers.OperationListener#operationUnDone(org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation)
	 */
	public void operationUnDone(AbstractOperation operation) {
		// remove from cache
		Set<ModelElementId> involvedMEs = operation.getAllInvolvedModelElements();
		for (ModelElementId childModelElementId : involvedMEs) {
			// update the model elements directly affected by the changes to the
			// list of modified model elements
			if (modifiedModelElements.containsKey(childModelElementId.getId())) {
				modifiedModelElements.get(childModelElementId.getId()).remove(operation);
				if (modifiedModelElements.get(childModelElementId.getId()).size() == 0) {
					modifiedModelElements.remove(childModelElementId.getId());
					if (childParentMapping.get(childModelElementId.getId()) != null) {
						removeOneFromParent(childParentMapping.get(childModelElementId.getId()));
					}
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.observers.CommitObserver#commitCompleted(org.eclipse.emf.emfstore.client.model.ProjectSpace,
	 *      org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec)
	 */
	public void commitCompleted(ProjectSpace projectSpace, PrimaryVersionSpec newRevision) {
		// do the same as when project has been shared
		shareDone();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.observers.CommitObserver#inspectChanges(org.eclipse.emf.emfstore.client.model.ProjectSpace,
	 *      org.eclipse.emf.emfstore.server.model.versioning.ChangePackage)
	 */
	public boolean inspectChanges(ProjectSpace projectSpace, ChangePackage changePackage) {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public void shareDone() {
		modifiedModelElementParents.clear();
		modifiedModelElements.clear();
	}
}
