/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.url;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Model Element Url</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.url.ModelElementUrl#getServerUrl <em>Server Url</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.url.ModelElementUrl#getProjectUrlFragment <em>Project Url Fragment</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.url.ModelElementUrl#getModelElementUrlFragment <em>Model Element Url Fragment
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.emfstore.esmodel.url.UrlPackage#getModelElementUrl()
 * @model
 * @generated
 */
public interface ModelElementUrl extends EObject {
	/**
	 * Returns the value of the '<em><b>Server Url</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Url</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Server Url</em>' containment reference.
	 * @see #setServerUrl(ServerUrl)
	 * @see org.unicase.emfstore.esmodel.url.UrlPackage#getModelElementUrl_ServerUrl()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ServerUrl getServerUrl();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.url.ModelElementUrl#getServerUrl <em>Server Url</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Server Url</em>' containment reference.
	 * @see #getServerUrl()
	 * @generated
	 */
	void setServerUrl(ServerUrl value);

	/**
	 * Returns the value of the '<em><b>Project Url Fragment</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Url Fragment</em>' containment reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Project Url Fragment</em>' containment reference.
	 * @see #setProjectUrlFragment(ProjectUrlFragment)
	 * @see org.unicase.emfstore.esmodel.url.UrlPackage#getModelElementUrl_ProjectUrlFragment()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ProjectUrlFragment getProjectUrlFragment();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.url.ModelElementUrl#getProjectUrlFragment
	 * <em>Project Url Fragment</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Project Url Fragment</em>' containment reference.
	 * @see #getProjectUrlFragment()
	 * @generated
	 */
	void setProjectUrlFragment(ProjectUrlFragment value);

	/**
	 * Returns the value of the '<em><b>Model Element Url Fragment</b></em>' containment reference. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Model Element Url Fragment</em>' containment reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Element Url Fragment</em>' containment reference.
	 * @see #setModelElementUrlFragment(ModelElementUrlFragment)
	 * @see org.unicase.emfstore.esmodel.url.UrlPackage#getModelElementUrl_ModelElementUrlFragment()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ModelElementUrlFragment getModelElementUrlFragment();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.url.ModelElementUrl#getModelElementUrlFragment
	 * <em>Model Element Url Fragment</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Model Element Url Fragment</em>' containment reference.
	 * @see #getModelElementUrlFragment()
	 * @generated
	 */
	void setModelElementUrlFragment(ModelElementUrlFragment value);

	/**
	 * Returns a string representation of the url.
	 * 
	 * @return the string
	 */
	String getUrlString();

} // ModelElementUrl
