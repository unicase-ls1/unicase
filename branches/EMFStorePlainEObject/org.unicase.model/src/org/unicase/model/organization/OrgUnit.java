/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.organization;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.WorkItem;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Org Unit</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.organization.OrgUnit#getAcOrgId <em>Ac Org Id</em>}</li>
 * <li>{@link org.unicase.model.organization.OrgUnit#getGroupMemberships <em>Group Memberships</em>}</li>
 * <li>{@link org.unicase.model.organization.OrgUnit#getAssignments <em>Assignments</em>}</li>
 * <li>{@link org.unicase.model.organization.OrgUnit#getParticipations <em>Participations</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.organization.OrganizationPackage#getOrgUnit()
 * @model abstract="true"
 * @generated
 */
public interface OrgUnit extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Ac Org Id</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ac Org Id</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Ac Org Id</em>' attribute.
	 * @see #setAcOrgId(String)
	 * @see org.unicase.model.organization.OrganizationPackage#getOrgUnit_AcOrgId()
	 * @model
	 * @generated
	 */
	String getAcOrgId();

	/**
	 * Sets the value of the '{@link org.unicase.model.organization.OrgUnit#getAcOrgId <em>Ac Org Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Ac Org Id</em>' attribute.
	 * @see #getAcOrgId()
	 * @generated
	 */
	void setAcOrgId(String value);

	/**
	 * Returns the value of the '<em><b>Group Memberships</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.organization.Group}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.organization.Group#getOrgUnits <em>Org Units</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group Memberships</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Group Memberships</em>' reference list.
	 * @see org.unicase.model.organization.OrganizationPackage#getOrgUnit_GroupMemberships()
	 * @see org.unicase.model.organization.Group#getOrgUnits
	 * @model opposite="orgUnits" annotation="org.unicase.ui.meeditor priority='10.0' position='right'"
	 * @generated
	 */
	EList<Group> getGroupMemberships();

	/**
	 * Returns the value of the '<em><b>Assignments</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.task.WorkItem}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.task.WorkItem#getAssignee <em>Assignee</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignments</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Assignments</em>' reference list.
	 * @see org.unicase.model.organization.OrganizationPackage#getOrgUnit_Assignments()
	 * @see org.unicase.model.task.WorkItem#getAssignee
	 * @model opposite="assignee" annotation="org.unicase.ui.meeditor priority='11.0' position='right'"
	 * @generated
	 */
	EList<WorkItem> getAssignments();

	/**
	 * Returns the value of the '<em><b>Participations</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.task.WorkItem}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.task.WorkItem#getParticipants <em>Participants</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participations</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Participations</em>' reference list.
	 * @see org.unicase.model.organization.OrganizationPackage#getOrgUnit_Participations()
	 * @see org.unicase.model.task.WorkItem#getParticipants
	 * @model opposite="participants"
	 * @generated
	 */
	EList<WorkItem> getParticipations();

} // OrgUnit
