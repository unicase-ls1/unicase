/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.iterator;

import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Version Spec Query</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.analyzer.iterator.VersionSpecQuery#getEndVersion <em>End Version</em>}</li>
 * <li>{@link org.unicase.analyzer.iterator.VersionSpecQuery#getStartVersion <em>Start Version</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.analyzer.iterator.IteratorPackage#getVersionSpecQuery()
 * @model
 * @generated
 */
public interface VersionSpecQuery extends EObject {
	/**
	 * Returns the value of the '<em><b>End Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Version</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Version</em>' containment reference.
	 * @see #setEndVersion(VersionSpec)
	 * @see org.unicase.analyzer.iterator.IteratorPackage#getVersionSpecQuery_EndVersion()
	 * @model containment="true"
	 * @generated
	 */
	VersionSpec getEndVersion();

	/**
	 * Sets the value of the '{@link org.unicase.analyzer.iterator.VersionSpecQuery#getEndVersion <em>End Version</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Version</em>' containment reference.
	 * @see #getEndVersion()
	 * @generated
	 */
	void setEndVersion(VersionSpec value);

	/**
	 * Returns the value of the '<em><b>Start Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Version</em>' containment reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Version</em>' containment reference.
	 * @see #setStartVersion(VersionSpec)
	 * @see org.unicase.analyzer.iterator.IteratorPackage#getVersionSpecQuery_StartVersion()
	 * @model containment="true"
	 * @generated
	 */
	VersionSpec getStartVersion();

	/**
	 * Sets the value of the '{@link org.unicase.analyzer.iterator.VersionSpecQuery#getStartVersion <em>Start Version</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Version</em>' containment reference.
	 * @see #getStartVersion()
	 * @generated
	 */
	void setStartVersion(VersionSpec value);

} // VersionSpecQuery
