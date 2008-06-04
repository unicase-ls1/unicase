/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.requirement;

import org.eclipse.emf.common.util.EList;

import org.unicase.model.ModelElement;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Use Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.requirement.UseCase#getSteps <em>Steps</em>}</li>
 *   <li>{@link org.unicase.model.requirement.UseCase#getInitiatingActor <em>Initiating Actor</em>}</li>
 *   <li>{@link org.unicase.model.requirement.UseCase#getParticipatingActors <em>Participating Actors</em>}</li>
 *   <li>{@link org.unicase.model.requirement.UseCase#getScenarios <em>Scenarios</em>}</li>
 *   <li>{@link org.unicase.model.requirement.UseCase#getFunctionalRequirements <em>Functional Requirements</em>}</li>
 *   <li>{@link org.unicase.model.requirement.UseCase#getNonFunctionalRequirements <em>Non Functional Requirements</em>}</li>
 *   <li>{@link org.unicase.model.requirement.UseCase#getIdentifiedClasses <em>Identified Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.requirement.RequirementPackage#getUseCase()
 * @model
 * @generated
 */
public interface UseCase extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Steps</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.Step}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Steps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Steps</em>' containment reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getUseCase_Steps()
	 * @model containment="true"
	 * @generated
	 */
	EList<Step> getSteps();

	/**
	 * Returns the value of the '<em><b>Initiating Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initiating Actor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initiating Actor</em>' reference.
	 * @see #setInitiatingActor(Actor)
	 * @see org.unicase.model.requirement.RequirementPackage#getUseCase_InitiatingActor()
	 * @model
	 * @generated
	 */
	Actor getInitiatingActor();

	/**
	 * Sets the value of the '{@link org.unicase.model.requirement.UseCase#getInitiatingActor <em>Initiating Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initiating Actor</em>' reference.
	 * @see #getInitiatingActor()
	 * @generated
	 */
	void setInitiatingActor(Actor value);

	/**
	 * Returns the value of the '<em><b>Scenarios</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.Scenario}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.requirement.Scenario#getInstantiatedUseCases <em>Instantiated Use Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scenarios</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenarios</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getUseCase_Scenarios()
	 * @see org.unicase.model.requirement.Scenario#getInstantiatedUseCases
	 * @model opposite="instantiatedUseCases"
	 * @generated
	 */
	EList<Scenario> getScenarios();

	/**
	 * Returns the value of the '<em><b>Functional Requirements</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.FunctionalRequirement}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.requirement.FunctionalRequirement#getUseCases <em>Use Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Functional Requirements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functional Requirements</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getUseCase_FunctionalRequirements()
	 * @see org.unicase.model.requirement.FunctionalRequirement#getUseCases
	 * @model opposite="useCases"
	 * @generated
	 */
	EList<FunctionalRequirement> getFunctionalRequirements();

	/**
	 * Returns the value of the '<em><b>Non Functional Requirements</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.NonFunctionalRequirement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Non Functional Requirements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Non Functional Requirements</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getUseCase_NonFunctionalRequirements()
	 * @model
	 * @generated
	 */
	EList<NonFunctionalRequirement> getNonFunctionalRequirements();

	/**
	 * Returns the value of the '<em><b>Identified Classes</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.classes.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identified Classes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identified Classes</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getUseCase_IdentifiedClasses()
	 * @model
	 * @generated
	 */
	EList<org.unicase.model.classes.Class> getIdentifiedClasses();

	/**
	 * Returns the value of the '<em><b>Participating Actors</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.Actor}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.requirement.Actor#getParticipatedUseCases <em>Participated Use Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participating Actors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participating Actors</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getUseCase_ParticipatingActors()
	 * @see org.unicase.model.requirement.Actor#getParticipatedUseCases
	 * @model opposite="participatedUseCases"
	 * @generated
	 */
	EList<Actor> getParticipatingActors();

} // UseCase
