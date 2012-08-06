/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataProcess.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import scrm.requirements.dataProcess.DataProcessFactory;
import scrm.requirements.dataProcess.DataProcessPackage;
import scrm.requirements.dataProcess.DataProcessSpace;
import scrm.requirements.dataProcess.ErrorHandling;
import scrm.requirements.dataProcess.InputDataReading;
import scrm.requirements.dataProcess.ResultsOutput;
import scrm.requirements.dataProcess.StatusMonitoring;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataProcessFactoryImpl extends EFactoryImpl implements
		DataProcessFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DataProcessFactory init() {
		try {
			DataProcessFactory theDataProcessFactory = (DataProcessFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://unicase.org/model/scrm/requirements/dataProcess");
			if (theDataProcessFactory != null) {
				return theDataProcessFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DataProcessFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataProcessFactoryImpl() {
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
		case DataProcessPackage.PROCESS:
			return createProcess();
		case DataProcessPackage.INPUT_DATA_READING:
			return createInputDataReading();
		case DataProcessPackage.RESULTS_OUTPUT:
			return createResultsOutput();
		case DataProcessPackage.ERROR_HANDLING:
			return createErrorHandling();
		case DataProcessPackage.STATUS_MONITORING:
			return createStatusMonitoring();
		case DataProcessPackage.DATA_PROCESS_SPACE:
			return createDataProcessSpace();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
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
	public scrm.requirements.dataProcess.Process createProcess() {
		ProcessImpl process = new ProcessImpl();
		return process;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataProcessSpace createDataProcessSpace() {
		DataProcessSpaceImpl dataProcessSpace = new DataProcessSpaceImpl();
		return dataProcessSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataProcessPackage getDataProcessPackage() {
		return (DataProcessPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DataProcessPackage getPackage() {
		return DataProcessPackage.eINSTANCE;
	}

} //DataProcessFactoryImpl
