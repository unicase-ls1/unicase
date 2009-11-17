/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>IClass</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.implementation.IClass#getParentPackage <em>Parent Package</em>}</li>
 * <li>{@link org.unicase.model.implementation.IClass#isAbstract <em>Abstract</em>}</li>
 * <li>{@link org.unicase.model.implementation.IClass#getSuperClasses <em>Super Classes</em>}</li>
 * <li>{@link org.unicase.model.implementation.IClass#getSubClasses <em>Sub Classes</em>}</li>
 * <li>{@link org.unicase.model.implementation.IClass#getAttributes <em>Attributes</em>}</li>
 * <li>{@link org.unicase.model.implementation.IClass#getOutgoingReferences <em>Outgoing References</em>}</li>
 * <li>{@link org.unicase.model.implementation.IClass#getIncomingReferences <em>Incoming References</em>}</li>
 * <li>{@link org.unicase.model.implementation.IClass#getAnalysisClasses <em>Analysis Classes</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.implementation.ImplementationPackage#getIClass()
 * @model
 * @generated
 */
public interface IClass extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Parent Package</b></em>' container reference. It is bidirectional and its
	 * opposite is '{@link org.unicase.model.implementation.IPackage#getClasses <em>Classes</em>}'. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Parent Package</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parent Package</em>' container reference.
	 * @see #setParentPackage(IPackage)
	 * @see org.unicase.model.implementation.ImplementationPackage#getIClass_ParentPackage()
	 * @see org.unicase.model.implementation.IPackage#getClasses
	 * @model opposite="classes" keys="identifier" transient="false"
	 * @generated
	 */
	IPackage getParentPackage();

	/**
	 * Sets the value of the '{@link org.unicase.model.implementation.IClass#getParentPackage <em>Parent Package</em>}'
	 * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Parent Package</em>' container reference.
	 * @see #getParentPackage()
	 * @generated
	 */
	void setParentPackage(IPackage value);

	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see org.unicase.model.implementation.ImplementationPackage#getIClass_Abstract()
	 * @model
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link org.unicase.model.implementation.IClass#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Super Classes</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.implementation.IClass}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.implementation.IClass#getSubClasses <em>Sub Classes</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Classes</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Super Classes</em>' reference list.
	 * @see #isSetSuperClasses()
	 * @see #unsetSuperClasses()
	 * @see org.unicase.model.implementation.ImplementationPackage#getIClass_SuperClasses()
	 * @see org.unicase.model.implementation.IClass#getSubClasses
	 * @model opposite="subClasses" unsettable="true" keys="identifier"
	 * @generated
	 */
	EList<IClass> getSuperClasses();

	/**
	 * Unsets the value of the '{@link org.unicase.model.implementation.IClass#getSuperClasses <em>Super Classes</em>}'
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isSetSuperClasses()
	 * @see #getSuperClasses()
	 * @generated
	 */
	void unsetSuperClasses();

	/**
	 * Returns whether the value of the '{@link org.unicase.model.implementation.IClass#getSuperClasses
	 * <em>Super Classes</em>}' reference list is set. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return whether the value of the '<em>Super Classes</em>' reference list is set.
	 * @see #unsetSuperClasses()
	 * @see #getSuperClasses()
	 * @generated
	 */
	boolean isSetSuperClasses();

	/**
	 * Returns the value of the '<em><b>Sub Classes</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.implementation.IClass}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.implementation.IClass#getSuperClasses <em>Super Classes</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Classes</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Sub Classes</em>' reference list.
	 * @see org.unicase.model.implementation.ImplementationPackage#getIClass_SubClasses()
	 * @see org.unicase.model.implementation.IClass#getSuperClasses
	 * @model opposite="superClasses" keys="identifier"
	 * @generated
	 */
	EList<IClass> getSubClasses();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.model.implementation.IAttribute}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.implementation.IAttribute#getParentClass <em>Parent Class</em>}'. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see org.unicase.model.implementation.ImplementationPackage#getIClass_Attributes()
	 * @see org.unicase.model.implementation.IAttribute#getParentClass
	 * @model opposite="parentClass" containment="true" keys="identifier"
	 * @generated
	 */
	EList<IAttribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Outgoing References</b></em>' containment reference list. The list contents are
	 * of type {@link org.unicase.model.implementation.IReference}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.implementation.IReference#getParentClass <em>Parent Class</em>}'. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Outgoing References</em>' containment reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Outgoing References</em>' containment reference list.
	 * @see org.unicase.model.implementation.ImplementationPackage#getIClass_OutgoingReferences()
	 * @see org.unicase.model.implementation.IReference#getParentClass
	 * @model opposite="parentClass" containment="true" keys="identifier"
	 * @generated
	 */
	EList<IReference> getOutgoingReferences();

	/**
	 * Returns the value of the '<em><b>Incoming References</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.implementation.IReference}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.implementation.IReference#getType <em>Type</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming References</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Incoming References</em>' reference list.
	 * @see org.unicase.model.implementation.ImplementationPackage#getIClass_IncomingReferences()
	 * @see org.unicase.model.implementation.IReference#getType
	 * @model opposite="type" keys="identifier"
	 * @generated
	 */
	EList<IReference> getIncomingReferences();

	/**
	 * Returns the value of the '<em><b>Analysis Classes</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.classes.Class}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.classes.Class#getImplementationClasses <em>Implementation Classes</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analysis Classes</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Analysis Classes</em>' reference list.
	 * @see org.unicase.model.implementation.ImplementationPackage#getIClass_AnalysisClasses()
	 * @see org.unicase.model.classes.Class#getImplementationClasses
	 * @model opposite="implementationClasses" keys="identifier"
	 * @generated
	 */
	EList<org.unicase.model.classes.Class> getAnalysisClasses();

} // IClass
