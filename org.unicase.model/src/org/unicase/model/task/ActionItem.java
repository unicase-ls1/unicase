/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Action Item</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.task.ActionItem#isDone <em>Done</em>}</li>
 *   <li>{@link org.unicase.model.task.ActionItem#getActivity <em>Activity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.task.TaskPackage#getActionItem()
 * @model
 * @generated
 */
public interface ActionItem extends WorkItem, Checkable {
	/**
	 * Returns the value of the '<em><b>Done</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Done</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Done</em>' attribute.
	 * @see #setDone(boolean)
	 * @see org.unicase.model.task.TaskPackage#getActionItem_Done()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='17.0' position='left'"
	 * @generated
	 */
	boolean isDone();

	/**
	 * Sets the value of the '{@link org.unicase.model.task.ActionItem#isDone <em>Done</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Done</em>' attribute.
	 * @see #isDone()
	 * @generated
	 */
	void setDone(boolean value);

	/**
	 * Returns the value of the '<em><b>Activity</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.model.task.ActivityType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activity</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activity</em>' attribute.
	 * @see org.unicase.model.task.ActivityType
	 * @see #setActivity(ActivityType)
	 * @see org.unicase.model.task.TaskPackage#getActionItem_Activity()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='9.5' position='left'"
	 * @generated
	 */
	ActivityType getActivity();

	/**
	 * Sets the value of the '{@link org.unicase.model.task.ActionItem#getActivity <em>Activity</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Activity</em>' attribute.
	 * @see org.unicase.model.task.ActivityType
	 * @see #getActivity()
	 * @generated
	 */
	void setActivity(ActivityType value);

} // ActionItem
