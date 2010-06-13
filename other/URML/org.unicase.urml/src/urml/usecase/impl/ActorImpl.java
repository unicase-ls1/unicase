/**
 * <copyright> </copyright> $Id$
 */
package urml.usecase.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import urml.danger.Danger;
import urml.danger.DangerPackage;

import urml.danger.impl.AssetImpl;

import urml.usecase.Actor;
import urml.usecase.UseCase;
import urml.usecase.UsecasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link urml.usecase.impl.ActorImpl#getUseCases <em>Use Cases</em>}</li>
 *   <li>{@link urml.usecase.impl.ActorImpl#getTriggeredDangers <em>Triggered Dangers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActorImpl extends AssetImpl implements Actor {
	/**
	 * The cached value of the '{@link #getUseCases() <em>Use Cases</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseCases()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCase> useCases;

	/**
	 * The cached value of the '{@link #getTriggeredDangers() <em>Triggered Dangers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggeredDangers()
	 * @generated
	 * @ordered
	 */
	protected EList<Danger> triggeredDangers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsecasePackage.Literals.ACTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCase> getUseCases() {
		if (useCases == null) {
			useCases = new EObjectWithInverseResolvingEList.ManyInverse<UseCase>(UseCase.class, this,
				UsecasePackage.ACTOR__USE_CASES, UsecasePackage.USE_CASE__ACTORS);
		}
		return useCases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Danger> getTriggeredDangers() {
		if (triggeredDangers == null) {
			triggeredDangers = new EObjectWithInverseResolvingEList.ManyInverse<Danger>(Danger.class, this,
				UsecasePackage.ACTOR__TRIGGERED_DANGERS, DangerPackage.DANGER__TRIGGERING_ACTORS);
		}
		return triggeredDangers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case UsecasePackage.ACTOR__USE_CASES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getUseCases()).basicAdd(otherEnd, msgs);
		case UsecasePackage.ACTOR__TRIGGERED_DANGERS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getTriggeredDangers()).basicAdd(otherEnd, msgs);
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
		case UsecasePackage.ACTOR__USE_CASES:
			return ((InternalEList<?>) getUseCases()).basicRemove(otherEnd, msgs);
		case UsecasePackage.ACTOR__TRIGGERED_DANGERS:
			return ((InternalEList<?>) getTriggeredDangers()).basicRemove(otherEnd, msgs);
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
		case UsecasePackage.ACTOR__USE_CASES:
			return getUseCases();
		case UsecasePackage.ACTOR__TRIGGERED_DANGERS:
			return getTriggeredDangers();
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
		case UsecasePackage.ACTOR__USE_CASES:
			getUseCases().clear();
			getUseCases().addAll((Collection<? extends UseCase>) newValue);
			return;
		case UsecasePackage.ACTOR__TRIGGERED_DANGERS:
			getTriggeredDangers().clear();
			getTriggeredDangers().addAll((Collection<? extends Danger>) newValue);
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
		case UsecasePackage.ACTOR__USE_CASES:
			getUseCases().clear();
			return;
		case UsecasePackage.ACTOR__TRIGGERED_DANGERS:
			getTriggeredDangers().clear();
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
		case UsecasePackage.ACTOR__USE_CASES:
			return useCases != null && !useCases.isEmpty();
		case UsecasePackage.ACTOR__TRIGGERED_DANGERS:
			return triggeredDangers != null && !triggeredDangers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ActorImpl
