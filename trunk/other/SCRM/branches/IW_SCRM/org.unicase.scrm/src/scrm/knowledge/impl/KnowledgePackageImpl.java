/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.knowledge.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.unicase.model.ModelPackage;

import scrm.ScrmPackage;
import scrm.impl.ScrmPackageImpl;
import scrm.knowledge.Assumption;
import scrm.knowledge.KnowledgeFactory;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.Method;
import scrm.knowledge.Model;
import scrm.knowledge.ScientificKnowledge;
import scrm.knowledge.ScientificProblem;
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
public class KnowledgePackageImpl extends EPackageImpl implements
		KnowledgePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scientificKnowledgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scientificProblemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assumptionEClass = null;

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
	 * @see scrm.knowledge.KnowledgePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private KnowledgePackageImpl() {
		super(eNS_URI, KnowledgeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link KnowledgePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static KnowledgePackage init() {
		if (isInited)
			return (KnowledgePackage) EPackage.Registry.INSTANCE
					.getEPackage(KnowledgePackage.eNS_URI);

		// Obtain or create and register package
		KnowledgePackageImpl theKnowledgePackage = (KnowledgePackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof KnowledgePackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new KnowledgePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();
		NotationPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ScrmPackageImpl theScrmPackage = (ScrmPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(ScrmPackage.eNS_URI) instanceof ScrmPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(ScrmPackage.eNS_URI) : ScrmPackage.eINSTANCE);
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
		theKnowledgePackage.createPackageContents();
		theScrmPackage.createPackageContents();
		theRequirementsPackage.createPackageContents();
		theDataProcessPackage.createPackageContents();
		theDataObjectPackage.createPackageContents();

		// Initialize created meta-data
		theKnowledgePackage.initializePackageContents();
		theScrmPackage.initializePackageContents();
		theRequirementsPackage.initializePackageContents();
		theDataProcessPackage.initializePackageContents();
		theDataObjectPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theKnowledgePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(KnowledgePackage.eNS_URI,
				theKnowledgePackage);
		return theKnowledgePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScientificKnowledge() {
		return scientificKnowledgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScientificProblem() {
		return scientificProblemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScientificProblem_RepresentingModel() {
		return (EReference) scientificProblemEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScientificProblem_SolvingMethods() {
		return (EReference) scientificProblemEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScientificProblem_InfluencedFeature() {
		return (EReference) scientificProblemEClass.getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModel() {
		return modelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_RepresentedProblem() {
		return (EReference) modelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_Refinements() {
		return (EReference) modelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_RefinedModel() {
		return (EReference) modelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_UsedInMethods() {
		return (EReference) modelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_Dependencies() {
		return (EReference) modelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_InvolvedData() {
		return (EReference) modelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethod() {
		return methodEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethod_SolvedProblem() {
		return (EReference) methodEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethod_Dependencies() {
		return (EReference) methodEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethod_RealizingRequirement() {
		return (EReference) methodEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethod_UsingModel() {
		return (EReference) methodEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethod_Performance() {
		return (EReference) methodEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssumption() {
		return assumptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssumption_DependingModel() {
		return (EReference) assumptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssumption_DependingMethod() {
		return (EReference) assumptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KnowledgeFactory getKnowledgeFactory() {
		return (KnowledgeFactory) getEFactoryInstance();
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
		scientificKnowledgeEClass = createEClass(SCIENTIFIC_KNOWLEDGE);

		scientificProblemEClass = createEClass(SCIENTIFIC_PROBLEM);
		createEReference(scientificProblemEClass,
				SCIENTIFIC_PROBLEM__REPRESENTING_MODEL);
		createEReference(scientificProblemEClass,
				SCIENTIFIC_PROBLEM__SOLVING_METHODS);
		createEReference(scientificProblemEClass,
				SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE);

		modelEClass = createEClass(MODEL);
		createEReference(modelEClass, MODEL__REPRESENTED_PROBLEM);
		createEReference(modelEClass, MODEL__REFINEMENTS);
		createEReference(modelEClass, MODEL__REFINED_MODEL);
		createEReference(modelEClass, MODEL__USED_IN_METHODS);
		createEReference(modelEClass, MODEL__DEPENDENCIES);
		createEReference(modelEClass, MODEL__INVOLVED_DATA);

		methodEClass = createEClass(METHOD);
		createEReference(methodEClass, METHOD__SOLVED_PROBLEM);
		createEReference(methodEClass, METHOD__DEPENDENCIES);
		createEReference(methodEClass, METHOD__REALIZING_REQUIREMENT);
		createEReference(methodEClass, METHOD__USING_MODEL);
		createEReference(methodEClass, METHOD__PERFORMANCE);

		assumptionEClass = createEClass(ASSUMPTION);
		createEReference(assumptionEClass, ASSUMPTION__DEPENDING_MODEL);
		createEReference(assumptionEClass, ASSUMPTION__DEPENDING_METHOD);
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
		ScrmPackage theScrmPackage = (ScrmPackage) EPackage.Registry.INSTANCE
				.getEPackage(ScrmPackage.eNS_URI);
		RequirementsPackage theRequirementsPackage = (RequirementsPackage) EPackage.Registry.INSTANCE
				.getEPackage(RequirementsPackage.eNS_URI);
		DataObjectPackage theDataObjectPackage = (DataObjectPackage) EPackage.Registry.INSTANCE
				.getEPackage(DataObjectPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		scientificKnowledgeEClass.getESuperTypes().add(
				theScrmPackage.getSCRMModelElement());
		scientificProblemEClass.getESuperTypes().add(
				this.getScientificKnowledge());
		modelEClass.getESuperTypes().add(this.getScientificKnowledge());
		methodEClass.getESuperTypes().add(this.getScientificKnowledge());
		assumptionEClass.getESuperTypes().add(this.getScientificKnowledge());

		// Initialize classes and features; add operations and parameters
		initEClass(scientificKnowledgeEClass, ScientificKnowledge.class,
				"ScientificKnowledge", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(scientificProblemEClass, ScientificProblem.class,
				"ScientificProblem", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScientificProblem_RepresentingModel(),
				this.getModel(), this.getModel_RepresentedProblem(),
				"representingModel", null, 0, -1, ScientificProblem.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getScientificProblem_SolvingMethods(), this.getMethod(),
				this.getMethod_SolvedProblem(), "solvingMethods", null, 0, -1,
				ScientificProblem.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScientificProblem_InfluencedFeature(),
				theRequirementsPackage.getFeature(),
				theRequirementsPackage.getFeature_InfluencingProblem(),
				"influencedFeature", null, 0, 1, ScientificProblem.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModel_RepresentedProblem(),
				this.getScientificProblem(),
				this.getScientificProblem_RepresentingModel(),
				"representedProblem", null, 0, 1, Model.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_Refinements(), this.getModel(),
				this.getModel_RefinedModel(), "refinements", null, 0, -1,
				Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getModel_RefinedModel(), this.getModel(),
				this.getModel_Refinements(), "refinedModel", null, 0, 1,
				Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getModel_UsedInMethods(), this.getMethod(),
				this.getMethod_UsingModel(), "usedInMethods", null, 0, -1,
				Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				IS_DERIVED, IS_ORDERED);
		initEReference(getModel_Dependencies(), this.getAssumption(),
				this.getAssumption_DependingModel(), "dependencies", null, 0,
				-1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getModel_InvolvedData(), theDataObjectPackage.getData(),
				theDataObjectPackage.getData_DescribedModel(), "involvedData",
				null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(methodEClass, Method.class, "Method", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMethod_SolvedProblem(), this.getScientificProblem(),
				this.getScientificProblem_SolvingMethods(), "solvedProblem",
				null, 0, 1, Method.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMethod_Dependencies(), this.getAssumption(),
				this.getAssumption_DependingMethod(), "dependencies", null, 0,
				-1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getMethod_RealizingRequirement(),
				theRequirementsPackage.getRequirement(),
				theRequirementsPackage.getRequirement_RealizedMethod(),
				"realizingRequirement", null, 0, 1, Method.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getMethod_UsingModel(), this.getModel(),
				this.getModel_UsedInMethods(), "usingModel", null, 0, 1,
				Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getMethod_Performance(),
				theRequirementsPackage.getPerformance(), null, "performance",
				null, 0, 1, Method.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assumptionEClass, Assumption.class, "Assumption",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssumption_DependingModel(), this.getModel(),
				this.getModel_Dependencies(), "dependingModel", null, 0, 1,
				Assumption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getAssumption_DependingMethod(), this.getMethod(),
				this.getMethod_Dependencies(), "dependingMethod", null, 0, 1,
				Assumption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

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
		addAnnotation(getScientificProblem_InfluencedFeature(), source,
				new String[] { "position", "left", "priority", "15" });
		addAnnotation(getModel_RepresentedProblem(), source, new String[] {
				"position", "left", "priority", "15" });
		addAnnotation(getModel_Refinements(), source, new String[] {
				"position", "right", "priority", "5" });
		addAnnotation(getModel_RefinedModel(), source, new String[] {
				"position", "left", "priority", "14" });
		addAnnotation(getModel_UsedInMethods(), source, new String[] {
				"position", "left", "priority", "15" });
		addAnnotation(getModel_Dependencies(), source, new String[] {
				"position", "right", "priority", "15" });
		addAnnotation(getModel_InvolvedData(), source, new String[] {
				"position", "left", "priority", "15" });
		addAnnotation(getMethod_SolvedProblem(), source, new String[] {
				"position", "left", "priority", "15" });
		addAnnotation(getMethod_Dependencies(), source, new String[] {
				"position", "right", "priority", "10" });
		addAnnotation(getMethod_RealizingRequirement(), source, new String[] {
				"position", "left", "priority", "25" });
		addAnnotation(getMethod_UsingModel(), source, new String[] {
				"position", "left", "priority", "20" });
		addAnnotation(getMethod_Performance(), source, new String[] {
				"position", "left", "priority", "30" });
		addAnnotation(getAssumption_DependingModel(), source, new String[] {
				"position", "left", "priority", "15" });
		addAnnotation(getAssumption_DependingMethod(), source, new String[] {
				"position", "left", "priority", "20" });
	}

} //KnowledgePackageImpl
