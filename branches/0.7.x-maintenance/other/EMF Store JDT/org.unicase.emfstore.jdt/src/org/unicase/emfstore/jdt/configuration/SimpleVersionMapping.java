/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.configuration;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Simple Version Mapping</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.emfstore.jdt.configuration.SimpleVersionMapping#getEMFStoreRevision <em>EMF Store Revision
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.emfstore.jdt.configuration.ConfigurationPackage#getSimpleVersionMapping()
 * @model
 * @generated
 */
public interface SimpleVersionMapping extends VersionMapping {
	/**
	 * Returns the value of the '<em><b>EMF Store Revision</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EMF Store Revision</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>EMF Store Revision</em>' attribute.
	 * @see #setEMFStoreRevision(int)
	 * @see org.unicase.emfstore.jdt.configuration.ConfigurationPackage#getSimpleVersionMapping_EMFStoreRevision()
	 * @model required="true"
	 * @generated
	 */
	int getEMFStoreRevision();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.jdt.configuration.SimpleVersionMapping#getEMFStoreRevision
	 * <em>EMF Store Revision</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>EMF Store Revision</em>' attribute.
	 * @see #getEMFStoreRevision()
	 * @generated
	 */
	void setEMFStoreRevision(int value);

} // SimpleVersionMapping
