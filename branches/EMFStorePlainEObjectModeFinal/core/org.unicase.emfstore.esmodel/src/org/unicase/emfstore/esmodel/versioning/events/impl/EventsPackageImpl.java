/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.events.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.emfstore.esmodel.EsmodelPackage;
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolPackage;
import org.unicase.emfstore.esmodel.accesscontrol.impl.AccesscontrolPackageImpl;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesPackage;
import org.unicase.emfstore.esmodel.accesscontrol.roles.impl.RolesPackageImpl;
import org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl;
import org.unicase.emfstore.esmodel.notification.NotificationPackage;
import org.unicase.emfstore.esmodel.notification.impl.NotificationPackageImpl;
import org.unicase.emfstore.esmodel.url.UrlPackage;
import org.unicase.emfstore.esmodel.url.impl.UrlPackageImpl;
import org.unicase.emfstore.esmodel.versioning.VersioningPackage;
import org.unicase.emfstore.esmodel.versioning.events.AnnotationEvent;
import org.unicase.emfstore.esmodel.versioning.events.CheckoutEvent;
import org.unicase.emfstore.esmodel.versioning.events.DNDEvent;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.EventsPackage;
import org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent;
import org.unicase.emfstore.esmodel.versioning.events.LinkEvent;
import org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent;
import org.unicase.emfstore.esmodel.versioning.events.MergeChoiceSelection;
import org.unicase.emfstore.esmodel.versioning.events.MergeEvent;
import org.unicase.emfstore.esmodel.versioning.events.MergeGlobalChoiceEvent;
import org.unicase.emfstore.esmodel.versioning.events.MergeGlobalChoiceSelection;
import org.unicase.emfstore.esmodel.versioning.events.NavigatorCreateEvent;
import org.unicase.emfstore.esmodel.versioning.events.NotificationGenerationEvent;
import org.unicase.emfstore.esmodel.versioning.events.NotificationIgnoreEvent;
import org.unicase.emfstore.esmodel.versioning.events.NotificationReadEvent;
import org.unicase.emfstore.esmodel.versioning.events.PerspectiveEvent;
import org.unicase.emfstore.esmodel.versioning.events.PluginFocusEvent;
import org.unicase.emfstore.esmodel.versioning.events.PluginStartEvent;
import org.unicase.emfstore.esmodel.versioning.events.PresentationSwitchEvent;
import org.unicase.emfstore.esmodel.versioning.events.ReadEvent;
import org.unicase.emfstore.esmodel.versioning.events.RevertEvent;
import org.unicase.emfstore.esmodel.versioning.events.ShowChangesEvent;
import org.unicase.emfstore.esmodel.versioning.events.ShowHistoryEvent;
import org.unicase.emfstore.esmodel.versioning.events.TraceEvent;
import org.unicase.emfstore.esmodel.versioning.events.URLEvent;
import org.unicase.emfstore.esmodel.versioning.events.UndoEvent;
import org.unicase.emfstore.esmodel.versioning.events.UpdateEvent;
import org.unicase.emfstore.esmodel.versioning.events.Validate;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerPackage;
import org.unicase.emfstore.esmodel.versioning.events.server.impl.ServerPackageImpl;
import org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticPackage;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.SemanticPackageImpl;
import org.unicase.metamodel.MetamodelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class EventsPackageImpl extends EPackageImpl implements EventsPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass readEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mergeEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass checkoutEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exceptionEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pluginStartEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass revertEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass showHistoryEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass perspectiveEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dndEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass navigatorCreateEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pluginFocusEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass presentationSwitchEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass undoEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validateEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass showChangesEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notificationReadEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notificationGenerationEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notificationIgnoreEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass urlEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mergeChoiceEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mergeGlobalChoiceEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum mergeChoiceSelectionEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum mergeGlobalChoiceSelectionEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EventsPackageImpl() {
		super(eNS_URI, EventsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link EventsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EventsPackage init() {
		if (isInited) return (EventsPackage)EPackage.Registry.INSTANCE.getEPackage(EventsPackage.eNS_URI);

		// Obtain or create and register package
		EventsPackageImpl theEventsPackage = (EventsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EventsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EventsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		MetamodelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		EsmodelPackageImpl theEsmodelPackage = (EsmodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EsmodelPackage.eNS_URI) instanceof EsmodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EsmodelPackage.eNS_URI) : EsmodelPackage.eINSTANCE);
		VersioningPackageImpl theVersioningPackage = (VersioningPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(VersioningPackage.eNS_URI) instanceof VersioningPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(VersioningPackage.eNS_URI) : VersioningPackage.eINSTANCE);
		OperationsPackageImpl theOperationsPackage = (OperationsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(OperationsPackage.eNS_URI) instanceof OperationsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(OperationsPackage.eNS_URI) : OperationsPackage.eINSTANCE);
		SemanticPackageImpl theSemanticPackage = (SemanticPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SemanticPackage.eNS_URI) instanceof SemanticPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SemanticPackage.eNS_URI) : SemanticPackage.eINSTANCE);
		ServerPackageImpl theServerPackage = (ServerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ServerPackage.eNS_URI) instanceof ServerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ServerPackage.eNS_URI) : ServerPackage.eINSTANCE);
		AccesscontrolPackageImpl theAccesscontrolPackage = (AccesscontrolPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AccesscontrolPackage.eNS_URI) instanceof AccesscontrolPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AccesscontrolPackage.eNS_URI) : AccesscontrolPackage.eINSTANCE);
		RolesPackageImpl theRolesPackage = (RolesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RolesPackage.eNS_URI) instanceof RolesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RolesPackage.eNS_URI) : RolesPackage.eINSTANCE);
		NotificationPackageImpl theNotificationPackage = (NotificationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NotificationPackage.eNS_URI) instanceof NotificationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NotificationPackage.eNS_URI) : NotificationPackage.eINSTANCE);
		UrlPackageImpl theUrlPackage = (UrlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UrlPackage.eNS_URI) instanceof UrlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UrlPackage.eNS_URI) : UrlPackage.eINSTANCE);

		// Create package meta-data objects
		theEventsPackage.createPackageContents();
		theEsmodelPackage.createPackageContents();
		theVersioningPackage.createPackageContents();
		theOperationsPackage.createPackageContents();
		theSemanticPackage.createPackageContents();
		theServerPackage.createPackageContents();
		theAccesscontrolPackage.createPackageContents();
		theRolesPackage.createPackageContents();
		theNotificationPackage.createPackageContents();
		theUrlPackage.createPackageContents();

		// Initialize created meta-data
		theEventsPackage.initializePackageContents();
		theEsmodelPackage.initializePackageContents();
		theVersioningPackage.initializePackageContents();
		theOperationsPackage.initializePackageContents();
		theSemanticPackage.initializePackageContents();
		theServerPackage.initializePackageContents();
		theAccesscontrolPackage.initializePackageContents();
		theRolesPackage.initializePackageContents();
		theNotificationPackage.initializePackageContents();
		theUrlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEventsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EventsPackage.eNS_URI, theEventsPackage);
		return theEventsPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvent() {
		return eventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_Timestamp() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReadEvent() {
		return readEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReadEvent_ModelElement() {
		return (EReference)readEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReadEvent_SourceView() {
		return (EAttribute)readEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReadEvent_ReadView() {
		return (EAttribute)readEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMergeEvent() {
		return mergeEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMergeEvent_NumberOfConflicts() {
		return (EAttribute)mergeEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMergeEvent_TotalTime() {
		return (EAttribute)mergeEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMergeEvent_BaseVersion() {
		return (EReference)mergeEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMergeEvent_TargetVersion() {
		return (EReference)mergeEventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMergeEvent_LocalChanges() {
		return (EReference)mergeEventEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCheckoutEvent() {
		return checkoutEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheckoutEvent_BaseVersion() {
		return (EReference)checkoutEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExceptionEvent() {
		return exceptionEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExceptionEvent_ExceptionTitle() {
		return (EAttribute)exceptionEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExceptionEvent_ExceptionStackTrace() {
		return (EAttribute)exceptionEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExceptionEvent_ExceptionCauseTitle() {
		return (EAttribute)exceptionEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExceptionEvent_ExceptionCauseStackTrace() {
		return (EAttribute)exceptionEventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPluginStartEvent() {
		return pluginStartEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPluginStartEvent_PluginId() {
		return (EAttribute)pluginStartEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpdateEvent() {
		return updateEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUpdateEvent_BaseVersion() {
		return (EReference)updateEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUpdateEvent_TargetVersion() {
		return (EReference)updateEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotationEvent() {
		return annotationEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationEvent_AnnotatedElement() {
		return (EReference)annotationEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationEvent_Annotation() {
		return (EReference)annotationEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRevertEvent() {
		return revertEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevertEvent_RevertedChangesCount() {
		return (EAttribute)revertEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShowHistoryEvent() {
		return showHistoryEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getShowHistoryEvent_SourceVersion() {
		return (EReference)showHistoryEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getShowHistoryEvent_TargetVersion() {
		return (EReference)showHistoryEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getShowHistoryEvent_ModelElement() {
		return (EReference)showHistoryEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPerspectiveEvent() {
		return perspectiveEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDNDEvent() {
		return dndEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDNDEvent_SourceView() {
		return (EAttribute)dndEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDNDEvent_TargetView() {
		return (EAttribute)dndEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDNDEvent_DragSourceElement() {
		return (EReference)dndEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDNDEvent_DropTargetElement() {
		return (EReference)dndEventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinkEvent() {
		return linkEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinkEvent_SourceView() {
		return (EAttribute)linkEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinkEvent_SourceElement() {
		return (EReference)linkEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinkEvent_TargetElement() {
		return (EReference)linkEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinkEvent_CreatedNew() {
		return (EAttribute)linkEventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceEvent() {
		return traceEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceEvent_SourceElement() {
		return (EReference)traceEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceEvent_TargetElement() {
		return (EReference)traceEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceEvent_FeatureName() {
		return (EAttribute)traceEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNavigatorCreateEvent() {
		return navigatorCreateEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNavigatorCreateEvent_CreatedElement() {
		return (EReference)navigatorCreateEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNavigatorCreateEvent_SourceSection() {
		return (EReference)navigatorCreateEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNavigatorCreateEvent_Dynamic() {
		return (EAttribute)navigatorCreateEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPluginFocusEvent() {
		return pluginFocusEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPluginFocusEvent_PluginId() {
		return (EAttribute)pluginFocusEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPluginFocusEvent_StartDate() {
		return (EAttribute)pluginFocusEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPresentationSwitchEvent() {
		return presentationSwitchEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationSwitchEvent_ReadView() {
		return (EAttribute)presentationSwitchEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationSwitchEvent_NewPresentation() {
		return (EAttribute)presentationSwitchEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUndoEvent() {
		return undoEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUndoEvent_Operation() {
		return (EReference)undoEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValidate() {
		return validateEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShowChangesEvent() {
		return showChangesEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getShowChangesEvent_SourceVersion() {
		return (EReference)showChangesEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getShowChangesEvent_TargetVersion() {
		return (EReference)showChangesEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotificationReadEvent() {
		return notificationReadEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNotificationReadEvent_NotificationId() {
		return (EAttribute)notificationReadEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotificationGenerationEvent() {
		return notificationGenerationEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNotificationGenerationEvent_Notifications() {
		return (EReference)notificationGenerationEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotificationIgnoreEvent() {
		return notificationIgnoreEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNotificationIgnoreEvent_NotificationId() {
		return (EAttribute)notificationIgnoreEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getURLEvent() {
		return urlEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getURLEvent_SourceModelElement() {
		return (EReference)urlEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getURLEvent_SourceView() {
		return (EAttribute)urlEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getURLEvent_SourceURL() {
		return (EReference)urlEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMergeChoiceEvent() {
		return mergeChoiceEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMergeChoiceEvent_MyAcceptedChanges() {
		return (EReference)mergeChoiceEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMergeChoiceEvent_TheirRejectedChanges() {
		return (EReference)mergeChoiceEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMergeChoiceEvent_ContextModelElement() {
		return (EReference)mergeChoiceEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMergeChoiceEvent_Selection() {
		return (EAttribute)mergeChoiceEventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMergeChoiceEvent_ContextFeature() {
		return (EAttribute)mergeChoiceEventEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMergeChoiceEvent_CreatedIssueName() {
		return (EAttribute)mergeChoiceEventEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMergeGlobalChoiceEvent() {
		return mergeGlobalChoiceEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMergeGlobalChoiceEvent_Selection() {
		return (EAttribute)mergeGlobalChoiceEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMergeChoiceSelection() {
		return mergeChoiceSelectionEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMergeGlobalChoiceSelection() {
		return mergeGlobalChoiceSelectionEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EventsFactory getEventsFactory() {
		return (EventsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		eventEClass = createEClass(EVENT);
		createEAttribute(eventEClass, EVENT__TIMESTAMP);

		readEventEClass = createEClass(READ_EVENT);
		createEReference(readEventEClass, READ_EVENT__MODEL_ELEMENT);
		createEAttribute(readEventEClass, READ_EVENT__SOURCE_VIEW);
		createEAttribute(readEventEClass, READ_EVENT__READ_VIEW);

		mergeEventEClass = createEClass(MERGE_EVENT);
		createEAttribute(mergeEventEClass, MERGE_EVENT__NUMBER_OF_CONFLICTS);
		createEAttribute(mergeEventEClass, MERGE_EVENT__TOTAL_TIME);
		createEReference(mergeEventEClass, MERGE_EVENT__BASE_VERSION);
		createEReference(mergeEventEClass, MERGE_EVENT__TARGET_VERSION);
		createEReference(mergeEventEClass, MERGE_EVENT__LOCAL_CHANGES);

		checkoutEventEClass = createEClass(CHECKOUT_EVENT);
		createEReference(checkoutEventEClass, CHECKOUT_EVENT__BASE_VERSION);

		exceptionEventEClass = createEClass(EXCEPTION_EVENT);
		createEAttribute(exceptionEventEClass, EXCEPTION_EVENT__EXCEPTION_TITLE);
		createEAttribute(exceptionEventEClass, EXCEPTION_EVENT__EXCEPTION_STACK_TRACE);
		createEAttribute(exceptionEventEClass, EXCEPTION_EVENT__EXCEPTION_CAUSE_TITLE);
		createEAttribute(exceptionEventEClass, EXCEPTION_EVENT__EXCEPTION_CAUSE_STACK_TRACE);

		pluginStartEventEClass = createEClass(PLUGIN_START_EVENT);
		createEAttribute(pluginStartEventEClass, PLUGIN_START_EVENT__PLUGIN_ID);

		updateEventEClass = createEClass(UPDATE_EVENT);
		createEReference(updateEventEClass, UPDATE_EVENT__BASE_VERSION);
		createEReference(updateEventEClass, UPDATE_EVENT__TARGET_VERSION);

		annotationEventEClass = createEClass(ANNOTATION_EVENT);
		createEReference(annotationEventEClass, ANNOTATION_EVENT__ANNOTATED_ELEMENT);
		createEReference(annotationEventEClass, ANNOTATION_EVENT__ANNOTATION);

		revertEventEClass = createEClass(REVERT_EVENT);
		createEAttribute(revertEventEClass, REVERT_EVENT__REVERTED_CHANGES_COUNT);

		showHistoryEventEClass = createEClass(SHOW_HISTORY_EVENT);
		createEReference(showHistoryEventEClass, SHOW_HISTORY_EVENT__SOURCE_VERSION);
		createEReference(showHistoryEventEClass, SHOW_HISTORY_EVENT__TARGET_VERSION);
		createEReference(showHistoryEventEClass, SHOW_HISTORY_EVENT__MODEL_ELEMENT);

		perspectiveEventEClass = createEClass(PERSPECTIVE_EVENT);

		dndEventEClass = createEClass(DND_EVENT);
		createEAttribute(dndEventEClass, DND_EVENT__SOURCE_VIEW);
		createEAttribute(dndEventEClass, DND_EVENT__TARGET_VIEW);
		createEReference(dndEventEClass, DND_EVENT__DRAG_SOURCE_ELEMENT);
		createEReference(dndEventEClass, DND_EVENT__DROP_TARGET_ELEMENT);

		linkEventEClass = createEClass(LINK_EVENT);
		createEAttribute(linkEventEClass, LINK_EVENT__SOURCE_VIEW);
		createEReference(linkEventEClass, LINK_EVENT__SOURCE_ELEMENT);
		createEReference(linkEventEClass, LINK_EVENT__TARGET_ELEMENT);
		createEAttribute(linkEventEClass, LINK_EVENT__CREATED_NEW);

		traceEventEClass = createEClass(TRACE_EVENT);
		createEReference(traceEventEClass, TRACE_EVENT__SOURCE_ELEMENT);
		createEReference(traceEventEClass, TRACE_EVENT__TARGET_ELEMENT);
		createEAttribute(traceEventEClass, TRACE_EVENT__FEATURE_NAME);

		navigatorCreateEventEClass = createEClass(NAVIGATOR_CREATE_EVENT);
		createEReference(navigatorCreateEventEClass, NAVIGATOR_CREATE_EVENT__CREATED_ELEMENT);
		createEReference(navigatorCreateEventEClass, NAVIGATOR_CREATE_EVENT__SOURCE_SECTION);
		createEAttribute(navigatorCreateEventEClass, NAVIGATOR_CREATE_EVENT__DYNAMIC);

		pluginFocusEventEClass = createEClass(PLUGIN_FOCUS_EVENT);
		createEAttribute(pluginFocusEventEClass, PLUGIN_FOCUS_EVENT__PLUGIN_ID);
		createEAttribute(pluginFocusEventEClass, PLUGIN_FOCUS_EVENT__START_DATE);

		presentationSwitchEventEClass = createEClass(PRESENTATION_SWITCH_EVENT);
		createEAttribute(presentationSwitchEventEClass, PRESENTATION_SWITCH_EVENT__READ_VIEW);
		createEAttribute(presentationSwitchEventEClass, PRESENTATION_SWITCH_EVENT__NEW_PRESENTATION);

		undoEventEClass = createEClass(UNDO_EVENT);
		createEReference(undoEventEClass, UNDO_EVENT__OPERATION);

		validateEClass = createEClass(VALIDATE);

		showChangesEventEClass = createEClass(SHOW_CHANGES_EVENT);
		createEReference(showChangesEventEClass, SHOW_CHANGES_EVENT__SOURCE_VERSION);
		createEReference(showChangesEventEClass, SHOW_CHANGES_EVENT__TARGET_VERSION);

		notificationReadEventEClass = createEClass(NOTIFICATION_READ_EVENT);
		createEAttribute(notificationReadEventEClass, NOTIFICATION_READ_EVENT__NOTIFICATION_ID);

		notificationGenerationEventEClass = createEClass(NOTIFICATION_GENERATION_EVENT);
		createEReference(notificationGenerationEventEClass, NOTIFICATION_GENERATION_EVENT__NOTIFICATIONS);

		notificationIgnoreEventEClass = createEClass(NOTIFICATION_IGNORE_EVENT);
		createEAttribute(notificationIgnoreEventEClass, NOTIFICATION_IGNORE_EVENT__NOTIFICATION_ID);

		urlEventEClass = createEClass(URL_EVENT);
		createEReference(urlEventEClass, URL_EVENT__SOURCE_MODEL_ELEMENT);
		createEAttribute(urlEventEClass, URL_EVENT__SOURCE_VIEW);
		createEReference(urlEventEClass, URL_EVENT__SOURCE_URL);

		mergeChoiceEventEClass = createEClass(MERGE_CHOICE_EVENT);
		createEReference(mergeChoiceEventEClass, MERGE_CHOICE_EVENT__MY_ACCEPTED_CHANGES);
		createEReference(mergeChoiceEventEClass, MERGE_CHOICE_EVENT__THEIR_REJECTED_CHANGES);
		createEReference(mergeChoiceEventEClass, MERGE_CHOICE_EVENT__CONTEXT_MODEL_ELEMENT);
		createEAttribute(mergeChoiceEventEClass, MERGE_CHOICE_EVENT__SELECTION);
		createEAttribute(mergeChoiceEventEClass, MERGE_CHOICE_EVENT__CONTEXT_FEATURE);
		createEAttribute(mergeChoiceEventEClass, MERGE_CHOICE_EVENT__CREATED_ISSUE_NAME);

		mergeGlobalChoiceEventEClass = createEClass(MERGE_GLOBAL_CHOICE_EVENT);
		createEAttribute(mergeGlobalChoiceEventEClass, MERGE_GLOBAL_CHOICE_EVENT__SELECTION);

		// Create enums
		mergeChoiceSelectionEEnum = createEEnum(MERGE_CHOICE_SELECTION);
		mergeGlobalChoiceSelectionEEnum = createEEnum(MERGE_GLOBAL_CHOICE_SELECTION);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ServerPackage theServerPackage = (ServerPackage)EPackage.Registry.INSTANCE.getEPackage(ServerPackage.eNS_URI);
		MetamodelPackage theMetamodelPackage = (MetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(MetamodelPackage.eNS_URI);
		VersioningPackage theVersioningPackage = (VersioningPackage)EPackage.Registry.INSTANCE.getEPackage(VersioningPackage.eNS_URI);
		OperationsPackage theOperationsPackage = (OperationsPackage)EPackage.Registry.INSTANCE.getEPackage(OperationsPackage.eNS_URI);
		NotificationPackage theNotificationPackage = (NotificationPackage)EPackage.Registry.INSTANCE.getEPackage(NotificationPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theServerPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		readEventEClass.getESuperTypes().add(this.getEvent());
		mergeEventEClass.getESuperTypes().add(this.getEvent());
		checkoutEventEClass.getESuperTypes().add(this.getEvent());
		exceptionEventEClass.getESuperTypes().add(this.getEvent());
		pluginStartEventEClass.getESuperTypes().add(this.getEvent());
		updateEventEClass.getESuperTypes().add(this.getEvent());
		annotationEventEClass.getESuperTypes().add(this.getEvent());
		revertEventEClass.getESuperTypes().add(this.getEvent());
		showHistoryEventEClass.getESuperTypes().add(this.getEvent());
		perspectiveEventEClass.getESuperTypes().add(this.getEvent());
		dndEventEClass.getESuperTypes().add(this.getEvent());
		linkEventEClass.getESuperTypes().add(this.getEvent());
		traceEventEClass.getESuperTypes().add(this.getEvent());
		navigatorCreateEventEClass.getESuperTypes().add(this.getEvent());
		pluginFocusEventEClass.getESuperTypes().add(this.getEvent());
		presentationSwitchEventEClass.getESuperTypes().add(this.getEvent());
		undoEventEClass.getESuperTypes().add(this.getEvent());
		validateEClass.getESuperTypes().add(this.getEvent());
		showChangesEventEClass.getESuperTypes().add(this.getEvent());
		notificationReadEventEClass.getESuperTypes().add(this.getReadEvent());
		notificationGenerationEventEClass.getESuperTypes().add(this.getEvent());
		notificationIgnoreEventEClass.getESuperTypes().add(this.getEvent());
		urlEventEClass.getESuperTypes().add(this.getEvent());
		mergeChoiceEventEClass.getESuperTypes().add(this.getEvent());
		mergeGlobalChoiceEventEClass.getESuperTypes().add(this.getEvent());

		// Initialize classes and features; add operations and parameters
		initEClass(eventEClass, Event.class, "Event", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEvent_Timestamp(), ecorePackage.getEDate(), "timestamp", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(readEventEClass, ReadEvent.class, "ReadEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReadEvent_ModelElement(), theMetamodelPackage.getModelElementId(), null, "modelElement", null, 0, 1, ReadEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReadEvent_SourceView(), ecorePackage.getEString(), "sourceView", null, 0, 1, ReadEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReadEvent_ReadView(), ecorePackage.getEString(), "readView", null, 0, 1, ReadEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mergeEventEClass, MergeEvent.class, "MergeEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMergeEvent_NumberOfConflicts(), ecorePackage.getEInt(), "numberOfConflicts", null, 0, 1, MergeEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMergeEvent_TotalTime(), ecorePackage.getEInt(), "totalTime", null, 0, 1, MergeEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMergeEvent_BaseVersion(), theVersioningPackage.getPrimaryVersionSpec(), null, "baseVersion", null, 0, 1, MergeEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMergeEvent_TargetVersion(), theVersioningPackage.getPrimaryVersionSpec(), null, "targetVersion", null, 0, 1, MergeEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMergeEvent_LocalChanges(), theOperationsPackage.getAbstractOperation(), null, "localChanges", null, 0, -1, MergeEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(checkoutEventEClass, CheckoutEvent.class, "CheckoutEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCheckoutEvent_BaseVersion(), theVersioningPackage.getPrimaryVersionSpec(), null, "baseVersion", null, 0, 1, CheckoutEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exceptionEventEClass, ExceptionEvent.class, "ExceptionEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExceptionEvent_ExceptionTitle(), ecorePackage.getEString(), "ExceptionTitle", null, 0, 1, ExceptionEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExceptionEvent_ExceptionStackTrace(), ecorePackage.getEString(), "ExceptionStackTrace", null, 0, 1, ExceptionEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExceptionEvent_ExceptionCauseTitle(), ecorePackage.getEString(), "ExceptionCauseTitle", null, 0, 1, ExceptionEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExceptionEvent_ExceptionCauseStackTrace(), ecorePackage.getEString(), "ExceptionCauseStackTrace", null, 0, 1, ExceptionEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pluginStartEventEClass, PluginStartEvent.class, "PluginStartEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPluginStartEvent_PluginId(), ecorePackage.getEString(), "pluginId", null, 0, 1, PluginStartEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(updateEventEClass, UpdateEvent.class, "UpdateEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUpdateEvent_BaseVersion(), theVersioningPackage.getPrimaryVersionSpec(), null, "baseVersion", null, 0, 1, UpdateEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUpdateEvent_TargetVersion(), theVersioningPackage.getPrimaryVersionSpec(), null, "targetVersion", null, 0, 1, UpdateEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationEventEClass, AnnotationEvent.class, "AnnotationEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotationEvent_AnnotatedElement(), theMetamodelPackage.getModelElementId(), null, "annotatedElement", null, 0, 1, AnnotationEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotationEvent_Annotation(), theMetamodelPackage.getModelElementId(), null, "annotation", null, 0, 1, AnnotationEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(revertEventEClass, RevertEvent.class, "RevertEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRevertEvent_RevertedChangesCount(), ecorePackage.getEInt(), "revertedChangesCount", null, 0, 1, RevertEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(showHistoryEventEClass, ShowHistoryEvent.class, "ShowHistoryEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getShowHistoryEvent_SourceVersion(), theVersioningPackage.getPrimaryVersionSpec(), null, "sourceVersion", null, 0, 1, ShowHistoryEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getShowHistoryEvent_TargetVersion(), theVersioningPackage.getPrimaryVersionSpec(), null, "targetVersion", null, 0, 1, ShowHistoryEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getShowHistoryEvent_ModelElement(), theMetamodelPackage.getModelElementId(), null, "modelElement", null, 0, -1, ShowHistoryEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(perspectiveEventEClass, PerspectiveEvent.class, "PerspectiveEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dndEventEClass, DNDEvent.class, "DNDEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDNDEvent_SourceView(), ecorePackage.getEString(), "sourceView", null, 0, 1, DNDEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDNDEvent_TargetView(), ecorePackage.getEString(), "targetView", null, 0, 1, DNDEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDNDEvent_DragSourceElement(), theMetamodelPackage.getModelElementId(), null, "dragSourceElement", null, 0, 1, DNDEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDNDEvent_DropTargetElement(), theMetamodelPackage.getModelElementId(), null, "dropTargetElement", null, 0, 1, DNDEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(linkEventEClass, LinkEvent.class, "LinkEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLinkEvent_SourceView(), ecorePackage.getEString(), "sourceView", null, 0, 1, LinkEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLinkEvent_SourceElement(), theMetamodelPackage.getModelElementId(), null, "sourceElement", null, 0, 1, LinkEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLinkEvent_TargetElement(), theMetamodelPackage.getModelElementId(), null, "targetElement", null, 0, 1, LinkEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLinkEvent_CreatedNew(), ecorePackage.getEBoolean(), "createdNew", null, 0, 1, LinkEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(traceEventEClass, TraceEvent.class, "TraceEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTraceEvent_SourceElement(), theMetamodelPackage.getModelElementId(), null, "sourceElement", null, 0, 1, TraceEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTraceEvent_TargetElement(), theMetamodelPackage.getModelElementId(), null, "targetElement", null, 0, 1, TraceEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceEvent_FeatureName(), ecorePackage.getEString(), "featureName", null, 0, 1, TraceEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(navigatorCreateEventEClass, NavigatorCreateEvent.class, "NavigatorCreateEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNavigatorCreateEvent_CreatedElement(), theMetamodelPackage.getModelElementId(), null, "createdElement", null, 0, 1, NavigatorCreateEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNavigatorCreateEvent_SourceSection(), theMetamodelPackage.getModelElementId(), null, "sourceSection", null, 0, 1, NavigatorCreateEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNavigatorCreateEvent_Dynamic(), ecorePackage.getEBoolean(), "dynamic", null, 0, 1, NavigatorCreateEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pluginFocusEventEClass, PluginFocusEvent.class, "PluginFocusEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPluginFocusEvent_PluginId(), ecorePackage.getEString(), "pluginId", null, 0, 1, PluginFocusEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPluginFocusEvent_StartDate(), ecorePackage.getEDate(), "startDate", null, 0, 1, PluginFocusEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(presentationSwitchEventEClass, PresentationSwitchEvent.class, "PresentationSwitchEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPresentationSwitchEvent_ReadView(), ecorePackage.getEString(), "readView", null, 0, 1, PresentationSwitchEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationSwitchEvent_NewPresentation(), ecorePackage.getEString(), "newPresentation", null, 0, 1, PresentationSwitchEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(undoEventEClass, UndoEvent.class, "UndoEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUndoEvent_Operation(), theOperationsPackage.getAbstractOperation(), null, "operation", null, 0, 1, UndoEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(validateEClass, Validate.class, "Validate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(showChangesEventEClass, ShowChangesEvent.class, "ShowChangesEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getShowChangesEvent_SourceVersion(), theVersioningPackage.getPrimaryVersionSpec(), null, "sourceVersion", null, 0, 1, ShowChangesEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getShowChangesEvent_TargetVersion(), theVersioningPackage.getPrimaryVersionSpec(), null, "targetVersion", null, 0, 1, ShowChangesEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(notificationReadEventEClass, NotificationReadEvent.class, "NotificationReadEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNotificationReadEvent_NotificationId(), ecorePackage.getEString(), "notificationId", "", 0, 1, NotificationReadEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(notificationGenerationEventEClass, NotificationGenerationEvent.class, "NotificationGenerationEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNotificationGenerationEvent_Notifications(), theNotificationPackage.getESNotification(), null, "notifications", null, 0, -1, NotificationGenerationEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getNotificationGenerationEvent_Notifications().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());

		initEClass(notificationIgnoreEventEClass, NotificationIgnoreEvent.class, "NotificationIgnoreEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNotificationIgnoreEvent_NotificationId(), ecorePackage.getEString(), "notificationId", "", 0, 1, NotificationIgnoreEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(urlEventEClass, URLEvent.class, "URLEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getURLEvent_SourceModelElement(), theMetamodelPackage.getModelElementId(), null, "sourceModelElement", null, 0, 1, URLEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getURLEvent_SourceView(), ecorePackage.getEString(), "sourceView", null, 0, 1, URLEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getURLEvent_SourceURL(), theMetamodelPackage.getModelElementId(), null, "sourceURL", null, 0, 1, URLEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mergeChoiceEventEClass, MergeChoiceEvent.class, "MergeChoiceEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMergeChoiceEvent_MyAcceptedChanges(), theOperationsPackage.getOperationId(), null, "myAcceptedChanges", null, 0, -1, MergeChoiceEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMergeChoiceEvent_TheirRejectedChanges(), theOperationsPackage.getOperationId(), null, "theirRejectedChanges", null, 0, -1, MergeChoiceEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMergeChoiceEvent_ContextModelElement(), theMetamodelPackage.getModelElementId(), null, "contextModelElement", null, 0, 1, MergeChoiceEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMergeChoiceEvent_Selection(), this.getMergeChoiceSelection(), "selection", null, 0, 1, MergeChoiceEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMergeChoiceEvent_ContextFeature(), ecorePackage.getEString(), "contextFeature", null, 0, 1, MergeChoiceEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMergeChoiceEvent_CreatedIssueName(), ecorePackage.getEString(), "createdIssueName", null, 0, 1, MergeChoiceEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mergeGlobalChoiceEventEClass, MergeGlobalChoiceEvent.class, "MergeGlobalChoiceEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMergeGlobalChoiceEvent_Selection(), this.getMergeGlobalChoiceSelection(), "selection", null, 0, 1, MergeGlobalChoiceEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(mergeChoiceSelectionEEnum, MergeChoiceSelection.class, "MergeChoiceSelection");
		addEEnumLiteral(mergeChoiceSelectionEEnum, MergeChoiceSelection.MINE);
		addEEnumLiteral(mergeChoiceSelectionEEnum, MergeChoiceSelection.THEIR);
		addEEnumLiteral(mergeChoiceSelectionEEnum, MergeChoiceSelection.ISSUE);
		addEEnumLiteral(mergeChoiceSelectionEEnum, MergeChoiceSelection.MERGED_TEXT);

		initEEnum(mergeGlobalChoiceSelectionEEnum, MergeGlobalChoiceSelection.class, "MergeGlobalChoiceSelection");
		addEEnumLiteral(mergeGlobalChoiceSelectionEEnum, MergeGlobalChoiceSelection.ALL_MINE);
		addEEnumLiteral(mergeGlobalChoiceSelectionEEnum, MergeGlobalChoiceSelection.ALL_THEIR);
		addEEnumLiteral(mergeGlobalChoiceSelectionEEnum, MergeGlobalChoiceSelection.CANCEL);
		addEEnumLiteral(mergeGlobalChoiceSelectionEEnum, MergeGlobalChoiceSelection.OK_NOT_FINISHED);
		addEEnumLiteral(mergeGlobalChoiceSelectionEEnum, MergeGlobalChoiceSelection.OK_FINISHED);
	}

} // EventsPackageImpl
