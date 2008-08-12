/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.task;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.Annotation;
import org.unicase.model.change.ModelChangePackage;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Work Item</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.task.WorkItem#getContainingWorkpackage <em>Containing Workpackage</em>}</li>
 *   <li>{@link org.unicase.model.task.WorkItem#getAssociatedChangePackages <em>Associated Change Packages</em>}</li>
 *   <li>{@link org.unicase.model.task.WorkItem#getPredecessors <em>Predecessors</em>}</li>
 *   <li>{@link org.unicase.model.task.WorkItem#getSuccessors <em>Successors</em>}</li>
 * </ul>
 * </p>
 *
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
	 * If the meaning of the '<em>Containing Workpackage</em>' container
	 * reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Workpackage</em>' container reference.
	 * @see #setContainingWorkpackage(WorkPackage)
	 * @see org.unicase.model.task.TaskPackage#getWorkItem_ContainingWorkpackage()
	 * @see org.unicase.model.task.WorkPackage#getContainedWorkItems
	 * @model opposite="containedWorkItems" keys="identifier" transient="false"
	 * @generated
	 */
	WorkPackage getContainingWorkpackage();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.model.task.WorkItem#getContainingWorkpackage
	 * <em>Containing Workpackage</em>}' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Containing Workpackage</em>'
	 *            container reference.
	 * @see #getContainingWorkpackage()
	 * @generated
	 */
	void setContainingWorkpackage(WorkPackage value);

	/**
	 * Returns the value of the '<em><b>Associated Change Packages</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.change.ModelChangePackage}.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Associated Change Packages</em>' reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated Change Packages</em>' reference list.
	 * @see org.unicase.model.task.TaskPackage#getWorkItem_AssociatedChangePackages()
	 * @model keys="identifier"
	 * @generated
	 */
	EList<ModelChangePackage> getAssociatedChangePackages();

	/**
	 * Returns the value of the '<em><b>Predecessors</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.task.WorkItem#getSuccessors <em>Successors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predecessors</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predecessors</em>' reference.
	 * @see #setPredecessors(WorkItem)
	 * @see org.unicase.model.task.TaskPackage#getWorkItem_Predecessors()
	 * @see org.unicase.model.task.WorkItem#getSuccessors
	 * @model opposite="successors" keys="identifier"
	 * @generated
	 */
	WorkItem getPredecessors();

	/**
	 * Sets the value of the '{@link org.unicase.model.task.WorkItem#getPredecessors <em>Predecessors</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predecessors</em>' reference.
	 * @see #getPredecessors()
	 * @generated
	 */
	void setPredecessors(WorkItem value);

	/**
	 * Returns the value of the '<em><b>Successors</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.task.WorkItem#getPredecessors <em>Predecessors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Successors</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Successors</em>' reference.
	 * @see #setSuccessors(WorkItem)
	 * @see org.unicase.model.task.TaskPackage#getWorkItem_Successors()
	 * @see org.unicase.model.task.WorkItem#getPredecessors
	 * @model opposite="predecessors" keys="identifier"
	 * @generated
	 */
	WorkItem getSuccessors();

	/**
	 * Sets the value of the '{@link org.unicase.model.task.WorkItem#getSuccessors <em>Successors</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Successors</em>' reference.
	 * @see #getSuccessors()
	 * @generated
	 */
	void setSuccessors(WorkItem value);

} // WorkItem
