/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.events.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.emfstore.server.model.versioning.events.*;
import org.eclipse.emf.emfstore.server.model.versioning.events.AnnotationEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.CheckoutEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.DNDEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.Event;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsFactory;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.events.ExceptionEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.LinkEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.MergeChoiceEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.MergeChoiceSelection;
import org.eclipse.emf.emfstore.server.model.versioning.events.MergeEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.MergeGlobalChoiceEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.MergeGlobalChoiceSelection;
import org.eclipse.emf.emfstore.server.model.versioning.events.NavigatorCreateEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.NotificationGenerationEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.NotificationIgnoreEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.NotificationReadEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.PerspectiveEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.PluginFocusEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.PluginStartEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.PresentationSwitchEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.ReadEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.RevertEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.ShowChangesEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.ShowHistoryEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.TraceEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.URLEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.UndoEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.UpdateEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.Validate;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class EventsFactoryImpl extends EFactoryImpl implements EventsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static EventsFactory init() {
		try {
			EventsFactory theEventsFactory = (EventsFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/emf/emfstore/server/model/versioning/events"); 
			if (theEventsFactory != null) {
				return theEventsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EventsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EventsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EventsPackage.EVENT: return createEvent();
			case EventsPackage.READ_EVENT: return createReadEvent();
			case EventsPackage.MERGE_EVENT: return createMergeEvent();
			case EventsPackage.CHECKOUT_EVENT: return createCheckoutEvent();
			case EventsPackage.EXCEPTION_EVENT: return createExceptionEvent();
			case EventsPackage.PLUGIN_START_EVENT: return createPluginStartEvent();
			case EventsPackage.UPDATE_EVENT: return createUpdateEvent();
			case EventsPackage.ANNOTATION_EVENT: return createAnnotationEvent();
			case EventsPackage.REVERT_EVENT: return createRevertEvent();
			case EventsPackage.SHOW_HISTORY_EVENT: return createShowHistoryEvent();
			case EventsPackage.PERSPECTIVE_EVENT: return createPerspectiveEvent();
			case EventsPackage.DND_EVENT: return createDNDEvent();
			case EventsPackage.LINK_EVENT: return createLinkEvent();
			case EventsPackage.TRACE_EVENT: return createTraceEvent();
			case EventsPackage.NAVIGATOR_CREATE_EVENT: return createNavigatorCreateEvent();
			case EventsPackage.PLUGIN_FOCUS_EVENT: return createPluginFocusEvent();
			case EventsPackage.PRESENTATION_SWITCH_EVENT: return createPresentationSwitchEvent();
			case EventsPackage.UNDO_EVENT: return createUndoEvent();
			case EventsPackage.VALIDATE: return createValidate();
			case EventsPackage.SHOW_CHANGES_EVENT: return createShowChangesEvent();
			case EventsPackage.NOTIFICATION_READ_EVENT: return createNotificationReadEvent();
			case EventsPackage.NOTIFICATION_GENERATION_EVENT: return createNotificationGenerationEvent();
			case EventsPackage.NOTIFICATION_IGNORE_EVENT: return createNotificationIgnoreEvent();
			case EventsPackage.URL_EVENT: return createURLEvent();
			case EventsPackage.MERGE_CHOICE_EVENT: return createMergeChoiceEvent();
			case EventsPackage.MERGE_GLOBAL_CHOICE_EVENT: return createMergeGlobalChoiceEvent();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case EventsPackage.MERGE_CHOICE_SELECTION:
				return createMergeChoiceSelectionFromString(eDataType, initialValue);
			case EventsPackage.MERGE_GLOBAL_CHOICE_SELECTION:
				return createMergeGlobalChoiceSelectionFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case EventsPackage.MERGE_CHOICE_SELECTION:
				return convertMergeChoiceSelectionToString(eDataType, instanceValue);
			case EventsPackage.MERGE_GLOBAL_CHOICE_SELECTION:
				return convertMergeGlobalChoiceSelectionToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Event createEvent() {
		EventImpl event = new EventImpl();
		return event;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ReadEvent createReadEvent() {
		ReadEventImpl readEvent = new ReadEventImpl();
		return readEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MergeEvent createMergeEvent() {
		MergeEventImpl mergeEvent = new MergeEventImpl();
		return mergeEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CheckoutEvent createCheckoutEvent() {
		CheckoutEventImpl checkoutEvent = new CheckoutEventImpl();
		return checkoutEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExceptionEvent createExceptionEvent() {
		ExceptionEventImpl exceptionEvent = new ExceptionEventImpl();
		return exceptionEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PluginStartEvent createPluginStartEvent() {
		PluginStartEventImpl pluginStartEvent = new PluginStartEventImpl();
		return pluginStartEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UpdateEvent createUpdateEvent() {
		UpdateEventImpl updateEvent = new UpdateEventImpl();
		return updateEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationEvent createAnnotationEvent() {
		AnnotationEventImpl annotationEvent = new AnnotationEventImpl();
		return annotationEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RevertEvent createRevertEvent() {
		RevertEventImpl revertEvent = new RevertEventImpl();
		return revertEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ShowHistoryEvent createShowHistoryEvent() {
		ShowHistoryEventImpl showHistoryEvent = new ShowHistoryEventImpl();
		return showHistoryEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PerspectiveEvent createPerspectiveEvent() {
		PerspectiveEventImpl perspectiveEvent = new PerspectiveEventImpl();
		return perspectiveEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DNDEvent createDNDEvent() {
		DNDEventImpl dndEvent = new DNDEventImpl();
		return dndEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinkEvent createLinkEvent() {
		LinkEventImpl linkEvent = new LinkEventImpl();
		return linkEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TraceEvent createTraceEvent() {
		TraceEventImpl traceEvent = new TraceEventImpl();
		return traceEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NavigatorCreateEvent createNavigatorCreateEvent() {
		NavigatorCreateEventImpl navigatorCreateEvent = new NavigatorCreateEventImpl();
		return navigatorCreateEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PluginFocusEvent createPluginFocusEvent() {
		PluginFocusEventImpl pluginFocusEvent = new PluginFocusEventImpl();
		return pluginFocusEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PresentationSwitchEvent createPresentationSwitchEvent() {
		PresentationSwitchEventImpl presentationSwitchEvent = new PresentationSwitchEventImpl();
		return presentationSwitchEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UndoEvent createUndoEvent() {
		UndoEventImpl undoEvent = new UndoEventImpl();
		return undoEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Validate createValidate() {
		ValidateImpl validate = new ValidateImpl();
		return validate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ShowChangesEvent createShowChangesEvent() {
		ShowChangesEventImpl showChangesEvent = new ShowChangesEventImpl();
		return showChangesEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationReadEvent createNotificationReadEvent() {
		NotificationReadEventImpl notificationReadEvent = new NotificationReadEventImpl();
		return notificationReadEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationGenerationEvent createNotificationGenerationEvent() {
		NotificationGenerationEventImpl notificationGenerationEvent = new NotificationGenerationEventImpl();
		return notificationGenerationEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationIgnoreEvent createNotificationIgnoreEvent() {
		NotificationIgnoreEventImpl notificationIgnoreEvent = new NotificationIgnoreEventImpl();
		return notificationIgnoreEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public URLEvent createURLEvent() {
		URLEventImpl urlEvent = new URLEventImpl();
		return urlEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MergeChoiceEvent createMergeChoiceEvent() {
		MergeChoiceEventImpl mergeChoiceEvent = new MergeChoiceEventImpl();
		return mergeChoiceEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MergeGlobalChoiceEvent createMergeGlobalChoiceEvent() {
		MergeGlobalChoiceEventImpl mergeGlobalChoiceEvent = new MergeGlobalChoiceEventImpl();
		return mergeGlobalChoiceEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MergeChoiceSelection createMergeChoiceSelectionFromString(EDataType eDataType, String initialValue) {
		MergeChoiceSelection result = MergeChoiceSelection.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMergeChoiceSelectionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MergeGlobalChoiceSelection createMergeGlobalChoiceSelectionFromString(EDataType eDataType,
		String initialValue) {
		MergeGlobalChoiceSelection result = MergeGlobalChoiceSelection.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMergeGlobalChoiceSelectionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EventsPackage getEventsPackage() {
		return (EventsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EventsPackage getPackage() {
		return EventsPackage.eINSTANCE;
	}

} // EventsFactoryImpl
