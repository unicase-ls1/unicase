/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.organization;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Group</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.organization.Group#getOrgUnits <em>Org Units</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.organization.OrganizationPackage#getGroup()
 * @model
 * @generated
 */
public interface Group extends OrgUnit {

	/**
	 * Returns the value of the '<em><b>Org Units</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.organization.OrgUnit#getGroupMemberships <em>Group Memberships</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Org Units</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Org Units</em>' reference.
	 * @see #setOrgUnits(OrgUnit)
	 * @see org.unicase.model.organization.OrganizationPackage#getGroup_OrgUnits()
	 * @see org.unicase.model.organization.OrgUnit#getGroupMemberships
	 * @model opposite="groupMemberships" keys="identifier"
	 * @generated
	 */
	OrgUnit getOrgUnits();

	/**
	 * Sets the value of the '{@link org.unicase.model.organization.Group#getOrgUnits <em>Org Units</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Org Units</em>' reference.
	 * @see #getOrgUnits()
	 * @generated
	 */
	void setOrgUnits(OrgUnit value);
} // Group
