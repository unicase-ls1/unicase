/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Multi Attribute Move Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.MultiAttributeMoveOperationImpl#getOldIndex <em>
 * Old Index</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.MultiAttributeMoveOperationImpl#getNewIndex <em>
 * New Index</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MultiAttributeMoveOperationImpl extends FeatureOperationImpl implements MultiAttributeMoveOperation {
	/**
	 * The default value of the '{@link #getOldIndex() <em>Old Index</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getOldIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int OLD_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOldIndex() <em>Old Index</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getOldIndex()
	 * @generated
	 * @ordered
	 */
	protected int oldIndex = OLD_INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewIndex() <em>New Index</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getNewIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int NEW_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNewIndex() <em>New Index</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getNewIndex()
	 * @generated
	 * @ordered
	 */
	protected int newIndex = NEW_INDEX_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MultiAttributeMoveOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.MULTI_ATTRIBUTE_MOVE_OPERATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getOldIndex() {
		return oldIndex;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setOldIndex(int newOldIndex) {
		int oldOldIndex = oldIndex;
		oldIndex = newOldIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__OLD_INDEX, oldOldIndex, oldIndex));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getNewIndex() {
		return newIndex;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNewIndex(int newNewIndex) {
		int oldNewIndex = newIndex;
		newIndex = newNewIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__NEW_INDEX, oldNewIndex, newIndex));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__OLD_INDEX:
			return getOldIndex();
		case OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__NEW_INDEX:
			return getNewIndex();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__OLD_INDEX:
			setOldIndex((Integer) newValue);
			return;
		case OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__NEW_INDEX:
			setNewIndex((Integer) newValue);
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
		case OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__OLD_INDEX:
			setOldIndex(OLD_INDEX_EDEFAULT);
			return;
		case OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__NEW_INDEX:
			setNewIndex(NEW_INDEX_EDEFAULT);
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
		case OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__OLD_INDEX:
			return oldIndex != OLD_INDEX_EDEFAULT;
		case OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__NEW_INDEX:
			return newIndex != NEW_INDEX_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (oldIndex: ");
		result.append(oldIndex);
		result.append(", newIndex: ");
		result.append(newIndex);
		result.append(')');
		return result.toString();
	}

	@Override
	public String getDescription() {
		// MK implement
		return null;
	}

	@Override
	public String getName() {
		// MK implement
		return null;
	}

	@Override
	public AbstractOperation reverse() {
		// MK implement
		return null;
	}

} // MultiAttributeMoveOperationImpl
