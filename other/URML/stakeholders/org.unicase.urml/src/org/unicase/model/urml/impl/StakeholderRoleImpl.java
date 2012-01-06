/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.urml.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.unicase.model.impl.UnicaseModelElementImpl;

import org.unicase.model.urml.StakeholderRole;
import org.unicase.model.urml.UrmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stakeholder Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.urml.impl.StakeholderRoleImpl#getReviewSet <em>Review Set</em>}</li>
 *   <li>{@link org.unicase.model.urml.impl.StakeholderRoleImpl#getFilterSet <em>Filter Set</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StakeholderRoleImpl extends UnicaseModelElementImpl implements
		StakeholderRole {
	/**
	 * The cached value of the '{@link #getReviewSet() <em>Review Set</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReviewSet()
	 * @generated
	 * @ordered
	 */
	protected EMap<EClass, EList<EStructuralFeature>> reviewSet;

	/**
	 * The cached value of the '{@link #getFilterSet() <em>Filter Set</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilterSet()
	 * @generated
	 * @ordered
	 */
	protected EMap<EClass, EList<EStructuralFeature>> filterSet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StakeholderRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UrmlPackage.Literals.STAKEHOLDER_ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<EClass, EList<EStructuralFeature>> getReviewSet() {
		if (reviewSet == null) {
			reviewSet = new EcoreEMap<EClass, EList<EStructuralFeature>>(
					UrmlPackage.Literals.SET_ENTRY, SetEntryImpl.class, this,
					UrmlPackage.STAKEHOLDER_ROLE__REVIEW_SET);
		}
		return reviewSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<EClass, EList<EStructuralFeature>> getFilterSet() {
		if (filterSet == null) {
			filterSet = new EcoreEMap<EClass, EList<EStructuralFeature>>(
					UrmlPackage.Literals.SET_ENTRY, SetEntryImpl.class, this,
					UrmlPackage.STAKEHOLDER_ROLE__FILTER_SET);
		}
		return filterSet;
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
		case UrmlPackage.STAKEHOLDER_ROLE__REVIEW_SET:
			return ((InternalEList<?>) getReviewSet()).basicRemove(otherEnd,
					msgs);
		case UrmlPackage.STAKEHOLDER_ROLE__FILTER_SET:
			return ((InternalEList<?>) getFilterSet()).basicRemove(otherEnd,
					msgs);
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
		case UrmlPackage.STAKEHOLDER_ROLE__REVIEW_SET:
			if (coreType)
				return getReviewSet();
			else
				return getReviewSet().map();
		case UrmlPackage.STAKEHOLDER_ROLE__FILTER_SET:
			if (coreType)
				return getFilterSet();
			else
				return getFilterSet().map();
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
		case UrmlPackage.STAKEHOLDER_ROLE__REVIEW_SET:
			((EStructuralFeature.Setting) getReviewSet()).set(newValue);
			return;
		case UrmlPackage.STAKEHOLDER_ROLE__FILTER_SET:
			((EStructuralFeature.Setting) getFilterSet()).set(newValue);
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
		case UrmlPackage.STAKEHOLDER_ROLE__REVIEW_SET:
			getReviewSet().clear();
			return;
		case UrmlPackage.STAKEHOLDER_ROLE__FILTER_SET:
			getFilterSet().clear();
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
		case UrmlPackage.STAKEHOLDER_ROLE__REVIEW_SET:
			return reviewSet != null && !reviewSet.isEmpty();
		case UrmlPackage.STAKEHOLDER_ROLE__FILTER_SET:
			return filterSet != null && !filterSet.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StakeholderRoleImpl
