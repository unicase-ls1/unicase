/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.meeting;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Meeting</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.meeting.Meeting#getLocation <em>Location</em>}</li>
 *   <li>{@link org.unicase.model.meeting.Meeting#getStarttime <em>Starttime</em>}</li>
 *   <li>{@link org.unicase.model.meeting.Meeting#getEndtime <em>Endtime</em>}</li>
 *   <li>{@link org.unicase.model.meeting.Meeting#getFacilitator <em>Facilitator</em>}</li>
 *   <li>{@link org.unicase.model.meeting.Meeting#getMinutetaker <em>Minutetaker</em>}</li>
 *   <li>{@link org.unicase.model.meeting.Meeting#getTimekeeper <em>Timekeeper</em>}</li>
 *   <li>{@link org.unicase.model.meeting.Meeting#getParticipants <em>Participants</em>}</li>
 *   <li>{@link org.unicase.model.meeting.Meeting#getSections <em>Sections</em>}</li>
 *   <li>{@link org.unicase.model.meeting.Meeting#getIdentifiedIssuesSection <em>Identified Issues Section</em>}</li>
 *   <li>{@link org.unicase.model.meeting.Meeting#getIdentifiedWorkItemsSection <em>Identified Work Items Section</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.meeting.MeetingPackage#getMeeting()
 * @model
 * @generated
 */
public interface Meeting extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see org.unicase.model.meeting.MeetingPackage#getMeeting_Location()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='10.0' position='left'"
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link org.unicase.model.meeting.Meeting#getLocation <em>Location</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Starttime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Starttime</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Starttime</em>' attribute.
	 * @see #setStarttime(Date)
	 * @see org.unicase.model.meeting.MeetingPackage#getMeeting_Starttime()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='11.0' position='left'"
	 * @generated
	 */
	Date getStarttime();

	/**
	 * Sets the value of the '{@link org.unicase.model.meeting.Meeting#getStarttime <em>Starttime</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Starttime</em>' attribute.
	 * @see #getStarttime()
	 * @generated
	 */
	void setStarttime(Date value);

	/**
	 * Returns the value of the '<em><b>Endtime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endtime</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endtime</em>' attribute.
	 * @see #setEndtime(Date)
	 * @see org.unicase.model.meeting.MeetingPackage#getMeeting_Endtime()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='11.0' position='left'"
	 * @generated
	 */
	Date getEndtime();

	/**
	 * Sets the value of the '{@link org.unicase.model.meeting.Meeting#getEndtime <em>Endtime</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Endtime</em>' attribute.
	 * @see #getEndtime()
	 * @generated
	 */
	void setEndtime(Date value);

	/**
	 * Returns the value of the '<em><b>Facilitator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facilitator</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facilitator</em>' reference.
	 * @see #setFacilitator(User)
	 * @see org.unicase.model.meeting.MeetingPackage#getMeeting_Facilitator()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='12.0' position='left'"
	 * @generated
	 */
	User getFacilitator();

	/**
	 * Sets the value of the '{@link org.unicase.model.meeting.Meeting#getFacilitator <em>Facilitator</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facilitator</em>' reference.
	 * @see #getFacilitator()
	 * @generated
	 */
	void setFacilitator(User value);

	/**
	 * Returns the value of the '<em><b>Minutetaker</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minutetaker</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minutetaker</em>' reference.
	 * @see #setMinutetaker(User)
	 * @see org.unicase.model.meeting.MeetingPackage#getMeeting_Minutetaker()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='12.0' position='left'"
	 * @generated
	 */
	User getMinutetaker();

	/**
	 * Sets the value of the '{@link org.unicase.model.meeting.Meeting#getMinutetaker <em>Minutetaker</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minutetaker</em>' reference.
	 * @see #getMinutetaker()
	 * @generated
	 */
	void setMinutetaker(User value);

	/**
	 * Returns the value of the '<em><b>Timekeeper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timekeeper</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timekeeper</em>' reference.
	 * @see #setTimekeeper(User)
	 * @see org.unicase.model.meeting.MeetingPackage#getMeeting_Timekeeper()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='12.0' position='left'"
	 * @generated
	 */
	User getTimekeeper();

	/**
	 * Sets the value of the '{@link org.unicase.model.meeting.Meeting#getTimekeeper <em>Timekeeper</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timekeeper</em>' reference.
	 * @see #getTimekeeper()
	 * @generated
	 */
	void setTimekeeper(User value);

	/**
	 * Returns the value of the '<em><b>Participants</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.organization.OrgUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participants</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participants</em>' reference list.
	 * @see org.unicase.model.meeting.MeetingPackage#getMeeting_Participants()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='10.0' position='right'"
	 * @generated
	 */
	EList<OrgUnit> getParticipants();

	/**
	 * Returns the value of the '<em><b>Sections</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.meeting.MeetingSection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sections</em>' containment reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sections</em>' containment reference list.
	 * @see org.unicase.model.meeting.MeetingPackage#getMeeting_Sections()
	 * @model containment="true" resolveProxies="true"
	 *        annotation="org.eclipse.emf.ecp.editor priority='11.0' position='right'"
	 * @generated
	 */
	EList<MeetingSection> getSections();

	/**
	 * Returns the value of the '<em><b>Identified Issues Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identified Issues Section</em>' reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identified Issues Section</em>' reference.
	 * @see #setIdentifiedIssuesSection(IssueMeetingSection)
	 * @see org.unicase.model.meeting.MeetingPackage#getMeeting_IdentifiedIssuesSection()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='13.0' position='left'"
	 * @generated
	 */
	IssueMeetingSection getIdentifiedIssuesSection();

	/**
	 * Sets the value of the '{@link org.unicase.model.meeting.Meeting#getIdentifiedIssuesSection <em>Identified Issues Section</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identified Issues Section</em>' reference.
	 * @see #getIdentifiedIssuesSection()
	 * @generated
	 */
	void setIdentifiedIssuesSection(IssueMeetingSection value);

	/**
	 * Returns the value of the '<em><b>Identified Work Items Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identified Work Items Section</em>' reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identified Work Items Section</em>' reference.
	 * @see #setIdentifiedWorkItemsSection(WorkItemMeetingSection)
	 * @see org.unicase.model.meeting.MeetingPackage#getMeeting_IdentifiedWorkItemsSection()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='14.0' position='left'"
	 * @generated
	 */
	WorkItemMeetingSection getIdentifiedWorkItemsSection();

	/**
	 * Sets the value of the '{@link org.unicase.model.meeting.Meeting#getIdentifiedWorkItemsSection <em>Identified Work Items Section</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identified Work Items Section</em>' reference.
	 * @see #getIdentifiedWorkItemsSection()
	 * @generated
	 */
	void setIdentifiedWorkItemsSection(WorkItemMeetingSection value);

} // Meeting
