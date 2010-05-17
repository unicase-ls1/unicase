/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.events.server;

import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Project Updated Event</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.server.ProjectUpdatedEvent#getNewVersion <em>New Version
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.emfstore.esmodel.versioning.events.server.ServerPackage#getProjectUpdatedEvent()
 * @model
 * @generated
 */
public interface ProjectUpdatedEvent extends ServerProjectEvent {
	/**
	 * Returns the value of the '<em><b>New Version</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Version</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>New Version</em>' containment reference.
	 * @see #setNewVersion(PrimaryVersionSpec)
	 * @see org.unicase.emfstore.esmodel.versioning.events.server.ServerPackage#getProjectUpdatedEvent_NewVersion()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	PrimaryVersionSpec getNewVersion();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.server.ProjectUpdatedEvent#getNewVersion
	 * <em>New Version</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>New Version</em>' containment reference.
	 * @see #getNewVersion()
	 * @generated
	 */
	void setNewVersion(PrimaryVersionSpec value);

} // ProjectUpdatedEvent
