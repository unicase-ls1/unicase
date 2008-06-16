/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.task;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Work Package</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.task.WorkPackage#getContainedWorkItems <em>Contained Work Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.task.TaskPackage#getWorkPackage()
 * @model
 * @generated
 */
public interface WorkPackage extends WorkItem {
	/**
	 * Returns the value of the '<em><b>Contained Work Items</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.task.WorkItem}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.task.WorkItem#getContainingWorkpackage <em>Containing Workpackage</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained Work Items</em>' containment
	 * reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Work Items</em>' containment reference list.
	 * @see org.unicase.model.task.TaskPackage#getWorkPackage_ContainedWorkItems()
	 * @see org.unicase.model.task.WorkItem#getContainingWorkpackage
	 * @model opposite="containingWorkpackage" containment="true"
	 * @generated
	 */
	EList<WorkItem> getContainedWorkItems();

} // WorkPackage
