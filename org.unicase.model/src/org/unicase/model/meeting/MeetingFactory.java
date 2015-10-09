/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.meeting;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * @see org.unicase.model.meeting.MeetingPackage
 * @generated
 */
public interface MeetingFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	MeetingFactory eINSTANCE = org.unicase.model.meeting.impl.MeetingFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Meeting</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Meeting</em>'.
	 * @generated
	 */
	Meeting createMeeting();

	/**
	 * Returns a new object of class '<em>Composite Meeting Section</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Meeting Section</em>'.
	 * @generated
	 */
	CompositeMeetingSection createCompositeMeetingSection();

	/**
	 * Returns a new object of class '<em>Issue Meeting Section</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Issue Meeting Section</em>'.
	 * @generated
	 */
	IssueMeetingSection createIssueMeetingSection();

	/**
	 * Returns a new object of class '<em>Work Item Meeting Section</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Work Item Meeting Section</em>'.
	 * @generated
	 */
	WorkItemMeetingSection createWorkItemMeetingSection();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MeetingPackage getMeetingPackage();

} // MeetingFactory
