/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.requirement.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.rationale.impl.CriterionImpl;
import org.unicase.model.requirement.NonFunctionalRequirement;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.requirement.Scenario;
import org.unicase.model.requirement.UseCase;

/*
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Non Functional Requirement</b></em>'. <!--
 * end-user-doc --> <p> The following features are implemented: <ul> <li>{@link
 * org.unicase.model.requirement.impl.NonFunctionalRequirementImpl#getConstrainedScenarios <em>Constrained
 * Scenarios</em>}</li> <li>{@link
 * org.unicase.model.requirement.impl.NonFunctionalRequirementImpl#getConstrainedUseCases <em>Constrained Use
 * Cases</em>}</li> <li>{@link org.unicase.model.requirement.impl.NonFunctionalRequirementImpl#getConstrainedFRs
 * <em>Constrained FRs</em>}</li> </ul> </p>
 * @generated
 */
public class NonFunctionalRequirementImpl extends CriterionImpl implements NonFunctionalRequirement {
	/**
	 * The cached value of the '{@link #getConstrainedScenarios() <em>Constrained Scenarios</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConstrainedScenarios()
	 * @generated
	 * @ordered
	 */
	protected EList<Scenario> constrainedScenarios;
	/**
	 * The cached value of the '{@link #getConstrainedUseCases() <em>Constrained Use Cases</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConstrainedUseCases()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCase> constrainedUseCases;
	/**
	 * The cached value of the '{@link #getConstrainedFRs() <em>Constrained FRs</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConstrainedFRs()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCase> constrainedFRs;

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
	public EList<Scenario> getConstrainedScenarios() {
		if (constrainedScenarios == null) {
			constrainedScenarios = new EObjectWithInverseResolvingEList.ManyInverse<Scenario>(Scenario.class, this,
				RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_SCENARIOS,
				RequirementPackage.SCENARIO__NON_FUNCTIONAL_REQUIREMENTS);
		}
		return constrainedScenarios;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCase> getConstrainedUseCases() {
		if (constrainedUseCases == null) {
			constrainedUseCases = new EObjectResolvingEList<UseCase>(UseCase.class, this,
				RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_USE_CASES);
		}
		return constrainedUseCases;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCase> getConstrainedFRs() {
		if (constrainedFRs == null) {
			constrainedFRs = new EObjectWithInverseResolvingEList.ManyInverse<UseCase>(UseCase.class, this,
				RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FRS,
				RequirementPackage.USE_CASE__CONSTRAINING_NF_RS);
		}
		return constrainedFRs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_SCENARIOS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getConstrainedScenarios()).basicAdd(otherEnd,
				msgs);
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FRS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getConstrainedFRs()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_SCENARIOS:
			return ((InternalEList<?>) getConstrainedScenarios()).basicRemove(otherEnd, msgs);
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FRS:
			return ((InternalEList<?>) getConstrainedFRs()).basicRemove(otherEnd, msgs);
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
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_SCENARIOS:
			return getConstrainedScenarios();
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_USE_CASES:
			return getConstrainedUseCases();
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FRS:
			return getConstrainedFRs();
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
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_SCENARIOS:
			getConstrainedScenarios().clear();
			getConstrainedScenarios().addAll((Collection<? extends Scenario>) newValue);
			return;
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_USE_CASES:
			getConstrainedUseCases().clear();
			getConstrainedUseCases().addAll((Collection<? extends UseCase>) newValue);
			return;
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FRS:
			getConstrainedFRs().clear();
			getConstrainedFRs().addAll((Collection<? extends UseCase>) newValue);
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
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_SCENARIOS:
			getConstrainedScenarios().clear();
			return;
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_USE_CASES:
			getConstrainedUseCases().clear();
			return;
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FRS:
			getConstrainedFRs().clear();
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
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_SCENARIOS:
			return constrainedScenarios != null && !constrainedScenarios.isEmpty();
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_USE_CASES:
			return constrainedUseCases != null && !constrainedUseCases.isEmpty();
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FRS:
			return constrainedFRs != null && !constrainedFRs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // NonFunctionalRequirementImpl
