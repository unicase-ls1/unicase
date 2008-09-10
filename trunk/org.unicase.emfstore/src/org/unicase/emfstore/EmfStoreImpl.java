/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.emfstore.accesscontrol.AuthorizationControl;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HeadVersionSpec;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.InvalidProjectIdException;
import org.unicase.emfstore.exceptions.InvalidVersionSpecException;
import org.unicase.emfstore.exceptions.StorageException;
import org.unicase.model.ModelFactory;
import org.unicase.model.Project;

/**
 * EmfStoreImpl is a server side implementation of {@link EmfStore}.
 * 
 * @author Wesendonk
 */
public class EmfStoreImpl implements EmfStore {

	private ServerSpace serverSpace;

	private static final Log LOGGER = LogFactory.getLog(EmfStoreImpl.class);

	private AuthorizationControl authorizationControl;

	/**
	 * Default constructor.
	 * 
	 * @param serverSpace
	 *            the serverspace
	 * @param authorizationControl
	 *            the accesscontroller
	 * @param properties
	 *            server properties
	 */
	public EmfStoreImpl(ServerSpace serverSpace,
			AuthorizationControl authorizationControl, Properties properties) {
		this.serverSpace = serverSpace;
		this.authorizationControl = authorizationControl;
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized PrimaryVersionSpec createVersion(SessionId sessionId,
			ProjectId projectId, PrimaryVersionSpec baseVersionSpec,
			ChangePackage changePackage, LogMessage logMessage)
			throws EmfStoreException {
		// TODO: authorization
		authorizationControl.checkWriteAccess(sessionId, projectId, null);
		long currentTimeMillis = System.currentTimeMillis();
		ProjectHistory projectHistory = getProject(projectId);
		List<Version> versions = projectHistory.getVersions();
		if (versions.size() - 1 != baseVersionSpec.getIdentifier()) {
			throw new InvalidVersionSpecException("");
		}

		PrimaryVersionSpec newVersionSpec = VersioningFactory.eINSTANCE
				.createPrimaryVersionSpec();
		newVersionSpec.setIdentifier(baseVersionSpec.getIdentifier() + 1);

		Version version = VersioningFactory.eINSTANCE.createVersion();

		Version previousHeadVersion = versions.get(versions.size() - 1);

		// MK: removed state copy for performance
		// Project newProjectState =
		// (Project)EcoreUtil.copy(previousHeadVersion.getProjectState());
		Project newProjectState = previousHeadVersion.getProjectState();

		changePackage.apply(newProjectState);

		version.setProjectState(newProjectState);

		version.setChanges(changePackage);
		logMessage.setDate(new Date());
		version.setLogMessage(logMessage);
		version.setPrimarySpec(newVersionSpec);
		version.setNextVersion(null);
		version.setPreviousVersion(previousHeadVersion);

		versions.add(version);
		createResourceForVersion(version, projectHistory.getProjectId());
		// if projectstate of the previous head version is set to null saving is
		// required
		save(previousHeadVersion);
		save(projectHistory);
		LOGGER.error("Total time for commit: "
				+ (System.currentTimeMillis() - currentTimeMillis));
		return newVersionSpec;
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized List<ChangePackage> getChanges(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws EmfStoreException {
		// TODO: authorization
		authorizationControl.checkReadAccess(sessionId, projectId, null);

		PrimaryVersionSpec resolvedSource = resolveVersionSpec(projectId,
				source);
		PrimaryVersionSpec resolvedTarget = resolveVersionSpec(projectId,
				target);
		List<ChangePackage> result = new ArrayList<ChangePackage>();

		resolvedSource.setIdentifier(resolvedSource.getIdentifier() + 1);

		for (Version version : getVersions(projectId, resolvedSource,
				resolvedTarget)) {
			ChangePackage changes = version.getChanges();
			result.add(changes);
		}

		// if source is after target in time
		if (resolvedSource.compareTo(resolvedTarget) > 0) {
			// reverse list and change packages
			List<ChangePackage> cps = result;
			result = new ArrayList<ChangePackage>();
			for (ChangePackage cp : cps) {
				result.add(0, cp.reverse());
			}
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized List<HistoryInfo> getHistoryInfo(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws EmfStoreException {
		// TODO: authorization
		authorizationControl.checkReadAccess(sessionId, projectId, null);
		List<HistoryInfo> result = new ArrayList<HistoryInfo>();
		for (Version version : getVersions(projectId, resolveVersionSpec(
				projectId, source), resolveVersionSpec(projectId, target))) {
			HistoryInfo history = VersioningFactory.eINSTANCE
					.createHistoryInfo();
			history.setLogMessage(version.getLogMessage());
			history.setPrimerySpec(version.getPrimarySpec());
			result.add(history);
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized Project getProject(SessionId sessionId,
			ProjectId projectId, VersionSpec versionSpec)
			throws EmfStoreException {
		// TODO: authorization
		authorizationControl.checkReadAccess(sessionId, projectId, null);
		// MK: TODO recalulate project state if not available
		// copy projectstate of nearest version
		// then apply changepackages to get to state (maybe reverse)
		return getVersion(projectId, resolveVersionSpec(projectId, versionSpec))
				.getProjectState();
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized List<ProjectInfo> getProjectList(SessionId sessionId)
			throws EmfStoreException {
		// TODO: authorization
		// authorizationControl.checkReadAccess(sessionId, null, null);
		List<ProjectInfo> result = new ArrayList<ProjectInfo>();
		for (ProjectHistory project : getServerSpace().getProjects()) {
			try {
				authorizationControl.checkReadAccess(sessionId, project
						.getProjectId(), null);
				result.add(getProjectInfo(project));
			} catch (AccessControlException e) {
				// do nothing continue
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized PrimaryVersionSpec resolveVersionSpec(
			SessionId sessionId, ProjectId projectId, VersionSpec versionSpec)
			throws EmfStoreException {
		// TODO: authorization
		authorizationControl.checkReadAccess(sessionId, projectId, null);
		return resolveVersionSpec(projectId, versionSpec);
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized ACUser resolveUser(SessionId sessionId,
			ACOrgUnitId id) throws EmfStoreException {
		ACUser requestingUser = authorizationControl.resolveUser(sessionId);
		if(id==null) {
			return requestingUser;
		}
		ACUser user = authorizationControl.resolveUser(id);
		if(requestingUser.getId().equals(user.getId())) {
			return user;
		}
		authorizationControl.checkServerAdminAccess(sessionId);
		return user;
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized ProjectInfo createProject(SessionId sessionId,
			String name, String description, LogMessage logMessage)
			throws EmfStoreException {
		authorizationControl.checkServerAdminAccess(sessionId);
		ProjectHistory projectHistory = createEmptyProject(name, description,
				logMessage);
		save();
		return getProjectInfo(projectHistory);
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized ProjectInfo createProject(SessionId sessionId,
			String name, String description, LogMessage logMessage,
			Project project) throws EmfStoreException {
		authorizationControl.checkServerAdminAccess(sessionId);
		ProjectHistory projectHistory = createEmptyProject(name, description,
				logMessage);
		projectHistory.getLastVersion().setProjectState(project);
		save();
		return getProjectInfo(projectHistory);
	}

	/**
	 * @param name
	 * @param description
	 * @param logMessage
	 * @return
	 * @throws EmfStoreException
	 */
	private ProjectHistory createEmptyProject(String name, String description,
			LogMessage logMessage) throws EmfStoreException {
		// TODO: authorization
		// create initial ProjectHistory
		ProjectHistory projectHistory = EsmodelFactory.eINSTANCE
				.createProjectHistory();
		projectHistory.setProjectName(name);
		projectHistory.setProjectDescription(description);
		projectHistory.setProjectId(EsmodelFactory.eINSTANCE.createProjectId());
		// create a initial version without previous and change package
		Version firstVersion = VersioningFactory.eINSTANCE.createVersion();
		firstVersion.setLogMessage(logMessage);
		PrimaryVersionSpec primary = VersioningFactory.eINSTANCE
				.createPrimaryVersionSpec();
		primary.setIdentifier(0);
		firstVersion.setPrimarySpec(primary);
		// create initial project
		firstVersion.setProjectState(ModelFactory.eINSTANCE.createProject());
		projectHistory.getVersions().add(firstVersion);
		// add to serverspace and saved
		createResourceForVersion(firstVersion, projectHistory.getProjectId());
		createResourceForProjectHistory(projectHistory);
		getServerSpace().getProjects().add(projectHistory);
		return projectHistory;
	}

	private void createResourceForProjectHistory(ProjectHistory projectHistory)
			throws EmfStoreException {
		String fileName = ServerConfiguration.getServerHome() + "project-"
				+ projectHistory.getProjectId().getId() + "/projectHistory";
		Resource resource = getServerSpace().eResource().getResourceSet()
				.createResource(URI.createFileURI(fileName));
		resource.getContents().add(projectHistory);
		save(projectHistory);
	}

	private void createResourceForVersion(Version version, ProjectId projectId)
			throws EmfStoreException {
		String fileName = ServerConfiguration.getServerHome() + "project-"
				+ projectId.getId() + "/version-"
				+ version.getPrimarySpec().getIdentifier();
		Resource resource = getServerSpace().eResource().getResourceSet()
				.createResource(URI.createFileURI(fileName));
		resource.getContents().add(version);
		save(version);
	}

	private ServerSpace getServerSpace() {
		return serverSpace;
	}

	private ProjectHistory getProject(ProjectId projectId)
			throws EmfStoreException {
		for (ProjectHistory project : serverSpace.getProjects()) {
			if (project.getProjectId().equals(projectId)) {
				return project;
			}
		}
		throw new InvalidProjectIdException("Project with the id:"
				+ ((projectId == null) ? "null" : projectId)
				+ " doesn't exist.");
	}

	private ProjectInfo getProjectInfo(ProjectHistory project) {
		ProjectInfo info = EsmodelFactory.eINSTANCE.createProjectInfo();
		info.setName(project.getProjectName());
		info.setDescription(project.getProjectDescription());
		info.setProjectId(project.getProjectId());
		info.setVersion(project.getLastVersion().getPrimarySpec());
		return info;
	}

	private PrimaryVersionSpec resolveVersionSpec(ProjectId projectId,
			VersionSpec versionSpec) throws EmfStoreException {
		ProjectHistory projectHistory = getProject(projectId);
		// PrimaryVersionSpec
		if (versionSpec instanceof PrimaryVersionSpec
				&& 0 <= ((PrimaryVersionSpec) versionSpec).getIdentifier()
				&& ((PrimaryVersionSpec) versionSpec).getIdentifier() < projectHistory
						.getVersions().size()) {
			return ((PrimaryVersionSpec) versionSpec);
			// HeadVersionSpec
		} else if (versionSpec instanceof HeadVersionSpec) {
			return (PrimaryVersionSpec) EcoreUtil.copy(getProject(projectId)
					.getLastVersion().getPrimarySpec());
		} else {
			// FIXME OW MK: Tag- and DateVersionSpec
			throw new InvalidVersionSpecException("");
		}
	}

	private Version getVersion(ProjectId projectId,
			PrimaryVersionSpec versionSpec) throws EmfStoreException {
		return getProject(projectId).getVersions().get(
				versionSpec.getIdentifier());
	}

	private List<Version> getVersions(ProjectId projectId,
			PrimaryVersionSpec source, PrimaryVersionSpec target)
			throws EmfStoreException {
		if (source.compareTo(target) < 1) {
			EList<Version> versions = getProject(projectId).getVersions();
			List<Version> result = new ArrayList<Version>();
			Iterator<Version> iter = versions.listIterator(source
					.getIdentifier());
			int steps = target.getIdentifier() - source.getIdentifier();
			while (iter.hasNext() && steps-- >= 0) {
				result.add(iter.next());
			}
			return result;
		} else {
			return getVersions(projectId, target, source);
		}
	}

	public void save() throws EmfStoreException {
		try {
			long currentTimeMillis = System.currentTimeMillis();
			getServerSpace().save();
			LOGGER.error("Total time for saving: "
					+ (System.currentTimeMillis() - currentTimeMillis));
			currentTimeMillis = System.currentTimeMillis();
		} catch (IOException e) {
			throw new StorageException(StorageException.NOSAVE, e);
		} catch (NullPointerException e) {
			throw new StorageException(StorageException.NOSAVE, e);
		}
	}

	private void save(EObject object) throws EmfStoreException {
		try {
			object.eResource().save(null);
		} catch (IOException e) {
			throw new StorageException(StorageException.NOSAVE, e);
		} catch (NullPointerException e) {
			throw new StorageException(StorageException.NOSAVE, e);
		}
	}

}
