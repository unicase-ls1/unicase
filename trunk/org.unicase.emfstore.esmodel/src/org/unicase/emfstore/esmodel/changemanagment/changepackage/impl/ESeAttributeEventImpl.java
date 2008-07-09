/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.changemanagment.changepackage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESeAttributeEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ESe Attribute Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESeAttributeEventImpl#getPreviousState <em>Previous State</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESeAttributeEventImpl#getSubsequentState <em>Subsequent State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ESeAttributeEventImpl extends ESEventImpl implements
		ESeAttributeEvent {
	/**
	 * The cached value of the '{@link #getPreviousState() <em>Previous State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreviousState()
	 * @generated
	 * @ordered
	 */
	protected EAttribute previousState;

	/**
	 * The cached value of the '{@link #getSubsequentState() <em>Subsequent State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubsequentState()
	 * @generated
	 * @ordered
	 */
	protected EAttribute subsequentState;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESeAttributeEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChangepackagePackage.Literals.ESE_ATTRIBUTE_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreviousState() {
		return previousState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPreviousState(EAttribute newPreviousState,
			NotificationChain msgs) {
		EAttribute oldPreviousState = previousState;
		previousState = newPreviousState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					ChangepackagePackage.ESE_ATTRIBUTE_EVENT__PREVIOUS_STATE,
					oldPreviousState, newPreviousState);
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
	public void setPreviousState(EAttribute newPreviousState) {
		if (newPreviousState != previousState) {
			NotificationChain msgs = null;
			if (previousState != null)
				msgs = ((InternalEObject) previousState)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- ChangepackagePackage.ESE_ATTRIBUTE_EVENT__PREVIOUS_STATE,
								null, msgs);
			if (newPreviousState != null)
				msgs = ((InternalEObject) newPreviousState)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- ChangepackagePackage.ESE_ATTRIBUTE_EVENT__PREVIOUS_STATE,
								null, msgs);
			msgs = basicSetPreviousState(newPreviousState, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ChangepackagePackage.ESE_ATTRIBUTE_EVENT__PREVIOUS_STATE,
					newPreviousState, newPreviousState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubsequentState() {
		if (subsequentState != null && subsequentState.eIsProxy()) {
			InternalEObject oldSubsequentState = (InternalEObject) subsequentState;
			subsequentState = (EAttribute) eResolveProxy(oldSubsequentState);
			if (subsequentState != oldSubsequentState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							ChangepackagePackage.ESE_ATTRIBUTE_EVENT__SUBSEQUENT_STATE,
							oldSubsequentState, subsequentState));
			}
		}
		return subsequentState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetSubsequentState() {
		return subsequentState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubsequentState(EAttribute newSubsequentState) {
		EAttribute oldSubsequentState = subsequentState;
		subsequentState = newSubsequentState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ChangepackagePackage.ESE_ATTRIBUTE_EVENT__SUBSEQUENT_STATE,
					oldSubsequentState, subsequentState));
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
		case ChangepackagePackage.ESE_ATTRIBUTE_EVENT__PREVIOUS_STATE:
			return basicSetPreviousState(null, msgs);
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
		case ChangepackagePackage.ESE_ATTRIBUTE_EVENT__PREVIOUS_STATE:
			return getPreviousState();
		case ChangepackagePackage.ESE_ATTRIBUTE_EVENT__SUBSEQUENT_STATE:
			if (resolve)
				return getSubsequentState();
			return basicGetSubsequentState();
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
		case ChangepackagePackage.ESE_ATTRIBUTE_EVENT__PREVIOUS_STATE:
			setPreviousState((EAttribute) newValue);
			return;
		case ChangepackagePackage.ESE_ATTRIBUTE_EVENT__SUBSEQUENT_STATE:
			setSubsequentState((EAttribute) newValue);
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
		case ChangepackagePackage.ESE_ATTRIBUTE_EVENT__PREVIOUS_STATE:
			setPreviousState((EAttribute) null);
			return;
		case ChangepackagePackage.ESE_ATTRIBUTE_EVENT__SUBSEQUENT_STATE:
			setSubsequentState((EAttribute) null);
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
		case ChangepackagePackage.ESE_ATTRIBUTE_EVENT__PREVIOUS_STATE:
			return previousState != null;
		case ChangepackagePackage.ESE_ATTRIBUTE_EVENT__SUBSEQUENT_STATE:
			return subsequentState != null;
		}
		return super.eIsSet(featureID);
	}

} //ESeAttributeEventImpl
