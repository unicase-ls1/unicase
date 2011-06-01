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
import org.eclipse.emf.emfstore.common.model.IdentifiableElement;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.Role;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>AC Org Unit</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit#getRoles <em>Roles</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit#getDescription <em>Description</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage#getACOrgUnit()
 * @model
 * @generated
 */
public interface ACOrgUnit extends IdentifiableElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage#getACOrgUnit_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit#getName
	 * <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Roles</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.server.model.accesscontrol.roles.Role}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roles</em>' reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Roles</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage#getACOrgUnit_Roles()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Role> getRoles();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @model kind="operation"
	 * @generated
	 */
	ACOrgUnitId getId();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage#getACOrgUnit_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit#getDescription
	 * <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.server.model.accesscontrol.OrgUnitProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage#getACOrgUnit_Properties()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<OrgUnitProperty> getProperties();

} // ACOrgUnit
