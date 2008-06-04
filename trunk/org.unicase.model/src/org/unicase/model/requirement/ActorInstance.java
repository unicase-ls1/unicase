/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.requirement;

import org.eclipse.emf.common.util.EList;

import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.requirement.ActorInstance#getInitiatedScenarios <em>Initiated Scenarios</em>}</li>
 *   <li>{@link org.unicase.model.requirement.ActorInstance#getParticipatedScenarios <em>Participated Scenarios</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.requirement.RequirementPackage#getActorInstance()
 * @model
 * @generated
 */
public interface ActorInstance extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Initiated Scenarios</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.Scenario}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initiated Scenarios</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initiated Scenarios</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getActorInstance_InitiatedScenarios()
	 * @model
	 * @generated
	 */
	EList<Scenario> getInitiatedScenarios();

	/**
	 * Returns the value of the '<em><b>Participated Scenarios</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.Scenario}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participated Scenarios</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participated Scenarios</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getActorInstance_ParticipatedScenarios()
	 * @model
	 * @generated
	 */
	EList<Scenario> getParticipatedScenarios();

} // ActorInstance
