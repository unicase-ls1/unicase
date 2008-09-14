/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>History Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.HistoryQuery#getSource <em>Source</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.HistoryQuery#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.versioning.VersioningPackage#getHistoryQuery()
 * @model
 * @generated
 */
public interface HistoryQuery extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(PrimaryVersionSpec)
	 * @see org.unicase.emfstore.esmodel.versioning.VersioningPackage#getHistoryQuery_Source()
	 * @model
	 * @generated
	 */
	PrimaryVersionSpec getSource();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.HistoryQuery#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(PrimaryVersionSpec value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(PrimaryVersionSpec)
	 * @see org.unicase.emfstore.esmodel.versioning.VersioningPackage#getHistoryQuery_Target()
	 * @model
	 * @generated
	 */
	PrimaryVersionSpec getTarget();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.HistoryQuery#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(PrimaryVersionSpec value);

} // HistoryQuery
