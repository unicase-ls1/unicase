/**
 * <copyright>Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html</copyright>
 *
 * $Id$
 */
package org.unicase.model.state.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.impl.ModelElementImpl;
import org.unicase.model.state.State;
import org.unicase.model.state.StatePackage;
import org.unicase.model.state.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.state.impl.StateImpl#getExitConditions <em>Exit Conditions</em>}</li>
 *   <li>{@link org.unicase.model.state.impl.StateImpl#getActivities <em>Activities</em>}</li>
 *   <li>{@link org.unicase.model.state.impl.StateImpl#getEntryConditions <em>Entry Conditions</em>}</li>
 *   <li>{@link org.unicase.model.state.impl.StateImpl#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link org.unicase.model.state.impl.StateImpl#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateImpl extends ModelElementImpl implements State {
	/**
	 * The default value of the '{@link #getExitConditions() <em>Exit Conditions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExitConditions()
	 * @generated
	 * @ordered
	 */
	protected static final String EXIT_CONDITIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExitConditions() <em>Exit Conditions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExitConditions()
	 * @generated
	 * @ordered
	 */
	protected String exitConditions = EXIT_CONDITIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getActivities() <em>Activities</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivities()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTIVITIES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActivities() <em>Activities</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivities()
	 * @generated
	 * @ordered
	 */
	protected String activities = ACTIVITIES_EDEFAULT;

	/**
	 * The default value of the '{@link #getEntryConditions() <em>Entry Conditions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryConditions()
	 * @generated
	 * @ordered
	 */
	protected static final String ENTRY_CONDITIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEntryConditions() <em>Entry Conditions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryConditions()
	 * @generated
	 * @ordered
	 */
	protected String entryConditions = ENTRY_CONDITIONS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOutgoingTransitions() <em>Outgoing Transitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> outgoingTransitions;

	/**
	 * The cached value of the '{@link #getIncomingTransitions() <em>Incoming Transitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> incomingTransitions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatePackage.Literals.STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExitConditions() {
		return exitConditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExitConditions(String newExitConditions) {
		String oldExitConditions = exitConditions;
		exitConditions = newExitConditions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					StatePackage.STATE__EXIT_CONDITIONS, oldExitConditions,
					exitConditions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getActivities() {
		return activities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivities(String newActivities) {
		String oldActivities = activities;
		activities = newActivities;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					StatePackage.STATE__ACTIVITIES, oldActivities, activities));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEntryConditions() {
		return entryConditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntryConditions(String newEntryConditions) {
		String oldEntryConditions = entryConditions;
		entryConditions = newEntryConditions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					StatePackage.STATE__ENTRY_CONDITIONS, oldEntryConditions,
					entryConditions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getOutgoingTransitions() {
		if (outgoingTransitions == null) {
			outgoingTransitions = new EObjectWithInverseResolvingEList<Transition>(
					Transition.class, this,
					StatePackage.STATE__OUTGOING_TRANSITIONS,
					StatePackage.TRANSITION__SOURCE);
		}
		return outgoingTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getIncomingTransitions() {
		if (incomingTransitions == null) {
			incomingTransitions = new EObjectWithInverseResolvingEList<Transition>(
					Transition.class, this,
					StatePackage.STATE__INCOMING_TRANSITIONS,
					StatePackage.TRANSITION__TARGET);
		}
		return incomingTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case StatePackage.STATE__OUTGOING_TRANSITIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOutgoingTransitions())
					.basicAdd(otherEnd, msgs);
		case StatePackage.STATE__INCOMING_TRANSITIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getIncomingTransitions())
					.basicAdd(otherEnd, msgs);
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
		case StatePackage.STATE__OUTGOING_TRANSITIONS:
			return ((InternalEList<?>) getOutgoingTransitions()).basicRemove(
					otherEnd, msgs);
		case StatePackage.STATE__INCOMING_TRANSITIONS:
			return ((InternalEList<?>) getIncomingTransitions()).basicRemove(
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
		case StatePackage.STATE__EXIT_CONDITIONS:
			return getExitConditions();
		case StatePackage.STATE__ACTIVITIES:
			return getActivities();
		case StatePackage.STATE__ENTRY_CONDITIONS:
			return getEntryConditions();
		case StatePackage.STATE__OUTGOING_TRANSITIONS:
			return getOutgoingTransitions();
		case StatePackage.STATE__INCOMING_TRANSITIONS:
			return getIncomingTransitions();
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
		case StatePackage.STATE__EXIT_CONDITIONS:
			setExitConditions((String) newValue);
			return;
		case StatePackage.STATE__ACTIVITIES:
			setActivities((String) newValue);
			return;
		case StatePackage.STATE__ENTRY_CONDITIONS:
			setEntryConditions((String) newValue);
			return;
		case StatePackage.STATE__OUTGOING_TRANSITIONS:
			getOutgoingTransitions().clear();
			getOutgoingTransitions().addAll(
					(Collection<? extends Transition>) newValue);
			return;
		case StatePackage.STATE__INCOMING_TRANSITIONS:
			getIncomingTransitions().clear();
			getIncomingTransitions().addAll(
					(Collection<? extends Transition>) newValue);
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
		case StatePackage.STATE__EXIT_CONDITIONS:
			setExitConditions(EXIT_CONDITIONS_EDEFAULT);
			return;
		case StatePackage.STATE__ACTIVITIES:
			setActivities(ACTIVITIES_EDEFAULT);
			return;
		case StatePackage.STATE__ENTRY_CONDITIONS:
			setEntryConditions(ENTRY_CONDITIONS_EDEFAULT);
			return;
		case StatePackage.STATE__OUTGOING_TRANSITIONS:
			getOutgoingTransitions().clear();
			return;
		case StatePackage.STATE__INCOMING_TRANSITIONS:
			getIncomingTransitions().clear();
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
		case StatePackage.STATE__EXIT_CONDITIONS:
			return EXIT_CONDITIONS_EDEFAULT == null ? exitConditions != null
					: !EXIT_CONDITIONS_EDEFAULT.equals(exitConditions);
		case StatePackage.STATE__ACTIVITIES:
			return ACTIVITIES_EDEFAULT == null ? activities != null
					: !ACTIVITIES_EDEFAULT.equals(activities);
		case StatePackage.STATE__ENTRY_CONDITIONS:
			return ENTRY_CONDITIONS_EDEFAULT == null ? entryConditions != null
					: !ENTRY_CONDITIONS_EDEFAULT.equals(entryConditions);
		case StatePackage.STATE__OUTGOING_TRANSITIONS:
			return outgoingTransitions != null
					&& !outgoingTransitions.isEmpty();
		case StatePackage.STATE__INCOMING_TRANSITIONS:
			return incomingTransitions != null
					&& !incomingTransitions.isEmpty();
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
		result.append(" (exitConditions: ");
		result.append(exitConditions);
		result.append(", activities: ");
		result.append(activities);
		result.append(", entryConditions: ");
		result.append(entryConditions);
		result.append(')');
		return result.toString();
	}

} //StateImpl
