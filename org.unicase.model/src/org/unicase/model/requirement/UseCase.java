/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.requirement;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Use Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.requirement.UseCase#getInitiatingActor <em>Initiating Actor</em>}</li>
 *   <li>{@link org.unicase.model.requirement.UseCase#getScenarios <em>Scenarios</em>}</li>
 *   <li>{@link org.unicase.model.requirement.UseCase#getParticipatingActors <em>Participating Actors</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.requirement.RequirementPackage#getUseCase()
 * @model
 * @generated
 */
public interface UseCase extends EObject {
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
