/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.emfstore.esmodel.versioning.operations.util;

import java.util.LinkedList;
import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;

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

		foldComposites(operations);
		foldAttributes(operations);
	}

	private static void foldComposites(List<AbstractOperation> operations) {

		List<CompositeOperation> emptyComposites = new LinkedList<CompositeOperation>();
		for (AbstractOperation op : operations) {

			if (!(op instanceof CompositeOperation)) {
				continue;
			}
			CompositeOperation comp = (CompositeOperation) op;
			OperationsCanonizer.canonize(comp.getSubOperations());
			if (comp.getSubOperations().size() == 0) {
				emptyComposites.add(comp);
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
				|| attOpLeft.getNewValue().equals(attOpLeft.getOldValue())) {
				operations.remove(i);
				i--; // reexamine the index after removal
			}

		}

	}
}
