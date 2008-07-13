/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.unicase.model.Project;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Change Package</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.ChangePackage#getFowardDelta <em>Foward Delta</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.ChangePackage#getBackwardDelta <em>Backward Delta</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.ChangePackage#getProjectState <em>Project State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.versioning.VersioningPackage#getChangePackage()
 * @model
 * @generated
 */
public interface ChangePackage extends EObject {
	/**
	 * Returns the value of the '<em><b>Foward Delta</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foward Delta</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foward Delta</em>' containment reference.
	 * @see #setFowardDelta(ChangeDescription)
	 * @see org.unicase.emfstore.esmodel.versioning.VersioningPackage#getChangePackage_FowardDelta()
	 * @model containment="true"
	 * @generated
	 */
	ChangeDescription getFowardDelta();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.ChangePackage#getFowardDelta <em>Foward Delta</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Foward Delta</em>' containment reference.
	 * @see #getFowardDelta()
	 * @generated
	 */
	void setFowardDelta(ChangeDescription value);

	/**
	 * Returns the value of the '<em><b>Backward Delta</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Backward Delta</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Backward Delta</em>' containment reference.
	 * @see #setBackwardDelta(ChangeDescription)
	 * @see org.unicase.emfstore.esmodel.versioning.VersioningPackage#getChangePackage_BackwardDelta()
	 * @model containment="true"
	 * @generated
	 */
	ChangeDescription getBackwardDelta();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.ChangePackage#getBackwardDelta <em>Backward Delta</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Backward Delta</em>' containment reference.
	 * @see #getBackwardDelta()
	 * @generated
	 */
	void setBackwardDelta(ChangeDescription value);

	/**
	 * Returns the value of the '<em><b>Project State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project State</em>' containment reference.
	 * @see #setProjectState(Project)
	 * @see org.unicase.emfstore.esmodel.versioning.VersioningPackage#getChangePackage_ProjectState()
	 * @model containment="true"
	 * @generated
	 */
	Project getProjectState();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.ChangePackage#getProjectState <em>Project State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project State</em>' containment reference.
	 * @see #getProjectState()
	 * @generated
	 */
	void setProjectState(Project value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ChangePackage reverse();

} // ChangePackage
