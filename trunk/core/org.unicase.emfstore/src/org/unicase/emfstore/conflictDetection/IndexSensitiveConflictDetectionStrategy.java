/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.conflictDetection;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.util.OperationInfo;
import org.unicase.model.ModelElementId;

/**
 * A conflict detection strategy that will operate on a per attribute and feature level.
 * 
 * @author koegel
 */
public class IndexSensitiveConflictDetectionStrategy implements ConflictDetectionStrategy {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.conflictDetection.ConflictDetectionStrategy#doConflict(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation,
	 *      org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public boolean doConflict(AbstractOperation operationA, AbstractOperation operationB) {

		if (operationA instanceof CompositeOperation) {
			CompositeOperation compA = (CompositeOperation) operationA;
			for (AbstractOperation op : compA.getSubOperations()) {
				if (doConflict(op, operationB)) {
					return true;
				}
			}
			return false;
		} else if (operationB instanceof CompositeOperation) {
			CompositeOperation compB = (CompositeOperation) operationB;
			for (AbstractOperation op : compB.getSubOperations()) {
				if (doConflict(operationA, op)) {
					return true;
				}
			}
			return false;
		}

		return doConflictHard(operationA, operationB);

	}

	private boolean doConflictHard(AbstractOperation operationA, AbstractOperation operationB) {

		if (operationA instanceof CreateDeleteOperation) {
			return doConflictHardCreateDelete((CreateDeleteOperation) operationA, operationB);
		}

		if (operationB instanceof CreateDeleteOperation) {
			return doConflictHardCreateDelete((CreateDeleteOperation) operationB, operationA);
		}

		if (operationA instanceof AttributeOperation && operationB instanceof AttributeOperation) {
			return doConflictHardAttributes((AttributeOperation) operationA, (AttributeOperation) operationB);
		}

		if (operationA instanceof SingleReferenceOperation && operationB instanceof SingleReferenceOperation) {
			return doConflictHardSingleReferences((SingleReferenceOperation) operationA,
				(SingleReferenceOperation) operationB);
		}

		if (operationA instanceof SingleReferenceOperation && operationB instanceof MultiReferenceOperation) {
			return doConflictHardSingleMultiReferences((SingleReferenceOperation) operationA,
				(MultiReferenceOperation) operationB);
		}

		if (operationA instanceof MultiReferenceOperation && operationB instanceof SingleReferenceOperation) {
			return doConflictHardSingleMultiReferences((SingleReferenceOperation) operationB,
				(MultiReferenceOperation) operationA);
		}

		if (operationA instanceof MultiReferenceOperation && operationB instanceof MultiReferenceOperation) {
			return doConflictHardMultiReferences((MultiReferenceOperation) operationA,
				(MultiReferenceOperation) operationB);
		}

		return false;
	}

	private boolean doConflictHardCreateDelete(CreateDeleteOperation opA, AbstractOperation opB) {
		// creates do not conflict with anything, by definition
		if (isCreateOperation(opA)) {
			return false;
		}

		if (isCreateOperation(opB)) {
			return false;
		}
		// we have a delete here
		// if the other operation changes any involved element, this is a conflict
		// (this rule might technically be reduced to "otherInvolvedElements")
		// reason why this always conflicts: there is no way to tell if the
		// change was a containment change within the deletion tree. If so, a hard
		// conflict arises, if not, it's not even important. But... we can't tell, because
		// the model is not available to answer that question.
		for (ModelElementId m : opA.getAllInvolvedModelElements()) {
			if (OperationInfo.changesModelElement(opB, m)) {
				return true;
			}
		}

		return false;
	}

