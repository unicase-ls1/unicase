/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.eclipse.emf.emfstore.common.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>EObject To Model Element Id Map</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.common.modelore.common.model.EObjectToModelElementIdMap#getKey <em>Key</em>}</liorg.eclipse.emf.emfstore.common.modelclipse.emf.emfstore.common.model.EObjectToModelElementIdMap#getValue <em>Value</em>}</lorg.eclipse.emf.emfstore.common.model* 
 * @see org.eclipse.emf.emfstore.common.model.MetamodelPackage#getEObjectToModelElementIdMap()
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
	 * @return the value of the '<em>Key</em>org.eclipse.emf.emfstore.common.model #setKey(EObject)
	 * @see org.eclipse.emf.emfstore.common.model.MetamodelPackage#getEObjectToModelElementIdMap_Key()
	 * @model
	 * @generated
org.eclipse.emf.emfstore.common.model);

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.common.model.EObjectToModelElementIdMap#getKey <em>Key</em>}' reference.
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
	 * @return the value of the '<emorg.eclipse.emf.emfstore.common.modelent reference.
	 * @see #setValue(ModelElementId)
	 * @see org.eclipse.emf.emfstore.common.model.MetamodelPackage#getEObjectToModelElementIdMap_Value()
	 * @model containment="true" resolveProxiesorg.eclipse.emf.emfstore.common.modeld
	 */
	ModelElementId getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.common.model.EObjectToModelElementIdMap#getValue <em>Value</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(ModelElementId value);

} // EObjectToModelElementIdMap
