/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.release;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Stream</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.release.Stream#getReleases <em>Releases</em>}</li>
 * <li>{@link org.unicase.model.release.Stream#getSourceCodeRepositoryStream <em>Source Code Repository Stream</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.release.ReleasePackage#getStream()
 * @model
 * @generated
 */
public interface Stream extends EObject {
	/**
	 * Returns the value of the '<em><b>Releases</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.model.release.Release}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.release.Release#getStream <em>Stream</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Releases</em>' containment reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Releases</em>' containment reference list.
	 * @see org.unicase.model.release.ReleasePackage#getStream_Releases()
	 * @see org.unicase.model.release.Release#getStream
	 * @model opposite="stream" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Release> getReleases();

	/**
	 * Returns the value of the '<em><b>Source Code Repository Stream</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Code Repository Stream</em>' reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source Code Repository Stream</em>' reference.
	 * @see #setSourceCodeRepositoryStream(SourceCodeRepositoryStream)
	 * @see org.unicase.model.release.ReleasePackage#getStream_SourceCodeRepositoryStream()
	 * @model
	 * @generated
	 */
	SourceCodeRepositoryStream getSourceCodeRepositoryStream();

	/**
	 * Sets the value of the '{@link org.unicase.model.release.Stream#getSourceCodeRepositoryStream
	 * <em>Source Code Repository Stream</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Source Code Repository Stream</em>' reference.
	 * @see #getSourceCodeRepositoryStream()
	 * @generated
	 */
	void setSourceCodeRepositoryStream(SourceCodeRepositoryStream value);

} // Stream
