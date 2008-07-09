/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Kögel
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.changemanagment.changepackage;

import org.unicase.model.ModelElementId;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ES Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESEvent#getModelElementId <em>Model Element Id</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESEvent#getFeatureId <em>Feature Id</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESEvent#getModelElementClass <em>Model Element Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage#getESEvent()
 * @model abstract="true"
 * @generated
 */
public interface ESEvent extends ESAbstractOperation {
	/**
	 * Returns the value of the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element Id</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element Id</em>' containment reference.
	 * @see #setModelElementId(ModelElementId)
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage#getESEvent_ModelElementId()
	 * @model containment="true"
	 * @generated
	 */
	ModelElementId getModelElementId();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESEvent#getModelElementId <em>Model Element Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Element Id</em>' containment reference.
	 * @see #getModelElementId()
	 * @generated
	 */
	void setModelElementId(ModelElementId value);

	/**
	 * Returns the value of the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Id</em>' attribute.
	 * @see #setFeatureId(int)
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage#getESEvent_FeatureId()
	 * @model
	 * @generated
	 */
	int getFeatureId();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESEvent#getFeatureId <em>Feature Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Id</em>' attribute.
	 * @see #getFeatureId()
	 * @generated
	 */
	void setFeatureId(int value);

	/**
	 * Returns the value of the '<em><b>Model Element Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element Class</em>' attribute.
	 * @see #setModelElementClass(Class)
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage#getESEvent_ModelElementClass()
	 * @model
	 * @generated
	 */
	Class<?> getModelElementClass();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESEvent#getModelElementClass <em>Model Element Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Element Class</em>' attribute.
	 * @see #getModelElementClass()
	 * @generated
	 */
	void setModelElementClass(Class<?> value);

} // ESEvent
