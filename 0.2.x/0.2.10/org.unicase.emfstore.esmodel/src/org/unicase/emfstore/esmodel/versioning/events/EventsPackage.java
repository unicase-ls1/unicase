/**
 * <copyright>Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html</copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.events;

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
 * @see org.unicase.emfstore.esmodel.versioning.events.EventsFactory
 * @model kind="package"
 * @generated
 */
public interface EventsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "events";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/esmodel/versioning/events";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.emfstore.esmodel.versioning.events";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EventsPackage eINSTANCE = org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 0;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__TIMESTAMP = 0;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.ReadEventImpl <em>Read Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.ReadEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getReadEvent()
	 * @generated
	 */
	int READ_EVENT = 1;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Model Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_EVENT__MODEL_ELEMENT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Read Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.MergeEventImpl <em>Merge Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.MergeEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getMergeEvent()
	 * @generated
	 */
	int MERGE_EVENT = 2;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Number Of Conflicts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_EVENT__NUMBER_OF_CONFLICTS = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Total Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_EVENT__TOTAL_TIME = EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_EVENT__BASE_VERSION = EVENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_EVENT__TARGET_VERSION = EVENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Local Changes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_EVENT__LOCAL_CHANGES = EVENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Merge Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.CheckoutEventImpl <em>Checkout Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.CheckoutEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getCheckoutEvent()
	 * @generated
	 */
	int CHECKOUT_EVENT = 3;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKOUT_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Base Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKOUT_EVENT__BASE_VERSION = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Checkout Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKOUT_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.ExceptionEventImpl <em>Exception Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.ExceptionEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getExceptionEvent()
	 * @generated
	 */
	int EXCEPTION_EVENT = 4;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Exception Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_EVENT__EXCEPTION_TITLE = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exception Stack Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_EVENT__EXCEPTION_STACK_TRACE = EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Exception Cause Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_EVENT__EXCEPTION_CAUSE_TITLE = EVENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Exception Cause Stack Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_EVENT__EXCEPTION_CAUSE_STACK_TRACE = EVENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Exception Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.PluginStartEventImpl <em>Plugin Start Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.PluginStartEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getPluginStartEvent()
	 * @generated
	 */
	int PLUGIN_START_EVENT = 5;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_START_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Plugin Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_START_EVENT__PLUGIN_ID = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Plugin Start Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_START_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.events.Event#getTimestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.Event#getTimestamp()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Timestamp();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.ReadEvent <em>Read Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Read Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.ReadEvent
	 * @generated
	 */
	EClass getReadEvent();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.versioning.events.ReadEvent#getModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Model Element</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.ReadEvent#getModelElement()
	 * @see #getReadEvent()
	 * @generated
	 */
	EReference getReadEvent_ModelElement();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.MergeEvent <em>Merge Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Merge Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeEvent
	 * @generated
	 */
	EClass getMergeEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.events.MergeEvent#getNumberOfConflicts <em>Number Of Conflicts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Conflicts</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeEvent#getNumberOfConflicts()
	 * @see #getMergeEvent()
	 * @generated
	 */
	EAttribute getMergeEvent_NumberOfConflicts();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.events.MergeEvent#getTotalTime <em>Total Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Time</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeEvent#getTotalTime()
	 * @see #getMergeEvent()
	 * @generated
	 */
	EAttribute getMergeEvent_TotalTime();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.versioning.events.MergeEvent#getBaseVersion <em>Base Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Base Version</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeEvent#getBaseVersion()
	 * @see #getMergeEvent()
	 * @generated
	 */
	EReference getMergeEvent_BaseVersion();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.versioning.events.MergeEvent#getTargetVersion <em>Target Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Version</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeEvent#getTargetVersion()
	 * @see #getMergeEvent()
	 * @generated
	 */
	EReference getMergeEvent_TargetVersion();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.emfstore.esmodel.versioning.events.MergeEvent#getLocalChanges <em>Local Changes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Local Changes</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeEvent#getLocalChanges()
	 * @see #getMergeEvent()
	 * @generated
	 */
	EReference getMergeEvent_LocalChanges();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.CheckoutEvent <em>Checkout Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Checkout Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.CheckoutEvent
	 * @generated
	 */
	EClass getCheckoutEvent();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.versioning.events.CheckoutEvent#getBaseVersion <em>Base Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Base Version</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.CheckoutEvent#getBaseVersion()
	 * @see #getCheckoutEvent()
	 * @generated
	 */
	EReference getCheckoutEvent_BaseVersion();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent <em>Exception Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exception Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent
	 * @generated
	 */
	EClass getExceptionEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent#getExceptionTitle <em>Exception Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exception Title</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent#getExceptionTitle()
	 * @see #getExceptionEvent()
	 * @generated
	 */
	EAttribute getExceptionEvent_ExceptionTitle();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent#getExceptionStackTrace <em>Exception Stack Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exception Stack Trace</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent#getExceptionStackTrace()
	 * @see #getExceptionEvent()
	 * @generated
	 */
	EAttribute getExceptionEvent_ExceptionStackTrace();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent#getExceptionCauseTitle <em>Exception Cause Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exception Cause Title</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent#getExceptionCauseTitle()
	 * @see #getExceptionEvent()
	 * @generated
	 */
	EAttribute getExceptionEvent_ExceptionCauseTitle();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent#getExceptionCauseStackTrace <em>Exception Cause Stack Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exception Cause Stack Trace</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent#getExceptionCauseStackTrace()
	 * @see #getExceptionEvent()
	 * @generated
	 */
	EAttribute getExceptionEvent_ExceptionCauseStackTrace();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.PluginStartEvent <em>Plugin Start Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plugin Start Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.PluginStartEvent
	 * @generated
	 */
	EClass getPluginStartEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.events.PluginStartEvent#getPluginId <em>Plugin Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plugin Id</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.PluginStartEvent#getPluginId()
	 * @see #getPluginStartEvent()
	 * @generated
	 */
	EAttribute getPluginStartEvent_PluginId();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EventsFactory getEventsFactory();

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
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>Timestamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__TIMESTAMP = eINSTANCE.getEvent_Timestamp();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.ReadEventImpl <em>Read Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.ReadEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getReadEvent()
		 * @generated
		 */
		EClass READ_EVENT = eINSTANCE.getReadEvent();

		/**
		 * The meta object literal for the '<em><b>Model Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference READ_EVENT__MODEL_ELEMENT = eINSTANCE
				.getReadEvent_ModelElement();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.MergeEventImpl <em>Merge Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.MergeEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getMergeEvent()
		 * @generated
		 */
		EClass MERGE_EVENT = eINSTANCE.getMergeEvent();

		/**
		 * The meta object literal for the '<em><b>Number Of Conflicts</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MERGE_EVENT__NUMBER_OF_CONFLICTS = eINSTANCE
				.getMergeEvent_NumberOfConflicts();

		/**
		 * The meta object literal for the '<em><b>Total Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MERGE_EVENT__TOTAL_TIME = eINSTANCE
				.getMergeEvent_TotalTime();

		/**
		 * The meta object literal for the '<em><b>Base Version</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MERGE_EVENT__BASE_VERSION = eINSTANCE
				.getMergeEvent_BaseVersion();

		/**
		 * The meta object literal for the '<em><b>Target Version</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MERGE_EVENT__TARGET_VERSION = eINSTANCE
				.getMergeEvent_TargetVersion();

		/**
		 * The meta object literal for the '<em><b>Local Changes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MERGE_EVENT__LOCAL_CHANGES = eINSTANCE
				.getMergeEvent_LocalChanges();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.CheckoutEventImpl <em>Checkout Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.CheckoutEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getCheckoutEvent()
		 * @generated
		 */
		EClass CHECKOUT_EVENT = eINSTANCE.getCheckoutEvent();

		/**
		 * The meta object literal for the '<em><b>Base Version</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECKOUT_EVENT__BASE_VERSION = eINSTANCE
				.getCheckoutEvent_BaseVersion();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.ExceptionEventImpl <em>Exception Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.ExceptionEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getExceptionEvent()
		 * @generated
		 */
		EClass EXCEPTION_EVENT = eINSTANCE.getExceptionEvent();

		/**
		 * The meta object literal for the '<em><b>Exception Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXCEPTION_EVENT__EXCEPTION_TITLE = eINSTANCE
				.getExceptionEvent_ExceptionTitle();

		/**
		 * The meta object literal for the '<em><b>Exception Stack Trace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXCEPTION_EVENT__EXCEPTION_STACK_TRACE = eINSTANCE
				.getExceptionEvent_ExceptionStackTrace();

		/**
		 * The meta object literal for the '<em><b>Exception Cause Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXCEPTION_EVENT__EXCEPTION_CAUSE_TITLE = eINSTANCE
				.getExceptionEvent_ExceptionCauseTitle();

		/**
		 * The meta object literal for the '<em><b>Exception Cause Stack Trace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXCEPTION_EVENT__EXCEPTION_CAUSE_STACK_TRACE = eINSTANCE
				.getExceptionEvent_ExceptionCauseStackTrace();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.PluginStartEventImpl <em>Plugin Start Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.PluginStartEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getPluginStartEvent()
		 * @generated
		 */
		EClass PLUGIN_START_EVENT = eINSTANCE.getPluginStartEvent();

		/**
		 * The meta object literal for the '<em><b>Plugin Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_START_EVENT__PLUGIN_ID = eINSTANCE
				.getPluginStartEvent_PluginId();

	}

} //EventsPackage
