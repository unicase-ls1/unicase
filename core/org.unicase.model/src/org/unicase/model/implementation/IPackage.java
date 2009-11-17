/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>IPackage</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.implementation.IPackage#getNamespace <em>Namespace</em>}</li>
 * <li>{@link org.unicase.model.implementation.IPackage#getParentPackage <em>Parent Package</em>}</li>
 * <li>{@link org.unicase.model.implementation.IPackage#getSubPackages <em>Sub Packages</em>}</li>
 * <li>{@link org.unicase.model.implementation.IPackage#getClasses <em>Classes</em>}</li>
 * <li>{@link org.unicase.model.implementation.IPackage#getEnumerations <em>Enumerations</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.implementation.ImplementationPackage#getIPackage()
 * @model
 * @generated
 */
public interface IPackage extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Namespace</em>' attribute.
	 * @see #setNamespace(String)
	 * @see org.unicase.model.implementation.ImplementationPackage#getIPackage_Namespace()
	 * @model
	 * @generated
	 */
	String getNamespace();

	/**
	 * Sets the value of the '{@link org.unicase.model.implementation.IPackage#getNamespace <em>Namespace</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Namespace</em>' attribute.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(String value);

	/**
	 * Returns the value of the '<em><b>Parent Package</b></em>' container reference. It is bidirectional and its
	 * opposite is '{@link org.unicase.model.implementation.IPackage#getSubPackages <em>Sub Packages</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Package</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parent Package</em>' container reference.
	 * @see #setParentPackage(IPackage)
	 * @see org.unicase.model.implementation.ImplementationPackage#getIPackage_ParentPackage()
	 * @see org.unicase.model.implementation.IPackage#getSubPackages
	 * @model opposite="subPackages" keys="identifier" transient="false"
	 * @generated
	 */
	IPackage getParentPackage();

	/**
	 * Sets the value of the '{@link org.unicase.model.implementation.IPackage#getParentPackage <em>Parent Package</em>}
	 * ' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Parent Package</em>' container reference.
	 * @see #getParentPackage()
	 * @generated
	 */
	void setParentPackage(IPackage value);

	/**
	 * Returns the value of the '<em><b>Sub Packages</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.model.implementation.IPackage}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.implementation.IPackage#getParentPackage <em>Parent Package</em>}'. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Sub Packages</em>' containment reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Sub Packages</em>' containment reference list.
	 * @see org.unicase.model.implementation.ImplementationPackage#getIPackage_SubPackages()
	 * @see org.unicase.model.implementation.IPackage#getParentPackage
	 * @model opposite="parentPackage" containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<IPackage> getSubPackages();

	/**
	 * Returns the value of the '<em><b>Classes</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.model.implementation.IClass}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.implementation.IClass#getParentPackage <em>Parent Package</em>}'. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Classes</em>' containment reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Classes</em>' containment reference list.
	 * @see org.unicase.model.implementation.ImplementationPackage#getIPackage_Classes()
	 * @see org.unicase.model.implementation.IClass#getParentPackage
	 * @model opposite="parentPackage" containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<IClass> getClasses();

	/**
	 * Returns the value of the '<em><b>Enumerations</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.model.implementation.IEnumeration}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.implementation.IEnumeration#getParentPackage <em>Parent Package</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumerations</em>' containment reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Enumerations</em>' containment reference list.
	 * @see org.unicase.model.implementation.ImplementationPackage#getIPackage_Enumerations()
	 * @see org.unicase.model.implementation.IEnumeration#getParentPackage
	 * @model opposite="parentPackage" containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<IEnumeration> getEnumerations();

} // IPackage
