/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.changeContainer;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.Project;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Change Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainer#getForwardDelta <em>Forward Delta</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainer#getBackwardDelta <em>Backward Delta</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainerPackage#getChangeContainer()
 * @model
 * @generated
 */
public interface ChangeContainer extends EObject {

	final static URI VIRTUAL_PROJECT_URI = URI.createURI("virtual.project.uri");
	final static URI VIRTUAL_CHANGEDESCRIPTION_URI = URI
			.createURI("virtual.changedescription.uri");

	/**
	 * Returns the value of the '<em><b>Forward Delta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forward Delta</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forward Delta</em>' attribute.
	 * @see #setForwardDelta(String)
	 * @see org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainerPackage#getChangeContainer_ForwardDelta()
	 * @model required="true"
	 *        annotation="teneo.jpa value='@Type(type=\"text\")'"
	 * @generated
	 */
	String getForwardDelta();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainer#getForwardDelta <em>Forward Delta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Forward Delta</em>' attribute.
	 * @see #getForwardDelta()
	 * @generated
	 */
	void setForwardDelta(String value);

	/**
	 * Returns the value of the '<em><b>Backward Delta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Backward Delta</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Backward Delta</em>' attribute.
	 * @see #setBackwardDelta(String)
	 * @see org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainerPackage#getChangeContainer_BackwardDelta()
	 * @model required="true"
	 *        annotation="teneo.jpa value='@Type(type=\"text\")'"
	 * @generated
	 */
	String getBackwardDelta();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainer#getBackwardDelta <em>Backward Delta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Backward Delta</em>' attribute.
	 * @see #getBackwardDelta()
	 * @generated
	 */
	void setBackwardDelta(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ChangeContainer reverse();

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
	 * @model kind="operation"
	 * @generated
	 */
	EList<AbstractOperation> getOperations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void init(Project project, ChangeDescription backwardChangeDescription);

} // ChangeContainer
