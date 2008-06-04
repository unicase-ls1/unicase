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
 * A representation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.requirement.Actor#getInitiatedUseCases <em>Initiated Use Cases</em>}</li>
 *   <li>{@link org.unicase.model.requirement.Actor#getParticipatedUseCases <em>Participated Use Cases</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.requirement.RequirementPackage#getActor()
 * @model
 * @generated
 */
public interface Actor extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Initiated Use Cases</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.UseCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initiated Use Cases</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initiated Use Cases</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getActor_InitiatedUseCases()
	 * @model
	 * @generated
	 */
	EList<UseCase> getInitiatedUseCases();

	/**
	 * Returns the value of the '<em><b>Participated Use Cases</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.UseCase}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.requirement.UseCase#getParticipatingActors <em>Participating Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participated Use Cases</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participated Use Cases</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getActor_ParticipatedUseCases()
	 * @see org.unicase.model.requirement.UseCase#getParticipatingActors
	 * @model opposite="participatingActors"
	 * @generated
	 */
	EList<UseCase> getParticipatedUseCases();

} // Actor
