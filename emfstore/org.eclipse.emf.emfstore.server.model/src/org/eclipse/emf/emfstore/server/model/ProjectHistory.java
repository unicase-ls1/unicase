/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.common.model.EMFStoreProperty;
import org.eclipse.emf.emfstore.server.model.versioning.Version;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Project History</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.ProjectHistory#getProjectId <em>Project Id</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.ProjectHistory#getVersions <em>Versions</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.ProjectHistory#getProjectName <em>Project Name</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.ProjectHistory#getProjectDescription <em>Project Description</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.emf.emfstore.server.model.EsmodelPackage#getProjectHistory()
 * @model
 * @generated
 */
public interface ProjectHistory extends EObject {
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
	 * @see org.eclipse.emf.emfstore.server.model.ModelPackage#getProjectHistory_ProjectId()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ProjectId getProjectId();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.ProjectHistory#getProjectId <em>Project Id</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Id</em>' containment reference.
	 * @see #getProjectId()
	 * @generated
	 */
	void setProjectId(ProjectId value);

	/**
	 * Returns the value of the '<em><b>Versions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.server.model.versioning.Version}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Versions</em>' containment reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Versions</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.server.model.ModelPackage#getProjectHistory_Versions()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	EList<Version> getVersions();

	/**
	 * Returns the last version (the last element in the version list).
	 * 
	 * @return the last version
	 * @generated NOT
	 */
	Version getLastVersion();

	/**
	 * Returns the value of the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Name</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Name</em>' attribute.
	 * @see #setProjectName(String)
	 * @see org.eclipse.emf.emfstore.server.model.ModelPackage#getProjectHistory_ProjectName()
	 * @model required="true"
	 * @generated
	 */
	String getProjectName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.ProjectHistory#getProjectName <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Name</em>' attribute.
	 * @see #getProjectName()
	 * @generated
	 */
	void setProjectName(String value);

	/**
	 * Returns the value of the '<em><b>Project Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Description</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Description</em>' attribute.
	 * @see #setProjectDescription(String)
	 * @see org.eclipse.emf.emfstore.server.model.ModelPackage#getProjectHistory_ProjectDescription()
	 * @model required="true"
	 * @generated
	 */
	String getProjectDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.ProjectHistory#getProjectDescription <em>Project Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Description</em>' attribute.
	 * @see #getProjectDescription()
	 * @generated
	 */
	void setProjectDescription(String value);

	/**
	 * Returns the value of the '<em><b>Shared Properties</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.eclipse.emf.emfstore.common.model.EMFStoreProperty},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shared Properties</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shared Properties</em>' map.
	 * @see org.eclipse.emf.emfstore.server.model.ModelPackage#getProjectHistory_SharedProperties()
	 * @model mapType="org.eclipse.emf.emfstore.common.model.PropertyMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.emfstore.common.model.EMFStoreProperty>"
	 * @generated
	 */
	EMap<String, EMFStoreProperty> getSharedProperties();

} // ProjectHistory
