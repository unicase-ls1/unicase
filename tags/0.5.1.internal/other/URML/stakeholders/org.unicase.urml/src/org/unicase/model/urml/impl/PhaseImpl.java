/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.urml.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import java.util.Collection;
import java.util.Map;

import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.impl.UnicaseModelElementImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.unicase.model.urml.Phase;
import org.unicase.model.urml.UrmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Phase</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.urml.impl.PhaseImpl#getAllowedAssociations <em>Allowed Associations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PhaseImpl extends UnicaseModelElementImpl implements Phase {
	/**
	 * The cached value of the '{@link #getAllowedAssociations() <em>Allowed Associations</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllowedAssociations()
	 * @generated
	 * @ordered
	 */
	protected EMap<EClass, EList<EClass>> allowedAssociations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PhaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UrmlPackage.Literals.PHASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<EClass, EList<EClass>> getAllowedAssociations() {
		if (allowedAssociations == null) {
			allowedAssociations = new EcoreEMap<EClass, EList<EClass>>(
					UrmlPackage.Literals.PHASE_SET_ENTRY,
					PhaseSetEntryImpl.class, this,
					UrmlPackage.PHASE__ALLOWED_ASSOCIATIONS);
		}
		return allowedAssociations;
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
		case UrmlPackage.PHASE__ALLOWED_ASSOCIATIONS:
			return ((InternalEList<?>) getAllowedAssociations()).basicRemove(
					otherEnd, msgs);
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
		case UrmlPackage.PHASE__ALLOWED_ASSOCIATIONS:
			if (coreType)
				return getAllowedAssociations();
			else
				return getAllowedAssociations().map();
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
		case UrmlPackage.PHASE__ALLOWED_ASSOCIATIONS:
			((EStructuralFeature.Setting) getAllowedAssociations())
					.set(newValue);
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
		case UrmlPackage.PHASE__ALLOWED_ASSOCIATIONS:
			getAllowedAssociations().clear();
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
		case UrmlPackage.PHASE__ALLOWED_ASSOCIATIONS:
			return allowedAssociations != null
					&& !allowedAssociations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PhaseImpl
