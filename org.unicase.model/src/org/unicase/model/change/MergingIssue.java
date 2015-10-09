/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.change;

import org.eclipse.emf.emfstore.internal.server.model.versioning.PrimaryVersionSpec;
import org.unicase.model.rationale.Issue;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Merging Issue</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.change.MergingIssue#getBaseVersion <em>Base Version</em>}</li>
 *   <li>{@link org.unicase.model.change.MergingIssue#getTargetVersion <em>Target Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.change.ChangePackage#getMergingIssue()
 * @model
 * @generated
 */
public interface MergingIssue extends Issue {
	/**
	 * Returns the value of the '<em><b>Base Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Version</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Version</em>' containment reference.
	 * @see #setBaseVersion(PrimaryVersionSpec)
	 * @see org.unicase.model.change.ChangePackage#getMergingIssue_BaseVersion()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	PrimaryVersionSpec getBaseVersion();

	/**
	 * Sets the value of the '{@link org.unicase.model.change.MergingIssue#getBaseVersion <em>Base Version</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Version</em>' containment reference.
	 * @see #getBaseVersion()
	 * @generated
	 */
	void setBaseVersion(PrimaryVersionSpec value);

	/**
	 * Returns the value of the '<em><b>Target Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Version</em>' containment reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Version</em>' containment reference.
	 * @see #setTargetVersion(PrimaryVersionSpec)
	 * @see org.unicase.model.change.ChangePackage#getMergingIssue_TargetVersion()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	PrimaryVersionSpec getTargetVersion();

	/**
	 * Sets the value of the '{@link org.unicase.model.change.MergingIssue#getTargetVersion <em>Target Version</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Version</em>' containment reference.
	 * @see #getTargetVersion()
	 * @generated
	 */
	void setTargetVersion(PrimaryVersionSpec value);

} // MergingIssue
