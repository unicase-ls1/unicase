/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Kögel
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.changemanagment.changepackage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESModifyElementEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ES Modify Element Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESModifyElementEventImpl#getPreviousState <em>Previous State</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESModifyElementEventImpl#getSubsequentState <em>Subsequent State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ESModifyElementEventImpl extends ESEventImpl implements
		ESModifyElementEvent {
	/**
	 * The default value of the '{@link #getPreviousState() <em>Previous State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreviousState()
	 * @generated
	 * @ordered
	 */
	protected static final String PREVIOUS_STATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPreviousState() <em>Previous State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreviousState()
	 * @generated
	 * @ordered
	 */
	protected String previousState = PREVIOUS_STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSubsequentState() <em>Subsequent State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubsequentState()
	 * @generated
	 * @ordered
	 */
	protected static final String SUBSEQUENT_STATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubsequentState() <em>Subsequent State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubsequentState()
	 * @generated
	 * @ordered
	 */
	protected String subsequentState = SUBSEQUENT_STATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESModifyElementEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChangepackagePackage.Literals.ES_MODIFY_ELEMENT_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPreviousState() {
		return previousState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreviousState(String newPreviousState) {
		String oldPreviousState = previousState;
		previousState = newPreviousState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					ChangepackagePackage.ES_MODIFY_ELEMENT_EVENT__PREVIOUS_STATE,
					oldPreviousState, previousState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubsequentState() {
		return subsequentState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubsequentState(String newSubsequentState) {
		String oldSubsequentState = subsequentState;
		subsequentState = newSubsequentState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					ChangepackagePackage.ES_MODIFY_ELEMENT_EVENT__SUBSEQUENT_STATE,
					oldSubsequentState, subsequentState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ChangepackagePackage.ES_MODIFY_ELEMENT_EVENT__PREVIOUS_STATE:
			return getPreviousState();
		case ChangepackagePackage.ES_MODIFY_ELEMENT_EVENT__SUBSEQUENT_STATE:
			return getSubsequentState();
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
		case ChangepackagePackage.ES_MODIFY_ELEMENT_EVENT__PREVIOUS_STATE:
			setPreviousState((String) newValue);
			return;
		case ChangepackagePackage.ES_MODIFY_ELEMENT_EVENT__SUBSEQUENT_STATE:
			setSubsequentState((String) newValue);
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
		case ChangepackagePackage.ES_MODIFY_ELEMENT_EVENT__PREVIOUS_STATE:
			setPreviousState(PREVIOUS_STATE_EDEFAULT);
			return;
		case ChangepackagePackage.ES_MODIFY_ELEMENT_EVENT__SUBSEQUENT_STATE:
			setSubsequentState(SUBSEQUENT_STATE_EDEFAULT);
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
		case ChangepackagePackage.ES_MODIFY_ELEMENT_EVENT__PREVIOUS_STATE:
			return PREVIOUS_STATE_EDEFAULT == null ? previousState != null
					: !PREVIOUS_STATE_EDEFAULT.equals(previousState);
		case ChangepackagePackage.ES_MODIFY_ELEMENT_EVENT__SUBSEQUENT_STATE:
			return SUBSEQUENT_STATE_EDEFAULT == null ? subsequentState != null
					: !SUBSEQUENT_STATE_EDEFAULT.equals(subsequentState);
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
		result.append(" (previousState: ");
		result.append(previousState);
		result.append(", subsequentState: ");
		result.append(subsequentState);
		result.append(')');
		return result.toString();
	}

} //ESModifyElementEventImpl
