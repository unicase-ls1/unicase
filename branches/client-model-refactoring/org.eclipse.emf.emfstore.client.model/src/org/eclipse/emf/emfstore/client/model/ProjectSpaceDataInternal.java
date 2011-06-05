/**
 * <copyright> Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Unversitaet Muenchen. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 */
package org.eclipse.emf.emfstore.client.model;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.emfstore.common.model.IdentifiableElement;
import org.eclipse.emf.emfstore.common.model.Project;

import org.eclipse.emf.emfstore.server.model.FileIdentifier;
import org.eclipse.emf.emfstore.server.model.ProjectId;

import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project Space Data Internal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getProjectId <em>Project Id</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getProjectDescription <em>Project Description</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getUsersession <em>Usersession</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getLastUpdated <em>Last Updated</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getBaseVersion <em>Base Version</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getResourceCount <em>Resource Count</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#isDirty <em>Dirty</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getOldLogMessages <em>Old Log Messages</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getWaitingUploads <em>Waiting Uploads</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getProjectSpaceDataInternal()
 * @model
 * @generated NOT
 */
public interface ProjectSpaceDataInternal extends IdentifiableElement,
		ProjectSpaceData {
	/**
	 * Returns the value of the '<em><b>Project Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Id</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Id</em>' containment reference.
	 * @see #setProjectId(ProjectId)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getProjectSpaceDataInternal_ProjectId()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	ProjectId getProjectId();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getProjectId <em>Project Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Id</em>' containment reference.
	 * @see #getProjectId()
	 * @generated
	 */
	void setProjectId(ProjectId value);

	/**
	 * Returns the value of the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Name</em>' attribute.
	 * @see #setProjectName(String)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getProjectSpaceDataInternal_ProjectName()
	 * @model required="true"
	 * @generated
	 */
	String getProjectName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getProjectName <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Name</em>' attribute.
	 * @see #getProjectName()
	 * @generated
	 */
	void setProjectName(String value);

	/**
	 * Returns the value of the '<em><b>Project Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Description</em>' attribute.
	 * @see #setProjectDescription(String)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getProjectSpaceDataInternal_ProjectDescription()
	 * @model required="true"
	 * @generated
	 */
	String getProjectDescription();

	// TODO: doc
	OperationComposite getLocalOperations();
	
	// TODO: doc
	void setLocalOperations(OperationComposite operationComposite);

	void setProject(Project newProject);

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getProjectDescription <em>Project Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Description</em>' attribute.
	 * @see #getProjectDescription()
	 * @generated
	 */
	void setProjectDescription(String value);

	/**
	 * Returns the value of the '<em><b>Usersession</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usersession</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usersession</em>' reference.
	 * @see #setUsersession(Usersession)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getProjectSpaceDataInternal_Usersession()
	 * @model
	 * @generated
	 */
	Usersession getUsersession();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getUsersession <em>Usersession</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usersession</em>' reference.
	 * @see #getUsersession()
	 * @generated
	 */
	void setUsersession(Usersession value);

	/**
	 * Returns the value of the '<em><b>Last Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Updated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Updated</em>' attribute.
	 * @see #setLastUpdated(Date)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getProjectSpaceDataInternal_LastUpdated()
	 * @model
	 * @generated
	 */
	Date getLastUpdated();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getLastUpdated <em>Last Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Updated</em>' attribute.
	 * @see #getLastUpdated()
	 * @generated
	 */
	void setLastUpdated(Date value);

	/**
	 * Returns the value of the '<em><b>Base Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Version</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Version</em>' containment reference.
	 * @see #setBaseVersion(PrimaryVersionSpec)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getProjectSpaceDataInternal_BaseVersion()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	PrimaryVersionSpec getBaseVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getBaseVersion <em>Base Version</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Version</em>' containment reference.
	 * @see #getBaseVersion()
	 * @generated
	 */
	void setBaseVersion(PrimaryVersionSpec value);

	/**
	 * Returns the value of the '<em><b>Resource Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Count</em>' attribute.
	 * @see #setResourceCount(int)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getProjectSpaceDataInternal_ResourceCount()
	 * @model
	 * @generated
	 */
	int getResourceCount();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getResourceCount <em>Resource Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Count</em>' attribute.
	 * @see #getResourceCount()
	 * @generated
	 */
	void setResourceCount(int value);

	/**
	 * Returns the value of the '<em><b>Dirty</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dirty</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dirty</em>' attribute.
	 * @see #setDirty(boolean)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getProjectSpaceDataInternal_Dirty()
	 * @model
	 * @generated
	 */
	boolean isDirty();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#isDirty <em>Dirty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dirty</em>' attribute.
	 * @see #isDirty()
	 * @generated
	 */
	void setDirty(boolean value);

	/**
	 * Returns the value of the '<em><b>Old Log Messages</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Log Messages</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Log Messages</em>' attribute list.
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getProjectSpaceDataInternal_OldLogMessages()
	 * @model
	 * @generated
	 */
	EList<String> getOldLogMessages();

	/**
	 * Returns the value of the '<em><b>Waiting Uploads</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.server.model.FileIdentifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Waiting Uploads</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Waiting Uploads</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getProjectSpaceDataInternal_WaitingUploads()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<FileIdentifier> getWaitingUploads();

} // ProjectSpaceDataInternal
