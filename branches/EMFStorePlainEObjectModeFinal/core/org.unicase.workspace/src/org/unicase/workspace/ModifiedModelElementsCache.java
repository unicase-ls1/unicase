/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.metamodel.ModelElementId;
import org.unicase.workspace.observers.CommitObserver;
import org.unicase.workspace.observers.OperationListener;
import org.unicase.workspace.observers.ShareObserver;

/**
 * Caches all modified model elements.
 * 
 * @author pfeifferc
 */
public class ModifiedModelElementsCache implements OperationListener, CommitObserver, ShareObserver {

	/**
	 * Contains the model elements that were changed, and a list of operations that need to be remembered for undone's.
	 */
	private Map<ModelElementId, List<AbstractOperation>> modifiedModelElements;

	/**
	 * Direct parents of model elements who were affected of changes.
	 */
	private Map<ModelElementId, Integer> modifiedModelElementParents;

	/**
	 * Maps child to parent elements to be able to retrieve hierarchies already deconstructed in the project space.
	 */
	private HashMap<ModelElementId, ModelElementId> childParentMapping;

	/**
	 * The project space.
	 */
	private ProjectSpace projectSpace;

	/**
	 * Constructor.
	 * 
	 * @param projectSpace the project space
	 */
	public ModifiedModelElementsCache(ProjectSpace projectSpace) {
		this.projectSpace = projectSpace;
		modifiedModelElements = new HashMap<ModelElementId, List<AbstractOperation>>();
		modifiedModelElementParents = new HashMap<ModelElementId, Integer>();
		childParentMapping = new HashMap<ModelElementId, ModelElementId>();
	}

	/**
	 * If this model element has been modified.
	 * 
	 * @param modelElementId model element id
	 * @return If this model element has been modified.
	 */
	public boolean isModelElementDirty(ModelElementId modelElementId) {
		return modifiedModelElementParents.containsKey(modelElementId)
			|| modifiedModelElements.containsKey(modelElementId);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.OperationListener#operationExecuted(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public void operationExecuted(AbstractOperation abstractOperation) {
		// cache the model element and the operation, as well as the modified parents recursively
		for (ModelElementId modelElementId : abstractOperation.getAllInvolvedModelElements()) {
			if (modifiedModelElements.containsKey(modelElementId)) {
				modifiedModelElements.get(modelElementId).add(abstractOperation);
			} else {
				List<AbstractOperation> abstractOperations = new ArrayList<AbstractOperation>();
				abstractOperations.add(abstractOperation);
				modifiedModelElements.put(modelElementId, abstractOperations);
				ModelElementId nextParentModelElementId = getNextParentModelElementId(modelElementId);
				if (nextParentModelElementId != null) {
					childParentMapping.put(modelElementId, nextParentModelElementId);
					addOneToParent(nextParentModelElementId);
				}
			}
		}
	}

	/**
	 * Removes one from the number of dirty children a parent has. Moves through the hierarchy recursively.
	 * 
	 * @param parentModelElementId
	 */
	private void removeOneFromParent(ModelElementId parentModelElementId) {
		Integer number = modifiedModelElementParents.get(parentModelElementId);
		if (number == null || number - 1 == 0) {
			modifiedModelElementParents.remove(parentModelElementId);
			if (!modifiedModelElements.containsKey(parentModelElementId)) {
				ModelElementId nextParentModelElementId = getNextParentModelElementId(parentModelElementId);
				if (nextParentModelElementId != null) {
					removeOneFromParent(nextParentModelElementId);
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
			if (!modifiedModelElements.containsKey(parentModelElementId)) {
				EObject nextParentModelElement = getModelElementForId(parentModelElementId).eContainer();
				if (nextParentModelElement != null && nextParentModelElement != this.projectSpace.getProject()) {
					addOneToParent(this.projectSpace.getProject().getModelElementId(nextParentModelElement));
				}
			}
		} else {
			number++;
		}
		modifiedModelElementParents.put(parentModelElementId, number);
	}

	/**
	 * @param childModelElementId the
	 * @return the model element id of the parent of the model element id passed as reference, or null if there is none
	 */
	private ModelElementId getNextParentModelElementId(ModelElementId childModelElementId) {
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
	 * @param modelElementId the
	 * @return the model element for the model element id passed as reference
	 */
	private EObject getModelElementForId(ModelElementId modelElementId) {
		return projectSpace.getProject().getModelElement(modelElementId);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.OperationListener#operationUnDone(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public void operationUnDone(AbstractOperation operation) {
		// remove from cache
		Set<ModelElementId> involvedMEs = operation.getAllInvolvedModelElements();
		for (ModelElementId childModelElementId : involvedMEs) {
			// update the model elements directly affected by the changes to the list of modified model elements
			if (modifiedModelElements.containsKey(childModelElementId)) {
				modifiedModelElements.get(childModelElementId).remove(operation);
				if (modifiedModelElements.get(childModelElementId).size() == 0) {
					modifiedModelElements.remove(childModelElementId);
					removeOneFromParent(childParentMapping.get(childModelElementId));
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.CommitObserver#commitCompleted(org.unicase.workspace.ProjectSpace,
	 *      org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec)
	 */
	public void commitCompleted(ProjectSpace projectSpace, PrimaryVersionSpec newRevision) {
		// do the same as when project has been shared
		shareDone();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.CommitObserver#inspectChanges(org.unicase.workspace.ProjectSpace,
	 *      org.unicase.emfstore.esmodel.versioning.ChangePackage)
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
