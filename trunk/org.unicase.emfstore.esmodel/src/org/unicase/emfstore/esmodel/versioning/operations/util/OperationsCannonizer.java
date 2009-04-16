/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.emfstore.esmodel.versioning.operations.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.model.ModelElementId;

/**
 * Cannonizes a list of operations. Removes all operations that are not necessary to achieve the same result when the
 * list of operations is applied to a project. Contract: project.apply(opList) = project.apply(cannonizedOpList)
 * 
 * @author koegel
 */
public final class OperationsCannonizer {

	/**
	 * Private constructor.
	 */
	private OperationsCannonizer() {
		// do nothing
	}

	/**
	 * Cannonize the operation list.
	 * 
	 * @param operations a list of operations (the list is order by creation time)
	 */
	public static void cannonize(List<AbstractOperation> operations) {
		Map<ModelElementId, AbstractOperation> deletedElements = new HashMap<ModelElementId, AbstractOperation>();
		Map<String, AttributeOperation> changedAttributes = new HashMap<String, AttributeOperation>();
		HashMap<ModelElementId, Set<AttributeOperation>> modelElementAttributeChangeMap = new HashMap<ModelElementId, Set<AttributeOperation>>();
		Map<String, ReferenceOperation> changedReferences = new HashMap<String, ReferenceOperation>();

		Set<AbstractOperation> operationsToBeDeleted = new HashSet<AbstractOperation>();

		for (int i = operations.size() - 1; i >= 0; i--) {
			AbstractOperation operation = operations.get(i);
			if (operation instanceof CompositeOperation) {
				// FIXME MK: check if composite will be empty after cannonize:
				// FIXME MK: check if composite in context of cp
				((CompositeOperation) operation).cannonize();
				continue;
			}

			ModelElementId modelElementId = operation.getModelElementId();

			if (operation instanceof CreateDeleteOperation) {
				handleCreateDeleteOperation(deletedElements, modelElementAttributeChangeMap, operationsToBeDeleted,
					operation, modelElementId);
				continue;
			}
			if (operation instanceof AttributeOperation) {
				if (deletedElements.keySet().contains(modelElementId)) {
					operationsToBeDeleted.add(operation);
					continue;
				}

				handleAttributeOperation(changedAttributes, modelElementAttributeChangeMap, operationsToBeDeleted,
					operation);
				continue;
			}
			if (operation instanceof SingleReferenceOperation) {
				handleSingleRefOperation((SingleReferenceOperation) operation, changedReferences,
					operationsToBeDeleted, deletedElements);
				continue;
			}

			if (operation instanceof MultiReferenceOperation) {
				handleMultiRefOperation((MultiReferenceOperation) operation, changedReferences, operationsToBeDeleted,
					deletedElements);
				continue;
			}
			// nop
			// we do not aggregate MultiReferenceOperations since this might be
			// confusing for the user
			// we cannot aggregate operations we do not know
		}
		// remove all obsolete operations
		operations.removeAll(operationsToBeDeleted);
	}

