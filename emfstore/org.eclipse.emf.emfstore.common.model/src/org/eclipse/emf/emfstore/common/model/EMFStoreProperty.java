/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 */
package org.eclipse.emf.emfstore.common.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EMF Store Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.common.model.EMFStoreProperty#getKey <em>Key</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.common.model.EMFStoreProperty#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.common.model.EMFStoreProperty#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.common.model.ModelPackage#getEMFStoreProperty()
 * @model
 * @generated
 */
public interface EMFStoreProperty extends EObject {
	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(String)
	 * @see org.eclipse.emf.emfstore.common.model.ModelPackage#getEMFStoreProperty_Key()
	 * @model
	 * @generated
	 */
	String getKey();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.common.model.EMFStoreProperty#getKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(EObject)
	 * @see org.eclipse.emf.emfstore.common.model.ModelPackage#getEMFStoreProperty_Value()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EObject getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.common.model.EMFStoreProperty#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(EObject value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.emf.emfstore.common.model.EMFStorePropertyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.emf.emfstore.common.model.EMFStorePropertyType
	 * @see #setType(EMFStorePropertyType)
	 * @see org.eclipse.emf.emfstore.common.model.ModelPackage#getEMFStoreProperty_Type()
	 * @model
	 * @generated
	 */
	EMFStorePropertyType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.common.model.EMFStoreProperty#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.emf.emfstore.common.model.EMFStorePropertyType
	 * @see #getType()
	 * @generated
	 */
	void setType(EMFStorePropertyType value);

} // EMFStoreProperty
