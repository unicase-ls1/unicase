/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.unicase.model.urml.Stakeholder;
import org.unicase.model.urml.UrmlPackage;

import urml.goal.Goal;
import urml.goal.GoalPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stakeholder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.urml.impl.StakeholderImpl#getGoals <em>Goals</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StakeholderImpl extends UrmlModelElementImpl implements Stakeholder {
	/**
	 * The cached value of the '{@link #getGoals() <em>Goals</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoals()
	 * @generated
	 * @ordered
	 */
	protected Goal goals;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StakeholderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UrmlPackage.Literals.STAKEHOLDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Goal getGoals() {
		if (goals != null && goals.eIsProxy()) {
			InternalEObject oldGoals = (InternalEObject) goals;
			goals = (Goal) eResolveProxy(oldGoals);
			if (goals != oldGoals) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UrmlPackage.STAKEHOLDER__GOALS, oldGoals,
						goals));
			}
		}
		return goals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Goal basicGetGoals() {
		return goals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGoals(Goal newGoals, NotificationChain msgs) {
		Goal oldGoals = goals;
		goals = newGoals;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				UrmlPackage.STAKEHOLDER__GOALS, oldGoals, newGoals);
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
	public void setGoals(Goal newGoals) {
		if (newGoals != goals) {
			NotificationChain msgs = null;
			if (goals != null)
				msgs = ((InternalEObject) goals).eInverseRemove(this, GoalPackage.GOAL__STAKEHOLDERS, Goal.class, msgs);
			if (newGoals != null)
				msgs = ((InternalEObject) newGoals).eInverseAdd(this, GoalPackage.GOAL__STAKEHOLDERS, Goal.class, msgs);
			msgs = basicSetGoals(newGoals, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.STAKEHOLDER__GOALS, newGoals, newGoals));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case UrmlPackage.STAKEHOLDER__GOALS:
			if (goals != null)
				msgs = ((InternalEObject) goals).eInverseRemove(this, GoalPackage.GOAL__STAKEHOLDERS, Goal.class, msgs);
			return basicSetGoals((Goal) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case UrmlPackage.STAKEHOLDER__GOALS:
			return basicSetGoals(null, msgs);
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
		case UrmlPackage.STAKEHOLDER__GOALS:
			if (resolve)
				return getGoals();
			return basicGetGoals();
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
		case UrmlPackage.STAKEHOLDER__GOALS:
			setGoals((Goal) newValue);
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
		case UrmlPackage.STAKEHOLDER__GOALS:
			setGoals((Goal) null);
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
		case UrmlPackage.STAKEHOLDER__GOALS:
			return goals != null;
		}
		return super.eIsSet(featureID);
	}

} //StakeholderImpl