	private static void aggregateMultiReferenceOperations(MultiReferenceOperation multiReferenceOperation,
		Map<String, ReferenceOperation> changedReferences, Set<AbstractOperation> operationsToBeDeleted, String key) {
		// aggregate the two multi reference changes if possible
		MultiReferenceOperation lastMultiReferenceOperation = (MultiReferenceOperation) changedReferences.get(key);
		// the two ops must be both remvoe
		EList<ModelElementId> referencedModelElements = multiReferenceOperation.getReferencedModelElements();
		EList<ModelElementId> referencedModelElementsOfLast = lastMultiReferenceOperation.getReferencedModelElements();
		if (!multiReferenceOperation.isAdd() && !lastMultiReferenceOperation.isAdd()) {

			int indexDifference = lastMultiReferenceOperation.getIndex() - multiReferenceOperation.getIndex();
			if (indexDifference > 0 && indexDifference <= referencedModelElements.size() + 1) {
				referencedModelElements.addAll(indexDifference - 1, referencedModelElementsOfLast);
				changedReferences.put(key, multiReferenceOperation);
				operationsToBeDeleted.add(lastMultiReferenceOperation);
				return;
			}
		}
		// the two ops must be both add
		else if (multiReferenceOperation.isAdd() && lastMultiReferenceOperation.isAdd()) {

			int indexDifference = lastMultiReferenceOperation.getIndex() - multiReferenceOperation.getIndex();
			if (indexDifference > 0 && indexDifference <= referencedModelElements.size()) {
				referencedModelElements.addAll(indexDifference, referencedModelElementsOfLast);
				referencedModelElementsOfLast.clear();
				referencedModelElementsOfLast.addAll(referencedModelElements);
				changedReferences.put(key, lastMultiReferenceOperation);
				lastMultiReferenceOperation.setIndex(multiReferenceOperation.getIndex());
				operationsToBeDeleted.add(multiReferenceOperation);
				return;
			}
		} else if (multiReferenceOperation.isAdd() != lastMultiReferenceOperation.isAdd()) {
			List<ModelElementId> idsToRemove = new ArrayList<ModelElementId>();
			for (ModelElementId modelElementId : referencedModelElements) {
				for (ModelElementId otherModelElementId : referencedModelElementsOfLast) {
					if (otherModelElementId.equals(modelElementId)) {
						idsToRemove.add(modelElementId);
					}
				}
			}
			referencedModelElements.removeAll(idsToRemove);
			referencedModelElementsOfLast.removeAll(idsToRemove);
			if (referencedModelElements.isEmpty()) {
				operationsToBeDeleted.add(multiReferenceOperation);
			}
			if (referencedModelElementsOfLast.isEmpty()) {
				operationsToBeDeleted.add(lastMultiReferenceOperation);
			}
		}
		changedReferences.put(key, multiReferenceOperation);
	}

	private static void handleMultiRefOperation(MultiReferenceOperation multiReferenceOperation,
		Map<String, ReferenceOperation> changedReferences, Set<AbstractOperation> operationsToBeDeleted,
		Map<ModelElementId, AbstractOperation> deletedElements) {
		String key = multiReferenceOperation.getModelElementId() + multiReferenceOperation.getFeatureName();

		EList<ModelElementId> referencedModelElements = multiReferenceOperation.getReferencedModelElements();

		// check if it is an add operation
		if (multiReferenceOperation.isAdd()) {
			// check if model element is already deleted and if it is an add
			// operation
			if (deletedElements.keySet().contains(multiReferenceOperation.getModelElementId())) {
				operationsToBeDeleted.add(multiReferenceOperation);
				return;
			}
			// check if any reference model element is already deleted
			Set<ModelElementId> referencedModelElementsToRemove = new HashSet<ModelElementId>();
			for (ModelElementId modelElementId : referencedModelElements) {
				if (deletedElements.keySet().contains(modelElementId)) {
					referencedModelElementsToRemove.add(modelElementId);
				}
			}
			referencedModelElements.removeAll(referencedModelElementsToRemove);
			if (referencedModelElements.isEmpty()) {
				operationsToBeDeleted.add(multiReferenceOperation);
				return;
			}
		}

		if (changedReferences.containsKey(key)) {
			aggregateMultiReferenceOperations(multiReferenceOperation, changedReferences, operationsToBeDeleted, key);
			return;
		} else if (multiReferenceOperation.isBidirectional()) {
			for (ModelElementId referencedId : referencedModelElements) {
				String oppositeKey = referencedId + multiReferenceOperation.getOppositeFeatureName();
				if (changedReferences.containsKey(oppositeKey)) {
					ReferenceOperation oppositeOperation = changedReferences.get(oppositeKey);
					if (oppositeOperation instanceof SingleReferenceOperation) {
						aggregateMultiwithSingleReference(multiReferenceOperation, changedReferences,
							operationsToBeDeleted, key, referencedId, oppositeKey, oppositeOperation);
						return;
					} else {
						// opposite is multiref
						aggregateMultiwithMultiReference(multiReferenceOperation,
							(MultiReferenceOperation) oppositeOperation, changedReferences, operationsToBeDeleted, key,
							oppositeKey);
						return;
					}
				}
			}
		}
		changedReferences.put(key, multiReferenceOperation);
	}

