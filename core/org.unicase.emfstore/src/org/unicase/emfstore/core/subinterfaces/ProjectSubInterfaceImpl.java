/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.core.subinterfaces;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.core.AbstractEmfstoreInterface;
import org.unicase.emfstore.core.AbstractSubEmfstoreInterface;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.InvalidProjectIdException;
import org.unicase.emfstore.exceptions.StorageException;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.FileUtil;

/**
 * This subinterfaces implements all project related functionality for the
 * {@link org.unicase.emfstore.core.EmfStoreImpl} interface.
 * 
 * @author wesendon
 */
public class ProjectSubInterfaceImpl extends AbstractSubEmfstoreInterface {

	/**
	 * Default constructor.
	 * 
	 * @param parentInterface parent interface
	 * @throws FatalEmfStoreException in case of failure
	 */
	public ProjectSubInterfaceImpl(AbstractEmfstoreInterface parentInterface) throws FatalEmfStoreException {
		super(parentInterface);
	}

	/**
	 * Returns the corresponding project.
	 * 
	 * @param projectId project id
	 * @return a project or throws exception
	 * @throws EmfStoreException if project couldn't be found
	 */
	protected ProjectHistory getProject(ProjectId projectId) throws EmfStoreException {
		ProjectHistory projectHistory = getProjectOrNull(projectId);
		if (projectHistory != null) {
			return projectHistory;
		}
		throw new InvalidProjectIdException("Project with the id:" + ((projectId == null) ? "null" : projectId)
			+ " doesn't exist.");
	}

