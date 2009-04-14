/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.core.subinterfaces;

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
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.InvalidProjectIdException;
import org.unicase.emfstore.exceptions.StorageException;
import org.unicase.model.ModelFactory;
import org.unicase.model.Project;

/**
 * This subinterfaces implements all project related functionality for the {@link EmfStoreImpl} interface.
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
		for (ProjectHistory project : getServerSpace().getProjects()) {
			if (project.getProjectId().equals(projectId)) {
				return project;
			}
		}
		throw new InvalidProjectIdException("Project with the id:" + ((projectId == null) ? "null" : projectId)
			+ " doesn't exist.");
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized Project getProject(ProjectId projectId, VersionSpec versionSpec) throws EmfStoreException {
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
	 */
	public synchronized List<ProjectInfo> getProjectList(SessionId sessionId) {
		List<ProjectInfo> result = new ArrayList<ProjectInfo>();
		for (ProjectHistory project : getServerSpace().getProjects()) {
			// try {
			result.add(createProjectInfo(project));
			// } catch (AccessControlException e) {
			// // do nothing and continue
			// }
		}
		return result;
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
				getSubInterface(ResourceHelper.class).createResourceForProject(project, lastVersion.getPrimarySpec(),
					projectHistory.getProjectId());
				save(lastVersion);
			} catch (FatalEmfStoreException e) {
				throw new StorageException(StorageException.NOSAVE);
			}

			return createProjectInfo(projectHistory);
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
		Project project = ModelFactory.eINSTANCE.createProject();
		firstVersion.setProjectState(project);
		getSubInterface(ResourceHelper.class).createResourceForProject(project, firstVersion.getPrimarySpec(),
			projectHistory.getProjectId());
		projectHistory.getVersions().add(firstVersion);

		// add to serverspace and saved
		getSubInterface(ResourceHelper.class).createResourceForVersion(firstVersion, projectHistory.getProjectId());
		getSubInterface(ResourceHelper.class).createResourceForProjectHistory(projectHistory);
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
