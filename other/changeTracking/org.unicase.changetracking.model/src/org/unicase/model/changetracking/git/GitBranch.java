/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 */
package org.unicase.model.changetracking.git;

import org.eclipse.emf.common.util.EList;

import org.unicase.model.changetracking.RepositoryStream;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Branch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.changetracking.git.GitBranch#getReferringChangePackages <em>Referring Change Packages</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.git.GitBranch#getBranchName <em>Branch Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.changetracking.git.GitPackage#getGitBranch()
 * @model
 * @generated
 */
public interface GitBranch extends RepositoryStream {
	/**
	 * Returns the value of the '<em><b>Referring Change Packages</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.changetracking.git.GitBranchChangePackage}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.changetracking.git.GitBranchChangePackage#getBranch <em>Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referring Change Packages</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referring Change Packages</em>' reference list.
	 * @see org.unicase.model.changetracking.git.GitPackage#getGitBranch_ReferringChangePackages()
	 * @see org.unicase.model.changetracking.git.GitBranchChangePackage#getBranch
	 * @model opposite="branch"
	 * @generated
	 */
	EList<GitBranchChangePackage> getReferringChangePackages();

	/**
	 * Returns the value of the '<em><b>Branch Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branch Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branch Name</em>' attribute.
	 * @see #setBranchName(String)
	 * @see org.unicase.model.changetracking.git.GitPackage#getGitBranch_BranchName()
	 * @model
	 * @generated
	 */
	String getBranchName();

	/**
	 * Sets the value of the '{@link org.unicase.model.changetracking.git.GitBranch#getBranchName <em>Branch Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Branch Name</em>' attribute.
	 * @see #getBranchName()
	 * @generated
	 */
	void setBranchName(String value);

} // GitBranch
