/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.core;

import java.util.List;

import org.unicase.emfstore.EmfStore;
import org.unicase.emfstore.accesscontrol.AuthorizationControl;
import org.unicase.emfstore.core.subinterfaces.FileTransferSubInterfaceImpl;
import org.unicase.emfstore.core.subinterfaces.HistorySubInterfaceImpl;
import org.unicase.emfstore.core.subinterfaces.ProjectPropertiesSubInterfaceImpl;
import org.unicase.emfstore.core.subinterfaces.ProjectSubInterfaceImpl;
import org.unicase.emfstore.core.subinterfaces.UserSubInterfaceImpl;
import org.unicase.emfstore.core.subinterfaces.VersionSubInterfaceImpl;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.HistoryQuery;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.TagVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.eventmanager.EventHelper;
import org.unicase.emfstore.eventmanager.EventManager;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.InvalidVersionSpecException;
import org.unicase.emfstore.filetransfer.FileChunk;
import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.metamodel.Project;

/**
 * This is the main implementation of {@link EmfStore}.
 * 
 * @author wesendon
 * @see EmfStore
 */
public class EmfStoreImpl extends AbstractEmfstoreInterface implements EmfStore {

	/**
	 * Default constructor.
	 * 
	 * @param serverSpace the serverspace
	 * @param authorizationControl the accesscontrol
	 * @throws FatalEmfStoreException in case of failure
	 */
	public EmfStoreImpl(ServerSpace serverSpace, AuthorizationControl authorizationControl)
		throws FatalEmfStoreException {
		super(serverSpace, authorizationControl);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initSubInterfaces() throws FatalEmfStoreException {
		addSubInterface(new HistorySubInterfaceImpl(this));
		addSubInterface(new ProjectSubInterfaceImpl(this));
		addSubInterface(new UserSubInterfaceImpl(this));
		addSubInterface(new VersionSubInterfaceImpl(this));
		addSubInterface(new FileTransferSubInterfaceImpl(this));
		addSubInterface(new ProjectPropertiesSubInterfaceImpl(this));
	}

	/**
	 * {@inheritDoc}
	 */
	public List<HistoryInfo> getHistoryInfo(SessionId sessionId, ProjectId projectId, HistoryQuery historyQuery)
		throws EmfStoreException {
		sanityCheckObjects(sessionId, projectId, historyQuery);
		checkReadAccess(sessionId, projectId, null);
		return getSubInterface(HistorySubInterfaceImpl.class).getHistoryInfo(projectId, historyQuery);
	}

	/**
	 * {@inheritDoc}
	 */
	public void addTag(SessionId sessionId, ProjectId projectId, PrimaryVersionSpec versionSpec, TagVersionSpec tag)
		throws EmfStoreException {
		sanityCheckObjects(sessionId, projectId, versionSpec, tag);
		checkProjectAdminAccess(sessionId, projectId);
		getSubInterface(HistorySubInterfaceImpl.class).addTag(projectId, versionSpec, tag);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeTag(SessionId sessionId, ProjectId projectId, PrimaryVersionSpec versionSpec, TagVersionSpec tag)
		throws EmfStoreException {
		sanityCheckObjects(sessionId, projectId, versionSpec, tag);
		checkProjectAdminAccess(sessionId, projectId);
		getSubInterface(HistorySubInterfaceImpl.class).removeTag(projectId, versionSpec, tag);
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectInfo createEmptyProject(SessionId sessionId, String name, String description, LogMessage logMessage)
		throws EmfStoreException {
		sanityCheckObjects(sessionId, name, description, logMessage);
		checkServerAdminAccess(sessionId);
		return getSubInterface(ProjectSubInterfaceImpl.class).createProject(name, description, logMessage);
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectInfo createProject(SessionId sessionId, String name, String description, LogMessage logMessage,
		Project project) throws EmfStoreException {
		sanityCheckObjects(sessionId, name, description, logMessage, project);
		checkServerAdminAccess(sessionId);
		return getSubInterface(ProjectSubInterfaceImpl.class).createProject(name, description, logMessage, project);
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteProject(SessionId sessionId, ProjectId projectId, boolean deleteFiles) throws EmfStoreException {
		sanityCheckObjects(sessionId, projectId);
		checkServerAdminAccess(sessionId);
		getSubInterface(ProjectSubInterfaceImpl.class).deleteProject(projectId, deleteFiles);
	}

	/**
	 * {@inheritDoc}
	 */
	public PrimaryVersionSpec createVersion(SessionId sessionId, ProjectId projectId,
		PrimaryVersionSpec baseVersionSpec, ChangePackage changePackage, LogMessage logMessage)
		throws EmfStoreException, InvalidVersionSpecException {
		sanityCheckObjects(sessionId, projectId, baseVersionSpec, changePackage, logMessage);
		checkWriteAccess(sessionId, projectId, null);
		PrimaryVersionSpec newVersion = getSubInterface(VersionSubInterfaceImpl.class).createVersion(projectId,
			baseVersionSpec, changePackage, logMessage);
		EventManager.getInstance().sendEvent(EventHelper.createUpdatedProjectEvent(projectId, newVersion));
		return newVersion;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ChangePackage> getChanges(SessionId sessionId, ProjectId projectId, VersionSpec source,
		VersionSpec target) throws EmfStoreException {
		sanityCheckObjects(sessionId, projectId, source, target);
		checkReadAccess(sessionId, projectId, null);
		return getSubInterface(VersionSubInterfaceImpl.class).getChanges(projectId, source, target);
	}

	/**
	 * {@inheritDoc}
	 */
	public PrimaryVersionSpec resolveVersionSpec(SessionId sessionId, ProjectId projectId, VersionSpec versionSpec)
		throws EmfStoreException {
		sanityCheckObjects(sessionId, projectId, versionSpec);
		checkReadAccess(sessionId, projectId, null);
		return getSubInterface(VersionSubInterfaceImpl.class).resolveVersionSpec(projectId, versionSpec);
	}

	/**
	 * {@inheritDoc}
	 */
	public Project getProject(SessionId sessionId, ProjectId projectId, VersionSpec versionSpec)
		throws EmfStoreException {
		sanityCheckObjects(sessionId, projectId, versionSpec);
		checkReadAccess(sessionId, projectId, null);
		return getSubInterface(ProjectSubInterfaceImpl.class).getProject(projectId, versionSpec);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ProjectInfo> getProjectList(SessionId sessionId) throws EmfStoreException {
		sanityCheckObjects(sessionId);
		return getSubInterface(ProjectSubInterfaceImpl.class).getProjectList(sessionId);
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectId importProjectHistoryToServer(SessionId sessionId, ProjectHistory projectHistory)
		throws EmfStoreException {
		sanityCheckObjects(sessionId, projectHistory);
		checkServerAdminAccess(sessionId);
		return getSubInterface(ProjectSubInterfaceImpl.class).importProjectHistoryToServer(projectHistory);
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectHistory exportProjectHistoryFromServer(SessionId sessionId, ProjectId projectId)
		throws EmfStoreException {
		sanityCheckObjects(sessionId, projectId);
		checkServerAdminAccess(sessionId);
		return getSubInterface(ProjectSubInterfaceImpl.class).exportProjectHistoryFromServer(projectId);
	}

	/**
	 * {@inheritDoc}
	 */
	public ACUser resolveUser(SessionId sessionId, ACOrgUnitId id) throws EmfStoreException {
		sanityCheckObjects(sessionId);
		return getSubInterface(UserSubInterfaceImpl.class).resolveUser(sessionId, id);
	}

	/**
	 * {@inheritDoc}
	 */
	public FileChunk downloadFileChunk(SessionId sessionId, ProjectId projectId, FileInformation fileInformation)
		throws EmfStoreException {
		sanityCheckObjects(sessionId, projectId, fileInformation);
		checkReadAccess(sessionId, projectId, null);
		return getSubInterface(FileTransferSubInterfaceImpl.class).readChunk(projectId, fileInformation);
	}

	/**
	 * {@inheritDoc}
	 */
	public FileInformation uploadFileChunk(SessionId sessionId, ProjectId projectId, FileChunk fileChunk)
		throws EmfStoreException {
		sanityCheckObjects(sessionId, projectId, fileChunk, fileChunk.getFileInformation());
		checkWriteAccess(sessionId, projectId, null);
		return getSubInterface(FileTransferSubInterfaceImpl.class).writeChunk(fileChunk, projectId);
	}

	/**
	 * {@inheritDoc}
	 */
	public void transmitProperty(SessionId sessionId, OrgUnitProperty changedProperty, ACUser user, ProjectId projectId)
		throws EmfStoreException {
		sanityCheckObjects(projectId, user, changedProperty);
		checkWriteAccess(sessionId, projectId, null);
		getSubInterface(ProjectPropertiesSubInterfaceImpl.class).setProperty(changedProperty, user, projectId);
	}

}
