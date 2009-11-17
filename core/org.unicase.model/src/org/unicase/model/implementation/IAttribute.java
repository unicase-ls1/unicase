/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>IAttribute</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.implementation.IAttribute#getParentClass <em>Parent Class</em>}</li>
 * <li>{@link org.unicase.model.implementation.IAttribute#isId <em>Id</em>}</li>
 * <li>{@link org.unicase.model.implementation.IAttribute#getType <em>Type</em>}</li>
 * <li>{@link org.unicase.model.implementation.IAttribute#getEnumeration <em>Enumeration</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.implementation.ImplementationPackage#getIAttribute()
 * @model
 * @generated
 */
public interface IAttribute extends IFeature {
	/**
	 * Returns the value of the '<em><b>Parent Class</b></em>' container reference. It is bidirectional and its opposite
	 * is '{@link org.unicase.model.implementation.IClass#getAttributes <em>Attributes</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Class</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parent Class</em>' container reference.
	 * @see #setParentClass(IClass)
	 * @see org.unicase.model.implementation.ImplementationPackage#getIAttribute_ParentClass()
	 * @see org.unicase.model.implementation.IClass#getAttributes
	 * @model opposite="attributes" keys="identifier" transient="false"
	 * @generated
	 */
	IClass getParentClass();

	/**
	 * Sets the value of the '{@link org.unicase.model.implementation.IAttribute#getParentClass <em>Parent Class</em>}'
	 * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Parent Class</em>' container reference.
	 * @see #getParentClass()
	 * @generated
	 */
	void setParentClass(IClass value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(boolean)
	 * @see org.unicase.model.implementation.ImplementationPackage#getIAttribute_Id()
	 * @model
	 * @generated
	 */
	boolean isId();

	/**
	 * Sets the value of the '{@link org.unicase.model.implementation.IAttribute#isId <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #isId()
	 * @generated
	 */
	void setId(boolean value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute. The literals are from the enumeration
	 * {@link org.unicase.model.implementation.IPrimitiveType}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.unicase.model.implementation.IPrimitiveType
	 * @see #setType(IPrimitiveType)
	 * @see org.unicase.model.implementation.ImplementationPackage#getIAttribute_Type()
	 * @model
	 * @generated
	 */
	IPrimitiveType getType();

	/**
	 * Sets the value of the '{@link org.unicase.model.implementation.IAttribute#getType <em>Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.unicase.model.implementation.IPrimitiveType
	 * @see #getType()
	 * @generated
	 */
	void setType(IPrimitiveType value);

	/**
	 * Returns the value of the '<em><b>Enumeration</b></em>' reference. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.implementation.IEnumeration#getAttributes <em>Attributes</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumeration</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Enumeration</em>' reference.
	 * @see #isSetEnumeration()
	 * @see #unsetEnumeration()
	 * @see #setEnumeration(IEnumeration)
	 * @see org.unicase.model.implementation.ImplementationPackage#getIAttribute_Enumeration()
	 * @see org.unicase.model.implementation.IEnumeration#getAttributes
	 * @model opposite="attributes" unsettable="true" keys="identifier"
	 * @generated
	 */
	IEnumeration getEnumeration();

	/**
	 * Sets the value of the '{@link org.unicase.model.implementation.IAttribute#getEnumeration <em>Enumeration</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Enumeration</em>' reference.
	 * @see #isSetEnumeration()
	 * @see #unsetEnumeration()
	 * @see #getEnumeration()
	 * @generated
	 */
	void setEnumeration(IEnumeration value);

	/**
	 * Unsets the value of the '{@link org.unicase.model.implementation.IAttribute#getEnumeration <em>Enumeration</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isSetEnumeration()
	 * @see #getEnumeration()
	 * @see #setEnumeration(IEnumeration)
	 * @generated
	 */
	void unsetEnumeration();

	/**
	 * Returns whether the value of the '{@link org.unicase.model.implementation.IAttribute#getEnumeration
	 * <em>Enumeration</em>}' reference is set. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return whether the value of the '<em>Enumeration</em>' reference is set.
	 * @see #unsetEnumeration()
	 * @see #getEnumeration()
	 * @see #setEnumeration(IEnumeration)
	 * @generated
	 */
	boolean isSetEnumeration();

} // IAttribute
