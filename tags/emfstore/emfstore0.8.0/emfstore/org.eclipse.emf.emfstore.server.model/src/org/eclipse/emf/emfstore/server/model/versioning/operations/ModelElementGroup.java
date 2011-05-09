/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.operations;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.common.model.ModelElementId;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Model Element Group</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.ModelElementGroup#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.ModelElementGroup#getModelElements <em>Model Elements
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getModelElementGroup()
 * @model
 * @generated
 */
public interface ModelElementGroup extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getModelElementGroup_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.ModelElementGroup#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Model Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.common.model.ModelElementId}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Elements</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Elements</em>' reference list.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getModelElementGroup_ModelElements()
	 * @model
	 * @generated
	 */
	EList<ModelElementId> getModelElements();

} // ModelElementGroup
