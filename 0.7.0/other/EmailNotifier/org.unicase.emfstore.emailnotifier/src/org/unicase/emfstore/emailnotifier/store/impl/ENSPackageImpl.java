/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.emailnotifier.store.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.unicase.emfstore.emailnotifier.store.EMailNotifierStore;
import org.unicase.emfstore.emailnotifier.store.ENSFactory;
import org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup;
import org.unicase.emfstore.emailnotifier.store.ENSNotificationProject;
import org.unicase.emfstore.emailnotifier.store.ENSPackage;
import org.unicase.emfstore.emailnotifier.store.ENSUser;
import org.unicase.emfstore.emailnotifier.store.SendOption;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ENSPackageImpl extends EPackageImpl implements ENSPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eMailNotifierStoreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ensNotificationProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ensUserEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ensNotificationGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sendOptionEEnum = null;

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
	 * @see org.unicase.emfstore.emailnotifier.store.ENSPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ENSPackageImpl() {
		super(eNS_URI, ENSFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ENSPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ENSPackage init() {
		if (isInited) return (ENSPackage)EPackage.Registry.INSTANCE.getEPackage(ENSPackage.eNS_URI);

		// Obtain or create and register package
		ENSPackageImpl theENSPackage = (ENSPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ENSPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ENSPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theENSPackage.createPackageContents();

		// Initialize created meta-data
		theENSPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theENSPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ENSPackage.eNS_URI, theENSPackage);
		return theENSPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEMailNotifierStore() {
		return eMailNotifierStoreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEMailNotifierStore_Projects() {
		return (EReference)eMailNotifierStoreEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getENSNotificationProject() {
		return ensNotificationProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getENSNotificationProject_Id() {
		return (EAttribute)ensNotificationProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getENSNotificationProject_LatestVersion() {
		return (EAttribute)ensNotificationProjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getENSNotificationProject_Users() {
		return (EReference)ensNotificationProjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getENSUser() {
		return ensUserEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getENSUser_UserName() {
		return (EAttribute)ensUserEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getENSUser_UserEMail() {
		return (EAttribute)ensUserEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getENSUser_Groups() {
		return (EReference)ensUserEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getENSNotificationGroup() {
		return ensNotificationGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getENSNotificationGroup_Name() {
		return (EAttribute)ensNotificationGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getENSNotificationGroup_SendOption() {
		return (EAttribute)ensNotificationGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getENSNotificationGroup_BaseVersion() {
		return (EAttribute)ensNotificationGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getENSNotificationGroup_NextSendingDate() {
		return (EAttribute)ensNotificationGroupEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSendOption() {
		return sendOptionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ENSFactory getENSFactory() {
		return (ENSFactory)getEFactoryInstance();
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
		eMailNotifierStoreEClass = createEClass(EMAIL_NOTIFIER_STORE);
		createEReference(eMailNotifierStoreEClass, EMAIL_NOTIFIER_STORE__PROJECTS);

		ensNotificationProjectEClass = createEClass(ENS_NOTIFICATION_PROJECT);
		createEAttribute(ensNotificationProjectEClass, ENS_NOTIFICATION_PROJECT__ID);
		createEAttribute(ensNotificationProjectEClass, ENS_NOTIFICATION_PROJECT__LATEST_VERSION);
		createEReference(ensNotificationProjectEClass, ENS_NOTIFICATION_PROJECT__USERS);

		ensUserEClass = createEClass(ENS_USER);
		createEAttribute(ensUserEClass, ENS_USER__USER_NAME);
		createEAttribute(ensUserEClass, ENS_USER__USER_EMAIL);
		createEReference(ensUserEClass, ENS_USER__GROUPS);

		ensNotificationGroupEClass = createEClass(ENS_NOTIFICATION_GROUP);
		createEAttribute(ensNotificationGroupEClass, ENS_NOTIFICATION_GROUP__NAME);
		createEAttribute(ensNotificationGroupEClass, ENS_NOTIFICATION_GROUP__SEND_OPTION);
		createEAttribute(ensNotificationGroupEClass, ENS_NOTIFICATION_GROUP__BASE_VERSION);
		createEAttribute(ensNotificationGroupEClass, ENS_NOTIFICATION_GROUP__NEXT_SENDING_DATE);

		// Create enums
		sendOptionEEnum = createEEnum(SEND_OPTION);
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
		initEClass(eMailNotifierStoreEClass, EMailNotifierStore.class, "EMailNotifierStore", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEMailNotifierStore_Projects(), this.getENSNotificationProject(), null, "projects", null, 0, -1, EMailNotifierStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ensNotificationProjectEClass, ENSNotificationProject.class, "ENSNotificationProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getENSNotificationProject_Id(), ecorePackage.getEString(), "id", null, 1, 1, ENSNotificationProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getENSNotificationProject_LatestVersion(), ecorePackage.getEInt(), "latestVersion", null, 1, 1, ENSNotificationProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getENSNotificationProject_Users(), this.getENSUser(), null, "users", null, 0, -1, ENSNotificationProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ensUserEClass, ENSUser.class, "ENSUser", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getENSUser_UserName(), ecorePackage.getEString(), "userName", null, 1, 1, ENSUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getENSUser_UserEMail(), ecorePackage.getEString(), "userEMail", null, 1, 1, ENSUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getENSUser_Groups(), this.getENSNotificationGroup(), null, "groups", null, 0, -1, ENSUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ensNotificationGroupEClass, ENSNotificationGroup.class, "ENSNotificationGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getENSNotificationGroup_Name(), ecorePackage.getEString(), "name", null, 1, 1, ENSNotificationGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getENSNotificationGroup_SendOption(), this.getSendOption(), "sendOption", null, 1, 1, ENSNotificationGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getENSNotificationGroup_BaseVersion(), ecorePackage.getEInt(), "baseVersion", null, 1, 1, ENSNotificationGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getENSNotificationGroup_NextSendingDate(), ecorePackage.getEDate(), "nextSendingDate", null, 1, 1, ENSNotificationGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(sendOptionEEnum, SendOption.class, "SendOption");
		addEEnumLiteral(sendOptionEEnum, SendOption.IMMEDIATELY);
		addEEnumLiteral(sendOptionEEnum, SendOption.AGGREGATED);

		// Create resource
		createResource(eNS_URI);
	}

} //ENSPackageImpl
