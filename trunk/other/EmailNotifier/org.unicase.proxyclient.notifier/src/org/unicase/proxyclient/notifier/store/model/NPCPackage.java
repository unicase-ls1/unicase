/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.proxyclient.notifier.store.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.unicase.proxyclient.notifier.store.model.NPCFactory
 * @model kind="package"
 * @generated
 * 
 * @author staudta
 */
public interface NPCPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "platform:/plugin/org.unicase.proxyclient.notifier/model/ProxyClientModel.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.proxyclient.notifier";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NPCPackage eINSTANCE = org.unicase.proxyclient.notifier.store.model.impl.NPCPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.proxyclient.notifier.store.model.impl.NotifierProxyClientStoreImpl <em>Notifier Proxy Client Store</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.proxyclient.notifier.store.model.impl.NotifierProxyClientStoreImpl
	 * @see org.unicase.proxyclient.notifier.store.model.impl.NPCPackageImpl#getNotifierProxyClientStore()
	 * @generated
	 */
	int NOTIFIER_PROXY_CLIENT_STORE = 0;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFIER_PROXY_CLIENT_STORE__PROJECTS = 0;

	/**
	 * The number of structural features of the '<em>Notifier Proxy Client Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFIER_PROXY_CLIENT_STORE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.proxyclient.notifier.store.model.impl.NotificationProjectImpl <em>Notification Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.proxyclient.notifier.store.model.impl.NotificationProjectImpl
	 * @see org.unicase.proxyclient.notifier.store.model.impl.NPCPackageImpl#getNotificationProject()
	 * @generated
	 */
	int NOTIFICATION_PROJECT = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_PROJECT__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_PROJECT__NAME = 1;

	/**
	 * The feature id for the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_PROJECT__USER_NAME = 2;

	/**
	 * The feature id for the '<em><b>Last Seen EMail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_PROJECT__LAST_SEEN_EMAIL = 3;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_PROJECT__GROUPS = 4;

	/**
	 * The number of structural features of the '<em>Notification Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_PROJECT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.unicase.proxyclient.notifier.store.model.impl.NotificationGroupImpl <em>Notification Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.proxyclient.notifier.store.model.impl.NotificationGroupImpl
	 * @see org.unicase.proxyclient.notifier.store.model.impl.NPCPackageImpl#getNotificationGroup()
	 * @generated
	 */
	int NOTIFICATION_GROUP = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_GROUP__NAME = 0;

	/**
	 * The feature id for the '<em><b>Next Sending</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_GROUP__NEXT_SENDING = 1;

	/**
	 * The feature id for the '<em><b>Notifications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_GROUP__NOTIFICATIONS = 2;

	/**
	 * The number of structural features of the '<em>Notification Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_GROUP_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.unicase.proxyclient.notifier.store.model.impl.NotificationEntryImpl <em>Notification Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.proxyclient.notifier.store.model.impl.NotificationEntryImpl
	 * @see org.unicase.proxyclient.notifier.store.model.impl.NPCPackageImpl#getNotificationEntry()
	 * @generated
	 */
	int NOTIFICATION_ENTRY = 3;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_ENTRY__TEXT = 0;

	/**
	 * The number of structural features of the '<em>Notification Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_ENTRY_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.unicase.proxyclient.notifier.store.model.NotifierProxyClientStore <em>Notifier Proxy Client Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Notifier Proxy Client Store</em>'.
	 * @see org.unicase.proxyclient.notifier.store.model.NotifierProxyClientStore
	 * @generated
	 */
	EClass getNotifierProxyClientStore();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.proxyclient.notifier.store.model.NotifierProxyClientStore#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Projects</em>'.
	 * @see org.unicase.proxyclient.notifier.store.model.NotifierProxyClientStore#getProjects()
	 * @see #getNotifierProxyClientStore()
	 * @generated
	 */
	EReference getNotifierProxyClientStore_Projects();

	/**
	 * Returns the meta object for class '{@link org.unicase.proxyclient.notifier.store.model.NotificationProject <em>Notification Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Notification Project</em>'.
	 * @see org.unicase.proxyclient.notifier.store.model.NotificationProject
	 * @generated
	 */
	EClass getNotificationProject();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.proxyclient.notifier.store.model.NotificationProject#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.unicase.proxyclient.notifier.store.model.NotificationProject#getId()
	 * @see #getNotificationProject()
	 * @generated
	 */
	EAttribute getNotificationProject_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.proxyclient.notifier.store.model.NotificationProject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.proxyclient.notifier.store.model.NotificationProject#getName()
	 * @see #getNotificationProject()
	 * @generated
	 */
	EAttribute getNotificationProject_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.proxyclient.notifier.store.model.NotificationProject#getUserName <em>User Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Name</em>'.
	 * @see org.unicase.proxyclient.notifier.store.model.NotificationProject#getUserName()
	 * @see #getNotificationProject()
	 * @generated
	 */
	EAttribute getNotificationProject_UserName();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.proxyclient.notifier.store.model.NotificationProject#getLastSeenEMail <em>Last Seen EMail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Seen EMail</em>'.
	 * @see org.unicase.proxyclient.notifier.store.model.NotificationProject#getLastSeenEMail()
	 * @see #getNotificationProject()
	 * @generated
	 */
	EAttribute getNotificationProject_LastSeenEMail();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.proxyclient.notifier.store.model.NotificationProject#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Groups</em>'.
	 * @see org.unicase.proxyclient.notifier.store.model.NotificationProject#getGroups()
	 * @see #getNotificationProject()
	 * @generated
	 */
	EReference getNotificationProject_Groups();

	/**
	 * Returns the meta object for class '{@link org.unicase.proxyclient.notifier.store.model.NotificationGroup <em>Notification Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Notification Group</em>'.
	 * @see org.unicase.proxyclient.notifier.store.model.NotificationGroup
	 * @generated
	 */
	EClass getNotificationGroup();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.proxyclient.notifier.store.model.NotificationGroup#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.proxyclient.notifier.store.model.NotificationGroup#getName()
	 * @see #getNotificationGroup()
	 * @generated
	 */
	EAttribute getNotificationGroup_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.proxyclient.notifier.store.model.NotificationGroup#getNextSending <em>Next Sending</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Next Sending</em>'.
	 * @see org.unicase.proxyclient.notifier.store.model.NotificationGroup#getNextSending()
	 * @see #getNotificationGroup()
	 * @generated
	 */
	EAttribute getNotificationGroup_NextSending();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.proxyclient.notifier.store.model.NotificationGroup#getNotifications <em>Notifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Notifications</em>'.
	 * @see org.unicase.proxyclient.notifier.store.model.NotificationGroup#getNotifications()
	 * @see #getNotificationGroup()
	 * @generated
	 */
	EReference getNotificationGroup_Notifications();

	/**
	 * Returns the meta object for class '{@link org.unicase.proxyclient.notifier.store.model.NotificationEntry <em>Notification Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Notification Entry</em>'.
	 * @see org.unicase.proxyclient.notifier.store.model.NotificationEntry
	 * @generated
	 */
	EClass getNotificationEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.proxyclient.notifier.store.model.NotificationEntry#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.unicase.proxyclient.notifier.store.model.NotificationEntry#getText()
	 * @see #getNotificationEntry()
	 * @generated
	 */
	EAttribute getNotificationEntry_Text();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NPCFactory getNPCFactory();

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
		 * The meta object literal for the '{@link org.unicase.proxyclient.notifier.store.model.impl.NotifierProxyClientStoreImpl <em>Notifier Proxy Client Store</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.proxyclient.notifier.store.model.impl.NotifierProxyClientStoreImpl
		 * @see org.unicase.proxyclient.notifier.store.model.impl.NPCPackageImpl#getNotifierProxyClientStore()
		 * @generated
		 */
		EClass NOTIFIER_PROXY_CLIENT_STORE = eINSTANCE.getNotifierProxyClientStore();

		/**
		 * The meta object literal for the '<em><b>Projects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOTIFIER_PROXY_CLIENT_STORE__PROJECTS = eINSTANCE.getNotifierProxyClientStore_Projects();

		/**
		 * The meta object literal for the '{@link org.unicase.proxyclient.notifier.store.model.impl.NotificationProjectImpl <em>Notification Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.proxyclient.notifier.store.model.impl.NotificationProjectImpl
		 * @see org.unicase.proxyclient.notifier.store.model.impl.NPCPackageImpl#getNotificationProject()
		 * @generated
		 */
		EClass NOTIFICATION_PROJECT = eINSTANCE.getNotificationProject();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION_PROJECT__ID = eINSTANCE.getNotificationProject_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION_PROJECT__NAME = eINSTANCE.getNotificationProject_Name();

		/**
		 * The meta object literal for the '<em><b>User Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION_PROJECT__USER_NAME = eINSTANCE.getNotificationProject_UserName();

		/**
		 * The meta object literal for the '<em><b>Last Seen EMail</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION_PROJECT__LAST_SEEN_EMAIL = eINSTANCE.getNotificationProject_LastSeenEMail();

		/**
		 * The meta object literal for the '<em><b>Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOTIFICATION_PROJECT__GROUPS = eINSTANCE.getNotificationProject_Groups();

		/**
		 * The meta object literal for the '{@link org.unicase.proxyclient.notifier.store.model.impl.NotificationGroupImpl <em>Notification Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.proxyclient.notifier.store.model.impl.NotificationGroupImpl
		 * @see org.unicase.proxyclient.notifier.store.model.impl.NPCPackageImpl#getNotificationGroup()
		 * @generated
		 */
		EClass NOTIFICATION_GROUP = eINSTANCE.getNotificationGroup();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION_GROUP__NAME = eINSTANCE.getNotificationGroup_Name();

		/**
		 * The meta object literal for the '<em><b>Next Sending</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION_GROUP__NEXT_SENDING = eINSTANCE.getNotificationGroup_NextSending();

		/**
		 * The meta object literal for the '<em><b>Notifications</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOTIFICATION_GROUP__NOTIFICATIONS = eINSTANCE.getNotificationGroup_Notifications();

		/**
		 * The meta object literal for the '{@link org.unicase.proxyclient.notifier.store.model.impl.NotificationEntryImpl <em>Notification Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.proxyclient.notifier.store.model.impl.NotificationEntryImpl
		 * @see org.unicase.proxyclient.notifier.store.model.impl.NPCPackageImpl#getNotificationEntry()
		 * @generated
		 */
		EClass NOTIFICATION_ENTRY = eINSTANCE.getNotificationEntry();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION_ENTRY__TEXT = eINSTANCE.getNotificationEntry_Text();

	}

} //NPCPackage
