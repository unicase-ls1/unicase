/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.simplemeeting.impl;

import java.util.Collection;
import java.util.Date;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.unicase.model.impl.UnicaseModelElementImpl;

import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.model.simplemeeting.SimpleMeeting;
import org.unicase.model.simplemeeting.SimplemeetingPackage;
import org.unicase.model.task.WorkItem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Meeting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.simplemeeting.impl.SimpleMeetingImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.unicase.model.simplemeeting.impl.SimpleMeetingImpl#getStarttime <em>Starttime</em>}</li>
 *   <li>{@link org.unicase.model.simplemeeting.impl.SimpleMeetingImpl#getEndtime <em>Endtime</em>}</li>
 *   <li>{@link org.unicase.model.simplemeeting.impl.SimpleMeetingImpl#getFacilitator <em>Facilitator</em>}</li>
 *   <li>{@link org.unicase.model.simplemeeting.impl.SimpleMeetingImpl#getMinutetaker <em>Minutetaker</em>}</li>
 *   <li>{@link org.unicase.model.simplemeeting.impl.SimpleMeetingImpl#getTimekeeper <em>Timekeeper</em>}</li>
 *   <li>{@link org.unicase.model.simplemeeting.impl.SimpleMeetingImpl#getParticipants <em>Participants</em>}</li>
 *   <li>{@link org.unicase.model.simplemeeting.impl.SimpleMeetingImpl#getStatusItems <em>Status Items</em>}</li>
 *   <li>{@link org.unicase.model.simplemeeting.impl.SimpleMeetingImpl#getDiscussionItems <em>Discussion Items</em>}</li>
 *   <li>{@link org.unicase.model.simplemeeting.impl.SimpleMeetingImpl#getIdentifiedItems <em>Identified Items</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleMeetingImpl extends UnicaseModelElementImpl implements SimpleMeeting {
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
	 * The default value of the '{@link #getStarttime() <em>Starttime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStarttime()
	 * @generated
	 * @ordered
	 */
	protected static final Date STARTTIME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getStarttime() <em>Starttime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStarttime()
	 * @generated
	 * @ordered
	 */
	protected Date starttime = STARTTIME_EDEFAULT;
	/**
	 * The default value of the '{@link #getEndtime() <em>Endtime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndtime()
	 * @generated
	 * @ordered
	 */
	protected static final Date ENDTIME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getEndtime() <em>Endtime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndtime()
	 * @generated
	 * @ordered
	 */
	protected Date endtime = ENDTIME_EDEFAULT;
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
	 * The cached value of the '{@link #getMinutetaker() <em>Minutetaker</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinutetaker()
	 * @generated
	 * @ordered
	 */
	protected User minutetaker;
	/**
	 * The cached value of the '{@link #getTimekeeper() <em>Timekeeper</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimekeeper()
	 * @generated
	 * @ordered
	 */
	protected User timekeeper;
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
	 * The cached value of the '{@link #getStatusItems() <em>Status Items</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatusItems()
	 * @generated
	 * @ordered
	 */
	protected EList<WorkItem> statusItems;

	/**
	 * The cached value of the '{@link #getDiscussionItems() <em>Discussion Items</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiscussionItems()
	 * @generated
	 * @ordered
	 */
	protected EList<WorkItem> discussionItems;
	/**
	 * The cached value of the '{@link #getIdentifiedItems() <em>Identified Items</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifiedItems()
	 * @generated
	 * @ordered
	 */
	protected EList<WorkItem> identifiedItems;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleMeetingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimplemeetingPackage.Literals.SIMPLE_MEETING;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SimplemeetingPackage.SIMPLE_MEETING__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getStarttime() {
		return starttime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStarttime(Date newStarttime) {
		Date oldStarttime = starttime;
		starttime = newStarttime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimplemeetingPackage.SIMPLE_MEETING__STARTTIME, oldStarttime, starttime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getEndtime() {
		return endtime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndtime(Date newEndtime) {
		Date oldEndtime = endtime;
		endtime = newEndtime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimplemeetingPackage.SIMPLE_MEETING__ENDTIME, oldEndtime, endtime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getFacilitator() {
		if (facilitator != null && facilitator.eIsProxy()) {
			InternalEObject oldFacilitator = (InternalEObject)facilitator;
			facilitator = (User)eResolveProxy(oldFacilitator);
			if (facilitator != oldFacilitator) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimplemeetingPackage.SIMPLE_MEETING__FACILITATOR, oldFacilitator, facilitator));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SimplemeetingPackage.SIMPLE_MEETING__FACILITATOR, oldFacilitator, facilitator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getMinutetaker() {
		if (minutetaker != null && minutetaker.eIsProxy()) {
			InternalEObject oldMinutetaker = (InternalEObject)minutetaker;
			minutetaker = (User)eResolveProxy(oldMinutetaker);
			if (minutetaker != oldMinutetaker) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimplemeetingPackage.SIMPLE_MEETING__MINUTETAKER, oldMinutetaker, minutetaker));
			}
		}
		return minutetaker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User basicGetMinutetaker() {
		return minutetaker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinutetaker(User newMinutetaker) {
		User oldMinutetaker = minutetaker;
		minutetaker = newMinutetaker;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimplemeetingPackage.SIMPLE_MEETING__MINUTETAKER, oldMinutetaker, minutetaker));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getTimekeeper() {
		if (timekeeper != null && timekeeper.eIsProxy()) {
			InternalEObject oldTimekeeper = (InternalEObject)timekeeper;
			timekeeper = (User)eResolveProxy(oldTimekeeper);
			if (timekeeper != oldTimekeeper) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimplemeetingPackage.SIMPLE_MEETING__TIMEKEEPER, oldTimekeeper, timekeeper));
			}
		}
		return timekeeper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User basicGetTimekeeper() {
		return timekeeper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimekeeper(User newTimekeeper) {
		User oldTimekeeper = timekeeper;
		timekeeper = newTimekeeper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimplemeetingPackage.SIMPLE_MEETING__TIMEKEEPER, oldTimekeeper, timekeeper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OrgUnit> getParticipants() {
		if (participants == null) {
			participants = new EObjectResolvingEList<OrgUnit>(OrgUnit.class, this, SimplemeetingPackage.SIMPLE_MEETING__PARTICIPANTS);
		}
		return participants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WorkItem> getStatusItems() {
		if (statusItems == null) {
			statusItems = new EObjectResolvingEList<WorkItem>(WorkItem.class, this, SimplemeetingPackage.SIMPLE_MEETING__STATUS_ITEMS);
		}
		return statusItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WorkItem> getDiscussionItems() {
		if (discussionItems == null) {
			discussionItems = new EObjectResolvingEList<WorkItem>(WorkItem.class, this, SimplemeetingPackage.SIMPLE_MEETING__DISCUSSION_ITEMS);
		}
		return discussionItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WorkItem> getIdentifiedItems() {
		if (identifiedItems == null) {
			identifiedItems = new EObjectResolvingEList<WorkItem>(WorkItem.class, this, SimplemeetingPackage.SIMPLE_MEETING__IDENTIFIED_ITEMS);
		}
		return identifiedItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimplemeetingPackage.SIMPLE_MEETING__LOCATION:
				return getLocation();
			case SimplemeetingPackage.SIMPLE_MEETING__STARTTIME:
				return getStarttime();
			case SimplemeetingPackage.SIMPLE_MEETING__ENDTIME:
				return getEndtime();
			case SimplemeetingPackage.SIMPLE_MEETING__FACILITATOR:
				if (resolve) return getFacilitator();
				return basicGetFacilitator();
			case SimplemeetingPackage.SIMPLE_MEETING__MINUTETAKER:
				if (resolve) return getMinutetaker();
				return basicGetMinutetaker();
			case SimplemeetingPackage.SIMPLE_MEETING__TIMEKEEPER:
				if (resolve) return getTimekeeper();
				return basicGetTimekeeper();
			case SimplemeetingPackage.SIMPLE_MEETING__PARTICIPANTS:
				return getParticipants();
			case SimplemeetingPackage.SIMPLE_MEETING__STATUS_ITEMS:
				return getStatusItems();
			case SimplemeetingPackage.SIMPLE_MEETING__DISCUSSION_ITEMS:
				return getDiscussionItems();
			case SimplemeetingPackage.SIMPLE_MEETING__IDENTIFIED_ITEMS:
				return getIdentifiedItems();
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
			case SimplemeetingPackage.SIMPLE_MEETING__LOCATION:
				setLocation((String)newValue);
				return;
			case SimplemeetingPackage.SIMPLE_MEETING__STARTTIME:
				setStarttime((Date)newValue);
				return;
			case SimplemeetingPackage.SIMPLE_MEETING__ENDTIME:
				setEndtime((Date)newValue);
				return;
			case SimplemeetingPackage.SIMPLE_MEETING__FACILITATOR:
				setFacilitator((User)newValue);
				return;
			case SimplemeetingPackage.SIMPLE_MEETING__MINUTETAKER:
				setMinutetaker((User)newValue);
				return;
			case SimplemeetingPackage.SIMPLE_MEETING__TIMEKEEPER:
				setTimekeeper((User)newValue);
				return;
			case SimplemeetingPackage.SIMPLE_MEETING__PARTICIPANTS:
				getParticipants().clear();
				getParticipants().addAll((Collection<? extends OrgUnit>)newValue);
				return;
			case SimplemeetingPackage.SIMPLE_MEETING__STATUS_ITEMS:
				getStatusItems().clear();
				getStatusItems().addAll((Collection<? extends WorkItem>)newValue);
				return;
			case SimplemeetingPackage.SIMPLE_MEETING__DISCUSSION_ITEMS:
				getDiscussionItems().clear();
				getDiscussionItems().addAll((Collection<? extends WorkItem>)newValue);
				return;
			case SimplemeetingPackage.SIMPLE_MEETING__IDENTIFIED_ITEMS:
				getIdentifiedItems().clear();
				getIdentifiedItems().addAll((Collection<? extends WorkItem>)newValue);
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
			case SimplemeetingPackage.SIMPLE_MEETING__LOCATION:
				setLocation(LOCATION_EDEFAULT);
				return;
			case SimplemeetingPackage.SIMPLE_MEETING__STARTTIME:
				setStarttime(STARTTIME_EDEFAULT);
				return;
			case SimplemeetingPackage.SIMPLE_MEETING__ENDTIME:
				setEndtime(ENDTIME_EDEFAULT);
				return;
			case SimplemeetingPackage.SIMPLE_MEETING__FACILITATOR:
				setFacilitator((User)null);
				return;
			case SimplemeetingPackage.SIMPLE_MEETING__MINUTETAKER:
				setMinutetaker((User)null);
				return;
			case SimplemeetingPackage.SIMPLE_MEETING__TIMEKEEPER:
				setTimekeeper((User)null);
				return;
			case SimplemeetingPackage.SIMPLE_MEETING__PARTICIPANTS:
				getParticipants().clear();
				return;
			case SimplemeetingPackage.SIMPLE_MEETING__STATUS_ITEMS:
				getStatusItems().clear();
				return;
			case SimplemeetingPackage.SIMPLE_MEETING__DISCUSSION_ITEMS:
				getDiscussionItems().clear();
				return;
			case SimplemeetingPackage.SIMPLE_MEETING__IDENTIFIED_ITEMS:
				getIdentifiedItems().clear();
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
			case SimplemeetingPackage.SIMPLE_MEETING__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
			case SimplemeetingPackage.SIMPLE_MEETING__STARTTIME:
				return STARTTIME_EDEFAULT == null ? starttime != null : !STARTTIME_EDEFAULT.equals(starttime);
			case SimplemeetingPackage.SIMPLE_MEETING__ENDTIME:
				return ENDTIME_EDEFAULT == null ? endtime != null : !ENDTIME_EDEFAULT.equals(endtime);
			case SimplemeetingPackage.SIMPLE_MEETING__FACILITATOR:
				return facilitator != null;
			case SimplemeetingPackage.SIMPLE_MEETING__MINUTETAKER:
				return minutetaker != null;
			case SimplemeetingPackage.SIMPLE_MEETING__TIMEKEEPER:
				return timekeeper != null;
			case SimplemeetingPackage.SIMPLE_MEETING__PARTICIPANTS:
				return participants != null && !participants.isEmpty();
			case SimplemeetingPackage.SIMPLE_MEETING__STATUS_ITEMS:
				return statusItems != null && !statusItems.isEmpty();
			case SimplemeetingPackage.SIMPLE_MEETING__DISCUSSION_ITEMS:
				return discussionItems != null && !discussionItems.isEmpty();
			case SimplemeetingPackage.SIMPLE_MEETING__IDENTIFIED_ITEMS:
				return identifiedItems != null && !identifiedItems.isEmpty();
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
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (location: ");
		result.append(location);
		result.append(", starttime: ");
		result.append(starttime);
		result.append(", endtime: ");
		result.append(endtime);
		result.append(')');
		return result.toString();
	}

} //SimpleMeetingImpl
