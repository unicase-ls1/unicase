/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.classes;

import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Association</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.classes.Association#isDirected <em>Directed</em>}</li>
 *   <li>{@link org.unicase.model.classes.Association#getSource <em>Source</em>}</li>
 *   <li>{@link org.unicase.model.classes.Association#getTarget <em>Target</em>}</li>
 *   <li>{@link org.unicase.model.classes.Association#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.classes.ClassesPackage#getAssociation()
 * @model
 * @generated
 */
public interface Association extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Directed</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Directed</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Directed</em>' attribute.
	 * @see #setDirected(boolean)
	 * @see org.unicase.model.classes.ClassesPackage#getAssociation_Directed()
	 * @model
	 * @generated
	 */
	boolean isDirected();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.model.classes.Association#isDirected
	 * <em>Directed</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Directed</em>' attribute.
	 * @see #isDirected()
	 * @generated
	 */
	void setDirected(boolean value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.classes.Class#getOutgoingAssociations <em>Outgoing Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(org.unicase.model.classes.Class)
	 * @see org.unicase.model.classes.ClassesPackage#getAssociation_Source()
	 * @see org.unicase.model.classes.Class#getOutgoingAssociations
	 * @model opposite="outgoingAssociations" keys="identifier"
	 * @generated
	 */
	org.unicase.model.classes.Class getSource();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Association#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(org.unicase.model.classes.Class value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.classes.Class#getIncomingAssociations <em>Incoming Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(org.unicase.model.classes.Class)
	 * @see org.unicase.model.classes.ClassesPackage#getAssociation_Target()
	 * @see org.unicase.model.classes.Class#getIncomingAssociations
	 * @model opposite="incomingAssociations" keys="identifier"
	 * @generated
	 */
	org.unicase.model.classes.Class getTarget();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Association#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(org.unicase.model.classes.Class value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link org.unicase.model.classes.AssociationType}.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.unicase.model.classes.AssociationType
	 * @see #setType(AssociationType)
	 * @see org.unicase.model.classes.ClassesPackage#getAssociation_Type()
	 * @model default=""
	 * @generated
	 */
	AssociationType getType();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Association#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.unicase.model.classes.AssociationType
	 * @see #getType()
	 * @generated
	 */
	void setType(AssociationType value);

} // Association
