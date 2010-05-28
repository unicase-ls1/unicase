/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.events;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.unicase.emfstore.esmodel.versioning.events.EventsFactory
 * @model kind="package"
 * @generated
 */
public interface EventsPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "events";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/esmodel/versioning/events";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.emfstore.esmodel.versioning.events";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	EventsPackage eINSTANCE = org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.EventImpl <em>Event</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 0;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT__TIMESTAMP = 0;

	/**
	 * The number of structural features of the '<em>Event</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.ReadEventImpl
	 * <em>Read Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.ReadEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getReadEvent()
	 * @generated
	 */
	int READ_EVENT = 1;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int READ_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Model Element</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int READ_EVENT__MODEL_ELEMENT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source View</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int READ_EVENT__SOURCE_VIEW = EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Read View</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int READ_EVENT__READ_VIEW = EVENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Read Event</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int READ_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.MergeEventImpl
	 * <em>Merge Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.MergeEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getMergeEvent()
	 * @generated
	 */
	int MERGE_EVENT = 2;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGE_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Number Of Conflicts</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGE_EVENT__NUMBER_OF_CONFLICTS = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Total Time</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGE_EVENT__TOTAL_TIME = EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Version</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGE_EVENT__BASE_VERSION = EVENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target Version</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGE_EVENT__TARGET_VERSION = EVENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Local Changes</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGE_EVENT__LOCAL_CHANGES = EVENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Merge Event</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGE_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.CheckoutEventImpl
	 * <em>Checkout Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.CheckoutEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getCheckoutEvent()
	 * @generated
	 */
	int CHECKOUT_EVENT = 3;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHECKOUT_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Base Version</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHECKOUT_EVENT__BASE_VERSION = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Checkout Event</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHECKOUT_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.ExceptionEventImpl
	 * <em>Exception Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.ExceptionEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getExceptionEvent()
	 * @generated
	 */
	int EXCEPTION_EVENT = 4;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Exception Title</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_EVENT__EXCEPTION_TITLE = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exception Stack Trace</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_EVENT__EXCEPTION_STACK_TRACE = EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Exception Cause Title</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_EVENT__EXCEPTION_CAUSE_TITLE = EVENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Exception Cause Stack Trace</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_EVENT__EXCEPTION_CAUSE_STACK_TRACE = EVENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Exception Event</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.PluginStartEventImpl
	 * <em>Plugin Start Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.PluginStartEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getPluginStartEvent()
	 * @generated
	 */
	int PLUGIN_START_EVENT = 5;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PLUGIN_START_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Plugin Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PLUGIN_START_EVENT__PLUGIN_ID = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Plugin Start Event</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PLUGIN_START_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.UpdateEventImpl
	 * <em>Update Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.UpdateEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getUpdateEvent()
	 * @generated
	 */
	int UPDATE_EVENT = 6;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UPDATE_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Base Version</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UPDATE_EVENT__BASE_VERSION = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Version</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UPDATE_EVENT__TARGET_VERSION = EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Update Event</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UPDATE_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.AnnotationEventImpl
	 * <em>Annotation Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.AnnotationEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getAnnotationEvent()
	 * @generated
	 */
	int ANNOTATION_EVENT = 7;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Annotated Element</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_EVENT__ANNOTATED_ELEMENT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_EVENT__ANNOTATION = EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Annotation Event</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.RevertEventImpl
	 * <em>Revert Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.RevertEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getRevertEvent()
	 * @generated
	 */
	int REVERT_EVENT = 8;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REVERT_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Reverted Changes Count</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REVERT_EVENT__REVERTED_CHANGES_COUNT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Revert Event</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REVERT_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.ShowHistoryEventImpl
	 * <em>Show History Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.ShowHistoryEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getShowHistoryEvent()
	 * @generated
	 */
	int SHOW_HISTORY_EVENT = 9;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOW_HISTORY_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Source Version</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOW_HISTORY_EVENT__SOURCE_VERSION = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Version</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOW_HISTORY_EVENT__TARGET_VERSION = EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Model Element</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOW_HISTORY_EVENT__MODEL_ELEMENT = EVENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Show History Event</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOW_HISTORY_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.PerspectiveEventImpl
	 * <em>Perspective Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.PerspectiveEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getPerspectiveEvent()
	 * @generated
	 */
	int PERSPECTIVE_EVENT = 10;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PERSPECTIVE_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The number of structural features of the '<em>Perspective Event</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PERSPECTIVE_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.DNDEventImpl
	 * <em>DND Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.DNDEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getDNDEvent()
	 * @generated
	 */
	int DND_EVENT = 11;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DND_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Source View</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DND_EVENT__SOURCE_VIEW = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target View</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DND_EVENT__TARGET_VIEW = EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Drag Source Element</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DND_EVENT__DRAG_SOURCE_ELEMENT = EVENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Drop Target Element</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DND_EVENT__DROP_TARGET_ELEMENT = EVENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>DND Event</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DND_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.LinkEventImpl
	 * <em>Link Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.LinkEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getLinkEvent()
	 * @generated
	 */
	int LINK_EVENT = 12;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINK_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Source View</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINK_EVENT__SOURCE_VIEW = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Element</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINK_EVENT__SOURCE_ELEMENT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Element</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINK_EVENT__TARGET_ELEMENT = EVENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Created New</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINK_EVENT__CREATED_NEW = EVENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Link Event</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINK_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.TraceEventImpl
	 * <em>Trace Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.TraceEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getTraceEvent()
	 * @generated
	 */
	int TRACE_EVENT = 13;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRACE_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Source Element</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRACE_EVENT__SOURCE_ELEMENT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Element</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRACE_EVENT__TARGET_ELEMENT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRACE_EVENT__FEATURE_NAME = EVENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Trace Event</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRACE_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.NavigatorCreateEventImpl
	 * <em>Navigator Create Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.NavigatorCreateEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getNavigatorCreateEvent()
	 * @generated
	 */
	int NAVIGATOR_CREATE_EVENT = 14;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAVIGATOR_CREATE_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Created Element</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAVIGATOR_CREATE_EVENT__CREATED_ELEMENT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Section</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAVIGATOR_CREATE_EVENT__SOURCE_SECTION = EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAVIGATOR_CREATE_EVENT__DYNAMIC = EVENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Navigator Create Event</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAVIGATOR_CREATE_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.PluginFocusEventImpl
	 * <em>Plugin Focus Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.PluginFocusEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getPluginFocusEvent()
	 * @generated
	 */
	int PLUGIN_FOCUS_EVENT = 15;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PLUGIN_FOCUS_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Plugin Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PLUGIN_FOCUS_EVENT__PLUGIN_ID = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Start Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PLUGIN_FOCUS_EVENT__START_DATE = EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Plugin Focus Event</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PLUGIN_FOCUS_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.impl.PresentationSwitchEventImpl
	 * <em>Presentation Switch Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.PresentationSwitchEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getPresentationSwitchEvent()
	 * @generated
	 */
	int PRESENTATION_SWITCH_EVENT = 16;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_SWITCH_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Read View</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_SWITCH_EVENT__READ_VIEW = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New Presentation</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_SWITCH_EVENT__NEW_PRESENTATION = EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Presentation Switch Event</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_SWITCH_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.UndoEventImpl
	 * <em>Undo Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.UndoEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getUndoEvent()
	 * @generated
	 */
	int UNDO_EVENT = 17;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNDO_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNDO_EVENT__OPERATION = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Undo Event</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNDO_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.ValidateImpl
	 * <em>Validate</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.ValidateImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getValidate()
	 * @generated
	 */
	int VALIDATE = 18;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALIDATE__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The number of structural features of the '<em>Validate</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALIDATE_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.ShowChangesEventImpl
	 * <em>Show Changes Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.ShowChangesEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getShowChangesEvent()
	 * @generated
	 */
	int SHOW_CHANGES_EVENT = 19;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOW_CHANGES_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Source Version</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOW_CHANGES_EVENT__SOURCE_VERSION = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Version</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOW_CHANGES_EVENT__TARGET_VERSION = EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Show Changes Event</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOW_CHANGES_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.NotificationReadEventImpl
	 * <em>Notification Read Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.NotificationReadEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getNotificationReadEvent()
	 * @generated
	 */
	int NOTIFICATION_READ_EVENT = 20;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_READ_EVENT__TIMESTAMP = READ_EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Model Element</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_READ_EVENT__MODEL_ELEMENT = READ_EVENT__MODEL_ELEMENT;

	/**
	 * The feature id for the '<em><b>Source View</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_READ_EVENT__SOURCE_VIEW = READ_EVENT__SOURCE_VIEW;

	/**
	 * The feature id for the '<em><b>Read View</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_READ_EVENT__READ_VIEW = READ_EVENT__READ_VIEW;

	/**
	 * The feature id for the '<em><b>Notification Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_READ_EVENT__NOTIFICATION_ID = READ_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Notification Read Event</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_READ_EVENT_FEATURE_COUNT = READ_EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.impl.NotificationGenerationEventImpl
	 * <em>Notification Generation Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.NotificationGenerationEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getNotificationGenerationEvent()
	 * @generated
	 */
	int NOTIFICATION_GENERATION_EVENT = 21;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_GENERATION_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Notifications</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_GENERATION_EVENT__NOTIFICATIONS = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Notification Generation Event</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_GENERATION_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.impl.NotificationIgnoreEventImpl
	 * <em>Notification Ignore Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.NotificationIgnoreEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getNotificationIgnoreEvent()
	 * @generated
	 */
	int NOTIFICATION_IGNORE_EVENT = 22;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_IGNORE_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Notification Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_IGNORE_EVENT__NOTIFICATION_ID = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Notification Ignore Event</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_IGNORE_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.URLEventImpl
	 * <em>URL Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.URLEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getURLEvent()
	 * @generated
	 */
	int URL_EVENT = 23;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int URL_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Source Model Element</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int URL_EVENT__SOURCE_MODEL_ELEMENT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source View</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int URL_EVENT__SOURCE_VIEW = EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source URL</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int URL_EVENT__SOURCE_URL = EVENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>URL Event</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int URL_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.MergeChoiceEventImpl
	 * <em>Merge Choice Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.MergeChoiceEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getMergeChoiceEvent()
	 * @generated
	 */
	int MERGE_CHOICE_EVENT = 24;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGE_CHOICE_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>My Accepted Changes</b></em>' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGE_CHOICE_EVENT__MY_ACCEPTED_CHANGES = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Their Rejected Changes</b></em>' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGE_CHOICE_EVENT__THEIR_REJECTED_CHANGES = EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Context Model Element</b></em>' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGE_CHOICE_EVENT__CONTEXT_MODEL_ELEMENT = EVENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Selection</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGE_CHOICE_EVENT__SELECTION = EVENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Context Feature</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGE_CHOICE_EVENT__CONTEXT_FEATURE = EVENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Created Issue Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGE_CHOICE_EVENT__CREATED_ISSUE_NAME = EVENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Merge Choice Event</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGE_CHOICE_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.impl.MergeGlobalChoiceEventImpl
	 * <em>Merge Global Choice Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.MergeGlobalChoiceEventImpl
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getMergeGlobalChoiceEvent()
	 * @generated
	 */
	int MERGE_GLOBAL_CHOICE_EVENT = 25;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGE_GLOBAL_CHOICE_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Selection</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGE_GLOBAL_CHOICE_EVENT__SELECTION = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Merge Global Choice Event</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGE_GLOBAL_CHOICE_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.MergeChoiceSelection
	 * <em>Merge Choice Selection</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeChoiceSelection
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getMergeChoiceSelection()
	 * @generated
	 */
	int MERGE_CHOICE_SELECTION = 26;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.events.MergeGlobalChoiceSelection
	 * <em>Merge Global Choice Selection</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeGlobalChoiceSelection
	 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getMergeGlobalChoiceSelection()
	 * @generated
	 */
	int MERGE_GLOBAL_CHOICE_SELECTION = 27;

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.Event <em>Event</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.Event#getTimestamp <em>Timestamp</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Timestamp</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.Event#getTimestamp()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Timestamp();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.ReadEvent
	 * <em>Read Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Read Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.ReadEvent
	 * @generated
	 */
	EClass getReadEvent();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.ReadEvent#getModelElement <em>Model Element</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Model Element</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.ReadEvent#getModelElement()
	 * @see #getReadEvent()
	 * @generated
	 */
	EReference getReadEvent_ModelElement();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.ReadEvent#getSourceView <em>Source View</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Source View</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.ReadEvent#getSourceView()
	 * @see #getReadEvent()
	 * @generated
	 */
	EAttribute getReadEvent_SourceView();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.ReadEvent#getReadView <em>Read View</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Read View</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.ReadEvent#getReadView()
	 * @see #getReadEvent()
	 * @generated
	 */
	EAttribute getReadEvent_ReadView();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.MergeEvent
	 * <em>Merge Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Merge Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeEvent
	 * @generated
	 */
	EClass getMergeEvent();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.MergeEvent#getNumberOfConflicts
	 * <em>Number Of Conflicts</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Number Of Conflicts</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeEvent#getNumberOfConflicts()
	 * @see #getMergeEvent()
	 * @generated
	 */
	EAttribute getMergeEvent_NumberOfConflicts();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.MergeEvent#getTotalTime <em>Total Time</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Total Time</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeEvent#getTotalTime()
	 * @see #getMergeEvent()
	 * @generated
	 */
	EAttribute getMergeEvent_TotalTime();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.MergeEvent#getBaseVersion <em>Base Version</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Base Version</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeEvent#getBaseVersion()
	 * @see #getMergeEvent()
	 * @generated
	 */
	EReference getMergeEvent_BaseVersion();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.MergeEvent#getTargetVersion <em>Target Version</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Target Version</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeEvent#getTargetVersion()
	 * @see #getMergeEvent()
	 * @generated
	 */
	EReference getMergeEvent_TargetVersion();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.MergeEvent#getLocalChanges <em>Local Changes</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Local Changes</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeEvent#getLocalChanges()
	 * @see #getMergeEvent()
	 * @generated
	 */
	EReference getMergeEvent_LocalChanges();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.CheckoutEvent
	 * <em>Checkout Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Checkout Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.CheckoutEvent
	 * @generated
	 */
	EClass getCheckoutEvent();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.CheckoutEvent#getBaseVersion <em>Base Version</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Base Version</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.CheckoutEvent#getBaseVersion()
	 * @see #getCheckoutEvent()
	 * @generated
	 */
	EReference getCheckoutEvent_BaseVersion();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent
	 * <em>Exception Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Exception Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent
	 * @generated
	 */
	EClass getExceptionEvent();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent#getExceptionTitle <em>Exception Title</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Exception Title</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent#getExceptionTitle()
	 * @see #getExceptionEvent()
	 * @generated
	 */
	EAttribute getExceptionEvent_ExceptionTitle();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent#getExceptionStackTrace
	 * <em>Exception Stack Trace</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Exception Stack Trace</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent#getExceptionStackTrace()
	 * @see #getExceptionEvent()
	 * @generated
	 */
	EAttribute getExceptionEvent_ExceptionStackTrace();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent#getExceptionCauseTitle
	 * <em>Exception Cause Title</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Exception Cause Title</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent#getExceptionCauseTitle()
	 * @see #getExceptionEvent()
	 * @generated
	 */
	EAttribute getExceptionEvent_ExceptionCauseTitle();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent#getExceptionCauseStackTrace
	 * <em>Exception Cause Stack Trace</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Exception Cause Stack Trace</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent#getExceptionCauseStackTrace()
	 * @see #getExceptionEvent()
	 * @generated
	 */
	EAttribute getExceptionEvent_ExceptionCauseStackTrace();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.PluginStartEvent
	 * <em>Plugin Start Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Plugin Start Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.PluginStartEvent
	 * @generated
	 */
	EClass getPluginStartEvent();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.PluginStartEvent#getPluginId <em>Plugin Id</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Plugin Id</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.PluginStartEvent#getPluginId()
	 * @see #getPluginStartEvent()
	 * @generated
	 */
	EAttribute getPluginStartEvent_PluginId();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.UpdateEvent
	 * <em>Update Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Update Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.UpdateEvent
	 * @generated
	 */
	EClass getUpdateEvent();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.UpdateEvent#getBaseVersion <em>Base Version</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Base Version</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.UpdateEvent#getBaseVersion()
	 * @see #getUpdateEvent()
	 * @generated
	 */
	EReference getUpdateEvent_BaseVersion();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.UpdateEvent#getTargetVersion <em>Target Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Target Version</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.UpdateEvent#getTargetVersion()
	 * @see #getUpdateEvent()
	 * @generated
	 */
	EReference getUpdateEvent_TargetVersion();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.AnnotationEvent
	 * <em>Annotation Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Annotation Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.AnnotationEvent
	 * @generated
	 */
	EClass getAnnotationEvent();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.AnnotationEvent#getAnnotatedElement
	 * <em>Annotated Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Annotated Element</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.AnnotationEvent#getAnnotatedElement()
	 * @see #getAnnotationEvent()
	 * @generated
	 */
	EReference getAnnotationEvent_AnnotatedElement();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.AnnotationEvent#getAnnotation <em>Annotation</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Annotation</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.AnnotationEvent#getAnnotation()
	 * @see #getAnnotationEvent()
	 * @generated
	 */
	EReference getAnnotationEvent_Annotation();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.RevertEvent
	 * <em>Revert Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Revert Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.RevertEvent
	 * @generated
	 */
	EClass getRevertEvent();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.RevertEvent#getRevertedChangesCount
	 * <em>Reverted Changes Count</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Reverted Changes Count</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.RevertEvent#getRevertedChangesCount()
	 * @see #getRevertEvent()
	 * @generated
	 */
	EAttribute getRevertEvent_RevertedChangesCount();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.ShowHistoryEvent
	 * <em>Show History Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Show History Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.ShowHistoryEvent
	 * @generated
	 */
	EClass getShowHistoryEvent();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.ShowHistoryEvent#getSourceVersion <em>Source Version</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Source Version</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.ShowHistoryEvent#getSourceVersion()
	 * @see #getShowHistoryEvent()
	 * @generated
	 */
	EReference getShowHistoryEvent_SourceVersion();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.ShowHistoryEvent#getTargetVersion <em>Target Version</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Target Version</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.ShowHistoryEvent#getTargetVersion()
	 * @see #getShowHistoryEvent()
	 * @generated
	 */
	EReference getShowHistoryEvent_TargetVersion();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.ShowHistoryEvent#getModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Model Element</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.ShowHistoryEvent#getModelElement()
	 * @see #getShowHistoryEvent()
	 * @generated
	 */
	EReference getShowHistoryEvent_ModelElement();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.PerspectiveEvent
	 * <em>Perspective Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Perspective Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.PerspectiveEvent
	 * @generated
	 */
	EClass getPerspectiveEvent();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.DNDEvent
	 * <em>DND Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>DND Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.DNDEvent
	 * @generated
	 */
	EClass getDNDEvent();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.DNDEvent#getSourceView <em>Source View</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Source View</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.DNDEvent#getSourceView()
	 * @see #getDNDEvent()
	 * @generated
	 */
	EAttribute getDNDEvent_SourceView();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.DNDEvent#getTargetView <em>Target View</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Target View</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.DNDEvent#getTargetView()
	 * @see #getDNDEvent()
	 * @generated
	 */
	EAttribute getDNDEvent_TargetView();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.DNDEvent#getDragSourceElement <em>Drag Source Element</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Drag Source Element</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.DNDEvent#getDragSourceElement()
	 * @see #getDNDEvent()
	 * @generated
	 */
	EReference getDNDEvent_DragSourceElement();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.DNDEvent#getDropTargetElement <em>Drop Target Element</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Drop Target Element</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.DNDEvent#getDropTargetElement()
	 * @see #getDNDEvent()
	 * @generated
	 */
	EReference getDNDEvent_DropTargetElement();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.LinkEvent
	 * <em>Link Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Link Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.LinkEvent
	 * @generated
	 */
	EClass getLinkEvent();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.LinkEvent#getSourceView <em>Source View</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Source View</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.LinkEvent#getSourceView()
	 * @see #getLinkEvent()
	 * @generated
	 */
	EAttribute getLinkEvent_SourceView();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.LinkEvent#getSourceElement <em>Source Element</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Source Element</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.LinkEvent#getSourceElement()
	 * @see #getLinkEvent()
	 * @generated
	 */
	EReference getLinkEvent_SourceElement();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.LinkEvent#getTargetElement <em>Target Element</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Target Element</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.LinkEvent#getTargetElement()
	 * @see #getLinkEvent()
	 * @generated
	 */
	EReference getLinkEvent_TargetElement();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.LinkEvent#isCreatedNew <em>Created New</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Created New</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.LinkEvent#isCreatedNew()
	 * @see #getLinkEvent()
	 * @generated
	 */
	EAttribute getLinkEvent_CreatedNew();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.TraceEvent
	 * <em>Trace Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Trace Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.TraceEvent
	 * @generated
	 */
	EClass getTraceEvent();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.TraceEvent#getSourceElement <em>Source Element</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Source Element</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.TraceEvent#getSourceElement()
	 * @see #getTraceEvent()
	 * @generated
	 */
	EReference getTraceEvent_SourceElement();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.TraceEvent#getTargetElement <em>Target Element</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Target Element</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.TraceEvent#getTargetElement()
	 * @see #getTraceEvent()
	 * @generated
	 */
	EReference getTraceEvent_TargetElement();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.TraceEvent#getFeatureName <em>Feature Name</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.TraceEvent#getFeatureName()
	 * @see #getTraceEvent()
	 * @generated
	 */
	EAttribute getTraceEvent_FeatureName();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.NavigatorCreateEvent
	 * <em>Navigator Create Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Navigator Create Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.NavigatorCreateEvent
	 * @generated
	 */
	EClass getNavigatorCreateEvent();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.NavigatorCreateEvent#getCreatedElement
	 * <em>Created Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Created Element</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.NavigatorCreateEvent#getCreatedElement()
	 * @see #getNavigatorCreateEvent()
	 * @generated
	 */
	EReference getNavigatorCreateEvent_CreatedElement();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.NavigatorCreateEvent#getSourceSection
	 * <em>Source Section</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Source Section</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.NavigatorCreateEvent#getSourceSection()
	 * @see #getNavigatorCreateEvent()
	 * @generated
	 */
	EReference getNavigatorCreateEvent_SourceSection();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.NavigatorCreateEvent#isDynamic <em>Dynamic</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Dynamic</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.NavigatorCreateEvent#isDynamic()
	 * @see #getNavigatorCreateEvent()
	 * @generated
	 */
	EAttribute getNavigatorCreateEvent_Dynamic();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.PluginFocusEvent
	 * <em>Plugin Focus Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Plugin Focus Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.PluginFocusEvent
	 * @generated
	 */
	EClass getPluginFocusEvent();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.PluginFocusEvent#getPluginId <em>Plugin Id</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Plugin Id</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.PluginFocusEvent#getPluginId()
	 * @see #getPluginFocusEvent()
	 * @generated
	 */
	EAttribute getPluginFocusEvent_PluginId();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.PluginFocusEvent#getStartDate <em>Start Date</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Start Date</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.PluginFocusEvent#getStartDate()
	 * @see #getPluginFocusEvent()
	 * @generated
	 */
	EAttribute getPluginFocusEvent_StartDate();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.PresentationSwitchEvent
	 * <em>Presentation Switch Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Presentation Switch Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.PresentationSwitchEvent
	 * @generated
	 */
	EClass getPresentationSwitchEvent();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.PresentationSwitchEvent#getReadView <em>Read View</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Read View</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.PresentationSwitchEvent#getReadView()
	 * @see #getPresentationSwitchEvent()
	 * @generated
	 */
	EAttribute getPresentationSwitchEvent_ReadView();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.PresentationSwitchEvent#getNewPresentation
	 * <em>New Presentation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>New Presentation</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.PresentationSwitchEvent#getNewPresentation()
	 * @see #getPresentationSwitchEvent()
	 * @generated
	 */
	EAttribute getPresentationSwitchEvent_NewPresentation();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.UndoEvent
	 * <em>Undo Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Undo Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.UndoEvent
	 * @generated
	 */
	EClass getUndoEvent();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.UndoEvent#getOperation <em>Operation</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Operation</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.UndoEvent#getOperation()
	 * @see #getUndoEvent()
	 * @generated
	 */
	EReference getUndoEvent_Operation();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.Validate
	 * <em>Validate</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Validate</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.Validate
	 * @generated
	 */
	EClass getValidate();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.ShowChangesEvent
	 * <em>Show Changes Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Show Changes Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.ShowChangesEvent
	 * @generated
	 */
	EClass getShowChangesEvent();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.ShowChangesEvent#getSourceVersion <em>Source Version</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Source Version</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.ShowChangesEvent#getSourceVersion()
	 * @see #getShowChangesEvent()
	 * @generated
	 */
	EReference getShowChangesEvent_SourceVersion();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.ShowChangesEvent#getTargetVersion <em>Target Version</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Target Version</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.ShowChangesEvent#getTargetVersion()
	 * @see #getShowChangesEvent()
	 * @generated
	 */
	EReference getShowChangesEvent_TargetVersion();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.NotificationReadEvent
	 * <em>Notification Read Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Notification Read Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.NotificationReadEvent
	 * @generated
	 */
	EClass getNotificationReadEvent();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.NotificationReadEvent#getNotificationId
	 * <em>Notification Id</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Notification Id</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.NotificationReadEvent#getNotificationId()
	 * @see #getNotificationReadEvent()
	 * @generated
	 */
	EAttribute getNotificationReadEvent_NotificationId();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.NotificationGenerationEvent
	 * <em>Notification Generation Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Notification Generation Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.NotificationGenerationEvent
	 * @generated
	 */
	EClass getNotificationGenerationEvent();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.NotificationGenerationEvent#getNotifications
	 * <em>Notifications</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Notifications</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.NotificationGenerationEvent#getNotifications()
	 * @see #getNotificationGenerationEvent()
	 * @generated
	 */
	EReference getNotificationGenerationEvent_Notifications();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.NotificationIgnoreEvent
	 * <em>Notification Ignore Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Notification Ignore Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.NotificationIgnoreEvent
	 * @generated
	 */
	EClass getNotificationIgnoreEvent();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.NotificationIgnoreEvent#getNotificationId
	 * <em>Notification Id</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Notification Id</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.NotificationIgnoreEvent#getNotificationId()
	 * @see #getNotificationIgnoreEvent()
	 * @generated
	 */
	EAttribute getNotificationIgnoreEvent_NotificationId();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.URLEvent
	 * <em>URL Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>URL Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.URLEvent
	 * @generated
	 */
	EClass getURLEvent();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.URLEvent#getSourceModelElement
	 * <em>Source Model Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Source Model Element</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.URLEvent#getSourceModelElement()
	 * @see #getURLEvent()
	 * @generated
	 */
	EReference getURLEvent_SourceModelElement();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.URLEvent#getSourceView <em>Source View</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Source View</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.URLEvent#getSourceView()
	 * @see #getURLEvent()
	 * @generated
	 */
	EAttribute getURLEvent_SourceView();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.URLEvent#getSourceURL <em>Source URL</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Source URL</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.URLEvent#getSourceURL()
	 * @see #getURLEvent()
	 * @generated
	 */
	EReference getURLEvent_SourceURL();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent
	 * <em>Merge Choice Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Merge Choice Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent
	 * @generated
	 */
	EClass getMergeChoiceEvent();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent#getMyAcceptedChanges
	 * <em>My Accepted Changes</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>My Accepted Changes</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent#getMyAcceptedChanges()
	 * @see #getMergeChoiceEvent()
	 * @generated
	 */
	EReference getMergeChoiceEvent_MyAcceptedChanges();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent#getTheirRejectedChanges
	 * <em>Their Rejected Changes</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Their Rejected Changes</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent#getTheirRejectedChanges()
	 * @see #getMergeChoiceEvent()
	 * @generated
	 */
	EReference getMergeChoiceEvent_TheirRejectedChanges();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent#getContextModelElement
	 * <em>Context Model Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Context Model Element</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent#getContextModelElement()
	 * @see #getMergeChoiceEvent()
	 * @generated
	 */
	EReference getMergeChoiceEvent_ContextModelElement();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent#getSelection <em>Selection</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Selection</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent#getSelection()
	 * @see #getMergeChoiceEvent()
	 * @generated
	 */
	EAttribute getMergeChoiceEvent_Selection();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent#getContextFeature
	 * <em>Context Feature</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Context Feature</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent#getContextFeature()
	 * @see #getMergeChoiceEvent()
	 * @generated
	 */
	EAttribute getMergeChoiceEvent_ContextFeature();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent#getCreatedIssueName
	 * <em>Created Issue Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Created Issue Name</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent#getCreatedIssueName()
	 * @see #getMergeChoiceEvent()
	 * @generated
	 */
	EAttribute getMergeChoiceEvent_CreatedIssueName();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.events.MergeGlobalChoiceEvent
	 * <em>Merge Global Choice Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Merge Global Choice Event</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeGlobalChoiceEvent
	 * @generated
	 */
	EClass getMergeGlobalChoiceEvent();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.MergeGlobalChoiceEvent#getSelection <em>Selection</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Selection</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeGlobalChoiceEvent#getSelection()
	 * @see #getMergeGlobalChoiceEvent()
	 * @generated
	 */
	EAttribute getMergeGlobalChoiceEvent_Selection();

	/**
	 * Returns the meta object for enum '{@link org.unicase.emfstore.esmodel.versioning.events.MergeChoiceSelection
	 * <em>Merge Choice Selection</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Merge Choice Selection</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeChoiceSelection
	 * @generated
	 */
	EEnum getMergeChoiceSelection();

	/**
	 * Returns the meta object for enum '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.MergeGlobalChoiceSelection
	 * <em>Merge Global Choice Selection</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Merge Global Choice Selection</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeGlobalChoiceSelection
	 * @generated
	 */
	EEnum getMergeGlobalChoiceSelection();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EventsFactory getEventsFactory();

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
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.EventImpl
		 * <em>Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>Timestamp</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EVENT__TIMESTAMP = eINSTANCE.getEvent_Timestamp();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.ReadEventImpl
		 * <em>Read Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.ReadEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getReadEvent()
		 * @generated
		 */
		EClass READ_EVENT = eINSTANCE.getReadEvent();

		/**
		 * The meta object literal for the '<em><b>Model Element</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference READ_EVENT__MODEL_ELEMENT = eINSTANCE.getReadEvent_ModelElement();

		/**
		 * The meta object literal for the '<em><b>Source View</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute READ_EVENT__SOURCE_VIEW = eINSTANCE.getReadEvent_SourceView();

		/**
		 * The meta object literal for the '<em><b>Read View</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute READ_EVENT__READ_VIEW = eINSTANCE.getReadEvent_ReadView();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.MergeEventImpl
		 * <em>Merge Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.MergeEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getMergeEvent()
		 * @generated
		 */
		EClass MERGE_EVENT = eINSTANCE.getMergeEvent();

		/**
		 * The meta object literal for the '<em><b>Number Of Conflicts</b></em>' attribute feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MERGE_EVENT__NUMBER_OF_CONFLICTS = eINSTANCE.getMergeEvent_NumberOfConflicts();

		/**
		 * The meta object literal for the '<em><b>Total Time</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MERGE_EVENT__TOTAL_TIME = eINSTANCE.getMergeEvent_TotalTime();

		/**
		 * The meta object literal for the '<em><b>Base Version</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MERGE_EVENT__BASE_VERSION = eINSTANCE.getMergeEvent_BaseVersion();

		/**
		 * The meta object literal for the '<em><b>Target Version</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MERGE_EVENT__TARGET_VERSION = eINSTANCE.getMergeEvent_TargetVersion();

		/**
		 * The meta object literal for the '<em><b>Local Changes</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MERGE_EVENT__LOCAL_CHANGES = eINSTANCE.getMergeEvent_LocalChanges();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.emfstore.esmodel.versioning.events.impl.CheckoutEventImpl <em>Checkout Event</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.CheckoutEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getCheckoutEvent()
		 * @generated
		 */
		EClass CHECKOUT_EVENT = eINSTANCE.getCheckoutEvent();

		/**
		 * The meta object literal for the '<em><b>Base Version</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CHECKOUT_EVENT__BASE_VERSION = eINSTANCE.getCheckoutEvent_BaseVersion();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.emfstore.esmodel.versioning.events.impl.ExceptionEventImpl <em>Exception Event</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.ExceptionEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getExceptionEvent()
		 * @generated
		 */
		EClass EXCEPTION_EVENT = eINSTANCE.getExceptionEvent();

		/**
		 * The meta object literal for the '<em><b>Exception Title</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EXCEPTION_EVENT__EXCEPTION_TITLE = eINSTANCE.getExceptionEvent_ExceptionTitle();

		/**
		 * The meta object literal for the '<em><b>Exception Stack Trace</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EXCEPTION_EVENT__EXCEPTION_STACK_TRACE = eINSTANCE.getExceptionEvent_ExceptionStackTrace();

		/**
		 * The meta object literal for the '<em><b>Exception Cause Title</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EXCEPTION_EVENT__EXCEPTION_CAUSE_TITLE = eINSTANCE.getExceptionEvent_ExceptionCauseTitle();

		/**
		 * The meta object literal for the '<em><b>Exception Cause Stack Trace</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EXCEPTION_EVENT__EXCEPTION_CAUSE_STACK_TRACE = eINSTANCE
			.getExceptionEvent_ExceptionCauseStackTrace();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.emfstore.esmodel.versioning.events.impl.PluginStartEventImpl <em>Plugin Start Event</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.PluginStartEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getPluginStartEvent()
		 * @generated
		 */
		EClass PLUGIN_START_EVENT = eINSTANCE.getPluginStartEvent();

		/**
		 * The meta object literal for the '<em><b>Plugin Id</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PLUGIN_START_EVENT__PLUGIN_ID = eINSTANCE.getPluginStartEvent_PluginId();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.UpdateEventImpl
		 * <em>Update Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.UpdateEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getUpdateEvent()
		 * @generated
		 */
		EClass UPDATE_EVENT = eINSTANCE.getUpdateEvent();

		/**
		 * The meta object literal for the '<em><b>Base Version</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference UPDATE_EVENT__BASE_VERSION = eINSTANCE.getUpdateEvent_BaseVersion();

		/**
		 * The meta object literal for the '<em><b>Target Version</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference UPDATE_EVENT__TARGET_VERSION = eINSTANCE.getUpdateEvent_TargetVersion();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.emfstore.esmodel.versioning.events.impl.AnnotationEventImpl <em>Annotation Event</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.AnnotationEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getAnnotationEvent()
		 * @generated
		 */
		EClass ANNOTATION_EVENT = eINSTANCE.getAnnotationEvent();

		/**
		 * The meta object literal for the '<em><b>Annotated Element</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ANNOTATION_EVENT__ANNOTATED_ELEMENT = eINSTANCE.getAnnotationEvent_AnnotatedElement();

		/**
		 * The meta object literal for the '<em><b>Annotation</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ANNOTATION_EVENT__ANNOTATION = eINSTANCE.getAnnotationEvent_Annotation();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.RevertEventImpl
		 * <em>Revert Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.RevertEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getRevertEvent()
		 * @generated
		 */
		EClass REVERT_EVENT = eINSTANCE.getRevertEvent();

		/**
		 * The meta object literal for the '<em><b>Reverted Changes Count</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REVERT_EVENT__REVERTED_CHANGES_COUNT = eINSTANCE.getRevertEvent_RevertedChangesCount();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.emfstore.esmodel.versioning.events.impl.ShowHistoryEventImpl <em>Show History Event</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.ShowHistoryEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getShowHistoryEvent()
		 * @generated
		 */
		EClass SHOW_HISTORY_EVENT = eINSTANCE.getShowHistoryEvent();

		/**
		 * The meta object literal for the '<em><b>Source Version</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SHOW_HISTORY_EVENT__SOURCE_VERSION = eINSTANCE.getShowHistoryEvent_SourceVersion();

		/**
		 * The meta object literal for the '<em><b>Target Version</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SHOW_HISTORY_EVENT__TARGET_VERSION = eINSTANCE.getShowHistoryEvent_TargetVersion();

		/**
		 * The meta object literal for the '<em><b>Model Element</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SHOW_HISTORY_EVENT__MODEL_ELEMENT = eINSTANCE.getShowHistoryEvent_ModelElement();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.emfstore.esmodel.versioning.events.impl.PerspectiveEventImpl <em>Perspective Event</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.PerspectiveEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getPerspectiveEvent()
		 * @generated
		 */
		EClass PERSPECTIVE_EVENT = eINSTANCE.getPerspectiveEvent();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.DNDEventImpl
		 * <em>DND Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.DNDEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getDNDEvent()
		 * @generated
		 */
		EClass DND_EVENT = eINSTANCE.getDNDEvent();

		/**
		 * The meta object literal for the '<em><b>Source View</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DND_EVENT__SOURCE_VIEW = eINSTANCE.getDNDEvent_SourceView();

		/**
		 * The meta object literal for the '<em><b>Target View</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DND_EVENT__TARGET_VIEW = eINSTANCE.getDNDEvent_TargetView();

		/**
		 * The meta object literal for the '<em><b>Drag Source Element</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DND_EVENT__DRAG_SOURCE_ELEMENT = eINSTANCE.getDNDEvent_DragSourceElement();

		/**
		 * The meta object literal for the '<em><b>Drop Target Element</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DND_EVENT__DROP_TARGET_ELEMENT = eINSTANCE.getDNDEvent_DropTargetElement();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.LinkEventImpl
		 * <em>Link Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.LinkEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getLinkEvent()
		 * @generated
		 */
		EClass LINK_EVENT = eINSTANCE.getLinkEvent();

		/**
		 * The meta object literal for the '<em><b>Source View</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LINK_EVENT__SOURCE_VIEW = eINSTANCE.getLinkEvent_SourceView();

		/**
		 * The meta object literal for the '<em><b>Source Element</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LINK_EVENT__SOURCE_ELEMENT = eINSTANCE.getLinkEvent_SourceElement();

		/**
		 * The meta object literal for the '<em><b>Target Element</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LINK_EVENT__TARGET_ELEMENT = eINSTANCE.getLinkEvent_TargetElement();

		/**
		 * The meta object literal for the '<em><b>Created New</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LINK_EVENT__CREATED_NEW = eINSTANCE.getLinkEvent_CreatedNew();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.TraceEventImpl
		 * <em>Trace Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.TraceEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getTraceEvent()
		 * @generated
		 */
		EClass TRACE_EVENT = eINSTANCE.getTraceEvent();

		/**
		 * The meta object literal for the '<em><b>Source Element</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TRACE_EVENT__SOURCE_ELEMENT = eINSTANCE.getTraceEvent_SourceElement();

		/**
		 * The meta object literal for the '<em><b>Target Element</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TRACE_EVENT__TARGET_ELEMENT = eINSTANCE.getTraceEvent_TargetElement();

		/**
		 * The meta object literal for the '<em><b>Feature Name</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TRACE_EVENT__FEATURE_NAME = eINSTANCE.getTraceEvent_FeatureName();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.emfstore.esmodel.versioning.events.impl.NavigatorCreateEventImpl
		 * <em>Navigator Create Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.NavigatorCreateEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getNavigatorCreateEvent()
		 * @generated
		 */
		EClass NAVIGATOR_CREATE_EVENT = eINSTANCE.getNavigatorCreateEvent();

		/**
		 * The meta object literal for the '<em><b>Created Element</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference NAVIGATOR_CREATE_EVENT__CREATED_ELEMENT = eINSTANCE.getNavigatorCreateEvent_CreatedElement();

		/**
		 * The meta object literal for the '<em><b>Source Section</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference NAVIGATOR_CREATE_EVENT__SOURCE_SECTION = eINSTANCE.getNavigatorCreateEvent_SourceSection();

		/**
		 * The meta object literal for the '<em><b>Dynamic</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute NAVIGATOR_CREATE_EVENT__DYNAMIC = eINSTANCE.getNavigatorCreateEvent_Dynamic();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.emfstore.esmodel.versioning.events.impl.PluginFocusEventImpl <em>Plugin Focus Event</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.PluginFocusEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getPluginFocusEvent()
		 * @generated
		 */
		EClass PLUGIN_FOCUS_EVENT = eINSTANCE.getPluginFocusEvent();

		/**
		 * The meta object literal for the '<em><b>Plugin Id</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PLUGIN_FOCUS_EVENT__PLUGIN_ID = eINSTANCE.getPluginFocusEvent_PluginId();

		/**
		 * The meta object literal for the '<em><b>Start Date</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PLUGIN_FOCUS_EVENT__START_DATE = eINSTANCE.getPluginFocusEvent_StartDate();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.emfstore.esmodel.versioning.events.impl.PresentationSwitchEventImpl
		 * <em>Presentation Switch Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.PresentationSwitchEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getPresentationSwitchEvent()
		 * @generated
		 */
		EClass PRESENTATION_SWITCH_EVENT = eINSTANCE.getPresentationSwitchEvent();

		/**
		 * The meta object literal for the '<em><b>Read View</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PRESENTATION_SWITCH_EVENT__READ_VIEW = eINSTANCE.getPresentationSwitchEvent_ReadView();

		/**
		 * The meta object literal for the '<em><b>New Presentation</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PRESENTATION_SWITCH_EVENT__NEW_PRESENTATION = eINSTANCE.getPresentationSwitchEvent_NewPresentation();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.UndoEventImpl
		 * <em>Undo Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.UndoEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getUndoEvent()
		 * @generated
		 */
		EClass UNDO_EVENT = eINSTANCE.getUndoEvent();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference UNDO_EVENT__OPERATION = eINSTANCE.getUndoEvent_Operation();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.ValidateImpl
		 * <em>Validate</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.ValidateImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getValidate()
		 * @generated
		 */
		EClass VALIDATE = eINSTANCE.getValidate();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.emfstore.esmodel.versioning.events.impl.ShowChangesEventImpl <em>Show Changes Event</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.ShowChangesEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getShowChangesEvent()
		 * @generated
		 */
		EClass SHOW_CHANGES_EVENT = eINSTANCE.getShowChangesEvent();

		/**
		 * The meta object literal for the '<em><b>Source Version</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SHOW_CHANGES_EVENT__SOURCE_VERSION = eINSTANCE.getShowChangesEvent_SourceVersion();

		/**
		 * The meta object literal for the '<em><b>Target Version</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SHOW_CHANGES_EVENT__TARGET_VERSION = eINSTANCE.getShowChangesEvent_TargetVersion();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.emfstore.esmodel.versioning.events.impl.NotificationReadEventImpl
		 * <em>Notification Read Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.NotificationReadEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getNotificationReadEvent()
		 * @generated
		 */
		EClass NOTIFICATION_READ_EVENT = eINSTANCE.getNotificationReadEvent();

		/**
		 * The meta object literal for the '<em><b>Notification Id</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute NOTIFICATION_READ_EVENT__NOTIFICATION_ID = eINSTANCE.getNotificationReadEvent_NotificationId();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.emfstore.esmodel.versioning.events.impl.NotificationGenerationEventImpl
		 * <em>Notification Generation Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.NotificationGenerationEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getNotificationGenerationEvent()
		 * @generated
		 */
		EClass NOTIFICATION_GENERATION_EVENT = eINSTANCE.getNotificationGenerationEvent();

		/**
		 * The meta object literal for the '<em><b>Notifications</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference NOTIFICATION_GENERATION_EVENT__NOTIFICATIONS = eINSTANCE
			.getNotificationGenerationEvent_Notifications();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.emfstore.esmodel.versioning.events.impl.NotificationIgnoreEventImpl
		 * <em>Notification Ignore Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.NotificationIgnoreEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getNotificationIgnoreEvent()
		 * @generated
		 */
		EClass NOTIFICATION_IGNORE_EVENT = eINSTANCE.getNotificationIgnoreEvent();

		/**
		 * The meta object literal for the '<em><b>Notification Id</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute NOTIFICATION_IGNORE_EVENT__NOTIFICATION_ID = eINSTANCE.getNotificationIgnoreEvent_NotificationId();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.events.impl.URLEventImpl
		 * <em>URL Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.URLEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getURLEvent()
		 * @generated
		 */
		EClass URL_EVENT = eINSTANCE.getURLEvent();

		/**
		 * The meta object literal for the '<em><b>Source Model Element</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference URL_EVENT__SOURCE_MODEL_ELEMENT = eINSTANCE.getURLEvent_SourceModelElement();

		/**
		 * The meta object literal for the '<em><b>Source View</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute URL_EVENT__SOURCE_VIEW = eINSTANCE.getURLEvent_SourceView();

		/**
		 * The meta object literal for the '<em><b>Source URL</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference URL_EVENT__SOURCE_URL = eINSTANCE.getURLEvent_SourceURL();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.emfstore.esmodel.versioning.events.impl.MergeChoiceEventImpl <em>Merge Choice Event</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.MergeChoiceEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getMergeChoiceEvent()
		 * @generated
		 */
		EClass MERGE_CHOICE_EVENT = eINSTANCE.getMergeChoiceEvent();

		/**
		 * The meta object literal for the '<em><b>My Accepted Changes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MERGE_CHOICE_EVENT__MY_ACCEPTED_CHANGES = eINSTANCE.getMergeChoiceEvent_MyAcceptedChanges();

		/**
		 * The meta object literal for the '<em><b>Their Rejected Changes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MERGE_CHOICE_EVENT__THEIR_REJECTED_CHANGES = eINSTANCE.getMergeChoiceEvent_TheirRejectedChanges();

		/**
		 * The meta object literal for the '<em><b>Context Model Element</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MERGE_CHOICE_EVENT__CONTEXT_MODEL_ELEMENT = eINSTANCE.getMergeChoiceEvent_ContextModelElement();

		/**
		 * The meta object literal for the '<em><b>Selection</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MERGE_CHOICE_EVENT__SELECTION = eINSTANCE.getMergeChoiceEvent_Selection();

		/**
		 * The meta object literal for the '<em><b>Context Feature</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MERGE_CHOICE_EVENT__CONTEXT_FEATURE = eINSTANCE.getMergeChoiceEvent_ContextFeature();

		/**
		 * The meta object literal for the '<em><b>Created Issue Name</b></em>' attribute feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MERGE_CHOICE_EVENT__CREATED_ISSUE_NAME = eINSTANCE.getMergeChoiceEvent_CreatedIssueName();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.emfstore.esmodel.versioning.events.impl.MergeGlobalChoiceEventImpl
		 * <em>Merge Global Choice Event</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.MergeGlobalChoiceEventImpl
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getMergeGlobalChoiceEvent()
		 * @generated
		 */
		EClass MERGE_GLOBAL_CHOICE_EVENT = eINSTANCE.getMergeGlobalChoiceEvent();

		/**
		 * The meta object literal for the '<em><b>Selection</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MERGE_GLOBAL_CHOICE_EVENT__SELECTION = eINSTANCE.getMergeGlobalChoiceEvent_Selection();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.events.MergeChoiceSelection
		 * <em>Merge Choice Selection</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.MergeChoiceSelection
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getMergeChoiceSelection()
		 * @generated
		 */
		EEnum MERGE_CHOICE_SELECTION = eINSTANCE.getMergeChoiceSelection();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.emfstore.esmodel.versioning.events.MergeGlobalChoiceSelection
		 * <em>Merge Global Choice Selection</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.events.MergeGlobalChoiceSelection
		 * @see org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl#getMergeGlobalChoiceSelection()
		 * @generated
		 */
		EEnum MERGE_GLOBAL_CHOICE_SELECTION = eINSTANCE.getMergeGlobalChoiceSelection();

	}

} // EventsPackage
