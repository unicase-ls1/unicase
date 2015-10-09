/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.profile;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Stereotype Attribute Simple</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.profile.StereotypeAttributeSimple#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.profile.ProfilePackage#getStereotypeAttributeSimple()
 * @model
 * @generated
 */
public interface StereotypeAttributeSimple extends StereotypeAttribute {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.unicase.model.profile.ProfilePackage#getStereotypeAttributeSimple_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.unicase.model.profile.StereotypeAttributeSimple#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // StereotypeAttributeSimple
