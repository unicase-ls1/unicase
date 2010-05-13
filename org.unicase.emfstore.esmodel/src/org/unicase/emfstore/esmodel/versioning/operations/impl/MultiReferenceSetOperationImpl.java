/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations.impl;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceSetOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Multi Reference Set Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.MultiReferenceSetOperationImpl#getIndex <em>Index
 * </em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.MultiReferenceSetOperationImpl#getOldValue <em>Old
 * Value</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.MultiReferenceSetOperationImpl#getNewValue <em>New
 * Value</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MultiReferenceSetOperationImpl extends ReferenceOperationImpl implements MultiReferenceSetOperation {
	/**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger INDEX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected BigInteger index = INDEX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOldValue() <em>Old Value</em>}' containment reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getOldValue()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId oldValue;

	/**
	 * The cached value of the '{@link #getNewValue() <em>New Value</em>}' containment reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getNewValue()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId newValue;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MultiReferenceSetOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.MULTI_REFERENCE_SET_OPERATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BigInteger getIndex() {
		return index;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIndex(BigInteger newIndex) {
		BigInteger oldIndex = index;
		index = newIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OperationsPackage.MULTI_REFERENCE_SET_OPERATION__INDEX, oldIndex, index));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId getOldValue() {
		if (oldValue != null && oldValue.eIsProxy()) {
			InternalEObject oldOldValue = (InternalEObject) oldValue;
			oldValue = (ModelElementId) eResolveProxy(oldOldValue);
			if (oldValue != oldOldValue) {
				InternalEObject newOldValue = (InternalEObject) oldValue;
				NotificationChain msgs = oldOldValue.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- OperationsPackage.MULTI_REFERENCE_SET_OPERATION__OLD_VALUE, null, null);
				if (newOldValue.eInternalContainer() == null) {
					msgs = newOldValue.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- OperationsPackage.MULTI_REFERENCE_SET_OPERATION__OLD_VALUE, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						OperationsPackage.MULTI_REFERENCE_SET_OPERATION__OLD_VALUE, oldOldValue, oldValue));
			}
		}
		return oldValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId basicGetOldValue() {
		return oldValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetOldValue(ModelElementId newOldValue, NotificationChain msgs) {
		ModelElementId oldOldValue = oldValue;
		oldValue = newOldValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				OperationsPackage.MULTI_REFERENCE_SET_OPERATION__OLD_VALUE, oldOldValue, newOldValue);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setOldValue(ModelElementId newOldValue) {
		if (newOldValue != oldValue) {
			NotificationChain msgs = null;
			if (oldValue != null)
				msgs = ((InternalEObject) oldValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- OperationsPackage.MULTI_REFERENCE_SET_OPERATION__OLD_VALUE, null, msgs);
			if (newOldValue != null)
				msgs = ((InternalEObject) newOldValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- OperationsPackage.MULTI_REFERENCE_SET_OPERATION__OLD_VALUE, null, msgs);
			msgs = basicSetOldValue(newOldValue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OperationsPackage.MULTI_REFERENCE_SET_OPERATION__OLD_VALUE, newOldValue, newOldValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId getNewValue() {
		if (newValue != null && newValue.eIsProxy()) {
			InternalEObject oldNewValue = (InternalEObject) newValue;
			newValue = (ModelElementId) eResolveProxy(oldNewValue);
			if (newValue != oldNewValue) {
				InternalEObject newNewValue = (InternalEObject) newValue;
				NotificationChain msgs = oldNewValue.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- OperationsPackage.MULTI_REFERENCE_SET_OPERATION__NEW_VALUE, null, null);
				if (newNewValue.eInternalContainer() == null) {
					msgs = newNewValue.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- OperationsPackage.MULTI_REFERENCE_SET_OPERATION__NEW_VALUE, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						OperationsPackage.MULTI_REFERENCE_SET_OPERATION__NEW_VALUE, oldNewValue, newValue));
			}
		}
		return newValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId basicGetNewValue() {
		return newValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetNewValue(ModelElementId newNewValue, NotificationChain msgs) {
		ModelElementId oldNewValue = newValue;
		newValue = newNewValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				OperationsPackage.MULTI_REFERENCE_SET_OPERATION__NEW_VALUE, oldNewValue, newNewValue);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNewValue(ModelElementId newNewValue) {
		if (newNewValue != newValue) {
			NotificationChain msgs = null;
			if (newValue != null)
				msgs = ((InternalEObject) newValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- OperationsPackage.MULTI_REFERENCE_SET_OPERATION__NEW_VALUE, null, msgs);
			if (newNewValue != null)
				msgs = ((InternalEObject) newNewValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- OperationsPackage.MULTI_REFERENCE_SET_OPERATION__NEW_VALUE, null, msgs);
			msgs = basicSetNewValue(newNewValue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OperationsPackage.MULTI_REFERENCE_SET_OPERATION__NEW_VALUE, newNewValue, newNewValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__OLD_VALUE:
			return basicSetOldValue(null, msgs);
		case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__NEW_VALUE:
			return basicSetNewValue(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__INDEX:
			return getIndex();
		case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__OLD_VALUE:
			if (resolve)
				return getOldValue();
			return basicGetOldValue();
		case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__NEW_VALUE:
			if (resolve)
				return getNewValue();
			return basicGetNewValue();
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
		case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__INDEX:
			setIndex((BigInteger) newValue);
			return;
		case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__OLD_VALUE:
			setOldValue((ModelElementId) newValue);
			return;
		case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__NEW_VALUE:
			setNewValue((ModelElementId) newValue);
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
		case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__INDEX:
			setIndex(INDEX_EDEFAULT);
			return;
		case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__OLD_VALUE:
			setOldValue((ModelElementId) null);
			return;
		case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__NEW_VALUE:
			setNewValue((ModelElementId) null);
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
		case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__INDEX:
			return INDEX_EDEFAULT == null ? index != null : !INDEX_EDEFAULT.equals(index);
		case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__OLD_VALUE:
			return oldValue != null;
		case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__NEW_VALUE:
			return newValue != null;
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
		result.append(" (index: ");
		result.append(index);
		result.append(')');
		return result.toString();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#apply(org.unicase.metamodel.Project)
	 */
	public void apply(Project project) {
		// TODO Auto-generated method stub

	}

} // MultiReferenceSetOperationImpl
