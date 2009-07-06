/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;
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
import org.unicase.emfstore.esmodel.versioning.DateVersionSpec;
import org.unicase.emfstore.esmodel.versioning.HeadVersionSpec;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.HistoryQuery;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.TagVersionSpec;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.BaseVersionOutdatedException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.InvalidInputException;
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
	 */
	public EmfStoreImpl(ServerSpace serverSpace,
			AuthorizationControl authorizationControl) {
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
		if (sessionId == null || projectId == null || baseVersionSpec == null
				|| changePackage == null || logMessage == null) {
			throw new InvalidInputException();
		}
		authorizationControl.checkWriteAccess(sessionId, projectId, null);
		long currentTimeMillis = System.currentTimeMillis();

		ProjectHistory projectHistory = getProject(projectId);
		List<Version> versions = projectHistory.getVersions();

		// OW: check here if base version is valid at all

		if (versions.size() - 1 != baseVersionSpec.getIdentifier()) {
			throw new BaseVersionOutdatedException();
		}

		PrimaryVersionSpec newVersionSpec = VersioningFactory.eINSTANCE
				.createPrimaryVersionSpec();
		newVersionSpec.setIdentifier(baseVersionSpec.getIdentifier() + 1);

		Version newVersion = VersioningFactory.eINSTANCE.createVersion();

		Version previousHeadVersion = versions.get(versions.size() - 1);

		Project newProjectState = (Project) EcoreUtil.copy(previousHeadVersion
				.getProjectState());

		changePackage.apply(newProjectState);

		newVersion.setProjectState(newProjectState);

		newVersion.setChanges(changePackage);

		logMessage.setDate(new Date());
		newVersion.setLogMessage(logMessage);
		newVersion.setPrimarySpec(newVersionSpec);
		newVersion.setNextVersion(null);
		newVersion.setPreviousVersion(previousHeadVersion);

		versions.add(newVersion);

		// try to save
		try {
			try {
				createResourceForProject(newProjectState, newVersion
						.getPrimarySpec(), projectHistory.getProjectId());
				createResourceForVersion(newVersion, projectHistory
						.getProjectId());
			} catch (FatalEmfStoreException e) {
				// try to roll back
				previousHeadVersion.setNextVersion(null);
				versions.remove(newVersion);
				// OW: why do we need to save here, can we remove? do test!!
				save(previousHeadVersion);
				save(projectHistory);
				throw new StorageException(StorageException.NOSAVE);
			}
			// delete projectstate from last revision depending on persistence
			// policy
			String property = ServerConfiguration
					.getProperties()
					.getProperty(
							ServerConfiguration.PROJECTSTATE_VERSION_PERSISTENCE,
							ServerConfiguration.PROJECTSPACE_VERSION_PERSISTENCE_DEFAULT);

			if (property
					.equals(ServerConfiguration.PROJECTSTATE_VERSION_PERSISTENCE_EVERYXVERSIONS)) {

				int x = getXFromPolicy(
						ServerConfiguration.PROJECTSTATE_VERSION_PERSISTENCE_EVERYXVERSIONS_X,
						ServerConfiguration.PROJECTSTATE_VERSION_PERSISTENCE_EVERYXVERSIONS_X_DEFAULT,
						false);

				// always save projecstate of first version
				int lastVersion = previousHeadVersion.getPrimarySpec()
						.getIdentifier();
				if (lastVersion != 0 && lastVersion % x != 0) {
					deleteProjectState(projectId, previousHeadVersion);
				}

			} else {
				deleteProjectState(projectId, previousHeadVersion);
			}
			save(previousHeadVersion);
			save(projectHistory);
		} catch (FatalEmfStoreException e) {
			// roll back failed
			EmfStoreController.getInstance().shutdown(e);
			throw new EmfStoreException("Shutting down server.");
		}

		LOGGER.info("Total time for commit: "
				+ (System.currentTimeMillis() - currentTimeMillis));
		return newVersionSpec;
	}

	private void deleteProjectState(ProjectId projectId,
			Version previousHeadVersion) {
		previousHeadVersion.setProjectState(null);

		// the projectstate is set null in the containment tree. Then the
		// emfstore checks whether he should the containing file, or if it
		// should be backuped.

		int lastVersion = previousHeadVersion.getPrimarySpec().getIdentifier();
		int x = getXFromPolicy(
				ServerConfiguration.PROJECTSTATE_VERSION_BACKUP_PERSISTENCE_EVERYXVERSIONS_X,
				ServerConfiguration.PROJECTSTATE_VERSION_BACKUP_PERSISTENCE_EVERYXVERSIONS_X_DEFAULT,
				true);
		File file = new File(getProjectFolder(projectId) + getProjectFile(lastVersion));
		if (lastVersion != 0 && lastVersion % x != 0) {
			file.delete();
		} else {
			file.renameTo(new File(getProjectFolder(projectId)+"backup_"+getProjectFile(lastVersion)));
		}
	}

	private int getXFromPolicy(String policy, String defaultPolicy,
			boolean allowZero) {
		int x;
		try {
			x = Integer.parseInt(ServerConfiguration.getProperties()
					.getProperty(policy, defaultPolicy));
		} catch (NumberFormatException e) {
			x = 1;
			LOGGER.warn("Couldn't read property: " + policy + " , x set to 1");
		}
		if (x < 0) {
			x = 1;
			LOGGER.warn("Policy " + policy
					+ " with x < 0 not possible, x set to 1.");
		}
		if (!allowZero && x == 0) {
			x = 1;
			LOGGER.warn("Policy " + policy
					+ " with x = 0 not possible, x set to 1.");
		}
		return x;
	}

	/**
	 * @generated NOT
	 * @return the emf store model version number as in the manifest file
	 */
	public static org.osgi.framework.Version getModelVersion() {
		Bundle emfStoreBundle = Platform.getBundle("org.unicase.emfstore");
		String emfStoreVersionString = (String) emfStoreBundle.getHeaders()
				.get(org.osgi.framework.Constants.BUNDLE_VERSION);
		org.osgi.framework.Version emfStoreVersion = new org.osgi.framework.Version(
				emfStoreVersionString);

		return emfStoreVersion;
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized List<ChangePackage> getChanges(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws EmfStoreException {
		if (sessionId == null || projectId == null || source == null
				|| target == null) {
			throw new InvalidInputException();
		}
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
			changes.setLogMessage((LogMessage) EcoreUtil.copy(version
					.getLogMessage()));
			result.add(changes);
		}

		// if source is after target in time
		if (resolvedSource.compareTo(resolvedTarget) > 0) {
			// reverse list and change packages
			Collections.reverse(result);
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized List<HistoryInfo> getHistoryInfo(SessionId sessionId,
			ProjectId projectId, HistoryQuery historyQuery)
			throws EmfStoreException {
		if (sessionId == null || projectId == null || historyQuery == null) {
			throw new InvalidInputException();
		}
		authorizationControl.checkReadAccess(sessionId, projectId, null);
		List<HistoryInfo> result = getHistoryInfo(projectId, historyQuery
				.getSource(), historyQuery.getTarget());
		if (historyQuery.getSource().compareTo(historyQuery.getTarget()) < 0) {
			Collections.reverse(result);
		}
		return result;
	}

	private List<HistoryInfo> getHistoryInfo(ProjectId projectId,
			PrimaryVersionSpec source, PrimaryVersionSpec target)
			throws EmfStoreException {
		if (projectId == null || source == null || target == null) {
			throw new InvalidInputException();
		}
		List<HistoryInfo> result = new ArrayList<HistoryInfo>();
		PrimaryVersionSpec headRevision = getProject(projectId)
				.getLastVersion().getPrimarySpec();
		for (Version version : getVersions(projectId, source, target)) {
			HistoryInfo history = VersioningFactory.eINSTANCE
					.createHistoryInfo();
			history.setLogMessage((LogMessage) EcoreUtil.copy(version
					.getLogMessage()));
			history.setPrimerySpec((PrimaryVersionSpec) EcoreUtil.copy(version
					.getPrimarySpec()));
			for (TagVersionSpec tagSpec : version.getTagSpecs()) {
				history.getTagSpecs().add(
						(TagVersionSpec) EcoreUtil.copy(tagSpec));
			}
			// add HEAD tag to history info
			if (version.getPrimarySpec().equals(headRevision)) {
				TagVersionSpec spec = VersioningFactory.eINSTANCE
						.createTagVersionSpec();
				spec.setName(VersionSpec.HEAD);
				history.getTagSpecs().add(spec);
			}
			result.add(history);
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addTag(SessionId sessionId, ProjectId projectId,
			PrimaryVersionSpec versionSpec, TagVersionSpec tag)
			throws EmfStoreException {
		if (sessionId == null || projectId == null || versionSpec == null
				|| tag == null) {
			throw new InvalidInputException();
		}
		authorizationControl.checkProjectAdminAccess(sessionId, projectId);
		Version version = getVersion(projectId, versionSpec);
		version.getTagSpecs().add(tag);
		try {
			save(version);
		} catch (FatalEmfStoreException e) {
			throw new StorageException(StorageException.NOSAVE);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeTag(SessionId sessionId, ProjectId projectId,
			PrimaryVersionSpec versionSpec, TagVersionSpec tag)
			throws EmfStoreException {
		if (sessionId == null || projectId == null || versionSpec == null
				|| tag == null) {
			throw new InvalidInputException();
		}
		authorizationControl.checkProjectAdminAccess(sessionId, projectId);
		Version version = getVersion(projectId, versionSpec);
		version.getTagSpecs().remove(tag);
		try {
			save(version);
		} catch (FatalEmfStoreException e) {
			throw new StorageException(StorageException.NOSAVE);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized Project getProject(SessionId sessionId,
			ProjectId projectId, VersionSpec versionSpec)
			throws EmfStoreException {
		if (sessionId == null || projectId == null || versionSpec == null) {
			throw new InvalidInputException();
		}
		authorizationControl.checkReadAccess(sessionId, projectId, null);
		PrimaryVersionSpec resolvedVersion = resolveVersionSpec(projectId,
				versionSpec);
		Version version = getVersion(projectId, resolvedVersion);
		if (version.getProjectState() == null) {
			// OW: speed up calculation by using nearer projectstate
			// instead of first.
			Version firstVersion = getProject(projectId).getVersions().get(0);
			Project projectState = (Project) EcoreUtil.copy(firstVersion
					.getProjectState());
			for (Version next = firstVersion.getNextVersion(); next != null
					&& next.getPrimarySpec().compareTo(resolvedVersion) < 1; next = next
					.getNextVersion()) {
				next.getChanges().apply(projectState);
			}
			return projectState;
		} else {
			return version.getProjectState();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized List<ProjectInfo> getProjectList(SessionId sessionId)
			throws EmfStoreException {
		if (sessionId == null) {
			throw new InvalidInputException();
		}
		List<ProjectInfo> result = new ArrayList<ProjectInfo>();
		for (ProjectHistory project : getServerSpace().getProjects()) {
			try {
				authorizationControl.checkReadAccess(sessionId, project
						.getProjectId(), null);
				result.add(getProjectInfo(project));
			} catch (AccessControlException e) {
				// do nothing and continue
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
		if (sessionId == null || projectId == null || versionSpec == null) {
			throw new InvalidInputException();
		}
		authorizationControl.checkReadAccess(sessionId, projectId, null);
		return resolveVersionSpec(projectId, versionSpec);
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized ACUser resolveUser(SessionId sessionId, ACOrgUnitId id)
			throws EmfStoreException {
		if (sessionId == null) {
			throw new InvalidInputException();
		}
		ACUser requestingUser = authorizationControl.resolveUser(sessionId);
		if (id == null) {
			return requestingUser;
		}
		ACUser user = authorizationControl.resolveUser(id);
		if (requestingUser.getId().equals(user.getId())) {
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
		if (sessionId == null || name == null || description == null
				|| logMessage == null) {
			throw new InvalidInputException();
		}
		authorizationControl.checkServerAdminAccess(sessionId);
		ProjectHistory projectHistory = null;
		try {
			logMessage.setDate(new Date());
			projectHistory = createEmptyProject(name, description, logMessage);
		} catch (FatalEmfStoreException e) {
			throw new StorageException(StorageException.NOSAVE);
		}
		return getProjectInfo(projectHistory);
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized ProjectInfo createProject(SessionId sessionId,
			String name, String description, LogMessage logMessage,
			Project project) throws EmfStoreException {
		if (sessionId == null || name == null || description == null
				|| logMessage == null || project == null) {
			throw new InvalidInputException();
		}
		authorizationControl.checkServerAdminAccess(sessionId);
		ProjectHistory projectHistory = null;
		try {
			logMessage.setDate(new Date());
			projectHistory = createEmptyProject(name, description, logMessage);
			Version lastVersion = projectHistory.getLastVersion();
			lastVersion.setProjectState(project);
			createResourceForProject(project, lastVersion.getPrimarySpec(),
					projectHistory.getProjectId());
			save(lastVersion);
		} catch (FatalEmfStoreException e) {
			throw new StorageException(StorageException.NOSAVE);
		}

		return getProjectInfo(projectHistory);
	}

	private ProjectHistory createEmptyProject(String name, String description,
			LogMessage logMessage) throws FatalEmfStoreException {

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
		Project project = ModelFactory.eINSTANCE.createProject();
		firstVersion.setProjectState(project);
		createResourceForProject(project, firstVersion.getPrimarySpec(),
				projectHistory.getProjectId());
		projectHistory.getVersions().add(firstVersion);

		// add to serverspace and saved
		createResourceForVersion(firstVersion, projectHistory.getProjectId());
		createResourceForProjectHistory(projectHistory);
		getServerSpace().getProjects().add(projectHistory);
		save();
		return projectHistory;
	}

	private void createResourceForProjectHistory(ProjectHistory projectHistory)
			throws FatalEmfStoreException {
		String fileName = getProjectFolder(projectHistory.getProjectId())
				+ "projectHistory"
				+ ServerConfiguration.FILE_EXTENSION_PROJECTHISTORY;
		saveInResource(projectHistory, fileName);
	}

	private void createResourceForVersion(Version version, ProjectId projectId)
			throws FatalEmfStoreException {
		String fileName = getProjectFolder(projectId) + "version-"
				+ version.getPrimarySpec().getIdentifier()
				+ ServerConfiguration.FILE_EXTENSION_VERSION;
		saveInResource(version, fileName);
	}

	private void createResourceForProject(Project project,
			PrimaryVersionSpec versionId, ProjectId projectId)
			throws FatalEmfStoreException {
		String filename = getProjectFolder(projectId)
				+ getProjectFile(versionId.getIdentifier());
		saveInResource(project, filename);
	}

	private String getProjectFile(int versionNumber) {
		return "projectstate-" + versionNumber
				+ ServerConfiguration.FILE_EXTENSION_PROJECTSTATE;
	}

	private String getProjectFolder(ProjectId projectId) {
		return ServerConfiguration.getServerHome() + "project-"
				+ projectId.getId() + File.separatorChar;
	}

	private void saveInResource(EObject obj, String fileName)
			throws FatalEmfStoreException {
		Resource resource = getServerSpace().eResource().getResourceSet()
				.createResource(URI.createFileURI(fileName));
		resource.getContents().add(obj);
		save(obj);
	}

	private ServerSpace getServerSpace() {
		return serverSpace;
	}

	private ProjectHistory getProject(ProjectId projectId)
			throws EmfStoreException {
		for (ProjectHistory project : getServerSpace().getProjects()) {
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
		info.setProjectId((ProjectId) EcoreUtil.copy(project.getProjectId()));
		info.setVersion((PrimaryVersionSpec) EcoreUtil.copy(project
				.getLastVersion().getPrimarySpec()));
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
			// DateVersionSpec
		} else if (versionSpec instanceof DateVersionSpec) {
			for (Version version : projectHistory.getVersions()) {
				if (((DateVersionSpec) versionSpec).getDate().before(
						version.getLogMessage().getDate())) {
					Version previousVersion = version.getPreviousVersion();
					if (previousVersion == null) {
						break;
					}
					return previousVersion.getPrimarySpec();
				}
			}
			throw new InvalidVersionSpecException();
			// TagVersionSpec
		} else if (versionSpec instanceof TagVersionSpec) {
			for (Version version : projectHistory.getVersions()) {
				for (TagVersionSpec tag : version.getTagSpecs()) {
					if (((TagVersionSpec) versionSpec).equals(tag)) {
						return (PrimaryVersionSpec) EcoreUtil.copy(version
								.getPrimarySpec());
					}
				}
			}
			throw new InvalidVersionSpecException();
		} else {
			throw new InvalidVersionSpecException();
		}
	}

	private Version getVersion(ProjectId projectId,
			PrimaryVersionSpec versionSpec) throws EmfStoreException {
		EList<Version> versions = getProject(projectId).getVersions();
		if (versionSpec.getIdentifier() < 0
				|| versionSpec.getIdentifier() > versions.size() - 1) {
			throw new InvalidVersionSpecException();
		}
		return versions.get(versionSpec.getIdentifier());
	}

	private List<Version> getVersions(ProjectId projectId,
			PrimaryVersionSpec source, PrimaryVersionSpec target)
			throws EmfStoreException {
		if (source.compareTo(target) < 1) {
			EList<Version> versions = getProject(projectId).getVersions();
			if (source.getIdentifier() < 0
					|| source.getIdentifier() > versions.size() - 1
					|| target.getIdentifier() < 0
					|| target.getIdentifier() > versions.size() - 1) {
				throw new InvalidVersionSpecException();
			}
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

	/**
	 * Unloads all projecstates which are not in the headrevision.
	 */
	// TODO OW move this function to clean memory task when monitor object is
	// introduced.
	public synchronized void unloadProjectStates() {
		ResourceSet resourceSet = getServerSpace().eResource().getResourceSet();
		EList<Resource> resources = resourceSet.getResources();
		for (int i = 0; i < resources.size(); i++) {
			Resource res = resources.get(i);
			if (res.isLoaded()) {
				EList<EObject> contents = res.getContents();
				if (contents.size() == 1 && contents.get(0) instanceof Project) {
					Project project = (Project) contents.get(0);
					if (project.eContainer() instanceof Version
							&& ((Version) project.eContainer())
									.getNextVersion() != null) {
						LOGGER.info("unloading: " + project);
						res.unload();
					}
				}
			}
		}
		System.gc();
	}

	private void save() throws FatalEmfStoreException {
		try {
			long currentTimeMillis = System.currentTimeMillis();
			getServerSpace().save();
			LOGGER.error("Total time for saving: "
					+ (System.currentTimeMillis() - currentTimeMillis));
			currentTimeMillis = System.currentTimeMillis();
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (Exception e) {
			throw new FatalEmfStoreException(StorageException.NOSAVE, e);
		}
		// END SUPRESS CATCH EXCEPTION
	}

	private void save(EObject object) throws FatalEmfStoreException {
		try {
			object.eResource().save(null);
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (Exception e) {
			throw new FatalEmfStoreException(StorageException.NOSAVE, e);
		}
		// END SUPRESS CATCH EXCEPTION
	}
}
