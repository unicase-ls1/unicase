/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.diagram.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.unicase.metamodel.IdentifiableElement;
import org.unicase.model.Attachment;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.diagram.ActivityDiagram;
import org.unicase.model.diagram.ClassDiagram;
import org.unicase.model.diagram.ComponentDiagram;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.diagram.StateDiagram;
import org.unicase.model.diagram.UseCaseDiagram;
import org.unicase.model.diagram.WorkItemDiagram;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * 
 * @see org.unicase.model.diagram.DiagramPackage
 * @generated
 */
public class DiagramSwitch<T> {
	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static DiagramPackage modelPackage;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DiagramSwitch() {
		if (modelPackage == null) {
			modelPackage = DiagramPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that
	 * result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that
	 * result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		} else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that
	 * result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case DiagramPackage.ME_DIAGRAM: {
			MEDiagram meDiagram = (MEDiagram) theEObject;
			T result = caseMEDiagram(meDiagram);
			if (result == null)
				result = caseAttachment(meDiagram);
			if (result == null)
				result = caseUnicaseModelElement(meDiagram);
			if (result == null)
				result = caseIdentifiableElement(meDiagram);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DiagramPackage.CLASS_DIAGRAM: {
			ClassDiagram classDiagram = (ClassDiagram) theEObject;
			T result = caseClassDiagram(classDiagram);
			if (result == null)
				result = caseMEDiagram(classDiagram);
			if (result == null)
				result = caseAttachment(classDiagram);
			if (result == null)
				result = caseUnicaseModelElement(classDiagram);
			if (result == null)
				result = caseIdentifiableElement(classDiagram);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DiagramPackage.USE_CASE_DIAGRAM: {
			UseCaseDiagram useCaseDiagram = (UseCaseDiagram) theEObject;
			T result = caseUseCaseDiagram(useCaseDiagram);
			if (result == null)
				result = caseMEDiagram(useCaseDiagram);
			if (result == null)
				result = caseAttachment(useCaseDiagram);
			if (result == null)
				result = caseUnicaseModelElement(useCaseDiagram);
			if (result == null)
				result = caseIdentifiableElement(useCaseDiagram);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DiagramPackage.COMPONENT_DIAGRAM: {
			ComponentDiagram componentDiagram = (ComponentDiagram) theEObject;
			T result = caseComponentDiagram(componentDiagram);
			if (result == null)
				result = caseMEDiagram(componentDiagram);
			if (result == null)
				result = caseAttachment(componentDiagram);
			if (result == null)
				result = caseUnicaseModelElement(componentDiagram);
			if (result == null)
				result = caseIdentifiableElement(componentDiagram);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DiagramPackage.STATE_DIAGRAM: {
			StateDiagram stateDiagram = (StateDiagram) theEObject;
			T result = caseStateDiagram(stateDiagram);
			if (result == null)
				result = caseMEDiagram(stateDiagram);
			if (result == null)
				result = caseAttachment(stateDiagram);
			if (result == null)
				result = caseUnicaseModelElement(stateDiagram);
			if (result == null)
				result = caseIdentifiableElement(stateDiagram);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DiagramPackage.ACTIVITY_DIAGRAM: {
			ActivityDiagram activityDiagram = (ActivityDiagram) theEObject;
			T result = caseActivityDiagram(activityDiagram);
			if (result == null)
				result = caseMEDiagram(activityDiagram);
			if (result == null)
				result = caseAttachment(activityDiagram);
			if (result == null)
				result = caseUnicaseModelElement(activityDiagram);
			if (result == null)
				result = caseIdentifiableElement(activityDiagram);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DiagramPackage.WORK_ITEM_DIAGRAM: {
			WorkItemDiagram workItemDiagram = (WorkItemDiagram) theEObject;
			T result = caseWorkItemDiagram(workItemDiagram);
			if (result == null)
				result = caseMEDiagram(workItemDiagram);
			if (result == null)
				result = caseAttachment(workItemDiagram);
			if (result == null)
				result = caseUnicaseModelElement(workItemDiagram);
			if (result == null)
				result = caseIdentifiableElement(workItemDiagram);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ME Diagram</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ME Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMEDiagram(MEDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Diagram</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassDiagram(ClassDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Use Case Diagram</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Use Case Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUseCaseDiagram(UseCaseDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Diagram</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentDiagram(ComponentDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Diagram</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateDiagram(StateDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Diagram</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityDiagram(ActivityDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Work Item Diagram</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Work Item Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWorkItemDiagram(WorkItemDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifiable Element</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifiable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifiableElement(IdentifiableElement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Attachment</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attachment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttachment(Attachment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch, but this is the last case
	 * anyway. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} // DiagramSwitch
