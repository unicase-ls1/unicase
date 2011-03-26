/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.eclipse.emf.emfstore.server.model.versioning.operations.util;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AttributeOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.util.ModelUtil;

/**
 * Canonizes a list of operations. Removes all operations that are not necessary to achieve the same result when the
 * list of operations is applied to a project. Contract: project.apply(opList) = project.apply(cannonizedOpList)
 * 
 * @author koegel
 */
public final class OperationsCanonizer {

	/**
	 * Private constructor.
	 */
	private OperationsCanonizer() {
		// do nothing
	}

	/**
	 * Canonize the operation list.
	 * 
	 * @param operations a list of operations (the list is order by creation time)
	 */
	public static void canonize(List<AbstractOperation> operations) {

		try {
			foldComposites(operations);
			foldAttributes(operations);
			foldAttributesIntoCreates(operations);
			foldAttributesIntoDeletes(operations);
			foldCreatesAndDeletes(operations);

			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (RuntimeException e) {
			ModelUtil.log("Runtime exception in " + OperationsCanonizer.class.getName(), e, IStatus.ERROR);
		}
		// END SUPRESS CATCH EXCEPTION

	}

	// neighbouring create and delete will be removed
	private static void foldCreatesAndDeletes(List<AbstractOperation> operations) {

		for (int i = 0; i < operations.size() - 1; i++) {

			// look for a create operation
			AbstractOperation opLeft = operations.get(i);
			if (!(opLeft instanceof CreateDeleteOperation)) {
				continue;
			}
			CreateDeleteOperation createOp = (CreateDeleteOperation) opLeft;

			if (createOp.isDelete()) {
				continue;
			}

			// ok, we got one, see if the next one is a matching delete
			AbstractOperation opRight = operations.get(i + 1);
			if (!(opRight instanceof CreateDeleteOperation)) {
				continue;
			}
			CreateDeleteOperation deleteOp = (CreateDeleteOperation) opRight;

			if (!deleteOp.isDelete()) {
				continue;
			}

			// ok, we got a create followed by a delete, if they have matching ids, remove them

			if (createOp.getModelElementId().equals(deleteOp.getModelElementId())) {
				// remove both
				operations.remove(i + 1);
				operations.remove(i);
				i = Math.max(0, i - 2); // reexamine the preceeding index

			}

		}

	}

	private static void foldAttributesIntoCreates(List<AbstractOperation> operations) {

		// look for suitable create operation
		for (int i = 0; i < operations.size() - 1; i++) {

			AbstractOperation opLeft = operations.get(i);
			if (!(opLeft instanceof CreateDeleteOperation)) {
				continue;
			}
			CreateDeleteOperation createOp = (CreateDeleteOperation) opLeft;

			if (createOp.isDelete()) {
				continue;
			}

			// found valid create operation, now looking for attribute operations for
			// the new object
			for (int j = i + 1; j < operations.size(); j++) {

				AbstractOperation opRight = operations.get(j);

				if (opRight instanceof AttributeOperation
					&& opLeft.getModelElementId().equals(opRight.getModelElementId())) {

					AttributeOperation attOp = (AttributeOperation) opRight;
					// found an attribute change for the new object
					// now merge it into the created object and discard the attribute operation
					EStructuralFeature feature = createOp.getModelElement().eClass()
						.getEStructuralFeature(attOp.getFeatureName());
					createOp.getModelElement().eSet(feature, attOp.getNewValue());

					operations.remove(j); // remove attribute operation
					j--; // reexamine the index after removal

				}

				// stop if a composite operation occurs, that contains an attribute operation on created object
				if (opRight instanceof CompositeOperation) {

					if (containsAttributeChangeTo((CompositeOperation) opRight, createOp.getModelElementId())) {
						break;
					}

				}

			}

		}

	}

	private static void foldAttributesIntoDeletes(List<AbstractOperation> operations) {

		// look for suitable delete operation
		for (int i = operations.size() - 1; i > 0 && i < operations.size(); i--) {

			AbstractOperation opRight = operations.get(i);
			if (!(opRight instanceof CreateDeleteOperation)) {
				continue;
			}
			CreateDeleteOperation deleteOp = (CreateDeleteOperation) opRight;

			if (!deleteOp.isDelete()) {
				continue;
			}

			// found valid delete operation, now looking for attribute operations for
			// the object
			for (int j = i - 1; j >= 0; j--) {

				AbstractOperation opLeft = operations.get(j);

				if (opLeft instanceof AttributeOperation
					&& opRight.getModelElementId().equals(opLeft.getModelElementId())) {

					AttributeOperation attOp = (AttributeOperation) opLeft;
					// found an attribute change for the object, that is deleted
					// now merge it into the deleted object and discard the attribute operation
					EStructuralFeature feature = deleteOp.getModelElement().eClass()
						.getEStructuralFeature(attOp.getFeatureName());
					deleteOp.getModelElement().eSet(feature, attOp.getOldValue());

					operations.remove(j); // remove attribute operation
					i--; // keep main loop consistent

				}

				// stop if a composite operation occurs, that contains an attribute operation on created object
				if (opLeft instanceof CompositeOperation) {

					if (containsAttributeChangeTo((CompositeOperation) opLeft, deleteOp.getModelElementId())) {
						break;
					}

				}

			}

		}

	}

	private static boolean containsAttributeChangeTo(CompositeOperation comp, ModelElementId modelElementId) {

		for (AbstractOperation op : comp.getSubOperations()) {

			if (op instanceof AttributeOperation && modelElementId.equals(op.getModelElementId())) {
				return true;
			}

		}

		return false;
	}

	private static void foldComposites(List<AbstractOperation> operations) {

		List<CompositeOperation> emptyComposites = new LinkedList<CompositeOperation>();
		for (AbstractOperation op : operations) {

			if (!(op instanceof CompositeOperation)) {
				continue;
			}
			CompositeOperation comp = (CompositeOperation) op;

			// safeguard preparation: if the main operation of the composite has been canonized away,
			// the canonization is reverted. This generates more operations,
			// but leaves the "intention" of the composite intact.
			AbstractOperation operationCopy = null;

			if (comp.getMainOperation() != null) {
				operationCopy = ModelUtil.clone(comp);
				// operationCopy = ModelUtil.eObjectToString(comp);
			}

			OperationsCanonizer.canonize(comp.getSubOperations());
			if (comp.getSubOperations().size() == 0) {
				emptyComposites.add(comp);
			}
			// safeguard implementation: restore original composite operation if the main operation has been canonized
			// away
			else if (comp.getMainOperation() != null && !comp.getSubOperations().contains(comp.getMainOperation())) {

				CompositeOperation restored = (CompositeOperation) operationCopy;
				comp.getSubOperations().clear();
				comp.getSubOperations().addAll(restored.getSubOperations());
				comp.setMainOperation(restored.getMainOperation());
			}
		}
		operations.removeAll(emptyComposites);
	}

	private static void foldAttributes(List<AbstractOperation> operations) {

		for (int i = 0; i < operations.size() - 1; i++) {

			AbstractOperation opLeft = operations.get(i);
			if (!(opLeft instanceof AttributeOperation)) {
				continue;
			}
			AttributeOperation attOpLeft = (AttributeOperation) opLeft;

			for (int j = i + 1; j < operations.size(); j++) {

				AbstractOperation opRight = operations.get(j);

				if (opRight instanceof AttributeOperation
					&& opLeft.getModelElementId().equals(opRight.getModelElementId())) {

					AttributeOperation attOpRight = (AttributeOperation) opRight;
					if (attOpLeft.getFeatureName().equals(attOpRight.getFeatureName())) {
						// merge opLeft and opRight in opLeft
						attOpLeft.setNewValue(attOpRight.getNewValue());
						operations.remove(j); // remove opRight
						j--; // reexamine the index after removal
					}

				}

				if (opRight instanceof CreateDeleteOperation || opRight instanceof CompositeOperation) {
					break;
				}

			}
			// if the remaining leftOp is a noop, remove it altogether
			if ((attOpLeft.getNewValue() == null && attOpLeft.getOldValue() == null)
				|| (attOpLeft.getNewValue() != null && attOpLeft.getNewValue().equals(attOpLeft.getOldValue()))) {
				operations.remove(i);
				i--; // reexamine the index after removal
			}

		}

	}
}
