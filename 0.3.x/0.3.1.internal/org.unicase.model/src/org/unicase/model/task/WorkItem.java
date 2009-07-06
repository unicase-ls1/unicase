/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.unicase.model.task;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.Annotation;
import org.unicase.model.change.ModelChangePackage;
import org.unicase.model.organization.OrgUnit;

/*
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Work Item</b></em>'. <!-- end-user-doc --> <p>
 * The following features are supported: <ul> <li>{@link org.unicase.model.task.WorkItem#getContainingWorkpackage
 * <em>Containing Workpackage</em>}</li> <li>{@link org.unicase.model.task.WorkItem#getAssociatedChangePackages
 * <em>Associated Change Packages</em>}</li> <li>{@link org.unicase.model.task.WorkItem#getPredecessors
 * <em>Predecessors</em>}</li> <li>{@link org.unicase.model.task.WorkItem#getSuccessors <em>Successors</em>}</li>
 * <li>{@link org.unicase.model.task.WorkItem#getAssignee <em>Assignee</em>}</li> <li>{@link
 * org.unicase.model.task.WorkItem#getParticipants <em>Participants</em>}</li> <li>{@link
 * org.unicase.model.task.WorkItem#getDueDate <em>Due Date</em>}</li> <li>{@link
 * org.unicase.model.task.WorkItem#getEstimate <em>Estimate</em>}</li> <li>{@link
 * org.unicase.model.task.WorkItem#getEffort <em>Effort</em>}</li> </ul> </p>
 * @see org.unicase.model.task.TaskPackage#getWorkItem()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface WorkItem extends Annotation {
	/**
	 * Returns the value of the '<em><b>Containing Workpackage</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.task.WorkPackage#getContainedWorkItems <em>Contained Work Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Workpackage</em>' container reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Workpackage</em>' container reference.
	 * @see #setContainingWorkpackage(WorkPackage)
	 * @see org.unicase.model.task.TaskPackage#getWorkItem_ContainingWorkpackage()
	 * @see org.unicase.model.task.WorkPackage#getContainedWorkItems
	 * @model opposite="containedWorkItems" keys="identifier" transient="false"
	 *        annotation="org.unicase.ui.meeditor priority='10.0' position='left'"
	 * @generated
	 */
	WorkPackage getContainingWorkpackage();

	/**
	 * Sets the value of the '{@link org.unicase.model.task.WorkItem#getContainingWorkpackage <em>Containing Workpackage</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing Workpackage</em>' container reference.
	 * @see #getContainingWorkpackage()
	 * @generated
	 */
	void setContainingWorkpackage(WorkPackage value);

	/**
	 * Returns the value of the '<em><b>Associated Change Packages</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.change.ModelChangePackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associated Change Packages</em>' reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated Change Packages</em>' reference list.
	 * @see org.unicase.model.task.TaskPackage#getWorkItem_AssociatedChangePackages()
	 * @model keys="identifier"
	 * @generated
	 */
	EList<ModelChangePackage> getAssociatedChangePackages();

	/**
	 * Returns the value of the '<em><b>Predecessors</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.task.WorkItem}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.task.WorkItem#getSuccessors <em>Successors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predecessors</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predecessors</em>' reference list.
	 * @see org.unicase.model.task.TaskPackage#getWorkItem_Predecessors()
	 * @see org.unicase.model.task.WorkItem#getSuccessors
	 * @model opposite="successors" keys="identifier"
	 *        annotation="org.unicase.ui.meeditor priority='11.0' position='right'"
	 * @generated
	 */
	EList<WorkItem> getPredecessors();

	/**
	 * Returns the value of the '<em><b>Successors</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.task.WorkItem}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.task.WorkItem#getPredecessors <em>Predecessors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Successors</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Successors</em>' reference list.
	 * @see org.unicase.model.task.TaskPackage#getWorkItem_Successors()
	 * @see org.unicase.model.task.WorkItem#getPredecessors
	 * @model opposite="predecessors" keys="identifier"
	 *        annotation="org.unicase.ui.meeditor priority='12.0' position='right'"
	 * @generated
	 */
	EList<WorkItem> getSuccessors();

	/**
	 * Returns the value of the '<em><b>Assignee</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.organization.OrgUnit#getAssignments <em>Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignee</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignee</em>' reference.
	 * @see #setAssignee(OrgUnit)
	 * @see org.unicase.model.task.TaskPackage#getWorkItem_Assignee()
	 * @see org.unicase.model.organization.OrgUnit#getAssignments
	 * @model opposite="assignments" keys="identifier"
	 *        annotation="org.unicase.ui.meeditor priority='11.0' position='left'"
	 * @generated
	 */
	OrgUnit getAssignee();

	/**
	 * Sets the value of the '{@link org.unicase.model.task.WorkItem#getAssignee <em>Assignee</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Assignee</em>' reference.
	 * @see #getAssignee()
	 * @generated
	 */
	void setAssignee(OrgUnit value);

	/**
	 * Returns the value of the '<em><b>Participants</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.organization.OrgUnit}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.organization.OrgUnit#getParticipations <em>Participations</em>}'.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Participants</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participants</em>' reference list.
	 * @see org.unicase.model.task.TaskPackage#getWorkItem_Participants()
	 * @see org.unicase.model.organization.OrgUnit#getParticipations
	 * @model opposite="participations" keys="identifier"
	 *        annotation="org.unicase.ui.meeditor priority='10.0' position='right'"
	 * @generated
	 */
	EList<OrgUnit> getParticipants();

	/**
	 * Returns the value of the '<em><b>Due Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Due Date</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Due Date</em>' attribute.
	 * @see #setDueDate(Date)
	 * @see org.unicase.model.task.TaskPackage#getWorkItem_DueDate()
	 * @model annotation="org.unicase.ui.meeditor priority='12.0' position='left'"
	 * @generated
	 */
	Date getDueDate();

	/**
	 * Sets the value of the '{@link org.unicase.model.task.WorkItem#getDueDate <em>Due Date</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Due Date</em>' attribute.
	 * @see #getDueDate()
	 * @generated
	 */
	void setDueDate(Date value);

	/**
	 * Returns the value of the '<em><b>Estimate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Estimate</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Estimate</em>' attribute.
	 * @see #setEstimate(int)
	 * @see org.unicase.model.task.TaskPackage#getWorkItem_Estimate()
	 * @model
	 * @generated
	 */
	int getEstimate();

	/**
	 * Sets the value of the '{@link org.unicase.model.task.WorkItem#getEstimate <em>Estimate</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Estimate</em>' attribute.
	 * @see #getEstimate()
	 * @generated
	 */
	void setEstimate(int value);

	/**
	 * Returns the value of the '<em><b>Effort</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Effort</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Effort</em>' attribute.
	 * @see #setEffort(int)
	 * @see org.unicase.model.task.TaskPackage#getWorkItem_Effort()
	 * @model
	 * @generated
	 */
	int getEffort();

	/**
	 * Sets the value of the '{@link org.unicase.model.task.WorkItem#getEffort <em>Effort</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Effort</em>' attribute.
	 * @see #getEffort()
	 * @generated
	 */
	void setEffort(int value);

} // WorkItem
