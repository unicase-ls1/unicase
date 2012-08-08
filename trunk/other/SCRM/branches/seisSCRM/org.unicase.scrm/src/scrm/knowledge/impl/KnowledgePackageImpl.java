/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.knowledge.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.gmf.runtime.notation.NotationPackage;

import scrm.ScrmPackage;
import scrm.impl.ScrmPackageImpl;
import scrm.knowledge.Assumption;
import scrm.knowledge.GeophysicalModel;
import scrm.knowledge.KnowledgeFactory;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.KnowledgeSpace;
import scrm.knowledge.MathematicalModel;
import scrm.knowledge.NumericalMethod;
import scrm.knowledge.ScientificKnowledge;
import scrm.knowledge.ScientificProblem;
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
	private EClass mathematicalModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numericalMethodEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assumptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass geophysicalModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass knowledgeSpaceEClass = null;

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

		// Create package meta-data objects
		theKnowledgePackage.createPackageContents();
		theScrmPackage.createPackageContents();
		theRequirementsPackage.createPackageContents();
		theDataProcessPackage.createPackageContents();

		// Initialize created meta-data
		theKnowledgePackage.initializePackageContents();
		theScrmPackage.initializePackageContents();
		theRequirementsPackage.initializePackageContents();
		theDataProcessPackage.initializePackageContents();

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
	public EReference getScientificKnowledge_ContainingKnowledgeSpace() {
		return (EReference) scientificKnowledgeEClass.getEStructuralFeatures()
				.get(0);
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
	public EClass getMathematicalModel() {
		return mathematicalModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMathematicalModel_RepresentedProblem() {
		return (EReference) mathematicalModelEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMathematicalModel_Refinements() {
		return (EReference) mathematicalModelEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMathematicalModel_RefinedModel() {
		return (EReference) mathematicalModelEClass.getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMathematicalModel_UsedInNumericalMethods() {
		return (EReference) mathematicalModelEClass.getEStructuralFeatures()
				.get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMathematicalModel_Dependencies() {
		return (EReference) mathematicalModelEClass.getEStructuralFeatures()
				.get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMathematicalModel_InvolvedData() {
		return (EReference) mathematicalModelEClass.getEStructuralFeatures()
				.get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumericalMethod() {
		return numericalMethodEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumericalMethod_SolvedProblem() {
		return (EReference) numericalMethodEClass.getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumericalMethod_Dependencies() {
		return (EReference) numericalMethodEClass.getEStructuralFeatures().get(
				1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumericalMethod_RealizingRequirement() {
		return (EReference) numericalMethodEClass.getEStructuralFeatures().get(
				2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumericalMethod_UsingMathematicalModel() {
		return (EReference) numericalMethodEClass.getEStructuralFeatures().get(
				3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumericalMethod_Performance() {
		return (EReference) numericalMethodEClass.getEStructuralFeatures().get(
				4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumericalMethod_Algorithm() {
		return (EAttribute) numericalMethodEClass.getEStructuralFeatures().get(
				5);
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
	public EClass getGeophysicalModel() {
		return geophysicalModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKnowledgeSpace() {
		return knowledgeSpaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKnowledgeSpace_ContainedScientificKnowledge() {
		return (EReference) knowledgeSpaceEClass.getEStructuralFeatures()
				.get(0);
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
		createEReference(scientificKnowledgeEClass,
				SCIENTIFIC_KNOWLEDGE__CONTAINING_KNOWLEDGE_SPACE);

		knowledgeSpaceEClass = createEClass(KNOWLEDGE_SPACE);
		createEReference(knowledgeSpaceEClass,
				KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_KNOWLEDGE);

		scientificProblemEClass = createEClass(SCIENTIFIC_PROBLEM);
		createEReference(scientificProblemEClass,
				SCIENTIFIC_PROBLEM__REPRESENTING_MODEL);
		createEReference(scientificProblemEClass,
				SCIENTIFIC_PROBLEM__SOLVING_METHODS);
		createEReference(scientificProblemEClass,
				SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE);

		mathematicalModelEClass = createEClass(MATHEMATICAL_MODEL);
		createEReference(mathematicalModelEClass,
				MATHEMATICAL_MODEL__REPRESENTED_PROBLEM);
		createEReference(mathematicalModelEClass,
				MATHEMATICAL_MODEL__REFINEMENTS);
		createEReference(mathematicalModelEClass,
				MATHEMATICAL_MODEL__REFINED_MODEL);
		createEReference(mathematicalModelEClass,
				MATHEMATICAL_MODEL__USED_IN_NUMERICAL_METHODS);
		createEReference(mathematicalModelEClass,
				MATHEMATICAL_MODEL__DEPENDENCIES);
		createEReference(mathematicalModelEClass,
				MATHEMATICAL_MODEL__INVOLVED_DATA);

		numericalMethodEClass = createEClass(NUMERICAL_METHOD);
		createEReference(numericalMethodEClass,
				NUMERICAL_METHOD__SOLVED_PROBLEM);
		createEReference(numericalMethodEClass, NUMERICAL_METHOD__DEPENDENCIES);
		createEReference(numericalMethodEClass,
				NUMERICAL_METHOD__REALIZING_REQUIREMENT);
		createEReference(numericalMethodEClass,
				NUMERICAL_METHOD__USING_MATHEMATICAL_MODEL);
		createEReference(numericalMethodEClass, NUMERICAL_METHOD__PERFORMANCE);
		createEAttribute(numericalMethodEClass, NUMERICAL_METHOD__ALGORITHM);

		assumptionEClass = createEClass(ASSUMPTION);
		createEReference(assumptionEClass, ASSUMPTION__DEPENDING_MODEL);
		createEReference(assumptionEClass, ASSUMPTION__DEPENDING_METHOD);

		geophysicalModelEClass = createEClass(GEOPHYSICAL_MODEL);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		scientificKnowledgeEClass.getESuperTypes().add(
				theScrmPackage.getSCRMModelElement());
		knowledgeSpaceEClass.getESuperTypes()
				.add(theScrmPackage.getSCRMSpace());
		knowledgeSpaceEClass.getESuperTypes()
				.add(this.getScientificKnowledge());
		scientificProblemEClass.getESuperTypes().add(
				this.getScientificKnowledge());
		mathematicalModelEClass.getESuperTypes().add(
				this.getScientificKnowledge());
		numericalMethodEClass.getESuperTypes().add(
				this.getScientificKnowledge());
		assumptionEClass.getESuperTypes().add(this.getScientificKnowledge());
		geophysicalModelEClass.getESuperTypes()
				.add(this.getMathematicalModel());

		// Initialize classes and features; add operations and parameters
		initEClass(scientificKnowledgeEClass, ScientificKnowledge.class,
				"ScientificKnowledge", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScientificKnowledge_ContainingKnowledgeSpace(),
				this.getKnowledgeSpace(),
				this.getKnowledgeSpace_ContainedScientificKnowledge(),
				"containingKnowledgeSpace", null, 0, 1,
				ScientificKnowledge.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(knowledgeSpaceEClass, KnowledgeSpace.class,
				"KnowledgeSpace", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKnowledgeSpace_ContainedScientificKnowledge(),
				this.getScientificKnowledge(),
				this.getScientificKnowledge_ContainingKnowledgeSpace(),
				"containedScientificKnowledge", null, 0, -1,
				KnowledgeSpace.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scientificProblemEClass, ScientificProblem.class,
				"ScientificProblem", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScientificProblem_RepresentingModel(),
				this.getMathematicalModel(),
				this.getMathematicalModel_RepresentedProblem(),
				"representingModel", null, 0, -1, ScientificProblem.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getScientificProblem_SolvingMethods(),
				this.getNumericalMethod(),
				this.getNumericalMethod_SolvedProblem(), "solvingMethods",
				null, 0, -1, ScientificProblem.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScientificProblem_InfluencedFeature(),
				theRequirementsPackage.getFeature(),
				theRequirementsPackage.getFeature_InfluencingProblem(),
				"influencedFeature", null, 0, 1, ScientificProblem.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(mathematicalModelEClass, MathematicalModel.class,
				"MathematicalModel", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMathematicalModel_RepresentedProblem(),
				this.getScientificProblem(),
				this.getScientificProblem_RepresentingModel(),
				"representedProblem", null, 0, 1, MathematicalModel.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getMathematicalModel_Refinements(),
				this.getMathematicalModel(),
				this.getMathematicalModel_RefinedModel(), "refinements", null,
				0, -1, MathematicalModel.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMathematicalModel_RefinedModel(),
				this.getMathematicalModel(),
				this.getMathematicalModel_Refinements(), "refinedModel", null,
				0, 1, MathematicalModel.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMathematicalModel_UsedInNumericalMethods(),
				this.getNumericalMethod(),
				this.getNumericalMethod_UsingMathematicalModel(),
				"usedInNumericalMethods", null, 0, -1, MathematicalModel.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getMathematicalModel_Dependencies(),
				this.getAssumption(), this.getAssumption_DependingModel(),
				"dependencies", null, 0, -1, MathematicalModel.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getMathematicalModel_InvolvedData(),
				theRequirementsPackage.getDataDefinition(), null,
				"involvedData", null, 0, -1, MathematicalModel.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(numericalMethodEClass, NumericalMethod.class,
				"NumericalMethod", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNumericalMethod_SolvedProblem(),
				this.getScientificProblem(),
				this.getScientificProblem_SolvingMethods(), "solvedProblem",
				null, 0, 1, NumericalMethod.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNumericalMethod_Dependencies(), this.getAssumption(),
				this.getAssumption_DependingMethod(), "dependencies", null, 0,
				-1, NumericalMethod.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNumericalMethod_RealizingRequirement(),
				theRequirementsPackage.getRequirement(),
				theRequirementsPackage.getRequirement_RealizedMethod(),
				"realizingRequirement", null, 0, 1, NumericalMethod.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getNumericalMethod_UsingMathematicalModel(),
				this.getMathematicalModel(),
				this.getMathematicalModel_UsedInNumericalMethods(),
				"usingMathematicalModel", null, 0, 1, NumericalMethod.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getNumericalMethod_Performance(),
				theRequirementsPackage.getPerformance(), null, "performance",
				null, 0, 1, NumericalMethod.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNumericalMethod_Algorithm(),
				ecorePackage.getEString(), "algorithm", null, 0, 1,
				NumericalMethod.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(assumptionEClass, Assumption.class, "Assumption",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssumption_DependingModel(),
				this.getMathematicalModel(),
				this.getMathematicalModel_Dependencies(), "dependingModel",
				null, 0, 1, Assumption.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssumption_DependingMethod(),
				this.getNumericalMethod(),
				this.getNumericalMethod_Dependencies(), "dependingMethod",
				null, 0, 1, Assumption.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(geophysicalModelEClass, GeophysicalModel.class,
				"GeophysicalModel", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

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
		addAnnotation(getScientificKnowledge_ContainingKnowledgeSpace(),
				source, new String[] { "position", "left", "priority", "10" });
		addAnnotation(getKnowledgeSpace_ContainedScientificKnowledge(), source,
				new String[] { "position", "right", "priority", "10" });
		addAnnotation(getScientificProblem_InfluencedFeature(), source,
				new String[] { "position", "left", "priority", "15" });
		addAnnotation(getMathematicalModel_RepresentedProblem(), source,
				new String[] { "position", "left", "priority", "15" });
		addAnnotation(getMathematicalModel_Refinements(), source, new String[] {
				"position", "right", "priority", "5" });
		addAnnotation(getMathematicalModel_RefinedModel(), source,
				new String[] { "position", "left", "priority", "14" });
		addAnnotation(getMathematicalModel_UsedInNumericalMethods(), source,
				new String[] { "position", "left", "priority", "15" });
		addAnnotation(getMathematicalModel_Dependencies(), source,
				new String[] { "position", "right", "priority", "15" });
		addAnnotation(getMathematicalModel_InvolvedData(), source,
				new String[] { "position", "left", "priority", "15" });
		addAnnotation(getNumericalMethod_SolvedProblem(), source, new String[] {
				"position", "left", "priority", "15" });
		addAnnotation(getNumericalMethod_Dependencies(), source, new String[] {
				"position", "right", "priority", "10" });
		addAnnotation(getNumericalMethod_RealizingRequirement(), source,
				new String[] { "position", "left", "priority", "25" });
		addAnnotation(getNumericalMethod_UsingMathematicalModel(), source,
				new String[] { "position", "left", "priority", "20" });
		addAnnotation(getNumericalMethod_Performance(), source, new String[] {
				"position", "left", "priority", "30" });
		addAnnotation(getNumericalMethod_Algorithm(), source, new String[] {
				"position", "left", "priority", "7" });
		addAnnotation(getAssumption_DependingModel(), source, new String[] {
				"position", "left", "priority", "15" });
		addAnnotation(getAssumption_DependingMethod(), source, new String[] {
				"position", "left", "priority", "20" });
	}

} //KnowledgePackageImpl
