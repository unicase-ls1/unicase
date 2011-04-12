/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.dataProcessing.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import scrm.SCRMModelElement;

import scrm.dataProcessing.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see scrm.dataProcessing.DataProcessingPackage
 * @generated
 */
public class DataProcessingSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DataProcessingPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataProcessingSwitch() {
		if (modelPackage == null) {
			modelPackage = DataProcessingPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		} else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(
					eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case DataProcessingPackage.DATA_PROCESSING: {
			DataProcessing dataProcessing = (DataProcessing) theEObject;
			T result = caseDataProcessing(dataProcessing);
			if (result == null)
				result = caseSCRMModelElement(dataProcessing);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataProcessingPackage.INPUT_DATA_READING: {
			InputDataReading inputDataReading = (InputDataReading) theEObject;
			T result = caseInputDataReading(inputDataReading);
			if (result == null)
				result = caseDataProcessing(inputDataReading);
			if (result == null)
				result = caseSCRMModelElement(inputDataReading);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataProcessingPackage.DATA_HANDLING: {
			DataHandling dataHandling = (DataHandling) theEObject;
			T result = caseDataHandling(dataHandling);
			if (result == null)
				result = caseDataProcessing(dataHandling);
			if (result == null)
				result = caseSCRMModelElement(dataHandling);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataProcessingPackage.RESULTS_OUTPUT: {
			ResultsOutput resultsOutput = (ResultsOutput) theEObject;
			T result = caseResultsOutput(resultsOutput);
			if (result == null)
				result = caseDataProcessing(resultsOutput);
			if (result == null)
				result = caseSCRMModelElement(resultsOutput);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataProcessingPackage.ERROR_HANDLING: {
			ErrorHandling errorHandling = (ErrorHandling) theEObject;
			T result = caseErrorHandling(errorHandling);
			if (result == null)
				result = caseDataProcessing(errorHandling);
			if (result == null)
				result = caseSCRMModelElement(errorHandling);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataProcessingPackage.STATUS_MONITORING: {
			StatusMonitoring statusMonitoring = (StatusMonitoring) theEObject;
			T result = caseStatusMonitoring(statusMonitoring);
			if (result == null)
				result = caseDataProcessing(statusMonitoring);
			if (result == null)
				result = caseSCRMModelElement(statusMonitoring);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Processing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Processing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataProcessing(DataProcessing object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Data Reading</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Data Reading</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputDataReading(InputDataReading object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Handling</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Handling</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataHandling(DataHandling object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Results Output</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Results Output</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResultsOutput(ResultsOutput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Error Handling</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error Handling</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorHandling(ErrorHandling object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Status Monitoring</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Status Monitoring</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatusMonitoring(StatusMonitoring object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCRM Model Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCRM Model Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSCRMModelElement(SCRMModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //DataProcessingSwitch
