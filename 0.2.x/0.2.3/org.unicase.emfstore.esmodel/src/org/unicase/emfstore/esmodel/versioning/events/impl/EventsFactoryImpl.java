/**
 * <copyright>Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html</copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.events.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.emfstore.esmodel.versioning.events.CheckoutEvent;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.EventsPackage;
import org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent;
import org.unicase.emfstore.esmodel.versioning.events.MergeEvent;
import org.unicase.emfstore.esmodel.versioning.events.ReadEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EventsFactoryImpl extends EFactoryImpl implements EventsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventsFactory init() {
		try {
			EventsFactory theEventsFactory = (EventsFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://unicase.org/esmodel/versioning/events");
			if (theEventsFactory != null) {
				return theEventsFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EventsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case EventsPackage.EVENT:
			return createEvent();
		case EventsPackage.READ_EVENT:
			return createReadEvent();
		case EventsPackage.MERGE_EVENT:
			return createMergeEvent();
		case EventsPackage.CHECKOUT_EVENT:
			return createCheckoutEvent();
		case EventsPackage.EXCEPTION_EVENT:
			return createExceptionEvent();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event createEvent() {
		EventImpl event = new EventImpl();
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReadEvent createReadEvent() {
		ReadEventImpl readEvent = new ReadEventImpl();
		return readEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MergeEvent createMergeEvent() {
		MergeEventImpl mergeEvent = new MergeEventImpl();
		return mergeEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CheckoutEvent createCheckoutEvent() {
		CheckoutEventImpl checkoutEvent = new CheckoutEventImpl();
		return checkoutEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExceptionEvent createExceptionEvent() {
		ExceptionEventImpl exceptionEvent = new ExceptionEventImpl();
		return exceptionEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventsPackage getEventsPackage() {
		return (EventsPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EventsPackage getPackage() {
		return EventsPackage.eINSTANCE;
	}

} //EventsFactoryImpl
