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

import scrm.ScrmPackage;
import scrm.impl.ScrmPackageImpl;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.impl.KnowledgePackageImpl;
import scrm.requirements.RequirementsPackage;
import scrm.requirements.dataProcess.DataProcessFactory;
import scrm.requirements.dataProcess.DataProcessPackage;
import scrm.requirements.dataProcess.DataProcessSpace;
import scrm.requirements.dataProcess.ErrorHandling;
import scrm.requirements.dataProcess.InputDataReading;
import scrm.requirements.dataProcess.MeshCreation;
import scrm.requirements.dataProcess.PostProcessing;
import scrm.requirements.dataProcess.PreProcessing;
import scrm.requirements.dataProcess.ResultsOutput;
import scrm.requirements.dataProcess.Solver;
import scrm.requirements.dataProcess.StatusMonitoring;
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
	private EClass inputDataReadingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resultsOutputEClass = null;

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
	private EClass statusMonitoringEClass = null;

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
	private EClass dataProcessSpaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass solverEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass meshCreationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preProcessingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postProcessingEClass = null;

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

		// Create package meta-data objects
		theDataProcessPackage.createPackageContents();
		theScrmPackage.createPackageContents();
		theKnowledgePackage.createPackageContents();
		theRequirementsPackage.createPackageContents();

		// Initialize created meta-data
		theDataProcessPackage.initializePackageContents();
		theScrmPackage.initializePackageContents();
		theKnowledgePackage.initializePackageContents();
		theRequirementsPackage.initializePackageContents();

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
	public EClass getInputDataReading() {
		return inputDataReadingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResultsOutput() {
		return resultsOutputEClass;
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
	public EClass getStatusMonitoring() {
		return statusMonitoringEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStatusMonitoring_MonitoredProcess() {
		return (EReference) statusMonitoringEClass.getEStructuralFeatures()
				.get(0);
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
	public EReference getProcess_DataFlow() {
		return (EReference) processEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_Predecessor() {
		return (EReference) processEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_Successor() {
		return (EReference) processEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_ContainingDataProcessSpace() {
		return (EReference) processEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_ErrorHandling() {
		return (EReference) processEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_StatusMonitoring() {
		return (EReference) processEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataProcessSpace() {
		return dataProcessSpaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataProcessSpace_ContainedDataProcessSteps() {
		return (EReference) dataProcessSpaceEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSolver() {
		return solverEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeshCreation() {
		return meshCreationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPreProcessing() {
		return preProcessingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostProcessing() {
		return postProcessingEClass;
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
		createEReference(processEClass, PROCESS__DATA_FLOW);
		createEReference(processEClass, PROCESS__PREDECESSOR);
		createEReference(processEClass, PROCESS__SUCCESSOR);
		createEReference(processEClass, PROCESS__CONTAINING_DATA_PROCESS_SPACE);
		createEReference(processEClass, PROCESS__ERROR_HANDLING);
		createEReference(processEClass, PROCESS__STATUS_MONITORING);

		inputDataReadingEClass = createEClass(INPUT_DATA_READING);

		resultsOutputEClass = createEClass(RESULTS_OUTPUT);

		errorHandlingEClass = createEClass(ERROR_HANDLING);
		createEReference(errorHandlingEClass, ERROR_HANDLING__HANDLED_PROCESS);

		statusMonitoringEClass = createEClass(STATUS_MONITORING);
		createEReference(statusMonitoringEClass,
				STATUS_MONITORING__MONITORED_PROCESS);

		dataProcessSpaceEClass = createEClass(DATA_PROCESS_SPACE);
		createEReference(dataProcessSpaceEClass,
				DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS);

		solverEClass = createEClass(SOLVER);

		meshCreationEClass = createEClass(MESH_CREATION);

		preProcessingEClass = createEClass(PRE_PROCESSING);

		postProcessingEClass = createEClass(POST_PROCESSING);
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
		ScrmPackage theScrmPackage = (ScrmPackage) EPackage.Registry.INSTANCE
				.getEPackage(ScrmPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		processEClass.getESuperTypes().add(
				theRequirementsPackage.getRequirement());
		inputDataReadingEClass.getESuperTypes().add(this.getProcess());
		resultsOutputEClass.getESuperTypes().add(this.getProcess());
		errorHandlingEClass.getESuperTypes().add(this.getProcess());
		statusMonitoringEClass.getESuperTypes().add(this.getProcess());
		dataProcessSpaceEClass.getESuperTypes().add(
				theScrmPackage.getSCRMSpace());
		dataProcessSpaceEClass.getESuperTypes().add(this.getProcess());
		solverEClass.getESuperTypes().add(this.getProcess());
		meshCreationEClass.getESuperTypes().add(this.getProcess());
		preProcessingEClass.getESuperTypes().add(this.getProcess());
		postProcessingEClass.getESuperTypes().add(this.getProcess());

		// Initialize classes and features; add operations and parameters
		initEClass(processEClass, scrm.requirements.dataProcess.Process.class,
				"Process", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcess_DataFlow(),
				theRequirementsPackage.getDataFlow(),
				theRequirementsPackage.getDataFlow_SpecifiedProcess(),
				"dataFlow", null, 0, 1,
				scrm.requirements.dataProcess.Process.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
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
		initEReference(getProcess_ContainingDataProcessSpace(),
				this.getDataProcessSpace(),
				this.getDataProcessSpace_ContainedDataProcessSteps(),
				"containingDataProcessSpace", null, 0, 1,
				scrm.requirements.dataProcess.Process.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcess_ErrorHandling(), this.getErrorHandling(),
				this.getErrorHandling_HandledProcess(), "errorHandling", null,
				0, 1, scrm.requirements.dataProcess.Process.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getProcess_StatusMonitoring(),
				this.getStatusMonitoring(),
				this.getStatusMonitoring_MonitoredProcess(),
				"statusMonitoring", null, 0, 1,
				scrm.requirements.dataProcess.Process.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputDataReadingEClass, InputDataReading.class,
				"InputDataReading", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(resultsOutputEClass, ResultsOutput.class, "ResultsOutput",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(errorHandlingEClass, ErrorHandling.class, "ErrorHandling",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorHandling_HandledProcess(), this.getProcess(),
				this.getProcess_ErrorHandling(), "handledProcess", null, 0, 1,
				ErrorHandling.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statusMonitoringEClass, StatusMonitoring.class,
				"StatusMonitoring", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStatusMonitoring_MonitoredProcess(),
				this.getProcess(), this.getProcess_StatusMonitoring(),
				"monitoredProcess", null, 0, 1, StatusMonitoring.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(dataProcessSpaceEClass, DataProcessSpace.class,
				"DataProcessSpace", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataProcessSpace_ContainedDataProcessSteps(),
				this.getProcess(),
				this.getProcess_ContainingDataProcessSpace(),
				"containedDataProcessSteps", null, 0, -1,
				DataProcessSpace.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(solverEClass, Solver.class, "Solver", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(meshCreationEClass, MeshCreation.class, "MeshCreation",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(preProcessingEClass, PreProcessing.class, "PreProcessing",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(postProcessingEClass, PostProcessing.class,
				"PostProcessing", !IS_ABSTRACT, !IS_INTERFACE,
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
		addAnnotation(getProcess_DataFlow(), source, new String[] { "position",
				"right", "priority", "16" });
		addAnnotation(getProcess_Predecessor(), source, new String[] {
				"position", "left", "priority", "15" });
		addAnnotation(getProcess_Successor(), source, new String[] {
				"position", "left", "priority", "15" });
		addAnnotation(getProcess_ContainingDataProcessSpace(), source,
				new String[] { "position", "left", "priority", "10" });
		addAnnotation(getProcess_ErrorHandling(), source, new String[] {
				"position", "right", "priority", "20" });
		addAnnotation(getProcess_StatusMonitoring(), source, new String[] {
				"position", "right", "priority", "20" });
		addAnnotation(getDataProcessSpace_ContainedDataProcessSteps(), source,
				new String[] { "position", "right", "priority", "5" });
	}

} //DataProcessPackageImpl
