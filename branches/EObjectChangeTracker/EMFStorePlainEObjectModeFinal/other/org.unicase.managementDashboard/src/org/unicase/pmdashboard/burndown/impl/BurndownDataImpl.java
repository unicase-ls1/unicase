/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.pmdashboard.burndown.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.unicase.model.ModelElementId;

import org.unicase.pmdashboard.burndown.BurndownData;
import org.unicase.pmdashboard.burndown.BurndownDay;
import org.unicase.pmdashboard.burndown.BurndownPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.pmdashboard.burndown.impl.BurndownDataImpl#getParentElementId <em>Parent Element Id</em>}</li>
 *   <li>{@link org.unicase.pmdashboard.burndown.impl.BurndownDataImpl#getDays <em>Days</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BurndownDataImpl extends EObjectImpl implements BurndownData {
	/**
	 * The cached value of the '{@link #getParentElementId() <em>Parent Element Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentElementId()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId parentElementId;

	/**
	 * The cached value of the '{@link #getDays() <em>Days</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDays()
	 * @generated
	 * @ordered
	 */
	protected EList<BurndownDay> days;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BurndownDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BurndownPackage.Literals.BURNDOWN_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId getParentElementId() {
		if (parentElementId != null && parentElementId.eIsProxy()) {
			InternalEObject oldParentElementId = (InternalEObject)parentElementId;
			parentElementId = (ModelElementId)eResolveProxy(oldParentElementId);
			if (parentElementId != oldParentElementId) {
				InternalEObject newParentElementId = (InternalEObject)parentElementId;
				NotificationChain msgs = oldParentElementId.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BurndownPackage.BURNDOWN_DATA__PARENT_ELEMENT_ID, null, null);
				if (newParentElementId.eInternalContainer() == null) {
					msgs = newParentElementId.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BurndownPackage.BURNDOWN_DATA__PARENT_ELEMENT_ID, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BurndownPackage.BURNDOWN_DATA__PARENT_ELEMENT_ID, oldParentElementId, parentElementId));
			}
		}
		return parentElementId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId basicGetParentElementId() {
		return parentElementId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentElementId(ModelElementId newParentElementId, NotificationChain msgs) {
		ModelElementId oldParentElementId = parentElementId;
		parentElementId = newParentElementId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BurndownPackage.BURNDOWN_DATA__PARENT_ELEMENT_ID, oldParentElementId, newParentElementId);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentElementId(ModelElementId newParentElementId) {
		if (newParentElementId != parentElementId) {
			NotificationChain msgs = null;
			if (parentElementId != null)
				msgs = ((InternalEObject)parentElementId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BurndownPackage.BURNDOWN_DATA__PARENT_ELEMENT_ID, null, msgs);
			if (newParentElementId != null)
				msgs = ((InternalEObject)newParentElementId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BurndownPackage.BURNDOWN_DATA__PARENT_ELEMENT_ID, null, msgs);
			msgs = basicSetParentElementId(newParentElementId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BurndownPackage.BURNDOWN_DATA__PARENT_ELEMENT_ID, newParentElementId, newParentElementId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BurndownDay> getDays() {
		if (days == null) {
			days = new EObjectContainmentEList.Resolving<BurndownDay>(BurndownDay.class, this, BurndownPackage.BURNDOWN_DATA__DAYS);
		}
		return days;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BurndownPackage.BURNDOWN_DATA__PARENT_ELEMENT_ID:
				return basicSetParentElementId(null, msgs);
			case BurndownPackage.BURNDOWN_DATA__DAYS:
				return ((InternalEList<?>)getDays()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BurndownPackage.BURNDOWN_DATA__PARENT_ELEMENT_ID:
				if (resolve) return getParentElementId();
				return basicGetParentElementId();
			case BurndownPackage.BURNDOWN_DATA__DAYS:
				return getDays();
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
			case BurndownPackage.BURNDOWN_DATA__PARENT_ELEMENT_ID:
				setParentElementId((ModelElementId)newValue);
				return;
			case BurndownPackage.BURNDOWN_DATA__DAYS:
				getDays().clear();
				getDays().addAll((Collection<? extends BurndownDay>)newValue);
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
			case BurndownPackage.BURNDOWN_DATA__PARENT_ELEMENT_ID:
				setParentElementId((ModelElementId)null);
				return;
			case BurndownPackage.BURNDOWN_DATA__DAYS:
				getDays().clear();
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
			case BurndownPackage.BURNDOWN_DATA__PARENT_ELEMENT_ID:
				return parentElementId != null;
			case BurndownPackage.BURNDOWN_DATA__DAYS:
				return days != null && !days.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BurndownDataImpl
