/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.core.helper;

import java.io.File;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.StorageException;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;

/**
 * Helper for creating resources etc.
 * 
 * @author wesendon
 */
public class ResourceHelper {

	private final ServerSpace serverSpace;

	/**
	 * Default constructor.
	 * 
	 * @param serverSpace serverspace
	 * @throws FatalEmfStoreException in case of failure
	 */
	public ResourceHelper(ServerSpace serverSpace) throws FatalEmfStoreException {
		this.serverSpace = serverSpace;
	}

	/**
	 * Creates a resource for project history.
	 * 
	 * @param projectHistory project history
	 * @throws FatalEmfStoreException if saving fails
	 */
	public void createResourceForProjectHistory(ProjectHistory projectHistory) throws FatalEmfStoreException {
		String fileName = getProjectFolder(projectHistory.getProjectId()) + "projectHistory"
			+ ServerConfiguration.FILE_EXTENSION_PROJECTHISTORY;
		saveInResource(projectHistory, fileName);
	}

	/**
	 * Creates a resource for a new version.
	 * 
	 * @param version version
	 * @param projectId project id
	 * @throws FatalEmfStoreException if saving fails
	 */
	public void createResourceForVersion(Version version, ProjectId projectId) throws FatalEmfStoreException {
		String fileName = getProjectFolder(projectId) + ServerConfiguration.FILE_PREFIX_VERSION
			+ version.getPrimarySpec().getIdentifier() + ServerConfiguration.FILE_EXTENSION_VERSION;
		saveInResource(version, fileName);
	}

	/**
	 * Creates a resource for a new project.
	 * 
	 * @param project project
	 * @param projectId projectid
	 * @param versionId versionid
	 * @throws FatalEmfStoreException if saving fails
	 */
	public void createResourceForProject(Project project, PrimaryVersionSpec versionId, ProjectId projectId)
		throws FatalEmfStoreException {
		String filename = getProjectFolder(projectId) + getProjectFile(versionId.getIdentifier());
		// saveInResource(project, filename);
		saveInResourceWithProject(project, filename, project);
	}

	/**
	 * Creates a resource for a changepackage.
	 * 
	 * @param changePackage changepackage
	 * @param versionId versionId
	 * @param projectId projectId
	 * @throws FatalEmfStoreException if saving fails
	 */
	public void createResourceForChangePackage(ChangePackage changePackage, PrimaryVersionSpec versionId,
		ProjectId projectId) throws FatalEmfStoreException {
		String filename = getProjectFolder(projectId) + getChangePackageFile(versionId.getIdentifier());
		saveInResource(changePackage, filename);
	}

	/**
	 * Deletes a projectstate, depending on the policy, the file is deleted or renamed for backup reasons. Note: renamed
	 * for backup is deactivated since 20.09.2009.
	 * 
	 * @param projectId project id
	 * @param lastVersion the version
	 */
	public void deleteProjectState(ProjectId projectId, int lastVersion) {
		// int x = getXFromPolicy(ServerConfiguration.PROJECTSTATE_VERSION_BACKUP_PERSISTENCE_EVERYXVERSIONS_X,
		// ServerConfiguration.PROJECTSTATE_VERSION_BACKUP_PERSISTENCE_EVERYXVERSIONS_X_DEFAULT, true);

		// backup projectstate deactivated

		File file = new File(getProjectFolder(projectId) + getProjectFile(lastVersion));
		file.delete();

		// if (lastVersion != 0 && lastVersion % x != 0) {
		// file.delete();
		// } else {
		// file.renameTo(new File(getProjectFolder(projectId) + ServerConfiguration.FILE_PREFIX_BACKUPPROJECTSTATE
		// + getProjectFile(lastVersion)));
		// }
	}

