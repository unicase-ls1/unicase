/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.task.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.unicase.model.impl.ModelElementImpl;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.model.rationale.Issue;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.Meeting;
import org.unicase.model.task.TaskPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Meeting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.task.impl.MeetingImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.MeetingImpl#getTime <em>Time</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.MeetingImpl#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.MeetingImpl#getFacilitator <em>Facilitator</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.MeetingImpl#getScribe <em>Scribe</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.MeetingImpl#getParticipants <em>Participants</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.MeetingImpl#getInformationExchange <em>Information Exchange</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.MeetingImpl#getDiscussedActionItems <em>Discussed Action Items</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.MeetingImpl#getDiscussedIssues <em>Discussed Issues</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.MeetingImpl#getIdentifiedActionItems <em>Identified Action Items</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MeetingImpl extends ModelElementImpl implements Meeting {
	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected String location = LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected static final Date TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected Date time = TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPurpose() <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPurpose()
	 * @generated
	 * @ordered
	 */
	protected static final String PURPOSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPurpose() <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPurpose()
	 * @generated
	 * @ordered
	 */
	protected String purpose = PURPOSE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFacilitator() <em>Facilitator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacilitator()
	 * @generated
	 * @ordered
	 */
	protected User facilitator;

	/**
	 * The cached value of the '{@link #getScribe() <em>Scribe</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScribe()
	 * @generated
	 * @ordered
	 */
	protected User scribe;

	/**
	 * The cached value of the '{@link #getParticipants() <em>Participants</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipants()
	 * @generated
	 * @ordered
	 */
	protected EList<OrgUnit> participants;

	/**
	 * The default value of the '{@link #getInformationExchange() <em>Information Exchange</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInformationExchange()
	 * @generated
	 * @ordered
	 */
	protected static final String INFORMATION_EXCHANGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInformationExchange() <em>Information Exchange</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInformationExchange()
	 * @generated
	 * @ordered
	 */
	protected String informationExchange = INFORMATION_EXCHANGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDiscussedActionItems() <em>Discussed Action Items</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiscussedActionItems()
	 * @generated
	 * @ordered
	 */
	protected EList<ActionItem> discussedActionItems;

	/**
	 * The cached value of the '{@link #getDiscussedIssues() <em>Discussed Issues</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiscussedIssues()
	 * @generated
	 * @ordered
	 */
	protected EList<Issue> discussedIssues;

	/**
	 * The cached value of the '{@link #getIdentifiedActionItems() <em>Identified Action Items</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifiedActionItems()
	 * @generated
	 * @ordered
	 */
	protected ActionItem identifiedActionItems;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MeetingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TaskPackage.Literals.MEETING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(String newLocation) {
		String oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					TaskPackage.MEETING__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTime(Date newTime) {
		Date oldTime = time;
		time = newTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					TaskPackage.MEETING__TIME, oldTime, time));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPurpose() {
		return purpose;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPurpose(String newPurpose) {
		String oldPurpose = purpose;
		purpose = newPurpose;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					TaskPackage.MEETING__PURPOSE, oldPurpose, purpose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getFacilitator() {
		if (facilitator != null && facilitator.eIsProxy()) {
			InternalEObject oldFacilitator = (InternalEObject) facilitator;
			facilitator = (User) eResolveProxy(oldFacilitator);
			if (facilitator != oldFacilitator) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							TaskPackage.MEETING__FACILITATOR, oldFacilitator,
							facilitator));
			}
		}
		return facilitator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User basicGetFacilitator() {
		return facilitator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFacilitator(User newFacilitator) {
		User oldFacilitator = facilitator;
		facilitator = newFacilitator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					TaskPackage.MEETING__FACILITATOR, oldFacilitator,
					facilitator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getScribe() {
		if (scribe != null && scribe.eIsProxy()) {
			InternalEObject oldScribe = (InternalEObject) scribe;
			scribe = (User) eResolveProxy(oldScribe);
			if (scribe != oldScribe) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							TaskPackage.MEETING__SCRIBE, oldScribe, scribe));
			}
		}
		return scribe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User basicGetScribe() {
		return scribe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScribe(User newScribe) {
		User oldScribe = scribe;
		scribe = newScribe;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					TaskPackage.MEETING__SCRIBE, oldScribe, scribe));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OrgUnit> getParticipants() {
		if (participants == null) {
			participants = new EObjectResolvingEList<OrgUnit>(OrgUnit.class,
					this, TaskPackage.MEETING__PARTICIPANTS);
		}
		return participants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInformationExchange() {
		return informationExchange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInformationExchange(String newInformationExchange) {
		String oldInformationExchange = informationExchange;
		informationExchange = newInformationExchange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					TaskPackage.MEETING__INFORMATION_EXCHANGE,
					oldInformationExchange, informationExchange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActionItem> getDiscussedActionItems() {
		if (discussedActionItems == null) {
			discussedActionItems = new EObjectResolvingEList<ActionItem>(
					ActionItem.class, this,
					TaskPackage.MEETING__DISCUSSED_ACTION_ITEMS);
		}
		return discussedActionItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Issue> getDiscussedIssues() {
		if (discussedIssues == null) {
			discussedIssues = new EObjectResolvingEList<Issue>(Issue.class,
					this, TaskPackage.MEETING__DISCUSSED_ISSUES);
		}
		return discussedIssues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionItem getIdentifiedActionItems() {
		if (identifiedActionItems != null && identifiedActionItems.eIsProxy()) {
			InternalEObject oldIdentifiedActionItems = (InternalEObject) identifiedActionItems;
			identifiedActionItems = (ActionItem) eResolveProxy(oldIdentifiedActionItems);
			if (identifiedActionItems != oldIdentifiedActionItems) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							TaskPackage.MEETING__IDENTIFIED_ACTION_ITEMS,
							oldIdentifiedActionItems, identifiedActionItems));
			}
		}
		return identifiedActionItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionItem basicGetIdentifiedActionItems() {
		return identifiedActionItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifiedActionItems(ActionItem newIdentifiedActionItems) {
		ActionItem oldIdentifiedActionItems = identifiedActionItems;
		identifiedActionItems = newIdentifiedActionItems;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					TaskPackage.MEETING__IDENTIFIED_ACTION_ITEMS,
					oldIdentifiedActionItems, identifiedActionItems));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case TaskPackage.MEETING__LOCATION:
			return getLocation();
		case TaskPackage.MEETING__TIME:
			return getTime();
		case TaskPackage.MEETING__PURPOSE:
			return getPurpose();
		case TaskPackage.MEETING__FACILITATOR:
			if (resolve)
				return getFacilitator();
			return basicGetFacilitator();
		case TaskPackage.MEETING__SCRIBE:
			if (resolve)
				return getScribe();
			return basicGetScribe();
		case TaskPackage.MEETING__PARTICIPANTS:
			return getParticipants();
		case TaskPackage.MEETING__INFORMATION_EXCHANGE:
			return getInformationExchange();
		case TaskPackage.MEETING__DISCUSSED_ACTION_ITEMS:
			return getDiscussedActionItems();
		case TaskPackage.MEETING__DISCUSSED_ISSUES:
			return getDiscussedIssues();
		case TaskPackage.MEETING__IDENTIFIED_ACTION_ITEMS:
			if (resolve)
				return getIdentifiedActionItems();
			return basicGetIdentifiedActionItems();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case TaskPackage.MEETING__LOCATION:
			setLocation((String) newValue);
			return;
		case TaskPackage.MEETING__TIME:
			setTime((Date) newValue);
			return;
		case TaskPackage.MEETING__PURPOSE:
			setPurpose((String) newValue);
			return;
		case TaskPackage.MEETING__FACILITATOR:
			setFacilitator((User) newValue);
			return;
		case TaskPackage.MEETING__SCRIBE:
			setScribe((User) newValue);
			return;
		case TaskPackage.MEETING__PARTICIPANTS:
			getParticipants().clear();
			getParticipants().addAll((Collection<? extends OrgUnit>) newValue);
			return;
		case TaskPackage.MEETING__INFORMATION_EXCHANGE:
			setInformationExchange((String) newValue);
			return;
		case TaskPackage.MEETING__DISCUSSED_ACTION_ITEMS:
			getDiscussedActionItems().clear();
			getDiscussedActionItems().addAll(
					(Collection<? extends ActionItem>) newValue);
			return;
		case TaskPackage.MEETING__DISCUSSED_ISSUES:
			getDiscussedIssues().clear();
			getDiscussedIssues().addAll((Collection<? extends Issue>) newValue);
			return;
		case TaskPackage.MEETING__IDENTIFIED_ACTION_ITEMS:
			setIdentifiedActionItems((ActionItem) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case TaskPackage.MEETING__LOCATION:
			setLocation(LOCATION_EDEFAULT);
			return;
		case TaskPackage.MEETING__TIME:
			setTime(TIME_EDEFAULT);
			return;
		case TaskPackage.MEETING__PURPOSE:
			setPurpose(PURPOSE_EDEFAULT);
			return;
		case TaskPackage.MEETING__FACILITATOR:
			setFacilitator((User) null);
			return;
		case TaskPackage.MEETING__SCRIBE:
			setScribe((User) null);
			return;
		case TaskPackage.MEETING__PARTICIPANTS:
			getParticipants().clear();
			return;
		case TaskPackage.MEETING__INFORMATION_EXCHANGE:
			setInformationExchange(INFORMATION_EXCHANGE_EDEFAULT);
			return;
		case TaskPackage.MEETING__DISCUSSED_ACTION_ITEMS:
			getDiscussedActionItems().clear();
			return;
		case TaskPackage.MEETING__DISCUSSED_ISSUES:
			getDiscussedIssues().clear();
			return;
		case TaskPackage.MEETING__IDENTIFIED_ACTION_ITEMS:
			setIdentifiedActionItems((ActionItem) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case TaskPackage.MEETING__LOCATION:
			return LOCATION_EDEFAULT == null ? location != null
					: !LOCATION_EDEFAULT.equals(location);
		case TaskPackage.MEETING__TIME:
			return TIME_EDEFAULT == null ? time != null : !TIME_EDEFAULT
					.equals(time);
		case TaskPackage.MEETING__PURPOSE:
			return PURPOSE_EDEFAULT == null ? purpose != null
					: !PURPOSE_EDEFAULT.equals(purpose);
		case TaskPackage.MEETING__FACILITATOR:
			return facilitator != null;
		case TaskPackage.MEETING__SCRIBE:
			return scribe != null;
		case TaskPackage.MEETING__PARTICIPANTS:
			return participants != null && !participants.isEmpty();
		case TaskPackage.MEETING__INFORMATION_EXCHANGE:
			return INFORMATION_EXCHANGE_EDEFAULT == null ? informationExchange != null
					: !INFORMATION_EXCHANGE_EDEFAULT
							.equals(informationExchange);
		case TaskPackage.MEETING__DISCUSSED_ACTION_ITEMS:
			return discussedActionItems != null
					&& !discussedActionItems.isEmpty();
		case TaskPackage.MEETING__DISCUSSED_ISSUES:
			return discussedIssues != null && !discussedIssues.isEmpty();
		case TaskPackage.MEETING__IDENTIFIED_ACTION_ITEMS:
			return identifiedActionItems != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (location: ");
		result.append(location);
		result.append(", time: ");
		result.append(time);
		result.append(", purpose: ");
		result.append(purpose);
		result.append(", informationExchange: ");
		result.append(informationExchange);
		result.append(')');
		return result.toString();
	}

} //MeetingImpl
