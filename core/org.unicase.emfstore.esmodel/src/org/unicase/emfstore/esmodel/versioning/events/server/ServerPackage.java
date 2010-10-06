/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.events.server;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.unicase.emfstore.esmodel.versioning.events.EventsPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.emfstore.esmodel.versioning.events.server.ServerFactory
 * @model kind="package"
 * @generated
 */
public interface ServerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "server";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/esmodel/versioning/events/server/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.esmodel.versioning.events.server";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	ServerPackage eINSTANCE = org.unicase.emfstore.esmodel.versioning.events.server.impl.ServerPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.server.impl.ServerEventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.events.server.impl.ServerEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.server.impl.ServerPackageImpl#getServerEvent()
	 * @generated
	 */
	int SERVER_EVENT = 0;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_EVENT__TIMESTAMP = EventsPackage.EVENT__TIMESTAMP;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_EVENT_FEATURE_COUNT = EventsPackage.EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.server.impl.ServerProjectEventImpl <em>Project Event</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.events.server.impl.ServerProjectEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.server.impl.ServerPackageImpl#getServerProjectEvent()
	 * @generated
	 */
	int SERVER_PROJECT_EVENT = 1;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_PROJECT_EVENT__TIMESTAMP = SERVER_EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Project Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_PROJECT_EVENT__PROJECT_ID = SERVER_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Project Event</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_PROJECT_EVENT_FEATURE_COUNT = SERVER_EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.server.impl.ProjectUpdatedEventImpl <em>Project Updated Event</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.events.server.impl.ProjectUpdatedEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.server.impl.ServerPackageImpl#getProjectUpdatedEvent()
	 * @generated
	 */
	int PROJECT_UPDATED_EVENT = 2;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UPDATED_EVENT__TIMESTAMP = SERVER_PROJECT_EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Project Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UPDATED_EVENT__PROJECT_ID = SERVER_PROJECT_EVENT__PROJECT_ID;

	/**
	 * The feature id for the '<em><b>New Version</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UPDATED_EVENT__NEW_VERSION = SERVER_PROJECT_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Project Updated Event</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UPDATED_EVENT_FEATURE_COUNT = SERVER_PROJECT_EVENT_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.server.ServerEvent <em>Event</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.server.ServerEvent
	 * @generated
	 */
	EClass getServerEvent();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.server.ServerProjectEvent <em>Project Event</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Project Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.server.ServerProjectEvent
	 * @generated
	 */
	EClass getServerProjectEvent();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.versioning.events.server.ServerProjectEvent#getProjectId <em>Project Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Project Id</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.server.ServerProjectEvent#getProjectId()
	 * @see #getServerProjectEvent()
	 * @generated
	 */
	EReference getServerProjectEvent_ProjectId();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.server.ProjectUpdatedEvent <em>Project Updated Event</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Updated Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.server.ProjectUpdatedEvent
	 * @generated
	 */
	EClass getProjectUpdatedEvent();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.versioning.events.server.ProjectUpdatedEvent#getNewVersion <em>New Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>New Version</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.server.ProjectUpdatedEvent#getNewVersion()
	 * @see #getProjectUpdatedEvent()
	 * @generated
	 */
	EReference getProjectUpdatedEvent_NewVersion();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ServerFactory getServerFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.events.server.impl.ServerEventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.events.server.impl.ServerEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.server.impl.ServerPackageImpl#getServerEvent()
		 * @generated
		 */
		EClass SERVER_EVENT = eINSTANCE.getServerEvent();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.events.server.impl.ServerProjectEventImpl <em>Project Event</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.events.server.impl.ServerProjectEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.server.impl.ServerPackageImpl#getServerProjectEvent()
		 * @generated
		 */
		EClass SERVER_PROJECT_EVENT = eINSTANCE.getServerProjectEvent();

		/**
		 * The meta object literal for the '<em><b>Project Id</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SERVER_PROJECT_EVENT__PROJECT_ID = eINSTANCE.getServerProjectEvent_ProjectId();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.events.server.impl.ProjectUpdatedEventImpl <em>Project Updated Event</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.events.server.impl.ProjectUpdatedEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.server.impl.ServerPackageImpl#getProjectUpdatedEvent()
		 * @generated
		 */
		EClass PROJECT_UPDATED_EVENT = eINSTANCE.getProjectUpdatedEvent();

		/**
		 * The meta object literal for the '<em><b>New Version</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROJECT_UPDATED_EVENT__NEW_VERSION = eINSTANCE.getProjectUpdatedEvent_NewVersion();

	}

} // ServerPackage
