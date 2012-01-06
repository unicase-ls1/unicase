/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.urml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.impl.UnicaseModelElementImpl;

import org.unicase.model.urml.Phase;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.model.urml.UrmlProjectSettings;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project Settings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.urml.impl.UrmlProjectSettingsImpl#getActivePhase <em>Active Phase</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UrmlProjectSettingsImpl extends UnicaseModelElementImpl implements
		UrmlProjectSettings {
	/**
	 * The cached value of the '{@link #getActivePhase() <em>Active Phase</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivePhase()
	 * @generated
	 * @ordered
	 */
	protected Phase activePhase;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UrmlProjectSettingsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UrmlPackage.Literals.URML_PROJECT_SETTINGS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Phase getActivePhase() {
		if (activePhase != null && activePhase.eIsProxy()) {
			InternalEObject oldActivePhase = (InternalEObject) activePhase;
			activePhase = (Phase) eResolveProxy(oldActivePhase);
			if (activePhase != oldActivePhase) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							UrmlPackage.URML_PROJECT_SETTINGS__ACTIVE_PHASE,
							oldActivePhase, activePhase));
			}
		}
		return activePhase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Phase basicGetActivePhase() {
		return activePhase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivePhase(Phase newActivePhase) {
		Phase oldActivePhase = activePhase;
		activePhase = newActivePhase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					UrmlPackage.URML_PROJECT_SETTINGS__ACTIVE_PHASE,
					oldActivePhase, activePhase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case UrmlPackage.URML_PROJECT_SETTINGS__ACTIVE_PHASE:
			if (resolve)
				return getActivePhase();
			return basicGetActivePhase();
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
		case UrmlPackage.URML_PROJECT_SETTINGS__ACTIVE_PHASE:
			setActivePhase((Phase) newValue);
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
		case UrmlPackage.URML_PROJECT_SETTINGS__ACTIVE_PHASE:
			setActivePhase((Phase) null);
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
		case UrmlPackage.URML_PROJECT_SETTINGS__ACTIVE_PHASE:
			return activePhase != null;
		}
		return super.eIsSet(featureID);
	}

} //UrmlProjectSettingsImpl
