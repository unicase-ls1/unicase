/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace;

import java.io.IOException;
import java.util.Date;

import org.eclipse.emf.ecore.change.ChangeDescription;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.IdentifiableElement;
import org.unicase.model.Project;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Project Container</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.workspace.ProjectSpace#getProject <em>Project</em>}</li>
 *   <li>{@link org.unicase.workspace.ProjectSpace#getProjectId <em>Project Id</em>}</li>
 *   <li>{@link org.unicase.workspace.ProjectSpace#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.unicase.workspace.ProjectSpace#getProjectDescription <em>Project Description</em>}</li>
 *   <li>{@link org.unicase.workspace.ProjectSpace#getLocalChanges <em>Local Changes</em>}</li>
 *   <li>{@link org.unicase.workspace.ProjectSpace#getUsersession <em>Usersession</em>}</li>
 *   <li>{@link org.unicase.workspace.ProjectSpace#getLastUpdated <em>Last Updated</em>}</li>
 *   <li>{@link org.unicase.workspace.ProjectSpace#getBaseVersion <em>Base Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace()
 * @model
 * @generated
 */
public interface ProjectSpace extends IdentifiableElement {
	/**
	 * Returns the value of the '<em><b>Project</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' containment reference.
	 * @see #setProject(Project)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_Project()
	 * @model containment="true"
	 * @generated
	 */
	Project getProject();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#getProject <em>Project</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' containment reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(Project value);

	/**
	 * Returns the value of the '<em><b>Project Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Id</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Id</em>' containment reference.
	 * @see #setProjectId(ProjectId)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_ProjectId()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ProjectId getProjectId();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#getProjectId <em>Project Id</em>}' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Project Id</em>' containment reference.
	 * @see #getProjectId()
	 * @generated
	 */
	void setProjectId(ProjectId value);

	/**
	 * Returns the value of the '<em><b>Project Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Project Name</em>' attribute.
	 * @see #setProjectName(String)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_ProjectName()
	 * @model required="true"
	 * @generated
	 */
	String getProjectName();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#getProjectName <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Project Name</em>' attribute.
	 * @see #getProjectName()
	 * @generated
	 */
	void setProjectName(String value);

	/**
	 * Returns the value of the '<em><b>Project Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Description</em>' attribute isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Description</em>' attribute.
	 * @see #setProjectDescription(String)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_ProjectDescription()
	 * @model required="true"
	 * @generated
	 */
	String getProjectDescription();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#getProjectDescription <em>Project Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Project Description</em>' attribute.
	 * @see #getProjectDescription()
	 * @generated
	 */
	void setProjectDescription(String value);

	/**
	 * Returns the value of the '<em><b>Local Changes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Changes</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Changes</em>' containment reference.
	 * @see #setLocalChanges(ChangeDescription)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_LocalChanges()
	 * @model containment="true"
	 * @generated
	 */
	ChangeDescription getLocalChanges();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#getLocalChanges <em>Local Changes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Changes</em>' containment reference.
	 * @see #getLocalChanges()
	 * @generated
	 */
	void setLocalChanges(ChangeDescription value);

	/**
	 * Returns the value of the '<em><b>Usersession</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usersession</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usersession</em>' reference.
	 * @see #setUsersession(Usersession)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_Usersession()
	 * @model
	 * @generated
	 */
	Usersession getUsersession();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#getUsersession <em>Usersession</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usersession</em>' reference.
	 * @see #getUsersession()
	 * @generated
	 */
	void setUsersession(Usersession value);

	/**
	 * Returns the value of the '<em><b>Last Updated</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Updated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Last Updated</em>' attribute.
	 * @see #setLastUpdated(Date)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_LastUpdated()
	 * @model
	 * @generated
	 */
	Date getLastUpdated();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#getLastUpdated <em>Last Updated</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Last Updated</em>' attribute.
	 * @see #getLastUpdated()
	 * @generated
	 */
	void setLastUpdated(Date value);

	/**
	 * Returns the value of the '<em><b>Base Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Version</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Version</em>' containment reference.
	 * @see #setBaseVersion(PrimaryVersionSpec)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_BaseVersion()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PrimaryVersionSpec getBaseVersion();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#getBaseVersion <em>Base Version</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Version</em>' containment reference.
	 * @see #getBaseVersion()
	 * @generated
	 */
	void setBaseVersion(PrimaryVersionSpec value);

	/**
	 * <!-- begin-user-doc --> Commit the all pending changes of the project.
	 * 
	 * @return new base version
	 * @throws EmfStoreException
	 *             if commit fails <!-- end-user-doc -->
	 * @model
	 * @generated NOT
	 */
	PrimaryVersionSpec commit() throws EmfStoreException;

	/**
	 * <!-- begin-user-doc --> Update the project to the head version.
	 * 
	 * @throws EmfStoreException
	 *             if update fails <!-- end-user-doc -->
	 * 
	 * @model
	 * @generated NOT
	 */
	void update() throws EmfStoreException;

	/**
	 * <!-- begin-user-doc --> Update the project to the given version.
	 * 
	 * @param version
	 *            the version to update to
	 * @throws EmfStoreException
	 *             if update fails
	 * 
	 *             <!-- end-user-doc -->
	 * 
	 * @model
	 * @generated NOT
	 */
	void update(VersionSpec version) throws EmfStoreException;

	/**
	 * <!-- begin-user-doc --> Drop all changes to the local project. <!--
	 * end-user-doc -->
	 * @model
	 * @generated
	 */
	void revert();

	/**
	 * <!-- begin-user-doc --> Save the current state and changes. <!--
	 * end-user-doc -->
	 * @model
	 * @generated
	 */
	void save();

	/**
	 * <!-- begin-user-doc --> Initialize project space. Start change tracking.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void init();

	/**
	 * <!-- begin-user-doc --> Retrieve the project info. <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	ProjectInfo getProjectInfo();

	/**
	 * <!-- begin-user-doc -->
	 * Resolve a version spec to a primary version spec.
	 * @param versionSpec the spec to resolve
	 * @return the primary version spec
	 * <!-- end-user-doc -->
	 * @throws EmfStoreException if resolving fails
	 * @model
	 * @generated NOT
	 */
	PrimaryVersionSpec resolveVersionSpec(VersionSpec versionSpec)
			throws EmfStoreException;

	void shareProject(Usersession usersession) throws EmfStoreException;

	void exportProject(String fileName) throws IOException;

	boolean isDirty();
} // ProjectContainer