	/**
	 * Gets and checks a number from a given server property. This number - referred as x - describes the size of an
	 * interval between projectstates. It's needed to determine whether a projectstate should be saved or be backuped.
	 * 
	 * @see ServerConfiguration#PROJECTSTATE_VERSION_BACKUP_PERSISTENCE_EVERYXVERSIONS_X
	 * @see ServerConfiguration#PROJECTSTATE_VERSION_PERSISTENCE_EVERYXVERSIONS_X
	 * @param policy policy name from server configuration
	 * @param defaultPolicy default policy name from server configuration
	 * @param allowZero allow zero for x
	 * @return x
	 */
	public int getXFromPolicy(String policy, String defaultPolicy, boolean allowZero) {
		int x;
		try {
			x = Integer.parseInt(ServerConfiguration.getProperties().getProperty(policy, defaultPolicy));
		} catch (NumberFormatException e) {
			x = 1;
			ModelUtil.logWarning("Couldn't read property: " + policy + " , x set to 1", e);
		}
		if (x < 0) {
			x = 1;
			ModelUtil.logWarning("Policy " + policy + " with x < 0 not possible, x set to 1.");
		}
		if (!allowZero && x == 0) {
			x = 1;
			ModelUtil.logWarning("Policy " + policy + " with x = 0 not possible, x set to 1.");
		}
		return x;
	}

	/**
	 * Returns the file path to a given project.
	 * 
	 * @param projectId the project id
	 * @return file path
	 */
	public String getProjectFolder(ProjectId projectId) {
		return ServerConfiguration.getServerHome() + ServerConfiguration.FILE_PREFIX_PROJECTFOLDER + projectId.getId()
			+ File.separatorChar;
	}

	private String getProjectFile(int versionNumber) {
		return ServerConfiguration.FILE_PREFIX_PROJECTSTATE + versionNumber
			+ ServerConfiguration.FILE_EXTENSION_PROJECTSTATE;
	}

	private String getChangePackageFile(int versionNumber) {
		return ServerConfiguration.FILE_PREFIX_CHANGEPACKAGE + versionNumber
			+ ServerConfiguration.FILE_EXTENSION_CHANGEPACKAGE;
	}

	private void saveInResource(EObject obj, String fileName) throws FatalEmfStoreException {
		Resource resource = serverSpace.eResource().getResourceSet().createResource(URI.createFileURI(fileName));
		resource.getContents().add(obj);
		save(obj);
	}

	private void saveInResourceWithProject(EObject obj, String fileName, Project project) throws FatalEmfStoreException {
		Resource resource = serverSpace.eResource().getResourceSet().createResource(URI.createFileURI(fileName));
		resource.getContents().add(obj);

		if (resource instanceof XMIResource) {
			XMIResource xmiResource = (XMIResource) resource;
			for (Map.Entry<EObject, ModelElementId> e : project.getEobjectsIdMap()) {
				xmiResource.setID(e.getKey(), e.getValue().getId());
			}
		}

		save(obj);
	}

	/**
	 * Saves an eObject.
	 * 
	 * @param object the object
	 * @throws FatalEmfStoreException in case of failure
	 */
	public void save(EObject object) throws FatalEmfStoreException {
		try {
			object.eResource().save(null);
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (Exception e) {
			throw new FatalEmfStoreException(StorageException.NOSAVE, e);
		}
		// END SUPRESS CATCH EXCEPTION
	}

	/**
	 * Saves all modified resources in the serverspace's resource set.
	 * 
	 * @throws FatalEmfStoreException in case of failure
	 */
	public void saveAll() throws FatalEmfStoreException {
		for (Resource res : serverSpace.eResource().getResourceSet().getResources()) {
			if (res.isLoaded() && res.isModified()) {
				try {
					res.save(null);
					// BEGIN SUPRESS CATCH EXCEPTION
				} catch (Exception e) {
					throw new FatalEmfStoreException(StorageException.NOSAVE, e);
				}
				// END SUPRESS CATCH EXCEPTION
			}
		}

	}
}
