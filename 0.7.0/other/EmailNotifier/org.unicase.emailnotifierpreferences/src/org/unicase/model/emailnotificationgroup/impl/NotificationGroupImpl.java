/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.emailnotificationgroup.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.unicase.model.emailnotificationgroup.AggregatedSettings;
import org.unicase.model.emailnotificationgroup.EmailnotificationgroupPackage;
import org.unicase.model.emailnotificationgroup.NotificationGroup;
import org.unicase.model.emailnotificationgroup.SendSettings;
import org.unicase.model.emailnotificationgroup.Weekdays;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Notification Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.emailnotificationgroup.impl.NotificationGroupImpl#getNotificationGroupName <em>Notification Group Name</em>}</li>
 *   <li>{@link org.unicase.model.emailnotificationgroup.impl.NotificationGroupImpl#getSendOption <em>Send Option</em>}</li>
 *   <li>{@link org.unicase.model.emailnotificationgroup.impl.NotificationGroupImpl#getAggregatedOption <em>Aggregated Option</em>}</li>
 *   <li>{@link org.unicase.model.emailnotificationgroup.impl.NotificationGroupImpl#getDaysCount <em>Days Count</em>}</li>
 *   <li>{@link org.unicase.model.emailnotificationgroup.impl.NotificationGroupImpl#getWeekdayOption <em>Weekday Option</em>}</li>
 *   <li>{@link org.unicase.model.emailnotificationgroup.impl.NotificationGroupImpl#getProviders <em>Providers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NotificationGroupImpl extends EObjectImpl implements NotificationGroup {
	/**
	 * The default value of the '{@link #getNotificationGroupName() <em>Notification Group Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotificationGroupName()
	 * @generated
	 * @ordered
	 */
	protected static final String NOTIFICATION_GROUP_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNotificationGroupName() <em>Notification Group Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotificationGroupName()
	 * @generated
	 * @ordered
	 */
	protected String notificationGroupName = NOTIFICATION_GROUP_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSendOption() <em>Send Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSendOption()
	 * @generated
	 * @ordered
	 */
	protected static final SendSettings SEND_OPTION_EDEFAULT = SendSettings.NONE;

	/**
	 * The cached value of the '{@link #getSendOption() <em>Send Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSendOption()
	 * @generated
	 * @ordered
	 */
	protected SendSettings sendOption = SEND_OPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAggregatedOption() <em>Aggregated Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregatedOption()
	 * @generated
	 * @ordered
	 */
	protected static final AggregatedSettings AGGREGATED_OPTION_EDEFAULT = AggregatedSettings.NONE;

	/**
	 * The cached value of the '{@link #getAggregatedOption() <em>Aggregated Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregatedOption()
	 * @generated
	 * @ordered
	 */
	protected AggregatedSettings aggregatedOption = AGGREGATED_OPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDaysCount() <em>Days Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDaysCount()
	 * @generated
	 * @ordered
	 */
	protected static final int DAYS_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDaysCount() <em>Days Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDaysCount()
	 * @generated
	 * @ordered
	 */
	protected int daysCount = DAYS_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getWeekdayOption() <em>Weekday Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeekdayOption()
	 * @generated
	 * @ordered
	 */
	protected static final Weekdays WEEKDAY_OPTION_EDEFAULT = Weekdays.NONE;

	/**
	 * The cached value of the '{@link #getWeekdayOption() <em>Weekday Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeekdayOption()
	 * @generated
	 * @ordered
	 */
	protected Weekdays weekdayOption = WEEKDAY_OPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProviders() <em>Providers</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProviders()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> providers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotificationGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmailnotificationgroupPackage.Literals.NOTIFICATION_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNotificationGroupName() {
		return notificationGroupName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotificationGroupName(String newNotificationGroupName) {
		String oldNotificationGroupName = notificationGroupName;
		notificationGroupName = newNotificationGroupName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				EmailnotificationgroupPackage.NOTIFICATION_GROUP__NOTIFICATION_GROUP_NAME, oldNotificationGroupName,
				notificationGroupName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SendSettings getSendOption() {
		return sendOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSendOption(SendSettings newSendOption) {
		SendSettings oldSendOption = sendOption;
		sendOption = newSendOption == null ? SEND_OPTION_EDEFAULT : newSendOption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				EmailnotificationgroupPackage.NOTIFICATION_GROUP__SEND_OPTION, oldSendOption, sendOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregatedSettings getAggregatedOption() {
		return aggregatedOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAggregatedOption(AggregatedSettings newAggregatedOption) {
		AggregatedSettings oldAggregatedOption = aggregatedOption;
		aggregatedOption = newAggregatedOption == null ? AGGREGATED_OPTION_EDEFAULT : newAggregatedOption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				EmailnotificationgroupPackage.NOTIFICATION_GROUP__AGGREGATED_OPTION, oldAggregatedOption,
				aggregatedOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDaysCount() {
		return daysCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDaysCount(int newDaysCount) {
		int oldDaysCount = daysCount;
		daysCount = newDaysCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				EmailnotificationgroupPackage.NOTIFICATION_GROUP__DAYS_COUNT, oldDaysCount, daysCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Weekdays getWeekdayOption() {
		return weekdayOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWeekdayOption(Weekdays newWeekdayOption) {
		Weekdays oldWeekdayOption = weekdayOption;
		weekdayOption = newWeekdayOption == null ? WEEKDAY_OPTION_EDEFAULT : newWeekdayOption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				EmailnotificationgroupPackage.NOTIFICATION_GROUP__WEEKDAY_OPTION, oldWeekdayOption, weekdayOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getProviders() {
		if (providers == null) {
			providers = new EDataTypeUniqueEList<Object>(Object.class, this,
				EmailnotificationgroupPackage.NOTIFICATION_GROUP__PROVIDERS);
		}
		return providers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case EmailnotificationgroupPackage.NOTIFICATION_GROUP__NOTIFICATION_GROUP_NAME:
			return getNotificationGroupName();
		case EmailnotificationgroupPackage.NOTIFICATION_GROUP__SEND_OPTION:
			return getSendOption();
		case EmailnotificationgroupPackage.NOTIFICATION_GROUP__AGGREGATED_OPTION:
			return getAggregatedOption();
		case EmailnotificationgroupPackage.NOTIFICATION_GROUP__DAYS_COUNT:
			return getDaysCount();
		case EmailnotificationgroupPackage.NOTIFICATION_GROUP__WEEKDAY_OPTION:
			return getWeekdayOption();
		case EmailnotificationgroupPackage.NOTIFICATION_GROUP__PROVIDERS:
			return getProviders();
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
		case EmailnotificationgroupPackage.NOTIFICATION_GROUP__NOTIFICATION_GROUP_NAME:
			setNotificationGroupName((String) newValue);
			return;
		case EmailnotificationgroupPackage.NOTIFICATION_GROUP__SEND_OPTION:
			setSendOption((SendSettings) newValue);
			return;
		case EmailnotificationgroupPackage.NOTIFICATION_GROUP__AGGREGATED_OPTION:
			setAggregatedOption((AggregatedSettings) newValue);
			return;
		case EmailnotificationgroupPackage.NOTIFICATION_GROUP__DAYS_COUNT:
			setDaysCount((Integer) newValue);
			return;
		case EmailnotificationgroupPackage.NOTIFICATION_GROUP__WEEKDAY_OPTION:
			setWeekdayOption((Weekdays) newValue);
			return;
		case EmailnotificationgroupPackage.NOTIFICATION_GROUP__PROVIDERS:
			getProviders().clear();
			getProviders().addAll((Collection<? extends Object>) newValue);
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
		case EmailnotificationgroupPackage.NOTIFICATION_GROUP__NOTIFICATION_GROUP_NAME:
			setNotificationGroupName(NOTIFICATION_GROUP_NAME_EDEFAULT);
			return;
		case EmailnotificationgroupPackage.NOTIFICATION_GROUP__SEND_OPTION:
			setSendOption(SEND_OPTION_EDEFAULT);
			return;
		case EmailnotificationgroupPackage.NOTIFICATION_GROUP__AGGREGATED_OPTION:
			setAggregatedOption(AGGREGATED_OPTION_EDEFAULT);
			return;
		case EmailnotificationgroupPackage.NOTIFICATION_GROUP__DAYS_COUNT:
			setDaysCount(DAYS_COUNT_EDEFAULT);
			return;
		case EmailnotificationgroupPackage.NOTIFICATION_GROUP__WEEKDAY_OPTION:
			setWeekdayOption(WEEKDAY_OPTION_EDEFAULT);
			return;
		case EmailnotificationgroupPackage.NOTIFICATION_GROUP__PROVIDERS:
			getProviders().clear();
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
		case EmailnotificationgroupPackage.NOTIFICATION_GROUP__NOTIFICATION_GROUP_NAME:
			return NOTIFICATION_GROUP_NAME_EDEFAULT == null ? notificationGroupName != null
				: !NOTIFICATION_GROUP_NAME_EDEFAULT.equals(notificationGroupName);
		case EmailnotificationgroupPackage.NOTIFICATION_GROUP__SEND_OPTION:
			return sendOption != SEND_OPTION_EDEFAULT;
		case EmailnotificationgroupPackage.NOTIFICATION_GROUP__AGGREGATED_OPTION:
			return aggregatedOption != AGGREGATED_OPTION_EDEFAULT;
		case EmailnotificationgroupPackage.NOTIFICATION_GROUP__DAYS_COUNT:
			return daysCount != DAYS_COUNT_EDEFAULT;
		case EmailnotificationgroupPackage.NOTIFICATION_GROUP__WEEKDAY_OPTION:
			return weekdayOption != WEEKDAY_OPTION_EDEFAULT;
		case EmailnotificationgroupPackage.NOTIFICATION_GROUP__PROVIDERS:
			return providers != null && !providers.isEmpty();
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
		result.append(" (NotificationGroupName: ");
		result.append(notificationGroupName);
		result.append(", SendOption: ");
		result.append(sendOption);
		result.append(", AggregatedOption: ");
		result.append(aggregatedOption);
		result.append(", DaysCount: ");
		result.append(daysCount);
		result.append(", WeekdayOption: ");
		result.append(weekdayOption);
		result.append(", Providers: ");
		result.append(providers);
		result.append(')');
		return result.toString();
	}

} //NotificationGroupImpl
