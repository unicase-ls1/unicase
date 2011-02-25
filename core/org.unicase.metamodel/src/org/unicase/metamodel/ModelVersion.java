/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Version</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.metamodel.ModelVersion#getReleaseNumber <em>Release Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.metamodel.MetamodelPackage#getModelVersion()
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
	 * @see org.unicase.metamodel.MetamodelPackage#getModelVersion_ReleaseNumber()
	 * @model
	 * @generated
	 */
	int getReleaseNumber();

	/**
	 * Sets the value of the '{@link org.unicase.metamodel.ModelVersion#getReleaseNumber <em>Release Number</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Release Number</em>' attribute.
	 * @see #getReleaseNumber()
	 * @generated
	 */
	void setReleaseNumber(int value);

} // ModelVersion
