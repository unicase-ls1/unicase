/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.dashboard;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Task Trace Classes Composite</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.dashboard.TaskTraceClassesComposite#getTaskTraceClasses <em>Task Trace Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.dashboard.DashboardPackage#getTaskTraceClassesComposite()
 * @model
 * @generated
 */
public interface TaskTraceClassesComposite extends
		org.eclipse.emf.emfstore.internal.common.model.NonDomainElement {
	/**
	 * Returns the value of the '<em><b>Task Trace Classes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Trace Classes</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Trace Classes</em>' reference list.
	 * @see org.unicase.dashboard.DashboardPackage#getTaskTraceClassesComposite_TaskTraceClasses()
	 * @model
	 * @generated
	 */
	EList<EObject> getTaskTraceClasses();

} // TaskTraceClassesComposite
