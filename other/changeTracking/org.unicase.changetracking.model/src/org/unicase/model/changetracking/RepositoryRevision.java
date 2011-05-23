/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 */
package org.unicase.model.changetracking;

import org.eclipse.emf.common.util.EList;

import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository Revision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.changetracking.RepositoryRevision#getRepositoryStream <em>Repository Stream</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.RepositoryRevision#getBuiltWithReleases <em>Built With Releases</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.changetracking.ChangetrackingPackage#getRepositoryRevision()
 * @model abstract="true"
 * @generated
 */
public interface RepositoryRevision extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Repository Stream</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.changetracking.RepositoryStream#getRevisions <em>Revisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository Stream</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Stream</em>' reference.
	 * @see #setRepositoryStream(RepositoryStream)
	 * @see org.unicase.model.changetracking.ChangetrackingPackage#getRepositoryRevision_RepositoryStream()
	 * @see org.unicase.model.changetracking.RepositoryStream#getRevisions
	 * @model opposite="revisions"
	 * @generated
	 */
	RepositoryStream getRepositoryStream();

	/**
	 * Sets the value of the '{@link org.unicase.model.changetracking.RepositoryRevision#getRepositoryStream <em>Repository Stream</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Stream</em>' reference.
	 * @see #getRepositoryStream()
	 * @generated
	 */
	void setRepositoryStream(RepositoryStream value);

	/**
	 * Returns the value of the '<em><b>Built With Releases</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.changetracking.Release}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.changetracking.Release#getBuiltRevision <em>Built Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Built With Releases</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Built With Releases</em>' reference list.
	 * @see org.unicase.model.changetracking.ChangetrackingPackage#getRepositoryRevision_BuiltWithReleases()
	 * @see org.unicase.model.changetracking.Release#getBuiltRevision
	 * @model opposite="builtRevision"
	 * @generated
	 */
	EList<Release> getBuiltWithReleases();

} // RepositoryRevision
