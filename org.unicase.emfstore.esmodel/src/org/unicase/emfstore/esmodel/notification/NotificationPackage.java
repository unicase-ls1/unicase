/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.notification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.unicase.model.ModelPackage;

/*
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul> <li>each class,</li> <li>each feature of each class,</li> <li>each enum,</li> <li>and each data type</li> </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.emfstore.esmodel.notification.NotificationFactory
 * @model kind="package"
 * @generated
 */
public interface NotificationPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "notification";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/esmodel/notification";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.notification";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	NotificationPackage eINSTANCE = org.unicase.emfstore.esmodel.notification.impl.NotificationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.notification.impl.ESNotificationImpl
	 * <em>ES Notification</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.notification.impl.ESNotificationImpl
	 * @see org.unicase.emfstore.esmodel.notification.impl.NotificationPackageImpl#getESNotification()
	 * @generated
	 */
	int ES_NOTIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ES_NOTIFICATION__IDENTIFIER = ModelPackage.IDENTIFIABLE_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Sender</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ES_NOTIFICATION__SENDER = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Recipient</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ES_NOTIFICATION__RECIPIENT = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Project</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ES_NOTIFICATION__PROJECT = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Related Model Elements</b></em>' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ES_NOTIFICATION__RELATED_MODEL_ELEMENTS = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ES_NOTIFICATION__MESSAGE = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>ES Notification</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ES_NOTIFICATION_FEATURE_COUNT = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.notification.ESNotification
	 * <em>ES Notification</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>ES Notification</em>'.
	 * @see org.unicase.emfstore.esmodel.notification.ESNotification
	 * @generated
	 */
	EClass getESNotification();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.notification.ESNotification#getSender <em>Sender</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Sender</em>'.
	 * @see org.unicase.emfstore.esmodel.notification.ESNotification#getSender()
	 * @see #getESNotification()
	 * @generated
	 */
	EAttribute getESNotification_Sender();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.notification.ESNotification#getRecipient <em>Recipient</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Recipient</em>'.
	 * @see org.unicase.emfstore.esmodel.notification.ESNotification#getRecipient()
	 * @see #getESNotification()
	 * @generated
	 */
	EAttribute getESNotification_Recipient();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.esmodel.notification.ESNotification#getProject <em>Project</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Project</em>'.
	 * @see org.unicase.emfstore.esmodel.notification.ESNotification#getProject()
	 * @see #getESNotification()
	 * @generated
	 */
	EReference getESNotification_Project();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.emfstore.esmodel.notification.ESNotification#getRelatedModelElements
	 * <em>Related Model Elements</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Related Model Elements</em>'.
	 * @see org.unicase.emfstore.esmodel.notification.ESNotification#getRelatedModelElements()
	 * @see #getESNotification()
	 * @generated
	 */
	EReference getESNotification_RelatedModelElements();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.notification.ESNotification#getMessage <em>Message</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.unicase.emfstore.esmodel.notification.ESNotification#getMessage()
	 * @see #getESNotification()
	 * @generated
	 */
	EAttribute getESNotification_Message();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NotificationFactory getNotificationFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.notification.impl.ESNotificationImpl
		 * <em>ES Notification</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.notification.impl.ESNotificationImpl
		 * @see org.unicase.emfstore.esmodel.notification.impl.NotificationPackageImpl#getESNotification()
		 * @generated
		 */
		EClass ES_NOTIFICATION = eINSTANCE.getESNotification();

		/**
		 * The meta object literal for the '<em><b>Sender</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ES_NOTIFICATION__SENDER = eINSTANCE.getESNotification_Sender();

		/**
		 * The meta object literal for the '<em><b>Recipient</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ES_NOTIFICATION__RECIPIENT = eINSTANCE.getESNotification_Recipient();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' containment reference feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ES_NOTIFICATION__PROJECT = eINSTANCE.getESNotification_Project();

		/**
		 * The meta object literal for the '<em><b>Related Model Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ES_NOTIFICATION__RELATED_MODEL_ELEMENTS = eINSTANCE.getESNotification_RelatedModelElements();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ES_NOTIFICATION__MESSAGE = eINSTANCE.getESNotification_Message();

	}

} // NotificationPackage
