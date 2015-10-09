/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task;

import org.eclipse.emf.ecore.EObject;
import org.unicase.model.organization.OrgUnit;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Assignable</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.task.Assignable#getAssignee <em>Assignee</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.task.TaskPackage#getAssignable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Assignable extends EObject {
	/**
	 * Returns the value of the '<em><b>Assignee</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignee</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Assignee</em>' reference.
	 * @see #setAssignee(OrgUnit)
	 * @see org.unicase.model.task.TaskPackage#getAssignable_Assignee()
	 * @model keys="identifier" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	OrgUnit getAssignee();

	/**
	 * Sets the value of the '{@link org.unicase.model.task.Assignable#getAssignee <em>Assignee</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Assignee</em>' reference.
	 * @see #getAssignee()
	 * @generated
	 */
	void setAssignee(OrgUnit value);

} // Assignable
