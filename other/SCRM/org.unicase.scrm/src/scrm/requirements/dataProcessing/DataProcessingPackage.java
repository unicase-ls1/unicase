/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataProcessing;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import scrm.requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see scrm.requirements.dataProcessing.DataProcessingFactory
 * @model kind="package"
 * @generated
 */
public interface DataProcessingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dataProcessing";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/scrm/requirements/dataProcessing";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.scrm.requirements.dataProcessing";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataProcessingPackage eINSTANCE = scrm.requirements.dataProcessing.impl.DataProcessingPackageImpl.init();

	/**
	 * The meta object id for the '{@link scrm.requirements.dataProcessing.DataProcessing <em>Data Processing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataProcessing.DataProcessing
	 * @see scrm.requirements.dataProcessing.impl.DataProcessingPackageImpl#getDataProcessing()
	 * @generated
	 */
	int DATA_PROCESSING = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESSING__NAME = RequirementsPackage.REQUIREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESSING__DESCRIPTION = RequirementsPackage.REQUIREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Containing Requirement Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESSING__CONTAINING_REQUIREMENT_SPACE = RequirementsPackage.REQUIREMENT__CONTAINING_REQUIREMENT_SPACE;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESSING__REFINEMENTS = RequirementsPackage.REQUIREMENT__REFINEMENTS;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESSING__REFINED_REQUIREMENT = RequirementsPackage.REQUIREMENT__REFINED_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Specified Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESSING__SPECIFIED_FEATURE = RequirementsPackage.REQUIREMENT__SPECIFIED_FEATURE;

	/**
	 * The feature id for the '<em><b>Defining Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESSING__DEFINING_DATA = RequirementsPackage.REQUIREMENT__DEFINING_DATA;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESSING__REALIZED_METHOD = RequirementsPackage.REQUIREMENT__REALIZED_METHOD;

	/**
	 * The number of structural features of the '<em>Data Processing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESSING_FEATURE_COUNT = RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link scrm.requirements.dataProcessing.impl.InputDataReadingImpl <em>Input Data Reading</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataProcessing.impl.InputDataReadingImpl
	 * @see scrm.requirements.dataProcessing.impl.DataProcessingPackageImpl#getInputDataReading()
	 * @generated
	 */
	int INPUT_DATA_READING = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__NAME = DATA_PROCESSING__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__DESCRIPTION = DATA_PROCESSING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Containing Requirement Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__CONTAINING_REQUIREMENT_SPACE = DATA_PROCESSING__CONTAINING_REQUIREMENT_SPACE;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__REFINEMENTS = DATA_PROCESSING__REFINEMENTS;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__REFINED_REQUIREMENT = DATA_PROCESSING__REFINED_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Specified Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__SPECIFIED_FEATURE = DATA_PROCESSING__SPECIFIED_FEATURE;

	/**
	 * The feature id for the '<em><b>Defining Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__DEFINING_DATA = DATA_PROCESSING__DEFINING_DATA;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__REALIZED_METHOD = DATA_PROCESSING__REALIZED_METHOD;

	/**
	 * The number of structural features of the '<em>Input Data Reading</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING_FEATURE_COUNT = DATA_PROCESSING_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link scrm.requirements.dataProcessing.impl.DataHandlingImpl <em>Data Handling</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataProcessing.impl.DataHandlingImpl
	 * @see scrm.requirements.dataProcessing.impl.DataProcessingPackageImpl#getDataHandling()
	 * @generated
	 */
	int DATA_HANDLING = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__NAME = DATA_PROCESSING__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__DESCRIPTION = DATA_PROCESSING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Containing Requirement Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__CONTAINING_REQUIREMENT_SPACE = DATA_PROCESSING__CONTAINING_REQUIREMENT_SPACE;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__REFINEMENTS = DATA_PROCESSING__REFINEMENTS;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__REFINED_REQUIREMENT = DATA_PROCESSING__REFINED_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Specified Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__SPECIFIED_FEATURE = DATA_PROCESSING__SPECIFIED_FEATURE;

	/**
	 * The feature id for the '<em><b>Defining Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__DEFINING_DATA = DATA_PROCESSING__DEFINING_DATA;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__REALIZED_METHOD = DATA_PROCESSING__REALIZED_METHOD;

	/**
	 * The number of structural features of the '<em>Data Handling</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING_FEATURE_COUNT = DATA_PROCESSING_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link scrm.requirements.dataProcessing.impl.ResultsOutputImpl <em>Results Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataProcessing.impl.ResultsOutputImpl
	 * @see scrm.requirements.dataProcessing.impl.DataProcessingPackageImpl#getResultsOutput()
	 * @generated
	 */
	int RESULTS_OUTPUT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__NAME = DATA_PROCESSING__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__DESCRIPTION = DATA_PROCESSING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Containing Requirement Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__CONTAINING_REQUIREMENT_SPACE = DATA_PROCESSING__CONTAINING_REQUIREMENT_SPACE;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__REFINEMENTS = DATA_PROCESSING__REFINEMENTS;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__REFINED_REQUIREMENT = DATA_PROCESSING__REFINED_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Specified Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__SPECIFIED_FEATURE = DATA_PROCESSING__SPECIFIED_FEATURE;

	/**
	 * The feature id for the '<em><b>Defining Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__DEFINING_DATA = DATA_PROCESSING__DEFINING_DATA;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__REALIZED_METHOD = DATA_PROCESSING__REALIZED_METHOD;

	/**
	 * The number of structural features of the '<em>Results Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT_FEATURE_COUNT = DATA_PROCESSING_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link scrm.requirements.dataProcessing.impl.ErrorHandlingImpl <em>Error Handling</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataProcessing.impl.ErrorHandlingImpl
	 * @see scrm.requirements.dataProcessing.impl.DataProcessingPackageImpl#getErrorHandling()
	 * @generated
	 */
	int ERROR_HANDLING = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__NAME = DATA_PROCESSING__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__DESCRIPTION = DATA_PROCESSING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Containing Requirement Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__CONTAINING_REQUIREMENT_SPACE = DATA_PROCESSING__CONTAINING_REQUIREMENT_SPACE;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__REFINEMENTS = DATA_PROCESSING__REFINEMENTS;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__REFINED_REQUIREMENT = DATA_PROCESSING__REFINED_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Specified Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__SPECIFIED_FEATURE = DATA_PROCESSING__SPECIFIED_FEATURE;

	/**
	 * The feature id for the '<em><b>Defining Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__DEFINING_DATA = DATA_PROCESSING__DEFINING_DATA;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__REALIZED_METHOD = DATA_PROCESSING__REALIZED_METHOD;

	/**
	 * The number of structural features of the '<em>Error Handling</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING_FEATURE_COUNT = DATA_PROCESSING_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link scrm.requirements.dataProcessing.impl.StatusMonitoringImpl <em>Status Monitoring</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataProcessing.impl.StatusMonitoringImpl
	 * @see scrm.requirements.dataProcessing.impl.DataProcessingPackageImpl#getStatusMonitoring()
	 * @generated
	 */
	int STATUS_MONITORING = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__NAME = DATA_PROCESSING__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__DESCRIPTION = DATA_PROCESSING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Containing Requirement Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__CONTAINING_REQUIREMENT_SPACE = DATA_PROCESSING__CONTAINING_REQUIREMENT_SPACE;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__REFINEMENTS = DATA_PROCESSING__REFINEMENTS;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__REFINED_REQUIREMENT = DATA_PROCESSING__REFINED_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Specified Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__SPECIFIED_FEATURE = DATA_PROCESSING__SPECIFIED_FEATURE;

	/**
	 * The feature id for the '<em><b>Defining Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__DEFINING_DATA = DATA_PROCESSING__DEFINING_DATA;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__REALIZED_METHOD = DATA_PROCESSING__REALIZED_METHOD;

	/**
	 * The number of structural features of the '<em>Status Monitoring</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING_FEATURE_COUNT = DATA_PROCESSING_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link scrm.requirements.dataProcessing.DataProcessing <em>Data Processing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Processing</em>'.
	 * @see scrm.requirements.dataProcessing.DataProcessing
	 * @generated
	 */
	EClass getDataProcessing();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.dataProcessing.InputDataReading <em>Input Data Reading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Data Reading</em>'.
	 * @see scrm.requirements.dataProcessing.InputDataReading
	 * @generated
	 */
	EClass getInputDataReading();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.dataProcessing.DataHandling <em>Data Handling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Handling</em>'.
	 * @see scrm.requirements.dataProcessing.DataHandling
	 * @generated
	 */
	EClass getDataHandling();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.dataProcessing.ResultsOutput <em>Results Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Results Output</em>'.
	 * @see scrm.requirements.dataProcessing.ResultsOutput
	 * @generated
	 */
	EClass getResultsOutput();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.dataProcessing.ErrorHandling <em>Error Handling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Handling</em>'.
	 * @see scrm.requirements.dataProcessing.ErrorHandling
	 * @generated
	 */
	EClass getErrorHandling();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.dataProcessing.StatusMonitoring <em>Status Monitoring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Status Monitoring</em>'.
	 * @see scrm.requirements.dataProcessing.StatusMonitoring
	 * @generated
	 */
	EClass getStatusMonitoring();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DataProcessingFactory getDataProcessingFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link scrm.requirements.dataProcessing.DataProcessing <em>Data Processing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataProcessing.DataProcessing
		 * @see scrm.requirements.dataProcessing.impl.DataProcessingPackageImpl#getDataProcessing()
		 * @generated
		 */
		EClass DATA_PROCESSING = eINSTANCE.getDataProcessing();

		/**
		 * The meta object literal for the '{@link scrm.requirements.dataProcessing.impl.InputDataReadingImpl <em>Input Data Reading</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataProcessing.impl.InputDataReadingImpl
		 * @see scrm.requirements.dataProcessing.impl.DataProcessingPackageImpl#getInputDataReading()
		 * @generated
		 */
		EClass INPUT_DATA_READING = eINSTANCE.getInputDataReading();

		/**
		 * The meta object literal for the '{@link scrm.requirements.dataProcessing.impl.DataHandlingImpl <em>Data Handling</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataProcessing.impl.DataHandlingImpl
		 * @see scrm.requirements.dataProcessing.impl.DataProcessingPackageImpl#getDataHandling()
		 * @generated
		 */
		EClass DATA_HANDLING = eINSTANCE.getDataHandling();

		/**
		 * The meta object literal for the '{@link scrm.requirements.dataProcessing.impl.ResultsOutputImpl <em>Results Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataProcessing.impl.ResultsOutputImpl
		 * @see scrm.requirements.dataProcessing.impl.DataProcessingPackageImpl#getResultsOutput()
		 * @generated
		 */
		EClass RESULTS_OUTPUT = eINSTANCE.getResultsOutput();

		/**
		 * The meta object literal for the '{@link scrm.requirements.dataProcessing.impl.ErrorHandlingImpl <em>Error Handling</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataProcessing.impl.ErrorHandlingImpl
		 * @see scrm.requirements.dataProcessing.impl.DataProcessingPackageImpl#getErrorHandling()
		 * @generated
		 */
		EClass ERROR_HANDLING = eINSTANCE.getErrorHandling();

		/**
		 * The meta object literal for the '{@link scrm.requirements.dataProcessing.impl.StatusMonitoringImpl <em>Status Monitoring</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataProcessing.impl.StatusMonitoringImpl
		 * @see scrm.requirements.dataProcessing.impl.DataProcessingPackageImpl#getStatusMonitoring()
		 * @generated
		 */
		EClass STATUS_MONITORING = eINSTANCE.getStatusMonitoring();

	}

} //DataProcessingPackage
