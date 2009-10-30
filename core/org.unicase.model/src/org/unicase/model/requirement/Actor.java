/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.requirement;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Actor</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.requirement.Actor#getInitiatedUserTask <em>Initiated User Task</em>}</li>
 * <li>{@link org.unicase.model.requirement.Actor#getParticipatedUserTasks <em>Participated User Tasks</em>}</li>
 * <li>{@link org.unicase.model.requirement.Actor#getInitiatedUseCases <em>Initiated Use Cases</em>}</li>
 * <li>{@link org.unicase.model.requirement.Actor#getParticipatedUseCases <em>Participated Use Cases</em>}</li>
 * <li>{@link org.unicase.model.requirement.Actor#getInstances <em>Instances</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.requirement.RequirementPackage#getActor()
 * @model
 * @generated
 */
public interface Actor extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Initiated User Task</b></em>' reference. It is bidirectional and its opposite is
	 * '{@link org.unicase.model.requirement.UserTask#getInitiatingActor <em>Initiating Actor</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initiated User Task</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Initiated User Task</em>' reference.
	 * @see #setInitiatedUserTask(UserTask)
	 * @see org.unicase.model.requirement.RequirementPackage#getActor_InitiatedUserTask()
	 * @see org.unicase.model.requirement.UserTask#getInitiatingActor
	 * @model opposite="initiatingActor" keys="identifier"
	 * @generated
	 */
	UserTask getInitiatedUserTask();

	/**
	 * Sets the value of the '{@link org.unicase.model.requirement.Actor#getInitiatedUserTask
	 * <em>Initiated User Task</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Initiated User Task</em>' reference.
	 * @see #getInitiatedUserTask()
	 * @generated
	 */
	void setInitiatedUserTask(UserTask value);

	/**
	 * Returns the value of the '<em><b>Participated User Tasks</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.requirement.UserTask}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.requirement.UserTask#getParticipatingActor <em>Participating Actor</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participated User Tasks</em>' reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Participated User Tasks</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getActor_ParticipatedUserTasks()
	 * @see org.unicase.model.requirement.UserTask#getParticipatingActor
	 * @model opposite="participatingActor" keys="identifier"
	 * @generated
	 */
	EList<UserTask> getParticipatedUserTasks();

	/**
	 * Returns the value of the '<em><b>Initiated Use Cases</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.requirement.UseCase}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.requirement.UseCase#getInitiatingActor <em>Initiating Actor</em>}'. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Initiated Use Cases</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Initiated Use Cases</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getActor_InitiatedUseCases()
	 * @see org.unicase.model.requirement.UseCase#getInitiatingActor
	 * @model opposite="initiatingActor" annotation="org.unicase.ui.meeditor priority='10.0' position='right'"
	 * @generated
	 */
	EList<UseCase> getInitiatedUseCases();

	/**
	 * Returns the value of the '<em><b>Participated Use Cases</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.requirement.UseCase}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.requirement.UseCase#getParticipatingActors <em>Participating Actors</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participated Use Cases</em>' reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Participated Use Cases</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getActor_ParticipatedUseCases()
	 * @see org.unicase.model.requirement.UseCase#getParticipatingActors
	 * @model opposite="participatingActors" keys="identifier"
	 *        annotation="org.unicase.ui.meeditor priority='11.0' position='right'"
	 * @generated
	 */
	EList<UseCase> getParticipatedUseCases();

	/**
	 * Returns the value of the '<em><b>Instances</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.requirement.ActorInstance}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.requirement.ActorInstance#getInstantiatedActor <em>Instantiated Actor</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instances</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Instances</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getActor_Instances()
	 * @see org.unicase.model.requirement.ActorInstance#getInstantiatedActor
	 * @model opposite="instantiatedActor" keys="identifier"
	 *        annotation="org.unicase.ui.meeditor priority='12.0' position='right'"
	 * @generated
	 */
	EList<ActorInstance> getInstances();

} // Actor
