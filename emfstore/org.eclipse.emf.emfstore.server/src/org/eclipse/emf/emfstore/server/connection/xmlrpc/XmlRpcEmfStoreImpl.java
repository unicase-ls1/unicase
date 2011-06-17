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
package org.eclipse.emf.emfstore.server.connection.xmlrpc;

import java.util.List;

import org.eclipse.emf.emfstore.common.model.EMFStoreProperty;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.EmfStore;
import org.eclipse.emf.emfstore.server.accesscontrol.AuthenticationControl;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.InvalidVersionSpecException;
import org.eclipse.emf.emfstore.server.filetransfer.FileChunk;
import org.eclipse.emf.emfstore.server.filetransfer.FileTransferInformation;
import org.eclipse.emf.emfstore.server.model.ClientVersionInfo;
import org.eclipse.emf.emfstore.server.model.ProjectHistory;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.OrgUnitProperty;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery;
import org.eclipse.emf.emfstore.server.model.versioning.LogMessage;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersionSpec;

/**
 * XML RPC connection interface for emfstore.
 * 
 * @author wesendon
 */
public class XmlRpcEmfStoreImpl implements EmfStore, AuthenticationControl {

	private EmfStore getEmfStore() {
		return XmlRpcConnectionHandler.getEmfStore();
	}

	private AuthenticationControl getAccessControl() {
		return XmlRpcConnectionHandler.getAccessControl();
	}

	/**
	 * {@inheritDoc}
	 */
	public SessionId logIn(String username, String password,
			ClientVersionInfo clientVersionInfo) throws AccessControlException {
		return getAccessControl().logIn(username, password, clientVersionInfo);
	}

	/**
	 * {@inheritDoc}
	 */
	public void logout(SessionId sessionId) throws AccessControlException {
		getAccessControl().logout(sessionId);
	}

	/**
	 * {@inheritDoc}
	 */
	public void addTag(SessionId sessionId, ProjectId projectId,
			PrimaryVersionSpec versionSpec, TagVersionSpec tag)
			throws EmfStoreException {
		getEmfStore().addTag(sessionId, projectId, versionSpec, tag);
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectInfo createEmptyProject(SessionId sessionId, String name,
			String description, LogMessage logMessage) throws EmfStoreException {
		return getEmfStore().createEmptyProject(sessionId, name, description,
				logMessage);
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectInfo createProject(SessionId sessionId, String name,
			String description, LogMessage logMessage, Project project)
			throws EmfStoreException {
		return getEmfStore().createProject(sessionId, name, description,
				logMessage, project);
	}

	/**
	 * {@inheritDoc}
	 */
	public PrimaryVersionSpec createVersion(SessionId sessionId,
			ProjectId projectId, PrimaryVersionSpec baseVersionSpec,
			ChangePackage changePackage, LogMessage logMessage)
			throws EmfStoreException, InvalidVersionSpecException {
		return getEmfStore().createVersion(sessionId, projectId,
				baseVersionSpec, changePackage, logMessage);
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteProject(SessionId sessionId, ProjectId projectId,
			boolean deleteFiles) throws EmfStoreException {
		getEmfStore().deleteProject(sessionId, projectId, deleteFiles);
	}

	/**
	 * {@inheritDoc}
	 */
	public FileChunk downloadFileChunk(SessionId sessionId,
			ProjectId projectId, FileTransferInformation fileInformation)
			throws EmfStoreException {
		return getEmfStore().downloadFileChunk(sessionId, projectId,
				fileInformation);
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectHistory exportProjectHistoryFromServer(SessionId sessionId,
			ProjectId projectId) throws EmfStoreException {
		return getEmfStore().exportProjectHistoryFromServer(sessionId,
				projectId);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ChangePackage> getChanges(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws EmfStoreException {
		return getEmfStore().getChanges(sessionId, projectId, source, target);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<HistoryInfo> getHistoryInfo(SessionId sessionId,
			ProjectId projectId, HistoryQuery historyQuery)
			throws EmfStoreException {
		return getEmfStore().getHistoryInfo(sessionId, projectId, historyQuery);
	}

	/**
	 * {@inheritDoc}
	 */
	public Project getProject(SessionId sessionId, ProjectId projectId,
			VersionSpec versionSpec) throws EmfStoreException {
		return getEmfStore().getProject(sessionId, projectId, versionSpec);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ProjectInfo> getProjectList(SessionId sessionId)
			throws EmfStoreException {
		return getEmfStore().getProjectList(sessionId);
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectId importProjectHistoryToServer(SessionId sessionId,
			ProjectHistory projectHistory) throws EmfStoreException {
		return getEmfStore().importProjectHistoryToServer(sessionId,
				projectHistory);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeTag(SessionId sessionId, ProjectId projectId,
			PrimaryVersionSpec versionSpec, TagVersionSpec tag)
			throws EmfStoreException {
		getEmfStore().removeTag(sessionId, projectId, versionSpec, tag);
	}

	/**
	 * {@inheritDoc}
	 */
	public ACUser resolveUser(SessionId sessionId, ACOrgUnitId id)
			throws EmfStoreException {
		return getEmfStore().resolveUser(sessionId, id);
	}

	/**
	 * {@inheritDoc}
	 */
	public PrimaryVersionSpec resolveVersionSpec(SessionId sessionId,
			ProjectId projectId, VersionSpec versionSpec)
			throws EmfStoreException {
		return getEmfStore().resolveVersionSpec(sessionId, projectId,
				versionSpec);
	}

	/**
	 * {@inheritDoc}
	 */
	public void transmitProperty(SessionId sessionId,
			OrgUnitProperty changedProperty, ACUser tmpUser, ProjectId projectId)
			throws EmfStoreException {
		getEmfStore().transmitProperty(sessionId, changedProperty, tmpUser,
				projectId);
	}

	/**
	 * {@inheritDoc}
	 */
	public FileTransferInformation uploadFileChunk(SessionId sessionId,
			ProjectId projectId, FileChunk fileChunk) throws EmfStoreException {
		return getEmfStore().uploadFileChunk(sessionId, projectId, fileChunk);
	}

	public void transmitEMFProperty(SessionId sessionId,
			EMFStoreProperty property, ProjectId projectId)
			throws EmfStoreException {
		getEmfStore().transmitEMFProperty(sessionId, property, projectId);

	}

}
