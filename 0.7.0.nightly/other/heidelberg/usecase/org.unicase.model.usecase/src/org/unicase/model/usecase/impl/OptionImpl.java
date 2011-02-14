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

import org.unicase.model.usecase.ActorStep;
import org.unicase.model.usecase.Option;
import org.unicase.model.usecase.UseCase;
import org.unicase.model.usecase.UsecasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.usecase.impl.OptionImpl#getTargetStep <em>Target Step</em>}</li>
 *   <li>{@link org.unicase.model.usecase.impl.OptionImpl#getSourceStep <em>Source Step</em>}</li>
 *   <li>{@link org.unicase.model.usecase.impl.OptionImpl#getIncludedUseCase <em>Included Use Case</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OptionImpl extends UnicaseModelElementImpl implements Option {
	/**
	 * The cached value of the '{@link #getTargetStep() <em>Target Step</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetStep()
	 * @generated
	 * @ordered
	 */
	protected UnicaseModelElement targetStep;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsecasePackage.Literals.OPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnicaseModelElement getTargetStep() {
		if (targetStep != null && targetStep.eIsProxy()) {
			InternalEObject oldTargetStep = (InternalEObject)targetStep;
			targetStep = (UnicaseModelElement)eResolveProxy(oldTargetStep);
			if (targetStep != oldTargetStep) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsecasePackage.OPTION__TARGET_STEP, oldTargetStep, targetStep));
			}
		}
		return targetStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnicaseModelElement basicGetTargetStep() {
		return targetStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetStep(UnicaseModelElement newTargetStep) {
		UnicaseModelElement oldTargetStep = targetStep;
		targetStep = newTargetStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.OPTION__TARGET_STEP, oldTargetStep, targetStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorStep getSourceStep() {
		if (eContainerFeatureID() != UsecasePackage.OPTION__SOURCE_STEP) return null;
		return (ActorStep)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorStep basicGetSourceStep() {
		if (eContainerFeatureID() != UsecasePackage.OPTION__SOURCE_STEP) return null;
		return (ActorStep)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceStep(ActorStep newSourceStep, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSourceStep, UsecasePackage.OPTION__SOURCE_STEP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceStep(ActorStep newSourceStep) {
		if (newSourceStep != eInternalContainer() || (eContainerFeatureID() != UsecasePackage.OPTION__SOURCE_STEP && newSourceStep != null)) {
			if (EcoreUtil.isAncestor(this, newSourceStep))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSourceStep != null)
				msgs = ((InternalEObject)newSourceStep).eInverseAdd(this, UsecasePackage.ACTOR_STEP__OPTIONS, ActorStep.class, msgs);
			msgs = basicSetSourceStep(newSourceStep, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.OPTION__SOURCE_STEP, newSourceStep, newSourceStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCase getIncludedUseCase() {
		if (includedUseCase != null && includedUseCase.eIsProxy()) {
			InternalEObject oldIncludedUseCase = (InternalEObject)includedUseCase;
			includedUseCase = (UseCase)eResolveProxy(oldIncludedUseCase);
			if (includedUseCase != oldIncludedUseCase) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsecasePackage.OPTION__INCLUDED_USE_CASE, oldIncludedUseCase, includedUseCase));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.OPTION__INCLUDED_USE_CASE, oldIncludedUseCase, includedUseCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsecasePackage.OPTION__SOURCE_STEP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSourceStep((ActorStep)otherEnd, msgs);
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
			case UsecasePackage.OPTION__SOURCE_STEP:
				return basicSetSourceStep(null, msgs);
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
			case UsecasePackage.OPTION__SOURCE_STEP:
				return eInternalContainer().eInverseRemove(this, UsecasePackage.ACTOR_STEP__OPTIONS, ActorStep.class, msgs);
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
			case UsecasePackage.OPTION__TARGET_STEP:
				if (resolve) return getTargetStep();
				return basicGetTargetStep();
			case UsecasePackage.OPTION__SOURCE_STEP:
				if (resolve) return getSourceStep();
				return basicGetSourceStep();
			case UsecasePackage.OPTION__INCLUDED_USE_CASE:
				if (resolve) return getIncludedUseCase();
				return basicGetIncludedUseCase();
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
			case UsecasePackage.OPTION__TARGET_STEP:
				setTargetStep((UnicaseModelElement)newValue);
				return;
			case UsecasePackage.OPTION__SOURCE_STEP:
				setSourceStep((ActorStep)newValue);
				return;
			case UsecasePackage.OPTION__INCLUDED_USE_CASE:
				setIncludedUseCase((UseCase)newValue);
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
			case UsecasePackage.OPTION__TARGET_STEP:
				setTargetStep((UnicaseModelElement)null);
				return;
			case UsecasePackage.OPTION__SOURCE_STEP:
				setSourceStep((ActorStep)null);
				return;
			case UsecasePackage.OPTION__INCLUDED_USE_CASE:
				setIncludedUseCase((UseCase)null);
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
			case UsecasePackage.OPTION__TARGET_STEP:
				return targetStep != null;
			case UsecasePackage.OPTION__SOURCE_STEP:
				return basicGetSourceStep() != null;
			case UsecasePackage.OPTION__INCLUDED_USE_CASE:
				return includedUseCase != null;
		}
		return super.eIsSet(featureID);
	}

} //OptionImpl
