/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.requirement.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.unicase.model.impl.ModelElementImpl;

import org.unicase.model.requirement.ActorInstance;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.requirement.Scenario;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.requirement.impl.ActorInstanceImpl#getInitiatedScenarios <em>Initiated Scenarios</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.ActorInstanceImpl#getParticipatedScenarios <em>Participated Scenarios</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActorInstanceImpl extends ModelElementImpl implements ActorInstance {
	/**
	 * The cached value of the '{@link #getInitiatedScenarios() <em>Initiated Scenarios</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitiatedScenarios()
	 * @generated
	 * @ordered
	 */
	protected EList<Scenario> initiatedScenarios;

	/**
	 * The cached value of the '{@link #getParticipatedScenarios() <em>Participated Scenarios</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipatedScenarios()
	 * @generated
	 * @ordered
	 */
	protected EList<Scenario> participatedScenarios;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActorInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementPackage.Literals.ACTOR_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Scenario> getInitiatedScenarios() {
		if (initiatedScenarios == null) {
			initiatedScenarios = new EObjectResolvingEList<Scenario>(Scenario.class, this, RequirementPackage.ACTOR_INSTANCE__INITIATED_SCENARIOS);
		}
		return initiatedScenarios;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Scenario> getParticipatedScenarios() {
		if (participatedScenarios == null) {
			participatedScenarios = new EObjectResolvingEList<Scenario>(Scenario.class, this, RequirementPackage.ACTOR_INSTANCE__PARTICIPATED_SCENARIOS);
		}
		return participatedScenarios;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RequirementPackage.ACTOR_INSTANCE__INITIATED_SCENARIOS:
				return getInitiatedScenarios();
			case RequirementPackage.ACTOR_INSTANCE__PARTICIPATED_SCENARIOS:
				return getParticipatedScenarios();
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
			case RequirementPackage.ACTOR_INSTANCE__INITIATED_SCENARIOS:
				getInitiatedScenarios().clear();
				getInitiatedScenarios().addAll((Collection<? extends Scenario>)newValue);
				return;
			case RequirementPackage.ACTOR_INSTANCE__PARTICIPATED_SCENARIOS:
				getParticipatedScenarios().clear();
				getParticipatedScenarios().addAll((Collection<? extends Scenario>)newValue);
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
			case RequirementPackage.ACTOR_INSTANCE__INITIATED_SCENARIOS:
				getInitiatedScenarios().clear();
				return;
			case RequirementPackage.ACTOR_INSTANCE__PARTICIPATED_SCENARIOS:
				getParticipatedScenarios().clear();
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
			case RequirementPackage.ACTOR_INSTANCE__INITIATED_SCENARIOS:
				return initiatedScenarios != null && !initiatedScenarios.isEmpty();
			case RequirementPackage.ACTOR_INSTANCE__PARTICIPATED_SCENARIOS:
				return participatedScenarios != null && !participatedScenarios.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ActorInstanceImpl
