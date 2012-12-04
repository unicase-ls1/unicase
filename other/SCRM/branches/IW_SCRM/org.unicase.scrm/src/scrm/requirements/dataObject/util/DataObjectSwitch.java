/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataObject.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.unicase.model.UnicaseModelElement;

import scrm.SCRMModelElement;
import scrm.requirements.IRequirement;
import scrm.requirements.dataObject.BuildingModel;
import scrm.requirements.dataObject.ControlSchedule;
import scrm.requirements.dataObject.Data;
import scrm.requirements.dataObject.DataObjectPackage;
import scrm.requirements.dataObject.GeometryData;
import scrm.requirements.dataObject.HVACOperationInformation;
import scrm.requirements.dataObject.PowerConsumption;
import scrm.requirements.dataObject.Report;
import scrm.requirements.dataObject.WeatherData;

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
 * @see scrm.requirements.dataObject.DataObjectPackage
 * @generated
 */
public class DataObjectSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DataObjectPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataObjectSwitch() {
		if (modelPackage == null) {
			modelPackage = DataObjectPackage.eINSTANCE;
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
		case DataObjectPackage.DATA: {
			Data data = (Data) theEObject;
			T result = caseData(data);
			if (result == null)
				result = caseIRequirement(data);
			if (result == null)
				result = caseSCRMModelElement(data);
			if (result == null)
				result = caseUnicaseModelElement(data);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataObjectPackage.WEATHER_DATA: {
			WeatherData weatherData = (WeatherData) theEObject;
			T result = caseWeatherData(weatherData);
			if (result == null)
				result = caseData(weatherData);
			if (result == null)
				result = caseIRequirement(weatherData);
			if (result == null)
				result = caseSCRMModelElement(weatherData);
			if (result == null)
				result = caseUnicaseModelElement(weatherData);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataObjectPackage.POWER_CONSUMPTION: {
			PowerConsumption powerConsumption = (PowerConsumption) theEObject;
			T result = casePowerConsumption(powerConsumption);
			if (result == null)
				result = caseData(powerConsumption);
			if (result == null)
				result = caseIRequirement(powerConsumption);
			if (result == null)
				result = caseSCRMModelElement(powerConsumption);
			if (result == null)
				result = caseUnicaseModelElement(powerConsumption);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataObjectPackage.HVAC_OPERATION_INFORMATION: {
			HVACOperationInformation hvacOperationInformation = (HVACOperationInformation) theEObject;
			T result = caseHVACOperationInformation(hvacOperationInformation);
			if (result == null)
				result = caseData(hvacOperationInformation);
			if (result == null)
				result = caseIRequirement(hvacOperationInformation);
			if (result == null)
				result = caseSCRMModelElement(hvacOperationInformation);
			if (result == null)
				result = caseUnicaseModelElement(hvacOperationInformation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataObjectPackage.BUILDING_MODEL: {
			BuildingModel buildingModel = (BuildingModel) theEObject;
			T result = caseBuildingModel(buildingModel);
			if (result == null)
				result = caseData(buildingModel);
			if (result == null)
				result = caseIRequirement(buildingModel);
			if (result == null)
				result = caseSCRMModelElement(buildingModel);
			if (result == null)
				result = caseUnicaseModelElement(buildingModel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataObjectPackage.REPORT: {
			Report report = (Report) theEObject;
			T result = caseReport(report);
			if (result == null)
				result = caseData(report);
			if (result == null)
				result = caseIRequirement(report);
			if (result == null)
				result = caseSCRMModelElement(report);
			if (result == null)
				result = caseUnicaseModelElement(report);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataObjectPackage.CONTROL_SCHEDULE: {
			ControlSchedule controlSchedule = (ControlSchedule) theEObject;
			T result = caseControlSchedule(controlSchedule);
			if (result == null)
				result = caseData(controlSchedule);
			if (result == null)
				result = caseIRequirement(controlSchedule);
			if (result == null)
				result = caseSCRMModelElement(controlSchedule);
			if (result == null)
				result = caseUnicaseModelElement(controlSchedule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataObjectPackage.GEOMETRY_DATA: {
			GeometryData geometryData = (GeometryData) theEObject;
			T result = caseGeometryData(geometryData);
			if (result == null)
				result = caseData(geometryData);
			if (result == null)
				result = caseIRequirement(geometryData);
			if (result == null)
				result = caseSCRMModelElement(geometryData);
			if (result == null)
				result = caseUnicaseModelElement(geometryData);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseData(Data object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Weather Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Weather Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWeatherData(WeatherData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Power Consumption</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Power Consumption</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePowerConsumption(PowerConsumption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HVAC Operation Information</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HVAC Operation Information</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHVACOperationInformation(HVACOperationInformation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Building Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Building Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBuildingModel(BuildingModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReport(Report object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Control Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Control Schedule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseControlSchedule(ControlSchedule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Geometry Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Geometry Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeometryData(GeometryData object) {
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

} //DataObjectSwitch
