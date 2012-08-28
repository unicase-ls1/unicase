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

import scrm.SCRMModelElement;
import scrm.requirements.IRequirement;
import scrm.requirements.dataObject.ComputationalMesh;
import scrm.requirements.dataObject.ControlParameter;
import scrm.requirements.dataObject.DataDefinition;
import scrm.requirements.dataObject.DataObjectPackage;
import scrm.requirements.dataObject.SeismicSource;
import scrm.requirements.dataObject.Station;
import scrm.requirements.dataObject.SyntheticSeismogram;

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
		case DataObjectPackage.DATA_DEFINITION: {
			DataDefinition dataDefinition = (DataDefinition) theEObject;
			T result = caseDataDefinition(dataDefinition);
			if (result == null)
				result = caseIRequirement(dataDefinition);
			if (result == null)
				result = caseSCRMModelElement(dataDefinition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataObjectPackage.SEISMIC_SOURCE: {
			SeismicSource seismicSource = (SeismicSource) theEObject;
			T result = caseSeismicSource(seismicSource);
			if (result == null)
				result = caseDataDefinition(seismicSource);
			if (result == null)
				result = caseIRequirement(seismicSource);
			if (result == null)
				result = caseSCRMModelElement(seismicSource);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataObjectPackage.COMPUTATIONAL_MESH: {
			ComputationalMesh computationalMesh = (ComputationalMesh) theEObject;
			T result = caseComputationalMesh(computationalMesh);
			if (result == null)
				result = caseDataDefinition(computationalMesh);
			if (result == null)
				result = caseIRequirement(computationalMesh);
			if (result == null)
				result = caseSCRMModelElement(computationalMesh);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataObjectPackage.SYNTHETIC_SEISMOGRAM: {
			SyntheticSeismogram syntheticSeismogram = (SyntheticSeismogram) theEObject;
			T result = caseSyntheticSeismogram(syntheticSeismogram);
			if (result == null)
				result = caseDataDefinition(syntheticSeismogram);
			if (result == null)
				result = caseIRequirement(syntheticSeismogram);
			if (result == null)
				result = caseSCRMModelElement(syntheticSeismogram);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataObjectPackage.STATION: {
			Station station = (Station) theEObject;
			T result = caseStation(station);
			if (result == null)
				result = caseDataDefinition(station);
			if (result == null)
				result = caseIRequirement(station);
			if (result == null)
				result = caseSCRMModelElement(station);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DataObjectPackage.CONTROL_PARAMETER: {
			ControlParameter controlParameter = (ControlParameter) theEObject;
			T result = caseControlParameter(controlParameter);
			if (result == null)
				result = caseIRequirement(controlParameter);
			if (result == null)
				result = caseSCRMModelElement(controlParameter);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataDefinition(DataDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Seismic Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Seismic Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSeismicSource(SeismicSource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Computational Mesh</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Computational Mesh</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComputationalMesh(ComputationalMesh object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Synthetic Seismogram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Synthetic Seismogram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSyntheticSeismogram(SyntheticSeismogram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Station</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Station</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStation(Station object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Control Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Control Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseControlParameter(ControlParameter object) {
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