	private static void aggregateMultiwithMultiReference(MultiReferenceOperation multiReferenceOperation,
		MultiReferenceOperation oppositeMultiOperation, Map<String, ReferenceOperation> changedReferences,
		Set<AbstractOperation> operationsToBeDeleted, String key, String oppositeKey) {
		if (oppositeMultiOperation.isAdd() == multiReferenceOperation.isAdd()) {
			if (oppositeMultiOperation.getReferencedModelElements().size() == 1) {
				ModelElementId oppositeReferencedModelElementId = oppositeMultiOperation.getReferencedModelElements()
					.get(0);
				if (oppositeReferencedModelElementId.equals(multiReferenceOperation.getModelElementId())) {
					operationsToBeDeleted.add(oppositeMultiOperation);
					changedReferences.remove(oppositeKey);
				}
				changedReferences.put(key, multiReferenceOperation);
				return;
			} else if (multiReferenceOperation.getReferencedModelElements().size() == 1) {
				ModelElementId referencedModelElementId = multiReferenceOperation.getReferencedModelElements().get(0);
				if (referencedModelElementId.equals(oppositeMultiOperation.getModelElementId())) {
					operationsToBeDeleted.add(multiReferenceOperation);
					return;
				}
				changedReferences.put(key, multiReferenceOperation);
				return;
			}
		}
	}

	private static void aggregateMultiwithSingleReference(MultiReferenceOperation multiReferenceOperation,
		Map<String, ReferenceOperation> changedReferences, Set<AbstractOperation> operationsToBeDeleted, String key,
		ModelElementId referencedId, String oppositeKey, ReferenceOperation oppositeOperation) {
		SingleReferenceOperation oppositeSingleOperation = (SingleReferenceOperation) oppositeOperation;
		// single operation on opposite is about same
		// remove change
		if (oppositeSingleOperation.getNewValue() == null
			&& referencedId.equals(oppositeSingleOperation.getModelElementId())
			&& multiReferenceOperation.getModelElementId().equals(oppositeSingleOperation.getOldValue())
			&& !multiReferenceOperation.isAdd()) {
			operationsToBeDeleted.add(oppositeSingleOperation);
			changedReferences.remove(oppositeKey);
		}
		// single operation on opposite is about same
		// add change
		else if (oppositeSingleOperation.getOldValue() == null
			&& referencedId.equals(oppositeSingleOperation.getModelElementId())
			&& multiReferenceOperation.getModelElementId().equals(oppositeSingleOperation.getNewValue())
			&& multiReferenceOperation.isAdd()) {
			operationsToBeDeleted.add(oppositeSingleOperation);
			changedReferences.remove(oppositeKey);
		}
		changedReferences.put(key, multiReferenceOperation);
	}

