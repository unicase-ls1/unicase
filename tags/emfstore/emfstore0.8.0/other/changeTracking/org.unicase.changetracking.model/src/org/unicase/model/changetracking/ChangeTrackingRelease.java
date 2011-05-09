/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 *
 * $Id$
 */
package org.unicase.model.changetracking;

import java.util.Date;

import org.unicase.model.release.Release;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Change Tracking Release</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.changetracking.ChangeTrackingRelease#getStream <em>Stream</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.ChangeTrackingRelease#isBuilt <em>Built</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.ChangeTrackingRelease#getBuiltRevision <em>Built Revision</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.ChangeTrackingRelease#getBuildDate <em>Build Date</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.ChangeTrackingRelease#getSuccessor <em>Successor</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.ChangeTrackingRelease#getPredecessor <em>Predecessor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.changetracking.ChangetrackingPackage#getChangeTrackingRelease()
 * @model
 * @generated
 */
public interface ChangeTrackingRelease extends Release {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "<copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>\r";

	/**
	 * Returns the value of the '<em><b>Stream</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.changetracking.Stream#getReleases <em>Releases</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stream</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stream</em>' reference.
	 * @see #setStream(Stream)
	 * @see org.unicase.model.changetracking.ChangetrackingPackage#getChangeTrackingRelease_Stream()
	 * @see org.unicase.model.changetracking.Stream#getReleases
	 * @model opposite="releases"
	 * @generated
	 */
	Stream getStream();

	/**
	 * Sets the value of the '{@link org.unicase.model.changetracking.ChangeTrackingRelease#getStream <em>Stream</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stream</em>' reference.
	 * @see #getStream()
	 * @generated
	 */
	void setStream(Stream value);

	/**
	 * Returns the value of the '<em><b>Built</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Built</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Built</em>' attribute.
	 * @see #setBuilt(boolean)
	 * @see org.unicase.model.changetracking.ChangetrackingPackage#getChangeTrackingRelease_Built()
	 * @model
	 * @generated
	 */
	boolean isBuilt();

	/**
	 * Sets the value of the '{@link org.unicase.model.changetracking.ChangeTrackingRelease#isBuilt <em>Built</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Built</em>' attribute.
	 * @see #isBuilt()
	 * @generated
	 */
	void setBuilt(boolean value);

	/**
	 * Returns the value of the '<em><b>Built Revision</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.changetracking.RepositoryRevision#getBuiltWithReleases <em>Built With Releases</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Built Revision</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Built Revision</em>' reference.
	 * @see #setBuiltRevision(RepositoryRevision)
	 * @see org.unicase.model.changetracking.ChangetrackingPackage#getChangeTrackingRelease_BuiltRevision()
	 * @see org.unicase.model.changetracking.RepositoryRevision#getBuiltWithReleases
	 * @model opposite="builtWithReleases"
	 * @generated
	 */
	RepositoryRevision getBuiltRevision();

	/**
	 * Sets the value of the '{@link org.unicase.model.changetracking.ChangeTrackingRelease#getBuiltRevision <em>Built Revision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Built Revision</em>' reference.
	 * @see #getBuiltRevision()
	 * @generated
	 */
	void setBuiltRevision(RepositoryRevision value);

	/**
	 * Returns the value of the '<em><b>Build Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Build Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Build Date</em>' attribute.
	 * @see #setBuildDate(Date)
	 * @see org.unicase.model.changetracking.ChangetrackingPackage#getChangeTrackingRelease_BuildDate()
	 * @model
	 * @generated
	 */
	Date getBuildDate();

	/**
	 * Sets the value of the '{@link org.unicase.model.changetracking.ChangeTrackingRelease#getBuildDate <em>Build Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Build Date</em>' attribute.
	 * @see #getBuildDate()
	 * @generated
	 */
	void setBuildDate(Date value);

	/**
	 * Returns the value of the '<em><b>Successor</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.changetracking.ChangeTrackingRelease#getPredecessor <em>Predecessor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Successor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Successor</em>' reference.
	 * @see #setSuccessor(ChangeTrackingRelease)
	 * @see org.unicase.model.changetracking.ChangetrackingPackage#getChangeTrackingRelease_Successor()
	 * @see org.unicase.model.changetracking.ChangeTrackingRelease#getPredecessor
	 * @model opposite="predecessor"
	 * @generated
	 */
	ChangeTrackingRelease getSuccessor();

	/**
	 * Sets the value of the '{@link org.unicase.model.changetracking.ChangeTrackingRelease#getSuccessor <em>Successor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Successor</em>' reference.
	 * @see #getSuccessor()
	 * @generated
	 */
	void setSuccessor(ChangeTrackingRelease value);

	/**
	 * Returns the value of the '<em><b>Predecessor</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.changetracking.ChangeTrackingRelease#getSuccessor <em>Successor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predecessor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predecessor</em>' reference.
	 * @see #setPredecessor(ChangeTrackingRelease)
	 * @see org.unicase.model.changetracking.ChangetrackingPackage#getChangeTrackingRelease_Predecessor()
	 * @see org.unicase.model.changetracking.ChangeTrackingRelease#getSuccessor
	 * @model opposite="successor"
	 * @generated
	 */
	ChangeTrackingRelease getPredecessor();

	/**
	 * Sets the value of the '{@link org.unicase.model.changetracking.ChangeTrackingRelease#getPredecessor <em>Predecessor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predecessor</em>' reference.
	 * @see #getPredecessor()
	 * @generated
	 */
	void setPredecessor(ChangeTrackingRelease value);

} // ChangeTrackingRelease
