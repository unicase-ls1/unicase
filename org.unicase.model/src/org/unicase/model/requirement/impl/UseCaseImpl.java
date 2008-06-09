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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.impl.ModelElementImpl;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.NonFunctionalRequirement;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.requirement.Scenario;
import org.unicase.model.requirement.Step;
import org.unicase.model.requirement.UseCase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Use Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.requirement.impl.UseCaseImpl#getSteps <em>Steps</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.UseCaseImpl#getInitiatingActor <em>Initiating Actor</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.UseCaseImpl#getParticipatingActors <em>Participating Actors</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.UseCaseImpl#getScenarios <em>Scenarios</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.UseCaseImpl#getFunctionalRequirements <em>Functional Requirements</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.UseCaseImpl#getNonFunctionalRequirements <em>Non Functional Requirements</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.UseCaseImpl#getIdentifiedClasses <em>Identified Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UseCaseImpl extends ModelElementImpl implements UseCase {
	/**
	 * The cached value of the '{@link #getSteps() <em>Steps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteps()
	 * @generated
	 * @ordered
	 */
	protected EList<Step> steps;

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
	 * The cached value of the '{@link #getParticipatingActors() <em>Participating Actors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipatingActors()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> participatingActors;

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
	 * The cached value of the '{@link #getFunctionalRequirements() <em>Functional Requirements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionalRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionalRequirement> functionalRequirements;

	/**
	 * The cached value of the '{@link #getNonFunctionalRequirements() <em>Non Functional Requirements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNonFunctionalRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<NonFunctionalRequirement> nonFunctionalRequirements;

	/**
	 * The cached value of the '{@link #getIdentifiedClasses() <em>Identified Classes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifiedClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<org.unicase.model.classes.Class> identifiedClasses;

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
	public EList<Step> getSteps() {
		if (steps == null) {
			steps = new EObjectContainmentEList<Step>(Step.class, this, RequirementPackage.USE_CASE__STEPS);
		}
		return steps;
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
	public NotificationChain basicSetInitiatingActor(Actor newInitiatingActor, NotificationChain msgs) {
		Actor oldInitiatingActor = initiatingActor;
		initiatingActor = newInitiatingActor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RequirementPackage.USE_CASE__INITIATING_ACTOR, oldInitiatingActor, newInitiatingActor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitiatingActor(Actor newInitiatingActor) {
		if (newInitiatingActor != initiatingActor) {
			NotificationChain msgs = null;
			if (initiatingActor != null)
				msgs = ((InternalEObject)initiatingActor).eInverseRemove(this, RequirementPackage.ACTOR__INITIATED_USE_CASES, Actor.class, msgs);
			if (newInitiatingActor != null)
				msgs = ((InternalEObject)newInitiatingActor).eInverseAdd(this, RequirementPackage.ACTOR__INITIATED_USE_CASES, Actor.class, msgs);
			msgs = basicSetInitiatingActor(newInitiatingActor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementPackage.USE_CASE__INITIATING_ACTOR, newInitiatingActor, newInitiatingActor));
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
	public EList<FunctionalRequirement> getFunctionalRequirements() {
		if (functionalRequirements == null) {
			functionalRequirements = new EObjectWithInverseResolvingEList.ManyInverse<FunctionalRequirement>(FunctionalRequirement.class, this, RequirementPackage.USE_CASE__FUNCTIONAL_REQUIREMENTS, RequirementPackage.FUNCTIONAL_REQUIREMENT__USE_CASES);
		}
		return functionalRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NonFunctionalRequirement> getNonFunctionalRequirements() {
		if (nonFunctionalRequirements == null) {
			nonFunctionalRequirements = new EObjectWithInverseResolvingEList.ManyInverse<NonFunctionalRequirement>(NonFunctionalRequirement.class, this, RequirementPackage.USE_CASE__NON_FUNCTIONAL_REQUIREMENTS, RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__RESTRICTED_USE_CASES);
		}
		return nonFunctionalRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.unicase.model.classes.Class> getIdentifiedClasses() {
		if (identifiedClasses == null) {
			identifiedClasses = new EObjectWithInverseResolvingEList.ManyInverse<org.unicase.model.classes.Class>(org.unicase.model.classes.Class.class, this, RequirementPackage.USE_CASE__IDENTIFIED_CLASSES, ClassesPackage.CLASS__PARTICIPATED_USE_CASES);
		}
		return identifiedClasses;
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
			case RequirementPackage.USE_CASE__INITIATING_ACTOR:
				if (initiatingActor != null)
					msgs = ((InternalEObject)initiatingActor).eInverseRemove(this, RequirementPackage.ACTOR__INITIATED_USE_CASES, Actor.class, msgs);
				return basicSetInitiatingActor((Actor)otherEnd, msgs);
			case RequirementPackage.USE_CASE__PARTICIPATING_ACTORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParticipatingActors()).basicAdd(otherEnd, msgs);
			case RequirementPackage.USE_CASE__SCENARIOS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getScenarios()).basicAdd(otherEnd, msgs);
			case RequirementPackage.USE_CASE__FUNCTIONAL_REQUIREMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFunctionalRequirements()).basicAdd(otherEnd, msgs);
			case RequirementPackage.USE_CASE__NON_FUNCTIONAL_REQUIREMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNonFunctionalRequirements()).basicAdd(otherEnd, msgs);
			case RequirementPackage.USE_CASE__IDENTIFIED_CLASSES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIdentifiedClasses()).basicAdd(otherEnd, msgs);
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
			case RequirementPackage.USE_CASE__STEPS:
				return ((InternalEList<?>)getSteps()).basicRemove(otherEnd, msgs);
			case RequirementPackage.USE_CASE__INITIATING_ACTOR:
				return basicSetInitiatingActor(null, msgs);
			case RequirementPackage.USE_CASE__PARTICIPATING_ACTORS:
				return ((InternalEList<?>)getParticipatingActors()).basicRemove(otherEnd, msgs);
			case RequirementPackage.USE_CASE__SCENARIOS:
				return ((InternalEList<?>)getScenarios()).basicRemove(otherEnd, msgs);
			case RequirementPackage.USE_CASE__FUNCTIONAL_REQUIREMENTS:
				return ((InternalEList<?>)getFunctionalRequirements()).basicRemove(otherEnd, msgs);
			case RequirementPackage.USE_CASE__NON_FUNCTIONAL_REQUIREMENTS:
				return ((InternalEList<?>)getNonFunctionalRequirements()).basicRemove(otherEnd, msgs);
			case RequirementPackage.USE_CASE__IDENTIFIED_CLASSES:
				return ((InternalEList<?>)getIdentifiedClasses()).basicRemove(otherEnd, msgs);
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
			case RequirementPackage.USE_CASE__STEPS:
				return getSteps();
			case RequirementPackage.USE_CASE__INITIATING_ACTOR:
				if (resolve) return getInitiatingActor();
				return basicGetInitiatingActor();
			case RequirementPackage.USE_CASE__PARTICIPATING_ACTORS:
				return getParticipatingActors();
			case RequirementPackage.USE_CASE__SCENARIOS:
				return getScenarios();
			case RequirementPackage.USE_CASE__FUNCTIONAL_REQUIREMENTS:
				return getFunctionalRequirements();
			case RequirementPackage.USE_CASE__NON_FUNCTIONAL_REQUIREMENTS:
				return getNonFunctionalRequirements();
			case RequirementPackage.USE_CASE__IDENTIFIED_CLASSES:
				return getIdentifiedClasses();
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
			case RequirementPackage.USE_CASE__STEPS:
				getSteps().clear();
				getSteps().addAll((Collection<? extends Step>)newValue);
				return;
			case RequirementPackage.USE_CASE__INITIATING_ACTOR:
				setInitiatingActor((Actor)newValue);
				return;
			case RequirementPackage.USE_CASE__PARTICIPATING_ACTORS:
				getParticipatingActors().clear();
				getParticipatingActors().addAll((Collection<? extends Actor>)newValue);
				return;
			case RequirementPackage.USE_CASE__SCENARIOS:
				getScenarios().clear();
				getScenarios().addAll((Collection<? extends Scenario>)newValue);
				return;
			case RequirementPackage.USE_CASE__FUNCTIONAL_REQUIREMENTS:
				getFunctionalRequirements().clear();
				getFunctionalRequirements().addAll((Collection<? extends FunctionalRequirement>)newValue);
				return;
			case RequirementPackage.USE_CASE__NON_FUNCTIONAL_REQUIREMENTS:
				getNonFunctionalRequirements().clear();
				getNonFunctionalRequirements().addAll((Collection<? extends NonFunctionalRequirement>)newValue);
				return;
			case RequirementPackage.USE_CASE__IDENTIFIED_CLASSES:
				getIdentifiedClasses().clear();
				getIdentifiedClasses().addAll((Collection<? extends org.unicase.model.classes.Class>)newValue);
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
			case RequirementPackage.USE_CASE__STEPS:
				getSteps().clear();
				return;
			case RequirementPackage.USE_CASE__INITIATING_ACTOR:
				setInitiatingActor((Actor)null);
				return;
			case RequirementPackage.USE_CASE__PARTICIPATING_ACTORS:
				getParticipatingActors().clear();
				return;
			case RequirementPackage.USE_CASE__SCENARIOS:
				getScenarios().clear();
				return;
			case RequirementPackage.USE_CASE__FUNCTIONAL_REQUIREMENTS:
				getFunctionalRequirements().clear();
				return;
			case RequirementPackage.USE_CASE__NON_FUNCTIONAL_REQUIREMENTS:
				getNonFunctionalRequirements().clear();
				return;
			case RequirementPackage.USE_CASE__IDENTIFIED_CLASSES:
				getIdentifiedClasses().clear();
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
			case RequirementPackage.USE_CASE__STEPS:
				return steps != null && !steps.isEmpty();
			case RequirementPackage.USE_CASE__INITIATING_ACTOR:
				return initiatingActor != null;
			case RequirementPackage.USE_CASE__PARTICIPATING_ACTORS:
				return participatingActors != null && !participatingActors.isEmpty();
			case RequirementPackage.USE_CASE__SCENARIOS:
				return scenarios != null && !scenarios.isEmpty();
			case RequirementPackage.USE_CASE__FUNCTIONAL_REQUIREMENTS:
				return functionalRequirements != null && !functionalRequirements.isEmpty();
			case RequirementPackage.USE_CASE__NON_FUNCTIONAL_REQUIREMENTS:
				return nonFunctionalRequirements != null && !nonFunctionalRequirements.isEmpty();
			case RequirementPackage.USE_CASE__IDENTIFIED_CLASSES:
				return identifiedClasses != null && !identifiedClasses.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //UseCaseImpl
