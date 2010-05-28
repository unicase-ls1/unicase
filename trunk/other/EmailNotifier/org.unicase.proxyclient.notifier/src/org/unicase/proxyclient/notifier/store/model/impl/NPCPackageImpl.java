/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.proxyclient.notifier.store.model.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.unicase.proxyclient.notifier.store.model.NPCFactory;
import org.unicase.proxyclient.notifier.store.model.NPCPackage;
import org.unicase.proxyclient.notifier.store.model.NotificationEntry;
import org.unicase.proxyclient.notifier.store.model.NotificationGroup;
import org.unicase.proxyclient.notifier.store.model.NotificationProject;
import org.unicase.proxyclient.notifier.store.model.NotifierProxyClientStore;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NPCPackageImpl extends EPackageImpl implements NPCPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notifierProxyClientStoreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notificationProjectEClass = null;

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
	private EClass notificationEntryEClass = null;

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
	 * @see org.unicase.proxyclient.notifier.store.model.NPCPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NPCPackageImpl() {
		super(eNS_URI, NPCFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link NPCPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NPCPackage init() {
		if (isInited) return (NPCPackage)EPackage.Registry.INSTANCE.getEPackage(NPCPackage.eNS_URI);

		// Obtain or create and register package
		NPCPackageImpl theNPCPackage = (NPCPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof NPCPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new NPCPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theNPCPackage.createPackageContents();

		// Initialize created meta-data
		theNPCPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNPCPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(NPCPackage.eNS_URI, theNPCPackage);
		return theNPCPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotifierProxyClientStore() {
		return notifierProxyClientStoreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNotifierProxyClientStore_Projects() {
		return (EReference)notifierProxyClientStoreEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotificationProject() {
		return notificationProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNotificationProject_Id() {
		return (EAttribute)notificationProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNotificationProject_UserName() {
		return (EAttribute)notificationProjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNotificationProject_LastSeenEMail() {
		return (EAttribute)notificationProjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNotificationProject_Groups() {
		return (EReference)notificationProjectEClass.getEStructuralFeatures().get(3);
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
	public EAttribute getNotificationGroup_Name() {
		return (EAttribute)notificationGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNotificationGroup_NextSending() {
		return (EAttribute)notificationGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNotificationGroup_Notifications() {
		return (EReference)notificationGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotificationEntry() {
		return notificationEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNotificationEntry_Text() {
		return (EAttribute)notificationEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NPCFactory getNPCFactory() {
		return (NPCFactory)getEFactoryInstance();
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
		notifierProxyClientStoreEClass = createEClass(NOTIFIER_PROXY_CLIENT_STORE);
		createEReference(notifierProxyClientStoreEClass, NOTIFIER_PROXY_CLIENT_STORE__PROJECTS);

		notificationProjectEClass = createEClass(NOTIFICATION_PROJECT);
		createEAttribute(notificationProjectEClass, NOTIFICATION_PROJECT__ID);
		createEAttribute(notificationProjectEClass, NOTIFICATION_PROJECT__USER_NAME);
		createEAttribute(notificationProjectEClass, NOTIFICATION_PROJECT__LAST_SEEN_EMAIL);
		createEReference(notificationProjectEClass, NOTIFICATION_PROJECT__GROUPS);

		notificationGroupEClass = createEClass(NOTIFICATION_GROUP);
		createEAttribute(notificationGroupEClass, NOTIFICATION_GROUP__NAME);
		createEAttribute(notificationGroupEClass, NOTIFICATION_GROUP__NEXT_SENDING);
		createEReference(notificationGroupEClass, NOTIFICATION_GROUP__NOTIFICATIONS);

		notificationEntryEClass = createEClass(NOTIFICATION_ENTRY);
		createEAttribute(notificationEntryEClass, NOTIFICATION_ENTRY__TEXT);
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
		initEClass(notifierProxyClientStoreEClass, NotifierProxyClientStore.class, "NotifierProxyClientStore", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNotifierProxyClientStore_Projects(), this.getNotificationProject(), null, "projects", null, 0, -1, NotifierProxyClientStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(notificationProjectEClass, NotificationProject.class, "NotificationProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNotificationProject_Id(), ecorePackage.getEString(), "id", null, 1, 1, NotificationProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNotificationProject_UserName(), ecorePackage.getEString(), "userName", null, 1, 1, NotificationProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNotificationProject_LastSeenEMail(), ecorePackage.getEString(), "lastSeenEMail", null, 1, 1, NotificationProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNotificationProject_Groups(), this.getNotificationGroup(), null, "groups", null, 0, -1, NotificationProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(notificationGroupEClass, NotificationGroup.class, "NotificationGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNotificationGroup_Name(), ecorePackage.getEString(), "name", null, 1, 1, NotificationGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNotificationGroup_NextSending(), ecorePackage.getEDate(), "nextSending", null, 1, 1, NotificationGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNotificationGroup_Notifications(), this.getNotificationEntry(), null, "notifications", null, 0, -1, NotificationGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(notificationEntryEClass, NotificationEntry.class, "NotificationEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNotificationEntry_Text(), ecorePackage.getEString(), "text", null, 1, 1, NotificationEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //NPCPackageImpl
