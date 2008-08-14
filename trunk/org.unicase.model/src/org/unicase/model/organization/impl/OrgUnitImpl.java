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
import org.unicase.model.impl.ModelElementImpl;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Org Unit</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.organization.impl.OrgUnitImpl#getAcOrgId <em>Ac Org Id</em>}</li>
 *   <li>{@link org.unicase.model.organization.impl.OrgUnitImpl#getGroupMemberships <em>Group Memberships</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrgUnitImpl extends ModelElementImpl implements OrgUnit {
	/**
	 * The default value of the '{@link #getAcOrgId() <em>Ac Org Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAcOrgId()
	 * @generated
	 * @ordered
	 */
	protected static final String AC_ORG_ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getAcOrgId() <em>Ac Org Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAcOrgId()
	 * @generated
	 * @ordered
	 */
	protected String acOrgId = AC_ORG_ID_EDEFAULT;
	/**
	 * The cached value of the '{@link #getGroupMemberships() <em>Group Memberships</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupMemberships()
	 * @generated
	 * @ordered
	 */
	protected Group groupMemberships;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAcOrgId() {
		return acOrgId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAcOrgId(String newAcOrgId) {
		String oldAcOrgId = acOrgId;
		acOrgId = newAcOrgId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OrganizationPackage.ORG_UNIT__AC_ORG_ID, oldAcOrgId,
					acOrgId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Group getGroupMemberships() {
		if (groupMemberships != null && groupMemberships.eIsProxy()) {
			InternalEObject oldGroupMemberships = (InternalEObject) groupMemberships;
			groupMemberships = (Group) eResolveProxy(oldGroupMemberships);
			if (groupMemberships != oldGroupMemberships) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							OrganizationPackage.ORG_UNIT__GROUP_MEMBERSHIPS,
							oldGroupMemberships, groupMemberships));
			}
		}
		return groupMemberships;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Group basicGetGroupMemberships() {
		return groupMemberships;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGroupMemberships(
			Group newGroupMemberships, NotificationChain msgs) {
		Group oldGroupMemberships = groupMemberships;
		groupMemberships = newGroupMemberships;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					OrganizationPackage.ORG_UNIT__GROUP_MEMBERSHIPS,
					oldGroupMemberships, newGroupMemberships);
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
	public void setGroupMemberships(Group newGroupMemberships) {
		if (newGroupMemberships != groupMemberships) {
			NotificationChain msgs = null;
			if (groupMemberships != null)
				msgs = ((InternalEObject) groupMemberships).eInverseRemove(
						this, OrganizationPackage.GROUP__ORG_UNITS,
						Group.class, msgs);
			if (newGroupMemberships != null)
				msgs = ((InternalEObject) newGroupMemberships).eInverseAdd(
						this, OrganizationPackage.GROUP__ORG_UNITS,
						Group.class, msgs);
			msgs = basicSetGroupMemberships(newGroupMemberships, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OrganizationPackage.ORG_UNIT__GROUP_MEMBERSHIPS,
					newGroupMemberships, newGroupMemberships));
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
			case OrganizationPackage.ORG_UNIT__GROUP_MEMBERSHIPS :
				if (groupMemberships != null)
					msgs = ((InternalEObject) groupMemberships).eInverseRemove(
							this, OrganizationPackage.GROUP__ORG_UNITS,
							Group.class, msgs);
				return basicSetGroupMemberships((Group) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OrganizationPackage.ORG_UNIT__GROUP_MEMBERSHIPS :
				return basicSetGroupMemberships(null, msgs);
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
			case OrganizationPackage.ORG_UNIT__AC_ORG_ID :
				return getAcOrgId();
			case OrganizationPackage.ORG_UNIT__GROUP_MEMBERSHIPS :
				if (resolve)
					return getGroupMemberships();
				return basicGetGroupMemberships();
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
			case OrganizationPackage.ORG_UNIT__AC_ORG_ID :
				setAcOrgId((String) newValue);
				return;
			case OrganizationPackage.ORG_UNIT__GROUP_MEMBERSHIPS :
				setGroupMemberships((Group) newValue);
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
			case OrganizationPackage.ORG_UNIT__AC_ORG_ID :
				setAcOrgId(AC_ORG_ID_EDEFAULT);
				return;
			case OrganizationPackage.ORG_UNIT__GROUP_MEMBERSHIPS :
				setGroupMemberships((Group) null);
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
			case OrganizationPackage.ORG_UNIT__AC_ORG_ID :
				return AC_ORG_ID_EDEFAULT == null
						? acOrgId != null
						: !AC_ORG_ID_EDEFAULT.equals(acOrgId);
			case OrganizationPackage.ORG_UNIT__GROUP_MEMBERSHIPS :
				return groupMemberships != null;
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
		result.append(" (acOrgId: ");
		result.append(acOrgId);
		result.append(')');
		return result.toString();
	}

} // OrgUnitImpl
