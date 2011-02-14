/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.simplemeeting.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.unicase.metamodel.MetamodelPackage;
import org.unicase.model.ModelPackage;

import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.simplemeeting.SimpleMeeting;
import org.unicase.model.simplemeeting.SimplemeetingFactory;
import org.unicase.model.simplemeeting.SimplemeetingPackage;
import org.unicase.model.task.TaskPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimplemeetingPackageImpl extends EPackageImpl implements SimplemeetingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleMeetingEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.model.simplemeeting.SimplemeetingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SimplemeetingPackageImpl() {
		super(eNS_URI, SimplemeetingFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SimplemeetingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SimplemeetingPackage init() {
		if (isInited) return (SimplemeetingPackage)EPackage.Registry.INSTANCE.getEPackage(SimplemeetingPackage.eNS_URI);

		// Obtain or create and register package
		SimplemeetingPackageImpl theSimplemeetingPackage = (SimplemeetingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SimplemeetingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SimplemeetingPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSimplemeetingPackage.createPackageContents();

		// Initialize created meta-data
		theSimplemeetingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSimplemeetingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SimplemeetingPackage.eNS_URI, theSimplemeetingPackage);
		return theSimplemeetingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleMeeting() {
		return simpleMeetingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleMeeting_Location() {
		return (EAttribute)simpleMeetingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleMeeting_Starttime() {
		return (EAttribute)simpleMeetingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleMeeting_Endtime() {
		return (EAttribute)simpleMeetingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleMeeting_Facilitator() {
		return (EReference)simpleMeetingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleMeeting_Minutetaker() {
		return (EReference)simpleMeetingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleMeeting_Timekeeper() {
		return (EReference)simpleMeetingEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleMeeting_Participants() {
		return (EReference)simpleMeetingEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleMeeting_StatusItems() {
		return (EReference)simpleMeetingEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleMeeting_DiscussionItems() {
		return (EReference)simpleMeetingEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleMeeting_IdentifiedItems() {
		return (EReference)simpleMeetingEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplemeetingFactory getSimplemeetingFactory() {
		return (SimplemeetingFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		simpleMeetingEClass = createEClass(SIMPLE_MEETING);
		createEAttribute(simpleMeetingEClass, SIMPLE_MEETING__LOCATION);
		createEAttribute(simpleMeetingEClass, SIMPLE_MEETING__STARTTIME);
		createEAttribute(simpleMeetingEClass, SIMPLE_MEETING__ENDTIME);
		createEReference(simpleMeetingEClass, SIMPLE_MEETING__FACILITATOR);
		createEReference(simpleMeetingEClass, SIMPLE_MEETING__MINUTETAKER);
		createEReference(simpleMeetingEClass, SIMPLE_MEETING__TIMEKEEPER);
		createEReference(simpleMeetingEClass, SIMPLE_MEETING__PARTICIPANTS);
		createEReference(simpleMeetingEClass, SIMPLE_MEETING__STATUS_ITEMS);
		createEReference(simpleMeetingEClass, SIMPLE_MEETING__DISCUSSION_ITEMS);
		createEReference(simpleMeetingEClass, SIMPLE_MEETING__IDENTIFIED_ITEMS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
		OrganizationPackage theOrganizationPackage = (OrganizationPackage)EPackage.Registry.INSTANCE.getEPackage(OrganizationPackage.eNS_URI);
		MetamodelPackage theMetamodelPackage = (MetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(MetamodelPackage.eNS_URI);
		TaskPackage theTaskPackage = (TaskPackage)EPackage.Registry.INSTANCE.getEPackage(TaskPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		simpleMeetingEClass.getESuperTypes().add(theModelPackage.getUnicaseModelElement());

		// Initialize classes and features; add operations and parameters
		initEClass(simpleMeetingEClass, SimpleMeeting.class, "SimpleMeeting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimpleMeeting_Location(), ecorePackage.getEString(), "location", null, 0, 1, SimpleMeeting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleMeeting_Starttime(), ecorePackage.getEDate(), "starttime", null, 0, 1, SimpleMeeting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleMeeting_Endtime(), ecorePackage.getEDate(), "endtime", null, 0, 1, SimpleMeeting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimpleMeeting_Facilitator(), theOrganizationPackage.getUser(), null, "facilitator", null, 0, 1, SimpleMeeting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getSimpleMeeting_Facilitator().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getSimpleMeeting_Minutetaker(), theOrganizationPackage.getUser(), null, "minutetaker", null, 0, 1, SimpleMeeting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getSimpleMeeting_Minutetaker().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getSimpleMeeting_Timekeeper(), theOrganizationPackage.getUser(), null, "timekeeper", null, 0, 1, SimpleMeeting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getSimpleMeeting_Timekeeper().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getSimpleMeeting_Participants(), theOrganizationPackage.getOrgUnit(), null, "participants", null, 0, -1, SimpleMeeting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getSimpleMeeting_Participants().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getSimpleMeeting_StatusItems(), theTaskPackage.getWorkItem(), null, "statusItems", null, 0, -1, SimpleMeeting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getSimpleMeeting_StatusItems().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getSimpleMeeting_DiscussionItems(), theTaskPackage.getWorkItem(), null, "discussionItems", null, 0, -1, SimpleMeeting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getSimpleMeeting_DiscussionItems().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getSimpleMeeting_IdentifiedItems(), theTaskPackage.getWorkItem(), null, "identifiedItems", null, 0, -1, SimpleMeeting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getSimpleMeeting_IdentifiedItems().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// org.unicase.ui.meeditor
		createOrgAnnotations();
	}

	/**
	 * Initializes the annotations for <b>org.unicase.ui.meeditor</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOrgAnnotations() {
		String source = "org.unicase.ui.meeditor";		
		addAnnotation
		  (getSimpleMeeting_Location(), 
		   source, 
		   new String[] {
			 "priority", "10.0",
			 "position", "left"
		   });		
		addAnnotation
		  (getSimpleMeeting_Starttime(), 
		   source, 
		   new String[] {
			 "priority", "11.0",
			 "position", "left"
		   });		
		addAnnotation
		  (getSimpleMeeting_Endtime(), 
		   source, 
		   new String[] {
			 "priority", "11.0",
			 "position", "left"
		   });		
		addAnnotation
		  (getSimpleMeeting_Facilitator(), 
		   source, 
		   new String[] {
			 "priority", "12.0",
			 "position", "left"
		   });		
		addAnnotation
		  (getSimpleMeeting_Minutetaker(), 
		   source, 
		   new String[] {
			 "priority", "12.0",
			 "position", "left"
		   });		
		addAnnotation
		  (getSimpleMeeting_Timekeeper(), 
		   source, 
		   new String[] {
			 "priority", "12.0",
			 "position", "left"
		   });		
		addAnnotation
		  (getSimpleMeeting_Participants(), 
		   source, 
		   new String[] {
			 "priority", "10.0",
			 "position", "right"
		   });		
		addAnnotation
		  (getSimpleMeeting_StatusItems(), 
		   source, 
		   new String[] {
			 "priority", "11.0",
			 "position", "right"
		   });		
		addAnnotation
		  (getSimpleMeeting_DiscussionItems(), 
		   source, 
		   new String[] {
			 "priority", "12.0",
			 "position", "right"
		   });		
		addAnnotation
		  (getSimpleMeeting_IdentifiedItems(), 
		   source, 
		   new String[] {
			 "priority", "13.0",
			 "position", "right"
		   });
	}

} //SimplemeetingPackageImpl
