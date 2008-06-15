/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.requirement;

import org.eclipse.emf.common.util.EList;

import org.unicase.model.ModelElement;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Actor</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.requirement.Actor#getInitiatedUseCases <em>
 * Initiated Use Cases</em>}</li>
 * <li>{@link org.unicase.model.requirement.Actor#getParticipatedUseCases <em>
 * Participated Use Cases</em>}</li>
 * <li>{@link org.unicase.model.requirement.Actor#getInstances <em>Instances
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.requirement.RequirementPackage#getActor()
 * @model
 * @generated
 */
public interface Actor extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Initiated Use Cases</b></em>' reference
	 * list. The list contents are of type
	 * {@link org.unicase.model.requirement.UseCase}. It is bidirectional and
	 * its opposite is '
	 * {@link org.unicase.model.requirement.UseCase#getInitiatingActor
	 * <em>Initiating Actor</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initiated Use Cases</em>' reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Initiated Use Cases</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getActor_InitiatedUseCases()
	 * @see org.unicase.model.requirement.UseCase#getInitiatingActor
	 * @model opposite="initiatingActor"
	 * @generated
	 */
	EList<UseCase> getInitiatedUseCases();

	/**
	 * Returns the value of the '<em><b>Participated Use Cases</b></em>'
	 * reference list. The list contents are of type
	 * {@link org.unicase.model.requirement.UseCase}. It is bidirectional and
	 * its opposite is '
	 * {@link org.unicase.model.requirement.UseCase#getParticipatingActors
	 * <em>Participating Actors</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participated Use Cases</em>' reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Participated Use Cases</em>' reference
	 *         list.
	 * @see org.unicase.model.requirement.RequirementPackage#getActor_ParticipatedUseCases()
	 * @see org.unicase.model.requirement.UseCase#getParticipatingActors
	 * @model opposite="participatingActors"
	 * @generated
	 */
	EList<UseCase> getParticipatedUseCases();

	/**
	 * Returns the value of the '<em><b>Instances</b></em>' reference list. The
	 * list contents are of type
	 * {@link org.unicase.model.requirement.ActorInstance}. It is bidirectional
	 * and its opposite is '
	 * {@link org.unicase.model.requirement.ActorInstance#getInstantiatedActor
	 * <em>Instantiated Actor</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instances</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Instances</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getActor_Instances()
	 * @see org.unicase.model.requirement.ActorInstance#getInstantiatedActor
	 * @model opposite="instantiatedActor" derived="true"
	 * @generated
	 */
	EList<ActorInstance> getInstances();

} // Actor
