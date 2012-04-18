/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classes;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.requirement.Scenario;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Method</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.classes.Method#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.unicase.model.classes.Method#getScope <em>Scope</em>}</li>
 *   <li>{@link org.unicase.model.classes.Method#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.unicase.model.classes.Method#getSignature <em>Signature</em>}</li>
 *   <li>{@link org.unicase.model.classes.Method#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.unicase.model.classes.Method#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.unicase.model.classes.Method#getDefiningClass <em>Defining Class</em>}</li>
 *   <li>{@link org.unicase.model.classes.Method#getLabel <em>Label</em>}</li>
 *   <li>{@link org.unicase.model.classes.Method#isStubbed <em>Stubbed</em>}</li>
 *   <li>{@link org.unicase.model.classes.Method#getCalledMethods <em>Called Methods</em>}</li>
 *   <li>{@link org.unicase.model.classes.Method#getCallingMethods <em>Calling Methods</em>}</li>
 *   <li>{@link org.unicase.model.classes.Method#getDemoParticipations <em>Demo Participations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.classes.ClassesPackage#getMethod()
 * @model
 * @generated
 */
public interface Method extends UnicaseModelElement {
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
	 * @see org.unicase.model.classes.ClassesPackage#getMethod_Visibility()
	 * @model annotation="org.unicase.ui.meeditor priority='11.0' position='left'"
	 * @generated
	 */
	VisibilityType getVisibility();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Method#getVisibility <em>Visibility</em>}' attribute.
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
	 * @see org.unicase.model.classes.ClassesPackage#getMethod_Scope()
	 * @model annotation="org.unicase.ui.meeditor priority='12.0' position='left'"
	 * @generated
	 */
	ScopeType getScope();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Method#getScope <em>Scope</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Scope</em>' attribute.
	 * @see org.unicase.model.classes.ScopeType
	 * @see #getScope()
	 * @generated
	 */
	void setScope(ScopeType value);

	/**
	 * Returns the value of the '<em><b>Defining Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.classes.Class#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defining Class</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defining Class</em>' container reference.
	 * @see #setDefiningClass(org.unicase.model.classes.Class)
	 * @see org.unicase.model.classes.ClassesPackage#getMethod_DefiningClass()
	 * @see org.unicase.model.classes.Class#getMethods
	 * @model opposite="methods" transient="false"
	 *        annotation="org.unicase.ui.meeditor priority='10.0' position='left'"
	 * @generated
	 */
	org.unicase.model.classes.Class getDefiningClass();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Method#getDefiningClass <em>Defining Class</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defining Class</em>' container reference.
	 * @see #getDefiningClass()
	 * @generated
	 */
	void setDefiningClass(org.unicase.model.classes.Class value);

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' attribute.
	 * @see #setReturnType(String)
	 * @see org.unicase.model.classes.ClassesPackage#getMethod_ReturnType()
	 * @model annotation="org.unicase.ui.meeditor priority='13.0' position='left'"
	 * @generated
	 */
	String getReturnType();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Method#getReturnType <em>Return Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' attribute.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(String value);

	/**
	 * Returns the value of the '<em><b>Signature</b></em>' attribute. The default value is <code>""</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signature</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Signature</em>' attribute.
	 * @see org.unicase.model.classes.ClassesPackage#getMethod_Signature()
	 * @model default="" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getSignature();

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.classes.MethodArgument}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.unicase.model.classes.ClassesPackage#getMethod_Arguments()
	 * @model containment="true" resolveProxies="true"
	 *        annotation="org.unicase.ui.meeditor priority='10.0' position='right'"
	 * @generated
	 */
	EList<MethodArgument> getArguments();

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
	 * @see org.unicase.model.classes.ClassesPackage#getMethod_Properties()
	 * @model annotation="org.unicase.ui.meeditor priority='14.0' position='left'"
	 * @generated
	 */
	String getProperties();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Method#getProperties <em>Properties</em>}' attribute.
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
	 * @see org.unicase.model.classes.ClassesPackage#getMethod_Label()
	 * @model annotation="org.unicase.ui.meeditor priority='15.0' position='left'"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Method#getLabel <em>Label</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Stubbed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stubbed</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stubbed</em>' attribute.
	 * @see #setStubbed(boolean)
	 * @see org.unicase.model.classes.ClassesPackage#getMethod_Stubbed()
	 * @model
	 * @generated
	 */
	boolean isStubbed();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Method#isStubbed <em>Stubbed</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Stubbed</em>' attribute.
	 * @see #isStubbed()
	 * @generated
	 */
	void setStubbed(boolean value);

	/**
	 * Returns the value of the '<em><b>Called Methods</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.classes.Method}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.classes.Method#getCallingMethods <em>Calling Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Called Methods</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Called Methods</em>' reference list.
	 * @see org.unicase.model.classes.ClassesPackage#getMethod_CalledMethods()
	 * @see org.unicase.model.classes.Method#getCallingMethods
	 * @model opposite="callingMethods"
	 *        annotation="org.unicase.ui.meeditor priority='10.1' position='right'"
	 * @generated
	 */
	EList<Method> getCalledMethods();

	/**
	 * Returns the value of the '<em><b>Calling Methods</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.classes.Method}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.classes.Method#getCalledMethods <em>Called Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Calling Methods</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calling Methods</em>' reference list.
	 * @see org.unicase.model.classes.ClassesPackage#getMethod_CallingMethods()
	 * @see org.unicase.model.classes.Method#getCalledMethods
	 * @model opposite="calledMethods"
	 *        annotation="org.unicase.ui.meeditor priority='10.2' position='right'"
	 * @generated
	 */
	EList<Method> getCallingMethods();

	/**
	 * Returns the value of the '<em><b>Demo Participations</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.requirement.Scenario}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.requirement.Scenario#getParticipatingMethods <em>Participating Methods</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Demo Participations</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Demo Participations</em>' reference list.
	 * @see org.unicase.model.classes.ClassesPackage#getMethod_DemoParticipations()
	 * @see org.unicase.model.requirement.Scenario#getParticipatingMethods
	 * @model opposite="participatingMethods" keys="identifier"
	 *        annotation="org.unicase.ui.meeditor priority='9.0' position='right'"
	 * @generated
	 */
	EList<Scenario> getDemoParticipations();

} // Method
