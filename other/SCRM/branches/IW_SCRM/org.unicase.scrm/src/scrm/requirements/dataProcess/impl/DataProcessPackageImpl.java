/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataProcess.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.unicase.model.ModelPackage;

import scrm.ScrmPackage;
import scrm.impl.ScrmPackageImpl;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.impl.KnowledgePackageImpl;
import scrm.requirements.RequirementsPackage;
import scrm.requirements.dataObject.DataObjectPackage;
import scrm.requirements.dataObject.impl.DataObjectPackageImpl;
import scrm.requirements.dataProcess.BuildingModelConstructionProcess;
import scrm.requirements.dataProcess.ControlSystemDesignProcess;
import scrm.requirements.dataProcess.CostMinimizationCalculationProcess;
import scrm.requirements.dataProcess.DataProcessFactory;
import scrm.requirements.dataProcess.DataProcessPackage;
import scrm.requirements.dataProcess.DataVisualizationProcess;
import scrm.requirements.dataProcess.EnergyUsageCalculationProcess;
import scrm.requirements.dataProcess.ErrorHandling;
import scrm.requirements.dataProcess.ReportGenerationProcess;
import scrm.requirements.impl.RequirementsPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataProcessPackageImpl extends EPackageImpl implements
		DataProcessPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorHandlingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass buildingModelConstructionProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass costMinimizationCalculationProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass controlSystemDesignProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass energyUsageCalculationProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataVisualizationProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reportGenerationProcessEClass = null;

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
	 * @see scrm.requirements.dataProcess.DataProcessPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DataProcessPackageImpl() {
		super(eNS_URI, DataProcessFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DataProcessPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DataProcessPackage init() {
		if (isInited)
			return (DataProcessPackage) EPackage.Registry.INSTANCE
					.getEPackage(DataProcessPackage.eNS_URI);

		// Obtain or create and register package
		DataProcessPackageImpl theDataProcessPackage = (DataProcessPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof DataProcessPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new DataProcessPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();
		NotationPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ScrmPackageImpl theScrmPackage = (ScrmPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(ScrmPackage.eNS_URI) instanceof ScrmPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(ScrmPackage.eNS_URI) : ScrmPackage.eINSTANCE);
		KnowledgePackageImpl theKnowledgePackage = (KnowledgePackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(KnowledgePackage.eNS_URI) instanceof KnowledgePackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(KnowledgePackage.eNS_URI)
				: KnowledgePackage.eINSTANCE);
		RequirementsPackageImpl theRequirementsPackage = (RequirementsPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(RequirementsPackage.eNS_URI) instanceof RequirementsPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(RequirementsPackage.eNS_URI)
				: RequirementsPackage.eINSTANCE);
		DataObjectPackageImpl theDataObjectPackage = (DataObjectPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(DataObjectPackage.eNS_URI) instanceof DataObjectPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(DataObjectPackage.eNS_URI)
				: DataObjectPackage.eINSTANCE);

		// Create package meta-data objects
		theDataProcessPackage.createPackageContents();
		theScrmPackage.createPackageContents();
		theKnowledgePackage.createPackageContents();
		theRequirementsPackage.createPackageContents();
		theDataObjectPackage.createPackageContents();

		// Initialize created meta-data
		theDataProcessPackage.initializePackageContents();
		theScrmPackage.initializePackageContents();
		theKnowledgePackage.initializePackageContents();
		theRequirementsPackage.initializePackageContents();
		theDataObjectPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDataProcessPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DataProcessPackage.eNS_URI,
				theDataProcessPackage);
		return theDataProcessPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getErrorHandling() {
		return errorHandlingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getErrorHandling_HandledProcess() {
		return (EReference) errorHandlingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuildingModelConstructionProcess() {
		return buildingModelConstructionProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCostMinimizationCalculationProcess() {
		return costMinimizationCalculationProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getControlSystemDesignProcess() {
		return controlSystemDesignProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnergyUsageCalculationProcess() {
		return energyUsageCalculationProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcess() {
		return processEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_Predecessor() {
		return (EReference) processEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_Successor() {
		return (EReference) processEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_ErrorHandling() {
		return (EReference) processEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataVisualizationProcess() {
		return dataVisualizationProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReportGenerationProcess() {
		return reportGenerationProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataProcessFactory getDataProcessFactory() {
		return (DataProcessFactory) getEFactoryInstance();
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
		processEClass = createEClass(PROCESS);
		createEReference(processEClass, PROCESS__PREDECESSOR);
		createEReference(processEClass, PROCESS__SUCCESSOR);
		createEReference(processEClass, PROCESS__ERROR_HANDLING);

		dataVisualizationProcessEClass = createEClass(DATA_VISUALIZATION_PROCESS);

		reportGenerationProcessEClass = createEClass(REPORT_GENERATION_PROCESS);

		errorHandlingEClass = createEClass(ERROR_HANDLING);
		createEReference(errorHandlingEClass, ERROR_HANDLING__HANDLED_PROCESS);

		buildingModelConstructionProcessEClass = createEClass(BUILDING_MODEL_CONSTRUCTION_PROCESS);

		costMinimizationCalculationProcessEClass = createEClass(COST_MINIMIZATION_CALCULATION_PROCESS);

		controlSystemDesignProcessEClass = createEClass(CONTROL_SYSTEM_DESIGN_PROCESS);

		energyUsageCalculationProcessEClass = createEClass(ENERGY_USAGE_CALCULATION_PROCESS);
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
		RequirementsPackage theRequirementsPackage = (RequirementsPackage) EPackage.Registry.INSTANCE
				.getEPackage(RequirementsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		processEClass.getESuperTypes().add(
				theRequirementsPackage.getRequirement());
		dataVisualizationProcessEClass.getESuperTypes().add(this.getProcess());
		reportGenerationProcessEClass.getESuperTypes().add(this.getProcess());
		errorHandlingEClass.getESuperTypes().add(this.getProcess());
		buildingModelConstructionProcessEClass.getESuperTypes().add(
				this.getProcess());
		costMinimizationCalculationProcessEClass.getESuperTypes().add(
				this.getProcess());
		controlSystemDesignProcessEClass.getESuperTypes()
				.add(this.getProcess());
		energyUsageCalculationProcessEClass.getESuperTypes().add(
				this.getProcess());

		// Initialize classes and features; add operations and parameters
		initEClass(processEClass, scrm.requirements.dataProcess.Process.class,
				"Process", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcess_Predecessor(), this.getProcess(),
				this.getProcess_Successor(), "predecessor", null, 0, 1,
				scrm.requirements.dataProcess.Process.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcess_Successor(), this.getProcess(),
				this.getProcess_Predecessor(), "successor", null, 0, 1,
				scrm.requirements.dataProcess.Process.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcess_ErrorHandling(), this.getErrorHandling(),
				this.getErrorHandling_HandledProcess(), "errorHandling", null,
				0, 1, scrm.requirements.dataProcess.Process.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(dataVisualizationProcessEClass,
				DataVisualizationProcess.class, "DataVisualizationProcess",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(reportGenerationProcessEClass,
				ReportGenerationProcess.class, "ReportGenerationProcess",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(errorHandlingEClass, ErrorHandling.class, "ErrorHandling",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorHandling_HandledProcess(), this.getProcess(),
				this.getProcess_ErrorHandling(), "handledProcess", null, 0, 1,
				ErrorHandling.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(buildingModelConstructionProcessEClass,
				BuildingModelConstructionProcess.class,
				"BuildingModelConstructionProcess", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(costMinimizationCalculationProcessEClass,
				CostMinimizationCalculationProcess.class,
				"CostMinimizationCalculationProcess", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(controlSystemDesignProcessEClass,
				ControlSystemDesignProcess.class, "ControlSystemDesignProcess",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(energyUsageCalculationProcessEClass,
				EnergyUsageCalculationProcess.class,
				"EnergyUsageCalculationProcess", !IS_ABSTRACT, !IS_INTERFACE,
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
		addAnnotation(getProcess_Predecessor(), source, new String[] {
				"position", "left", "priority", "15" });
		addAnnotation(getProcess_Successor(), source, new String[] {
				"position", "left", "priority", "15" });
		addAnnotation(getProcess_ErrorHandling(), source, new String[] {
				"position", "right", "priority", "20" });
	}

} //DataProcessPackageImpl
