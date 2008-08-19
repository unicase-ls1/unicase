/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.requirement.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.impl.ModelElementImpl;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.requirement.Step;
import org.unicase.model.requirement.SystemFunction;
import org.unicase.model.requirement.UseCase;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Step</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.requirement.impl.StepImpl#isUserStep <em>User Step</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.StepImpl#getIncludedUseCase <em>Included Use Case</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.StepImpl#getIncludedSystemFunction <em>Included System Function</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StepImpl extends ModelElementImpl implements Step {
	/**
	 * The default value of the '{@link #isUserStep() <em>User Step</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isUserStep()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USER_STEP_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUserStep() <em>User Step</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isUserStep()
	 * @generated
	 * @ordered
	 */
	protected boolean userStep = USER_STEP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIncludedUseCase() <em>Included Use Case</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncludedUseCase()
	 * @generated
	 * @ordered
	 */
	protected UseCase includedUseCase;

	/**
	 * The cached value of the '{@link #getIncludedSystemFunction() <em>Included System Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncludedSystemFunction()
	 * @generated
	 * @ordered
	 */
	protected SystemFunction includedSystemFunction;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected StepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementPackage.Literals.STEP;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUserStep() {
		return userStep;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserStep(boolean newUserStep) {
		boolean oldUserStep = userStep;
		userStep = newUserStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementPackage.STEP__USER_STEP, oldUserStep, userStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCase getIncludedUseCase() {
		if (includedUseCase != null && includedUseCase.eIsProxy()) {
			InternalEObject oldIncludedUseCase = (InternalEObject) includedUseCase;
			includedUseCase = (UseCase) eResolveProxy(oldIncludedUseCase);
			if (includedUseCase != oldIncludedUseCase) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							RequirementPackage.STEP__INCLUDED_USE_CASE,
							oldIncludedUseCase, includedUseCase));
			}
		}
		return includedUseCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCase basicGetIncludedUseCase() {
		return includedUseCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncludedUseCase(UseCase newIncludedUseCase) {
		UseCase oldIncludedUseCase = includedUseCase;
		includedUseCase = newIncludedUseCase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementPackage.STEP__INCLUDED_USE_CASE,
					oldIncludedUseCase, includedUseCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemFunction getIncludedSystemFunction() {
		if (includedSystemFunction != null && includedSystemFunction.eIsProxy()) {
			InternalEObject oldIncludedSystemFunction = (InternalEObject) includedSystemFunction;
			includedSystemFunction = (SystemFunction) eResolveProxy(oldIncludedSystemFunction);
			if (includedSystemFunction != oldIncludedSystemFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							RequirementPackage.STEP__INCLUDED_SYSTEM_FUNCTION,
							oldIncludedSystemFunction, includedSystemFunction));
			}
		}
		return includedSystemFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemFunction basicGetIncludedSystemFunction() {
		return includedSystemFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncludedSystemFunction(
			SystemFunction newIncludedSystemFunction) {
		SystemFunction oldIncludedSystemFunction = includedSystemFunction;
		includedSystemFunction = newIncludedSystemFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementPackage.STEP__INCLUDED_SYSTEM_FUNCTION,
					oldIncludedSystemFunction, includedSystemFunction));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RequirementPackage.STEP__USER_STEP:
			return isUserStep() ? Boolean.TRUE : Boolean.FALSE;
		case RequirementPackage.STEP__INCLUDED_USE_CASE:
			if (resolve)
				return getIncludedUseCase();
			return basicGetIncludedUseCase();
		case RequirementPackage.STEP__INCLUDED_SYSTEM_FUNCTION:
			if (resolve)
				return getIncludedSystemFunction();
			return basicGetIncludedSystemFunction();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case RequirementPackage.STEP__USER_STEP:
			setUserStep(((Boolean) newValue).booleanValue());
			return;
		case RequirementPackage.STEP__INCLUDED_USE_CASE:
			setIncludedUseCase((UseCase) newValue);
			return;
		case RequirementPackage.STEP__INCLUDED_SYSTEM_FUNCTION:
			setIncludedSystemFunction((SystemFunction) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case RequirementPackage.STEP__USER_STEP:
			setUserStep(USER_STEP_EDEFAULT);
			return;
		case RequirementPackage.STEP__INCLUDED_USE_CASE:
			setIncludedUseCase((UseCase) null);
			return;
		case RequirementPackage.STEP__INCLUDED_SYSTEM_FUNCTION:
			setIncludedSystemFunction((SystemFunction) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case RequirementPackage.STEP__USER_STEP:
			return userStep != USER_STEP_EDEFAULT;
		case RequirementPackage.STEP__INCLUDED_USE_CASE:
			return includedUseCase != null;
		case RequirementPackage.STEP__INCLUDED_SYSTEM_FUNCTION:
			return includedSystemFunction != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (userStep: ");
		result.append(userStep);
		result.append(')');
		return result.toString();
	}

} // StepImpl
