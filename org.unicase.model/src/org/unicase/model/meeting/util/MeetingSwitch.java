/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.meeting.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.meeting.*;
import org.unicase.model.meeting.CompositeMeetingSection;
import org.unicase.model.meeting.IssueMeetingSection;
import org.unicase.model.meeting.Meeting;
import org.unicase.model.meeting.MeetingPackage;
import org.unicase.model.meeting.MeetingSection;
import org.unicase.model.meeting.WorkItemMeetingSection;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * @see org.unicase.model.meeting.MeetingPackage
 * @generated
 */
public class MeetingSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static MeetingPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MeetingSwitch() {
		if (modelPackage == null) {
			modelPackage = MeetingPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case MeetingPackage.MEETING: {
			Meeting meeting = (Meeting) theEObject;
			T result = caseMeeting(meeting);
			if (result == null)
				result = caseUnicaseModelElement(meeting);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MeetingPackage.MEETING_SECTION: {
			MeetingSection meetingSection = (MeetingSection) theEObject;
			T result = caseMeetingSection(meetingSection);
			if (result == null)
				result = caseUnicaseModelElement(meetingSection);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MeetingPackage.COMPOSITE_MEETING_SECTION: {
			CompositeMeetingSection compositeMeetingSection = (CompositeMeetingSection) theEObject;
			T result = caseCompositeMeetingSection(compositeMeetingSection);
			if (result == null)
				result = caseMeetingSection(compositeMeetingSection);
			if (result == null)
				result = caseUnicaseModelElement(compositeMeetingSection);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MeetingPackage.ISSUE_MEETING_SECTION: {
			IssueMeetingSection issueMeetingSection = (IssueMeetingSection) theEObject;
			T result = caseIssueMeetingSection(issueMeetingSection);
			if (result == null)
				result = caseMeetingSection(issueMeetingSection);
			if (result == null)
				result = caseUnicaseModelElement(issueMeetingSection);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MeetingPackage.WORK_ITEM_MEETING_SECTION: {
			WorkItemMeetingSection workItemMeetingSection = (WorkItemMeetingSection) theEObject;
			T result = caseWorkItemMeetingSection(workItemMeetingSection);
			if (result == null)
				result = caseMeetingSection(workItemMeetingSection);
			if (result == null)
				result = caseUnicaseModelElement(workItemMeetingSection);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Meeting</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Meeting</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeeting(Meeting object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Section</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeetingSection(MeetingSection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Meeting Section</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Meeting Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeMeetingSection(CompositeMeetingSection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Issue Meeting Section</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Issue Meeting Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIssueMeetingSection(IssueMeetingSection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Work Item Meeting Section</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Work Item Meeting Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWorkItemMeetingSection(WorkItemMeetingSection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unicase Model Element</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unicase Model Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnicaseModelElement(UnicaseModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch, but this is the last case
	 * anyway. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} // MeetingSwitch