	private ProjectHistory getProjectOrNull(ProjectId projectId) {
		for (ProjectHistory project : getServerSpace().getProjects()) {
			if (project.getProjectId().equals(projectId)) {
				return project;
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Project getProject(ProjectId projectId, VersionSpec versionSpec) throws EmfStoreException {
		synchronized (getMonitor()) {
			PrimaryVersionSpec resolvedVersion = getSubInterface(VersionSubInterfaceImpl.class).resolveVersionSpec(
				projectId, versionSpec);
			Version version = getSubInterface(VersionSubInterfaceImpl.class).getVersion(projectId, resolvedVersion);
			if (version.getProjectState() == null) {
				while (version.getProjectState() == null && version.getPreviousVersion() != null) {
					version = version.getPreviousVersion();
				}
				if (version.getProjectState() == null) {
					// TODO: nicer exception.
					// is this null check necessary anyway? (there were problems in past, because
					// the xml files were inconsistent.
					throw new EmfStoreException("Couldn't find project state.");
				}
				Project projectState = (Project) EcoreUtil.copy(version.getProjectState());
				for (Version next = version.getNextVersion(); next != null
					&& next.getPrimarySpec().compareTo(resolvedVersion) < 1; next = next.getNextVersion()) {
					next.getChanges().apply(projectState);
				}
				return projectState;
			} else {
				return version.getProjectState();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws EmfStoreException
	 * @throws AccessControlException
	 */
	public List<ProjectInfo> getProjectList(SessionId sessionId) throws EmfStoreException {
		synchronized (getMonitor()) {
			List<ProjectInfo> result = new ArrayList<ProjectInfo>();
			for (ProjectHistory projectHistory : getServerSpace().getProjects()) {
				try {
					getAuthorizationControl().checkReadAccess(sessionId, projectHistory.getProjectId(), null);
					result.add(createProjectInfo(projectHistory));
				} catch (AccessControlException e) {
					// if this exception occurs, project won't be added to list
				}
			}
			return result;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectInfo createProject(String name, String description, LogMessage logMessage) throws EmfStoreException {
		synchronized (getMonitor()) {
			ProjectHistory projectHistory = null;
			try {
				logMessage.setDate(new Date());
				projectHistory = createEmptyProject(name, description, logMessage);
			} catch (FatalEmfStoreException e) {
				throw new StorageException(StorageException.NOSAVE);
			}
			return createProjectInfo(projectHistory);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectInfo createProject(String name, String description, LogMessage logMessage, Project project)
		throws EmfStoreException {
		synchronized (getMonitor()) {
			ProjectHistory projectHistory = null;
			try {
				logMessage.setDate(new Date());
				projectHistory = createEmptyProject(name, description, logMessage);
				Version lastVersion = projectHistory.getLastVersion();
				lastVersion.setProjectState(project);
				getResourceHelper().createResourceForProject(project, lastVersion.getPrimarySpec(),
					projectHistory.getProjectId());
				// TODO: check if this is OK
				saveWithProject(lastVersion, lastVersion.getProjectState());
			} catch (FatalEmfStoreException e) {
				throw new StorageException(StorageException.NOSAVE);
			}

			return createProjectInfo(projectHistory);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteProject(ProjectId projectId, boolean deleteFiles) throws EmfStoreException {
		deleteProject2(projectId, deleteFiles, true);
	}

	/**
	 * Implemenation of {@link #deleteProject(ProjectId, boolean)} with additional possibility of not throwing an
	 * invalid id exception.
	 * 
	 * @param projectId project id
	 * @param deleteFiles boolean, whether to delete files in file system
	 * @param throwInvalidIdException boolean
	 * @throws EmfStoreException in case of failure
	 */
	protected void deleteProject2(ProjectId projectId, boolean deleteFiles, boolean throwInvalidIdException)
		throws EmfStoreException {
		synchronized (getMonitor()) {
			try {
				try {
					ProjectHistory project = getProject(projectId);
					getServerSpace().getProjects().remove(project);
					save(getServerSpace());
				} catch (InvalidProjectIdException e) {
					if (throwInvalidIdException) {
						throw e;
					}
				}
				if (deleteFiles) {
					File projectFolder = new File(getResourceHelper().getProjectFolder(projectId));
					try {
						FileUtil.deleteFolder(projectFolder);
					} catch (IOException e) {
						throw new StorageException(
							"Project files couldn't be deleted, but it was deleted from containment tree.", e);
					}
				}
			} catch (FatalEmfStoreException e) {
				throw new StorageException(StorageException.NOSAVE);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectId importProjectHistoryToServer(ProjectHistory projectHistory) throws EmfStoreException {
		synchronized (getMonitor()) {
			ProjectHistory projectOrNull = getProjectOrNull(projectHistory.getProjectId());
			if (projectOrNull != null) {
				// if project with same id exists, create a new id.
				projectHistory.setProjectId(EsmodelFactory.eINSTANCE.createProjectId());
			}
			try {
				getResourceHelper().createResourceForProjectHistory(projectHistory);
				getServerSpace().getProjects().add(projectHistory);
				getResourceHelper().save(getServerSpace());
				for (Version version : projectHistory.getVersions()) {
					if (version.getChanges() != null) {
						getResourceHelper().createResourceForChangePackage(version.getChanges(),
							version.getPrimarySpec(), projectHistory.getProjectId());
					}
					if (version.getProjectState() != null) {
						getResourceHelper().createResourceForProject(version.getProjectState(),
							version.getPrimarySpec(), projectHistory.getProjectId());
					}
					getResourceHelper().createResourceForVersion(version, projectHistory.getProjectId());
				}
				getResourceHelper().save(projectHistory);
				getResourceHelper().saveAll();
			} catch (FatalEmfStoreException e) {
				// roll back
				deleteProject2(projectHistory.getProjectId(), true, false);
				throw new StorageException(StorageException.NOSAVE);
			}
			return (ProjectId) EcoreUtil.copy(projectHistory.getProjectId());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectHistory exportProjectHistoryFromServer(ProjectId projectId) throws EmfStoreException {
		synchronized (getMonitor()) {
			return (ProjectHistory) EcoreUtil.copy(getProject(projectId));
		}
	}

	private ProjectHistory createEmptyProject(String name, String description, LogMessage logMessage)
		throws FatalEmfStoreException {

		// create initial ProjectHistory
		ProjectHistory projectHistory = EsmodelFactory.eINSTANCE.createProjectHistory();
		projectHistory.setProjectName(name);
		projectHistory.setProjectDescription(description);
		projectHistory.setProjectId(EsmodelFactory.eINSTANCE.createProjectId());

		// create a initial version without previous and change package
		Version firstVersion = VersioningFactory.eINSTANCE.createVersion();
		firstVersion.setLogMessage(logMessage);
		PrimaryVersionSpec primary = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		primary.setIdentifier(0);
		firstVersion.setPrimarySpec(primary);

		// create initial project
		Project project = MetamodelFactory.eINSTANCE.createProject();
		firstVersion.setProjectState(project);
		getResourceHelper().createResourceForProject(project, firstVersion.getPrimarySpec(),
			projectHistory.getProjectId());
		projectHistory.getVersions().add(firstVersion);

		// add to serverspace and saved
		getResourceHelper().createResourceForVersion(firstVersion, projectHistory.getProjectId());
		getResourceHelper().createResourceForProjectHistory(projectHistory);
		getServerSpace().getProjects().add(projectHistory);
		save(getServerSpace());
		return projectHistory;
	}

	private ProjectInfo createProjectInfo(ProjectHistory project) {
		ProjectInfo info = EsmodelFactory.eINSTANCE.createProjectInfo();
		info.setName(project.getProjectName());
		info.setDescription(project.getProjectDescription());
		info.setProjectId((ProjectId) EcoreUtil.copy(project.getProjectId()));
		info.setVersion((PrimaryVersionSpec) EcoreUtil.copy(project.getLastVersion().getPrimarySpec()));
		return info;
	}
}
