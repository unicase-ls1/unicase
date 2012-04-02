/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.model.changetracking.git;

import org.unicase.model.changetracking.RepositoryLocation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.changetracking.git.GitRepository#getUrl <em>Url</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.git.GitRepository#getIdentifyingCommitHash <em>Identifying Commit Hash</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.changetracking.git.GitPackage#getGitRepository()
 * @model
 * @generated
 */
public interface GitRepository extends RepositoryLocation
{
	/**
	 * Returns the value of the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url</em>' attribute.
	 * @see #setUrl(String)
	 * @see org.unicase.model.changetracking.git.GitPackage#getGitRepository_Url()
	 * @model
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link org.unicase.model.changetracking.git.GitRepository#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url</em>' attribute.
	 * @see #getUrl()
	 * @generated
	 */
	void setUrl(String value);

	/**
	 * Returns the value of the '<em><b>Identifying Commit Hash</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifying Commit Hash</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifying Commit Hash</em>' attribute.
	 * @see #setIdentifyingCommitHash(String)
	 * @see org.unicase.model.changetracking.git.GitPackage#getGitRepository_IdentifyingCommitHash()
	 * @model
	 * @generated
	 */
	String getIdentifyingCommitHash();

	/**
	 * Sets the value of the '{@link org.unicase.model.changetracking.git.GitRepository#getIdentifyingCommitHash <em>Identifying Commit Hash</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifying Commit Hash</em>' attribute.
	 * @see #getIdentifyingCommitHash()
	 * @generated
	 */
	void setIdentifyingCommitHash(String value);

} // GitRepository
