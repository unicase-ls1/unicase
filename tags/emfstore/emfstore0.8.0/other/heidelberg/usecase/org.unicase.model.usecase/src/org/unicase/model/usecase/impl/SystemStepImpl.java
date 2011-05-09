/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.usecase.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.unicase.model.UnicaseModelElement;

import org.unicase.model.impl.UnicaseModelElementImpl;

import org.unicase.model.requirement.SystemFunction;

import org.unicase.model.usecase.SystemStep;
import org.unicase.model.usecase.UseCase;
import org.unicase.model.usecase.UsecasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.usecase.impl.SystemStepImpl#getException <em>Exception</em>}</li>
 *   <li>{@link org.unicase.model.usecase.impl.SystemStepImpl#getIncludedSystemFunction <em>Included System Function</em>}</li>
 *   <li>{@link org.unicase.model.usecase.impl.SystemStepImpl#getLinkedStep <em>Linked Step</em>}</li>
 *   <li>{@link org.unicase.model.usecase.impl.SystemStepImpl#getUseCase <em>Use Case</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemStepImpl extends UnicaseModelElementImpl implements SystemStep {
	/**
	 * The default value of the '{@link #getException() <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getException()
	 * @generated
	 * @ordered
	 */
	protected static final String EXCEPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getException() <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getException()
	 * @generated
	 * @ordered
	 */
	protected String exception = EXCEPTION_EDEFAULT;

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
	 * The cached value of the '{@link #getLinkedStep() <em>Linked Step</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkedStep()
	 * @generated
	 * @ordered
	 */
	protected UnicaseModelElement linkedStep;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsecasePackage.Literals.SYSTEM_STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getException() {
		return exception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setException(String newException) {
		String oldException = exception;
		exception = newException;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.SYSTEM_STEP__EXCEPTION, oldException, exception));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemFunction getIncludedSystemFunction() {
		if (includedSystemFunction != null && includedSystemFunction.eIsProxy()) {
			InternalEObject oldIncludedSystemFunction = (InternalEObject)includedSystemFunction;
			includedSystemFunction = (SystemFunction)eResolveProxy(oldIncludedSystemFunction);
			if (includedSystemFunction != oldIncludedSystemFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsecasePackage.SYSTEM_STEP__INCLUDED_SYSTEM_FUNCTION, oldIncludedSystemFunction, includedSystemFunction));
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
	public void setIncludedSystemFunction(SystemFunction newIncludedSystemFunction) {
		SystemFunction oldIncludedSystemFunction = includedSystemFunction;
		includedSystemFunction = newIncludedSystemFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.SYSTEM_STEP__INCLUDED_SYSTEM_FUNCTION, oldIncludedSystemFunction, includedSystemFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnicaseModelElement getLinkedStep() {
		if (linkedStep != null && linkedStep.eIsProxy()) {
			InternalEObject oldLinkedStep = (InternalEObject)linkedStep;
			linkedStep = (UnicaseModelElement)eResolveProxy(oldLinkedStep);
			if (linkedStep != oldLinkedStep) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsecasePackage.SYSTEM_STEP__LINKED_STEP, oldLinkedStep, linkedStep));
			}
		}
		return linkedStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnicaseModelElement basicGetLinkedStep() {
		return linkedStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkedStep(UnicaseModelElement newLinkedStep) {
		UnicaseModelElement oldLinkedStep = linkedStep;
		linkedStep = newLinkedStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.SYSTEM_STEP__LINKED_STEP, oldLinkedStep, linkedStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCase getUseCase() {
		if (eContainerFeatureID() != UsecasePackage.SYSTEM_STEP__USE_CASE) return null;
		return (UseCase)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCase basicGetUseCase() {
		if (eContainerFeatureID() != UsecasePackage.SYSTEM_STEP__USE_CASE) return null;
		return (UseCase)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUseCase(UseCase newUseCase, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newUseCase, UsecasePackage.SYSTEM_STEP__USE_CASE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseCase(UseCase newUseCase) {
		if (newUseCase != eInternalContainer() || (eContainerFeatureID() != UsecasePackage.SYSTEM_STEP__USE_CASE && newUseCase != null)) {
			if (EcoreUtil.isAncestor(this, newUseCase))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newUseCase != null)
				msgs = ((InternalEObject)newUseCase).eInverseAdd(this, UsecasePackage.USE_CASE__SYSTEM_STEPS, UseCase.class, msgs);
			msgs = basicSetUseCase(newUseCase, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.SYSTEM_STEP__USE_CASE, newUseCase, newUseCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsecasePackage.SYSTEM_STEP__USE_CASE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetUseCase((UseCase)otherEnd, msgs);
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
			case UsecasePackage.SYSTEM_STEP__USE_CASE:
				return basicSetUseCase(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case UsecasePackage.SYSTEM_STEP__USE_CASE:
				return eInternalContainer().eInverseRemove(this, UsecasePackage.USE_CASE__SYSTEM_STEPS, UseCase.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UsecasePackage.SYSTEM_STEP__EXCEPTION:
				return getException();
			case UsecasePackage.SYSTEM_STEP__INCLUDED_SYSTEM_FUNCTION:
				if (resolve) return getIncludedSystemFunction();
				return basicGetIncludedSystemFunction();
			case UsecasePackage.SYSTEM_STEP__LINKED_STEP:
				if (resolve) return getLinkedStep();
				return basicGetLinkedStep();
			case UsecasePackage.SYSTEM_STEP__USE_CASE:
				if (resolve) return getUseCase();
				return basicGetUseCase();
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
			case UsecasePackage.SYSTEM_STEP__EXCEPTION:
				setException((String)newValue);
				return;
			case UsecasePackage.SYSTEM_STEP__INCLUDED_SYSTEM_FUNCTION:
				setIncludedSystemFunction((SystemFunction)newValue);
				return;
			case UsecasePackage.SYSTEM_STEP__LINKED_STEP:
				setLinkedStep((UnicaseModelElement)newValue);
				return;
			case UsecasePackage.SYSTEM_STEP__USE_CASE:
				setUseCase((UseCase)newValue);
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
			case UsecasePackage.SYSTEM_STEP__EXCEPTION:
				setException(EXCEPTION_EDEFAULT);
				return;
			case UsecasePackage.SYSTEM_STEP__INCLUDED_SYSTEM_FUNCTION:
				setIncludedSystemFunction((SystemFunction)null);
				return;
			case UsecasePackage.SYSTEM_STEP__LINKED_STEP:
				setLinkedStep((UnicaseModelElement)null);
				return;
			case UsecasePackage.SYSTEM_STEP__USE_CASE:
				setUseCase((UseCase)null);
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
			case UsecasePackage.SYSTEM_STEP__EXCEPTION:
				return EXCEPTION_EDEFAULT == null ? exception != null : !EXCEPTION_EDEFAULT.equals(exception);
			case UsecasePackage.SYSTEM_STEP__INCLUDED_SYSTEM_FUNCTION:
				return includedSystemFunction != null;
			case UsecasePackage.SYSTEM_STEP__LINKED_STEP:
				return linkedStep != null;
			case UsecasePackage.SYSTEM_STEP__USE_CASE:
				return basicGetUseCase() != null;
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
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (exception: ");
		result.append(exception);
		result.append(')');
		return result.toString();
	}

} //SystemStepImpl
