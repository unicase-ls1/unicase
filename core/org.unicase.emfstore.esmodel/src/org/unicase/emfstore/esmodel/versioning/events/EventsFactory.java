/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.events;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage
 * @generated
 */
public interface EventsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	EventsFactory eINSTANCE = org.unicase.emfstore.esmodel.versioning.events.impl.EventsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Event</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Event</em>'.
	 * @generated
	 */
	Event createEvent();

	/**
	 * Returns a new object of class '<em>Read Event</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Read Event</em>'.
	 * @generated
	 */
	ReadEvent createReadEvent();

	/**
	 * Returns a new object of class '<em>Merge Event</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Merge Event</em>'.
	 * @generated
	 */
	MergeEvent createMergeEvent();

	/**
	 * Returns a new object of class '<em>Checkout Event</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Checkout Event</em>'.
	 * @generated
	 */
	CheckoutEvent createCheckoutEvent();

	/**
	 * Returns a new object of class '<em>Exception Event</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Exception Event</em>'.
	 * @generated
	 */
	ExceptionEvent createExceptionEvent();

	/**
	 * Returns a new object of class '<em>Plugin Start Event</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Plugin Start Event</em>'.
	 * @generated
	 */
	PluginStartEvent createPluginStartEvent();

	/**
	 * Returns a new object of class '<em>Update Event</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Update Event</em>'.
	 * @generated
	 */
	UpdateEvent createUpdateEvent();

	/**
	 * Returns a new object of class '<em>Annotation Event</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation Event</em>'.
	 * @generated
	 */
	AnnotationEvent createAnnotationEvent();

	/**
	 * Returns a new object of class '<em>Revert Event</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Revert Event</em>'.
	 * @generated
	 */
	RevertEvent createRevertEvent();

	/**
	 * Returns a new object of class '<em>Show History Event</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Show History Event</em>'.
	 * @generated
	 */
	ShowHistoryEvent createShowHistoryEvent();

	/**
	 * Returns a new object of class '<em>Perspective Event</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Perspective Event</em>'.
	 * @generated
	 */
	PerspectiveEvent createPerspectiveEvent();

	/**
	 * Returns a new object of class '<em>DND Event</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>DND Event</em>'.
	 * @generated
	 */
	DNDEvent createDNDEvent();

	/**
	 * Returns a new object of class '<em>Link Event</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Event</em>'.
	 * @generated
	 */
	LinkEvent createLinkEvent();

	/**
	 * Returns a new object of class '<em>Trace Event</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace Event</em>'.
	 * @generated
	 */
	TraceEvent createTraceEvent();

	/**
	 * Returns a new object of class '<em>Navigator Create Event</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Navigator Create Event</em>'.
	 * @generated
	 */
	NavigatorCreateEvent createNavigatorCreateEvent();

	/**
	 * Returns a new object of class '<em>Plugin Focus Event</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Plugin Focus Event</em>'.
	 * @generated
	 */
	PluginFocusEvent createPluginFocusEvent();

	/**
	 * Returns a new object of class '<em>Presentation Switch Event</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Presentation Switch Event</em>'.
	 * @generated
	 */
	PresentationSwitchEvent createPresentationSwitchEvent();

	/**
	 * Returns a new object of class '<em>Undo Event</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Undo Event</em>'.
	 * @generated
	 */
	UndoEvent createUndoEvent();

	/**
	 * Returns a new object of class '<em>Validate</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Validate</em>'.
	 * @generated
	 */
	Validate createValidate();

	/**
	 * Returns a new object of class '<em>Show Changes Event</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Show Changes Event</em>'.
	 * @generated
	 */
	ShowChangesEvent createShowChangesEvent();

	/**
	 * Returns a new object of class '<em>Notification Read Event</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Notification Read Event</em>'.
	 * @generated
	 */
	NotificationReadEvent createNotificationReadEvent();

	/**
	 * Returns a new object of class '<em>Notification Generation Event</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Notification Generation Event</em>'.
	 * @generated
	 */
	NotificationGenerationEvent createNotificationGenerationEvent();

	/**
	 * Returns a new object of class '<em>Notification Ignore Event</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Notification Ignore Event</em>'.
	 * @generated
	 */
	NotificationIgnoreEvent createNotificationIgnoreEvent();

	/**
	 * Returns a new object of class '<em>URL Event</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>URL Event</em>'.
	 * @generated
	 */
	URLEvent createURLEvent();

	/**
	 * Returns a new object of class '<em>Merge Choice Event</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Merge Choice Event</em>'.
	 * @generated
	 */
	MergeChoiceEvent createMergeChoiceEvent();

	/**
	 * Returns a new object of class '<em>Merge Global Choice Event</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Merge Global Choice Event</em>'.
	 * @generated
	 */
	MergeGlobalChoiceEvent createMergeGlobalChoiceEvent();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EventsPackage getEventsPackage();

} // EventsFactory
