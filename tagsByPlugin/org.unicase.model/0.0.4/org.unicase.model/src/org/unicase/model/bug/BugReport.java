/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.bug;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.requirement.Step;
import org.unicase.model.task.WorkItem;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Report</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.bug.BugReport#getStepsToReproduce <em>Steps To Reproduce</em>}</li>
 *   <li>{@link org.unicase.model.bug.BugReport#getStatus <em>Status</em>}</li>
 *   <li>{@link org.unicase.model.bug.BugReport#getAssignedTo <em>Assigned To</em>}</li>
 *   <li>{@link org.unicase.model.bug.BugReport#getResolution <em>Resolution</em>}</li>
 *   <li>{@link org.unicase.model.bug.BugReport#getSeverity <em>Severity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.bug.BugPackage#getBugReport()
 * @model
 * @generated
 */
public interface BugReport extends WorkItem {
	/**
	 * Returns the value of the '<em><b>Steps To Reproduce</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.Step}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Steps To Reproduce</em>' reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Steps To Reproduce</em>' reference list.
	 * @see org.unicase.model.bug.BugPackage#getBugReport_StepsToReproduce()
	 * @model keys="identifier"
	 * @generated
	 */
	EList<Step> getStepsToReproduce();

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
	 * Returns the value of the '<em><b>Assigned To</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assigned To</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Assigned To</em>' reference.
	 * @see #setAssignedTo(OrgUnit)
	 * @see org.unicase.model.bug.BugPackage#getBugReport_AssignedTo()
	 * @model
	 * @generated
	 */
	OrgUnit getAssignedTo();

	/**
	 * Sets the value of the '{@link org.unicase.model.bug.BugReport#getAssignedTo <em>Assigned To</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Assigned To</em>' reference.
	 * @see #getAssignedTo()
	 * @generated
	 */
	void setAssignedTo(OrgUnit value);

	/**
	 * Returns the value of the '<em><b>Resolution</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolution</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Resolution</em>' reference.
	 * @see #setResolution(BugResolution)
	 * @see org.unicase.model.bug.BugPackage#getBugReport_Resolution()
	 * @model
	 * @generated
	 */
	BugResolution getResolution();

	/**
	 * Sets the value of the '{@link org.unicase.model.bug.BugReport#getResolution <em>Resolution</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolution</em>' reference.
	 * @see #getResolution()
	 * @generated
	 */
	void setResolution(BugResolution value);

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
