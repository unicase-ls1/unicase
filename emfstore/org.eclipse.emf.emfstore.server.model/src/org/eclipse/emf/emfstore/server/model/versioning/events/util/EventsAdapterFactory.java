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
package org.eclipse.emf.emfstore.server.model.versioning.events.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
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
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage
 * @generated
 */
public class EventsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static EventsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EventsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EventsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc --> This
	 * implementation returns <code>true</code> if the object is either the model's package or is an instance object of
	 * the model. <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EventsSwitch<Adapter> modelSwitch = new EventsSwitch<Adapter>() {
			@Override
			public Adapter caseEvent(Event object) {
				return createEventAdapter();
			}
			@Override
			public Adapter caseReadEvent(ReadEvent object) {
				return createReadEventAdapter();
			}
			@Override
			public Adapter caseMergeEvent(MergeEvent object) {
				return createMergeEventAdapter();
			}
			@Override
			public Adapter caseCheckoutEvent(CheckoutEvent object) {
				return createCheckoutEventAdapter();
			}
			@Override
			public Adapter caseExceptionEvent(ExceptionEvent object) {
				return createExceptionEventAdapter();
			}
			@Override
			public Adapter casePluginStartEvent(PluginStartEvent object) {
				return createPluginStartEventAdapter();
			}
			@Override
			public Adapter caseUpdateEvent(UpdateEvent object) {
				return createUpdateEventAdapter();
			}
			@Override
			public Adapter caseAnnotationEvent(AnnotationEvent object) {
				return createAnnotationEventAdapter();
			}
			@Override
			public Adapter caseRevertEvent(RevertEvent object) {
				return createRevertEventAdapter();
			}
			@Override
			public Adapter caseShowHistoryEvent(ShowHistoryEvent object) {
				return createShowHistoryEventAdapter();
			}
			@Override
			public Adapter casePerspectiveEvent(PerspectiveEvent object) {
				return createPerspectiveEventAdapter();
			}
			@Override
			public Adapter caseDNDEvent(DNDEvent object) {
				return createDNDEventAdapter();
			}
			@Override
			public Adapter caseLinkEvent(LinkEvent object) {
				return createLinkEventAdapter();
			}
			@Override
			public Adapter caseTraceEvent(TraceEvent object) {
				return createTraceEventAdapter();
			}
			@Override
			public Adapter caseNavigatorCreateEvent(NavigatorCreateEvent object) {
				return createNavigatorCreateEventAdapter();
			}
			@Override
			public Adapter casePluginFocusEvent(PluginFocusEvent object) {
				return createPluginFocusEventAdapter();
			}
			@Override
			public Adapter casePresentationSwitchEvent(PresentationSwitchEvent object) {
				return createPresentationSwitchEventAdapter();
			}
			@Override
			public Adapter caseUndoEvent(UndoEvent object) {
				return createUndoEventAdapter();
			}
			@Override
			public Adapter caseValidate(Validate object) {
				return createValidateAdapter();
			}
			@Override
			public Adapter caseShowChangesEvent(ShowChangesEvent object) {
				return createShowChangesEventAdapter();
			}
			@Override
			public Adapter caseNotificationReadEvent(NotificationReadEvent object) {
				return createNotificationReadEventAdapter();
			}
			@Override
			public Adapter caseNotificationGenerationEvent(NotificationGenerationEvent object) {
				return createNotificationGenerationEventAdapter();
			}
			@Override
			public Adapter caseNotificationIgnoreEvent(NotificationIgnoreEvent object) {
				return createNotificationIgnoreEventAdapter();
			}
			@Override
			public Adapter caseURLEvent(URLEvent object) {
				return createURLEventAdapter();
			}
			@Override
			public Adapter caseMergeChoiceEvent(MergeChoiceEvent object) {
				return createMergeChoiceEventAdapter();
			}
			@Override
			public Adapter caseMergeGlobalChoiceEvent(MergeGlobalChoiceEvent object) {
				return createMergeGlobalChoiceEventAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.events.Event <em>Event</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.Event
	 * @generated
	 */
	public Adapter createEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.events.ReadEvent
	 * <em>Read Event</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.ReadEvent
	 * @generated
	 */
	public Adapter createReadEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeEvent
	 * <em>Merge Event</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.MergeEvent
	 * @generated
	 */
	public Adapter createMergeEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.events.CheckoutEvent <em>Checkout Event</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.CheckoutEvent
	 * @generated
	 */
	public Adapter createCheckoutEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.events.ExceptionEvent <em>Exception Event</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.ExceptionEvent
	 * @generated
	 */
	public Adapter createExceptionEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.events.PluginStartEvent <em>Plugin Start Event</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.PluginStartEvent
	 * @generated
	 */
	public Adapter createPluginStartEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.events.UpdateEvent
	 * <em>Update Event</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.UpdateEvent
	 * @generated
	 */
	public Adapter createUpdateEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.events.AnnotationEvent <em>Annotation Event</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.AnnotationEvent
	 * @generated
	 */
	public Adapter createAnnotationEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.events.RevertEvent
	 * <em>Revert Event</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.RevertEvent
	 * @generated
	 */
	public Adapter createRevertEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.events.ShowHistoryEvent <em>Show History Event</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.ShowHistoryEvent
	 * @generated
	 */
	public Adapter createShowHistoryEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.events.PerspectiveEvent <em>Perspective Event</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.PerspectiveEvent
	 * @generated
	 */
	public Adapter createPerspectiveEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.events.DNDEvent
	 * <em>DND Event</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.DNDEvent
	 * @generated
	 */
	public Adapter createDNDEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.events.LinkEvent
	 * <em>Link Event</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.LinkEvent
	 * @generated
	 */
	public Adapter createLinkEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.events.TraceEvent
	 * <em>Trace Event</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.TraceEvent
	 * @generated
	 */
	public Adapter createTraceEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.events.NavigatorCreateEvent <em>Navigator Create Event</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.NavigatorCreateEvent
	 * @generated
	 */
	public Adapter createNavigatorCreateEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.events.PluginFocusEvent <em>Plugin Focus Event</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.PluginFocusEvent
	 * @generated
	 */
	public Adapter createPluginFocusEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.events.PresentationSwitchEvent <em>Presentation Switch Event</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.PresentationSwitchEvent
	 * @generated
	 */
	public Adapter createPresentationSwitchEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.events.UndoEvent
	 * <em>Undo Event</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.UndoEvent
	 * @generated
	 */
	public Adapter createUndoEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.events.Validate
	 * <em>Validate</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.Validate
	 * @generated
	 */
	public Adapter createValidateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.events.ShowChangesEvent <em>Show Changes Event</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.ShowChangesEvent
	 * @generated
	 */
	public Adapter createShowChangesEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.events.NotificationReadEvent <em>Notification Read Event</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.NotificationReadEvent
	 * @generated
	 */
	public Adapter createNotificationReadEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.events.NotificationGenerationEvent <em>Notification Generation Event</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so
	 * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.NotificationGenerationEvent
	 * @generated
	 */
	public Adapter createNotificationGenerationEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.events.NotificationIgnoreEvent <em>Notification Ignore Event</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.NotificationIgnoreEvent
	 * @generated
	 */
	public Adapter createNotificationIgnoreEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.events.URLEvent
	 * <em>URL Event</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.URLEvent
	 * @generated
	 */
	public Adapter createURLEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeChoiceEvent <em>Merge Choice Event</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.MergeChoiceEvent
	 * @generated
	 */
	public Adapter createMergeChoiceEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeGlobalChoiceEvent <em>Merge Global Choice Event</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.MergeGlobalChoiceEvent
	 * @generated
	 */
	public Adapter createMergeGlobalChoiceEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc --> This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // EventsAdapterFactory
