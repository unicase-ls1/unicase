/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.unicase.model.emailnotificationgroup;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Notification Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.emailnotificationgroup.NotificationGroup#getNotificationGroupName <em>Notification Group Name</em>}</li>
 *   <li>{@link org.unicase.model.emailnotificationgroup.NotificationGroup#getSendOption <em>Send Option</em>}</li>
 *   <li>{@link org.unicase.model.emailnotificationgroup.NotificationGroup#getAggregatedOption <em>Aggregated Option</em>}</li>
 *   <li>{@link org.unicase.model.emailnotificationgroup.NotificationGroup#getDaysCount <em>Days Count</em>}</li>
 *   <li>{@link org.unicase.model.emailnotificationgroup.NotificationGroup#getWeekdayOption <em>Weekday Option</em>}</li>
 *   <li>{@link org.unicase.model.emailnotificationgroup.NotificationGroup#getProviders <em>Providers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.emailnotificationgroup.EmailnotificationgroupPackage#getNotificationGroup()
 * @model
 * @generated
 */
public interface NotificationGroup extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "<copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>";

	/**
	 * Returns the value of the '<em><b>Notification Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notification Group Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notification Group Name</em>' attribute.
	 * @see #setNotificationGroupName(String)
	 * @see org.unicase.model.emailnotificationgroup.EmailnotificationgroupPackage#getNotificationGroup_NotificationGroupName()
	 * @model
	 * @generated
	 */
	String getNotificationGroupName();

	/**
	 * Sets the value of the '{@link org.unicase.model.emailnotificationgroup.NotificationGroup#getNotificationGroupName <em>Notification Group Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Notification Group Name</em>' attribute.
	 * @see #getNotificationGroupName()
	 * @generated
	 */
	void setNotificationGroupName(String value);

	/**
	 * Returns the value of the '<em><b>Send Option</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.model.emailnotificationgroup.SendSettings}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Send Option</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Send Option</em>' attribute.
	 * @see org.unicase.model.emailnotificationgroup.SendSettings
	 * @see #setSendOption(SendSettings)
	 * @see org.unicase.model.emailnotificationgroup.EmailnotificationgroupPackage#getNotificationGroup_SendOption()
	 * @model
	 * @generated
	 */
	SendSettings getSendOption();

	/**
	 * Sets the value of the '{@link org.unicase.model.emailnotificationgroup.NotificationGroup#getSendOption <em>Send Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Send Option</em>' attribute.
	 * @see org.unicase.model.emailnotificationgroup.SendSettings
	 * @see #getSendOption()
	 * @generated
	 */
	void setSendOption(SendSettings value);

	/**
	 * Returns the value of the '<em><b>Aggregated Option</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.model.emailnotificationgroup.AggregatedSettings}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregated Option</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregated Option</em>' attribute.
	 * @see org.unicase.model.emailnotificationgroup.AggregatedSettings
	 * @see #setAggregatedOption(AggregatedSettings)
	 * @see org.unicase.model.emailnotificationgroup.EmailnotificationgroupPackage#getNotificationGroup_AggregatedOption()
	 * @model
	 * @generated
	 */
	AggregatedSettings getAggregatedOption();

	/**
	 * Sets the value of the '{@link org.unicase.model.emailnotificationgroup.NotificationGroup#getAggregatedOption <em>Aggregated Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregated Option</em>' attribute.
	 * @see org.unicase.model.emailnotificationgroup.AggregatedSettings
	 * @see #getAggregatedOption()
	 * @generated
	 */
	void setAggregatedOption(AggregatedSettings value);

	/**
	 * Returns the value of the '<em><b>Days Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Days Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Days Count</em>' attribute.
	 * @see #setDaysCount(int)
	 * @see org.unicase.model.emailnotificationgroup.EmailnotificationgroupPackage#getNotificationGroup_DaysCount()
	 * @model
	 * @generated
	 */
	int getDaysCount();

	/**
	 * Sets the value of the '{@link org.unicase.model.emailnotificationgroup.NotificationGroup#getDaysCount <em>Days Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Days Count</em>' attribute.
	 * @see #getDaysCount()
	 * @generated
	 */
	void setDaysCount(int value);

	/**
	 * Returns the value of the '<em><b>Weekday Option</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.model.emailnotificationgroup.Weekdays}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weekday Option</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weekday Option</em>' attribute.
	 * @see org.unicase.model.emailnotificationgroup.Weekdays
	 * @see #setWeekdayOption(Weekdays)
	 * @see org.unicase.model.emailnotificationgroup.EmailnotificationgroupPackage#getNotificationGroup_WeekdayOption()
	 * @model
	 * @generated
	 */
	Weekdays getWeekdayOption();

	/**
	 * Sets the value of the '{@link org.unicase.model.emailnotificationgroup.NotificationGroup#getWeekdayOption <em>Weekday Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weekday Option</em>' attribute.
	 * @see org.unicase.model.emailnotificationgroup.Weekdays
	 * @see #getWeekdayOption()
	 * @generated
	 */
	void setWeekdayOption(Weekdays value);

	/**
	 * Returns the value of the '<em><b>Providers</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Providers</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Providers</em>' attribute list.
	 * @see org.unicase.model.emailnotificationgroup.EmailnotificationgroupPackage#getNotificationGroup_Providers()
	 * @model
	 * @generated
	 */
	EList<Object> getProviders();

} // NotificationGroup
