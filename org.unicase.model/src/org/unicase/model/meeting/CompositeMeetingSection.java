/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.meeting;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Composite Meeting Section</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.meeting.CompositeMeetingSection#getSubsections <em>Subsections</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.meeting.MeetingPackage#getCompositeMeetingSection()
 * @model
 * @generated
 */
public interface CompositeMeetingSection extends MeetingSection {
	/**
	 * Returns the value of the '<em><b>Subsections</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.meeting.MeetingSection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsections</em>' containment reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subsections</em>' containment reference list.
	 * @see org.unicase.model.meeting.MeetingPackage#getCompositeMeetingSection_Subsections()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<MeetingSection> getSubsections();

} // CompositeMeetingSection
