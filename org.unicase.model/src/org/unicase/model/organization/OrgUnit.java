/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.organization;

import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Org Unit</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.organization.OrgUnit#getOrgId <em>Org Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.organization.OrganizationPackage#getOrgUnit()
 * @model
 * @generated
 */
public interface OrgUnit extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Org Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Org Id</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Org Id</em>' containment reference.
	 * @see #setOrgId(OrgUnitId)
	 * @see org.unicase.model.organization.OrganizationPackage#getOrgUnit_OrgId()
	 * @model containment="true"
	 * @generated
	 */
	OrgUnitId getOrgId();

	/**
	 * Sets the value of the '{@link org.unicase.model.organization.OrgUnit#getOrgId <em>Org Id</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Org Id</em>' containment reference.
	 * @see #getOrgId()
	 * @generated
	 */
	void setOrgId(OrgUnitId value);

} // OrgUnit
