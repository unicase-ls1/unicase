/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataProcess.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import scrm.SCRMModelElement;
import scrm.SCRMSpace;
import scrm.requirements.IRequirement;
import scrm.requirements.Requirement;
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
 * @see scrm.requirements.dataProcess.DataProcessPackage
 * @generated
 */
public class DataProcessSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DataProcessPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataProcessSwitch() {
		if (modelPackage == null) {
			modelPackage = DataProcessPackage.eINSTANCE;
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
		case DataProcessPackage.PROCESS: {
			scrm.requirements.dataProcess.Process process = (scrm.requirements.dataProcess.Process) theEObject;
			T result = caseProcess(process);
			if (result == null)
				result = caseRequirement(process);
			if (result == null)
				result = caseIRequirement(process);
			if (result == null)
				result = caseSCRMModelElement(process);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataProcessPackage.INPUT_DATA_READING: {
			InputDataReading inputDataReading = (InputDataReading) theEObject;
			T result = caseInputDataReading(inputDataReading);
			if (result == null)
				result = caseProcess(inputDataReading);
			if (result == null)
				result = caseRequirement(inputDataReading);
			if (result == null)
				result = caseIRequirement(inputDataReading);
			if (result == null)
				result = caseSCRMModelElement(inputDataReading);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataProcessPackage.RESULTS_OUTPUT: {
			ResultsOutput resultsOutput = (ResultsOutput) theEObject;
			T result = caseResultsOutput(resultsOutput);
			if (result == null)
				result = caseProcess(resultsOutput);
			if (result == null)
				result = caseRequirement(resultsOutput);
			if (result == null)
				result = caseIRequirement(resultsOutput);
			if (result == null)
				result = caseSCRMModelElement(resultsOutput);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataProcessPackage.ERROR_HANDLING: {
			ErrorHandling errorHandling = (ErrorHandling) theEObject;
			T result = caseErrorHandling(errorHandling);
			if (result == null)
				result = caseProcess(errorHandling);
			if (result == null)
				result = caseRequirement(errorHandling);
			if (result == null)
				result = caseIRequirement(errorHandling);
			if (result == null)
				result = caseSCRMModelElement(errorHandling);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataProcessPackage.STATUS_MONITORING: {
			StatusMonitoring statusMonitoring = (StatusMonitoring) theEObject;
			T result = caseStatusMonitoring(statusMonitoring);
			if (result == null)
				result = caseProcess(statusMonitoring);
			if (result == null)
				result = caseRequirement(statusMonitoring);
			if (result == null)
				result = caseIRequirement(statusMonitoring);
			if (result == null)
				result = caseSCRMModelElement(statusMonitoring);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataProcessPackage.DATA_PROCESS_SPACE: {
			DataProcessSpace dataProcessSpace = (DataProcessSpace) theEObject;
			T result = caseDataProcessSpace(dataProcessSpace);
			if (result == null)
				result = caseSCRMSpace(dataProcessSpace);
			if (result == null)
				result = caseProcess(dataProcessSpace);
			if (result == null)
				result = caseRequirement(dataProcessSpace);
			if (result == null)
				result = caseIRequirement(dataProcessSpace);
			if (result == null)
				result = caseSCRMModelElement(dataProcessSpace);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataProcessPackage.SOLVER: {
			Solver solver = (Solver) theEObject;
			T result = caseSolver(solver);
			if (result == null)
				result = caseProcess(solver);
			if (result == null)
				result = caseRequirement(solver);
			if (result == null)
				result = caseIRequirement(solver);
			if (result == null)
				result = caseSCRMModelElement(solver);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataProcessPackage.MESH_CREATION: {
			MeshCreation meshCreation = (MeshCreation) theEObject;
			T result = caseMeshCreation(meshCreation);
			if (result == null)
				result = caseProcess(meshCreation);
			if (result == null)
				result = caseRequirement(meshCreation);
			if (result == null)
				result = caseIRequirement(meshCreation);
			if (result == null)
				result = caseSCRMModelElement(meshCreation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataProcessPackage.PRE_PROCESSING: {
			PreProcessing preProcessing = (PreProcessing) theEObject;
			T result = casePreProcessing(preProcessing);
			if (result == null)
				result = caseProcess(preProcessing);
			if (result == null)
				result = caseRequirement(preProcessing);
			if (result == null)
				result = caseIRequirement(preProcessing);
			if (result == null)
				result = caseSCRMModelElement(preProcessing);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataProcessPackage.POST_PROCESSING: {
			PostProcessing postProcessing = (PostProcessing) theEObject;
			T result = casePostProcessing(postProcessing);
			if (result == null)
				result = caseProcess(postProcessing);
			if (result == null)
				result = caseRequirement(postProcessing);
			if (result == null)
				result = caseIRequirement(postProcessing);
			if (result == null)
				result = caseSCRMModelElement(postProcessing);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcess(scrm.requirements.dataProcess.Process object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Space</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Space</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataProcessSpace(DataProcessSpace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Solver</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Solver</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSolver(Solver object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mesh Creation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mesh Creation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeshCreation(MeshCreation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pre Processing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pre Processing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreProcessing(PreProcessing object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Post Processing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Post Processing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostProcessing(PostProcessing object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>IRequirement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IRequirement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIRequirement(IRequirement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Requirement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequirement(Requirement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCRM Space</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCRM Space</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSCRMSpace(SCRMSpace object) {
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

} //DataProcessSwitch
