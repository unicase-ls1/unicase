/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.operations;

import java.util.Date;

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
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#isAccepted <em>Accepted</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#getClientDate <em>Client Date</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getAbstractOperation()
 * @model abstract="true"
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
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getAbstractOperation_Name()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getName();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getAbstractOperation_Description()
	 * @model default="" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Returns the value of the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element Id</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element Id</em>' containment reference.
	 * @see #setModelElementId(ModelElementId)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getAbstractOperation_ModelElementId()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ModelElementId getModelElementId();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#getModelElementId <em>Model Element Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Element Id</em>' containment reference.
	 * @see #getModelElementId()
	 * @generated
	 */
	void setModelElementId(ModelElementId value);

	/**
	 * Returns the value of the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accepted</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accepted</em>' attribute.
	 * @see #setAccepted(boolean)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getAbstractOperation_Accepted()
	 * @model transient="true"
	 * @generated
	 */
	boolean isAccepted();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#isAccepted <em>Accepted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Accepted</em>' attribute.
	 * @see #isAccepted()
	 * @generated
	 */
	void setAccepted(boolean value);

	/**
	 * Returns the value of the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Client Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Client Date</em>' attribute.
	 * @see #setClientDate(Date)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getAbstractOperation_ClientDate()
	 * @model
	 * @generated
	 */
	Date getClientDate();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#getClientDate <em>Client Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Date</em>' attribute.
	 * @see #getClientDate()
	 * @generated
	 */
	void setClientDate(Date value);

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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isChange();

} // AbstractOperation
