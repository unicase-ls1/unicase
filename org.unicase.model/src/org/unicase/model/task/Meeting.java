/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.model.task;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.ModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.model.rationale.Issue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meeting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.task.Meeting#getLocation <em>Location</em>}</li>
 *   <li>{@link org.unicase.model.task.Meeting#getTime <em>Time</em>}</li>
 *   <li>{@link org.unicase.model.task.Meeting#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link org.unicase.model.task.Meeting#getFacilitator <em>Facilitator</em>}</li>
 *   <li>{@link org.unicase.model.task.Meeting#getScribe <em>Scribe</em>}</li>
 *   <li>{@link org.unicase.model.task.Meeting#getParticipants <em>Participants</em>}</li>
 *   <li>{@link org.unicase.model.task.Meeting#getInformationExchange <em>Information Exchange</em>}</li>
 *   <li>{@link org.unicase.model.task.Meeting#getDiscussedActionItems <em>Discussed Action Items</em>}</li>
 *   <li>{@link org.unicase.model.task.Meeting#getDiscussedIssues <em>Discussed Issues</em>}</li>
 *   <li>{@link org.unicase.model.task.Meeting#getIdentifiedActionItems <em>Identified Action Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.task.TaskPackage#getMeeting()
 * @model
 * @generated
 */
public interface Meeting extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see org.unicase.model.task.TaskPackage#getMeeting_Location()
	 * @model
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link org.unicase.model.task.Meeting#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(Date)
	 * @see org.unicase.model.task.TaskPackage#getMeeting_Time()
	 * @model
	 * @generated
	 */
	Date getTime();

	/**
	 * Sets the value of the '{@link org.unicase.model.task.Meeting#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(Date value);

	/**
	 * Returns the value of the '<em><b>Purpose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Purpose</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Purpose</em>' attribute.
	 * @see #setPurpose(String)
	 * @see org.unicase.model.task.TaskPackage#getMeeting_Purpose()
	 * @model
	 * @generated
	 */
	String getPurpose();

	/**
	 * Sets the value of the '{@link org.unicase.model.task.Meeting#getPurpose <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Purpose</em>' attribute.
	 * @see #getPurpose()
	 * @generated
	 */
	void setPurpose(String value);

	/**
	 * Returns the value of the '<em><b>Facilitator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facilitator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facilitator</em>' reference.
	 * @see #setFacilitator(User)
	 * @see org.unicase.model.task.TaskPackage#getMeeting_Facilitator()
	 * @model keys="identifier"
	 * @generated
	 */
	User getFacilitator();

	/**
	 * Sets the value of the '{@link org.unicase.model.task.Meeting#getFacilitator <em>Facilitator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facilitator</em>' reference.
	 * @see #getFacilitator()
	 * @generated
	 */
	void setFacilitator(User value);

	/**
	 * Returns the value of the '<em><b>Scribe</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scribe</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scribe</em>' reference.
	 * @see #setScribe(User)
	 * @see org.unicase.model.task.TaskPackage#getMeeting_Scribe()
	 * @model keys="identifier"
	 * @generated
	 */
	User getScribe();

	/**
	 * Sets the value of the '{@link org.unicase.model.task.Meeting#getScribe <em>Scribe</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scribe</em>' reference.
	 * @see #getScribe()
	 * @generated
	 */
	void setScribe(User value);

	/**
	 * Returns the value of the '<em><b>Participants</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.organization.OrgUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participants</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participants</em>' reference list.
	 * @see org.unicase.model.task.TaskPackage#getMeeting_Participants()
	 * @model keys="identifier"
	 * @generated
	 */
	EList<OrgUnit> getParticipants();

	/**
	 * Returns the value of the '<em><b>Information Exchange</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Information Exchange</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Information Exchange</em>' attribute.
	 * @see #setInformationExchange(String)
	 * @see org.unicase.model.task.TaskPackage#getMeeting_InformationExchange()
	 * @model
	 * @generated
	 */
	String getInformationExchange();

	/**
	 * Sets the value of the '{@link org.unicase.model.task.Meeting#getInformationExchange <em>Information Exchange</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Information Exchange</em>' attribute.
	 * @see #getInformationExchange()
	 * @generated
	 */
	void setInformationExchange(String value);

	/**
	 * Returns the value of the '<em><b>Discussed Action Items</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.task.ActionItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Discussed Action Items</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Discussed Action Items</em>' reference list.
	 * @see org.unicase.model.task.TaskPackage#getMeeting_DiscussedActionItems()
	 * @model keys="identifier"
	 * @generated
	 */
	EList<ActionItem> getDiscussedActionItems();

	/**
	 * Returns the value of the '<em><b>Discussed Issues</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.rationale.Issue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Discussed Issues</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Discussed Issues</em>' reference list.
	 * @see org.unicase.model.task.TaskPackage#getMeeting_DiscussedIssues()
	 * @model keys="identifier"
	 * @generated
	 */
	EList<Issue> getDiscussedIssues();

	/**
	 * Returns the value of the '<em><b>Identified Action Items</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identified Action Items</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identified Action Items</em>' reference.
	 * @see #setIdentifiedActionItems(ActionItem)
	 * @see org.unicase.model.task.TaskPackage#getMeeting_IdentifiedActionItems()
	 * @model keys="identifier"
	 * @generated
	 */
	ActionItem getIdentifiedActionItems();

	/**
	 * Sets the value of the '{@link org.unicase.model.task.Meeting#getIdentifiedActionItems <em>Identified Action Items</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identified Action Items</em>' reference.
	 * @see #getIdentifiedActionItems()
	 * @generated
	 */
	void setIdentifiedActionItems(ActionItem value);

} // Meeting
