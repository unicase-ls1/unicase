/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.organization;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Group</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.organization.Group#getOrgUnits <em>Org Units</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.organization.OrganizationPackage#getGroup()
 * @model
 * @generated
 */
public interface Group extends OrgUnit {

	/**
	 * Returns the value of the '<em><b>Org Units</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.organization.OrgUnit}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.organization.OrgUnit#getGroupMemberships <em>Group Memberships</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Org Units</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Org Units</em>' reference list.
	 * @see org.unicase.model.organization.OrganizationPackage#getGroup_OrgUnits()
	 * @see org.unicase.model.organization.OrgUnit#getGroupMemberships
	 * @model opposite="groupMemberships" keys="identifier"
	 * @generated
	 */
	EList<OrgUnit> getOrgUnits();
} // Group
