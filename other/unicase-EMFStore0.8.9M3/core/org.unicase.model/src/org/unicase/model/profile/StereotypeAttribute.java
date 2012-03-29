/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.profile;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Stereotype Attribute</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.profile.StereotypeAttribute#getStereotype <em>Stereotype</em>}</li>
 * <li>{@link org.unicase.model.profile.StereotypeAttribute#getStereotypeAttributeInstances <em>Stereotype Attribute
 * Instances</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.profile.ProfilePackage#getStereotypeAttribute()
 * @model abstract="true"
 * @generated
 */
public interface StereotypeAttribute extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Stereotype</b></em>' container reference. It is bidirectional and its opposite
	 * is '{@link org.unicase.model.profile.Stereotype#getStereotypeAttributes <em>Stereotype Attributes</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Stereotype</em>' container reference.
	 * @see #setStereotype(Stereotype)
	 * @see org.unicase.model.profile.ProfilePackage#getStereotypeAttribute_Stereotype()
	 * @see org.unicase.model.profile.Stereotype#getStereotypeAttributes
	 * @model opposite="stereotypeAttributes" keys="identifier" transient="false"
	 * @generated
	 */
	Stereotype getStereotype();

	/**
	 * Sets the value of the '{@link org.unicase.model.profile.StereotypeAttribute#getStereotype <em>Stereotype</em>}'
	 * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Stereotype</em>' container reference.
	 * @see #getStereotype()
	 * @generated
	 */
	void setStereotype(Stereotype value);

	/**
	 * Returns the value of the '<em><b>Stereotype Attribute Instances</b></em>' reference list. The list contents are
	 * of type {@link org.unicase.model.profile.StereotypeAttributeInstance}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.profile.StereotypeAttributeInstance#getStereotypeAttribute
	 * <em>Stereotype Attribute</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype Attribute Instances</em>' reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Stereotype Attribute Instances</em>' reference list.
	 * @see org.unicase.model.profile.ProfilePackage#getStereotypeAttribute_StereotypeAttributeInstances()
	 * @see org.unicase.model.profile.StereotypeAttributeInstance#getStereotypeAttribute
	 * @model opposite="stereotypeAttribute"
	 * @generated
	 */
	EList<StereotypeAttributeInstance> getStereotypeAttributeInstances();

} // StereotypeAttribute
