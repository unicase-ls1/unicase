/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.meeting;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.task.WorkItem;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Work Item Meeting Section</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.meeting.WorkItemMeetingSection#getIncludedWorkItems <em>Included Work Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.meeting.MeetingPackage#getWorkItemMeetingSection()
 * @model
 * @generated
 */
public interface WorkItemMeetingSection extends MeetingSection {
	/**
	 * Returns the value of the '<em><b>Included Work Items</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.task.WorkItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Included Work Items</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Included Work Items</em>' reference list.
	 * @see org.unicase.model.meeting.MeetingPackage#getWorkItemMeetingSection_IncludedWorkItems()
	 * @model annotation="org.unicase.ui.meeditor priority='10.0' position='right'"
	 * @generated
	 */
	EList<WorkItem> getIncludedWorkItems();

} // WorkItemMeetingSection
