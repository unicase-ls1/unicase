/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.model;

import org.eclipse.emf.ecore.EObject;
import org.osgi.framework.Version;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Version Info</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.VersionInfo#getEmfStoreVersionString <em>Emf Store Version String</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.emf.emfstore.server.model.EsmodelPackage#getVersionInfo()
 * @model
 * @generated
 */
public interface VersionInfo extends EObject {
	/**
	 * Returns the value of the '<em><b>Emf Store Version String</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Emf Store Version String</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Emf Store Version String</em>' attribute.
	 * @see #setEmfStoreVersionString(String)
	 * @see org.eclipse.emf.emfstore.server.model.EsmodelPackage#getVersionInfo_EmfStoreVersionString()
	 * @model
	 * @generated
	 */
	String getEmfStoreVersionString();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.VersionInfo#getEmfStoreVersionString
	 * <em>Emf Store Version String</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Emf Store Version String</em>' attribute.
	 * @see #getEmfStoreVersionString()
	 * @generated
	 */
	void setEmfStoreVersionString(String value);

	/**
	 * Returns the value of the '<em><b>Emf Store Version String</b></em>' attribute as a Version. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 * @return the version of the emf store plugin.
	 */
	Version getEmfStoreVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.VersionInfo#getEmfStoreVersionString
	 * <em>Emf Store Version String</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 * @param emfStoreVersion the version of the emf store plugin
	 */
	void setEmfStoreVersion(Version emfStoreVersion);

} // VersionInfo