	private static void handleSingleRefOperation(SingleReferenceOperation singleReferenceOperation,
		Map<String, ReferenceOperation> changedReferences, Set<AbstractOperation> operationsToBeDeleted,
		Map<ModelElementId, AbstractOperation> deletedElements) {
		String key = singleReferenceOperation.getModelElementId() + singleReferenceOperation.getFeatureName();
		// check if element is already deleted
		if (deletedElements.keySet().contains(singleReferenceOperation.getModelElementId())) {
			operationsToBeDeleted.add(singleReferenceOperation);
			return;
		}
		// check if referenced element is deleted
		ModelElementId newValue = singleReferenceOperation.getNewValue();
		if (newValue != null && deletedElements.keySet().contains(newValue)) {
			operationsToBeDeleted.add(singleReferenceOperation);
			return;
		}

		if (changedReferences.containsKey(key)) {
			// aggregate the two single reference changes
			SingleReferenceOperation lastSingleReferenceOperation = (SingleReferenceOperation) changedReferences
				.get(key);
			lastSingleReferenceOperation.setOldValue(singleReferenceOperation.getOldValue());
			operationsToBeDeleted.add(singleReferenceOperation);
			return;
		} else if (singleReferenceOperation.isBidirectional()) {
			String oppositeKey = singleReferenceOperation.getOldValue()
				+ singleReferenceOperation.getOppositeFeatureName();
			if (changedReferences.containsKey(oppositeKey)) {
				ReferenceOperation oppositeOperation = changedReferences.get(oppositeKey);
				if (singleReferenceOperation.getOldValue().equals(oppositeOperation.getModelElementId())
					&& (newValue == null)) {
					operationsToBeDeleted.add(singleReferenceOperation);
					return;
				}
			}
		}
		changedReferences.put(key, singleReferenceOperation);
	}

	private static void handleAttributeOperation(Map<String, AttributeOperation> changedAttributes,
		HashMap<ModelElementId, Set<AttributeOperation>> modelElementAttributeChangeMap,
		Set<AbstractOperation> operationsToBeDeleted, AbstractOperation operation) {
		AttributeOperation attributeOperation = (AttributeOperation) operation;
		String key = attributeOperation.getModelElementId() + attributeOperation.getFeatureName();
		if (changedAttributes.containsKey(key)) {
			// aggregate the two attribute changes
			AttributeOperation lastAttributeOperation = changedAttributes.get(key);
			lastAttributeOperation.setOldValue(attributeOperation.getOldValue());
			operationsToBeDeleted.add(attributeOperation);
			if (lastAttributeOperation.getNewValue() != null
				&& lastAttributeOperation.getNewValue().equals(lastAttributeOperation.getOldValue())) {
				operationsToBeDeleted.add(attributeOperation);
				changedAttributes.remove(key);
			}
		} else {
			if (attributeOperation.getNewValue() != null
				&& attributeOperation.getNewValue().equals(attributeOperation.getOldValue())) {
				operationsToBeDeleted.add(attributeOperation);
				return;
			}
			changedAttributes.put(key, attributeOperation);
			Set<AttributeOperation> set = modelElementAttributeChangeMap.get(attributeOperation.getModelElementId());
			if (set == null) {
				set = new HashSet<AttributeOperation>();
				modelElementAttributeChangeMap.put(attributeOperation.getModelElementId(), set);
			}
			set.add(attributeOperation);
		}
	}

	private static void handleCreateDeleteOperation(Map<ModelElementId, AbstractOperation> deletedElements,
		HashMap<ModelElementId, Set<AttributeOperation>> modelElementAttributeChangeMap,
		Set<AbstractOperation> operationsToBeDeleted, AbstractOperation operation, ModelElementId modelElementId) {
		boolean isDelete = ((CreateDeleteOperation) operation).isDelete();
		if (isDelete) {
			deletedElements.put(modelElementId, operation);
		} else {
			if (deletedElements.keySet().contains(modelElementId)) {
				operationsToBeDeleted.add(operation);
				operationsToBeDeleted.add(deletedElements.get(modelElementId));
				deletedElements.remove(modelElementId);
			} else {
				Set<AttributeOperation> set = modelElementAttributeChangeMap.get(modelElementId);
				if (set != null) {
					for (AttributeOperation attributeOperation : set) {
						attributeOperation.apply(((CreateDeleteOperation) operation).getModelElement());
						operationsToBeDeleted.add(attributeOperation);
					}
				}
			}
		}
	}

}
