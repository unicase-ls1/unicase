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
 * A representation of the model object '<em><b>Repository Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.changetracking.RepositoryLocation#getStreams <em>Streams</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.changetracking.ChangetrackingPackage#getRepositoryLocation()
 * @model abstract="true"
 * @generated
 */
public interface RepositoryLocation extends UnicaseModelElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "<copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>\r";

	/**
	 * Returns the value of the '<em><b>Streams</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.changetracking.RepositoryStream}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.changetracking.RepositoryStream#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Streams</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Streams</em>' reference list.
	 * @see org.unicase.model.changetracking.ChangetrackingPackage#getRepositoryLocation_Streams()
	 * @see org.unicase.model.changetracking.RepositoryStream#getLocation
	 * @model opposite="location"
	 * @generated
	 */
	EList<RepositoryStream> getStreams();

} // RepositoryLocation
