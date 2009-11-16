/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Operation Composite</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.workspace.OperationComposite#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.workspace.WorkspacePackage#getOperationComposite()
 * @model
 * @generated
 */
public interface OperationComposite extends EObject {
	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' containment reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see org.unicase.workspace.WorkspacePackage#getOperationComposite_Operations()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<AbstractOperation> getOperations();

} // OperationComposite
