/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Kögel
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.changemanagment.changepackage.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESAbstractOperation;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESChangePackage;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESEvent;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESListEvent;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESModifyElementEvent;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESOperation;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESeAttributeEvent;

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
 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage
 * @generated
 */
public class ChangepackageSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ChangepackagePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangepackageSwitch() {
		if (modelPackage == null) {
			modelPackage = ChangepackagePackage.eINSTANCE;
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
		case ChangepackagePackage.ES_CHANGE_PACKAGE: {
			ESChangePackage esChangePackage = (ESChangePackage) theEObject;
			T result = caseESChangePackage(esChangePackage);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangepackagePackage.ES_ABSTRACT_OPERATION: {
			ESAbstractOperation esAbstractOperation = (ESAbstractOperation) theEObject;
			T result = caseESAbstractOperation(esAbstractOperation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangepackagePackage.ES_OPERATION: {
			ESOperation esOperation = (ESOperation) theEObject;
			T result = caseESOperation(esOperation);
			if (result == null)
				result = caseESAbstractOperation(esOperation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangepackagePackage.ES_EVENT: {
			ESEvent esEvent = (ESEvent) theEObject;
			T result = caseESEvent(esEvent);
			if (result == null)
				result = caseESAbstractOperation(esEvent);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangepackagePackage.ESE_ATTRIBUTE_EVENT: {
			ESeAttributeEvent eSeAttributeEvent = (ESeAttributeEvent) theEObject;
			T result = caseESeAttributeEvent(eSeAttributeEvent);
			if (result == null)
				result = caseESEvent(eSeAttributeEvent);
			if (result == null)
				result = caseESAbstractOperation(eSeAttributeEvent);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangepackagePackage.ES_LIST_EVENT: {
			ESListEvent esListEvent = (ESListEvent) theEObject;
			T result = caseESListEvent(esListEvent);
			if (result == null)
				result = caseESEvent(esListEvent);
			if (result == null)
				result = caseESAbstractOperation(esListEvent);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangepackagePackage.ES_MODIFY_ELEMENT_EVENT: {
			ESModifyElementEvent esModifyElementEvent = (ESModifyElementEvent) theEObject;
			T result = caseESModifyElementEvent(esModifyElementEvent);
			if (result == null)
				result = caseESEvent(esModifyElementEvent);
			if (result == null)
				result = caseESAbstractOperation(esModifyElementEvent);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ES Change Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ES Change Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESChangePackage(ESChangePackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ES Abstract Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ES Abstract Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESAbstractOperation(ESAbstractOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ES Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ES Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESOperation(ESOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ES Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ES Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESEvent(ESEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ESe Attribute Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ESe Attribute Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESeAttributeEvent(ESeAttributeEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ES List Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ES List Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESListEvent(ESListEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ES Modify Element Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ES Modify Element Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESModifyElementEvent(ESModifyElementEvent object) {
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

} //ChangepackageSwitch
