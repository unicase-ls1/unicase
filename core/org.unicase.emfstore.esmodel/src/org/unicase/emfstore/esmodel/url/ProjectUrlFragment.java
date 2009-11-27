/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.url;

import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.ProjectId;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Project Url Fragment</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.url.ProjectUrlFragment#getName <em>Name</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.url.ProjectUrlFragment#getProjectId <em>Project Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.url.UrlPackage#getProjectUrlFragment()
 * @model
 * @generated
 */
public interface ProjectUrlFragment extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.unicase.emfstore.esmodel.url.UrlPackage#getProjectUrlFragment_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.url.ProjectUrlFragment#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Project Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Id</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Id</em>' containment reference.
	 * @see #setProjectId(ProjectId)
	 * @see org.unicase.emfstore.esmodel.url.UrlPackage#getProjectUrlFragment_ProjectId()
	 * @model containment="true" resolveProxies="true" keys="id"
	 * @generated
	 */
	ProjectId getProjectId();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.url.ProjectUrlFragment#getProjectId <em>Project Id</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Id</em>' containment reference.
	 * @see #getProjectId()
	 * @generated
	 */
	void setProjectId(ProjectId value);

	/**
	 * Returns a string representation of the url.
	 * 
	 * @return the string
	 */
	String getUrlString();

} // ProjectUrlFragment
