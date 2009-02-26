/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.unicase.model.Annotation;
import org.unicase.model.Attachment;
import org.unicase.model.IdentifiableElement;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.ModelFactory;
import org.unicase.model.ModelPackage;
import org.unicase.model.ModelVersion;
import org.unicase.model.NonDomainElement;
import org.unicase.model.Project;
import org.unicase.model.UniqueIdentifier;
import org.unicase.model.attachment.AttachmentPackage;
import org.unicase.model.attachment.impl.AttachmentPackageImpl;
import org.unicase.model.bug.BugPackage;
import org.unicase.model.bug.impl.BugPackageImpl;
import org.unicase.model.change.ChangePackage;
import org.unicase.model.change.impl.ChangePackageImpl;
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.classes.impl.ClassesPackageImpl;
import org.unicase.model.component.ComponentPackage;
import org.unicase.model.component.impl.ComponentPackageImpl;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.impl.DiagramPackageImpl;
import org.unicase.model.document.DocumentPackage;
import org.unicase.model.document.impl.DocumentPackageImpl;
import org.unicase.model.meeting.MeetingPackage;
import org.unicase.model.meeting.impl.MeetingPackageImpl;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.impl.OrganizationPackageImpl;
import org.unicase.model.profile.ProfilePackage;
import org.unicase.model.profile.impl.ProfilePackageImpl;
import org.unicase.model.rationale.RationalePackage;
import org.unicase.model.rationale.impl.RationalePackageImpl;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.requirement.impl.RequirementPackageImpl;
import org.unicase.model.state.StatePackage;
import org.unicase.model.state.impl.StatePackageImpl;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.impl.TaskPackageImpl;
import org.unicase.model.util.UtilPackage;
import org.unicase.model.util.impl.UtilPackageImpl;

