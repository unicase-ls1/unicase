/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 *
 * $Id$
 */
package org.unicase.model.changetracking;

import org.eclipse.emf.common.util.EList;

import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository Stream</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.changetracking.RepositoryStream#getLocation <em>Location</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.RepositoryStream#getRevisions <em>Revisions</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.RepositoryStream#getUsingStreams <em>Using Streams</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.changetracking.ChangetrackingPackage#getRepositoryStream()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface RepositoryStream extends UnicaseModelElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "<copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>\r";

	/**
	 * Returns the value of the '<em><b>Location</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.changetracking.RepositoryLocation#getStreams <em>Streams</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' reference.
	 * @see #setLocation(RepositoryLocation)
	 * @see org.unicase.model.changetracking.ChangetrackingPackage#getRepositoryStream_Location()
	 * @see org.unicase.model.changetracking.RepositoryLocation#getStreams
	 * @model opposite="streams"
	 * @generated
	 */
	RepositoryLocation getLocation();

	/**
	 * Sets the value of the '{@link org.unicase.model.changetracking.RepositoryStream#getLocation <em>Location</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' reference.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(RepositoryLocation value);

	/**
	 * Returns the value of the '<em><b>Revisions</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.changetracking.RepositoryRevision}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.changetracking.RepositoryRevision#getRepositoryStream <em>Repository Stream</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Revisions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Revisions</em>' reference list.
	 * @see org.unicase.model.changetracking.ChangetrackingPackage#getRepositoryStream_Revisions()
	 * @see org.unicase.model.changetracking.RepositoryRevision#getRepositoryStream
	 * @model opposite="repositoryStream"
	 * @generated
	 */
	EList<RepositoryRevision> getRevisions();

	/**
	 * Returns the value of the '<em><b>Using Streams</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.changetracking.Stream}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.changetracking.Stream#getRepositoryStream <em>Repository Stream</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Using Streams</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Using Streams</em>' reference list.
	 * @see org.unicase.model.changetracking.ChangetrackingPackage#getRepositoryStream_UsingStreams()
	 * @see org.unicase.model.changetracking.Stream#getRepositoryStream
	 * @model opposite="repositoryStream"
	 * @generated
	 */
	EList<Stream> getUsingStreams();

} // RepositoryStream
