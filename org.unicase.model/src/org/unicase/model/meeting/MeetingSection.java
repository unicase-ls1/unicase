/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.meeting;

import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Section</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.meeting.MeetingSection#getAllocatedTime <em>Allocated Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.meeting.MeetingPackage#getMeetingSection()
 * @model abstract="true"
 * @generated
 */
public interface MeetingSection extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Allocated Time</b></em>' attribute. The default value is <code>"0"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allocated Time</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Allocated Time</em>' attribute.
	 * @see #setAllocatedTime(int)
	 * @see org.unicase.model.meeting.MeetingPackage#getMeetingSection_AllocatedTime()
	 * @model default="0"
	 * @generated
	 */
	int getAllocatedTime();

	/**
	 * Sets the value of the '{@link org.unicase.model.meeting.MeetingSection#getAllocatedTime <em>Allocated Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allocated Time</em>' attribute.
	 * @see #getAllocatedTime()
	 * @generated
	 */
	void setAllocatedTime(int value);

} // MeetingSection
