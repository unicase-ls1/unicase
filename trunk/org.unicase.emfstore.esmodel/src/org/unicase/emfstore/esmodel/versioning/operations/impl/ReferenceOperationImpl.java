/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.operations.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.ReferenceOperationImpl#isBidirectional <em>Bidirectional</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.ReferenceOperationImpl#getOppositeFeatureName <em>Opposite Feature Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ReferenceOperationImpl extends FeatureOperationImpl
		implements ReferenceOperation {
	/**
	 * The default value of the '{@link #isBidirectional() <em>Bidirectional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBidirectional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BIDIRECTIONAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBidirectional() <em>Bidirectional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBidirectional()
	 * @generated
	 * @ordered
	 */
	protected boolean bidirectional = BIDIRECTIONAL_EDEFAULT;

	@Override
	protected void reverse(AbstractOperation abstractOperation) {
		super.reverse(abstractOperation);
		if (!(abstractOperation instanceof ReferenceOperation)) {
			throw new IllegalArgumentException(
					"Given operation is not a reference operation.");
		}
		ReferenceOperation referenceOperation = (ReferenceOperation) abstractOperation;
		referenceOperation.setBidirectional(isBidirectional());
		referenceOperation.setOppositeFeatureName(getOppositeFeatureName());
	}

	/**
	 * The default value of the '{@link #getOppositeFeatureName() <em>Opposite Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOppositeFeatureName()
	 * @generated
	 * @ordered
	 */
	protected static final String OPPOSITE_FEATURE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOppositeFeatureName() <em>Opposite Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOppositeFeatureName()
	 * @generated
	 * @ordered
	 */
	protected String oppositeFeatureName = OPPOSITE_FEATURE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.REFERENCE_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBidirectional() {
		return bidirectional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBidirectional(boolean newBidirectional) {
		boolean oldBidirectional = bidirectional;
		bidirectional = newBidirectional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OperationsPackage.REFERENCE_OPERATION__BIDIRECTIONAL,
					oldBidirectional, bidirectional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOppositeFeatureName() {
		return oppositeFeatureName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOppositeFeatureName(String newOppositeFeatureName) {
		String oldOppositeFeatureName = oppositeFeatureName;
		oppositeFeatureName = newOppositeFeatureName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					OperationsPackage.REFERENCE_OPERATION__OPPOSITE_FEATURE_NAME,
					oldOppositeFeatureName, oppositeFeatureName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OperationsPackage.REFERENCE_OPERATION__BIDIRECTIONAL:
			return isBidirectional() ? Boolean.TRUE : Boolean.FALSE;
		case OperationsPackage.REFERENCE_OPERATION__OPPOSITE_FEATURE_NAME:
			return getOppositeFeatureName();
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
		case OperationsPackage.REFERENCE_OPERATION__BIDIRECTIONAL:
			setBidirectional(((Boolean) newValue).booleanValue());
			return;
		case OperationsPackage.REFERENCE_OPERATION__OPPOSITE_FEATURE_NAME:
			setOppositeFeatureName((String) newValue);
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
		case OperationsPackage.REFERENCE_OPERATION__BIDIRECTIONAL:
			setBidirectional(BIDIRECTIONAL_EDEFAULT);
			return;
		case OperationsPackage.REFERENCE_OPERATION__OPPOSITE_FEATURE_NAME:
			setOppositeFeatureName(OPPOSITE_FEATURE_NAME_EDEFAULT);
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
		case OperationsPackage.REFERENCE_OPERATION__BIDIRECTIONAL:
			return bidirectional != BIDIRECTIONAL_EDEFAULT;
		case OperationsPackage.REFERENCE_OPERATION__OPPOSITE_FEATURE_NAME:
			return OPPOSITE_FEATURE_NAME_EDEFAULT == null ? oppositeFeatureName != null
					: !OPPOSITE_FEATURE_NAME_EDEFAULT
							.equals(oppositeFeatureName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (bidirectional: ");
		result.append(bidirectional);
		result.append(", oppositeFeatureName: ");
		result.append(oppositeFeatureName);
		result.append(')');
		return result.toString();
	}

} //ReferenceOperationImpl
