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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Profile</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.profile.Profile#getAffectedContainers <em>Affected Containers</em>}</li>
 *   <li>{@link org.unicase.model.profile.Profile#getStereotypes <em>Stereotypes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.profile.ProfilePackage#getProfile()
 * @model
 * @generated
 */
public interface Profile extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Affected Containers</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.UnicaseModelElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Affected Containers</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Affected Containers</em>' reference list.
	 * @see org.unicase.model.profile.ProfilePackage#getProfile_AffectedContainers()
	 * @model
	 * @generated
	 */
	EList<UnicaseModelElement> getAffectedContainers();

	/**
	 * Returns the value of the '<em><b>Stereotypes</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.profile.Stereotype}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.profile.Stereotype#getProfile <em>Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotypes</em>' containment reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotypes</em>' containment reference list.
	 * @see org.unicase.model.profile.ProfilePackage#getProfile_Stereotypes()
	 * @see org.unicase.model.profile.Stereotype#getProfile
	 * @model opposite="profile" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Stereotype> getStereotypes();

} // Profile
