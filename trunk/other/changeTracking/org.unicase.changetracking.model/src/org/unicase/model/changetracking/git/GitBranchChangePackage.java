/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 *
 * $Id$
 */
package org.unicase.model.changetracking.git;

import org.unicase.model.changetracking.ChangePackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Branch Change Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.changetracking.git.GitBranchChangePackage#getBranch <em>Branch</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.changetracking.git.GitPackage#getGitBranchChangePackage()
 * @model
 * @generated
 */
public interface GitBranchChangePackage extends ChangePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "<copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>\r";

	/**
	 * Returns the value of the '<em><b>Branch</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.changetracking.git.GitBranch#getReferringChangePackages <em>Referring Change Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branch</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branch</em>' reference.
	 * @see #setBranch(GitBranch)
	 * @see org.unicase.model.changetracking.git.GitPackage#getGitBranchChangePackage_Branch()
	 * @see org.unicase.model.changetracking.git.GitBranch#getReferringChangePackages
	 * @model opposite="referringChangePackages"
	 * @generated
	 */
	GitBranch getBranch();

	/**
	 * Sets the value of the '{@link org.unicase.model.changetracking.git.GitBranchChangePackage#getBranch <em>Branch</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Branch</em>' reference.
	 * @see #getBranch()
	 * @generated
	 */
	void setBranch(GitBranch value);

} // GitBranchChangePackage
