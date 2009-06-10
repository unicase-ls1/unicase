/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.requirement;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.rationale.Criterion;

/*
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Non Functional Requirement</b></em>'. <!--
 * end-user-doc --> <p> The following features are supported: <ul> <li>{@link
 * org.unicase.model.requirement.NonFunctionalRequirement#getConstrainedScenarios <em>Constrained Scenarios</em>}</li>
 * <li>{@link org.unicase.model.requirement.NonFunctionalRequirement#getConstrainedUseCases <em>Constrained Use
 * Cases</em>}</li> <li>{@link org.unicase.model.requirement.NonFunctionalRequirement#getConstrainedFRs <em>Constrained
 * FRs</em>}</li> </ul> </p>
 * @see org.unicase.model.requirement.RequirementPackage#getNonFunctionalRequirement()
 * @model
 * @generated
 */
public interface NonFunctionalRequirement extends Criterion {

	/**
	 * Returns the value of the '<em><b>Constrained Scenarios</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.Scenario}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.requirement.Scenario#getNonFunctionalRequirements <em>Non Functional Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constrained Scenarios</em>' reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constrained Scenarios</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getNonFunctionalRequirement_ConstrainedScenarios()
	 * @see org.unicase.model.requirement.Scenario#getNonFunctionalRequirements
	 * @model opposite="nonFunctionalRequirements" keys="identifier"
	 *        annotation="org.unicase.ui.meeditor priority='9.1' position='right'"
	 * @generated
	 */
	EList<Scenario> getConstrainedScenarios();

	/**
	 * Returns the value of the '<em><b>Constrained Use Cases</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.UseCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constrained Use Cases</em>' reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constrained Use Cases</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getNonFunctionalRequirement_ConstrainedUseCases()
	 * @model keys="identifier"
	 *        annotation="org.unicase.ui.meeditor priority='9.2' position='right'"
	 * @generated
	 */
	EList<UseCase> getConstrainedUseCases();

	/**
	 * Returns the value of the '<em><b>Constrained FRs</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.requirement.UseCase}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.requirement.UseCase#getConstrainingNFRs <em>Constraining NF Rs</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constrained FRs</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constrained FRs</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getNonFunctionalRequirement_ConstrainedFRs()
	 * @see org.unicase.model.requirement.UseCase#getConstrainingNFRs
	 * @model opposite="constrainingNFRs" keys="identifier"
	 * @generated
	 */
	EList<UseCase> getConstrainedFRs();
} // NonFunctionalRequirement