/*
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class ModelPackageImpl extends EPackageImpl implements ModelPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uniqueIdentifierEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attachmentEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifiableElementEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementIdEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nonDomainElementEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelVersionEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.model.ModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelPackageImpl() {
		super(eNS_URI, ModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModelPackage init() {
		if (isInited)
			return (ModelPackage) EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Obtain or create and register package
		ModelPackageImpl theModelPackage = (ModelPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(eNS_URI)
			: new ModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		NotationPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		OrganizationPackageImpl theOrganizationPackage = (OrganizationPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(OrganizationPackage.eNS_URI) instanceof OrganizationPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(OrganizationPackage.eNS_URI) : OrganizationPackage.eINSTANCE);
		TaskPackageImpl theTaskPackage = (TaskPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(TaskPackage.eNS_URI) instanceof TaskPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(TaskPackage.eNS_URI)
			: TaskPackage.eINSTANCE);
		DiagramPackageImpl theDiagramPackage = (DiagramPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(DiagramPackage.eNS_URI) instanceof DiagramPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(DiagramPackage.eNS_URI) : DiagramPackage.eINSTANCE);
		ClassesPackageImpl theClassesPackage = (ClassesPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(ClassesPackage.eNS_URI) instanceof ClassesPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(ClassesPackage.eNS_URI) : ClassesPackage.eINSTANCE);
		DocumentPackageImpl theDocumentPackage = (DocumentPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(DocumentPackage.eNS_URI) instanceof DocumentPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(DocumentPackage.eNS_URI) : DocumentPackage.eINSTANCE);
		RequirementPackageImpl theRequirementPackage = (RequirementPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(RequirementPackage.eNS_URI) instanceof RequirementPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(RequirementPackage.eNS_URI) : RequirementPackage.eINSTANCE);
		RationalePackageImpl theRationalePackage = (RationalePackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(RationalePackage.eNS_URI) instanceof RationalePackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(RationalePackage.eNS_URI) : RationalePackage.eINSTANCE);
		ChangePackageImpl theChangePackage = (ChangePackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(ChangePackage.eNS_URI) instanceof ChangePackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(ChangePackage.eNS_URI) : ChangePackage.eINSTANCE);
		BugPackageImpl theBugPackage = (BugPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(BugPackage.eNS_URI) instanceof BugPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(BugPackage.eNS_URI)
			: BugPackage.eINSTANCE);
		ComponentPackageImpl theComponentPackage = (ComponentPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(ComponentPackage.eNS_URI) instanceof ComponentPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(ComponentPackage.eNS_URI) : ComponentPackage.eINSTANCE);
		MeetingPackageImpl theMeetingPackage = (MeetingPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(MeetingPackage.eNS_URI) instanceof MeetingPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(MeetingPackage.eNS_URI) : MeetingPackage.eINSTANCE);
		StatePackageImpl theStatePackage = (StatePackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(StatePackage.eNS_URI) instanceof StatePackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(StatePackage.eNS_URI) : StatePackage.eINSTANCE);
		AttachmentPackageImpl theAttachmentPackage = (AttachmentPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(AttachmentPackage.eNS_URI) instanceof AttachmentPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(AttachmentPackage.eNS_URI) : AttachmentPackage.eINSTANCE);
		ProfilePackageImpl theProfilePackage = (ProfilePackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(ProfilePackage.eNS_URI) instanceof ProfilePackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(ProfilePackage.eNS_URI) : ProfilePackage.eINSTANCE);
		UtilPackageImpl theUtilPackage = (UtilPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(UtilPackage.eNS_URI) instanceof UtilPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(UtilPackage.eNS_URI)
			: UtilPackage.eINSTANCE);

		// Create package meta-data objects
		theModelPackage.createPackageContents();
		theOrganizationPackage.createPackageContents();
		theTaskPackage.createPackageContents();
		theDiagramPackage.createPackageContents();
		theClassesPackage.createPackageContents();
		theDocumentPackage.createPackageContents();
		theRequirementPackage.createPackageContents();
		theRationalePackage.createPackageContents();
		theChangePackage.createPackageContents();
		theBugPackage.createPackageContents();
		theComponentPackage.createPackageContents();
		theMeetingPackage.createPackageContents();
		theStatePackage.createPackageContents();
		theAttachmentPackage.createPackageContents();
		theProfilePackage.createPackageContents();
		theUtilPackage.createPackageContents();

		// Initialize created meta-data
		theModelPackage.initializePackageContents();
		theOrganizationPackage.initializePackageContents();
		theTaskPackage.initializePackageContents();
		theDiagramPackage.initializePackageContents();
		theClassesPackage.initializePackageContents();
		theDocumentPackage.initializePackageContents();
		theRequirementPackage.initializePackageContents();
		theRationalePackage.initializePackageContents();
		theChangePackage.initializePackageContents();
		theBugPackage.initializePackageContents();
		theComponentPackage.initializePackageContents();
		theMeetingPackage.initializePackageContents();
		theStatePackage.initializePackageContents();
		theAttachmentPackage.initializePackageContents();
		theProfilePackage.initializePackageContents();
		theUtilPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelPackage.freeze();

		return theModelPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelElement() {
		return modelElementEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelElement_Name() {
		return (EAttribute) modelElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelElement_Description() {
		return (EAttribute) modelElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelElement_Creator() {
		return (EAttribute) modelElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelElement_CreationDate() {
		return (EAttribute) modelElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElement_Annotations() {
		return (EReference) modelElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElement_Attachments() {
		return (EReference) modelElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElement_IncomingDocumentReferences() {
		return (EReference) modelElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElement_LeafSection() {
		return (EReference) modelElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelElement_State() {
		return (EAttribute) modelElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElement_AppliedStereotypeInstances() {
		return (EReference) modelElementEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProject() {
		return projectEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_ModelElements() {
		return (EReference) projectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUniqueIdentifier() {
		return uniqueIdentifierEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUniqueIdentifier_Id() {
		return (EAttribute) uniqueIdentifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotation() {
		return annotationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotation_AnnotatedModelElements() {
		return (EReference) annotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttachment() {
		return attachmentEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttachment_ReferringModelElements() {
		return (EReference) attachmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifiableElement() {
		return identifiableElementEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentifiableElement_Identifier() {
		return (EAttribute) identifiableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelElementId() {
		return modelElementIdEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNonDomainElement() {
		return nonDomainElementEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelVersion() {
		return modelVersionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelVersion_ReleaseNumber() {
		return (EAttribute) modelVersionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactory getModelFactory() {
		return (ModelFactory) getEFactoryInstance();
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
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		modelElementEClass = createEClass(MODEL_ELEMENT);
		createEAttribute(modelElementEClass, MODEL_ELEMENT__NAME);
		createEAttribute(modelElementEClass, MODEL_ELEMENT__DESCRIPTION);
		createEAttribute(modelElementEClass, MODEL_ELEMENT__CREATOR);
		createEAttribute(modelElementEClass, MODEL_ELEMENT__CREATION_DATE);
		createEReference(modelElementEClass, MODEL_ELEMENT__ANNOTATIONS);
		createEReference(modelElementEClass, MODEL_ELEMENT__ATTACHMENTS);
		createEReference(modelElementEClass, MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES);
		createEReference(modelElementEClass, MODEL_ELEMENT__LEAF_SECTION);
		createEAttribute(modelElementEClass, MODEL_ELEMENT__STATE);
		createEReference(modelElementEClass, MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES);

		projectEClass = createEClass(PROJECT);
		createEReference(projectEClass, PROJECT__MODEL_ELEMENTS);

		uniqueIdentifierEClass = createEClass(UNIQUE_IDENTIFIER);
		createEAttribute(uniqueIdentifierEClass, UNIQUE_IDENTIFIER__ID);

		annotationEClass = createEClass(ANNOTATION);
		createEReference(annotationEClass, ANNOTATION__ANNOTATED_MODEL_ELEMENTS);

		attachmentEClass = createEClass(ATTACHMENT);
		createEReference(attachmentEClass, ATTACHMENT__REFERRING_MODEL_ELEMENTS);

		identifiableElementEClass = createEClass(IDENTIFIABLE_ELEMENT);
		createEAttribute(identifiableElementEClass, IDENTIFIABLE_ELEMENT__IDENTIFIER);

		modelElementIdEClass = createEClass(MODEL_ELEMENT_ID);

		nonDomainElementEClass = createEClass(NON_DOMAIN_ELEMENT);

		modelVersionEClass = createEClass(MODEL_VERSION);
		createEAttribute(modelVersionEClass, MODEL_VERSION__RELEASE_NUMBER);
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
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		OrganizationPackage theOrganizationPackage = (OrganizationPackage) EPackage.Registry.INSTANCE
			.getEPackage(OrganizationPackage.eNS_URI);
		TaskPackage theTaskPackage = (TaskPackage) EPackage.Registry.INSTANCE.getEPackage(TaskPackage.eNS_URI);
		DiagramPackage theDiagramPackage = (DiagramPackage) EPackage.Registry.INSTANCE
			.getEPackage(DiagramPackage.eNS_URI);
		ClassesPackage theClassesPackage = (ClassesPackage) EPackage.Registry.INSTANCE
			.getEPackage(ClassesPackage.eNS_URI);
		DocumentPackage theDocumentPackage = (DocumentPackage) EPackage.Registry.INSTANCE
			.getEPackage(DocumentPackage.eNS_URI);
		RequirementPackage theRequirementPackage = (RequirementPackage) EPackage.Registry.INSTANCE
			.getEPackage(RequirementPackage.eNS_URI);
		RationalePackage theRationalePackage = (RationalePackage) EPackage.Registry.INSTANCE
			.getEPackage(RationalePackage.eNS_URI);
		ChangePackage theChangePackage = (ChangePackage) EPackage.Registry.INSTANCE.getEPackage(ChangePackage.eNS_URI);
		BugPackage theBugPackage = (BugPackage) EPackage.Registry.INSTANCE.getEPackage(BugPackage.eNS_URI);
		ComponentPackage theComponentPackage = (ComponentPackage) EPackage.Registry.INSTANCE
			.getEPackage(ComponentPackage.eNS_URI);
		MeetingPackage theMeetingPackage = (MeetingPackage) EPackage.Registry.INSTANCE
			.getEPackage(MeetingPackage.eNS_URI);
		StatePackage theStatePackage = (StatePackage) EPackage.Registry.INSTANCE.getEPackage(StatePackage.eNS_URI);
		AttachmentPackage theAttachmentPackage = (AttachmentPackage) EPackage.Registry.INSTANCE
			.getEPackage(AttachmentPackage.eNS_URI);
		ProfilePackage theProfilePackage = (ProfilePackage) EPackage.Registry.INSTANCE
			.getEPackage(ProfilePackage.eNS_URI);
		UtilPackage theUtilPackage = (UtilPackage) EPackage.Registry.INSTANCE.getEPackage(UtilPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theOrganizationPackage);
		getESubpackages().add(theTaskPackage);
		getESubpackages().add(theDiagramPackage);
		getESubpackages().add(theClassesPackage);
		getESubpackages().add(theDocumentPackage);
		getESubpackages().add(theRequirementPackage);
		getESubpackages().add(theRationalePackage);
		getESubpackages().add(theChangePackage);
		getESubpackages().add(theBugPackage);
		getESubpackages().add(theComponentPackage);
		getESubpackages().add(theMeetingPackage);
		getESubpackages().add(theStatePackage);
		getESubpackages().add(theAttachmentPackage);
		getESubpackages().add(theProfilePackage);
		getESubpackages().add(theUtilPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		modelElementEClass.getESuperTypes().add(this.getIdentifiableElement());
		annotationEClass.getESuperTypes().add(this.getModelElement());
		attachmentEClass.getESuperTypes().add(this.getModelElement());
		modelElementIdEClass.getESuperTypes().add(this.getUniqueIdentifier());

		// Initialize classes and features; add operations and parameters
		initEClass(modelElementEClass, ModelElement.class, "ModelElement", IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, ModelElement.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelElement_Description(), ecorePackage.getEString(), "description", null, 0, 1,
			ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelElement_Creator(), ecorePackage.getEString(), "creator", null, 0, 1, ModelElement.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelElement_CreationDate(), ecorePackage.getEDate(), "creationDate", null, 0, 1,
			ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEReference(getModelElement_Annotations(), this.getAnnotation(),
			this.getAnnotation_AnnotatedModelElements(), "annotations", null, 0, -1, ModelElement.class, !IS_TRANSIENT,
			!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
			IS_ORDERED);
		getModelElement_Annotations().getEKeys().add(this.getIdentifiableElement_Identifier());
		initEReference(getModelElement_Attachments(), this.getAttachment(),
			this.getAttachment_ReferringModelElements(), "attachments", null, 0, -1, ModelElement.class, !IS_TRANSIENT,
			!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
			IS_ORDERED);
		getModelElement_Attachments().getEKeys().add(this.getIdentifiableElement_Identifier());
		initEReference(getModelElement_IncomingDocumentReferences(), theDocumentPackage.getLeafSection(),
			theDocumentPackage.getLeafSection_ReferencedModelElements(), "incomingDocumentReferences", null, 0, -1,
			ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getModelElement_IncomingDocumentReferences().getEKeys().add(this.getIdentifiableElement_Identifier());
		initEReference(getModelElement_LeafSection(), theDocumentPackage.getLeafSection(), theDocumentPackage
			.getLeafSection_ModelElements(), "leafSection", null, 0, 1, ModelElement.class, !IS_TRANSIENT,
			!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
			IS_ORDERED);
		getModelElement_LeafSection().getEKeys().add(this.getIdentifiableElement_Identifier());
		initEAttribute(getModelElement_State(), ecorePackage.getEString(), "state", "", 0, 1, ModelElement.class,
			IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getModelElement_AppliedStereotypeInstances(), theProfilePackage.getStereotypeInstance(),
			theProfilePackage.getStereotypeInstance_ModelElement(), "appliedStereotypeInstances", null, 0, -1,
			ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getModelElement_AppliedStereotypeInstances().getEKeys().add(this.getIdentifiableElement_Identifier());

		initEClass(projectEClass, Project.class, "Project", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProject_ModelElements(), this.getModelElement(), null, "modelElements", null, 0, -1,
			Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		getProject_ModelElements().getEKeys().add(this.getIdentifiableElement_Identifier());

		initEClass(uniqueIdentifierEClass, UniqueIdentifier.class, "UniqueIdentifier", IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUniqueIdentifier_Id(), ecorePackage.getEString(), "id", "Default Value Literal\t", 1, 1,
			UniqueIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);

		initEClass(annotationEClass, Annotation.class, "Annotation", IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotation_AnnotatedModelElements(), this.getModelElement(), this
			.getModelElement_Annotations(), "annotatedModelElements", null, 0, -1, Annotation.class, !IS_TRANSIENT,
			!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
			IS_ORDERED);
		getAnnotation_AnnotatedModelElements().getEKeys().add(this.getIdentifiableElement_Identifier());

		initEClass(attachmentEClass, Attachment.class, "Attachment", IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttachment_ReferringModelElements(), this.getModelElement(), this
			.getModelElement_Attachments(), "referringModelElements", null, 0, -1, Attachment.class, !IS_TRANSIENT,
			!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
			IS_ORDERED);
		getAttachment_ReferringModelElements().getEKeys().add(this.getIdentifiableElement_Identifier());

		initEClass(identifiableElementEClass, IdentifiableElement.class, "IdentifiableElement", !IS_ABSTRACT,
			!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdentifiableElement_Identifier(), ecorePackage.getEString(), "identifier", null, 1, 1,
			IdentifiableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);

		initEClass(modelElementIdEClass, ModelElementId.class, "ModelElementId", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);

		initEClass(nonDomainElementEClass, NonDomainElement.class, "NonDomainElement", IS_ABSTRACT, IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);

		initEClass(modelVersionEClass, ModelVersion.class, "ModelVersion", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelVersion_ReleaseNumber(), ecorePackage.getEInt(), "releaseNumber", null, 0, 1,
			ModelVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// org.unicase.ui.meeditor
		createOrgAnnotations();
		// teneo.jpa
		createTeneoAnnotations();
	}

	/**
	 * Initializes the annotations for <b>org.unicase.ui.meeditor</b>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOrgAnnotations() {
		String source = "org.unicase.ui.meeditor";
		addAnnotation(getModelElement_Name(), source, new String[] { "priority", "1.0", "position", "left" });
		addAnnotation(getModelElement_Description(), source, new String[] { "priority", "1.0", "position", "left" });
		addAnnotation(getModelElement_Annotations(), source, new String[] { "priority", "100.0", "position", "right" });
		addAnnotation(getModelElement_Attachments(), source, new String[] { "priority", "101.0", "position", "right" });
		addAnnotation(getModelElement_IncomingDocumentReferences(), source, new String[] { "priority", "102.0",
			"position", "right" });
		addAnnotation(getAnnotation_AnnotatedModelElements(), source, new String[] { "priority", "90.0", "position",
			"right" });
	}

	/**
	 * Initializes the annotations for <b>teneo.jpa</b>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void createTeneoAnnotations() {
		String source = "teneo.jpa";
		addAnnotation(getModelElement_Description(), source, new String[] { "value", "@Type(type=\"text\")" });
	}

} // ModelPackageImpl