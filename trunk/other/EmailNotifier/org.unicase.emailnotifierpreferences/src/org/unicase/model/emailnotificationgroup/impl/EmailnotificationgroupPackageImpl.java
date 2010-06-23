/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.emailnotificationgroup.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.unicase.model.emailnotificationgroup.AggregatedSettings;
import org.unicase.model.emailnotificationgroup.EmailnotificationgroupFactory;
import org.unicase.model.emailnotificationgroup.EmailnotificationgroupPackage;
import org.unicase.model.emailnotificationgroup.NotificationGroup;
import org.unicase.model.emailnotificationgroup.SendSettings;
import org.unicase.model.emailnotificationgroup.Weekdays;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EmailnotificationgroupPackageImpl extends EPackageImpl implements EmailnotificationgroupPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "<copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notificationGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sendSettingsEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum weekdaysEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum aggregatedSettingsEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.model.emailnotificationgroup.EmailnotificationgroupPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EmailnotificationgroupPackageImpl() {
		super(eNS_URI, EmailnotificationgroupFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link EmailnotificationgroupPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EmailnotificationgroupPackage init() {
		if (isInited)
			return (EmailnotificationgroupPackage) EPackage.Registry.INSTANCE
				.getEPackage(EmailnotificationgroupPackage.eNS_URI);

		// Obtain or create and register package
		EmailnotificationgroupPackageImpl theEmailnotificationgroupPackage = (EmailnotificationgroupPackageImpl) (EPackage.Registry.INSTANCE
			.get(eNS_URI) instanceof EmailnotificationgroupPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
			: new EmailnotificationgroupPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theEmailnotificationgroupPackage.createPackageContents();

		// Initialize created meta-data
		theEmailnotificationgroupPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEmailnotificationgroupPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EmailnotificationgroupPackage.eNS_URI, theEmailnotificationgroupPackage);
		return theEmailnotificationgroupPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotificationGroup() {
		return notificationGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNotificationGroup_NotificationGroupName() {
		return (EAttribute) notificationGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNotificationGroup_SendOption() {
		return (EAttribute) notificationGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNotificationGroup_AggregatedOption() {
		return (EAttribute) notificationGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNotificationGroup_DaysCount() {
		return (EAttribute) notificationGroupEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNotificationGroup_WeekdayOption() {
		return (EAttribute) notificationGroupEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNotificationGroup_Providers() {
		return (EAttribute) notificationGroupEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSendSettings() {
		return sendSettingsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWeekdays() {
		return weekdaysEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAggregatedSettings() {
		return aggregatedSettingsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmailnotificationgroupFactory getEmailnotificationgroupFactory() {
		return (EmailnotificationgroupFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		notificationGroupEClass = createEClass(NOTIFICATION_GROUP);
		createEAttribute(notificationGroupEClass, NOTIFICATION_GROUP__NOTIFICATION_GROUP_NAME);
		createEAttribute(notificationGroupEClass, NOTIFICATION_GROUP__SEND_OPTION);
		createEAttribute(notificationGroupEClass, NOTIFICATION_GROUP__AGGREGATED_OPTION);
		createEAttribute(notificationGroupEClass, NOTIFICATION_GROUP__DAYS_COUNT);
		createEAttribute(notificationGroupEClass, NOTIFICATION_GROUP__WEEKDAY_OPTION);
		createEAttribute(notificationGroupEClass, NOTIFICATION_GROUP__PROVIDERS);

		// Create enums
		sendSettingsEEnum = createEEnum(SEND_SETTINGS);
		weekdaysEEnum = createEEnum(WEEKDAYS);
		aggregatedSettingsEEnum = createEEnum(AGGREGATED_SETTINGS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(notificationGroupEClass, NotificationGroup.class, "NotificationGroup", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNotificationGroup_NotificationGroupName(), ecorePackage.getEString(),
			"NotificationGroupName", null, 0, 1, NotificationGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNotificationGroup_SendOption(), this.getSendSettings(), "SendOption", null, 0, 1,
			NotificationGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getNotificationGroup_AggregatedOption(), this.getAggregatedSettings(), "AggregatedOption", null,
			0, 1, NotificationGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
			IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNotificationGroup_DaysCount(), ecorePackage.getEInt(), "DaysCount", null, 0, 1,
			NotificationGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getNotificationGroup_WeekdayOption(), this.getWeekdays(), "WeekdayOption", null, 0, 1,
			NotificationGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getNotificationGroup_Providers(), ecorePackage.getEJavaObject(), "Providers", null, 0, -1,
			NotificationGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(sendSettingsEEnum, SendSettings.class, "SendSettings");
		addEEnumLiteral(sendSettingsEEnum, SendSettings.NONE);
		addEEnumLiteral(sendSettingsEEnum, SendSettings.IMMEDIATELY);
		addEEnumLiteral(sendSettingsEEnum, SendSettings.AGGREGATED);

		initEEnum(weekdaysEEnum, Weekdays.class, "Weekdays");
		addEEnumLiteral(weekdaysEEnum, Weekdays.NONE);
		addEEnumLiteral(weekdaysEEnum, Weekdays.MONDAY);
		addEEnumLiteral(weekdaysEEnum, Weekdays.TUESDAY);
		addEEnumLiteral(weekdaysEEnum, Weekdays.WEDNESDAY);
		addEEnumLiteral(weekdaysEEnum, Weekdays.THURSDAY);
		addEEnumLiteral(weekdaysEEnum, Weekdays.FRIDAY);
		addEEnumLiteral(weekdaysEEnum, Weekdays.SATURDAY);
		addEEnumLiteral(weekdaysEEnum, Weekdays.SUNDAY);

		initEEnum(aggregatedSettingsEEnum, AggregatedSettings.class, "AggregatedSettings");
		addEEnumLiteral(aggregatedSettingsEEnum, AggregatedSettings.NONE);
		addEEnumLiteral(aggregatedSettingsEEnum, AggregatedSettings.DAYS);
		addEEnumLiteral(aggregatedSettingsEEnum, AggregatedSettings.WEEKDAY);

		// Create resource
		createResource(eNS_URI);
	}

} //EmailnotificationgroupPackageImpl
