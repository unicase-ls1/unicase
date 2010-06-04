/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.pmdashboard.burndown;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.unicase.model.ModelElementId;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.pmdashboard.burndown.BurndownData#getParentElementId <em>Parent Element Id</em>}</li>
 *   <li>{@link org.unicase.pmdashboard.burndown.BurndownData#getDays <em>Days</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.pmdashboard.burndown.BurndownPackage#getBurndownData()
 * @model
 * @generated
 */
public interface BurndownData extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Element Id</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Element Id</em>' containment reference.
	 * @see #setParentElementId(ModelElementId)
	 * @see org.unicase.pmdashboard.burndown.BurndownPackage#getBurndownData_ParentElementId()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ModelElementId getParentElementId();

	/**
	 * Sets the value of the '{@link org.unicase.pmdashboard.burndown.BurndownData#getParentElementId <em>Parent Element Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Element Id</em>' containment reference.
	 * @see #getParentElementId()
	 * @generated
	 */
	void setParentElementId(ModelElementId value);

	/**
	 * Returns the value of the '<em><b>Days</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.pmdashboard.burndown.BurndownDay}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Days</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Days</em>' containment reference list.
	 * @see org.unicase.pmdashboard.burndown.BurndownPackage#getBurndownData_Days()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<BurndownDay> getDays();

} // BurndownData
