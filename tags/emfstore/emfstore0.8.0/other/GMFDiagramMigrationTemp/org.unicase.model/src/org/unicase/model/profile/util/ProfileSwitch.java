/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.profile.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.unicase.metamodel.IdentifiableElement;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.profile.*;
import org.unicase.model.profile.Profile;
import org.unicase.model.profile.ProfilePackage;
import org.unicase.model.profile.Stereotype;
import org.unicase.model.profile.StereotypeAttribute;
import org.unicase.model.profile.StereotypeAttributeInstance;
import org.unicase.model.profile.StereotypeAttributeInstanceString;
import org.unicase.model.profile.StereotypeAttributeSimple;
import org.unicase.model.profile.StereotypeInstance;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * @see org.unicase.model.profile.ProfilePackage
 * @generated
 */
public class ProfileSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static ProfilePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProfileSwitch() {
		if (modelPackage == null) {
			modelPackage = ProfilePackage.eINSTANCE;
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
			return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(eSuperTypes.get(0), theEObject);
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
		case ProfilePackage.PROFILE: {
			Profile profile = (Profile) theEObject;
			T result = caseProfile(profile);
			if (result == null)
				result = caseUnicaseModelElement(profile);
			if (result == null)
				result = caseModelElement(profile);
			if (result == null)
				result = caseIdentifiableElement(profile);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ProfilePackage.STEREOTYPE: {
			Stereotype stereotype = (Stereotype) theEObject;
			T result = caseStereotype(stereotype);
			if (result == null)
				result = caseUnicaseModelElement(stereotype);
			if (result == null)
				result = caseModelElement(stereotype);
			if (result == null)
				result = caseIdentifiableElement(stereotype);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ProfilePackage.STEREOTYPE_INSTANCE: {
			StereotypeInstance stereotypeInstance = (StereotypeInstance) theEObject;
			T result = caseStereotypeInstance(stereotypeInstance);
			if (result == null)
				result = caseUnicaseModelElement(stereotypeInstance);
			if (result == null)
				result = caseModelElement(stereotypeInstance);
			if (result == null)
				result = caseIdentifiableElement(stereotypeInstance);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ProfilePackage.STEREOTYPE_ATTRIBUTE: {
			StereotypeAttribute stereotypeAttribute = (StereotypeAttribute) theEObject;
			T result = caseStereotypeAttribute(stereotypeAttribute);
			if (result == null)
				result = caseUnicaseModelElement(stereotypeAttribute);
			if (result == null)
				result = caseModelElement(stereotypeAttribute);
			if (result == null)
				result = caseIdentifiableElement(stereotypeAttribute);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ProfilePackage.STEREOTYPE_ATTRIBUTE_SIMPLE: {
			StereotypeAttributeSimple stereotypeAttributeSimple = (StereotypeAttributeSimple) theEObject;
			T result = caseStereotypeAttributeSimple(stereotypeAttributeSimple);
			if (result == null)
				result = caseStereotypeAttribute(stereotypeAttributeSimple);
			if (result == null)
				result = caseUnicaseModelElement(stereotypeAttributeSimple);
			if (result == null)
				result = caseModelElement(stereotypeAttributeSimple);
			if (result == null)
				result = caseIdentifiableElement(stereotypeAttributeSimple);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ProfilePackage.STEREOTYPE_ATTRIBUTE_INSTANCE: {
			StereotypeAttributeInstance stereotypeAttributeInstance = (StereotypeAttributeInstance) theEObject;
			T result = caseStereotypeAttributeInstance(stereotypeAttributeInstance);
			if (result == null)
				result = caseUnicaseModelElement(stereotypeAttributeInstance);
			if (result == null)
				result = caseModelElement(stereotypeAttributeInstance);
			if (result == null)
				result = caseIdentifiableElement(stereotypeAttributeInstance);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ProfilePackage.STEREOTYPE_ATTRIBUTE_INSTANCE_STRING: {
			StereotypeAttributeInstanceString stereotypeAttributeInstanceString = (StereotypeAttributeInstanceString) theEObject;
			T result = caseStereotypeAttributeInstanceString(stereotypeAttributeInstanceString);
			if (result == null)
				result = caseStereotypeAttributeInstance(stereotypeAttributeInstanceString);
			if (result == null)
				result = caseUnicaseModelElement(stereotypeAttributeInstanceString);
			if (result == null)
				result = caseModelElement(stereotypeAttributeInstanceString);
			if (result == null)
				result = caseIdentifiableElement(stereotypeAttributeInstanceString);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Profile</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Profile</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProfile(Profile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stereotype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stereotype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStereotype(Stereotype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stereotype Instance</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stereotype Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStereotypeInstance(StereotypeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stereotype Attribute</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stereotype Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStereotypeAttribute(StereotypeAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stereotype Attribute Simple</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stereotype Attribute Simple</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStereotypeAttributeSimple(StereotypeAttributeSimple object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stereotype Attribute Instance</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stereotype Attribute Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStereotypeAttributeInstance(StereotypeAttributeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stereotype Attribute Instance String</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stereotype Attribute Instance String</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStereotypeAttributeInstanceString(StereotypeAttributeInstanceString object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Model Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
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

} // ProfileSwitch
