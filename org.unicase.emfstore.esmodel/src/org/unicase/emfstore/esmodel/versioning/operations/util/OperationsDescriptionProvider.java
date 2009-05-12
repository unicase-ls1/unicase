/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.emfstore.esmodel.versioning.operations.util;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;

/**
 * Helper class, that generates verbose descriptions for versioning Operations.
 * 
 * @author chodnick
 */

public class OperationsDescriptionProvider {

	private Project project;

	/**
	 * @param project the project to fetch information from
	 */
	public OperationsDescriptionProvider(Project project) {
		super();
		this.project = project;
	}

	/**
	 * @param op the operation to generate a description for
	 * @return the description for given operation
	 */
	public String getDescription(AbstractOperation op) {

		// choose method to call based on operation type
		// anyone a better idea how to do this?
		if (op instanceof AttributeOperation) {
			return getDescriptionAttributeOperation((AttributeOperation) op);
		}
		if (op instanceof SingleReferenceOperation) {
			return getDescriptionSingleReferenceOperation((SingleReferenceOperation) op);
		}
		if (op instanceof MultiReferenceOperation) {
			return getDescriptionMultiReferenceOperation((MultiReferenceOperation) op);
		}
		if (op instanceof CreateDeleteOperation) {
			return getDescriptionCreateDeleteOperation((CreateDeleteOperation) op);
		}
		if (op instanceof MultiReferenceMoveOperation) {
			return getDescriptionMultiReferenceMoveOperation((MultiReferenceMoveOperation) op);
		}

		return getDescriptionUnknownOperation(op);

	}

	private String getDescriptionMultiReferenceMoveOperation(MultiReferenceMoveOperation op) {

		ModelElement elem = project.getModelElement(op.getReferencedModelElementId());
		String elemName = elem.eClass().getName() + " '" + elem.getName() + "'";

		return "reordered " + op.getFeatureName() + ", moved " + elemName + " from " + op.getOldIndex() + " to "
			+ op.getNewIndex();
	}

	private String getDescriptionCreateDeleteOperation(CreateDeleteOperation op) {

		if (op.isDelete()) {
			return "deleted " + op.getModelElement().eClass().getName() + " '" + op.getModelElement().getName() + "'";
		} else {
			return "created " + op.getModelElement().eClass().getName() + " '" + op.getModelElement().getName() + "'";
		}

	}

	private String getDescriptionMultiReferenceOperation(MultiReferenceOperation op) {

		String elemNames = getModelElementClassesAndNames(op.getReferencedModelElements());

		if (op.isAdd()) {
			// if adding to or removing from modelElements -> attach/detach operation in main tree
			if (op.getFeatureName().equals("modelElements")) {
				return "attached " + elemNames;
			} else {
				return "added " + elemNames + " to " + op.getFeatureName();
			}

		} else {

			if (op.getFeatureName().equals("modelElements")) {
				return "detached " + elemNames;
			} else {
				return "removed " + elemNames + " from " + op.getFeatureName();
			}
		}

	}

	private String getDescriptionSingleReferenceOperation(SingleReferenceOperation op) {

		ModelElement oldElement = project.getModelElement(op.getOldValue());
		ModelElement newElement = project.getModelElement(op.getNewValue());

		String oldName = (oldElement == null) ? "none" : oldElement.getName();
		String newName = (newElement == null) ? "none" : newElement.getName();

		// changing leafSections means relocating the item
		if (op.getFeatureName().equals("leafSection")) {
			return "relocated from '" + oldName + "' to '" + newName + "'";
		}
		// generic changing text
		else {
			return "changed " + op.getFeatureName() + " from '" + oldName + "' to '" + newName + "'";
		}

	}

	private String getDescriptionAttributeOperation(AttributeOperation op) {
		return "changed " + op.getFeatureName() + " from '" + op.getOldValue() + "' to '" + op.getNewValue() + "'";
	}

	private String getDescriptionUnknownOperation(AbstractOperation op) {
		return op.getClass().getSimpleName() + " " + op.getDescription();
	}

	/**
	 * Returns a comma separated list of class names and model names. {id1, id2} will become
	 * "Comment 'some comment', LeafSection 'section title'"
	 * 
	 * @param idList the list of model element IDs to return the names for
	 * @return
	 */
	private String getModelElementClassesAndNames(EList<ModelElementId> idList) {

		StringBuilder sb = new StringBuilder();
		for (ModelElementId id : idList) {

			if (project.getModelElement(id) != null) {
				sb.append(project.getModelElement(id).eClass().getName() + " '" + project.getModelElement(id).getName()
					+ "'");
				sb.append(", ");
			}
		}
		if (sb.length() > 2) {
			sb.delete(sb.length() - 2, sb.length());
		}

		return sb.toString();
	}
}
