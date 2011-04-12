/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.dataProcessing;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import scrm.ScrmPackage;

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
 * @see scrm.dataProcessing.DataProcessingFactory
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
	String eNS_URI = "http://unicase.org/model/scrm/dataProcessing";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.scrm.dataProcessing";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataProcessingPackage eINSTANCE = scrm.dataProcessing.impl.DataProcessingPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link scrm.dataProcessing.DataProcessing <em>Data Processing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.dataProcessing.DataProcessing
	 * @see scrm.dataProcessing.impl.DataProcessingPackageImpl#getDataProcessing()
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
	int DATA_PROCESSING__NAME = ScrmPackage.SCRM_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESSING__DESCRIPTION = ScrmPackage.SCRM_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Data Processing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESSING_FEATURE_COUNT = ScrmPackage.SCRM_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link scrm.dataProcessing.impl.InputDataReadingImpl <em>Input Data Reading</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.dataProcessing.impl.InputDataReadingImpl
	 * @see scrm.dataProcessing.impl.DataProcessingPackageImpl#getInputDataReading()
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
	 * The number of structural features of the '<em>Input Data Reading</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING_FEATURE_COUNT = DATA_PROCESSING_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link scrm.dataProcessing.impl.DataHandlingImpl <em>Data Handling</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.dataProcessing.impl.DataHandlingImpl
	 * @see scrm.dataProcessing.impl.DataProcessingPackageImpl#getDataHandling()
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
	 * The number of structural features of the '<em>Data Handling</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING_FEATURE_COUNT = DATA_PROCESSING_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link scrm.dataProcessing.impl.ResultsOutputImpl <em>Results Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.dataProcessing.impl.ResultsOutputImpl
	 * @see scrm.dataProcessing.impl.DataProcessingPackageImpl#getResultsOutput()
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
	 * The number of structural features of the '<em>Results Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT_FEATURE_COUNT = DATA_PROCESSING_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link scrm.dataProcessing.impl.ErrorHandlingImpl <em>Error Handling</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.dataProcessing.impl.ErrorHandlingImpl
	 * @see scrm.dataProcessing.impl.DataProcessingPackageImpl#getErrorHandling()
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
	 * The number of structural features of the '<em>Error Handling</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING_FEATURE_COUNT = DATA_PROCESSING_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link scrm.dataProcessing.impl.StatusMonitoringImpl <em>Status Monitoring</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.dataProcessing.impl.StatusMonitoringImpl
	 * @see scrm.dataProcessing.impl.DataProcessingPackageImpl#getStatusMonitoring()
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
	 * The number of structural features of the '<em>Status Monitoring</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING_FEATURE_COUNT = DATA_PROCESSING_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link scrm.dataProcessing.DataProcessing <em>Data Processing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Processing</em>'.
	 * @see scrm.dataProcessing.DataProcessing
	 * @generated
	 */
	EClass getDataProcessing();

	/**
	 * Returns the meta object for class '{@link scrm.dataProcessing.InputDataReading <em>Input Data Reading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Data Reading</em>'.
	 * @see scrm.dataProcessing.InputDataReading
	 * @generated
	 */
	EClass getInputDataReading();

	/**
	 * Returns the meta object for class '{@link scrm.dataProcessing.DataHandling <em>Data Handling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Handling</em>'.
	 * @see scrm.dataProcessing.DataHandling
	 * @generated
	 */
	EClass getDataHandling();

	/**
	 * Returns the meta object for class '{@link scrm.dataProcessing.ResultsOutput <em>Results Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Results Output</em>'.
	 * @see scrm.dataProcessing.ResultsOutput
	 * @generated
	 */
	EClass getResultsOutput();

	/**
	 * Returns the meta object for class '{@link scrm.dataProcessing.ErrorHandling <em>Error Handling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Handling</em>'.
	 * @see scrm.dataProcessing.ErrorHandling
	 * @generated
	 */
	EClass getErrorHandling();

	/**
	 * Returns the meta object for class '{@link scrm.dataProcessing.StatusMonitoring <em>Status Monitoring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Status Monitoring</em>'.
	 * @see scrm.dataProcessing.StatusMonitoring
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
		 * The meta object literal for the '{@link scrm.dataProcessing.DataProcessing <em>Data Processing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.dataProcessing.DataProcessing
		 * @see scrm.dataProcessing.impl.DataProcessingPackageImpl#getDataProcessing()
		 * @generated
		 */
		EClass DATA_PROCESSING = eINSTANCE.getDataProcessing();

		/**
		 * The meta object literal for the '{@link scrm.dataProcessing.impl.InputDataReadingImpl <em>Input Data Reading</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.dataProcessing.impl.InputDataReadingImpl
		 * @see scrm.dataProcessing.impl.DataProcessingPackageImpl#getInputDataReading()
		 * @generated
		 */
		EClass INPUT_DATA_READING = eINSTANCE.getInputDataReading();

		/**
		 * The meta object literal for the '{@link scrm.dataProcessing.impl.DataHandlingImpl <em>Data Handling</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.dataProcessing.impl.DataHandlingImpl
		 * @see scrm.dataProcessing.impl.DataProcessingPackageImpl#getDataHandling()
		 * @generated
		 */
		EClass DATA_HANDLING = eINSTANCE.getDataHandling();

		/**
		 * The meta object literal for the '{@link scrm.dataProcessing.impl.ResultsOutputImpl <em>Results Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.dataProcessing.impl.ResultsOutputImpl
		 * @see scrm.dataProcessing.impl.DataProcessingPackageImpl#getResultsOutput()
		 * @generated
		 */
		EClass RESULTS_OUTPUT = eINSTANCE.getResultsOutput();

		/**
		 * The meta object literal for the '{@link scrm.dataProcessing.impl.ErrorHandlingImpl <em>Error Handling</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.dataProcessing.impl.ErrorHandlingImpl
		 * @see scrm.dataProcessing.impl.DataProcessingPackageImpl#getErrorHandling()
		 * @generated
		 */
		EClass ERROR_HANDLING = eINSTANCE.getErrorHandling();

		/**
		 * The meta object literal for the '{@link scrm.dataProcessing.impl.StatusMonitoringImpl <em>Status Monitoring</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.dataProcessing.impl.StatusMonitoringImpl
		 * @see scrm.dataProcessing.impl.DataProcessingPackageImpl#getStatusMonitoring()
		 * @generated
		 */
		EClass STATUS_MONITORING = eINSTANCE.getStatusMonitoring();

	}

} //DataProcessingPackage
