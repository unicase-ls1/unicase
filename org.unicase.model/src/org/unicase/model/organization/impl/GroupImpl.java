/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
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
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Group</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.organization.impl.GroupImpl#getOrgUnits <em>Org Units</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GroupImpl extends OrgUnitImpl implements Group {
	/**
	 * The cached value of the '{@link #getOrgUnits() <em>Org Units</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrgUnits()
	 * @generated
	 * @ordered
	 */
	protected OrgUnit orgUnits;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected GroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OrganizationPackage.Literals.GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrgUnit getOrgUnits() {
		if (orgUnits != null && orgUnits.eIsProxy()) {
			InternalEObject oldOrgUnits = (InternalEObject) orgUnits;
			orgUnits = (OrgUnit) eResolveProxy(oldOrgUnits);
			if (orgUnits != oldOrgUnits) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							OrganizationPackage.GROUP__ORG_UNITS, oldOrgUnits,
							orgUnits));
			}
		}
		return orgUnits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrgUnit basicGetOrgUnits() {
		return orgUnits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOrgUnits(OrgUnit newOrgUnits,
			NotificationChain msgs) {
		OrgUnit oldOrgUnits = orgUnits;
		orgUnits = newOrgUnits;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, OrganizationPackage.GROUP__ORG_UNITS,
					oldOrgUnits, newOrgUnits);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrgUnits(OrgUnit newOrgUnits) {
		if (newOrgUnits != orgUnits) {
			NotificationChain msgs = null;
			if (orgUnits != null)
				msgs = ((InternalEObject) orgUnits).eInverseRemove(this,
						OrganizationPackage.ORG_UNIT__GROUP_MEMBERSHIPS,
						OrgUnit.class, msgs);
			if (newOrgUnits != null)
				msgs = ((InternalEObject) newOrgUnits).eInverseAdd(this,
						OrganizationPackage.ORG_UNIT__GROUP_MEMBERSHIPS,
						OrgUnit.class, msgs);
			msgs = basicSetOrgUnits(newOrgUnits, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OrganizationPackage.GROUP__ORG_UNITS, newOrgUnits,
					newOrgUnits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case OrganizationPackage.GROUP__ORG_UNITS:
			if (orgUnits != null)
				msgs = ((InternalEObject) orgUnits).eInverseRemove(this,
						OrganizationPackage.ORG_UNIT__GROUP_MEMBERSHIPS,
						OrgUnit.class, msgs);
			return basicSetOrgUnits((OrgUnit) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case OrganizationPackage.GROUP__ORG_UNITS:
			return basicSetOrgUnits(null, msgs);
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
		case OrganizationPackage.GROUP__ORG_UNITS:
			if (resolve)
				return getOrgUnits();
			return basicGetOrgUnits();
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
		case OrganizationPackage.GROUP__ORG_UNITS:
			setOrgUnits((OrgUnit) newValue);
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
		case OrganizationPackage.GROUP__ORG_UNITS:
			setOrgUnits((OrgUnit) null);
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
		case OrganizationPackage.GROUP__ORG_UNITS:
			return orgUnits != null;
		}
		return super.eIsSet(featureID);
	}

} // GroupImpl
