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
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.HistoryQuery#getFrom <em>From</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.HistoryQuery#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.versioning.VersioningPackage#getHistoryQuery()
 * @model
 * @generated
 */
public interface HistoryQuery extends EObject {
	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(PrimaryVersionSpec)
	 * @see org.unicase.emfstore.esmodel.versioning.VersioningPackage#getHistoryQuery_From()
	 * @model
	 * @generated
	 */
	PrimaryVersionSpec getFrom();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.HistoryQuery#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(PrimaryVersionSpec value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(PrimaryVersionSpec)
	 * @see org.unicase.emfstore.esmodel.versioning.VersioningPackage#getHistoryQuery_To()
	 * @model
	 * @generated
	 */
	PrimaryVersionSpec getTo();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.HistoryQuery#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(PrimaryVersionSpec value);

} // HistoryQuery
