/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classes;

import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Attribute</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.classes.Attribute#getDefiningClass <em>Defining Class</em>}</li>
 *   <li>{@link org.unicase.model.classes.Attribute#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.unicase.model.classes.Attribute#getScope <em>Scope</em>}</li>
 *   <li>{@link org.unicase.model.classes.Attribute#getSignature <em>Signature</em>}</li>
 *   <li>{@link org.unicase.model.classes.Attribute#getType <em>Type</em>}</li>
 *   <li>{@link org.unicase.model.classes.Attribute#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.unicase.model.classes.Attribute#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.unicase.model.classes.Attribute#getLabel <em>Label</em>}</li>
 *   <li>{@link org.unicase.model.classes.Attribute#isId <em>Id</em>}</li>
 *   <li>{@link org.unicase.model.classes.Attribute#getImplementationType <em>Implementation Type</em>}</li>
 *   <li>{@link org.unicase.model.classes.Attribute#getImplementationEnumeration <em>Implementation Enumeration</em>}</li>
 *   <li>{@link org.unicase.model.classes.Attribute#isTransient <em>Transient</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.classes.ClassesPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Defining Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.classes.Class#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defining Class</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defining Class</em>' container reference.
	 * @see #setDefiningClass(org.unicase.model.classes.Class)
	 * @see org.unicase.model.classes.ClassesPackage#getAttribute_DefiningClass()
	 * @see org.unicase.model.classes.Class#getAttributes
	 * @model opposite="attributes" transient="false"
	 *        annotation="org.eclipse.emf.ecp.editor priority='10.0' position='left'"
	 * @generated
	 */
	org.unicase.model.classes.Class getDefiningClass();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Attribute#getDefiningClass <em>Defining Class</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defining Class</em>' container reference.
	 * @see #getDefiningClass()
	 * @generated
	 */
	void setDefiningClass(org.unicase.model.classes.Class value);

	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.model.classes.VisibilityType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see org.unicase.model.classes.VisibilityType
	 * @see #setVisibility(VisibilityType)
	 * @see org.unicase.model.classes.ClassesPackage#getAttribute_Visibility()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='11.0' position='left'"
	 * @generated
	 */
	VisibilityType getVisibility();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Attribute#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see org.unicase.model.classes.VisibilityType
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(VisibilityType value);

	/**
	 * Returns the value of the '<em><b>Scope</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.model.classes.ScopeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope</em>' attribute.
	 * @see org.unicase.model.classes.ScopeType
	 * @see #setScope(ScopeType)
	 * @see org.unicase.model.classes.ClassesPackage#getAttribute_Scope()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='12.0' position='left'"
	 * @generated
	 */
	ScopeType getScope();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Attribute#getScope <em>Scope</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Scope</em>' attribute.
	 * @see org.unicase.model.classes.ScopeType
	 * @see #getScope()
	 * @generated
	 */
	void setScope(ScopeType value);

	/**
	 * Returns the value of the '<em><b>Signature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signature</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signature</em>' attribute.
	 * @see org.unicase.model.classes.ClassesPackage#getAttribute_Signature()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getSignature();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute. The default value is <code>""</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.unicase.model.classes.ClassesPackage#getAttribute_Type()
	 * @model default=""
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Attribute#getType <em>Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' attribute.
	 * @see #setDefaultValue(String)
	 * @see org.unicase.model.classes.ClassesPackage#getAttribute_DefaultValue()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='14.0' position='left'"
	 * @generated
	 */
	String getDefaultValue();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Attribute#getDefaultValue <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' attribute.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(String value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' attribute.
	 * @see #setProperties(String)
	 * @see org.unicase.model.classes.ClassesPackage#getAttribute_Properties()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='15.0' position='left'"
	 * @generated
	 */
	String getProperties();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Attribute#getProperties <em>Properties</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Properties</em>' attribute.
	 * @see #getProperties()
	 * @generated
	 */
	void setProperties(String value);

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.unicase.model.classes.ClassesPackage#getAttribute_Label()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='16.0' position='left'"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Attribute#getLabel <em>Label</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(boolean)
	 * @see org.unicase.model.classes.ClassesPackage#getAttribute_Id()
	 * @model
	 * @generated
	 */
	boolean isId();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Attribute#isId <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #isId()
	 * @generated
	 */
	void setId(boolean value);

	/**
	 * Returns the value of the '<em><b>Implementation Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.model.classes.PrimitiveType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation Type</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation Type</em>' attribute.
	 * @see org.unicase.model.classes.PrimitiveType
	 * @see #setImplementationType(PrimitiveType)
	 * @see org.unicase.model.classes.ClassesPackage#getAttribute_ImplementationType()
	 * @model
	 * @generated
	 */
	PrimitiveType getImplementationType();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Attribute#getImplementationType <em>Implementation Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation Type</em>' attribute.
	 * @see org.unicase.model.classes.PrimitiveType
	 * @see #getImplementationType()
	 * @generated
	 */
	void setImplementationType(PrimitiveType value);

	/**
	 * Returns the value of the '<em><b>Implementation Enumeration</b></em>' reference. It is bidirectional and its
	 * opposite is '{@link org.unicase.model.classes.Enumeration#getAttributes <em>Attributes</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation Enumeration</em>' reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Implementation Enumeration</em>' reference.
	 * @see #setImplementationEnumeration(Enumeration)
	 * @see org.unicase.model.classes.ClassesPackage#getAttribute_ImplementationEnumeration()
	 * @see org.unicase.model.classes.Enumeration#getAttributes
	 * @model opposite="attributes" keys="identifier"
	 * @generated
	 */
	Enumeration getImplementationEnumeration();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Attribute#getImplementationEnumeration <em>Implementation Enumeration</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation Enumeration</em>' reference.
	 * @see #getImplementationEnumeration()
	 * @generated
	 */
	void setImplementationEnumeration(Enumeration value);

	/**
	 * Returns the value of the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transient</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transient</em>' attribute.
	 * @see #setTransient(boolean)
	 * @see org.unicase.model.classes.ClassesPackage#getAttribute_Transient()
	 * @model
	 * @generated
	 */
	boolean isTransient();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Attribute#isTransient <em>Transient</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transient</em>' attribute.
	 * @see #isTransient()
	 * @generated
	 */
	void setTransient(boolean value);

} // Attribute
