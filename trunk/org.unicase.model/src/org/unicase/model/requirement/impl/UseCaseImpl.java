/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.requirement.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.requirement.Scenario;
import org.unicase.model.requirement.UseCase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Use Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.requirement.impl.UseCaseImpl#getInitiatingActor <em>Initiating Actor</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.UseCaseImpl#getScenarios <em>Scenarios</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.UseCaseImpl#getParticipatingActors <em>Participating Actors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UseCaseImpl extends EObjectImpl implements UseCase {
	/**
	 * The cached value of the '{@link #getInitiatingActor() <em>Initiating Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitiatingActor()
	 * @generated
	 * @ordered
	 */
	protected Actor initiatingActor;

	/**
	 * The cached value of the '{@link #getScenarios() <em>Scenarios</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenarios()
	 * @generated
	 * @ordered
	 */
	protected EList<Scenario> scenarios;

	/**
	 * The cached value of the '{@link #getParticipatingActors() <em>Participating Actors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipatingActors()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> participatingActors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UseCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementPackage.Literals.USE_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor getInitiatingActor() {
		if (initiatingActor != null && initiatingActor.eIsProxy()) {
			InternalEObject oldInitiatingActor = (InternalEObject)initiatingActor;
			initiatingActor = (Actor)eResolveProxy(oldInitiatingActor);
			if (initiatingActor != oldInitiatingActor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequirementPackage.USE_CASE__INITIATING_ACTOR, oldInitiatingActor, initiatingActor));
			}
		}
		return initiatingActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor basicGetInitiatingActor() {
		return initiatingActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitiatingActor(Actor newInitiatingActor) {
		Actor oldInitiatingActor = initiatingActor;
		initiatingActor = newInitiatingActor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementPackage.USE_CASE__INITIATING_ACTOR, oldInitiatingActor, initiatingActor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Scenario> getScenarios() {
		if (scenarios == null) {
			scenarios = new EObjectWithInverseResolvingEList.ManyInverse<Scenario>(Scenario.class, this, RequirementPackage.USE_CASE__SCENARIOS, RequirementPackage.SCENARIO__INSTANTIATED_USE_CASES);
		}
		return scenarios;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Actor> getParticipatingActors() {
		if (participatingActors == null) {
			participatingActors = new EObjectWithInverseResolvingEList.ManyInverse<Actor>(Actor.class, this, RequirementPackage.USE_CASE__PARTICIPATING_ACTORS, RequirementPackage.ACTOR__PARTICIPATED_USE_CASES);
		}
		return participatingActors;
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
			case RequirementPackage.USE_CASE__SCENARIOS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getScenarios()).basicAdd(otherEnd, msgs);
			case RequirementPackage.USE_CASE__PARTICIPATING_ACTORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParticipatingActors()).basicAdd(otherEnd, msgs);
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
			case RequirementPackage.USE_CASE__SCENARIOS:
				return ((InternalEList<?>)getScenarios()).basicRemove(otherEnd, msgs);
			case RequirementPackage.USE_CASE__PARTICIPATING_ACTORS:
				return ((InternalEList<?>)getParticipatingActors()).basicRemove(otherEnd, msgs);
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
			case RequirementPackage.USE_CASE__INITIATING_ACTOR:
				if (resolve) return getInitiatingActor();
				return basicGetInitiatingActor();
			case RequirementPackage.USE_CASE__SCENARIOS:
				return getScenarios();
			case RequirementPackage.USE_CASE__PARTICIPATING_ACTORS:
				return getParticipatingActors();
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
			case RequirementPackage.USE_CASE__INITIATING_ACTOR:
				setInitiatingActor((Actor)newValue);
				return;
			case RequirementPackage.USE_CASE__SCENARIOS:
				getScenarios().clear();
				getScenarios().addAll((Collection<? extends Scenario>)newValue);
				return;
			case RequirementPackage.USE_CASE__PARTICIPATING_ACTORS:
				getParticipatingActors().clear();
				getParticipatingActors().addAll((Collection<? extends Actor>)newValue);
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
			case RequirementPackage.USE_CASE__INITIATING_ACTOR:
				setInitiatingActor((Actor)null);
				return;
			case RequirementPackage.USE_CASE__SCENARIOS:
				getScenarios().clear();
				return;
			case RequirementPackage.USE_CASE__PARTICIPATING_ACTORS:
				getParticipatingActors().clear();
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
			case RequirementPackage.USE_CASE__INITIATING_ACTOR:
				return initiatingActor != null;
			case RequirementPackage.USE_CASE__SCENARIOS:
				return scenarios != null && !scenarios.isEmpty();
			case RequirementPackage.USE_CASE__PARTICIPATING_ACTORS:
				return participatingActors != null && !participatingActors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //UseCaseImpl
