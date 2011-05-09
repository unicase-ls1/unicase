/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.conflictDetection;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;

/**
 * Detects conflicts by documents.
 * 
 * @author koegel
 */
public class ByDocumentConflictDetectionStrategy implements ConflictDetectionStrategy {

	private Project project;

	/**
	 * Set the project that is currently valid for the detection of the conflicts.
	 * 
	 * @param project the current project
	 * @return
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.conflictDetection.ConflictDetectionStrategy#doConflict(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation,
	 *      org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public boolean doConflict(AbstractOperation operationA, AbstractOperation operationB) {
		Set<ModelElementId> allInvolvedModelElementsA = operationA.getAllInvolvedModelElements();
		Set<ModelElementId> allInvolvedModelElementsB = operationB.getAllInvolvedModelElements();
		Set<EObject> allInvolvedRootElementsA = new HashSet<EObject>();
		Set<EObject> allInvolvedRootElementsB = new HashSet<EObject>();
		for (ModelElementId modelElementId : allInvolvedModelElementsA) {
			EObject modelElement = project.getModelElement(modelElementId);
			if (modelElement == null) {
				continue;
			}
			allInvolvedRootElementsA.add(getRootLevelParent(modelElement));
		}
		for (ModelElementId modelElementId : allInvolvedModelElementsB) {
			EObject modelElement = project.getModelElement(modelElementId);
			if (modelElement == null) {
				continue;
			}
			allInvolvedRootElementsB.add(getRootLevelParent(modelElement));
		}
		return allInvolvedRootElementsA.removeAll(allInvolvedRootElementsB);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.conflictDetection.ConflictDetectionStrategy#isRequired(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation,
	 *      org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public boolean isRequired(AbstractOperation requiredOperation, AbstractOperation operation) {
		return this.doConflict(requiredOperation, operation);
	}

	private EObject getRootLevelParent(EObject modelElement) {
		EObject parent = modelElement;
		EObject nextParent = modelElement.eContainer();
		while (nextParent != null) {
			parent = nextParent;
			nextParent = nextParent.eContainer();
		}
		return parent;
	}

}
