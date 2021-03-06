/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.gmf.runtime.notation.NotationPackage;

import scrm.DiagramType;
import scrm.SCRMDiagram;
import scrm.SCRMModelElement;
import scrm.SCRMSpace;
import scrm.ScrmFactory;
import scrm.ScrmPackage;

import scrm.knowledge.KnowledgePackage;

import scrm.knowledge.impl.KnowledgePackageImpl;

import scrm.requirements.RequirementsPackage;

import scrm.requirements.dataProcess.DataProcessPackage;
import scrm.requirements.dataProcess.impl.DataProcessPackageImpl;
import scrm.requirements.impl.RequirementsPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ScrmPackageImpl extends EPackageImpl implements ScrmPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scrmModelElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scrmDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scrmSpaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum diagramTypeEEnum = null;

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
	 * @see scrm.ScrmPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ScrmPackageImpl() {
		super(eNS_URI, ScrmFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ScrmPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ScrmPackage init() {
		if (isInited)
			return (ScrmPackage) EPackage.Registry.INSTANCE
					.getEPackage(ScrmPackage.eNS_URI);

		// Obtain or create and register package
		ScrmPackageImpl theScrmPackage = (ScrmPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof ScrmPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new ScrmPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		NotationPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		KnowledgePackageImpl theKnowledgePackage = (KnowledgePackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(KnowledgePackage.eNS_URI) instanceof KnowledgePackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(KnowledgePackage.eNS_URI)
				: KnowledgePackage.eINSTANCE);
		RequirementsPackageImpl theRequirementsPackage = (RequirementsPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(RequirementsPackage.eNS_URI) instanceof RequirementsPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(RequirementsPackage.eNS_URI)
				: RequirementsPackage.eINSTANCE);
		DataProcessPackageImpl theDataProcessPackage = (DataProcessPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(DataProcessPackage.eNS_URI) instanceof DataProcessPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(DataProcessPackage.eNS_URI)
				: DataProcessPackage.eINSTANCE);

		// Create package meta-data objects
		theScrmPackage.createPackageContents();
		theKnowledgePackage.createPackageContents();
		theRequirementsPackage.createPackageContents();
		theDataProcessPackage.createPackageContents();

		// Initialize created meta-data
		theScrmPackage.initializePackageContents();
		theKnowledgePackage.initializePackageContents();
		theRequirementsPackage.initializePackageContents();
		theDataProcessPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theScrmPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ScrmPackage.eNS_URI, theScrmPackage);
		return theScrmPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCRMModelElement() {
		return scrmModelElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCRMModelElement_Name() {
		return (EAttribute) scrmModelElementEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCRMModelElement_Description() {
		return (EAttribute) scrmModelElementEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCRMModelElement_DisplayingDiagrams() {
		return (EReference) scrmModelElementEClass.getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCRMDiagram() {
		return scrmDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCRMDiagram_Elements() {
		return (EReference) scrmDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCRMDiagram_NewElements() {
		return (EReference) scrmDiagramEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCRMDiagram_DiagramLayout() {
		return (EAttribute) scrmDiagramEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCRMDiagram_DiagramType() {
		return (EAttribute) scrmDiagramEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCRMDiagram_RepresentedSpace() {
		return (EReference) scrmDiagramEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCRMSpace() {
		return scrmSpaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCRMSpace_RepresentingDiagram() {
		return (EReference) scrmSpaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDiagramType() {
		return diagramTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCRMDiagram_Gmfdiagram() {
		return (EReference) scrmDiagramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScrmFactory getScrmFactory() {
		return (ScrmFactory) getEFactoryInstance();
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
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		scrmModelElementEClass = createEClass(SCRM_MODEL_ELEMENT);
		createEAttribute(scrmModelElementEClass, SCRM_MODEL_ELEMENT__NAME);
		createEAttribute(scrmModelElementEClass,
				SCRM_MODEL_ELEMENT__DESCRIPTION);
		createEReference(scrmModelElementEClass,
				SCRM_MODEL_ELEMENT__DISPLAYING_DIAGRAMS);

		scrmDiagramEClass = createEClass(SCRM_DIAGRAM);
		createEReference(scrmDiagramEClass, SCRM_DIAGRAM__ELEMENTS);
		createEReference(scrmDiagramEClass, SCRM_DIAGRAM__GMFDIAGRAM);
		createEReference(scrmDiagramEClass, SCRM_DIAGRAM__NEW_ELEMENTS);
		createEAttribute(scrmDiagramEClass, SCRM_DIAGRAM__DIAGRAM_LAYOUT);
		createEAttribute(scrmDiagramEClass, SCRM_DIAGRAM__DIAGRAM_TYPE);
		createEReference(scrmDiagramEClass, SCRM_DIAGRAM__REPRESENTED_SPACE);

		scrmSpaceEClass = createEClass(SCRM_SPACE);
		createEReference(scrmSpaceEClass, SCRM_SPACE__REPRESENTING_DIAGRAM);

		// Create enums
		diagramTypeEEnum = createEEnum(DIAGRAM_TYPE);
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
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		KnowledgePackage theKnowledgePackage = (KnowledgePackage) EPackage.Registry.INSTANCE
				.getEPackage(KnowledgePackage.eNS_URI);
		RequirementsPackage theRequirementsPackage = (RequirementsPackage) EPackage.Registry.INSTANCE
				.getEPackage(RequirementsPackage.eNS_URI);
		NotationPackage theNotationPackage = (NotationPackage) EPackage.Registry.INSTANCE
				.getEPackage(NotationPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE
				.getEPackage(EcorePackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theKnowledgePackage);
		getESubpackages().add(theRequirementsPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		scrmDiagramEClass.getESuperTypes().add(this.getSCRMModelElement());
		scrmSpaceEClass.getESuperTypes().add(this.getSCRMModelElement());

		// Initialize classes and features; add operations and parameters
		initEClass(scrmModelElementEClass, SCRMModelElement.class,
				"SCRMModelElement", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSCRMModelElement_Name(), ecorePackage.getEString(),
				"name", "", 0, 1, SCRMModelElement.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getSCRMModelElement_Description(),
				ecorePackage.getEString(), "description", null, 0, 1,
				SCRMModelElement.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getSCRMModelElement_DisplayingDiagrams(),
				this.getSCRMDiagram(), this.getSCRMDiagram_Elements(),
				"displayingDiagrams", null, 0, -1, SCRMModelElement.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(scrmDiagramEClass, SCRMDiagram.class, "SCRMDiagram",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSCRMDiagram_Elements(), this.getSCRMModelElement(),
				this.getSCRMModelElement_DisplayingDiagrams(), "elements",
				null, 0, -1, SCRMDiagram.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSCRMDiagram_Gmfdiagram(),
				theNotationPackage.getDiagram(), null, "gmfdiagram", null, 0,
				1, SCRMDiagram.class, IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSCRMDiagram_NewElements(),
				this.getSCRMModelElement(), null, "newElements", null, 0, -1,
				SCRMDiagram.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getSCRMDiagram_DiagramLayout(),
				theEcorePackage.getEString(), "diagramLayout", null, 0, 1,
				SCRMDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSCRMDiagram_DiagramType(), this.getDiagramType(),
				"diagramType", null, 0, 1, SCRMDiagram.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getSCRMDiagram_RepresentedSpace(), this.getSCRMSpace(),
				this.getSCRMSpace_RepresentingDiagram(), "representedSpace",
				null, 0, 1, SCRMDiagram.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scrmSpaceEClass, SCRMSpace.class, "SCRMSpace", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSCRMSpace_RepresentingDiagram(),
				this.getSCRMDiagram(), this.getSCRMDiagram_RepresentedSpace(),
				"representingDiagram", null, 0, 1, SCRMSpace.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		addEOperation(scrmSpaceEClass, this.getSCRMModelElement(),
				"getContainedModelElements", 0, -1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(diagramTypeEEnum, DiagramType.class, "DiagramType");
		addEEnumLiteral(diagramTypeEEnum, DiagramType.DEFAULT_DIAGRAM);
		addEEnumLiteral(diagramTypeEEnum, DiagramType.KNOWLEDGE_DIAGRAM);
		addEEnumLiteral(diagramTypeEEnum, DiagramType.REQUIREMENTS_DIAGRAM);
		addEEnumLiteral(diagramTypeEEnum, DiagramType.DATA_PROCESS_DIAGRAM);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// org.eclipse.emf.ecp.editor
		createOrgAnnotations();
	}

	/**
	 * Initializes the annotations for <b>org.eclipse.emf.ecp.editor</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOrgAnnotations() {
		String source = "org.eclipse.emf.ecp.editor";
		addAnnotation(getSCRMModelElement_Name(), source, new String[] {
				"position", "left", "priority", "1" });
		addAnnotation(getSCRMModelElement_Description(), source, new String[] {
				"position", "left", "priority", "2" });
	}

} //ScrmPackageImpl
