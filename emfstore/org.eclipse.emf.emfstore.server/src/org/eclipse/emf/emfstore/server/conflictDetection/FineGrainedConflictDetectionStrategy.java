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
package org.eclipse.emf.emfstore.server.conflictDetection;

import java.util.Set;

import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AttributeOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.DiagramLayoutOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.FeatureOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceMoveOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.ReferenceOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.SingleReferenceOperation;

/**
 * A conflict detection strategy that will operate on a per attribute and feature level.
 * 
 * @author koegel
 */
public class FineGrainedConflictDetectionStrategy implements ConflictDetectionStrategy {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.conflictDetection.ConflictDetectionStrategy#doConflict(org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation,
	 *      org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation)
	 */
	public boolean doConflict(AbstractOperation operationA, AbstractOperation operationB) {
		if (operationA instanceof DiagramLayoutOperation) {
			return doConflict((DiagramLayoutOperation) operationA, operationB);

		} else if (operationA instanceof AttributeOperation) {
			return doConflict((AttributeOperation) operationA, operationB);
		} else if (operationA instanceof MultiReferenceMoveOperation) {
			return doConflict((MultiReferenceMoveOperation) operationA, operationB);
		} else if (operationA instanceof SingleReferenceOperation) {
			return doConflict((SingleReferenceOperation) operationA, operationB);
		} else if (operationA instanceof MultiReferenceOperation) {
			return doConflict((MultiReferenceOperation) operationA, operationB);
		} else if (operationA instanceof CreateDeleteOperation) {
			return doConflict((CreateDeleteOperation) operationA, operationB);
		} else if (operationA instanceof CompositeOperation) {
			return doConflict((CompositeOperation) operationA, operationB);
		}
		throw new IllegalArgumentException("Unkown operation type: " + operationA);

	}

	private boolean doConflict(MultiReferenceOperation operationA, AbstractOperation operationB) {
		if (operationB instanceof AttributeOperation) {
			return false;
		} else if (operationB instanceof MultiReferenceMoveOperation) {
			boolean sameFeature = ((FeatureOperation) operationA).getFeatureName().equals(
				((MultiReferenceMoveOperation) operationB).getFeatureName());
			boolean sameElement = operationA.getModelElementId().equals(operationB.getModelElementId());
			return sameElement && sameFeature;
		} else if (operationB instanceof ReferenceOperation) {
			// MK split by multireference and singlereference
			MultiReferenceOperation multiOperationA = operationA;
			ReferenceOperation referenceOperationB = (ReferenceOperation) operationB;
			boolean sameFeature = multiOperationA.getFeatureName().equals(referenceOperationB.getFeatureName());
			// check if they really overlap
			boolean sameElement = multiOperationA.getModelElementId().equals(referenceOperationB.getModelElementId());
			if (sameFeature && sameElement) {
				Set<ModelElementId> otherInvolvedModelElements = operationA.getOtherInvolvedModelElements();
				for (ModelElementId modelElementId : operationA.getReferencedModelElements()) {
					if (otherInvolvedModelElements.contains(modelElementId)) {
						return true;
					}
				}
			}
			if (multiOperationA.getOppositeFeatureName() != null) {
				sameFeature = multiOperationA.getOppositeFeatureName().equals(referenceOperationB.getFeatureName());

			}

			return false;
		} else {
			return doConflict(operationB, operationA);
		}
	}

	private boolean doConflict(CompositeOperation operationA, AbstractOperation operationB) {
		for (AbstractOperation subOperationA : operationA.getSubOperations()) {
			if (doConflict(subOperationA, operationB)) {
				return true;
			}
		}
		return false;
	}

	private boolean doConflict(DiagramLayoutOperation operationA, AbstractOperation operationB) {
		if (operationB instanceof DiagramLayoutOperation) {
			return operationA.getModelElementId().equals(operationA.getModelElementId());
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.conflictDetection.ConflictDetectionStrategy#isRequired(org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation,
	 *      org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation)
	 */
	public boolean isRequired(AbstractOperation requiredOperation, AbstractOperation operation) {
		if (requiredOperation instanceof CreateDeleteOperation) {
			return isRequired((CreateDeleteOperation) requiredOperation, operation);
		} else if (requiredOperation instanceof MultiReferenceOperation
			&& operation instanceof MultiReferenceMoveOperation) {
			return isRequired((MultiReferenceOperation) requiredOperation, (MultiReferenceMoveOperation) operation);
		} else if (requiredOperation instanceof MultiReferenceOperation && operation instanceof MultiReferenceOperation) {
			return isRequired((MultiReferenceOperation) requiredOperation, (MultiReferenceOperation) operation);
		} else if (requiredOperation instanceof CompositeOperation) {
			for (AbstractOperation abstractOperation : ((CompositeOperation) requiredOperation).getSubOperations()) {
				if (isRequired(abstractOperation, operation)) {
					return true;
				}
			}
			return false;
		} else if (operation instanceof CompositeOperation) {
			for (AbstractOperation abstractOperation : ((CompositeOperation) operation).getSubOperations()) {
				if (isRequired(requiredOperation, abstractOperation)) {
					return true;
				}
			}
			return false;
		}
		return false;
	}

	private boolean isRequired(MultiReferenceOperation requiredMultiReferenceOperation,
		MultiReferenceOperation multiReferenceOperation) {
		boolean sameElement = requiredMultiReferenceOperation.getModelElementId().equals(
			multiReferenceOperation.getModelElementId());
		boolean sameFeature = requiredMultiReferenceOperation.getFeatureName().equals(
			multiReferenceOperation.getFeatureName());
		if (sameElement && sameFeature && requiredMultiReferenceOperation.isAdd() && !multiReferenceOperation.isAdd()) {
			for (ModelElementId modelElementId : multiReferenceOperation.getReferencedModelElements()) {
				if (requiredMultiReferenceOperation.getReferencedModelElements().contains(modelElementId)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isRequired(MultiReferenceOperation requiredMultiReferenceOperation,
		MultiReferenceMoveOperation moveOperation) {
		boolean sameElement = requiredMultiReferenceOperation.getModelElementId().equals(
			moveOperation.getModelElementId());
		boolean sameFeature = requiredMultiReferenceOperation.getFeatureName().equals(moveOperation.getFeatureName());
		if (sameElement && sameFeature) {
			for (ModelElementId modelElementId : requiredMultiReferenceOperation.getReferencedModelElements()) {
				if (modelElementId.equals(moveOperation.getReferencedModelElementId())) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isRequired(CreateDeleteOperation requiredOperation, AbstractOperation operation) {
		if (!requiredOperation.isDelete()) {
			if (operation instanceof FeatureOperation) {
				if (operation.getModelElementId().equals(requiredOperation.getModelElementId())) {
					return true;
				}
				if (operation instanceof ReferenceOperation) {
					return ((ReferenceOperation) operation).getOtherInvolvedModelElements().contains(
						requiredOperation.getModelElementId());
				}
				if (operation instanceof MultiReferenceMoveOperation) {
					return ((MultiReferenceMoveOperation) operation).getReferencedModelElementId().equals(
						requiredOperation);
				}
				return false;
			} else if (operation instanceof CompositeOperation) {
				for (AbstractOperation abstractOperation : ((CompositeOperation) operation).getSubOperations()) {
					if (isRequired(requiredOperation, abstractOperation)) {
						return true;
					}
				}
				return false;
			} else if (operation instanceof CreateDeleteOperation) {
				return (((CreateDeleteOperation) operation).isDelete());
			}
		}
		return false;
	}

	private boolean doConflict(CreateDeleteOperation operationA, AbstractOperation operationB) {
		if (operationB instanceof CompositeOperation) {
			return doConflict(operationB, operationA);
		}
		if (operationB instanceof ReferenceOperation) {
			for (ModelElementId modelElementId : ((ReferenceOperation) operationB).getOtherInvolvedModelElements()) {
				if (operationA.getModelElementId().equals(modelElementId)) {
					return true;
				}
			}
		}
		return operationA.getModelElementId().equals(operationB.getModelElementId());
	}

	private boolean doConflict(AttributeOperation operationA, AbstractOperation operationB) {
		if (!operationA.getModelElementId().equals(operationB.getModelElementId())) {
			return false;
		}
		if (operationB instanceof FeatureOperation) {
			FeatureOperation featureOperationB = (FeatureOperation) operationB;
			return featureOperationB.getFeatureName().equals(operationA.getFeatureName());
		}
		return doConflict(operationB, operationA);
	}

	private boolean doConflict(MultiReferenceMoveOperation operationA, AbstractOperation operationB) {
		if (operationB instanceof MultiReferenceMoveOperation) {
			boolean sameElement = operationA.getModelElementId().equals(operationB.getModelElementId());
			boolean sameFeature = operationA.getFeatureName().equals(
				((MultiReferenceMoveOperation) operationB).getFeatureName());
			return sameElement && sameFeature;
		} else if (operationB instanceof AttributeOperation) {
			return false;
		}
		return doConflict(operationB, operationA);
	}

	private boolean doConflict(SingleReferenceOperation operationA, AbstractOperation operationB) {
		if (operationB instanceof SingleReferenceOperation) {
			ReferenceOperation singleOperationB = (SingleReferenceOperation) operationB;
			boolean sameFeature = operationA.getFeatureName().equals(singleOperationB.getFeatureName());
			if (operationA.getOppositeFeatureName() != null) {
				sameFeature = sameFeature
					|| operationA.getOppositeFeatureName().equals(singleOperationB.getFeatureName());
			}
			boolean sameElement = operationA.getModelElementId().equals(operationB.getModelElementId());
			return sameFeature && sameElement;
		} else if (operationB instanceof AttributeOperation) {
			return false;
		} else if (operationB instanceof MultiReferenceMoveOperation) {
			return false;
		}
		return doConflict(operationB, operationA);
	}
}
