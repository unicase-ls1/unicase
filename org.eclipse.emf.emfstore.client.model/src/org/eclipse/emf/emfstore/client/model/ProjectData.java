/**
 * <copyright> Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Unversitaet Muenchen. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 */
package org.eclipse.emf.emfstore.client.model;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.emfstore.common.model.Project;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.ProjectData#getProject <em>Project</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.ProjectData#getLocalOperations <em>Local Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getProjectData()
 * @model
 * @generated
 */
public interface ProjectData extends EObject {
	/**
	 * Returns the value of the '<em><b>Project</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' containment reference.
	 * @see #setProject(Project)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getProjectData_Project()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Project getProject();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.ProjectData#getProject <em>Project</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' containment reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(Project value);

	/**
	 * Returns the value of the '<em><b>Local Operations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Operations</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Operations</em>' containment reference.
	 * @see #setLocalOperations(OperationComposite)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getProjectData_LocalOperations()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	OperationComposite getLocalOperations();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.ProjectData#getLocalOperations <em>Local Operations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Operations</em>' containment reference.
	 * @see #getLocalOperations()
	 * @generated
	 */
	void setLocalOperations(OperationComposite value);

} // ProjectData
