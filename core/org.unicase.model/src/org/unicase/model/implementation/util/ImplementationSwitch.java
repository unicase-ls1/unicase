/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.unicase.metamodel.IdentifiableElement;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.implementation.IAttribute;
import org.unicase.model.implementation.IClass;
import org.unicase.model.implementation.IEnumeration;
import org.unicase.model.implementation.IFeature;
import org.unicase.model.implementation.ILiteral;
import org.unicase.model.implementation.IPackage;
import org.unicase.model.implementation.IReference;
import org.unicase.model.implementation.ImplementationPackage;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * 
 * @see org.unicase.model.implementation.ImplementationPackage
 * @generated
 */
public class ImplementationSwitch<T> {
	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static ImplementationPackage modelPackage;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ImplementationSwitch() {
		if (modelPackage == null) {
			modelPackage = ImplementationPackage.eINSTANCE;
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
		case ImplementationPackage.IPACKAGE: {
			IPackage iPackage = (IPackage) theEObject;
			T result = caseIPackage(iPackage);
			if (result == null)
				result = caseUnicaseModelElement(iPackage);
			if (result == null)
				result = caseModelElement(iPackage);
			if (result == null)
				result = caseIdentifiableElement(iPackage);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImplementationPackage.ICLASS: {
			IClass iClass = (IClass) theEObject;
			T result = caseIClass(iClass);
			if (result == null)
				result = caseUnicaseModelElement(iClass);
			if (result == null)
				result = caseModelElement(iClass);
			if (result == null)
				result = caseIdentifiableElement(iClass);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImplementationPackage.IFEATURE: {
			IFeature iFeature = (IFeature) theEObject;
			T result = caseIFeature(iFeature);
			if (result == null)
				result = caseUnicaseModelElement(iFeature);
			if (result == null)
				result = caseModelElement(iFeature);
			if (result == null)
				result = caseIdentifiableElement(iFeature);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImplementationPackage.IATTRIBUTE: {
			IAttribute iAttribute = (IAttribute) theEObject;
			T result = caseIAttribute(iAttribute);
			if (result == null)
				result = caseIFeature(iAttribute);
			if (result == null)
				result = caseUnicaseModelElement(iAttribute);
			if (result == null)
				result = caseModelElement(iAttribute);
			if (result == null)
				result = caseIdentifiableElement(iAttribute);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImplementationPackage.IREFERENCE: {
			IReference iReference = (IReference) theEObject;
			T result = caseIReference(iReference);
			if (result == null)
				result = caseIFeature(iReference);
			if (result == null)
				result = caseUnicaseModelElement(iReference);
			if (result == null)
				result = caseModelElement(iReference);
			if (result == null)
				result = caseIdentifiableElement(iReference);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImplementationPackage.IENUMERATION: {
			IEnumeration iEnumeration = (IEnumeration) theEObject;
			T result = caseIEnumeration(iEnumeration);
			if (result == null)
				result = caseUnicaseModelElement(iEnumeration);
			if (result == null)
				result = caseModelElement(iEnumeration);
			if (result == null)
				result = caseIdentifiableElement(iEnumeration);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImplementationPackage.ILITERAL: {
			ILiteral iLiteral = (ILiteral) theEObject;
			T result = caseILiteral(iLiteral);
			if (result == null)
				result = caseUnicaseModelElement(iLiteral);
			if (result == null)
				result = caseModelElement(iLiteral);
			if (result == null)
				result = caseIdentifiableElement(iLiteral);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPackage</em>'. <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPackage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPackage(IPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IClass</em>'. <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IClass</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIClass(IClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IFeature</em>'. <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IFeature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIFeature(IFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IAttribute</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IAttribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIAttribute(IAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IReference</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IReference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIReference(IReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IEnumeration</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IEnumeration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIEnumeration(IEnumeration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ILiteral</em>'. <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ILiteral</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseILiteral(ILiteral object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Model Element</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelElement(ModelElement object) {
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

} // ImplementationSwitch
