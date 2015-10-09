/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classes;

import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Association</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.classes.Association#getSource <em>Source</em>}</li>
 *   <li>{@link org.unicase.model.classes.Association#getTarget <em>Target</em>}</li>
 *   <li>{@link org.unicase.model.classes.Association#getType <em>Type</em>}</li>
 *   <li>{@link org.unicase.model.classes.Association#getSourceMultiplicity <em>Source Multiplicity</em>}</li>
 *   <li>{@link org.unicase.model.classes.Association#getTargetMultiplicity <em>Target Multiplicity</em>}</li>
 *   <li>{@link org.unicase.model.classes.Association#getSourceRole <em>Source Role</em>}</li>
 *   <li>{@link org.unicase.model.classes.Association#getTargetRole <em>Target Role</em>}</li>
 *   <li>{@link org.unicase.model.classes.Association#isTransient <em>Transient</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.classes.ClassesPackage#getAssociation()
 * @model
 * @generated
 */
public interface Association extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.classes.Class#getOutgoingAssociations <em>Outgoing Associations</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(org.unicase.model.classes.Class)
	 * @see org.unicase.model.classes.ClassesPackage#getAssociation_Source()
	 * @see org.unicase.model.classes.Class#getOutgoingAssociations
	 * @model opposite="outgoingAssociations" keys="identifier"
	 * @generated
	 */
	org.unicase.model.classes.Class getSource();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Association#getSource <em>Source</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(org.unicase.model.classes.Class value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.classes.Class#getIncomingAssociations <em>Incoming Associations</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(org.unicase.model.classes.Class)
	 * @see org.unicase.model.classes.ClassesPackage#getAssociation_Target()
	 * @see org.unicase.model.classes.Class#getIncomingAssociations
	 * @model opposite="incomingAssociations" keys="identifier"
	 * @generated
	 */
	org.unicase.model.classes.Class getTarget();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Association#getTarget <em>Target</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(org.unicase.model.classes.Class value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.model.classes.AssociationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.unicase.model.classes.AssociationType
	 * @see #setType(AssociationType)
	 * @see org.unicase.model.classes.ClassesPackage#getAssociation_Type()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='12.0' position='left'"
	 * @generated
	 */
	AssociationType getType();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Association#getType <em>Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.unicase.model.classes.AssociationType
	 * @see #getType()
	 * @generated
	 */
	void setType(AssociationType value);

	/**
	 * Returns the value of the '<em><b>Source Multiplicity</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Multiplicity</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Multiplicity</em>' attribute.
	 * @see #setSourceMultiplicity(String)
	 * @see org.unicase.model.classes.ClassesPackage#getAssociation_SourceMultiplicity()
	 * @model default="1"
	 *        annotation="org.eclipse.emf.ecp.editor priority='13.0' position='left'"
	 * @generated
	 */
	String getSourceMultiplicity();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Association#getSourceMultiplicity <em>Source Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Multiplicity</em>' attribute.
	 * @see #getSourceMultiplicity()
	 * @generated
	 */
	void setSourceMultiplicity(String value);

	/**
	 * Returns the value of the '<em><b>Target Multiplicity</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Multiplicity</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Multiplicity</em>' attribute.
	 * @see #setTargetMultiplicity(String)
	 * @see org.unicase.model.classes.ClassesPackage#getAssociation_TargetMultiplicity()
	 * @model default="1"
	 *        annotation="org.eclipse.emf.ecp.editor priority='14.0' position='left'"
	 * @generated
	 */
	String getTargetMultiplicity();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Association#getTargetMultiplicity <em>Target Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Multiplicity</em>' attribute.
	 * @see #getTargetMultiplicity()
	 * @generated
	 */
	void setTargetMultiplicity(String value);

	/**
	 * Returns the value of the '<em><b>Source Role</b></em>' attribute. The default value is <code>"1"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Role</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source Role</em>' attribute.
	 * @see #setSourceRole(String)
	 * @see org.unicase.model.classes.ClassesPackage#getAssociation_SourceRole()
	 * @model default="1"
	 * @generated
	 */
	String getSourceRole();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Association#getSourceRole <em>Source Role</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Role</em>' attribute.
	 * @see #getSourceRole()
	 * @generated
	 */
	void setSourceRole(String value);

	/**
	 * Returns the value of the '<em><b>Target Role</b></em>' attribute. The default value is <code>"1"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Role</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Target Role</em>' attribute.
	 * @see #setTargetRole(String)
	 * @see org.unicase.model.classes.ClassesPackage#getAssociation_TargetRole()
	 * @model default="1"
	 * @generated
	 */
	String getTargetRole();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Association#getTargetRole <em>Target Role</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Role</em>' attribute.
	 * @see #getTargetRole()
	 * @generated
	 */
	void setTargetRole(String value);

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
	 * @see org.unicase.model.classes.ClassesPackage#getAssociation_Transient()
	 * @model
	 * @generated
	 */
	boolean isTransient();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Association#isTransient <em>Transient</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transient</em>' attribute.
	 * @see #isTransient()
	 * @generated
	 */
	void setTransient(boolean value);

} // Association
