/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.requirement;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Use Case</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.requirement.UseCase#getInitiatingActor <em>Initiating Actor</em>}</li>
 *   <li>{@link org.unicase.model.requirement.UseCase#getParticipatingActors <em>Participating Actors</em>}</li>
 *   <li>{@link org.unicase.model.requirement.UseCase#getRealizedUserTask <em>Realized User Task</em>}</li>
 *   <li>{@link org.unicase.model.requirement.UseCase#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link org.unicase.model.requirement.UseCase#getUseCaseSteps <em>Use Case Steps</em>}</li>
 *   <li>{@link org.unicase.model.requirement.UseCase#getPostcondition <em>Postcondition</em>}</li>
 *   <li>{@link org.unicase.model.requirement.UseCase#getRules <em>Rules</em>}</li>
 *   <li>{@link org.unicase.model.requirement.UseCase#getException <em>Exception</em>}</li>
 *   <li>{@link org.unicase.model.requirement.UseCase#getScenarios <em>Scenarios</em>}</li>
 *   <li>{@link org.unicase.model.requirement.UseCase#getFunctionalRequirements <em>Functional Requirements</em>}</li>
 *   <li>{@link org.unicase.model.requirement.UseCase#getNonFunctionalRequirements <em>Non Functional Requirements</em>}</li>
 *   <li>{@link org.unicase.model.requirement.UseCase#getIdentifiedClasses <em>Identified Classes</em>}</li>
 *   <li>{@link org.unicase.model.requirement.UseCase#getIncludedUseCases <em>Included Use Cases</em>}</li>
 *   <li>{@link org.unicase.model.requirement.UseCase#getExtendedUseCases <em>Extended Use Cases</em>}</li>
 *   <li>{@link org.unicase.model.requirement.UseCase#getSystemFunctions <em>System Functions</em>}</li>
 *   <li>{@link org.unicase.model.requirement.UseCase#isDone <em>Done</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.requirement.RequirementPackage#getUseCase()
 * @model
 * @generated
 */
public interface UseCase extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Initiating Actor</b></em>' reference. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.requirement.Actor#getInitiatedUseCases <em>Initiated Use Cases</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initiating Actor</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Initiating Actor</em>' reference.
	 * @see #setInitiatingActor(Actor)
	 * @see org.unicase.model.requirement.RequirementPackage#getUseCase_InitiatingActor()
	 * @see org.unicase.model.requirement.Actor#getInitiatedUseCases
	 * @model opposite="initiatedUseCases" keys="identifier"
	 * @generated
	 */
	Actor getInitiatingActor();

	/**
	 * Sets the value of the '{@link org.unicase.model.requirement.UseCase#getInitiatingActor <em>Initiating Actor</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initiating Actor</em>' reference.
	 * @see #getInitiatingActor()
	 * @generated
	 */
	void setInitiatingActor(Actor value);

	/**
	 * Returns the value of the '<em><b>Scenarios</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.requirement.Scenario}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.requirement.Scenario#getInstantiatedUseCases <em>Instantiated Use Cases</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scenarios</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Scenarios</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getUseCase_Scenarios()
	 * @see org.unicase.model.requirement.Scenario#getInstantiatedUseCases
	 * @model opposite="instantiatedUseCases" keys="identifier"
	 * @generated
	 */
	EList<Scenario> getScenarios();

	/**
	 * Returns the value of the '<em><b>Functional Requirements</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.FunctionalRequirement}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.requirement.FunctionalRequirement#getUseCases <em>Use Cases</em>}'.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Functional Requirements</em>' reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functional Requirements</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getUseCase_FunctionalRequirements()
	 * @see org.unicase.model.requirement.FunctionalRequirement#getUseCases
	 * @model opposite="useCases"
	 *        annotation="org.eclipse.emf.ecp.editor priority='11.0' position='right'"
	 * @generated
	 */
	EList<FunctionalRequirement> getFunctionalRequirements();

	/**
	 * Returns the value of the '<em><b>Non Functional Requirements</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.NonFunctionalRequirement}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.requirement.NonFunctionalRequirement#getRestrictedUseCases <em>Restricted Use Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Non Functional Requirements</em>' reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Non Functional Requirements</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getUseCase_NonFunctionalRequirements()
	 * @see org.unicase.model.requirement.NonFunctionalRequirement#getRestrictedUseCases
	 * @model opposite="restrictedUseCases"
	 *        annotation="org.eclipse.emf.ecp.editor priority='12.0' position='right'"
	 * @generated
	 */
	EList<NonFunctionalRequirement> getNonFunctionalRequirements();

	/**
	 * Returns the value of the '<em><b>Identified Classes</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.classes.Class}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.classes.Class#getParticipatedUseCases <em>Participated Use Cases</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identified Classes</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Identified Classes</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getUseCase_IdentifiedClasses()
	 * @see org.unicase.model.classes.Class#getParticipatedUseCases
	 * @model opposite="participatedUseCases" keys="identifier"
	 * @generated
	 */
	EList<org.unicase.model.classes.Class> getIdentifiedClasses();

	/**
	 * Returns the value of the '<em><b>Included Use Cases</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.UseCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Included Use Cases</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Included Use Cases</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getUseCase_IncludedUseCases()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='12.0' position='left'"
	 * @generated
	 */
	EList<UseCase> getIncludedUseCases();

	/**
	 * Returns the value of the '<em><b>Extended Use Cases</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.UseCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extended Use Cases</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extended Use Cases</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getUseCase_ExtendedUseCases()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='13.0' position='left'"
	 * @generated
	 */
	EList<UseCase> getExtendedUseCases();

	/**
	 * Returns the value of the '<em><b>System Functions</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.SystemFunction}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.requirement.SystemFunction#getUsecases <em>Usecases</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Functions</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Functions</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getUseCase_SystemFunctions()
	 * @see org.unicase.model.requirement.SystemFunction#getUsecases
	 * @model opposite="usecases"
	 *        annotation="org.eclipse.emf.ecp.editor priority='15.0' position='right'"
	 * @generated
	 */
	EList<SystemFunction> getSystemFunctions();

	/**
	 * Returns the value of the '<em><b>Done</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Done</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Done</em>' attribute.
	 * @see #setDone(boolean)
	 * @see org.unicase.model.requirement.RequirementPackage#getUseCase_Done()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='17.0' position='left'"
	 * @generated
	 */
	boolean isDone();

	/**
	 * Sets the value of the '{@link org.unicase.model.requirement.UseCase#isDone <em>Done</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Done</em>' attribute.
	 * @see #isDone()
	 * @generated
	 */
	void setDone(boolean value);

	/**
	 * Returns the value of the '<em><b>Participating Actors</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.requirement.Actor}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.requirement.Actor#getParticipatedUseCases <em>Participated Use Cases</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participating Actors</em>' reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Participating Actors</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getUseCase_ParticipatingActors()
	 * @see org.unicase.model.requirement.Actor#getParticipatedUseCases
	 * @model opposite="participatedUseCases" keys="identifier"
	 * @generated
	 */
	EList<Actor> getParticipatingActors();

	/**
	 * Returns the value of the '<em><b>Realized User Task</b></em>' reference. It is bidirectional and its opposite is
	 * '{@link org.unicase.model.requirement.UserTask#getRealizingUseCases <em>Realizing Use Cases</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realized User Task</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Realized User Task</em>' reference.
	 * @see #setRealizedUserTask(UserTask)
	 * @see org.unicase.model.requirement.RequirementPackage#getUseCase_RealizedUserTask()
	 * @see org.unicase.model.requirement.UserTask#getRealizingUseCases
	 * @model opposite="realizingUseCases" keys="identifier"
	 * @generated
	 */
	UserTask getRealizedUserTask();

	/**
	 * Sets the value of the '{@link org.unicase.model.requirement.UseCase#getRealizedUserTask <em>Realized User Task</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Realized User Task</em>' reference.
	 * @see #getRealizedUserTask()
	 * @generated
	 */
	void setRealizedUserTask(UserTask value);

	/**
	 * Returns the value of the '<em><b>Precondition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precondition</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precondition</em>' attribute.
	 * @see #setPrecondition(String)
	 * @see org.unicase.model.requirement.RequirementPackage#getUseCase_Precondition()
	 * @model
	 * @generated
	 */
	String getPrecondition();

	/**
	 * Sets the value of the '{@link org.unicase.model.requirement.UseCase#getPrecondition <em>Precondition</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precondition</em>' attribute.
	 * @see #getPrecondition()
	 * @generated
	 */
	void setPrecondition(String value);

	/**
	 * Returns the value of the '<em><b>Use Case Steps</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.Step}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.requirement.Step#getUseCase <em>Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Case Steps</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Case Steps</em>' containment reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getUseCase_UseCaseSteps()
	 * @see org.unicase.model.requirement.Step#getUseCase
	 * @model opposite="useCase" containment="true" resolveProxies="true"
	 *        annotation="org.eclipse.emf.ecp.editor priority='10.1' position='bottom'"
	 * @generated
	 */
	EList<Step> getUseCaseSteps();

	/**
	 * Returns the value of the '<em><b>Postcondition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postcondition</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postcondition</em>' attribute.
	 * @see #setPostcondition(String)
	 * @see org.unicase.model.requirement.RequirementPackage#getUseCase_Postcondition()
	 * @model
	 * @generated
	 */
	String getPostcondition();

	/**
	 * Sets the value of the '{@link org.unicase.model.requirement.UseCase#getPostcondition <em>Postcondition</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Postcondition</em>' attribute.
	 * @see #getPostcondition()
	 * @generated
	 */
	void setPostcondition(String value);

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' attribute. The default value is <code>""</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Rules</em>' attribute.
	 * @see #setRules(String)
	 * @see org.unicase.model.requirement.RequirementPackage#getUseCase_Rules()
	 * @model default=""
	 * @generated
	 */
	String getRules();

	/**
	 * Sets the value of the '{@link org.unicase.model.requirement.UseCase#getRules <em>Rules</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Rules</em>' attribute.
	 * @see #getRules()
	 * @generated
	 */
	void setRules(String value);

	/**
	 * Returns the value of the '<em><b>Exception</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception</em>' attribute.
	 * @see #setException(String)
	 * @see org.unicase.model.requirement.RequirementPackage#getUseCase_Exception()
	 * @model
	 * @generated
	 */
	String getException();

	/**
	 * Sets the value of the '{@link org.unicase.model.requirement.UseCase#getException <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception</em>' attribute.
	 * @see #getException()
	 * @generated
	 */
	void setException(String value);

} // UseCase
