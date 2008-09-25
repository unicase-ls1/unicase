/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.bug;

import org.unicase.model.task.Checkable;
import org.unicase.model.task.WorkItem;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Report</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.bug.BugReport#getStatus <em>Status</em>}</li>
 *   <li>{@link org.unicase.model.bug.BugReport#getSeverity <em>Severity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.bug.BugPackage#getBugReport()
 * @model
 * @generated
 */
public interface BugReport extends WorkItem, Checkable {
	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute. The literals
	 * are from the enumeration {@link org.unicase.model.bug.BugStatus}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see org.unicase.model.bug.BugStatus
	 * @see #setStatus(BugStatus)
	 * @see org.unicase.model.bug.BugPackage#getBugReport_Status()
	 * @model
	 * @generated
	 */
	BugStatus getStatus();

	/**
	 * Sets the value of the '{@link org.unicase.model.bug.BugReport#getStatus
	 * <em>Status</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Status</em>' attribute.
	 * @see org.unicase.model.bug.BugStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(BugStatus value);

	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.model.bug.Severity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see org.unicase.model.bug.Severity
	 * @see #setSeverity(Severity)
	 * @see org.unicase.model.bug.BugPackage#getBugReport_Severity()
	 * @model
	 * @generated
	 */
	Severity getSeverity();

	/**
	 * Sets the value of the '{@link org.unicase.model.bug.BugReport#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see org.unicase.model.bug.Severity
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(Severity value);

} // BugReport
