/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.emailnotifier.store;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.unicase.emfstore.emailnotifier.store.ENSFactory
 * @model kind="package"
 * @generated
 */
public interface ENSPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "store";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "platform:/plugin/org.unicase.emfstore.emailnotifier/model/EMailNotifierModel.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.emfstore.emailnotifier";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ENSPackage eINSTANCE = org.unicase.emfstore.emailnotifier.store.impl.ENSPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.emailnotifier.store.impl.EMailNotifierStoreImpl <em>EMail Notifier Store</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.emailnotifier.store.impl.EMailNotifierStoreImpl
	 * @see org.unicase.emfstore.emailnotifier.store.impl.ENSPackageImpl#getEMailNotifierStore()
	 * @generated
	 */
	int EMAIL_NOTIFIER_STORE = 0;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_NOTIFIER_STORE__PROJECTS = 0;

	/**
	 * The number of structural features of the '<em>EMail Notifier Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_NOTIFIER_STORE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.emailnotifier.store.impl.ENSNotificationProjectImpl <em>Notification Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.emailnotifier.store.impl.ENSNotificationProjectImpl
	 * @see org.unicase.emfstore.emailnotifier.store.impl.ENSPackageImpl#getENSNotificationProject()
	 * @generated
	 */
	int ENS_NOTIFICATION_PROJECT = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENS_NOTIFICATION_PROJECT__ID = 0;

	/**
	 * The feature id for the '<em><b>Latest Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENS_NOTIFICATION_PROJECT__LATEST_VERSION = 1;

	/**
	 * The feature id for the '<em><b>Users</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENS_NOTIFICATION_PROJECT__USERS = 2;

	/**
	 * The number of structural features of the '<em>Notification Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENS_NOTIFICATION_PROJECT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.emailnotifier.store.impl.ENSUserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.emailnotifier.store.impl.ENSUserImpl
	 * @see org.unicase.emfstore.emailnotifier.store.impl.ENSPackageImpl#getENSUser()
	 * @generated
	 */
	int ENS_USER = 2;

	/**
	 * The feature id for the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENS_USER__USER_NAME = 0;

	/**
	 * The feature id for the '<em><b>User EMail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENS_USER__USER_EMAIL = 1;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENS_USER__GROUPS = 2;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENS_USER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.emailnotifier.store.impl.ENSNotificationGroupImpl <em>Notification Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.emailnotifier.store.impl.ENSNotificationGroupImpl
	 * @see org.unicase.emfstore.emailnotifier.store.impl.ENSPackageImpl#getENSNotificationGroup()
	 * @generated
	 */
	int ENS_NOTIFICATION_GROUP = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENS_NOTIFICATION_GROUP__NAME = 0;

	/**
	 * The feature id for the '<em><b>Send Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENS_NOTIFICATION_GROUP__SEND_OPTION = 1;

	/**
	 * The feature id for the '<em><b>Base Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENS_NOTIFICATION_GROUP__BASE_VERSION = 2;

	/**
	 * The feature id for the '<em><b>Next Sending Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENS_NOTIFICATION_GROUP__NEXT_SENDING_DATE = 3;

	/**
	 * The number of structural features of the '<em>Notification Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENS_NOTIFICATION_GROUP_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.emailnotifier.store.SendOption <em>Send Option</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.emailnotifier.store.SendOption
	 * @see org.unicase.emfstore.emailnotifier.store.impl.ENSPackageImpl#getSendOption()
	 * @generated
	 */
	int SEND_OPTION = 4;


	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.emailnotifier.store.EMailNotifierStore <em>EMail Notifier Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMail Notifier Store</em>'.
	 * @see org.unicase.emfstore.emailnotifier.store.EMailNotifierStore
	 * @generated
	 */
	EClass getEMailNotifierStore();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.emfstore.emailnotifier.store.EMailNotifierStore#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Projects</em>'.
	 * @see org.unicase.emfstore.emailnotifier.store.EMailNotifierStore#getProjects()
	 * @see #getEMailNotifierStore()
	 * @generated
	 */
	EReference getEMailNotifierStore_Projects();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.emailnotifier.store.ENSNotificationProject <em>Notification Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Notification Project</em>'.
	 * @see org.unicase.emfstore.emailnotifier.store.ENSNotificationProject
	 * @generated
	 */
	EClass getENSNotificationProject();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.emailnotifier.store.ENSNotificationProject#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.unicase.emfstore.emailnotifier.store.ENSNotificationProject#getId()
	 * @see #getENSNotificationProject()
	 * @generated
	 */
	EAttribute getENSNotificationProject_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.emailnotifier.store.ENSNotificationProject#getLatestVersion <em>Latest Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Latest Version</em>'.
	 * @see org.unicase.emfstore.emailnotifier.store.ENSNotificationProject#getLatestVersion()
	 * @see #getENSNotificationProject()
	 * @generated
	 */
	EAttribute getENSNotificationProject_LatestVersion();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.emfstore.emailnotifier.store.ENSNotificationProject#getUsers <em>Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Users</em>'.
	 * @see org.unicase.emfstore.emailnotifier.store.ENSNotificationProject#getUsers()
	 * @see #getENSNotificationProject()
	 * @generated
	 */
	EReference getENSNotificationProject_Users();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.emailnotifier.store.ENSUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see org.unicase.emfstore.emailnotifier.store.ENSUser
	 * @generated
	 */
	EClass getENSUser();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.emailnotifier.store.ENSUser#getUserName <em>User Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Name</em>'.
	 * @see org.unicase.emfstore.emailnotifier.store.ENSUser#getUserName()
	 * @see #getENSUser()
	 * @generated
	 */
	EAttribute getENSUser_UserName();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.emailnotifier.store.ENSUser#getUserEMail <em>User EMail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User EMail</em>'.
	 * @see org.unicase.emfstore.emailnotifier.store.ENSUser#getUserEMail()
	 * @see #getENSUser()
	 * @generated
	 */
	EAttribute getENSUser_UserEMail();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.emfstore.emailnotifier.store.ENSUser#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Groups</em>'.
	 * @see org.unicase.emfstore.emailnotifier.store.ENSUser#getGroups()
	 * @see #getENSUser()
	 * @generated
	 */
	EReference getENSUser_Groups();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup <em>Notification Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Notification Group</em>'.
	 * @see org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup
	 * @generated
	 */
	EClass getENSNotificationGroup();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup#getName()
	 * @see #getENSNotificationGroup()
	 * @generated
	 */
	EAttribute getENSNotificationGroup_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup#getSendOption <em>Send Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Send Option</em>'.
	 * @see org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup#getSendOption()
	 * @see #getENSNotificationGroup()
	 * @generated
	 */
	EAttribute getENSNotificationGroup_SendOption();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup#getBaseVersion <em>Base Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base Version</em>'.
	 * @see org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup#getBaseVersion()
	 * @see #getENSNotificationGroup()
	 * @generated
	 */
	EAttribute getENSNotificationGroup_BaseVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup#getNextSendingDate <em>Next Sending Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Next Sending Date</em>'.
	 * @see org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup#getNextSendingDate()
	 * @see #getENSNotificationGroup()
	 * @generated
	 */
	EAttribute getENSNotificationGroup_NextSendingDate();

	/**
	 * Returns the meta object for enum '{@link org.unicase.emfstore.emailnotifier.store.SendOption <em>Send Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Send Option</em>'.
	 * @see org.unicase.emfstore.emailnotifier.store.SendOption
	 * @generated
	 */
	EEnum getSendOption();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ENSFactory getENSFactory();

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
		 * The meta object literal for the '{@link org.unicase.emfstore.emailnotifier.store.impl.EMailNotifierStoreImpl <em>EMail Notifier Store</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.emailnotifier.store.impl.EMailNotifierStoreImpl
		 * @see org.unicase.emfstore.emailnotifier.store.impl.ENSPackageImpl#getEMailNotifierStore()
		 * @generated
		 */
		EClass EMAIL_NOTIFIER_STORE = eINSTANCE.getEMailNotifierStore();

		/**
		 * The meta object literal for the '<em><b>Projects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMAIL_NOTIFIER_STORE__PROJECTS = eINSTANCE.getEMailNotifierStore_Projects();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.emailnotifier.store.impl.ENSNotificationProjectImpl <em>Notification Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.emailnotifier.store.impl.ENSNotificationProjectImpl
		 * @see org.unicase.emfstore.emailnotifier.store.impl.ENSPackageImpl#getENSNotificationProject()
		 * @generated
		 */
		EClass ENS_NOTIFICATION_PROJECT = eINSTANCE.getENSNotificationProject();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENS_NOTIFICATION_PROJECT__ID = eINSTANCE.getENSNotificationProject_Id();

		/**
		 * The meta object literal for the '<em><b>Latest Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENS_NOTIFICATION_PROJECT__LATEST_VERSION = eINSTANCE.getENSNotificationProject_LatestVersion();

		/**
		 * The meta object literal for the '<em><b>Users</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENS_NOTIFICATION_PROJECT__USERS = eINSTANCE.getENSNotificationProject_Users();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.emailnotifier.store.impl.ENSUserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.emailnotifier.store.impl.ENSUserImpl
		 * @see org.unicase.emfstore.emailnotifier.store.impl.ENSPackageImpl#getENSUser()
		 * @generated
		 */
		EClass ENS_USER = eINSTANCE.getENSUser();

		/**
		 * The meta object literal for the '<em><b>User Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENS_USER__USER_NAME = eINSTANCE.getENSUser_UserName();

		/**
		 * The meta object literal for the '<em><b>User EMail</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENS_USER__USER_EMAIL = eINSTANCE.getENSUser_UserEMail();

		/**
		 * The meta object literal for the '<em><b>Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENS_USER__GROUPS = eINSTANCE.getENSUser_Groups();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.emailnotifier.store.impl.ENSNotificationGroupImpl <em>Notification Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.emailnotifier.store.impl.ENSNotificationGroupImpl
		 * @see org.unicase.emfstore.emailnotifier.store.impl.ENSPackageImpl#getENSNotificationGroup()
		 * @generated
		 */
		EClass ENS_NOTIFICATION_GROUP = eINSTANCE.getENSNotificationGroup();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENS_NOTIFICATION_GROUP__NAME = eINSTANCE.getENSNotificationGroup_Name();

		/**
		 * The meta object literal for the '<em><b>Send Option</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENS_NOTIFICATION_GROUP__SEND_OPTION = eINSTANCE.getENSNotificationGroup_SendOption();

		/**
		 * The meta object literal for the '<em><b>Base Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENS_NOTIFICATION_GROUP__BASE_VERSION = eINSTANCE.getENSNotificationGroup_BaseVersion();

		/**
		 * The meta object literal for the '<em><b>Next Sending Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENS_NOTIFICATION_GROUP__NEXT_SENDING_DATE = eINSTANCE.getENSNotificationGroup_NextSendingDate();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.emailnotifier.store.SendOption <em>Send Option</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.emailnotifier.store.SendOption
		 * @see org.unicase.emfstore.emailnotifier.store.impl.ENSPackageImpl#getSendOption()
		 * @generated
		 */
		EEnum SEND_OPTION = eINSTANCE.getSendOption();

	}

} //ENSPackage
