/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.gmf.runtime.notation.NotationPackage;

import scrm.ScrmPackage;
import scrm.impl.ScrmPackageImpl;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.impl.KnowledgePackageImpl;
import scrm.requirements.Constraint;
import scrm.requirements.DataDefinition;
import scrm.requirements.DataFlow;
import scrm.requirements.Feature;
import scrm.requirements.Hardware;
import scrm.requirements.IRequirement;
import scrm.requirements.Interface;
import scrm.requirements.Performance;
import scrm.requirements.Requirement;
import scrm.requirements.RequirementSpace;
import scrm.requirements.RequirementsFactory;
import scrm.requirements.RequirementsPackage;
import scrm.requirements.SoftwareInterface;
import scrm.requirements.UserInterface;
import scrm.requirements.dataProcess.DataProcessPackage;
import scrm.requirements.dataProcess.impl.DataProcessPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RequirementsPackageImpl extends EPackageImpl implements
		RequirementsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iRequirementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hardwareEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requirementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass softwareInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass performanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataFlowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requirementSpaceEClass = null;

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
	 * @see scrm.requirements.RequirementsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RequirementsPackageImpl() {
		super(eNS_URI, RequirementsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RequirementsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RequirementsPackage init() {
		if (isInited)
			return (RequirementsPackage) EPackage.Registry.INSTANCE
					.getEPackage(RequirementsPackage.eNS_URI);

		// Obtain or create and register package
		RequirementsPackageImpl theRequirementsPackage = (RequirementsPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof RequirementsPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new RequirementsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		NotationPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ScrmPackageImpl theScrmPackage = (ScrmPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(ScrmPackage.eNS_URI) instanceof ScrmPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(ScrmPackage.eNS_URI) : ScrmPackage.eINSTANCE);
		KnowledgePackageImpl theKnowledgePackage = (KnowledgePackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(KnowledgePackage.eNS_URI) instanceof KnowledgePackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(KnowledgePackage.eNS_URI)
				: KnowledgePackage.eINSTANCE);
		DataProcessPackageImpl theDataProcessPackage = (DataProcessPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(DataProcessPackage.eNS_URI) instanceof DataProcessPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(DataProcessPackage.eNS_URI)
				: DataProcessPackage.eINSTANCE);

		// Create package meta-data objects
		theRequirementsPackage.createPackageContents();
		theScrmPackage.createPackageContents();
		theKnowledgePackage.createPackageContents();
		theDataProcessPackage.createPackageContents();

		// Initialize created meta-data
		theRequirementsPackage.initializePackageContents();
		theScrmPackage.initializePackageContents();
		theKnowledgePackage.initializePackageContents();
		theDataProcessPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRequirementsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RequirementsPackage.eNS_URI,
				theRequirementsPackage);
		return theRequirementsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIRequirement() {
		return iRequirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIRequirement_ContainingRequirementSpace() {
		return (EReference) iRequirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterface() {
		return interfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_ProvidingFeature() {
		return (EReference) interfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_RequiringFeatures() {
		return (EReference) interfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_ProvidingData() {
		return (EReference) interfaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_RequiringData() {
		return (EReference) interfaceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_ProvidingRequirements() {
		return (EReference) interfaceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_RequiringRequirements() {
		return (EReference) interfaceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeature() {
		return featureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_Constraints() {
		return (EReference) featureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_Dependencies() {
		return (EReference) featureEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_RequiredInterfaces() {
		return (EReference) featureEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_ProvidedInterfaces() {
		return (EReference) featureEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_DetailedRequirements() {
		return (EReference) featureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_InfluencingProblem() {
		return (EReference) featureEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_SubFeatures() {
		return (EReference) featureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_SuperFeature() {
		return (EReference) featureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_RequiredFeatures() {
		return (EReference) featureEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_RequiringFeatures() {
		return (EReference) featureEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_ExcludedFeatures() {
		return (EReference) featureEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_ExcludingFeatures() {
		return (EReference) featureEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHardware() {
		return hardwareEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHardware_DependingFeature() {
		return (EReference) hardwareEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHardware_Processor() {
		return (EAttribute) hardwareEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHardware_Platform() {
		return (EAttribute) hardwareEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHardware_Memory() {
		return (EAttribute) hardwareEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraint() {
		return constraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraint_RestrictedFeature() {
		return (EReference) constraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequirement() {
		return requirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequirement_Refinements() {
		return (EReference) requirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequirement_RefinedRequirement() {
		return (EReference) requirementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequirement_SpecifiedFeature() {
		return (EReference) requirementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequirement_DefiningData() {
		return (EReference) requirementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequirement_RealizedMethod() {
		return (EReference) requirementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequirement_ProvidedInterface() {
		return (EReference) requirementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequirement_RequiredInterface() {
		return (EReference) requirementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserInterface() {
		return userInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSoftwareInterface() {
		return softwareInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSoftwareInterface_DataTypes() {
		return (EAttribute) softwareInterfaceEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPerformance() {
		return performanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerformance_ProblemSize() {
		return (EAttribute) performanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPerformance_DescribedMethod() {
		return (EReference) performanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataFlow() {
		return dataFlowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataFlow_SpecifiedProcess() {
		return (EReference) dataFlowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataDefinition() {
		return dataDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataDefinition_DefinedRequirement() {
		return (EReference) dataDefinitionEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataDefinition_Accuracy() {
		return (EAttribute) dataDefinitionEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataDefinition_Format() {
		return (EAttribute) dataDefinitionEClass.getEStructuralFeatures()
				.get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataDefinition_ProvidedInterface() {
		return (EReference) dataDefinitionEClass.getEStructuralFeatures()
				.get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataDefinition_RequiredInterface() {
		return (EReference) dataDefinitionEClass.getEStructuralFeatures()
				.get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataDefinition_Range() {
		return (EAttribute) dataDefinitionEClass.getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataDefinition_DataType() {
		return (EAttribute) dataDefinitionEClass.getEStructuralFeatures()
				.get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequirementSpace() {
		return requirementSpaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequirementSpace_ContainedInformationofRequirements() {
		return (EReference) requirementSpaceEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementsFactory getRequirementsFactory() {
		return (RequirementsFactory) getEFactoryInstance();
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
		iRequirementEClass = createEClass(IREQUIREMENT);
		createEReference(iRequirementEClass,
				IREQUIREMENT__CONTAINING_REQUIREMENT_SPACE);

		interfaceEClass = createEClass(INTERFACE);
		createEReference(interfaceEClass, INTERFACE__PROVIDING_FEATURE);
		createEReference(interfaceEClass, INTERFACE__REQUIRING_FEATURES);
		createEReference(interfaceEClass, INTERFACE__PROVIDING_DATA);
		createEReference(interfaceEClass, INTERFACE__REQUIRING_DATA);
		createEReference(interfaceEClass, INTERFACE__PROVIDING_REQUIREMENTS);
		createEReference(interfaceEClass, INTERFACE__REQUIRING_REQUIREMENTS);

		requirementEClass = createEClass(REQUIREMENT);
		createEReference(requirementEClass, REQUIREMENT__REFINEMENTS);
		createEReference(requirementEClass, REQUIREMENT__REFINED_REQUIREMENT);
		createEReference(requirementEClass, REQUIREMENT__SPECIFIED_FEATURE);
		createEReference(requirementEClass, REQUIREMENT__DEFINING_DATA);
		createEReference(requirementEClass, REQUIREMENT__REALIZED_METHOD);
		createEReference(requirementEClass, REQUIREMENT__PROVIDED_INTERFACE);
		createEReference(requirementEClass, REQUIREMENT__REQUIRED_INTERFACE);

		requirementSpaceEClass = createEClass(REQUIREMENT_SPACE);
		createEReference(requirementSpaceEClass,
				REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS);

		featureEClass = createEClass(FEATURE);
		createEReference(featureEClass, FEATURE__DETAILED_REQUIREMENTS);
		createEReference(featureEClass, FEATURE__SUB_FEATURES);
		createEReference(featureEClass, FEATURE__SUPER_FEATURE);
		createEReference(featureEClass, FEATURE__CONSTRAINTS);
		createEReference(featureEClass, FEATURE__DEPENDENCIES);
		createEReference(featureEClass, FEATURE__REQUIRED_INTERFACES);
		createEReference(featureEClass, FEATURE__PROVIDED_INTERFACES);
		createEReference(featureEClass, FEATURE__INFLUENCING_PROBLEM);
		createEReference(featureEClass, FEATURE__REQUIRED_FEATURES);
		createEReference(featureEClass, FEATURE__REQUIRING_FEATURES);
		createEReference(featureEClass, FEATURE__EXCLUDED_FEATURES);
		createEReference(featureEClass, FEATURE__EXCLUDING_FEATURES);

		hardwareEClass = createEClass(HARDWARE);
		createEReference(hardwareEClass, HARDWARE__DEPENDING_FEATURE);
		createEAttribute(hardwareEClass, HARDWARE__PROCESSOR);
		createEAttribute(hardwareEClass, HARDWARE__PLATFORM);
		createEAttribute(hardwareEClass, HARDWARE__MEMORY);

		constraintEClass = createEClass(CONSTRAINT);
		createEReference(constraintEClass, CONSTRAINT__RESTRICTED_FEATURE);

		userInterfaceEClass = createEClass(USER_INTERFACE);

		softwareInterfaceEClass = createEClass(SOFTWARE_INTERFACE);
		createEAttribute(softwareInterfaceEClass,
				SOFTWARE_INTERFACE__DATA_TYPES);

		performanceEClass = createEClass(PERFORMANCE);
		createEAttribute(performanceEClass, PERFORMANCE__PROBLEM_SIZE);
		createEReference(performanceEClass, PERFORMANCE__DESCRIBED_METHOD);

		dataFlowEClass = createEClass(DATA_FLOW);
		createEReference(dataFlowEClass, DATA_FLOW__SPECIFIED_PROCESS);

		dataDefinitionEClass = createEClass(DATA_DEFINITION);
		createEReference(dataDefinitionEClass,
				DATA_DEFINITION__DEFINED_REQUIREMENT);
		createEAttribute(dataDefinitionEClass, DATA_DEFINITION__ACCURACY);
		createEAttribute(dataDefinitionEClass, DATA_DEFINITION__RANGE);
		createEAttribute(dataDefinitionEClass, DATA_DEFINITION__DATA_TYPE);
		createEAttribute(dataDefinitionEClass, DATA_DEFINITION__FORMAT);
		createEReference(dataDefinitionEClass,
				DATA_DEFINITION__PROVIDED_INTERFACE);
		createEReference(dataDefinitionEClass,
				DATA_DEFINITION__REQUIRED_INTERFACE);
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
		DataProcessPackage theDataProcessPackage = (DataProcessPackage) EPackage.Registry.INSTANCE
				.getEPackage(DataProcessPackage.eNS_URI);
		ScrmPackage theScrmPackage = (ScrmPackage) EPackage.Registry.INSTANCE
				.getEPackage(ScrmPackage.eNS_URI);
		KnowledgePackage theKnowledgePackage = (KnowledgePackage) EPackage.Registry.INSTANCE
				.getEPackage(KnowledgePackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE
				.getEPackage(EcorePackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theDataProcessPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		iRequirementEClass.getESuperTypes().add(
				theScrmPackage.getSCRMModelElement());
		interfaceEClass.getESuperTypes().add(this.getIRequirement());
		requirementEClass.getESuperTypes().add(this.getIRequirement());
		requirementSpaceEClass.getESuperTypes().add(
				theScrmPackage.getSCRMSpace());
		requirementSpaceEClass.getESuperTypes().add(this.getIRequirement());
		featureEClass.getESuperTypes().add(this.getIRequirement());
		hardwareEClass.getESuperTypes().add(this.getIRequirement());
		constraintEClass.getESuperTypes().add(this.getIRequirement());
		userInterfaceEClass.getESuperTypes().add(this.getInterface());
		softwareInterfaceEClass.getESuperTypes().add(this.getInterface());
		performanceEClass.getESuperTypes().add(this.getRequirement());
		dataFlowEClass.getESuperTypes().add(this.getIRequirement());
		dataDefinitionEClass.getESuperTypes().add(this.getIRequirement());

		// Initialize classes and features; add operations and parameters
		initEClass(iRequirementEClass, IRequirement.class, "IRequirement",
				IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIRequirement_ContainingRequirementSpace(),
				this.getRequirementSpace(),
				this.getRequirementSpace_ContainedInformationofRequirements(),
				"containingRequirementSpace", null, 0, 1, IRequirement.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(interfaceEClass, Interface.class, "Interface", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterface_ProvidingFeature(), this.getFeature(),
				this.getFeature_ProvidedInterfaces(), "providingFeature", null,
				0, 1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterface_RequiringFeatures(), this.getFeature(),
				this.getFeature_RequiredInterfaces(), "requiringFeatures",
				null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterface_ProvidingData(), this.getDataDefinition(),
				this.getDataDefinition_ProvidedInterface(), "providingData",
				null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterface_RequiringData(), this.getDataDefinition(),
				this.getDataDefinition_RequiredInterface(), "requiringData",
				null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterface_ProvidingRequirements(),
				this.getRequirement(), this.getRequirement_ProvidedInterface(),
				"providingRequirements", null, 0, -1, Interface.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getInterface_RequiringRequirements(),
				this.getRequirement(), this.getRequirement_RequiredInterface(),
				"requiringRequirements", null, 0, -1, Interface.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(requirementEClass, Requirement.class, "Requirement",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRequirement_Refinements(), this.getRequirement(),
				this.getRequirement_RefinedRequirement(), "refinements", null,
				0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequirement_RefinedRequirement(),
				this.getRequirement(), this.getRequirement_Refinements(),
				"refinedRequirement", null, 0, 1, Requirement.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getRequirement_SpecifiedFeature(), this.getFeature(),
				this.getFeature_DetailedRequirements(), "specifiedFeature",
				null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequirement_DefiningData(), this.getDataDefinition(),
				this.getDataDefinition_DefinedRequirement(), "definingData",
				null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequirement_RealizedMethod(),
				theKnowledgePackage.getNumericalMethod(),
				theKnowledgePackage.getNumericalMethod_RealizingRequirement(),
				"realizedMethod", null, 0, 1, Requirement.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequirement_ProvidedInterface(), this.getInterface(),
				this.getInterface_ProvidingRequirements(), "providedInterface",
				null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequirement_RequiredInterface(), this.getInterface(),
				this.getInterface_RequiringRequirements(), "requiredInterface",
				null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requirementSpaceEClass, RequirementSpace.class,
				"RequirementSpace", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(
				getRequirementSpace_ContainedInformationofRequirements(),
				this.getIRequirement(),
				this.getIRequirement_ContainingRequirementSpace(),
				"containedInformationofRequirements", null, 0, -1,
				RequirementSpace.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureEClass, Feature.class, "Feature", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeature_DetailedRequirements(),
				this.getRequirement(), this.getRequirement_SpecifiedFeature(),
				"detailedRequirements", null, 0, -1, Feature.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getFeature_SubFeatures(), this.getFeature(),
				this.getFeature_SuperFeature(), "subFeatures", null, 0, -1,
				Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getFeature_SuperFeature(), this.getFeature(),
				this.getFeature_SubFeatures(), "superFeature", null, 0, 1,
				Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getFeature_Constraints(), this.getConstraint(),
				this.getConstraint_RestrictedFeature(), "constraints", null, 0,
				-1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getFeature_Dependencies(), this.getHardware(),
				this.getHardware_DependingFeature(), "dependencies", null, 0,
				-1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getFeature_RequiredInterfaces(), this.getInterface(),
				this.getInterface_RequiringFeatures(), "requiredInterfaces",
				null, 0, -1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeature_ProvidedInterfaces(), this.getInterface(),
				this.getInterface_ProvidingFeature(), "providedInterfaces",
				null, 0, -1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeature_InfluencingProblem(),
				theKnowledgePackage.getScientificProblem(),
				theKnowledgePackage.getScientificProblem_InfluencedFeature(),
				"influencingProblem", null, 0, 1, Feature.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeature_RequiredFeatures(), this.getFeature(),
				this.getFeature_RequiringFeatures(), "requiredFeatures", null,
				0, -1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeature_RequiringFeatures(), this.getFeature(),
				this.getFeature_RequiredFeatures(), "requiringFeatures", null,
				0, -1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeature_ExcludedFeatures(), this.getFeature(),
				this.getFeature_ExcludingFeatures(), "excludedFeatures", null,
				0, -1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeature_ExcludingFeatures(), this.getFeature(),
				this.getFeature_ExcludedFeatures(), "excludingFeatures", null,
				0, -1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hardwareEClass, Hardware.class, "Hardware", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHardware_DependingFeature(), this.getFeature(),
				this.getFeature_Dependencies(), "dependingFeature", null, 0, 1,
				Hardware.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getHardware_Processor(), ecorePackage.getEString(),
				"processor", null, 0, 1, Hardware.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getHardware_Platform(), ecorePackage.getEString(),
				"platform", null, 0, 1, Hardware.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getHardware_Memory(), theEcorePackage.getEString(),
				"memory", null, 0, 1, Hardware.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(constraintEClass, Constraint.class, "Constraint",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstraint_RestrictedFeature(), this.getFeature(),
				this.getFeature_Constraints(), "restrictedFeature", null, 0, 1,
				Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(userInterfaceEClass, UserInterface.class, "UserInterface",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(softwareInterfaceEClass, SoftwareInterface.class,
				"SoftwareInterface", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSoftwareInterface_DataTypes(),
				ecorePackage.getEString(), "dataTypes", null, 0, 1,
				SoftwareInterface.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(performanceEClass, Performance.class, "Performance",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPerformance_ProblemSize(),
				theEcorePackage.getEString(), "problemSize", null, 0, 1,
				Performance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPerformance_DescribedMethod(),
				theKnowledgePackage.getNumericalMethod(),
				theKnowledgePackage.getNumericalMethod_Performance(),
				"describedMethod", null, 0, 1, Performance.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(dataFlowEClass, DataFlow.class, "DataFlow", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataFlow_SpecifiedProcess(),
				theDataProcessPackage.getProcess(),
				theDataProcessPackage.getProcess_DataFlow(),
				"specifiedProcess", null, 0, 1, DataFlow.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataDefinitionEClass, DataDefinition.class,
				"DataDefinition", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataDefinition_DefinedRequirement(),
				this.getRequirement(), this.getRequirement_DefiningData(),
				"definedRequirement", null, 0, 1, DataDefinition.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getDataDefinition_Accuracy(),
				theEcorePackage.getEString(), "accuracy", null, 0, 1,
				DataDefinition.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getDataDefinition_Range(), ecorePackage.getEString(),
				"range", null, 0, 1, DataDefinition.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataDefinition_DataType(), ecorePackage.getEString(),
				"dataType", null, 0, 1, DataDefinition.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataDefinition_Format(), ecorePackage.getEString(),
				"format", null, 0, 1, DataDefinition.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getDataDefinition_ProvidedInterface(),
				this.getInterface(), this.getInterface_ProvidingData(),
				"providedInterface", null, 0, 1, DataDefinition.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getDataDefinition_RequiredInterface(),
				this.getInterface(), this.getInterface_RequiringData(),
				"requiredInterface", null, 0, 1, DataDefinition.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

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
		addAnnotation(getIRequirement_ContainingRequirementSpace(), source,
				new String[] { "position", "left", "priority", "10" });
		addAnnotation(getInterface_ProvidingFeature(), source, new String[] {
				"position", "left", "priority", "15" });
		addAnnotation(getInterface_RequiringFeatures(), source, new String[] {
				"position", "right", "priority", "10" });
		addAnnotation(getRequirement_Refinements(), source, new String[] {
				"position", "right", "priority", "5" });
		addAnnotation(getRequirement_RefinedRequirement(), source,
				new String[] { "position", "left", "priority", "15" });
		addAnnotation(getRequirement_SpecifiedFeature(), source, new String[] {
				"position", "left", "priority", "20" });
		addAnnotation(getRequirement_DefiningData(), source, new String[] {
				"position", "right", "priority", "10" });
		addAnnotation(getRequirement_RealizedMethod(), source, new String[] {
				"position", "left", "priority", "25" });
		addAnnotation(getRequirementSpace_ContainedInformationofRequirements(),
				source, new String[] { "position", "right", "priority", "10" });
		addAnnotation(getFeature_DetailedRequirements(), source, new String[] {
				"position", "right", "priority", "5" });
		addAnnotation(getFeature_SubFeatures(), source, new String[] {
				"position", "right", "priority", "7" });
		addAnnotation(getFeature_SuperFeature(), source, new String[] {
				"position", "left", "priority", "15" });
		addAnnotation(getFeature_Constraints(), source, new String[] {
				"position", "right", "priority", "10" });
		addAnnotation(getFeature_Dependencies(), source, new String[] {
				"position", "right", "priority", "15" });
		addAnnotation(getFeature_RequiredInterfaces(), source, new String[] {
				"position", "right", "priority", "20" });
		addAnnotation(getFeature_ProvidedInterfaces(), source, new String[] {
				"position", "right", "priority", "25" });
		addAnnotation(getFeature_InfluencingProblem(), source, new String[] {
				"position", "left", "priority", "25" });
		addAnnotation(getFeature_RequiredFeatures(), source, new String[] {
				"position", "right", "priority", "30" });
		addAnnotation(getFeature_RequiringFeatures(), source, new String[] {
				"position", "right", "priority", "35" });
		addAnnotation(getFeature_ExcludedFeatures(), source, new String[] {
				"position", "right", "priority", "40" });
		addAnnotation(getFeature_ExcludingFeatures(), source, new String[] {
				"position", "right", "priority", "45" });
		addAnnotation(getHardware_DependingFeature(), source, new String[] {
				"position", "left", "priority", "15" });
		addAnnotation(getHardware_Processor(), source, new String[] {
				"position", "left", "priority", "5" });
		addAnnotation(getHardware_Platform(), source, new String[] {
				"position", "left", "priority", "6" });
		addAnnotation(getHardware_Memory(), source, new String[] { "position",
				"left", "priority", "7" });
		addAnnotation(getConstraint_RestrictedFeature(), source, new String[] {
				"position", "left", "priority", "15" });
		addAnnotation(getSoftwareInterface_DataTypes(), source, new String[] {
				"position", "left", "priority", "5" });
		addAnnotation(getPerformance_ProblemSize(), source, new String[] {
				"position", "left", "priority", "5" });
		addAnnotation(getDataFlow_SpecifiedProcess(), source, new String[] {
				"position", "left", "priority", "15" });
		addAnnotation(getDataDefinition_DefinedRequirement(), source,
				new String[] { "position", "left", "priority", "15" });
		addAnnotation(getDataDefinition_Accuracy(), source, new String[] {
				"position", "left", "priority", "5" });
		addAnnotation(getDataDefinition_Range(), source, new String[] {
				"position", "left", "priority", "6" });
		addAnnotation(getDataDefinition_DataType(), source, new String[] {
				"position", "left", "priority", "7" });
		addAnnotation(getDataDefinition_Format(), source, new String[] {
				"position", "left", "priority", "8" });
	}

} //RequirementsPackageImpl
