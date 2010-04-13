/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Model Element EObject Wrapper</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.metamodel.ModelElementEObjectWrapper#getWrappedEObject <em>Wrapped EObject</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.metamodel.MetamodelPackage#getModelElementEObjectWrapper()
 * @model
 * @generated
 */
public interface ModelElementEObjectWrapper extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Wrapped EObject</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wrapped EObject</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Wrapped EObject</em>' reference.
	 * @see #setWrappedEObject(EObject)
	 * @see org.unicase.metamodel.MetamodelPackage#getModelElementEObjectWrapper_WrappedEObject()
	 * @model
	 * @generated
	 */
	EObject getWrappedEObject();

	/**
	 * Sets the value of the '{@link org.unicase.metamodel.ModelElementEObjectWrapper#getWrappedEObject
	 * <em>Wrapped EObject</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Wrapped EObject</em>' reference.
	 * @see #getWrappedEObject()
	 * @generated
	 */
	void setWrappedEObject(EObject value);

} // ModelElementEObjectWrapper
