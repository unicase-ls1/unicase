/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.meeting.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.model.meeting.*;
import org.unicase.model.meeting.CompositeMeetingSection;
import org.unicase.model.meeting.IssueMeetingSection;
import org.unicase.model.meeting.Meeting;
import org.unicase.model.meeting.MeetingFactory;
import org.unicase.model.meeting.MeetingPackage;
import org.unicase.model.meeting.WorkItemMeetingSection;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class MeetingFactoryImpl extends EFactoryImpl implements MeetingFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static MeetingFactory init() {
		try {
			MeetingFactory theMeetingFactory = (MeetingFactory) EPackage.Registry.INSTANCE
					.getEFactory(MeetingPackage.eNS_URI);
			if (theMeetingFactory != null) {
				return theMeetingFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MeetingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MeetingFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case MeetingPackage.MEETING:
			return createMeeting();
		case MeetingPackage.COMPOSITE_MEETING_SECTION:
			return createCompositeMeetingSection();
		case MeetingPackage.ISSUE_MEETING_SECTION:
			return createIssueMeetingSection();
		case MeetingPackage.WORK_ITEM_MEETING_SECTION:
			return createWorkItemMeetingSection();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Meeting createMeeting() {
		MeetingImpl meeting = new MeetingImpl();
		return meeting;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeMeetingSection createCompositeMeetingSection() {
		CompositeMeetingSectionImpl compositeMeetingSection = new CompositeMeetingSectionImpl();
		return compositeMeetingSection;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IssueMeetingSection createIssueMeetingSection() {
		IssueMeetingSectionImpl issueMeetingSection = new IssueMeetingSectionImpl();
		return issueMeetingSection;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WorkItemMeetingSection createWorkItemMeetingSection() {
		WorkItemMeetingSectionImpl workItemMeetingSection = new WorkItemMeetingSectionImpl();
		return workItemMeetingSection;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MeetingPackage getMeetingPackage() {
		return (MeetingPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MeetingPackage getPackage() {
		return MeetingPackage.eINSTANCE;
	}

} // MeetingFactoryImpl
