/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.operations;

import org.eclipse.emf.ecore.EObject;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#getName <em>Name</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#getDescription <em>Description</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#getModelElementId <em>Model Element Id</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#getUsername <em>Username</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getAbstractOperation()
 * @model
 * @generated
 */
public interface AbstractOperation extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getAbstractOperation_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getAbstractOperation_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Model Element Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element Id</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element Id</em>' reference.
	 * @see #setModelElementId(ModelElementId)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getAbstractOperation_ModelElementId()
	 * @model
	 * @generated
	 */
	ModelElementId getModelElementId();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#getModelElementId <em>Model Element Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Element Id</em>' reference.
	 * @see #getModelElementId()
	 * @generated
	 */
	void setModelElementId(ModelElementId value);

	/**
	 * Returns the value of the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Username</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Username</em>' attribute.
	 * @see #setUsername(String)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getAbstractOperation_Username()
	 * @model
	 * @generated
	 */
	String getUsername();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#getUsername <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Username</em>' attribute.
	 * @see #getUsername()
	 * @generated
	 */
	void setUsername(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void apply(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	AbstractOperation reverse();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canApply(Project project);

} // AbstractOperation
