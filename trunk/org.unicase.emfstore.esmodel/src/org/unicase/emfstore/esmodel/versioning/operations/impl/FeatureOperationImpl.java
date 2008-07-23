/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.operations.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.emfstore.esmodel.versioning.operations.FeatureOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.FeatureOperationImpl#getFeatureChange <em>Feature Change</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureOperationImpl extends AtomicOperationImpl implements
		FeatureOperation {
	/**
	 * The cached value of the '{@link #getFeatureChange() <em>Feature Change</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureChange()
	 * @generated
	 * @ordered
	 */
	protected FeatureChange featureChange;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.FEATURE_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureChange getFeatureChange() {
		if (featureChange != null && featureChange.eIsProxy()) {
			InternalEObject oldFeatureChange = (InternalEObject) featureChange;
			featureChange = (FeatureChange) eResolveProxy(oldFeatureChange);
			if (featureChange != oldFeatureChange) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							OperationsPackage.FEATURE_OPERATION__FEATURE_CHANGE,
							oldFeatureChange, featureChange));
			}
		}
		return featureChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureChange basicGetFeatureChange() {
		return featureChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureChange(FeatureChange newFeatureChange) {
		FeatureChange oldFeatureChange = featureChange;
		featureChange = newFeatureChange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OperationsPackage.FEATURE_OPERATION__FEATURE_CHANGE,
					oldFeatureChange, featureChange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OperationsPackage.FEATURE_OPERATION__FEATURE_CHANGE:
			if (resolve)
				return getFeatureChange();
			return basicGetFeatureChange();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case OperationsPackage.FEATURE_OPERATION__FEATURE_CHANGE:
			setFeatureChange((FeatureChange) newValue);
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
		case OperationsPackage.FEATURE_OPERATION__FEATURE_CHANGE:
			setFeatureChange((FeatureChange) null);
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
		case OperationsPackage.FEATURE_OPERATION__FEATURE_CHANGE:
			return featureChange != null;
		}
		return super.eIsSet(featureID);
	}

} //FeatureOperationImpl
