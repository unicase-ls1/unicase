/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.task;

import org.eclipse.emf.common.util.EList;

import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;

import org.unicase.model.change.ModelChangePackage;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Work Item</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.task.WorkItem#getContainingWorkpackage <em>
 * Containing Workpackage</em>}</li>
 * <li>{@link org.unicase.model.task.WorkItem#getAssociatedChangePackages <em>
 * Associated Change Packages</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.task.TaskPackage#getWorkItem()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface WorkItem extends Annotation {
	/**
	 * Returns the value of the '<em><b>Containing Workpackage</b></em>'
	 * container reference. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.task.WorkPackage#getContainedWorkItems
	 * <em>Contained Work Items</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Workpackage</em>' container
	 * reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Containing Workpackage</em>' container
	 *         reference.
	 * @see #setContainingWorkpackage(WorkPackage)
	 * @see org.unicase.model.task.TaskPackage#getWorkItem_ContainingWorkpackage()
	 * @see org.unicase.model.task.WorkPackage#getContainedWorkItems
	 * @model opposite="containedWorkItems" transient="false"
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
	 * Returns the value of the '<em><b>Associated Change Packages</b></em>'
	 * reference list. The list contents are of type
	 * {@link org.unicase.model.change.ModelChangePackage}. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Associated Change Packages</em>' reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Associated Change Packages</em>' reference
	 *         list.
	 * @see org.unicase.model.task.TaskPackage#getWorkItem_AssociatedChangePackages()
	 * @model
	 * @generated
	 */
	EList<ModelChangePackage> getAssociatedChangePackages();

} // WorkItem
