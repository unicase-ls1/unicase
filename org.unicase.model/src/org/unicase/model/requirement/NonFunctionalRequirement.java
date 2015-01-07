/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.requirement;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.rationale.Criterion;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Non Functional Requirement</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.requirement.NonFunctionalRequirement#getRestrictedScenarios <em>Restricted Scenarios</em>}</li>
 *   <li>{@link org.unicase.model.requirement.NonFunctionalRequirement#getRestrictedUseCases <em>Restricted Use Cases</em>}</li>
 *   <li>{@link org.unicase.model.requirement.NonFunctionalRequirement#getSystemFunctions <em>System Functions</em>}</li>
 *   <li>{@link org.unicase.model.requirement.NonFunctionalRequirement#getUserTasks <em>User Tasks</em>}</li>
 *   <li>{@link org.unicase.model.requirement.NonFunctionalRequirement#isDone <em>Done</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.requirement.RequirementPackage#getNonFunctionalRequirement()
 * @model
 * @generated
 */
public interface NonFunctionalRequirement extends Criterion {

	/**
	 * Returns the value of the '<em><b>Restricted Scenarios</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.Scenario}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.requirement.Scenario#getNonFunctionalRequirements <em>Non Functional Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restricted Scenarios</em>' reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Restricted Scenarios</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getNonFunctionalRequirement_RestrictedScenarios()
	 * @see org.unicase.model.requirement.Scenario#getNonFunctionalRequirements
	 * @model opposite="nonFunctionalRequirements"
	 *        annotation="org.eclipse.emf.ecp.editor priority='9.1' position='right'"
	 * @generated
	 */
	EList<Scenario> getRestrictedScenarios();

	/**
	 * Returns the value of the '<em><b>Restricted Use Cases</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.UseCase}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.requirement.UseCase#getNonFunctionalRequirements <em>Non Functional Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restricted Use Cases</em>' reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Restricted Use Cases</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getNonFunctionalRequirement_RestrictedUseCases()
	 * @see org.unicase.model.requirement.UseCase#getNonFunctionalRequirements
	 * @model opposite="nonFunctionalRequirements"
	 *        annotation="org.eclipse.emf.ecp.editor priority='9.2' position='right'"
	 * @generated
	 */
	EList<UseCase> getRestrictedUseCases();

	/**
	 * Returns the value of the '<em><b>System Functions</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.SystemFunction}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.requirement.SystemFunction#getNonFunctionalRequirement <em>Non Functional Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Functions</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Functions</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getNonFunctionalRequirement_SystemFunctions()
	 * @see org.unicase.model.requirement.SystemFunction#getNonFunctionalRequirement
	 * @model opposite="nonFunctionalRequirement"
	 *        annotation="org.eclipse.emf.ecp.editor priority='13.0' position='right'"
	 * @generated
	 */
	EList<SystemFunction> getSystemFunctions();

	/**
	 * Returns the value of the '<em><b>User Tasks</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.UserTask}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.requirement.UserTask#getNonFunctionalRequirements <em>Non Functional Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Tasks</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Tasks</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getNonFunctionalRequirement_UserTasks()
	 * @see org.unicase.model.requirement.UserTask#getNonFunctionalRequirements
	 * @model opposite="nonFunctionalRequirements"
	 *        annotation="org.eclipse.emf.ecp.editor priority='14.0' position='right'"
	 * @generated
	 */
	EList<UserTask> getUserTasks();

	/**
	 * Returns the value of the '<em><b>Done</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Done</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Done</em>' attribute.
	 * @see #setDone(boolean)
	 * @see org.unicase.model.requirement.RequirementPackage#getNonFunctionalRequirement_Done()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='17.0' position='left'"
	 * @generated
	 */
	boolean isDone();

	/**
	 * Sets the value of the '{@link org.unicase.model.requirement.NonFunctionalRequirement#isDone <em>Done</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Done</em>' attribute.
	 * @see #isDone()
	 * @generated
	 */
	void setDone(boolean value);
} // NonFunctionalRequirement
