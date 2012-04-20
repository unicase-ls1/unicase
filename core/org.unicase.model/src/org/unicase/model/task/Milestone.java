/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Milestone</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.task.Milestone#getContainedModelElements <em>Contained Model Elements</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.task.TaskPackage#getMilestone()
 * @model
 * @generated
 */
public interface Milestone extends WorkItem {

	/**
	 * Returns the value of the '<em><b>Contained Model Elements</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.UnicaseModelElement}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained Model Elements</em>' reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Contained Model Elements</em>' reference list.
	 * @see org.unicase.model.task.TaskPackage#getMilestone_ContainedModelElements()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='1' position='right'"
	 * @generated
	 */
	EList<UnicaseModelElement> getContainedModelElements();
} // Milestone
