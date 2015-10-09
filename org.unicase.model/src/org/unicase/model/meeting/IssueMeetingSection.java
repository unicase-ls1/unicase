/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.meeting;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.rationale.Issue;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Issue Meeting Section</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.meeting.IssueMeetingSection#getIncludedIssues <em>Included Issues</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.meeting.MeetingPackage#getIssueMeetingSection()
 * @model
 * @generated
 */
public interface IssueMeetingSection extends MeetingSection {
	/**
	 * Returns the value of the '<em><b>Included Issues</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.rationale.Issue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Included Issues</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Included Issues</em>' reference list.
	 * @see org.unicase.model.meeting.MeetingPackage#getIssueMeetingSection_IncludedIssues()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='10.0' position='right'"
	 * @generated
	 */
	EList<Issue> getIncludedIssues();

} // IssueMeetingSection
