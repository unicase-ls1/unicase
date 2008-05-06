/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.unicase.esmodel.Administration;
import org.unicase.esmodel.EsmodelPackage;

import org.unicase.esmodel.accesscontrol.OrgUnit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Administration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.esmodel.impl.AdministrationImpl#getOrgUnits <em>Org Units</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AdministrationImpl extends EObjectImpl implements Administration {
	/**
	 * The cached value of the '{@link #getOrgUnits() <em>Org Units</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrgUnits()
	 * @generated
	 * @ordered
	 */
	protected EList<OrgUnit> orgUnits;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdministrationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsmodelPackage.Literals.ADMINISTRATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OrgUnit> getOrgUnits() {
		if (orgUnits == null) {
			orgUnits = new EObjectContainmentEList<OrgUnit>(OrgUnit.class, this, EsmodelPackage.ADMINISTRATION__ORG_UNITS);
		}
		return orgUnits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsmodelPackage.ADMINISTRATION__ORG_UNITS:
				return ((InternalEList<?>)getOrgUnits()).basicRemove(otherEnd, msgs);
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
			case EsmodelPackage.ADMINISTRATION__ORG_UNITS:
				return getOrgUnits();
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
			case EsmodelPackage.ADMINISTRATION__ORG_UNITS:
				getOrgUnits().clear();
				getOrgUnits().addAll((Collection<? extends OrgUnit>)newValue);
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
			case EsmodelPackage.ADMINISTRATION__ORG_UNITS:
				getOrgUnits().clear();
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
			case EsmodelPackage.ADMINISTRATION__ORG_UNITS:
				return orgUnits != null && !orgUnits.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AdministrationImpl
