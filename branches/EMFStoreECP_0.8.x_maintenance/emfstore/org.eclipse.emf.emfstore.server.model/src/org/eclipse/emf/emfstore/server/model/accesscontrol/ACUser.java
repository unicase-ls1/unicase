/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.accesscontrol;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.Role;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>AC User</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser#getFirstName <em>First Name</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser#getLastName <em>Last Name</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser#getEffectiveGroups <em>Effective Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage#getACUser()
 * @model
 * @generated
 */
public interface ACUser extends ACOrgUnit {
	/**
	 * Returns the value of the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Name</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Name</em>' attribute.
	 * @see #setFirstName(String)
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage#getACUser_FirstName()
	 * @model
	 * @generated
	 */
	String getFirstName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser#getFirstName <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Name</em>' attribute.
	 * @see #getFirstName()
	 * @generated
	 */
	void setFirstName(String value);

	/**
	 * Returns the value of the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Name</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Name</em>' attribute.
	 * @see #setLastName(String)
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage#getACUser_LastName()
	 * @model
	 * @generated
	 */
	String getLastName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser#getLastName <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Name</em>' attribute.
	 * @see #getLastName()
	 * @generated
	 */
	void setLastName(String value);

	/**
	 * Returns the value of the '<em><b>Effective Groups</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.server.model.accesscontrol.roles.Role}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Effective Groups</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Effective Groups</em>' reference list.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage#getACUser_EffectiveGroups()
	 * @model
	 * @generated
	 */
	EList<Role> getEffectiveGroups();

} // ACUser
