/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataProcessing.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.gmf.runtime.notation.NotationPackage;

import org.unicase.metamodel.MetamodelPackage;

import scrm.ScrmPackage;

import scrm.impl.ScrmPackageImpl;

import scrm.knowledge.KnowledgePackage;

import scrm.knowledge.impl.KnowledgePackageImpl;

import scrm.requirements.RequirementsPackage;

import scrm.requirements.dataProcessing.DataHandling;
import scrm.requirements.dataProcessing.DataProcessing;
import scrm.requirements.dataProcessing.DataProcessingFactory;
import scrm.requirements.dataProcessing.DataProcessingPackage;
import scrm.requirements.dataProcessing.ErrorHandling;
import scrm.requirements.dataProcessing.InputDataReading;
import scrm.requirements.dataProcessing.ResultsOutput;
import scrm.requirements.dataProcessing.StatusMonitoring;

import scrm.requirements.impl.RequirementsPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataProcessingPackageImpl extends EPackageImpl implements DataProcessingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataProcessingEClass = null;

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
	private EClass dataHandlingEClass = null;

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
	 * @see scrm.requirements.dataProcessing.DataProcessingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DataProcessingPackageImpl() {
		super(eNS_URI, DataProcessingFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DataProcessingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DataProcessingPackage init() {
		if (isInited) return (DataProcessingPackage)EPackage.Registry.INSTANCE.getEPackage(DataProcessingPackage.eNS_URI);

		// Obtain or create and register package
		DataProcessingPackageImpl theDataProcessingPackage = (DataProcessingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DataProcessingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DataProcessingPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		MetamodelPackage.eINSTANCE.eClass();
		NotationPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ScrmPackageImpl theScrmPackage = (ScrmPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ScrmPackage.eNS_URI) instanceof ScrmPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ScrmPackage.eNS_URI) : ScrmPackage.eINSTANCE);
		KnowledgePackageImpl theKnowledgePackage = (KnowledgePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(KnowledgePackage.eNS_URI) instanceof KnowledgePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(KnowledgePackage.eNS_URI) : KnowledgePackage.eINSTANCE);
		RequirementsPackageImpl theRequirementsPackage = (RequirementsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RequirementsPackage.eNS_URI) instanceof RequirementsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RequirementsPackage.eNS_URI) : RequirementsPackage.eINSTANCE);

		// Create package meta-data objects
		theDataProcessingPackage.createPackageContents();
		theScrmPackage.createPackageContents();
		theKnowledgePackage.createPackageContents();
		theRequirementsPackage.createPackageContents();

		// Initialize created meta-data
		theDataProcessingPackage.initializePackageContents();
		theScrmPackage.initializePackageContents();
		theKnowledgePackage.initializePackageContents();
		theRequirementsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDataProcessingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DataProcessingPackage.eNS_URI, theDataProcessingPackage);
		return theDataProcessingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataProcessing() {
		return dataProcessingEClass;
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
	public EClass getDataHandling() {
		return dataHandlingEClass;
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
	public EClass getStatusMonitoring() {
		return statusMonitoringEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataProcessingFactory getDataProcessingFactory() {
		return (DataProcessingFactory)getEFactoryInstance();
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
		dataProcessingEClass = createEClass(DATA_PROCESSING);

		inputDataReadingEClass = createEClass(INPUT_DATA_READING);

		dataHandlingEClass = createEClass(DATA_HANDLING);

		resultsOutputEClass = createEClass(RESULTS_OUTPUT);

		errorHandlingEClass = createEClass(ERROR_HANDLING);

		statusMonitoringEClass = createEClass(STATUS_MONITORING);
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
		RequirementsPackage theRequirementsPackage = (RequirementsPackage)EPackage.Registry.INSTANCE.getEPackage(RequirementsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		dataProcessingEClass.getESuperTypes().add(theRequirementsPackage.getRequirement());
		inputDataReadingEClass.getESuperTypes().add(this.getDataProcessing());
		dataHandlingEClass.getESuperTypes().add(this.getDataProcessing());
		resultsOutputEClass.getESuperTypes().add(this.getDataProcessing());
		errorHandlingEClass.getESuperTypes().add(this.getDataProcessing());
		statusMonitoringEClass.getESuperTypes().add(this.getDataProcessing());

		// Initialize classes and features; add operations and parameters
		initEClass(dataProcessingEClass, DataProcessing.class, "DataProcessing", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inputDataReadingEClass, InputDataReading.class, "InputDataReading", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataHandlingEClass, DataHandling.class, "DataHandling", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(resultsOutputEClass, ResultsOutput.class, "ResultsOutput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(errorHandlingEClass, ErrorHandling.class, "ErrorHandling", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(statusMonitoringEClass, StatusMonitoring.class, "StatusMonitoring", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} //DataProcessingPackageImpl
