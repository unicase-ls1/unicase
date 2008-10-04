/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.VersioningPackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Change Package</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.unicase.emfstore.esmodel.versioning.impl.ChangePackageImpl#getOperations
 * <em>Operations</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ChangePackageImpl extends EObjectImpl implements ChangePackage {
	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractOperation> operations;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ChangePackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VersioningPackage.Literals.CHANGE_PACKAGE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AbstractOperation> getOperations() {
		if (operations == null) {
			operations = new EObjectContainmentEList.Resolving<AbstractOperation>(
					AbstractOperation.class, this,
					VersioningPackage.CHANGE_PACKAGE__OPERATIONS);
		}
		return operations;
	}

	// begin of custom code
	/**
	 * <!-- begin-user-doc --> Reverse the change package. That applying the
	 * change package and the reversed change package to a project is a nop.
	 * 
	 * @return the reversed change package <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ChangePackage reverse() {
		ChangePackage changePackage = VersioningFactory.eINSTANCE
				.createChangePackage();
		// reverse subOperations and add in reverse order
		EList<AbstractOperation> copiedSubOperations = changePackage
				.getOperations();
		for (AbstractOperation abstractOperation : getOperations()) {
			copiedSubOperations.add(0, abstractOperation.reverse());
		}
		return changePackage;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.ChangePackage#apply(org.unicase.model.Project)
	 * @generated NOT
	 */
	public void apply(Project project) {
		// for (ChangeContainer changeContainer : getChangeContainers()) {
		// changeContainer.apply(project);
		// }
		for (AbstractOperation abstractOperation : getOperations()) {
			// MK FIXME hack:
			try {
				abstractOperation.apply(project);
			} catch (IllegalStateException e) {

			}
		}
	}

	/**
	 * <!-- begin-user-doc --> Cannonize the change package, that is remove all
	 * operations that are masked by later operations. <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void cannonize() {
		Map<ModelElementId, AbstractOperation> deletedElements = new HashMap<ModelElementId, AbstractOperation>();
		Map<String, AttributeOperation> changedAttributes = new HashMap<String, AttributeOperation>();
		HashMap<ModelElementId, Set<AttributeOperation>> modelElementAttributeChangeMap = new HashMap<ModelElementId, Set<AttributeOperation>>();
		Map<String, ReferenceOperation> changedReferences = new HashMap<String, ReferenceOperation>();

		Set<AbstractOperation> operationsToBeDeleted = new HashSet<AbstractOperation>();

		EList<AbstractOperation> list = getOperations();
		for (int i = list.size() - 1; i >= 0; i--) {
			AbstractOperation operation = list.get(i);
			if (operation instanceof CompositeOperation) {
				// FIXME MK: check if composite will be empty after cannonize:
				// FIXME MK: check if composite in context of cp
				((CompositeOperation) operation).cannonize();
				continue;
			}

			ModelElementId modelElementId = operation.getModelElementId();

			if (operation instanceof CreateDeleteOperation) {
				handleCreateDeleteOperation(deletedElements,
						modelElementAttributeChangeMap, operationsToBeDeleted,
						operation, modelElementId);
				continue;
			}
			if (operation instanceof AttributeOperation) {
				if (deletedElements.keySet().contains(modelElementId)) {
					operationsToBeDeleted.add(operation);
					continue;
				}

				handleAttributeOperation(changedAttributes,
						modelElementAttributeChangeMap, operationsToBeDeleted,
						operation);
				continue;
			}
			if (operation instanceof SingleReferenceOperation) {
				handleSingleRefOperation((SingleReferenceOperation) operation, changedReferences, operationsToBeDeleted);
				continue;
			}

			if (operation instanceof MultiReferenceOperation) {
				handleMultiRefOperation((MultiReferenceOperation) operation, changedReferences, operationsToBeDeleted);
				continue;
			}
			// nop
			// we do not aggregate MultiReferenceOperations since this might be
			// confusing for the user
			// we cannot aggregate operations we do not know
		}
		// remove all obsolete operations
		list.removeAll(operationsToBeDeleted);
	}
	
	private void aggregateMultiReferenceOperations(MultiReferenceOperation multiReferenceOperation, Map<String, ReferenceOperation> changedReferences,
			Set<AbstractOperation> operationsToBeDeleted, String key) {
		// aggregate the two multi reference changes if possible
		MultiReferenceOperation lastMultiReferenceOperation = (MultiReferenceOperation) changedReferences
				.get(key);
		// the two ops must be both add or both remove
		if (multiReferenceOperation.isAdd() == lastMultiReferenceOperation
				.isAdd()) {

			int indexDifference = lastMultiReferenceOperation
					.getIndex()
					- multiReferenceOperation.getIndex();
			if (indexDifference > 0
					&& indexDifference < multiReferenceOperation
							.getReferencedModelElements().size()) {
				multiReferenceOperation
						.getReferencedModelElements()
						.addAll(
								lastMultiReferenceOperation
										.getIndex(),
								lastMultiReferenceOperation
										.getReferencedModelElements());
				changedReferences.put(key, multiReferenceOperation);
				operationsToBeDeleted
						.add(lastMultiReferenceOperation);
				return;
			}
		}
		changedReferences.put(key, multiReferenceOperation);
	}
	
	private void handleMultiRefOperation(MultiReferenceOperation multiReferenceOperation, Map<String, ReferenceOperation> changedReferences,
			Set<AbstractOperation> operationsToBeDeleted ) {
		String key = multiReferenceOperation.getModelElementId()
				+ multiReferenceOperation.getFeatureName();

		if (changedReferences.containsKey(key)) {
			aggregateMultiReferenceOperations(multiReferenceOperation, changedReferences, operationsToBeDeleted, key);
			return;
		} else if (multiReferenceOperation.isBidirectional()) {
			for (ModelElementId referencedId : multiReferenceOperation
					.getReferencedModelElements()) {
				String oppositeKey = referencedId
						+ multiReferenceOperation
								.getOppositeFeatureName();
				if (changedReferences.containsKey(oppositeKey)) {
					ReferenceOperation oppositeOperation = changedReferences
							.get(oppositeKey);
					if (oppositeOperation instanceof SingleReferenceOperation) {
						aggregateMultiwithSingleReference(multiReferenceOperation, changedReferences,
								operationsToBeDeleted, key, referencedId,
								oppositeKey, oppositeOperation);
						return;
					} else {
						// opposite is multiref
						aggregateMultiwithMultiReference(multiReferenceOperation, (MultiReferenceOperation) oppositeOperation, changedReferences, operationsToBeDeleted, key, oppositeKey);
						return;
					}
				}
			}
		}
		changedReferences.put(key, multiReferenceOperation);
	}
	
	private void aggregateMultiwithMultiReference(MultiReferenceOperation multiReferenceOperation, MultiReferenceOperation oppositeMultiOperation, Map<String, ReferenceOperation> changedReferences,
			Set<AbstractOperation> operationsToBeDeleted, String key, String oppositeKey) {
		if (oppositeMultiOperation.isAdd() == multiReferenceOperation
				.isAdd()) {
			if (oppositeMultiOperation
					.getReferencedModelElements()
					.size() == 1) {
				ModelElementId oppositeReferencedModelElementId = oppositeMultiOperation
						.getReferencedModelElements()
						.get(0);
				if (oppositeReferencedModelElementId
						.equals(multiReferenceOperation
								.getModelElementId())) {
					operationsToBeDeleted
							.add(oppositeMultiOperation);
					changedReferences
							.remove(oppositeKey);
				}
				changedReferences.put(key, multiReferenceOperation);
				return;
			} else if (multiReferenceOperation
					.getReferencedModelElements()
					.size() == 1) {
				ModelElementId referencedModelElementId = multiReferenceOperation
						.getReferencedModelElements()
						.get(0);
				if (referencedModelElementId
						.equals(oppositeMultiOperation
								.getModelElementId())) {
					operationsToBeDeleted
							.add(multiReferenceOperation);
					return;
				}
				changedReferences.put(key, multiReferenceOperation);
				return;
			}
		}
	}

	private void aggregateMultiwithSingleReference(MultiReferenceOperation multiReferenceOperation,
			Map<String, ReferenceOperation> changedReferences,
			Set<AbstractOperation> operationsToBeDeleted, String key,
			ModelElementId referencedId, String oppositeKey,
			ReferenceOperation oppositeOperation) {
		SingleReferenceOperation oppositeSingleOperation = (SingleReferenceOperation) oppositeOperation;
		// single operation on opposite is about same
		// remove change
		if (oppositeSingleOperation.getNewValue() == null
				&& referencedId
						.equals(oppositeSingleOperation
								.getModelElementId())
				&& multiReferenceOperation
						.getModelElementId().equals(
								oppositeSingleOperation
										.getOldValue())
				&& !multiReferenceOperation.isAdd()) {
			operationsToBeDeleted
					.add(oppositeSingleOperation);
			changedReferences.remove(oppositeKey);
		}
		// single operation on opposite is about same
		// add change
		else if (oppositeSingleOperation.getOldValue() == null
				&& referencedId
						.equals(oppositeSingleOperation
								.getModelElementId())
				&& multiReferenceOperation
						.getModelElementId().equals(
								oppositeSingleOperation
										.getNewValue())
				&& multiReferenceOperation.isAdd()) {
			operationsToBeDeleted
					.add(oppositeSingleOperation);
			changedReferences.remove(oppositeKey);
		}
		changedReferences.put(key, multiReferenceOperation);
	}

	private void handleSingleRefOperation(
			SingleReferenceOperation singleReferenceOperation,
			Map<String, ReferenceOperation> changedReferences,
			Set<AbstractOperation> operationsToBeDeleted) {
		String key = singleReferenceOperation.getModelElementId()
				+ singleReferenceOperation.getFeatureName();

		if (changedReferences.containsKey(key)) {
			// aggregate the two single reference changes
			SingleReferenceOperation lastSingleReferenceOperation = (SingleReferenceOperation) changedReferences
					.get(key);
			lastSingleReferenceOperation.setOldValue(singleReferenceOperation
					.getOldValue());
			operationsToBeDeleted.add(singleReferenceOperation);
			return;
		} else if (singleReferenceOperation.isBidirectional()) {
			String oppositeKey = singleReferenceOperation.getOldValue()
					+ singleReferenceOperation.getOppositeFeatureName();
			if (changedReferences.containsKey(oppositeKey)) {
				ReferenceOperation oppositeOperation = changedReferences
						.get(oppositeKey);
				if (singleReferenceOperation.getOldValue().equals(
						oppositeOperation.getModelElementId())
						&& (singleReferenceOperation.getNewValue() == null)) {
					operationsToBeDeleted.add(singleReferenceOperation);
					return;
				}
			}
		}
		changedReferences.put(key, singleReferenceOperation);
	}

	private void handleAttributeOperation(
			Map<String, AttributeOperation> changedAttributes,
			HashMap<ModelElementId, Set<AttributeOperation>> modelElementAttributeChangeMap,
			Set<AbstractOperation> operationsToBeDeleted,
			AbstractOperation operation) {
		AttributeOperation attributeOperation = (AttributeOperation) operation;
		String key = attributeOperation.getModelElementId()
				+ attributeOperation.getFeatureName();
		if (changedAttributes.containsKey(key)) {
			// aggregate the two attribute changes
			AttributeOperation lastAttributeOperation = changedAttributes
					.get(key);
			lastAttributeOperation
					.setOldValue(attributeOperation.getOldValue());
			operationsToBeDeleted.add(attributeOperation);
		} else {
			changedAttributes.put(key, attributeOperation);
			Set<AttributeOperation> set = modelElementAttributeChangeMap
					.get(attributeOperation.getModelElementId());
			if (set == null) {
				set = new HashSet<AttributeOperation>();
				modelElementAttributeChangeMap.put(attributeOperation
						.getModelElementId(), set);
			}
			set.add(attributeOperation);
		}
	}

	private void handleCreateDeleteOperation(
			Map<ModelElementId, AbstractOperation> deletedElements,
			HashMap<ModelElementId, Set<AttributeOperation>> modelElementAttributeChangeMap,
			Set<AbstractOperation> operationsToBeDeleted,
			AbstractOperation operation, ModelElementId modelElementId) {
		boolean isDelete = ((CreateDeleteOperation) operation).isDelete();
		if (isDelete) {
			deletedElements.put(modelElementId, operation);
		} else {
			if (deletedElements.keySet().contains(modelElementId)) {
				operationsToBeDeleted.add(operation);
			} else {
				Set<AttributeOperation> set = modelElementAttributeChangeMap
						.get(modelElementId);
				if (set != null) {
					for (AttributeOperation attributeOperation : set) {
						attributeOperation
								.apply(((CreateDeleteOperation) operation)
										.getModelElement());
						operationsToBeDeleted.add(attributeOperation);
					}
				}
			}
		}
	}

	// end of custom code
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case VersioningPackage.CHANGE_PACKAGE__OPERATIONS:
			return ((InternalEList<?>) getOperations()).basicRemove(otherEnd,
					msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	// end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case VersioningPackage.CHANGE_PACKAGE__OPERATIONS:
			return getOperations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case VersioningPackage.CHANGE_PACKAGE__OPERATIONS:
			getOperations().clear();
			getOperations().addAll(
					(Collection<? extends AbstractOperation>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case VersioningPackage.CHANGE_PACKAGE__OPERATIONS:
			getOperations().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case VersioningPackage.CHANGE_PACKAGE__OPERATIONS:
			return operations != null && !operations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ChangePackageImpl
