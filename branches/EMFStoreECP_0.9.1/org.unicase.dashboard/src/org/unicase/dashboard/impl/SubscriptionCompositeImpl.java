/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.dashboard.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.unicase.dashboard.DashboardPackage;
import org.unicase.dashboard.SubscriptionComposite;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Subscription Composite</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.dashboard.impl.SubscriptionCompositeImpl#getSubscriptions <em>Subscriptions</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SubscriptionCompositeImpl extends EObjectImpl implements SubscriptionComposite {
	/**
	 * The cached value of the '{@link #getSubscriptions() <em>Subscriptions</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSubscriptions()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementId> subscriptions;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SubscriptionCompositeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DashboardPackage.Literals.SUBSCRIPTION_COMPOSITE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ModelElementId> getSubscriptions() {
		if (subscriptions == null) {
			subscriptions = new SubscriptionIdList(this);
		}
		return subscriptions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DashboardPackage.SUBSCRIPTION_COMPOSITE__SUBSCRIPTIONS:
			return ((InternalEList<?>) getSubscriptions()).basicRemove(otherEnd, msgs);
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
		case DashboardPackage.SUBSCRIPTION_COMPOSITE__SUBSCRIPTIONS:
			return getSubscriptions();
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
		case DashboardPackage.SUBSCRIPTION_COMPOSITE__SUBSCRIPTIONS:
			getSubscriptions().clear();
			getSubscriptions().addAll((Collection<? extends ModelElementId>) newValue);
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
		case DashboardPackage.SUBSCRIPTION_COMPOSITE__SUBSCRIPTIONS:
			getSubscriptions().clear();
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
		case DashboardPackage.SUBSCRIPTION_COMPOSITE__SUBSCRIPTIONS:
			return subscriptions != null && !subscriptions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // SubscriptionCompositeImpl
