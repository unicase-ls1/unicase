/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Model Version</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.workspace.WorkspaceModelVersion#getModelReleaseNumber <em>Model Release Number</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.workspace.WorkspacePackage#getWorkspaceModelVersion()
 * @model
 * @generated
 */
public interface WorkspaceModelVersion extends EObject {
	/**
	 * Returns the value of the '<em><b>Model Release Number</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Release Number</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Release Number</em>' attribute.
	 * @see #setModelReleaseNumber(int)
	 * @see org.unicase.workspace.WorkspacePackage#getWorkspaceModelVersion_ModelReleaseNumber()
	 * @model
	 * @generated
	 */
	int getModelReleaseNumber();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.WorkspaceModelVersion#getModelReleaseNumber
	 * <em>Model Release Number</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Model Release Number</em>' attribute.
	 * @see #getModelReleaseNumber()
	 * @generated
	 */
	void setModelReleaseNumber(int value);

} // WorkspaceModelVersion
