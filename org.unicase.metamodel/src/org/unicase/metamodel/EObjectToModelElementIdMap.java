/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.unicase.metamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>EObject To Model Element Id Map</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.metamodel.EObjectToModelElementIdMap#getKey <em>Key</em>}</li>
 * <li>{@link org.unicase.metamodel.EObjectToModelElementIdMap#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.metamodel.MetamodelPackage#getEObjectToModelElementIdMap()
 * @model
 * @generated
 */
public interface EObjectToModelElementIdMap extends EObject {
	/**
	 * Returns the value of the '<em><b>Key</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Key</em>' reference.
	 * @see #setKey(EObject)
	 * @see org.unicase.metamodel.MetamodelPackage#getEObjectToModelElementIdMap_Key()
	 * @model
	 * @generated
	 */
	EObject getKey();

	/**
	 * Sets the value of the '{@link org.unicase.metamodel.EObjectToModelElementIdMap#getKey <em>Key</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Key</em>' reference.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(EObject value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(ModelElementId)
	 * @see org.unicase.metamodel.MetamodelPackage#getEObjectToModelElementIdMap_Value()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ModelElementId getValue();

	/**
	 * Sets the value of the '{@link org.unicase.metamodel.EObjectToModelElementIdMap#getValue <em>Value</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(ModelElementId value);

} // EObjectToModelElementIdMap
