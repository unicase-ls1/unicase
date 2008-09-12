/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.operations.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Reference Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.MultiReferenceOperationImpl#getOldValues <em>Old Values</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.MultiReferenceOperationImpl#getNewValues <em>New Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiReferenceOperationImpl extends FeatureOperationImpl implements
		MultiReferenceOperation {
	/**
	 * The cached value of the '{@link #getOldValues() <em>Old Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldValues()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> oldValues;

	/**
	 * The cached value of the '{@link #getNewValues() <em>New Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewValues()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> newValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiReferenceOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.MULTI_REFERENCE_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getOldValues() {
		if (oldValues == null) {
			oldValues = new EObjectResolvingEList<EObject>(EObject.class, this,
					OperationsPackage.MULTI_REFERENCE_OPERATION__OLD_VALUES);
		}
		return oldValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getNewValues() {
		if (newValues == null) {
			newValues = new EObjectResolvingEList<EObject>(EObject.class, this,
					OperationsPackage.MULTI_REFERENCE_OPERATION__NEW_VALUES);
		}
		return newValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OperationsPackage.MULTI_REFERENCE_OPERATION__OLD_VALUES:
			return getOldValues();
		case OperationsPackage.MULTI_REFERENCE_OPERATION__NEW_VALUES:
			return getNewValues();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case OperationsPackage.MULTI_REFERENCE_OPERATION__OLD_VALUES:
			getOldValues().clear();
			getOldValues().addAll((Collection<? extends EObject>) newValue);
			return;
		case OperationsPackage.MULTI_REFERENCE_OPERATION__NEW_VALUES:
			getNewValues().clear();
			getNewValues().addAll((Collection<? extends EObject>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case OperationsPackage.MULTI_REFERENCE_OPERATION__OLD_VALUES:
			getOldValues().clear();
			return;
		case OperationsPackage.MULTI_REFERENCE_OPERATION__NEW_VALUES:
			getNewValues().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case OperationsPackage.MULTI_REFERENCE_OPERATION__OLD_VALUES:
			return oldValues != null && !oldValues.isEmpty();
		case OperationsPackage.MULTI_REFERENCE_OPERATION__NEW_VALUES:
			return newValues != null && !newValues.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MultiReferenceOperationImpl
