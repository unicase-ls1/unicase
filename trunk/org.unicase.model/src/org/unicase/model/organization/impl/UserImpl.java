/**
 * <copyright>
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
import org.unicase.model.organization.User;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.organization.impl.UserImpl#getOrgId <em>Org Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserImpl extends ModelElementImpl implements User {
	/**
	 * The cached value of the '{@link #getOrgId() <em>Org Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrgId()
	 * @generated
	 * @ordered
	 */
	protected OrgUnitId orgId;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UserImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OrganizationPackage.Literals.USER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrgUnitId getOrgId() {
		return orgId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOrgId(OrgUnitId newOrgId, NotificationChain msgs) {
		OrgUnitId oldOrgId = orgId;
		orgId = newOrgId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OrganizationPackage.USER__ORG_ID, oldOrgId, newOrgId);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrgId(OrgUnitId newOrgId) {
		if (newOrgId != orgId) {
			NotificationChain msgs = null;
			if (orgId != null)
				msgs = ((InternalEObject)orgId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OrganizationPackage.USER__ORG_ID, null, msgs);
			if (newOrgId != null)
				msgs = ((InternalEObject)newOrgId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OrganizationPackage.USER__ORG_ID, null, msgs);
			msgs = basicSetOrgId(newOrgId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrganizationPackage.USER__ORG_ID, newOrgId, newOrgId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OrganizationPackage.USER__ORG_ID:
				return basicSetOrgId(null, msgs);
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
			case OrganizationPackage.USER__ORG_ID:
				return getOrgId();
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
			case OrganizationPackage.USER__ORG_ID:
				setOrgId((OrgUnitId)newValue);
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
			case OrganizationPackage.USER__ORG_ID:
				setOrgId((OrgUnitId)null);
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
			case OrganizationPackage.USER__ORG_ID:
				return orgId != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == OrgUnit.class) {
			switch (derivedFeatureID) {
				case OrganizationPackage.USER__ORG_ID: return OrganizationPackage.ORG_UNIT__ORG_ID;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == OrgUnit.class) {
			switch (baseFeatureID) {
				case OrganizationPackage.ORG_UNIT__ORG_ID: return OrganizationPackage.USER__ORG_ID;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //UserImpl
