/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.events.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.server.model.versioning.events.*;
import org.eclipse.emf.emfstore.server.model.versioning.events.AnnotationEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.CheckoutEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.DNDEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.Event;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.events.ExceptionEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.LinkEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.MergeChoiceEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.MergeEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.MergeGlobalChoiceEvent;
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
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage
 * @generated
 */
public class EventsSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static EventsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EventsSwitch() {
		if (modelPackage == null) {
			modelPackage = EventsPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EventsPackage.EVENT: {
				Event event = (Event)theEObject;
				T result = caseEvent(event);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.READ_EVENT: {
				ReadEvent readEvent = (ReadEvent)theEObject;
				T result = caseReadEvent(readEvent);
				if (result == null) result = caseEvent(readEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.MERGE_EVENT: {
				MergeEvent mergeEvent = (MergeEvent)theEObject;
				T result = caseMergeEvent(mergeEvent);
				if (result == null) result = caseEvent(mergeEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.CHECKOUT_EVENT: {
				CheckoutEvent checkoutEvent = (CheckoutEvent)theEObject;
				T result = caseCheckoutEvent(checkoutEvent);
				if (result == null) result = caseEvent(checkoutEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.EXCEPTION_EVENT: {
				ExceptionEvent exceptionEvent = (ExceptionEvent)theEObject;
				T result = caseExceptionEvent(exceptionEvent);
				if (result == null) result = caseEvent(exceptionEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.PLUGIN_START_EVENT: {
				PluginStartEvent pluginStartEvent = (PluginStartEvent)theEObject;
				T result = casePluginStartEvent(pluginStartEvent);
				if (result == null) result = caseEvent(pluginStartEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.UPDATE_EVENT: {
				UpdateEvent updateEvent = (UpdateEvent)theEObject;
				T result = caseUpdateEvent(updateEvent);
				if (result == null) result = caseEvent(updateEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.ANNOTATION_EVENT: {
				AnnotationEvent annotationEvent = (AnnotationEvent)theEObject;
				T result = caseAnnotationEvent(annotationEvent);
				if (result == null) result = caseEvent(annotationEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.REVERT_EVENT: {
				RevertEvent revertEvent = (RevertEvent)theEObject;
				T result = caseRevertEvent(revertEvent);
				if (result == null) result = caseEvent(revertEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.SHOW_HISTORY_EVENT: {
				ShowHistoryEvent showHistoryEvent = (ShowHistoryEvent)theEObject;
				T result = caseShowHistoryEvent(showHistoryEvent);
				if (result == null) result = caseEvent(showHistoryEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.PERSPECTIVE_EVENT: {
				PerspectiveEvent perspectiveEvent = (PerspectiveEvent)theEObject;
				T result = casePerspectiveEvent(perspectiveEvent);
				if (result == null) result = caseEvent(perspectiveEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.DND_EVENT: {
				DNDEvent dndEvent = (DNDEvent)theEObject;
				T result = caseDNDEvent(dndEvent);
				if (result == null) result = caseEvent(dndEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.LINK_EVENT: {
				LinkEvent linkEvent = (LinkEvent)theEObject;
				T result = caseLinkEvent(linkEvent);
				if (result == null) result = caseEvent(linkEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.TRACE_EVENT: {
				TraceEvent traceEvent = (TraceEvent)theEObject;
				T result = caseTraceEvent(traceEvent);
				if (result == null) result = caseEvent(traceEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.NAVIGATOR_CREATE_EVENT: {
				NavigatorCreateEvent navigatorCreateEvent = (NavigatorCreateEvent)theEObject;
				T result = caseNavigatorCreateEvent(navigatorCreateEvent);
				if (result == null) result = caseEvent(navigatorCreateEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.PLUGIN_FOCUS_EVENT: {
				PluginFocusEvent pluginFocusEvent = (PluginFocusEvent)theEObject;
				T result = casePluginFocusEvent(pluginFocusEvent);
				if (result == null) result = caseEvent(pluginFocusEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.PRESENTATION_SWITCH_EVENT: {
				PresentationSwitchEvent presentationSwitchEvent = (PresentationSwitchEvent)theEObject;
				T result = casePresentationSwitchEvent(presentationSwitchEvent);
				if (result == null) result = caseEvent(presentationSwitchEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.UNDO_EVENT: {
				UndoEvent undoEvent = (UndoEvent)theEObject;
				T result = caseUndoEvent(undoEvent);
				if (result == null) result = caseEvent(undoEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.VALIDATE: {
				Validate validate = (Validate)theEObject;
				T result = caseValidate(validate);
				if (result == null) result = caseEvent(validate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.SHOW_CHANGES_EVENT: {
				ShowChangesEvent showChangesEvent = (ShowChangesEvent)theEObject;
				T result = caseShowChangesEvent(showChangesEvent);
				if (result == null) result = caseEvent(showChangesEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.NOTIFICATION_READ_EVENT: {
				NotificationReadEvent notificationReadEvent = (NotificationReadEvent)theEObject;
				T result = caseNotificationReadEvent(notificationReadEvent);
				if (result == null) result = caseReadEvent(notificationReadEvent);
				if (result == null) result = caseEvent(notificationReadEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.NOTIFICATION_GENERATION_EVENT: {
				NotificationGenerationEvent notificationGenerationEvent = (NotificationGenerationEvent)theEObject;
				T result = caseNotificationGenerationEvent(notificationGenerationEvent);
				if (result == null) result = caseEvent(notificationGenerationEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.NOTIFICATION_IGNORE_EVENT: {
				NotificationIgnoreEvent notificationIgnoreEvent = (NotificationIgnoreEvent)theEObject;
				T result = caseNotificationIgnoreEvent(notificationIgnoreEvent);
				if (result == null) result = caseEvent(notificationIgnoreEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.URL_EVENT: {
				URLEvent urlEvent = (URLEvent)theEObject;
				T result = caseURLEvent(urlEvent);
				if (result == null) result = caseEvent(urlEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.MERGE_CHOICE_EVENT: {
				MergeChoiceEvent mergeChoiceEvent = (MergeChoiceEvent)theEObject;
				T result = caseMergeChoiceEvent(mergeChoiceEvent);
				if (result == null) result = caseEvent(mergeChoiceEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.MERGE_GLOBAL_CHOICE_EVENT: {
				MergeGlobalChoiceEvent mergeGlobalChoiceEvent = (MergeGlobalChoiceEvent)theEObject;
				T result = caseMergeGlobalChoiceEvent(mergeGlobalChoiceEvent);
				if (result == null) result = caseEvent(mergeGlobalChoiceEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvent(Event object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Read Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Read Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReadEvent(ReadEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Merge Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Merge Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMergeEvent(MergeEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Checkout Event</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Checkout Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCheckoutEvent(CheckoutEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exception Event</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exception Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExceptionEvent(ExceptionEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Plugin Start Event</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plugin Start Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePluginStartEvent(PluginStartEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdateEvent(UpdateEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation Event</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotationEvent(AnnotationEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Revert Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Revert Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRevertEvent(RevertEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Show History Event</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Show History Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShowHistoryEvent(ShowHistoryEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Perspective Event</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Perspective Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePerspectiveEvent(PerspectiveEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DND Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DND Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDNDEvent(DNDEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinkEvent(LinkEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trace Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceEvent(TraceEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Navigator Create Event</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigator Create Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNavigatorCreateEvent(NavigatorCreateEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Plugin Focus Event</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plugin Focus Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePluginFocusEvent(PluginFocusEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Presentation Switch Event</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Presentation Switch Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePresentationSwitchEvent(PresentationSwitchEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Undo Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Undo Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUndoEvent(UndoEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Validate</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Validate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValidate(Validate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Show Changes Event</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Show Changes Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShowChangesEvent(ShowChangesEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Notification Read Event</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Notification Read Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotificationReadEvent(NotificationReadEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Notification Generation Event</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Notification Generation Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotificationGenerationEvent(NotificationGenerationEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Notification Ignore Event</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Notification Ignore Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotificationIgnoreEvent(NotificationIgnoreEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>URL Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>URL Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseURLEvent(URLEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Merge Choice Event</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Merge Choice Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMergeChoiceEvent(MergeChoiceEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Merge Global Choice Event</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Merge Global Choice Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMergeGlobalChoiceEvent(MergeGlobalChoiceEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch, but this is the last case
	 * anyway. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} // EventsSwitch
