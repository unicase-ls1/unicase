/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 *
 * $Id$
 */
package org.unicase.model.emailbundle.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.unicase.model.ModelPackage;

import org.unicase.model.emailbundle.Bundle;
import org.unicase.model.emailbundle.EmailbundleFactory;
import org.unicase.model.emailbundle.EmailbundlePackage;
import org.unicase.model.emailbundle.SendSettings;
import org.unicase.model.emailbundle.Weekdays;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EmailbundlePackageImpl extends EPackageImpl implements EmailbundlePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "<copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the\naccompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this\ndistribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>\n";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bundleEClass = null;

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
	 * @see org.unicase.model.emailbundle.EmailbundlePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EmailbundlePackageImpl() {
		super(eNS_URI, EmailbundleFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EmailbundlePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EmailbundlePackage init() {
		if (isInited) return (EmailbundlePackage)EPackage.Registry.INSTANCE.getEPackage(EmailbundlePackage.eNS_URI);

		// Obtain or create and register package
		EmailbundlePackageImpl theEmailbundlePackage = (EmailbundlePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EmailbundlePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EmailbundlePackageImpl());

		isInited = true;

		// Create package meta-data objects
		theEmailbundlePackage.createPackageContents();

		// Initialize created meta-data
		theEmailbundlePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEmailbundlePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EmailbundlePackage.eNS_URI, theEmailbundlePackage);
		return theEmailbundlePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBundle() {
		return bundleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBundle_BundleName() {
		return (EAttribute)bundleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBundle_SendOption() {
		return (EAttribute)bundleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBundle_Days() {
		return (EAttribute)bundleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBundle_DaysCount() {
		return (EAttribute)bundleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBundle_Weekday() {
		return (EAttribute)bundleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBundle_WeekdayOption() {
		return (EAttribute)bundleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBundle_Providers() {
		return (EAttribute)bundleEClass.getEStructuralFeatures().get(6);
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
	public EmailbundleFactory getEmailbundleFactory() {
		return (EmailbundleFactory)getEFactoryInstance();
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
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		bundleEClass = createEClass(BUNDLE);
		createEAttribute(bundleEClass, BUNDLE__BUNDLE_NAME);
		createEAttribute(bundleEClass, BUNDLE__SEND_OPTION);
		createEAttribute(bundleEClass, BUNDLE__DAYS);
		createEAttribute(bundleEClass, BUNDLE__DAYS_COUNT);
		createEAttribute(bundleEClass, BUNDLE__WEEKDAY);
		createEAttribute(bundleEClass, BUNDLE__WEEKDAY_OPTION);
		createEAttribute(bundleEClass, BUNDLE__PROVIDERS);

		// Create enums
		sendSettingsEEnum = createEEnum(SEND_SETTINGS);
		weekdaysEEnum = createEEnum(WEEKDAYS);
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
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(bundleEClass, Bundle.class, "Bundle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBundle_BundleName(), ecorePackage.getEString(), "BundleName", null, 0, 1, Bundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBundle_SendOption(), this.getSendSettings(), "SendOption", null, 0, 1, Bundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBundle_Days(), ecorePackage.getEBoolean(), "Days", null, 0, 1, Bundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBundle_DaysCount(), ecorePackage.getEInt(), "DaysCount", null, 0, 1, Bundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBundle_Weekday(), ecorePackage.getEBoolean(), "Weekday", null, 0, 1, Bundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBundle_WeekdayOption(), this.getWeekdays(), "WeekdayOption", null, 0, 1, Bundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBundle_Providers(), ecorePackage.getEJavaObject(), "Providers", null, 0, -1, Bundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		// Create resource
		createResource(eNS_URI);
	}

} //EmailbundlePackageImpl
