/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.organization;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Org Unit</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.organization.OrgUnit#getAcOrgId <em>Ac Org Id</em>}</li>
 *   <li>{@link org.unicase.model.organization.OrgUnit#getGroupMemberships <em>Group Memberships</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.organization.OrganizationPackage#getOrgUnit()
 * @model
 * @generated
 */
public interface OrgUnit extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Ac Org Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ac Org Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ac Org Id</em>' attribute.
	 * @see #setAcOrgId(String)
	 * @see org.unicase.model.organization.OrganizationPackage#getOrgUnit_AcOrgId()
	 * @model
	 * @generated
	 */
	String getAcOrgId();

	/**
	 * Sets the value of the '{@link org.unicase.model.organization.OrgUnit#getAcOrgId <em>Ac Org Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ac Org Id</em>' attribute.
	 * @see #getAcOrgId()
	 * @generated
	 */
	void setAcOrgId(String value);

	/**
	 * Returns the value of the '<em><b>Group Memberships</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.organization.Group}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.organization.Group#getOrgUnits <em>Org Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group Memberships</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group Memberships</em>' reference list.
	 * @see org.unicase.model.organization.OrganizationPackage#getOrgUnit_GroupMemberships()
	 * @see org.unicase.model.organization.Group#getOrgUnits
	 * @model opposite="orgUnits" keys="identifier"
	 * @generated
	 */
	EList<Group> getGroupMemberships();

} // OrgUnit
