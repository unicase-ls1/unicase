/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataProcessing.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import scrm.requirements.dataProcessing.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataProcessingFactoryImpl extends EFactoryImpl implements DataProcessingFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DataProcessingFactory init() {
		try {
			DataProcessingFactory theDataProcessingFactory = (DataProcessingFactory)EPackage.Registry.INSTANCE.getEFactory("http://unicase.org/model/scrm/requirements/dataProcessing"); 
			if (theDataProcessingFactory != null) {
				return theDataProcessingFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DataProcessingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataProcessingFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DataProcessingPackage.INPUT_DATA_READING: return createInputDataReading();
			case DataProcessingPackage.DATA_HANDLING: return createDataHandling();
			case DataProcessingPackage.RESULTS_OUTPUT: return createResultsOutput();
			case DataProcessingPackage.ERROR_HANDLING: return createErrorHandling();
			case DataProcessingPackage.STATUS_MONITORING: return createStatusMonitoring();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputDataReading createInputDataReading() {
		InputDataReadingImpl inputDataReading = new InputDataReadingImpl();
		return inputDataReading;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataHandling createDataHandling() {
		DataHandlingImpl dataHandling = new DataHandlingImpl();
		return dataHandling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultsOutput createResultsOutput() {
		ResultsOutputImpl resultsOutput = new ResultsOutputImpl();
		return resultsOutput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorHandling createErrorHandling() {
		ErrorHandlingImpl errorHandling = new ErrorHandlingImpl();
		return errorHandling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatusMonitoring createStatusMonitoring() {
		StatusMonitoringImpl statusMonitoring = new StatusMonitoringImpl();
		return statusMonitoring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataProcessingPackage getDataProcessingPackage() {
		return (DataProcessingPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DataProcessingPackage getPackage() {
		return DataProcessingPackage.eINSTANCE;
	}

} //DataProcessingFactoryImpl
