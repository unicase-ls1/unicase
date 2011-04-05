/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.configuration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>History Version Mapping Entry</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.emfstore.jdt.configuration.HistoryVersionMappingEntry#getTeamProviderRevision <em>Team
 * Provider Revision</em>}</li>
 * <li>{@link org.unicase.emfstore.jdt.configuration.HistoryVersionMappingEntry#getEMFStoreRevision <em>EMF Store
 * Revision</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.emfstore.jdt.configuration.ConfigurationPackage#getHistoryVersionMappingEntry()
 * @model
 * @generated
 */
public interface HistoryVersionMappingEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Team Provider Revision</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Team Provider Revision</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Team Provider Revision</em>' attribute.
	 * @see #setTeamProviderRevision(String)
	 * @see org.unicase.emfstore.jdt.configuration.ConfigurationPackage#getHistoryVersionMappingEntry_TeamProviderRevision()
	 * @model required="true"
	 * @generated
	 */
	String getTeamProviderRevision();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.emfstore.jdt.configuration.HistoryVersionMappingEntry#getTeamProviderRevision
	 * <em>Team Provider Revision</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Team Provider Revision</em>' attribute.
	 * @see #getTeamProviderRevision()
	 * @generated
	 */
	void setTeamProviderRevision(String value);

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
	 * @see org.unicase.emfstore.jdt.configuration.ConfigurationPackage#getHistoryVersionMappingEntry_EMFStoreRevision()
	 * @model required="true"
	 * @generated
	 */
	int getEMFStoreRevision();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.emfstore.jdt.configuration.HistoryVersionMappingEntry#getEMFStoreRevision
	 * <em>EMF Store Revision</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>EMF Store Revision</em>' attribute.
	 * @see #getEMFStoreRevision()
	 * @generated
	 */
	void setEMFStoreRevision(int value);

} // HistoryVersionMappingEntry
