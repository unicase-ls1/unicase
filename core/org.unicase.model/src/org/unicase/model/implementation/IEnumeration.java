/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>IEnumeration</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.implementation.IEnumeration#getParentPackage <em>Parent Package</em>}</li>
 * <li>{@link org.unicase.model.implementation.IEnumeration#getLiterals <em>Literals</em>}</li>
 * <li>{@link org.unicase.model.implementation.IEnumeration#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.implementation.ImplementationPackage#getIEnumeration()
 * @model
 * @generated
 */
public interface IEnumeration extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Parent Package</b></em>' container reference. It is bidirectional and its
	 * opposite is '{@link org.unicase.model.implementation.IPackage#getEnumerations <em>Enumerations</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Package</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parent Package</em>' container reference.
	 * @see #setParentPackage(IPackage)
	 * @see org.unicase.model.implementation.ImplementationPackage#getIEnumeration_ParentPackage()
	 * @see org.unicase.model.implementation.IPackage#getEnumerations
	 * @model opposite="enumerations" keys="identifier" transient="false"
	 * @generated
	 */
	IPackage getParentPackage();

	/**
	 * Sets the value of the '{@link org.unicase.model.implementation.IEnumeration#getParentPackage
	 * <em>Parent Package</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Parent Package</em>' container reference.
	 * @see #getParentPackage()
	 * @generated
	 */
	void setParentPackage(IPackage value);

	/**
	 * Returns the value of the '<em><b>Literals</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.model.implementation.ILiteral}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.implementation.ILiteral#getParentEnumeration <em>Parent Enumeration</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literals</em>' containment reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Literals</em>' containment reference list.
	 * @see org.unicase.model.implementation.ImplementationPackage#getIEnumeration_Literals()
	 * @see org.unicase.model.implementation.ILiteral#getParentEnumeration
	 * @model opposite="parentEnumeration" containment="true" keys="identifier"
	 * @generated
	 */
	EList<ILiteral> getLiterals();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.implementation.IAttribute}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.implementation.IAttribute#getEnumeration <em>Enumeration</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Attributes</em>' reference list.
	 * @see org.unicase.model.implementation.ImplementationPackage#getIEnumeration_Attributes()
	 * @see org.unicase.model.implementation.IAttribute#getEnumeration
	 * @model opposite="enumeration" keys="identifier"
	 * @generated
	 */
	EList<IAttribute> getAttributes();

} // IEnumeration
