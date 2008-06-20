/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.requirement.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.rationale.impl.CriterionImpl;
import org.unicase.model.requirement.NonFunctionalRequirement;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.requirement.Scenario;
import org.unicase.model.requirement.UseCase;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Non Functional Requirement</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.requirement.impl.NonFunctionalRequirementImpl#getRestrictedScenarios <em>Restricted Scenarios</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.NonFunctionalRequirementImpl#getRestrictedUseCases <em>Restricted Use Cases</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NonFunctionalRequirementImpl extends CriterionImpl implements
		NonFunctionalRequirement {
	/**
	 * The cached value of the '{@link #getRestrictedScenarios() <em>Restricted Scenarios</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestrictedScenarios()
	 * @generated
	 * @ordered
	 */
	protected EList<Scenario> restrictedScenarios;
	/**
	 * The cached value of the '{@link #getRestrictedUseCases() <em>Restricted Use Cases</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestrictedUseCases()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCase> restrictedUseCases;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected NonFunctionalRequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementPackage.Literals.NON_FUNCTIONAL_REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Scenario> getRestrictedScenarios() {
		if (restrictedScenarios == null) {
			restrictedScenarios = new EObjectWithInverseResolvingEList.ManyInverse<Scenario>(
					Scenario.class,
					this,
					RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__RESTRICTED_SCENARIOS,
					RequirementPackage.SCENARIO__NON_FUNCTIONAL_REQUIREMENTS);
		}
		return restrictedScenarios;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCase> getRestrictedUseCases() {
		if (restrictedUseCases == null) {
			restrictedUseCases = new EObjectWithInverseResolvingEList.ManyInverse<UseCase>(
					UseCase.class,
					this,
					RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__RESTRICTED_USE_CASES,
					RequirementPackage.USE_CASE__NON_FUNCTIONAL_REQUIREMENTS);
		}
		return restrictedUseCases;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__RESTRICTED_SCENARIOS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getRestrictedScenarios())
					.basicAdd(otherEnd, msgs);
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__RESTRICTED_USE_CASES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getRestrictedUseCases())
					.basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__RESTRICTED_SCENARIOS:
			return ((InternalEList<?>) getRestrictedScenarios()).basicRemove(
					otherEnd, msgs);
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__RESTRICTED_USE_CASES:
			return ((InternalEList<?>) getRestrictedUseCases()).basicRemove(
					otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__RESTRICTED_SCENARIOS:
			return getRestrictedScenarios();
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__RESTRICTED_USE_CASES:
			return getRestrictedUseCases();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__RESTRICTED_SCENARIOS:
			getRestrictedScenarios().clear();
			getRestrictedScenarios().addAll(
					(Collection<? extends Scenario>) newValue);
			return;
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__RESTRICTED_USE_CASES:
			getRestrictedUseCases().clear();
			getRestrictedUseCases().addAll(
					(Collection<? extends UseCase>) newValue);
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
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__RESTRICTED_SCENARIOS:
			getRestrictedScenarios().clear();
			return;
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__RESTRICTED_USE_CASES:
			getRestrictedUseCases().clear();
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
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__RESTRICTED_SCENARIOS:
			return restrictedScenarios != null
					&& !restrictedScenarios.isEmpty();
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__RESTRICTED_USE_CASES:
			return restrictedUseCases != null && !restrictedUseCases.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // NonFunctionalRequirementImpl
