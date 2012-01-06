/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.util;

import java.util.List;

import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.metamodel.NonDomainElement;
import org.unicase.model.Attachment;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.urml.*;
import org.unicase.model.urml.Stakeholder;
import org.unicase.model.urml.URMLDiagram;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.model.urml.UrmlPackage;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * @see org.unicase.model.urml.UrmlPackage
 * @generated
 */
public class UrmlSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static UrmlPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UrmlSwitch() {
		if (modelPackage == null) {
			modelPackage = UrmlPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case UrmlPackage.URML_MODEL_ELEMENT: {
			UrmlModelElement urmlModelElement = (UrmlModelElement) theEObject;
			T result = caseUrmlModelElement(urmlModelElement);
			if (result == null)
				result = caseUnicaseModelElement(urmlModelElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UrmlPackage.STAKEHOLDER: {
			Stakeholder stakeholder = (Stakeholder) theEObject;
			T result = caseStakeholder(stakeholder);
			if (result == null)
				result = caseUrmlModelElement(stakeholder);
			if (result == null)
				result = caseUnicaseModelElement(stakeholder);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UrmlPackage.URML_DIAGRAM: {
			URMLDiagram urmlDiagram = (URMLDiagram) theEObject;
			T result = caseURMLDiagram(urmlDiagram);
			if (result == null)
				result = caseMEDiagram(urmlDiagram);
			if (result == null)
				result = caseAttachment(urmlDiagram);
			if (result == null)
				result = caseUnicaseModelElement(urmlDiagram);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UrmlPackage.STAKEHOLDER_ROLE: {
			StakeholderRole stakeholderRole = (StakeholderRole) theEObject;
			T result = caseStakeholderRole(stakeholderRole);
			if (result == null)
				result = caseUnicaseModelElement(stakeholderRole);
			if (result == null)
				result = caseNonDomainElement(stakeholderRole);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UrmlPackage.SET_ENTRY: {
			@SuppressWarnings("unchecked")
			Map.Entry<EClass, EList<EStructuralFeature>> setEntry = (Map.Entry<EClass, EList<EStructuralFeature>>) theEObject;
			T result = caseSetEntry(setEntry);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UrmlPackage.PHASE_SET_ENTRY: {
			@SuppressWarnings("unchecked")
			Map.Entry<EClass, EList<EClass>> phaseSetEntry = (Map.Entry<EClass, EList<EClass>>) theEObject;
			T result = casePhaseSetEntry(phaseSetEntry);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UrmlPackage.PHASE: {
			Phase phase = (Phase) theEObject;
			T result = casePhase(phase);
			if (result == null)
				result = caseUnicaseModelElement(phase);
			if (result == null)
				result = caseNonDomainElement(phase);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UrmlPackage.URML_PROJECT_SETTINGS: {
			UrmlProjectSettings urmlProjectSettings = (UrmlProjectSettings) theEObject;
			T result = caseUrmlProjectSettings(urmlProjectSettings);
			if (result == null)
				result = caseUnicaseModelElement(urmlProjectSettings);
			if (result == null)
				result = caseNonDomainElement(urmlProjectSettings);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUrmlModelElement(UrmlModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stakeholder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stakeholder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStakeholder(Stakeholder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>URML Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>URML Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseURMLDiagram(URMLDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stakeholder Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stakeholder Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStakeholderRole(StakeholderRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetEntry(Map.Entry<EClass, EList<EStructuralFeature>> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Phase Set Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Phase Set Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePhaseSetEntry(Map.Entry<EClass, EList<EClass>> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Phase</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Phase</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePhase(Phase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Project Settings</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Project Settings</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUrmlProjectSettings(UrmlProjectSettings object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unicase Model Element</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unicase Model Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnicaseModelElement(UnicaseModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attachment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attachment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttachment(Attachment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ME Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ME Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMEDiagram(MEDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Non Domain Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Non Domain Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNonDomainElement(NonDomainElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch, but this is the last case
	 * anyway. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} // UrmlSwitch
