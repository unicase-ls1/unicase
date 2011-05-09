/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.orga.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.unicase.model.orga.OrgaPackage;
import org.unicase.model.orga.OrgaUnit;
import org.unicase.model.orga.Team;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Team</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.orga.impl.TeamImpl#getHasOrgUnit <em>Has Org Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TeamImpl extends OrgaUnitImpl implements Team {
	/**
	 * The cached value of the '{@link #getHasOrgUnit() <em>Has Org Unit</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasOrgUnit()
	 * @generated
	 * @ordered
	 */
	protected EList<OrgaUnit> hasOrgUnit;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TeamImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OrgaPackage.Literals.TEAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OrgaUnit> getHasOrgUnit() {
		if (hasOrgUnit == null) {
			hasOrgUnit = new EObjectResolvingEList<OrgaUnit>(OrgaUnit.class, this, OrgaPackage.TEAM__HAS_ORG_UNIT);
		}
		return hasOrgUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OrgaPackage.TEAM__HAS_ORG_UNIT:
				return getHasOrgUnit();
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
			case OrgaPackage.TEAM__HAS_ORG_UNIT:
				getHasOrgUnit().clear();
				getHasOrgUnit().addAll((Collection<? extends OrgaUnit>)newValue);
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
			case OrgaPackage.TEAM__HAS_ORG_UNIT:
				getHasOrgUnit().clear();
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
			case OrgaPackage.TEAM__HAS_ORG_UNIT:
				return hasOrgUnit != null && !hasOrgUnit.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TeamImpl
