/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation;

import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>ILiteral</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.implementation.ILiteral#getParentEnumeration <em>Parent Enumeration</em>}</li>
 * <li>{@link org.unicase.model.implementation.ILiteral#getLiteral <em>Literal</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.implementation.ImplementationPackage#getILiteral()
 * @model
 * @generated
 */
public interface ILiteral extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Parent Enumeration</b></em>' container reference. It is bidirectional and its
	 * opposite is '{@link org.unicase.model.implementation.IEnumeration#getLiterals <em>Literals</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Enumeration</em>' container reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parent Enumeration</em>' container reference.
	 * @see #setParentEnumeration(IEnumeration)
	 * @see org.unicase.model.implementation.ImplementationPackage#getILiteral_ParentEnumeration()
	 * @see org.unicase.model.implementation.IEnumeration#getLiterals
	 * @model opposite="literals" keys="identifier" transient="false"
	 * @generated
	 */
	IEnumeration getParentEnumeration();

	/**
	 * Sets the value of the '{@link org.unicase.model.implementation.ILiteral#getParentEnumeration
	 * <em>Parent Enumeration</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Parent Enumeration</em>' container reference.
	 * @see #getParentEnumeration()
	 * @generated
	 */
	void setParentEnumeration(IEnumeration value);

	/**
	 * Returns the value of the '<em><b>Literal</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Literal</em>' attribute.
	 * @see #setLiteral(String)
	 * @see org.unicase.model.implementation.ImplementationPackage#getILiteral_Literal()
	 * @model
	 * @generated
	 */
	String getLiteral();

	/**
	 * Sets the value of the '{@link org.unicase.model.implementation.ILiteral#getLiteral <em>Literal</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Literal</em>' attribute.
	 * @see #getLiteral()
	 * @generated
	 */
	void setLiteral(String value);

} // ILiteral
