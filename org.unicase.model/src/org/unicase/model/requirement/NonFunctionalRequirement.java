/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian K�gel All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.requirement;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.rationale.Criterion;
import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Non Functional Requirement</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.unicase.model.requirement.NonFunctionalRequirement#getRestrictedScenarios
 * <em>Restricted Scenarios</em>}</li>
 * <li>
 * {@link org.unicase.model.requirement.NonFunctionalRequirement#getRestrictedUseCases
 * <em>Restricted Use Cases</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.requirement.RequirementPackage#getNonFunctionalRequirement()
 * @model
 * @generated
 */
public interface NonFunctionalRequirement extends Criterion {

	/**
	 * Returns the value of the '<em><b>Restricted Scenarios</b></em>' reference
	 * list. The list contents are of type
	 * {@link org.unicase.model.requirement.Scenario}. It is bidirectional and
	 * its opposite is '
	 * {@link org.unicase.model.requirement.Scenario#getNonFunctionalRequirements
	 * <em>Non Functional Requirements</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restricted Scenarios</em>' reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Restricted Scenarios</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getNonFunctionalRequirement_RestrictedScenarios()
	 * @see org.unicase.model.requirement.Scenario#getNonFunctionalRequirements
	 * @model opposite="nonFunctionalRequirements"
	 * @generated
	 */
	EList<Scenario> getRestrictedScenarios();

	/**
	 * Returns the value of the '<em><b>Restricted Use Cases</b></em>' reference
	 * list. The list contents are of type
	 * {@link org.unicase.model.requirement.UseCase}. It is bidirectional and
	 * its opposite is '
	 * {@link org.unicase.model.requirement.UseCase#getNonFunctionalRequirements
	 * <em>Non Functional Requirements</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restricted Use Cases</em>' reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Restricted Use Cases</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getNonFunctionalRequirement_RestrictedUseCases()
	 * @see org.unicase.model.requirement.UseCase#getNonFunctionalRequirements
	 * @model opposite="nonFunctionalRequirements"
	 * @generated
	 */
	EList<UseCase> getRestrictedUseCases();
} // NonFunctionalRequirement
