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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Stereotype</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.profile.Stereotype#isRequired <em>Required</em>}</li>
 *   <li>{@link org.unicase.model.profile.Stereotype#getProfile <em>Profile</em>}</li>
 *   <li>{@link org.unicase.model.profile.Stereotype#getStereotypeInstances <em>Stereotype Instances</em>}</li>
 *   <li>{@link org.unicase.model.profile.Stereotype#getStereotypeAttributes <em>Stereotype Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.profile.ProfilePackage#getStereotype()
 * @model
 * @generated
 */
public interface Stereotype extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required</em>' attribute.
	 * @see #setRequired(boolean)
	 * @see org.unicase.model.profile.ProfilePackage#getStereotype_Required()
	 * @model
	 * @generated
	 */
	boolean isRequired();

	/**
	 * Sets the value of the '{@link org.unicase.model.profile.Stereotype#isRequired <em>Required</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Required</em>' attribute.
	 * @see #isRequired()
	 * @generated
	 */
	void setRequired(boolean value);

	/**
	 * Returns the value of the '<em><b>Profile</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.profile.Profile#getStereotypes <em>Stereotypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile</em>' container reference.
	 * @see #setProfile(Profile)
	 * @see org.unicase.model.profile.ProfilePackage#getStereotype_Profile()
	 * @see org.unicase.model.profile.Profile#getStereotypes
	 * @model opposite="stereotypes" transient="false"
	 * @generated
	 */
	Profile getProfile();

	/**
	 * Sets the value of the '{@link org.unicase.model.profile.Stereotype#getProfile <em>Profile</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile</em>' container reference.
	 * @see #getProfile()
	 * @generated
	 */
	void setProfile(Profile value);

	/**
	 * Returns the value of the '<em><b>Stereotype Instances</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.profile.StereotypeInstance}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.profile.StereotypeInstance#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype Instances</em>' reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotype Instances</em>' reference list.
	 * @see org.unicase.model.profile.ProfilePackage#getStereotype_StereotypeInstances()
	 * @see org.unicase.model.profile.StereotypeInstance#getStereotype
	 * @model opposite="stereotype"
	 * @generated
	 */
	EList<StereotypeInstance> getStereotypeInstances();

	/**
	 * Returns the value of the '<em><b>Stereotype Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.profile.StereotypeAttribute}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.profile.StereotypeAttribute#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype Attributes</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotype Attributes</em>' containment reference list.
	 * @see org.unicase.model.profile.ProfilePackage#getStereotype_StereotypeAttributes()
	 * @see org.unicase.model.profile.StereotypeAttribute#getStereotype
	 * @model opposite="stereotype" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<StereotypeAttribute> getStereotypeAttributes();

} // Stereotype