	private boolean doConflictHardMultiReferences(MultiReferenceOperation opA, MultiReferenceOperation opB) {

		// 4 cases to check
		// regular vs. regular
		// regular vs. opposite
		// opposite vs. regular
		// opposite vs. opposite

		// case 1: regular vs. regular
		if (opA.getModelElementId().equals(opB.getModelElementId())
			&& opA.getFeatureName().equals(opB.getFeatureName())) {

			// if add and remove meet, there might be a hard conflict
			if (opA.isAdd() != opB.isAdd()) {

				for (ModelElementId mA : opA.getOtherInvolvedModelElements()) {

					for (ModelElementId mB : opB.getOtherInvolvedModelElements()) {

						if (mA.equals(mB)) {
							return true;
						}
					}
				}

			}
			return false;

		}

		// case 2: regular vs. opposite
		if (opA.getFeatureName().equals(opB.getOppositeFeatureName())) {

			// if add and remove meet, there might be a hard conflict (opposite is added to when regular is added to,
			// and removed from when regular also removes)
			if (opA.isAdd() != opB.isAdd()) {

				ModelElementId mA = opA.getModelElementId();

				for (ModelElementId mB : opB.getOtherInvolvedModelElements()) {

					if (mA.equals(mB)) {
						return true;
					}
				}
			}

		}

		// case 3: opposite vs. regular
		if (opB.getFeatureName().equals(opA.getOppositeFeatureName())) {

			// if add and remove meet, there might be a hard conflict (opposite is added to when regular is added to,
			// and removed from when regular also removes)
			if (opA.isAdd() != opB.isAdd()) {

				ModelElementId mB = opB.getModelElementId();

				for (ModelElementId mA : opA.getOtherInvolvedModelElements()) {

					if (mA.equals(mB)) {
						return true;
					}
				}

			}

		}

		// case 4: opposite vs. opposite
		if (opB.getOppositeFeatureName().equals(opA.getOppositeFeatureName())) {
			for (ModelElementId mA : opA.getOtherInvolvedModelElements()) {

				for (ModelElementId mB : opB.getOtherInvolvedModelElements()) {

					if (mA.equals(mB)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean doConflictHardSingleMultiReferences(SingleReferenceOperation opA, MultiReferenceOperation opB) {

		// 1 possible case to check
		// regular vs. opposite

		// case 1: regular vs. opposite
		if (opA.getFeatureName().equals(opB.getOppositeFeatureName())) {

			for (ModelElementId m : opB.getOtherInvolvedModelElements()) {
				if (m.equals(opA.getModelElementId())) {

					if (opB.isAdd()) {
						if (isDifferent(opA.getNewValue(), opB.getModelElementId())) {
							return true;
						}
					} else if (isDifferent(opA.getNewValue(), null)) {
						return true;
					}

				}
			}
		}

		return false;
	}

	private boolean doConflictHardSingleReferences(SingleReferenceOperation opA, SingleReferenceOperation opB) {

		// 4 possible cases to check:
		// regular vs. regular
		// regular vs. opposite
		// opposite vs. regular
		// opposite vs. opposite

		// case 1: regular vs. regular
		if (opA.getModelElementId().equals(opB.getModelElementId())
			&& opA.getFeatureName().equals(opB.getFeatureName())) {
			// unless both operations set the same new value
			if (isDifferent(opA.getNewValue(), opB.getNewValue())) {
				return true;
			}
			return false;

		}

		// case 2: regular vs. opposite
		if (opA.getFeatureName().equals(opB.getOppositeFeatureName())) {
			for (ModelElementId m : opB.getOtherInvolvedModelElements()) {
				if (m.equals(opA.getModelElementId()) && isDifferent(opA.getNewValue(), opB.getModelElementId())) {
					return true;
				}
			}
		}

		// case 3: opposite vs. regular
		if (opB.getFeatureName().equals(opA.getOppositeFeatureName())) {
			for (ModelElementId m : opA.getOtherInvolvedModelElements()) {
				if (m.equals(opB.getModelElementId()) && isDifferent(opB.getNewValue(), opA.getModelElementId())) {
					return true;
				}
			}
		}

		// case 4: opposite vs. opposite
		if (opB.getOppositeFeatureName().equals(opA.getOppositeFeatureName())) {
			for (ModelElementId mA : opA.getOtherInvolvedModelElements()) {

				for (ModelElementId mB : opB.getOtherInvolvedModelElements()) {

					if (mA.equals(mB)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private boolean doConflictHardAttributes(AttributeOperation opA, AttributeOperation opB) {

		// if same object's same feature is set, there's a potential conflict
		if (opA.getModelElementId().equals(opB.getModelElementId())
			&& opA.getFeatureName().equals(opB.getFeatureName())) {

			// unless both operations set the same new value
			if (isSame(opA.getNewValue(), opB.getNewValue())) {
				return false;
			}
			return true;

		}

		return false;

	}

	public boolean doConflictIndexIntegrity(AbstractOperation operationA, AbstractOperation operationB) {

		if (operationA instanceof CompositeOperation) {
			CompositeOperation compA = (CompositeOperation) operationA;
			for (AbstractOperation op : compA.getSubOperations()) {
				if (doConflictIndexIntegrity(op, operationB)) {
					return true;
				}
			}
			return false;
		} else if (operationB instanceof CompositeOperation) {
			CompositeOperation compB = (CompositeOperation) operationB;
			for (AbstractOperation op : compB.getSubOperations()) {
				if (doConflictIndexIntegrity(operationA, op)) {
					return true;
				}
			}
			return false;
		}

		if (operationA instanceof MultiReferenceOperation && operationB instanceof MultiReferenceOperation) {
			return doConflictIndexIntegrityMultiReferences((MultiReferenceOperation) operationA,
				(MultiReferenceOperation) operationB);
		}

		if (operationA instanceof SingleReferenceOperation && operationB instanceof MultiReferenceOperation) {
			return doConflictIndexIntegritySingleMultiReferences((SingleReferenceOperation) operationA,
				(MultiReferenceOperation) operationB);
		}

		if (operationB instanceof SingleReferenceOperation && operationA instanceof MultiReferenceOperation) {
			return doConflictIndexIntegritySingleMultiReferences((SingleReferenceOperation) operationB,
				(MultiReferenceOperation) operationA);
		}

		if (operationA instanceof MultiReferenceMoveOperation && operationB instanceof MultiReferenceMoveOperation) {
			return doConflictIndexIntegrityMultiMoveReferences((MultiReferenceMoveOperation) operationA,
				(MultiReferenceMoveOperation) operationB);
		}

		if (operationA instanceof MultiReferenceMoveOperation && operationB instanceof MultiReferenceOperation) {
			return doConflictIndexIntegrityMultiMoveMultiReferences((MultiReferenceMoveOperation) operationA,
				(MultiReferenceOperation) operationB);
		}

		if (operationB instanceof MultiReferenceMoveOperation && operationA instanceof MultiReferenceOperation) {
			return doConflictIndexIntegrityMultiMoveMultiReferences((MultiReferenceMoveOperation) operationB,
				(MultiReferenceOperation) operationA);
		}

		if (operationA instanceof MultiReferenceMoveOperation && operationB instanceof SingleReferenceOperation) {
			return doConflictIndexIntegrityMultiMoveSingleReferences((MultiReferenceMoveOperation) operationA,
				(SingleReferenceOperation) operationB);
		}

		if (operationB instanceof MultiReferenceMoveOperation && operationA instanceof SingleReferenceOperation) {
			return doConflictIndexIntegrityMultiMoveSingleReferences((MultiReferenceMoveOperation) operationB,
				(SingleReferenceOperation) operationA);
		}

		if (operationA instanceof MultiReferenceMoveOperation && operationB instanceof SingleReferenceOperation) {
			return doConflictIndexIntegrityMultiMoveSingleReferences((MultiReferenceMoveOperation) operationA,
				(SingleReferenceOperation) operationB);
		}

		if (operationA instanceof SingleReferenceOperation && operationB instanceof SingleReferenceOperation) {
			return doConflictIndexIntegritySingleReferences((SingleReferenceOperation) operationA,
				(SingleReferenceOperation) operationB);
		}

		return false;
	}

	private boolean doConflictIndexIntegritySingleReferences(SingleReferenceOperation opA, SingleReferenceOperation opB) {
		// 1 case only
		// opposite vs. opposite

		// index integrity can only be broken, if both are added to the same feature
		if (isDifferent(opA.getNewValue(), opB.getNewValue())) {
			return false;
		}

		// identical ops don't conflict
		if (opB.getModelElementId().equals(opA.getModelElementId()) && isSame(opA.getOldValue(), opB.getOldValue())) {
			return false;
		}

		if (opB.getOppositeFeatureName().equals(opA.getOppositeFeatureName())) {
			for (ModelElementId mA : opA.getOtherInvolvedModelElements()) {

				for (ModelElementId mB : opB.getOtherInvolvedModelElements()) {

					// index integrity breaks only if the operations weren't identical
					if (mA.equals(mB)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private boolean doConflictIndexIntegrityMultiMoveSingleReferences(MultiReferenceMoveOperation opA,
		SingleReferenceOperation opB) {

		// 1 case only
		// regular vs. opposite

		if (opA.getFeatureName().equals(opB.getOppositeFeatureName())) {

			// might conflict for equal elements
			if (isSame(opB.getNewValue(), opA.getModelElementId())
				&& isSame(opB.getModelElementId(), opA.getReferencedModelElementId())) {
				return true;
			}
			// might conflict for different manipulated elements as well, if the move's
			// target is the last index, we can't tell from here, so the assumption is, that it conflicts
			// potentiality is there
			else if (isSame(opB.getNewValue(), opA.getModelElementId())) {
				return true;
			}

		}
		return false;
	}

	private boolean doConflictIndexIntegrityMultiMoveMultiReferences(MultiReferenceMoveOperation opA,
		MultiReferenceOperation opB) {

		// 2 cases
		// regular vs. regular
		// regular vs. opposite

		// regular vs. regular
		if (opA.getModelElementId().equals(opB.getModelElementId())
			&& opA.getFeatureName().equals(opB.getFeatureName())) {

			if (containsId(opB.getReferencedModelElements(), opA.getReferencedModelElementId())) {
				if (opB.isAdd()) {
					return true;
				}
				return false;

			} else {
				// so there is an add or remove and a move going on on different objects but on the same feature
				if (opB.isAdd() && opB.getIndex() >= opA.getNewIndex()) {
					return true;
				} else if (!opB.isAdd() && opB.getIndex() < opA.getNewIndex()) {
					return true;
				}
				return false;

			}

		}

		// regular vs. opposite
		if (opA.getFeatureName().equals(opB.getOppositeFeatureName())) {

			if (containsId(opB.getReferencedModelElements(), opA.getModelElementId())) {

				if (opA.getReferencedModelElementId().equals(opB.getModelElementId())) {
					if (opB.isAdd()) {
						return true;
					}
				} else {
					return true;
				}
			}
		}

		return false;
	}

	private boolean doConflictIndexIntegrityMultiMoveReferences(MultiReferenceMoveOperation opA,
		MultiReferenceMoveOperation opB) {

		if (opA.getModelElementId().equals(opB.getModelElementId())
			&& opA.getFeatureName().equals(opB.getFeatureName())) {

			if (opA.getReferencedModelElementId().equals(opB.getReferencedModelElementId())) {
				return opA.getNewIndex() != opB.getNewIndex();
			} else {
				return opA.getNewIndex() == opB.getNewIndex();
			}

		}

		return false;
	}

	private boolean doConflictIndexIntegritySingleMultiReferences(SingleReferenceOperation opA,
		MultiReferenceOperation opB) {

		if (!opB.isAdd()) {
			return false;
		}

		// 1 case to look for
		// opposite vs. regular
		if (opB.getFeatureName().equals(opA.getOppositeFeatureName())) {

			ModelElementId mB = opB.getModelElementId();
			for (ModelElementId mA : opA.getOtherInvolvedModelElements()) {
				if (mA.equals(mB) && isDifferent(opB.getModelElementId(), opA.getNewValue())) {
					return true;
				}
			}

		}

		return false;
	}

	private boolean doConflictIndexIntegrityMultiReferences(MultiReferenceOperation opA, MultiReferenceOperation opB) {

		// 3 cases to look for
		// regular vs. regular
		// regular vs. opposite
		// opposite vs. regular

		// case 1: regular vs. regular
		if (opA.getModelElementId().equals(opB.getModelElementId())
			&& opA.getFeatureName().equals(opB.getFeatureName())) {
			if (opA.isAdd() && opB.isAdd()) {

				// make sure that some of the added things are different
				if (opA.getIndex() == opB.getIndex()) {
					for (ModelElementId mA : opA.getOtherInvolvedModelElements()) {
						for (ModelElementId mB : opB.getOtherInvolvedModelElements()) {
							// if all were the same, this would be identical operations, thus no index conflict
							if (!mA.equals(mB)) {
								return true;
							}
						}
					}
				} else {
					return true;
				}

			}

			if (opA.isAdd() != opB.isAdd()) {

				for (ModelElementId mA : opA.getOtherInvolvedModelElements()) {
					for (ModelElementId mB : opB.getOtherInvolvedModelElements()) {
						if (!mA.equals(mB)) {

							// if the remove index is smaller than the add index, there is an index integrity conflict

							if (opA.isAdd()) {
								return opA.getIndex() > opB.getIndex() && opA.getIndex() != 0 && opB.getIndex() != 0;
							} else {
								return opA.getIndex() < opB.getIndex() && opA.getIndex() != 0 && opB.getIndex() != 0;
							}

						}
					}
				}

			}
		}

		// case 2: regular vs. opposite
		if (opA.getFeatureName().equals(opB.getOppositeFeatureName())) {

			ModelElementId mA = opA.getModelElementId();
			for (ModelElementId mB : opB.getOtherInvolvedModelElements()) {
				if (mA.equals(mB)) {
					return true;
				}
			}

		}

		// case 3: opposite vs. regular
		if (opB.getFeatureName().equals(opA.getOppositeFeatureName())) {

			ModelElementId mB = opB.getModelElementId();
			for (ModelElementId mA : opA.getOtherInvolvedModelElements()) {
				if (mA.equals(mB)) {
					return true;
				}
			}

		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.conflictDetection.ConflictDetectionStrategy#isRequired(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation,
	 *      org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public boolean isRequired(AbstractOperation operationA, AbstractOperation operationB) {
		return false;
	}

	private static boolean isDifferent(Object a, Object b) {

		// if both are null, they are not different
		if (a == null && b == null) {
			return false;
		}

		// if either is null now, the other is not, so the objects ARE different
		if (a == null || b == null) {
			return true;
		}

		// if neither is null, let the objects sort out equality
		return !a.equals(b);
	}

	private static boolean isSame(Object a, Object b) {

		// if both are null, they are the same
		if (a == null && b == null) {
			return true;
		}

		// if either is null now, the other is not, so the objects ARE different
		if (a == null || b == null) {
			return false;
		}

		// if neither is null, let the objects sort out equality
		return a.equals(b);
	}

	private static boolean isCreateOperation(AbstractOperation op) {

		if (op instanceof CreateDeleteOperation) {
			CreateDeleteOperation cdop = (CreateDeleteOperation) op;
			return !cdop.isDelete();
		}
		return false;
	}

	private boolean containsId(Iterable<ModelElementId> list, ModelElementId id) {
		for (ModelElementId m : list) {
			if (m.equals(id)) {
				return true;
			}
		}
		return false;
	}

}
