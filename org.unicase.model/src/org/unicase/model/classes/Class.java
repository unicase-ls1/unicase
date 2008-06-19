/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.classes;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.requirement.UseCase;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Class</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.classes.Class#getParticipatedUseCases <em>Participated Use Cases</em>}</li>
 *   <li>{@link org.unicase.model.classes.Class#getSuperClass <em>Super Class</em>}</li>
 *   <li>{@link org.unicase.model.classes.Class#getSubClasses <em>Sub Classes</em>}</li>
 *   <li>{@link org.unicase.model.classes.Class#getIncomingAssociations <em>Incoming Associations</em>}</li>
 *   <li>{@link org.unicase.model.classes.Class#getOutgoingAssociations <em>Outgoing Associations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.classes.ClassesPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends PackageElement {

	/**
	 * Returns the value of the '<em><b>Participated Use Cases</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.UseCase}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.requirement.UseCase#getIdentifiedClasses <em>Identified Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participated Use Cases</em>' reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participated Use Cases</em>' reference list.
	 * @see org.unicase.model.classes.ClassesPackage#getClass_ParticipatedUseCases()
	 * @see org.unicase.model.requirement.UseCase#getIdentifiedClasses
	 * @model opposite="identifiedClasses"
	 * @generated
	 */
	EList<UseCase> getParticipatedUseCases();

	/**
	 * Returns the value of the '<em><b>Super Class</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.classes.Class#getSubClasses <em>Sub Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Class</em>' reference.
	 * @see #setSuperClass(Class)
	 * @see org.unicase.model.classes.ClassesPackage#getClass_SuperClass()
	 * @see org.unicase.model.classes.Class#getSubClasses
	 * @model opposite="subClasses"
	 * @generated
	 */
	Class getSuperClass();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Class#getSuperClass <em>Super Class</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Super Class</em>' reference.
	 * @see #getSuperClass()
	 * @generated
	 */
	void setSuperClass(Class value);

	/**
	 * Returns the value of the '<em><b>Sub Classes</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.classes.Class}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.classes.Class#getSuperClass <em>Super Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Classes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Classes</em>' reference list.
	 * @see org.unicase.model.classes.ClassesPackage#getClass_SubClasses()
	 * @see org.unicase.model.classes.Class#getSuperClass
	 * @model opposite="superClass"
	 * @generated
	 */
	EList<Class> getSubClasses();

	/**
	 * Returns the value of the '<em><b>Incoming Associations</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.classes.Association}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.classes.Association#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Associations</em>' reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Associations</em>' reference list.
	 * @see org.unicase.model.classes.ClassesPackage#getClass_IncomingAssociations()
	 * @see org.unicase.model.classes.Association#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Association> getIncomingAssociations();

	/**
	 * Returns the value of the '<em><b>Outgoing Associations</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.classes.Association}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.classes.Association#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Associations</em>' reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Associations</em>' reference list.
	 * @see org.unicase.model.classes.ClassesPackage#getClass_OutgoingAssociations()
	 * @see org.unicase.model.classes.Association#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Association> getOutgoingAssociations();
} // Class
