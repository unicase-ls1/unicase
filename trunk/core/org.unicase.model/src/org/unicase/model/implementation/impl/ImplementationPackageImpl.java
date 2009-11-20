/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.unicase.emfstore.esmodel.EsmodelPackage;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.model.ModelPackage;
import org.unicase.model.activity.ActivityPackage;
import org.unicase.model.activity.impl.ActivityPackageImpl;
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
import org.unicase.model.impl.ModelPackageImpl;
import org.unicase.model.implementation.IAttribute;
import org.unicase.model.implementation.IClass;
import org.unicase.model.implementation.IEnumeration;
import org.unicase.model.implementation.IFeature;
import org.unicase.model.implementation.ILiteral;
import org.unicase.model.implementation.IPackage;
import org.unicase.model.implementation.IPrimitiveType;
import org.unicase.model.implementation.IReference;
import org.unicase.model.implementation.ImplementationFactory;
import org.unicase.model.implementation.ImplementationPackage;
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

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ImplementationPackageImpl extends EPackageImpl implements ImplementationPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass iPackageEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass iClassEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass iFeatureEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass iAttributeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass iReferenceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass iEnumerationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass iLiteralEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum iPrimitiveTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.model.implementation.ImplementationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ImplementationPackageImpl() {
		super(eNS_URI, ImplementationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * <p>
	 * This method is used to initialize {@link ImplementationPackage#eINSTANCE} when that field is accessed. Clients
	 * should not invoke it directly. Instead, they should simply access that field to obtain the package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ImplementationPackage init() {
		if (isInited)
			return (ImplementationPackage) EPackage.Registry.INSTANCE.getEPackage(ImplementationPackage.eNS_URI);

		// Obtain or create and register package
		ImplementationPackageImpl theImplementationPackage = (ImplementationPackageImpl) (EPackage.Registry.INSTANCE
			.get(eNS_URI) instanceof ImplementationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
			: new ImplementationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EsmodelPackage.eINSTANCE.eClass();
		NotationPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ModelPackageImpl theModelPackage = (ModelPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);
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
		ActivityPackageImpl theActivityPackage = (ActivityPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(ActivityPackage.eNS_URI) instanceof ActivityPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(ActivityPackage.eNS_URI) : ActivityPackage.eINSTANCE);

		// Create package meta-data objects
		theImplementationPackage.createPackageContents();
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
		theActivityPackage.createPackageContents();

		// Initialize created meta-data
		theImplementationPackage.initializePackageContents();
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
		theActivityPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theImplementationPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ImplementationPackage.eNS_URI, theImplementationPackage);
		return theImplementationPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getIPackage() {
		return iPackageEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getIPackage_Namespace() {
		return (EAttribute) iPackageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIPackage_ParentPackage() {
		return (EReference) iPackageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIPackage_SubPackages() {
		return (EReference) iPackageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIPackage_Classes() {
		return (EReference) iPackageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIPackage_Enumerations() {
		return (EReference) iPackageEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getIClass() {
		return iClassEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIClass_ParentPackage() {
		return (EReference) iClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getIClass_Abstract() {
		return (EAttribute) iClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIClass_SuperClasses() {
		return (EReference) iClassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIClass_SubClasses() {
		return (EReference) iClassEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIClass_Attributes() {
		return (EReference) iClassEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIClass_OutgoingReferences() {
		return (EReference) iClassEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIClass_IncomingReferences() {
		return (EReference) iClassEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIClass_AnalysisClasses() {
		return (EReference) iClassEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getIFeature() {
		return iFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getIFeature_MinimumMultiplicity() {
		return (EAttribute) iFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getIFeature_MaximumMultiplicity() {
		return (EAttribute) iFeatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getIFeature_Transient() {
		return (EAttribute) iFeatureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getIAttribute() {
		return iAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIAttribute_ParentClass() {
		return (EReference) iAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getIAttribute_Id() {
		return (EAttribute) iAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getIAttribute_Type() {
		return (EAttribute) iAttributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIAttribute_Enumeration() {
		return (EReference) iAttributeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getIReference() {
		return iReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIReference_ParentClass() {
		return (EReference) iReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIReference_Type() {
		return (EReference) iReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getIReference_Containment() {
		return (EAttribute) iReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIReference_OppositeReference() {
		return (EReference) iReferenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getIEnumeration() {
		return iEnumerationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIEnumeration_ParentPackage() {
		return (EReference) iEnumerationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIEnumeration_Literals() {
		return (EReference) iEnumerationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIEnumeration_Attributes() {
		return (EReference) iEnumerationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getILiteral() {
		return iLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getILiteral_ParentEnumeration() {
		return (EReference) iLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getILiteral_Literal() {
		return (EAttribute) iLiteralEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getIPrimitiveType() {
		return iPrimitiveTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ImplementationFactory getImplementationFactory() {
		return (ImplementationFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is guarded to have no affect on any invocation but
	 * its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		iPackageEClass = createEClass(IPACKAGE);
		createEAttribute(iPackageEClass, IPACKAGE__NAMESPACE);
		createEReference(iPackageEClass, IPACKAGE__PARENT_PACKAGE);
		createEReference(iPackageEClass, IPACKAGE__SUB_PACKAGES);
		createEReference(iPackageEClass, IPACKAGE__CLASSES);
		createEReference(iPackageEClass, IPACKAGE__ENUMERATIONS);

		iClassEClass = createEClass(ICLASS);
		createEReference(iClassEClass, ICLASS__PARENT_PACKAGE);
		createEAttribute(iClassEClass, ICLASS__ABSTRACT);
		createEReference(iClassEClass, ICLASS__SUPER_CLASSES);
		createEReference(iClassEClass, ICLASS__SUB_CLASSES);
		createEReference(iClassEClass, ICLASS__ATTRIBUTES);
		createEReference(iClassEClass, ICLASS__OUTGOING_REFERENCES);
		createEReference(iClassEClass, ICLASS__INCOMING_REFERENCES);
		createEReference(iClassEClass, ICLASS__ANALYSIS_CLASSES);

		iFeatureEClass = createEClass(IFEATURE);
		createEAttribute(iFeatureEClass, IFEATURE__MINIMUM_MULTIPLICITY);
		createEAttribute(iFeatureEClass, IFEATURE__MAXIMUM_MULTIPLICITY);
		createEAttribute(iFeatureEClass, IFEATURE__TRANSIENT);

		iAttributeEClass = createEClass(IATTRIBUTE);
		createEReference(iAttributeEClass, IATTRIBUTE__PARENT_CLASS);
		createEAttribute(iAttributeEClass, IATTRIBUTE__ID);
		createEAttribute(iAttributeEClass, IATTRIBUTE__TYPE);
		createEReference(iAttributeEClass, IATTRIBUTE__ENUMERATION);

		iReferenceEClass = createEClass(IREFERENCE);
		createEReference(iReferenceEClass, IREFERENCE__PARENT_CLASS);
		createEReference(iReferenceEClass, IREFERENCE__TYPE);
		createEAttribute(iReferenceEClass, IREFERENCE__CONTAINMENT);
		createEReference(iReferenceEClass, IREFERENCE__OPPOSITE_REFERENCE);

		iEnumerationEClass = createEClass(IENUMERATION);
		createEReference(iEnumerationEClass, IENUMERATION__PARENT_PACKAGE);
		createEReference(iEnumerationEClass, IENUMERATION__LITERALS);
		createEReference(iEnumerationEClass, IENUMERATION__ATTRIBUTES);

		iLiteralEClass = createEClass(ILITERAL);
		createEReference(iLiteralEClass, ILITERAL__PARENT_ENUMERATION);
		createEAttribute(iLiteralEClass, ILITERAL__LITERAL);

		// Create enums
		iPrimitiveTypeEEnum = createEEnum(IPRIMITIVE_TYPE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This method is guarded to have no affect on any
	 * invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
		ModelPackage theModelPackage = (ModelPackage) EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
		MetamodelPackage theMetamodelPackage = (MetamodelPackage) EPackage.Registry.INSTANCE
			.getEPackage(MetamodelPackage.eNS_URI);
		ClassesPackage theClassesPackage = (ClassesPackage) EPackage.Registry.INSTANCE
			.getEPackage(ClassesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		iPackageEClass.getESuperTypes().add(theModelPackage.getUnicaseModelElement());
		iClassEClass.getESuperTypes().add(theModelPackage.getUnicaseModelElement());
		iFeatureEClass.getESuperTypes().add(theModelPackage.getUnicaseModelElement());
		iAttributeEClass.getESuperTypes().add(this.getIFeature());
		iReferenceEClass.getESuperTypes().add(this.getIFeature());
		iEnumerationEClass.getESuperTypes().add(theModelPackage.getUnicaseModelElement());
		iLiteralEClass.getESuperTypes().add(theModelPackage.getUnicaseModelElement());

		// Initialize classes and features; add operations and parameters
		initEClass(iPackageEClass, IPackage.class, "IPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIPackage_Namespace(), ecorePackage.getEString(), "namespace", null, 0, 1, IPackage.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIPackage_ParentPackage(), this.getIPackage(), this.getIPackage_SubPackages(),
			"parentPackage", null, 0, 1, IPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIPackage_ParentPackage().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getIPackage_SubPackages(), this.getIPackage(), this.getIPackage_ParentPackage(), "subPackages",
			null, 0, -1, IPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIPackage_SubPackages().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getIPackage_Classes(), this.getIClass(), this.getIClass_ParentPackage(), "classes", null, 0, -1,
			IPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIPackage_Classes().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getIPackage_Enumerations(), this.getIEnumeration(), this.getIEnumeration_ParentPackage(),
			"enumerations", null, 0, -1, IPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIPackage_Enumerations().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());

		initEClass(iClassEClass, IClass.class, "IClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIClass_ParentPackage(), this.getIPackage(), this.getIPackage_Classes(), "parentPackage",
			null, 0, 1, IClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIClass_ParentPackage().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEAttribute(getIClass_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 0, 1, IClass.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIClass_SuperClasses(), this.getIClass(), this.getIClass_SubClasses(), "superClasses", null,
			0, -1, IClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIClass_SuperClasses().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getIClass_SubClasses(), this.getIClass(), this.getIClass_SuperClasses(), "subClasses", null, 0,
			-1, IClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIClass_SubClasses().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getIClass_Attributes(), this.getIAttribute(), this.getIAttribute_ParentClass(), "attributes",
			null, 0, -1, IClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIClass_Attributes().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getIClass_OutgoingReferences(), this.getIReference(), this.getIReference_ParentClass(),
			"outgoingReferences", null, 0, -1, IClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
			!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIClass_OutgoingReferences().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getIClass_IncomingReferences(), this.getIReference(), this.getIReference_Type(),
			"incomingReferences", null, 0, -1, IClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIClass_IncomingReferences().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getIClass_AnalysisClasses(), theClassesPackage.getClass_(), theClassesPackage
			.getClass_ImplementationClasses(), "analysisClasses", null, 0, -1, IClass.class, !IS_TRANSIENT,
			!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
			IS_ORDERED);
		getIClass_AnalysisClasses().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());

		initEClass(iFeatureEClass, IFeature.class, "IFeature", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIFeature_MinimumMultiplicity(), ecorePackage.getEInt(), "minimumMultiplicity", null, 0, 1,
			IFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
			IS_ORDERED);
		initEAttribute(getIFeature_MaximumMultiplicity(), ecorePackage.getEInt(), "maximumMultiplicity", "1", 0, 1,
			IFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
			IS_ORDERED);
		initEAttribute(getIFeature_Transient(), ecorePackage.getEBoolean(), "transient", null, 0, 1, IFeature.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iAttributeEClass, IAttribute.class, "IAttribute", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIAttribute_ParentClass(), this.getIClass(), this.getIClass_Attributes(), "parentClass", null,
			0, 1, IAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIAttribute_ParentClass().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEAttribute(getIAttribute_Id(), ecorePackage.getEBoolean(), "id", null, 0, 1, IAttribute.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIAttribute_Type(), this.getIPrimitiveType(), "type", null, 0, 1, IAttribute.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIAttribute_Enumeration(), this.getIEnumeration(), this.getIEnumeration_Attributes(),
			"enumeration", null, 0, 1, IAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIAttribute_Enumeration().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());

		initEClass(iReferenceEClass, IReference.class, "IReference", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIReference_ParentClass(), this.getIClass(), this.getIClass_OutgoingReferences(),
			"parentClass", null, 0, 1, IReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIReference_ParentClass().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getIReference_Type(), this.getIClass(), this.getIClass_IncomingReferences(), "type", null, 0, 1,
			IReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIReference_Type().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEAttribute(getIReference_Containment(), ecorePackage.getEBoolean(), "containment", null, 0, 1,
			IReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEReference(getIReference_OppositeReference(), this.getIReference(), null, "oppositeReference", null, 0, 1,
			IReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIReference_OppositeReference().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());

		initEClass(iEnumerationEClass, IEnumeration.class, "IEnumeration", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIEnumeration_ParentPackage(), this.getIPackage(), this.getIPackage_Enumerations(),
			"parentPackage", null, 0, 1, IEnumeration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIEnumeration_ParentPackage().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getIEnumeration_Literals(), this.getILiteral(), this.getILiteral_ParentEnumeration(),
			"literals", null, 0, -1, IEnumeration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
			!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIEnumeration_Literals().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getIEnumeration_Attributes(), this.getIAttribute(), this.getIAttribute_Enumeration(),
			"attributes", null, 0, -1, IEnumeration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIEnumeration_Attributes().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());

		initEClass(iLiteralEClass, ILiteral.class, "ILiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getILiteral_ParentEnumeration(), this.getIEnumeration(), this.getIEnumeration_Literals(),
			"parentEnumeration", null, 0, 1, ILiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getILiteral_ParentEnumeration().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEAttribute(getILiteral_Literal(), ecorePackage.getEString(), "literal", null, 0, 1, ILiteral.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(iPrimitiveTypeEEnum, IPrimitiveType.class, "IPrimitiveType");
		addEEnumLiteral(iPrimitiveTypeEEnum, IPrimitiveType.STRING);
		addEEnumLiteral(iPrimitiveTypeEEnum, IPrimitiveType.BOOLEAN);
		addEEnumLiteral(iPrimitiveTypeEEnum, IPrimitiveType.INTEGER);
		addEEnumLiteral(iPrimitiveTypeEEnum, IPrimitiveType.DATE);
		addEEnumLiteral(iPrimitiveTypeEEnum, IPrimitiveType.DOUBLE);
		addEEnumLiteral(iPrimitiveTypeEEnum, IPrimitiveType.ENUMERATION);
	}

} // ImplementationPackageImpl
