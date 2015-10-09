/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.profile;

import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Stereotype Attribute Instance</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.profile.StereotypeAttributeInstance#getStereotypeInstance <em>Stereotype Instance</em>}</li>
 *   <li>{@link org.unicase.model.profile.StereotypeAttributeInstance#getStereotypeAttribute <em>Stereotype Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.profile.ProfilePackage#getStereotypeAttributeInstance()
 * @model abstract="true"
 * @generated
 */
public interface StereotypeAttributeInstance extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Stereotype Instance</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.profile.StereotypeInstance#getStereotypeAttributeInstances <em>Stereotype Attribute Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype Instance</em>' container reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotype Instance</em>' container reference.
	 * @see #setStereotypeInstance(StereotypeInstance)
	 * @see org.unicase.model.profile.ProfilePackage#getStereotypeAttributeInstance_StereotypeInstance()
	 * @see org.unicase.model.profile.StereotypeInstance#getStereotypeAttributeInstances
	 * @model opposite="stereotypeAttributeInstances" transient="false"
	 * @generated
	 */
	StereotypeInstance getStereotypeInstance();

	/**
	 * Sets the value of the '{@link org.unicase.model.profile.StereotypeAttributeInstance#getStereotypeInstance <em>Stereotype Instance</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype Instance</em>' container reference.
	 * @see #getStereotypeInstance()
	 * @generated
	 */
	void setStereotypeInstance(StereotypeInstance value);

	/**
	 * Returns the value of the '<em><b>Stereotype Attribute</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.profile.StereotypeAttribute#getStereotypeAttributeInstances <em>Stereotype Attribute Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype Attribute</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotype Attribute</em>' reference.
	 * @see #setStereotypeAttribute(StereotypeAttribute)
	 * @see org.unicase.model.profile.ProfilePackage#getStereotypeAttributeInstance_StereotypeAttribute()
	 * @see org.unicase.model.profile.StereotypeAttribute#getStereotypeAttributeInstances
	 * @model opposite="stereotypeAttributeInstances"
	 * @generated
	 */
	StereotypeAttribute getStereotypeAttribute();

	/**
	 * Sets the value of the '{@link org.unicase.model.profile.StereotypeAttributeInstance#getStereotypeAttribute <em>Stereotype Attribute</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype Attribute</em>' reference.
	 * @see #getStereotypeAttribute()
	 * @generated
	 */
	void setStereotypeAttribute(StereotypeAttribute value);

} // StereotypeAttributeInstance
