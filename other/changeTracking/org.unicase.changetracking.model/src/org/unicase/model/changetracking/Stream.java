/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.model.changetracking;

import org.eclipse.emf.common.util.EList;

import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stream</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.changetracking.Stream#getReleases <em>Releases</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.Stream#getRepositoryStream <em>Repository Stream</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.changetracking.ChangetrackingPackage#getStream()
 * @model
 * @generated
 */
public interface Stream extends UnicaseModelElement
{
	/**
	 * Returns the value of the '<em><b>Releases</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.changetracking.Release}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.changetracking.Release#getStream <em>Stream</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Releases</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Releases</em>' reference list.
	 * @see org.unicase.model.changetracking.ChangetrackingPackage#getStream_Releases()
	 * @see org.unicase.model.changetracking.Release#getStream
	 * @model opposite="stream"
	 *        annotation="org.unicase.ui.meeditor priority='10.0' position='right'"
	 * @generated
	 */
	EList<Release> getReleases();

	/**
	 * Returns the value of the '<em><b>Repository Stream</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.changetracking.RepositoryStream#getUsingStreams <em>Using Streams</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository Stream</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Stream</em>' reference.
	 * @see #setRepositoryStream(RepositoryStream)
	 * @see org.unicase.model.changetracking.ChangetrackingPackage#getStream_RepositoryStream()
	 * @see org.unicase.model.changetracking.RepositoryStream#getUsingStreams
	 * @model opposite="usingStreams"
	 * @generated
	 */
	RepositoryStream getRepositoryStream();

	/**
	 * Sets the value of the '{@link org.unicase.model.changetracking.Stream#getRepositoryStream <em>Repository Stream</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Stream</em>' reference.
	 * @see #getRepositoryStream()
	 * @generated
	 */
	void setRepositoryStream(RepositoryStream value);

} // Stream
