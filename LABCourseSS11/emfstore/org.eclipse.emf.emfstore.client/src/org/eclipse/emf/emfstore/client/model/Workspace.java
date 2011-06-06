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
package org.eclipse.emf.emfstore.client.model;

import java.io.IOException;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.emfstore.client.model.connectionmanager.ConnectionManager;
import org.eclipse.emf.emfstore.client.model.exceptions.ProjectUrlResolutionException;
import org.eclipse.emf.emfstore.client.model.exceptions.ServerUrlResolutionException;
import org.eclipse.emf.emfstore.client.model.exceptions.UnkownProjectException;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.url.ProjectUrlFragment;
import org.eclipse.emf.emfstore.server.model.url.ServerUrl;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Workspace</b></em>'.
 * 
 * @implements IAdaptable <!-- end-user-doc -->
 * 
 *             <p>
 *             The following features are supported:
 *             <ul>
 *             <li>{@link org.eclipse.emf.emfstore.client.model.Workspace#getProjectSpaces <em>Project Spaces</em>}</li>
 *             <li>{@link org.eclipse.emf.emfstore.client.model.Workspace#getServerInfos <em>Server Infos</em>}</li>
 *             <li>{@link org.eclipse.emf.emfstore.client.model.Workspace#getUsersessions <em>Usersessions</em>}</li>
 *             <li>{@link org.eclipse.emf.emfstore.client.model.Workspace#getActiveProjectSpace <em>Active Project Space
 *             </em>}</li>
 *             </ul>
 *             </p>
 * 
 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getWorkspace()
 * @model
 * @generated
 */
public interface Workspace extends EObject, IAdaptable {
	/**
	 * Returns the value of the '<em><b>Project Spaces</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.client.model.ProjectSpace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Spaces</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Project Spaces</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getWorkspace_ProjectSpaces()
	 * @model containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<ProjectSpace> getProjectSpaces();

	/**
	 * Returns the value of the '<em><b>Server Infos</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.client.model.ServerInfo}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Infos</em>' containment reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Server Infos</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getWorkspace_ServerInfos()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ServerInfo> getServerInfos();

	/**
	 * Returns the value of the '<em><b>Usersessions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.client.model.Usersession}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usersessions</em>' containment reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Usersessions</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getWorkspace_Usersessions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Usersession> getUsersessions();

	/**
	 * Returns the value of the '<em><b>Active Project Space</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Project Space</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Active Project Space</em>' reference.
	 * @see #setActiveProjectSpace(ProjectSpace)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getWorkspace_ActiveProjectSpace()
	 * @model keys="identifier"
	 * @generated
	 */
	ProjectSpace getActiveProjectSpace();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.Workspace#getActiveProjectSpace
	 * <em>Active Project Space</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Active Project Space</em>' reference.
	 * @see #getActiveProjectSpace()
	 * @generated
	 */
	void setActiveProjectSpace(ProjectSpace value);

	/**
	 * Checkout a project to the workspace in the current head revision.
	 * 
	 * @param usersession the usersession
	 * @param projectInfo the project info describing the project and version
	 * @throws EmfStoreException if checkout fails
	 * @return the project space containing the project
	 * @model
	 * @generated NOT
	 */
	ProjectSpace checkout(Usersession usersession, ProjectInfo projectInfo) throws EmfStoreException;

	/**
	 * Set the workspace connection manager.
	 * 
	 * @param connectionManager the connection manager
	 * @generated NOT
	 */
	void setConnectionManager(ConnectionManager connectionManager);

	/**
	 * Set the workspace resource set.
	 * 
	 * @param resourceSet the resource set
	 * @generated NOT
	 */
	void setWorkspaceResourceSet(ResourceSet resourceSet);

	/**
	 * Init the workspace and its projectspaces.
	 * 
	 * @generated NOT
	 */
	void init();

	/**
	 * Return this workspace?s transactional editing domain.
	 * 
	 * @return the editing domain
	 * @generated NOT
	 */
	EditingDomain getEditingDomain();

	/**
	 * Import a project from file.
	 * 
	 * @param absoluteFileName the file name to import from
	 * @return a project space containing the imported project
	 * @throws IOException if file access fails
	 */
	ProjectSpace importProject(String absoluteFileName) throws IOException;

	/**
	 * Imports a project into a projectSpace.
	 * 
	 * @param project project
	 * @param name name
	 * @param description description
	 * @return projectspace
	 */
	ProjectSpace importProject(Project project, String name, String description);

	/**
	 * Export a project to a file.
	 * 
	 * @param projectSpace the projectSpace containing the project
	 * @param absoluteFileName the file name
	 * @throws IOException if file access fails
	 */
	void exportProject(ProjectSpace projectSpace, String absoluteFileName) throws IOException;

	/**
	 * Export a project space to a file.
	 * 
	 * @param projectSpace the project space
	 * @param absoluteFileName the file name
	 * @throws IOException if file access fails
	 */
	void exportProjectSpace(ProjectSpace projectSpace, String absoluteFileName) throws IOException;

	/**
	 * Export the current workspace to a file.
	 * 
	 * @param absoluteFileName the file name
	 * @throws IOException if file access fails
	 */
	void exportWorkSpace(String absoluteFileName) throws IOException;

	/**
	 * Import a project space from file.
	 * 
	 * @param absoluteFileName the file name to import from
	 * @return the project space
	 * @throws IOException if file access fails
	 */
	ProjectSpace importProjectSpace(String absoluteFileName) throws IOException;

	/**
	 * Make the current workspace state persistent.
	 */
	void save();

	/**
	 * Resolves a project url fragment to the project space the project is in. Since a project may have been checked out
	 * multiple times, a set of project spaces is returned.
	 * 
	 * @param projectUrlFragment the project url fragment to resolve
	 * @return a set of matching project spaces
	 * @throws ProjectUrlResolutionException if project cannot be found in workspace
	 */
	Set<ProjectSpace> resolve(ProjectUrlFragment projectUrlFragment) throws ProjectUrlResolutionException;

	/**
	 * Resolves a server url to a set server infos if multiple serverInfos match the url.
	 * 
	 * @param serverUrl the server url
	 * @return the server info
	 * @throws ServerUrlResolutionException if no matching server info can be found
	 */
	Set<ServerInfo> resolve(ServerUrl serverUrl) throws ServerUrlResolutionException;

	/**
	 * Checkout a project to the workspace in a given version.
	 * 
	 * @param usersession the usersession
	 * @param projectInfo the project info describing the project and version
	 * @param targetSpec the target version
	 * @throws EmfStoreException if checkout fails
	 * @return the project space containing the project
	 * @model
	 * @generated NOT
	 */
	ProjectSpace checkout(Usersession usersession, ProjectInfo projectInfo, PrimaryVersionSpec targetSpec)
		throws EmfStoreException;

	/**
	 * Get the project space for the given project.
	 * 
	 * @param project the project
	 * @return the project space the project is stored in
	 * @throws UnkownProjectException if the project is not known to the workspace
	 */
	ProjectSpace getProjectSpace(Project project) throws UnkownProjectException;

	/**
	 * Delete the given project space.
	 * 
	 * @param projectSpace the project space
	 * @throws IOException if deleting the obsolete project space files fails
	 */
	void deleteProjectSpace(ProjectSpace projectSpace) throws IOException;

	/**
	 * Creates a new local project that is not shared with the server yet.
	 * 
	 * @param projectName the project name
	 * @param projectDescription the project description
	 * @return the project space that the new project resides in
	 */
	ProjectSpace createLocalProject(String projectName, String projectDescription);

} // Workspace
