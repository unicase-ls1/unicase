/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.accesscontrol;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>AC Org Unit</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit#getName <em>Name</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit#getId <em>Id</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolPackage#getACOrgUnit()
 * @model
 * @generated
 */
public interface ACOrgUnit extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolPackage#getACOrgUnit_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Roles</b></em>' reference list. The list
	 * contents are of type
	 * {@link org.unicase.emfstore.esmodel.accesscontrol.roles.Role}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roles</em>' reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Roles</em>' reference list.
	 * @see org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolPackage#getACOrgUnit_Roles()
	 * @model
	 * @generated
	 */
	EList<Role> getRoles();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Id</em>' reference.
	 * @see #setId(ACOrgUnitId)
	 * @see org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolPackage#getACOrgUnit_Id()
	 * @model
	 * @generated
	 */
	ACOrgUnitId getId();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit#getId <em>Id</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' reference.
	 * @see #getId()
	 * @generated
	 */
	void setId(ACOrgUnitId value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolPackage#getACOrgUnit_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // ACOrgUnit
