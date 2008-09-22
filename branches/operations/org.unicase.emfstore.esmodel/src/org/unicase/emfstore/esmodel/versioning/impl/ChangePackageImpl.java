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
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.VersioningPackage;
import org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainer;
import org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainerFactory;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Change Package</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.impl.ChangePackageImpl#getChangeContainers <em>Change Containers</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.impl.ChangePackageImpl#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChangePackageImpl extends EObjectImpl implements ChangePackage {
	/**
	 * The cached value of the '{@link #getChangeContainers()
	 * <em>Change Containers</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getChangeContainers()
	 * @generated
	 * @ordered
	 */
	protected EList<ChangeContainer> changeContainers;

	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractOperation> operations;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ChangePackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VersioningPackage.Literals.CHANGE_PACKAGE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ChangeContainer> getChangeContainers() {
		if (changeContainers == null) {
			changeContainers = new EObjectContainmentEList.Resolving<ChangeContainer>(
					ChangeContainer.class, this,
					VersioningPackage.CHANGE_PACKAGE__CHANGE_CONTAINERS);
		}
		return changeContainers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ChangePackage reverse() {
		ChangePackage changePackage = VersioningFactory.eINSTANCE
				.createChangePackage();
		//add reversed change containers in reversed order
		for (ChangeContainer changeContainer : getChangeContainers()) {
			changePackage.getChangeContainers().add(0,
					changeContainer.reverse());
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
		//		for (ChangeContainer changeContainer : getChangeContainers()) {
		//			changeContainer.apply(project);
		//		}
		for (AbstractOperation abstractOperation : getOperations()) {
			abstractOperation.apply(project);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void init(Project project,
			ChangeDescription backwardChangeDescription) {
		ChangeContainer changeContainer = ChangeContainerFactory.eINSTANCE
				.createChangeContainer();
		changeContainer.init(project, backwardChangeDescription);
		getChangeContainers().add(changeContainer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void cannonize() {
		Set<ModelElementId> deletedElements = new HashSet<ModelElementId>();
		Map<String, AttributeOperation> changedAttributes = new HashMap<String, AttributeOperation>();
		Map<String, SingleReferenceOperation> changedSingleReferences = new HashMap<String, SingleReferenceOperation>();
		Set<AbstractOperation> operationsToBeDeleted = new HashSet<AbstractOperation>();
		EList<AbstractOperation> list = getOperations();
		for (int i = list.size(); i>0; i--) {
			AbstractOperation operation = list.get(i);
			if (operation instanceof CompositeOperation) {
				//FIXME MK: check if composite will be empty after cannonize:
				//FIXME MK: check if composite in context of cp
				((CompositeOperation) operation).cannonize();
				continue;
			}
			if (deletedElements.contains(operation.getModelElementId())) {
				operationsToBeDeleted.add(operation);
				continue;
			}
			if (operation instanceof CreateDeleteOperation) {
				boolean isDelete = ((CreateDeleteOperation) operation).isDelete();
				if (isDelete) {
					deletedElements.add(operation.getModelElementId());
				}
				continue;
			}
			if (operation instanceof AttributeOperation) {
				AttributeOperation attributeOperation = (AttributeOperation) operation;
				String key = attributeOperation.getModelElementId() + attributeOperation.getFeatureName();
				if (changedAttributes.containsKey(key)) {
					//aggregate the two attribute changes
					AttributeOperation lastAttributeOperation = changedAttributes.get(key);
					lastAttributeOperation.setOldValue(attributeOperation.getOldValue());
					operationsToBeDeleted.add(attributeOperation);
				}
				else {
					changedAttributes.put(key, attributeOperation);
				}
				continue;
			}
			if (operation instanceof SingleReferenceOperation) {
				SingleReferenceOperation singleReferenceOperation = (SingleReferenceOperation) operation;
				String key = singleReferenceOperation.getModelElementId() + singleReferenceOperation.getFeatureName();
				if (changedSingleReferences.containsKey(key)) {
					//aggregate the two single reference changes
					SingleReferenceOperation lastSingleReferenceOperation = changedSingleReferences.get(key);
					lastSingleReferenceOperation.setOldValue(singleReferenceOperation.getOldValue());
					operationsToBeDeleted.add(singleReferenceOperation);
				}
				else {
					changedSingleReferences.put(key, singleReferenceOperation);
				}
				continue;
			}
			//nop
			//we do not aggregate MultiReferenceOperations since this might be confusing for the user
			//we cannot aggregate operations we do not know
		}
		//remove all obsolete operations
		list.removeAll(operationsToBeDeleted);
		
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case VersioningPackage.CHANGE_PACKAGE__CHANGE_CONTAINERS:
			return ((InternalEList<?>) getChangeContainers()).basicRemove(
					otherEnd, msgs);
		case VersioningPackage.CHANGE_PACKAGE__OPERATIONS:
			return ((InternalEList<?>) getOperations()).basicRemove(otherEnd,
					msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	// end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case VersioningPackage.CHANGE_PACKAGE__CHANGE_CONTAINERS:
			return getChangeContainers();
		case VersioningPackage.CHANGE_PACKAGE__OPERATIONS:
			return getOperations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case VersioningPackage.CHANGE_PACKAGE__CHANGE_CONTAINERS:
			getChangeContainers().clear();
			getChangeContainers().addAll(
					(Collection<? extends ChangeContainer>) newValue);
			return;
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
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case VersioningPackage.CHANGE_PACKAGE__CHANGE_CONTAINERS:
			getChangeContainers().clear();
			return;
		case VersioningPackage.CHANGE_PACKAGE__OPERATIONS:
			getOperations().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case VersioningPackage.CHANGE_PACKAGE__CHANGE_CONTAINERS:
			return changeContainers != null && !changeContainers.isEmpty();
		case VersioningPackage.CHANGE_PACKAGE__OPERATIONS:
			return operations != null && !operations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ChangePackageImpl
