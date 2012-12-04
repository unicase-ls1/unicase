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
import org.unicase.model.UnicaseModelElement;

import scrm.SCRMModelElement;
import scrm.requirements.IRequirement;
import scrm.requirements.Requirement;
import scrm.requirements.dataProcess.BuildingModelConstructionProcess;
import scrm.requirements.dataProcess.ControlSystemDesignProcess;
import scrm.requirements.dataProcess.CostMinimizationCalculationProcess;
import scrm.requirements.dataProcess.DataProcessPackage;
import scrm.requirements.dataProcess.DataVisualizationProcess;
import scrm.requirements.dataProcess.EnergyUsageCalculationProcess;
import scrm.requirements.dataProcess.ErrorHandling;
import scrm.requirements.dataProcess.ReportGenerationProcess;

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
				result = caseUnicaseModelElement(process);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataProcessPackage.DATA_VISUALIZATION_PROCESS: {
			DataVisualizationProcess dataVisualizationProcess = (DataVisualizationProcess) theEObject;
			T result = caseDataVisualizationProcess(dataVisualizationProcess);
			if (result == null)
				result = caseProcess(dataVisualizationProcess);
			if (result == null)
				result = caseRequirement(dataVisualizationProcess);
			if (result == null)
				result = caseIRequirement(dataVisualizationProcess);
			if (result == null)
				result = caseSCRMModelElement(dataVisualizationProcess);
			if (result == null)
				result = caseUnicaseModelElement(dataVisualizationProcess);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataProcessPackage.REPORT_GENERATION_PROCESS: {
			ReportGenerationProcess reportGenerationProcess = (ReportGenerationProcess) theEObject;
			T result = caseReportGenerationProcess(reportGenerationProcess);
			if (result == null)
				result = caseProcess(reportGenerationProcess);
			if (result == null)
				result = caseRequirement(reportGenerationProcess);
			if (result == null)
				result = caseIRequirement(reportGenerationProcess);
			if (result == null)
				result = caseSCRMModelElement(reportGenerationProcess);
			if (result == null)
				result = caseUnicaseModelElement(reportGenerationProcess);
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
				result = caseUnicaseModelElement(errorHandling);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataProcessPackage.BUILDING_MODEL_CONSTRUCTION_PROCESS: {
			BuildingModelConstructionProcess buildingModelConstructionProcess = (BuildingModelConstructionProcess) theEObject;
			T result = caseBuildingModelConstructionProcess(buildingModelConstructionProcess);
			if (result == null)
				result = caseProcess(buildingModelConstructionProcess);
			if (result == null)
				result = caseRequirement(buildingModelConstructionProcess);
			if (result == null)
				result = caseIRequirement(buildingModelConstructionProcess);
			if (result == null)
				result = caseSCRMModelElement(buildingModelConstructionProcess);
			if (result == null)
				result = caseUnicaseModelElement(buildingModelConstructionProcess);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataProcessPackage.COST_MINIMIZATION_CALCULATION_PROCESS: {
			CostMinimizationCalculationProcess costMinimizationCalculationProcess = (CostMinimizationCalculationProcess) theEObject;
			T result = caseCostMinimizationCalculationProcess(costMinimizationCalculationProcess);
			if (result == null)
				result = caseProcess(costMinimizationCalculationProcess);
			if (result == null)
				result = caseRequirement(costMinimizationCalculationProcess);
			if (result == null)
				result = caseIRequirement(costMinimizationCalculationProcess);
			if (result == null)
				result = caseSCRMModelElement(costMinimizationCalculationProcess);
			if (result == null)
				result = caseUnicaseModelElement(costMinimizationCalculationProcess);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataProcessPackage.CONTROL_SYSTEM_DESIGN_PROCESS: {
			ControlSystemDesignProcess controlSystemDesignProcess = (ControlSystemDesignProcess) theEObject;
			T result = caseControlSystemDesignProcess(controlSystemDesignProcess);
			if (result == null)
				result = caseProcess(controlSystemDesignProcess);
			if (result == null)
				result = caseRequirement(controlSystemDesignProcess);
			if (result == null)
				result = caseIRequirement(controlSystemDesignProcess);
			if (result == null)
				result = caseSCRMModelElement(controlSystemDesignProcess);
			if (result == null)
				result = caseUnicaseModelElement(controlSystemDesignProcess);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataProcessPackage.ENERGY_USAGE_CALCULATION_PROCESS: {
			EnergyUsageCalculationProcess energyUsageCalculationProcess = (EnergyUsageCalculationProcess) theEObject;
			T result = caseEnergyUsageCalculationProcess(energyUsageCalculationProcess);
			if (result == null)
				result = caseProcess(energyUsageCalculationProcess);
			if (result == null)
				result = caseRequirement(energyUsageCalculationProcess);
			if (result == null)
				result = caseIRequirement(energyUsageCalculationProcess);
			if (result == null)
				result = caseSCRMModelElement(energyUsageCalculationProcess);
			if (result == null)
				result = caseUnicaseModelElement(energyUsageCalculationProcess);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>Building Model Construction Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Building Model Construction Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBuildingModelConstructionProcess(
			BuildingModelConstructionProcess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cost Minimization Calculation Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cost Minimization Calculation Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCostMinimizationCalculationProcess(
			CostMinimizationCalculationProcess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Control System Design Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Control System Design Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseControlSystemDesignProcess(ControlSystemDesignProcess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Energy Usage Calculation Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Energy Usage Calculation Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnergyUsageCalculationProcess(
			EnergyUsageCalculationProcess object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Data Visualization Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Visualization Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataVisualizationProcess(DataVisualizationProcess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Report Generation Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Report Generation Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReportGenerationProcess(ReportGenerationProcess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unicase Model Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unicase Model Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnicaseModelElement(UnicaseModelElement object) {
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
