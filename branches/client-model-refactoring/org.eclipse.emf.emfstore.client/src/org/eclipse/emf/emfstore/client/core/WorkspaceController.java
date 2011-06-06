package org.eclipse.emf.emfstore.client.core;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.emfstore.client.ProjectSpace;
import org.eclipse.emf.emfstore.client.exceptions.ProjectUrlResolutionException;
import org.eclipse.emf.emfstore.client.exceptions.ServerUrlResolutionException;
import org.eclipse.emf.emfstore.client.exceptions.UnkownProjectException;
import org.eclipse.emf.emfstore.client.model.ProjectSpaceData;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.url.ProjectUrlFragment;
import org.eclipse.emf.emfstore.server.model.url.ServerUrl;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;

public interface WorkspaceController {

	List<ProjectSpace> getProjectSpaces();

	ProjectSpace getActiveProjectSpace();

	void setActiveProjectSpace(ProjectSpace newActiveProjectSpace);

	/**
	 * Get the project space for the given project.
	 * 
	 * @param project
	 *            the project
	 * @return the project space the project is stored in
	 * @throws UnkownProjectException
	 *             if the project is not known to the workspace
	 */
	ProjectSpace getProjectSpace(Project project) throws UnkownProjectException;

	/**
	 * Checkout a project to the workspace in the current head revision.
	 * 
	 * @param usersession
	 *            the usersession
	 * @param projectInfo
	 *            the project info describing the project and version
	 * @throws EmfStoreException
	 *             if checkout fails
	 * @return the project space containing the project
	 */
	ProjectSpace checkout(Usersession usersession, ProjectInfo projectInfo)
			throws EmfStoreException;

	/**
	 * Checkout a project to the workspace in a given version.
	 * 
	 * @param usersession
	 *            the usersession
	 * @param projectInfo
	 *            the project info describing the project and version
	 * @param targetSpec
	 *            the target version
	 * @throws EmfStoreException
	 *             if checkout fails
	 * @return the project space containing the project
	 * @model
	 * @generated NOT
	 */
	ProjectSpaceInternal checkout(Usersession usersession,
			ProjectInfo projectInfo, PrimaryVersionSpec targetSpec)
			throws EmfStoreException;

	/**
	 * Import a project from file.
	 * 
	 * @param absoluteFileName
	 *            the file name to import from
	 * @return a project space containing the imported project
	 * @throws IOException
	 *             if file access fails
	 */
	ProjectSpace importProject(String absoluteFileName) throws IOException;

	/**
	 * Imports a project into a projectSpace.
	 * 
	 * @param project
	 *            project
	 * @param name
	 *            name
	 * @param description
	 *            description
	 * @return projectspace
	 */
	ProjectSpace importProject(Project project, String name, String description);

	/**
	 * Export a project to a file.
	 * 
	 * @param projectSpace
	 *            the projectSpace containing the project
	 * @param absoluteFileName
	 *            the file name
	 * @throws IOException
	 *             if file access fails
	 */
	void exportProject(ProjectSpaceData projectSpace, String absoluteFileName)
			throws IOException;

	/**
	 * Export a project space to a file.
	 * 
	 * @param projectSpace
	 *            the project space
	 * @param absoluteFileName
	 *            the file name
	 * @throws IOException
	 *             if file access fails
	 */
	void exportProjectSpace(ProjectSpaceData projectSpace,
			String absoluteFileName) throws IOException;

	/**
	 * Export the current workspace to a file.
	 * 
	 * @param absoluteFileName
	 *            the file name
	 * @throws IOException
	 *             if file access fails
	 */
	void exportWorkSpace(String absoluteFileName) throws IOException;

	/**
	 * Import a project space from file.
	 * 
	 * @param absoluteFileName
	 *            the file name to import from
	 * @return the project space
	 * @throws IOException
	 *             if file access fails
	 */
	ProjectSpace importProjectSpace(String absoluteFileName) throws IOException;

	/**
	 * Creates a new local project that is not shared with the server yet.
	 * 
	 * @param projectName
	 *            the project name
	 * @param projectDescription
	 *            the project description
	 * @return the project space that the new project resides in
	 */
	ProjectSpace createLocalProject(String projectName,
			String projectDescription);

	/**
	 * Resolves a project url fragment to the project space the project is in.
	 * Since a project may have been checked out multiple times, a set of
	 * project spaces is returned.
	 * 
	 * @param projectUrlFragment
	 *            the project url fragment to resolve
	 * @return a set of matching project spaces
	 * @throws ProjectUrlResolutionException
	 *             if project cannot be found in workspace
	 */
	Set<ProjectSpace> resolve(ProjectUrlFragment projectUrlFragment)
			throws ProjectUrlResolutionException;

	/**
	 * Resolves a server url to a set server infos if multiple serverInfos match
	 * the url.
	 * 
	 * @param serverUrl
	 *            the server url
	 * @return the server info
	 * @throws ServerUrlResolutionException
	 *             if no matching server info can be found
	 */
	Set<ServerInfo> resolve(ServerUrl serverUrl)
			throws ServerUrlResolutionException;

	/**
	 * Delete the given project space.
	 * 
	 * @param projectSpace
	 *            the project space
	 * @throws IOException
	 *             if deleting the obsolete project space files fails
	 */
	void deleteProjectSpace(ProjectSpace projectSpace) throws IOException;

	/**
	 * Make the current workspace state persistent.
	 */
	void save();

}
