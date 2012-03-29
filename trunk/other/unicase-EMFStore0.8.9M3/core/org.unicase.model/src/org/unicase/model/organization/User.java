/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.organization;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.task.WorkItem;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>User</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.organization.User#getEmail <em>Email</em>}</li>
 * <li>{@link org.unicase.model.organization.User#getFirstName <em>First Name</em>}</li>
 * <li>{@link org.unicase.model.organization.User#getLastName <em>Last Name</em>}</li>
 * <li>{@link org.unicase.model.organization.User#getWorkItemsToReview <em>Work Items To Review</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.organization.OrganizationPackage#getUser()
 * @model
 * @generated
 */
public interface User extends OrgUnit {

	/**
	 * Returns the value of the '<em><b>Email</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Email</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Email</em>' attribute.
	 * @see #setEmail(String)
	 * @see org.unicase.model.organization.OrganizationPackage#getUser_Email()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='10.0' position='left'"
	 * @generated
	 */
	String getEmail();

	/**
	 * Sets the value of the '{@link org.unicase.model.organization.User#getEmail <em>Email</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Email</em>' attribute.
	 * @see #getEmail()
	 * @generated
	 */
	void setEmail(String value);

	/**
	 * Returns the value of the '<em><b>First Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Name</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>First Name</em>' attribute.
	 * @see #setFirstName(String)
	 * @see org.unicase.model.organization.OrganizationPackage#getUser_FirstName()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='11.0' position='left'"
	 * @generated
	 */
	String getFirstName();

	/**
	 * Sets the value of the '{@link org.unicase.model.organization.User#getFirstName <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>First Name</em>' attribute.
	 * @see #getFirstName()
	 * @generated
	 */
	void setFirstName(String value);

	/**
	 * Returns the value of the '<em><b>Last Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Name</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Last Name</em>' attribute.
	 * @see #setLastName(String)
	 * @see org.unicase.model.organization.OrganizationPackage#getUser_LastName()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='12.0' position='left'"
	 * @generated
	 */
	String getLastName();

	/**
	 * Sets the value of the '{@link org.unicase.model.organization.User#getLastName <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Last Name</em>' attribute.
	 * @see #getLastName()
	 * @generated
	 */
	void setLastName(String value);

	/**
	 * Returns the value of the '<em><b>Work Items To Review</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.task.WorkItem}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.task.WorkItem#getReviewer <em>Reviewer</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Work Items To Review</em>' reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Work Items To Review</em>' reference list.
	 * @see org.unicase.model.organization.OrganizationPackage#getUser_WorkItemsToReview()
	 * @see org.unicase.model.task.WorkItem#getReviewer
	 * @model opposite="reviewer"
	 * @generated
	 */
	EList<WorkItem> getWorkItemsToReview();
} // User
