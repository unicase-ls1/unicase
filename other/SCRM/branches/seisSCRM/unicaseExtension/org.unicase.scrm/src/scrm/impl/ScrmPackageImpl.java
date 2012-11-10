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

import org.unicase.model.ModelPackage;
import scrm.DiagramType;
import scrm.SCRMDiagram;
import scrm.SCRMModelElement;
import scrm.SCRMSpace;
import scrm.ScrmFactory;
import scrm.ScrmPackage;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.impl.KnowledgePackageImpl;
import scrm.requirements.RequirementsPackage;
import scrm.requirements.dataObject.DataObjectPackage;
import scrm.requirements.dataObject.impl.DataObjectPackageImpl;
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
		ModelPackage.eINSTANCE.eClass();
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
		DataObjectPackageImpl theDataObjectPackage = (DataObjectPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(DataObjectPackage.eNS_URI) instanceof DataObjectPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(DataObjectPackage.eNS_URI)
				: DataObjectPackage.eINSTANCE);

		// Create package meta-data objects
		theScrmPackage.createPackageContents();
		theKnowledgePackage.createPackageContents();
		theRequirementsPackage.createPackageContents();
		theDataProcessPackage.createPackageContents();
		theDataObjectPackage.createPackageContents();

		// Initialize created meta-data
		theScrmPackage.initializePackageContents();
		theKnowledgePackage.initializePackageContents();
		theRequirementsPackage.initializePackageContents();
		theDataProcessPackage.initializePackageContents();
		theDataObjectPackage.initializePackageContents();

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
	public EReference getSCRMModelElement_DisplayingDiagrams() {
		return (EReference) scrmModelElementEClass.getEStructuralFeatures()
				.get(0);
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
		createEReference(scrmModelElementEClass,
				SCRM_MODEL_ELEMENT__DISPLAYING_DIAGRAMS);

		scrmDiagramEClass = createEClass(SCRM_DIAGRAM);
		createEReference(scrmDiagramEClass, SCRM_DIAGRAM__ELEMENTS);
		createEReference(scrmDiagramEClass, SCRM_DIAGRAM__GMFDIAGRAM);
		createEReference(scrmDiagramEClass, SCRM_DIAGRAM__NEW_ELEMENTS);
		createEAttribute(scrmDiagramEClass, SCRM_DIAGRAM__DIAGRAM_LAYOUT);
		createEAttribute(scrmDiagramEClass, SCRM_DIAGRAM__DIAGRAM_TYPE);

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
		ModelPackage theModelPackage = (ModelPackage) EPackage.Registry.INSTANCE
				.getEPackage(ModelPackage.eNS_URI);
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
		scrmModelElementEClass.getESuperTypes().add(
				theModelPackage.getUnicaseModelElement());
		scrmDiagramEClass.getESuperTypes().add(this.getSCRMModelElement());

		// Initialize classes and features; add operations and parameters
		initEClass(scrmModelElementEClass, SCRMModelElement.class,
				"SCRMModelElement", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
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

		// Initialize enums and add enum literals
		initEEnum(diagramTypeEEnum, DiagramType.class, "DiagramType");
		addEEnumLiteral(diagramTypeEEnum, DiagramType.DEFAULT_DIAGRAM);
		addEEnumLiteral(diagramTypeEEnum, DiagramType.KNOWLEDGE_DIAGRAM);
		addEEnumLiteral(diagramTypeEEnum, DiagramType.REQUIREMENTS_DIAGRAM);
		addEEnumLiteral(diagramTypeEEnum, DiagramType.DATA_PROCESS_DIAGRAM);

		// Create resource
		createResource(eNS_URI);
	}

} //ScrmPackageImpl
