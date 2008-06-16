/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.organization.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.impl.ModelElementImpl;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrgUnitId;
import org.unicase.model.organization.OrganizationPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Org Unit</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.organization.impl.OrgUnitImpl#getOrgId <em>Org Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrgUnitImpl extends ModelElementImpl implements OrgUnit {
	/**
	 * The cached value of the '{@link #getOrgId() <em>Org Id</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOrgId()
	 * @generated
	 * @ordered
	 */
	protected OrgUnitId orgId;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected OrgUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OrganizationPackage.Literals.ORG_UNIT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OrgUnitId getOrgId() {
		return orgId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOrgId(OrgUnitId newOrgId,
			NotificationChain msgs) {
		OrgUnitId oldOrgId = orgId;
		orgId = newOrgId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OrganizationPackage.ORG_UNIT__ORG_ID, oldOrgId, newOrgId);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrgId(OrgUnitId newOrgId) {
		if (newOrgId != orgId) {
			NotificationChain msgs = null;
			if (orgId != null)
				msgs = ((InternalEObject)orgId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OrganizationPackage.ORG_UNIT__ORG_ID, null, msgs);
			if (newOrgId != null)
				msgs = ((InternalEObject)newOrgId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OrganizationPackage.ORG_UNIT__ORG_ID, null, msgs);
			msgs = basicSetOrgId(newOrgId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrganizationPackage.ORG_UNIT__ORG_ID, newOrgId, newOrgId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OrganizationPackage.ORG_UNIT__ORG_ID:
				return basicSetOrgId(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OrganizationPackage.ORG_UNIT__ORG_ID:
				return getOrgId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OrganizationPackage.ORG_UNIT__ORG_ID:
				setOrgId((OrgUnitId)newValue);
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
			case OrganizationPackage.ORG_UNIT__ORG_ID:
				setOrgId((OrgUnitId)null);
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
			case OrganizationPackage.ORG_UNIT__ORG_ID:
				return orgId != null;
		}
		return super.eIsSet(featureID);
	}

} // OrgUnitImpl
