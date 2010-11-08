/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.emailnotificationgroup;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.model.emailnotificationgroup.EmailnotificationgroupFactory
 * @model kind="package"
 * @generated
 */
public interface EmailnotificationgroupPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "emailnotificationgroup";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/emailnotificationgroup";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.emailnotificationgroup";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EmailnotificationgroupPackage eINSTANCE = org.unicase.model.emailnotificationgroup.impl.EmailnotificationgroupPackageImpl
		.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.emailnotificationgroup.impl.NotificationGroupImpl <em>Notification Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.emailnotificationgroup.impl.NotificationGroupImpl
	 * @see org.unicase.model.emailnotificationgroup.impl.EmailnotificationgroupPackageImpl#getNotificationGroup()
	 * @generated
	 */
	int NOTIFICATION_GROUP = 0;

	/**
	 * The feature id for the '<em><b>Notification Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_GROUP__NOTIFICATION_GROUP_NAME = 0;

	/**
	 * The feature id for the '<em><b>Send Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_GROUP__SEND_OPTION = 1;

	/**
	 * The feature id for the '<em><b>Aggregated Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_GROUP__AGGREGATED_OPTION = 2;

	/**
	 * The feature id for the '<em><b>Days Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_GROUP__DAYS_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Weekday Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_GROUP__WEEKDAY_OPTION = 4;

	/**
	 * The feature id for the '<em><b>Providers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_GROUP__PROVIDERS = 5;

	/**
	 * The number of structural features of the '<em>Notification Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_GROUP_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.unicase.model.emailnotificationgroup.SendSettings <em>Send Settings</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.emailnotificationgroup.SendSettings
	 * @see org.unicase.model.emailnotificationgroup.impl.EmailnotificationgroupPackageImpl#getSendSettings()
	 * @generated
	 */
	int SEND_SETTINGS = 1;

	/**
	 * The meta object id for the '{@link org.unicase.model.emailnotificationgroup.Weekdays <em>Weekdays</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.emailnotificationgroup.Weekdays
	 * @see org.unicase.model.emailnotificationgroup.impl.EmailnotificationgroupPackageImpl#getWeekdays()
	 * @generated
	 */
	int WEEKDAYS = 2;

	/**
	 * The meta object id for the '{@link org.unicase.model.emailnotificationgroup.AggregatedSettings <em>Aggregated Settings</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.emailnotificationgroup.AggregatedSettings
	 * @see org.unicase.model.emailnotificationgroup.impl.EmailnotificationgroupPackageImpl#getAggregatedSettings()
	 * @generated
	 */
	int AGGREGATED_SETTINGS = 3;

	/**
	 * Returns the meta object for class '{@link org.unicase.model.emailnotificationgroup.NotificationGroup <em>Notification Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Notification Group</em>'.
	 * @see org.unicase.model.emailnotificationgroup.NotificationGroup
	 * @generated
	 */
	EClass getNotificationGroup();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.emailnotificationgroup.NotificationGroup#getNotificationGroupName <em>Notification Group Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Notification Group Name</em>'.
	 * @see org.unicase.model.emailnotificationgroup.NotificationGroup#getNotificationGroupName()
	 * @see #getNotificationGroup()
	 * @generated
	 */
	EAttribute getNotificationGroup_NotificationGroupName();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.emailnotificationgroup.NotificationGroup#getSendOption <em>Send Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Send Option</em>'.
	 * @see org.unicase.model.emailnotificationgroup.NotificationGroup#getSendOption()
	 * @see #getNotificationGroup()
	 * @generated
	 */
	EAttribute getNotificationGroup_SendOption();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.emailnotificationgroup.NotificationGroup#getAggregatedOption <em>Aggregated Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Aggregated Option</em>'.
	 * @see org.unicase.model.emailnotificationgroup.NotificationGroup#getAggregatedOption()
	 * @see #getNotificationGroup()
	 * @generated
	 */
	EAttribute getNotificationGroup_AggregatedOption();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.emailnotificationgroup.NotificationGroup#getDaysCount <em>Days Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Days Count</em>'.
	 * @see org.unicase.model.emailnotificationgroup.NotificationGroup#getDaysCount()
	 * @see #getNotificationGroup()
	 * @generated
	 */
	EAttribute getNotificationGroup_DaysCount();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.emailnotificationgroup.NotificationGroup#getWeekdayOption <em>Weekday Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weekday Option</em>'.
	 * @see org.unicase.model.emailnotificationgroup.NotificationGroup#getWeekdayOption()
	 * @see #getNotificationGroup()
	 * @generated
	 */
	EAttribute getNotificationGroup_WeekdayOption();

	/**
	 * Returns the meta object for the attribute list '{@link org.unicase.model.emailnotificationgroup.NotificationGroup#getProviders <em>Providers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Providers</em>'.
	 * @see org.unicase.model.emailnotificationgroup.NotificationGroup#getProviders()
	 * @see #getNotificationGroup()
	 * @generated
	 */
	EAttribute getNotificationGroup_Providers();

	/**
	 * Returns the meta object for enum '{@link org.unicase.model.emailnotificationgroup.SendSettings <em>Send Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Send Settings</em>'.
	 * @see org.unicase.model.emailnotificationgroup.SendSettings
	 * @generated
	 */
	EEnum getSendSettings();

	/**
	 * Returns the meta object for enum '{@link org.unicase.model.emailnotificationgroup.Weekdays <em>Weekdays</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Weekdays</em>'.
	 * @see org.unicase.model.emailnotificationgroup.Weekdays
	 * @generated
	 */
	EEnum getWeekdays();

	/**
	 * Returns the meta object for enum '{@link org.unicase.model.emailnotificationgroup.AggregatedSettings <em>Aggregated Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Aggregated Settings</em>'.
	 * @see org.unicase.model.emailnotificationgroup.AggregatedSettings
	 * @generated
	 */
	EEnum getAggregatedSettings();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EmailnotificationgroupFactory getEmailnotificationgroupFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.model.emailnotificationgroup.impl.NotificationGroupImpl <em>Notification Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.emailnotificationgroup.impl.NotificationGroupImpl
		 * @see org.unicase.model.emailnotificationgroup.impl.EmailnotificationgroupPackageImpl#getNotificationGroup()
		 * @generated
		 */
		EClass NOTIFICATION_GROUP = eINSTANCE.getNotificationGroup();

		/**
		 * The meta object literal for the '<em><b>Notification Group Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION_GROUP__NOTIFICATION_GROUP_NAME = eINSTANCE.getNotificationGroup_NotificationGroupName();

		/**
		 * The meta object literal for the '<em><b>Send Option</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION_GROUP__SEND_OPTION = eINSTANCE.getNotificationGroup_SendOption();

		/**
		 * The meta object literal for the '<em><b>Aggregated Option</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION_GROUP__AGGREGATED_OPTION = eINSTANCE.getNotificationGroup_AggregatedOption();

		/**
		 * The meta object literal for the '<em><b>Days Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION_GROUP__DAYS_COUNT = eINSTANCE.getNotificationGroup_DaysCount();

		/**
		 * The meta object literal for the '<em><b>Weekday Option</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION_GROUP__WEEKDAY_OPTION = eINSTANCE.getNotificationGroup_WeekdayOption();

		/**
		 * The meta object literal for the '<em><b>Providers</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION_GROUP__PROVIDERS = eINSTANCE.getNotificationGroup_Providers();

		/**
		 * The meta object literal for the '{@link org.unicase.model.emailnotificationgroup.SendSettings <em>Send Settings</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.emailnotificationgroup.SendSettings
		 * @see org.unicase.model.emailnotificationgroup.impl.EmailnotificationgroupPackageImpl#getSendSettings()
		 * @generated
		 */
		EEnum SEND_SETTINGS = eINSTANCE.getSendSettings();

		/**
		 * The meta object literal for the '{@link org.unicase.model.emailnotificationgroup.Weekdays <em>Weekdays</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.emailnotificationgroup.Weekdays
		 * @see org.unicase.model.emailnotificationgroup.impl.EmailnotificationgroupPackageImpl#getWeekdays()
		 * @generated
		 */
		EEnum WEEKDAYS = eINSTANCE.getWeekdays();

		/**
		 * The meta object literal for the '{@link org.unicase.model.emailnotificationgroup.AggregatedSettings <em>Aggregated Settings</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.emailnotificationgroup.AggregatedSettings
		 * @see org.unicase.model.emailnotificationgroup.impl.EmailnotificationgroupPackageImpl#getAggregatedSettings()
		 * @generated
		 */
		EEnum AGGREGATED_SETTINGS = eINSTANCE.getAggregatedSettings();

	}

} //EmailnotificationgroupPackage
