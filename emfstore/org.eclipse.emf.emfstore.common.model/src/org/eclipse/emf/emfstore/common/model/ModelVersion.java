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
package org.eclipse.emf.emfstore.common.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Version</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.common.model.ModelVersion#getReleaseNumber <em>Release Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.common.model.ModelPackage#getModelVersion()
 * @model
 * @generated
 */
public interface ModelVersion extends EObject {
	/**
	 * Returns the value of the '<em><b>Release Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Release Number</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Release Number</em>' attribute.
	 * @see #setReleaseNumber(int)
	 * @see org.eclipse.emf.emfstore.common.model.ModelPackage#getModelVersion_ReleaseNumber()
	 * @model
	 * @generated
	 */
	int getReleaseNumber();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.common.model.ModelVersion#getReleaseNumber <em>Release Number</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Release Number</em>' attribute.
	 * @see #getReleaseNumber()
	 * @generated
	 */
	void setReleaseNumber(int value);

} // ModelVersion
