/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.jdt.operationstore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Store</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.jdt.operationstore.OperationStore#getOperationSets <em>Operation Sets</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.jdt.operationstore.OperationstorePackage#getOperationStore()
 * @model
 * @generated
 */
public interface OperationStore extends EObject {
	/**
	 * Returns the value of the '<em><b>Operation Sets</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.emfstore.jdt.operationstore.OperationSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Sets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Sets</em>' containment reference list.
	 * @see org.unicase.emfstore.jdt.operationstore.OperationstorePackage#getOperationStore_OperationSets()
	 * @model containment="true"
	 * @generated
	 */
	EList<OperationSet> getOperationSets();

} // OperationStore
