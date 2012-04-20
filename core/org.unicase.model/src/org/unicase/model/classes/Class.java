/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classes;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.requirement.Scenario;
import org.unicase.model.requirement.UseCase;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Class</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.classes.Class#getInstantiationType <em>Instantiation Type</em>}</li>
 * <li>{@link org.unicase.model.classes.Class#getParticipatedUseCases <em>Participated Use Cases</em>}</li>
 * <li>{@link org.unicase.model.classes.Class#getSuperClasses <em>Super Classes</em>}</li>
 * <li>{@link org.unicase.model.classes.Class#getSubClasses <em>Sub Classes</em>}</li>
 * <li>{@link org.unicase.model.classes.Class#getIncomingAssociations <em>Incoming Associations</em>}</li>
 * <li>{@link org.unicase.model.classes.Class#getOutgoingAssociations <em>Outgoing Associations</em>}</li>
 * <li>{@link org.unicase.model.classes.Class#getAttributes <em>Attributes</em>}</li>
 * <li>{@link org.unicase.model.classes.Class#getMethods <em>Methods</em>}</li>
 * <li>{@link org.unicase.model.classes.Class#getDemoParticipations <em>Demo Participations</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.classes.ClassesPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends PackageElement {

	/**
	 * Returns the value of the '<em><b>Instantiation Type</b></em>' attribute. The literals are from the enumeration
	 * {@link org.unicase.model.classes.InstantiationType}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instantiation Type</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Instantiation Type</em>' attribute.
	 * @see org.unicase.model.classes.InstantiationType
	 * @see #setInstantiationType(InstantiationType)
	 * @see org.unicase.model.classes.ClassesPackage#getClass_InstantiationType()
	 * @model
	 * @generated
	 */
	InstantiationType getInstantiationType();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Class#getInstantiationType <em>Instantiation Type</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Instantiation Type</em>' attribute.
	 * @see org.unicase.model.classes.InstantiationType
	 * @see #getInstantiationType()
	 * @generated
	 */
	void setInstantiationType(InstantiationType value);

	/**
	 * Returns the value of the '<em><b>Participated Use Cases</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.requirement.UseCase}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.requirement.UseCase#getIdentifiedClasses <em>Identified Classes</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participated Use Cases</em>' reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Participated Use Cases</em>' reference list.
	 * @see org.unicase.model.classes.ClassesPackage#getClass_ParticipatedUseCases()
	 * @see org.unicase.model.requirement.UseCase#getIdentifiedClasses
	 * @model opposite="identifiedClasses" keys="identifier"
	 * @generated
	 */
	EList<UseCase> getParticipatedUseCases();

	/**
	 * Returns the value of the '<em><b>Super Classes</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.classes.Class}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.classes.Class#getSubClasses <em>Sub Classes</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Classes</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Super Classes</em>' reference list.
	 * @see org.unicase.model.classes.ClassesPackage#getClass_SuperClasses()
	 * @see org.unicase.model.classes.Class#getSubClasses
	 * @model opposite="subClasses" annotation="org.eclipse.emf.ecp.editor priority='21.0' position='left'"
	 * @generated
	 */
	EList<Class> getSuperClasses();

	/**
	 * Returns the value of the '<em><b>Sub Classes</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.classes.Class}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.classes.Class#getSuperClasses <em>Super Classes</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Classes</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Sub Classes</em>' reference list.
	 * @see org.unicase.model.classes.ClassesPackage#getClass_SubClasses()
	 * @see org.unicase.model.classes.Class#getSuperClasses
	 * @model opposite="superClasses" annotation="org.eclipse.emf.ecp.editor priority='22.0' position='left'"
	 * @generated
	 */
	EList<Class> getSubClasses();

	/**
	 * Returns the value of the '<em><b>Incoming Associations</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.classes.Association}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.classes.Association#getTarget <em>Target</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Associations</em>' reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Incoming Associations</em>' reference list.
	 * @see org.unicase.model.classes.ClassesPackage#getClass_IncomingAssociations()
	 * @see org.unicase.model.classes.Association#getTarget
	 * @model opposite="target" annotation="org.eclipse.emf.ecp.editor priority='20.0' position='right'"
	 * @generated
	 */
	EList<Association> getIncomingAssociations();

	/**
	 * Returns the value of the '<em><b>Outgoing Associations</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.classes.Association}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.classes.Association#getSource <em>Source</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Associations</em>' reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Outgoing Associations</em>' reference list.
	 * @see org.unicase.model.classes.ClassesPackage#getClass_OutgoingAssociations()
	 * @see org.unicase.model.classes.Association#getSource
	 * @model opposite="source" annotation="org.eclipse.emf.ecp.editor priority='21.0' position='right'"
	 * @generated
	 */
	EList<Association> getOutgoingAssociations();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.model.classes.Attribute}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.classes.Attribute#getDefiningClass <em>Defining Class</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see org.unicase.model.classes.ClassesPackage#getClass_Attributes()
	 * @see org.unicase.model.classes.Attribute#getDefiningClass
	 * @model opposite="definingClass" containment="true" resolveProxies="true"
	 *        annotation="org.eclipse.emf.ecp.editor priority='23.0' position='left'"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Methods</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.model.classes.Method}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.classes.Method#getDefiningClass <em>Defining Class</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' containment reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Methods</em>' containment reference list.
	 * @see org.unicase.model.classes.ClassesPackage#getClass_Methods()
	 * @see org.unicase.model.classes.Method#getDefiningClass
	 * @model opposite="definingClass" containment="true" resolveProxies="true"
	 *        annotation="org.eclipse.emf.ecp.editor priority='24.0' position='left'"
	 * @generated
	 */
	EList<Method> getMethods();

	/**
	 * Returns the value of the '<em><b>Demo Participations</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.requirement.Scenario}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.requirement.Scenario#getParticipatingClasses <em>Participating Classes</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Demo Participations</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Demo Participations</em>' reference list.
	 * @see org.unicase.model.classes.ClassesPackage#getClass_DemoParticipations()
	 * @see org.unicase.model.requirement.Scenario#getParticipatingClasses
	 * @model opposite="participatingClasses" keys="identifier"
	 * @generated
	 */
	EList<Scenario> getDemoParticipations();
} // Class
