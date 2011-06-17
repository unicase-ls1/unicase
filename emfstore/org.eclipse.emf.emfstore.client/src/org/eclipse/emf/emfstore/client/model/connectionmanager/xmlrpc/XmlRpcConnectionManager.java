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
package org.eclipse.emf.emfstore.client.model.connectionmanager.xmlrpc;

import java.util.List;

import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.connectionmanager.AbstractConnectionManager;
import org.eclipse.emf.emfstore.client.model.connectionmanager.ConnectionManager;
import org.eclipse.emf.emfstore.common.model.EMFStoreProperty;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.connection.xmlrpc.XmlRpcConnectionHandler;
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
 * XML RPC based Implementation of ConnectionManager.
 * 
 * @author wesendon
 */
public class XmlRpcConnectionManager extends
		AbstractConnectionManager<XmlRpcClientManager> implements
		ConnectionManager {

	/**
	 * {@inheritDoc}
	 */
	public SessionId logIn(String username, String password,
			ServerInfo serverInfo, ClientVersionInfo clientVersionInfo)
			throws EmfStoreException {
		XmlRpcClientManager clientManager = new XmlRpcClientManager(
				XmlRpcConnectionHandler.EMFSTORE);
		clientManager.initConnection(serverInfo);
		SessionId id = clientManager.callWithResult("logIn", SessionId.class,
				username, password, clientVersionInfo);
		addConnectionProxy(id, clientManager);
		return id;
	}

	/**
	 * {@inheritDoc}
	 */
	public void logout(SessionId sessionId) throws EmfStoreException {
		getConnectionProxy(sessionId).call("logout", sessionId);
		removeConnectionProxy(sessionId);
	}

	/**
	 * {@inheritDoc}
	 */
	public void addTag(SessionId sessionId, ProjectId projectId,
			PrimaryVersionSpec versionSpec, TagVersionSpec tag)
			throws EmfStoreException {
		getConnectionProxy(sessionId).call("addTag", sessionId, projectId,
				versionSpec, tag);
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectInfo createEmptyProject(SessionId sessionId, String name,
			String description, LogMessage logMessage) throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithResult(
				"createEmptyProject", ProjectInfo.class, sessionId, name,
				description, logMessage);
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectInfo createProject(SessionId sessionId, String name,
			String description, LogMessage logMessage, Project project)
			throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithResult("createProject",
				ProjectInfo.class, sessionId, name, description, logMessage,
				project);
	}

	/**
	 * {@inheritDoc}
	 */
	public PrimaryVersionSpec createVersion(SessionId sessionId,
			ProjectId projectId, PrimaryVersionSpec baseVersionSpec,
			ChangePackage changePackage, LogMessage logMessage)
			throws EmfStoreException, InvalidVersionSpecException {
		return getConnectionProxy(sessionId).callWithResult("createVersion",
				PrimaryVersionSpec.class, sessionId, projectId,
				baseVersionSpec, changePackage, logMessage);
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteProject(SessionId sessionId, ProjectId projectId,
			boolean deleteFiles) throws EmfStoreException {
		getConnectionProxy(sessionId).call("deleteProject", sessionId,
				projectId, deleteFiles);
	}

	/**
	 * {@inheritDoc}
	 */
	public FileChunk downloadFileChunk(SessionId sessionId,
			ProjectId projectId, FileTransferInformation fileInformation)
			throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithResult(
				"downloadFileChunk", FileChunk.class, sessionId, projectId,
				fileInformation);
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectHistory exportProjectHistoryFromServer(SessionId sessionId,
			ProjectId projectId) throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithResult(
				"exportProjectHistoryFromServer", ProjectHistory.class,
				sessionId, projectId);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ChangePackage> getChanges(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithListResult("getChanges",
				ChangePackage.class, sessionId, projectId, source, target);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<HistoryInfo> getHistoryInfo(SessionId sessionId,
			ProjectId projectId, HistoryQuery historyQuery)
			throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithListResult(
				"getHistoryInfo", HistoryInfo.class, sessionId, projectId,
				historyQuery);
	}

	/**
	 * {@inheritDoc}
	 */
	public Project getProject(SessionId sessionId, ProjectId projectId,
			VersionSpec versionSpec) throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithResult("getProject",
				Project.class, sessionId, projectId, versionSpec);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ProjectInfo> getProjectList(SessionId sessionId)
			throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithListResult(
				"getProjectList", ProjectInfo.class, sessionId);
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectId importProjectHistoryToServer(SessionId sessionId,
			ProjectHistory projectHistory) throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithResult(
				"importProjectHistoryToServer", ProjectId.class, sessionId,
				projectHistory);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeTag(SessionId sessionId, ProjectId projectId,
			PrimaryVersionSpec versionSpec, TagVersionSpec tag)
			throws EmfStoreException {
		getConnectionProxy(sessionId).call("removeTag", sessionId, projectId,
				versionSpec, tag);
	}

	/**
	 * {@inheritDoc}
	 */
	public ACUser resolveUser(SessionId sessionId, ACOrgUnitId id)
			throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithResult("resolveUser",
				ACUser.class, sessionId, id);
	}

	/**
	 * {@inheritDoc}
	 */
	public PrimaryVersionSpec resolveVersionSpec(SessionId sessionId,
			ProjectId projectId, VersionSpec versionSpec)
			throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithResult(
				"resolveVersionSpec", PrimaryVersionSpec.class, sessionId,
				projectId, versionSpec);
	}

	/**
	 * {@inheritDoc}
	 */
	public void transmitProperty(SessionId sessionId,
			OrgUnitProperty changedProperty, ACUser tmpUser, ProjectId projectId)
			throws EmfStoreException {
		getConnectionProxy(sessionId).call("transmitProperty", sessionId,
				changedProperty, tmpUser, projectId);
	}

	/**
	 * {@inheritDoc}
	 */
	public FileTransferInformation uploadFileChunk(SessionId sessionId,
			ProjectId projectId, FileChunk fileChunk) throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithResult("uploadFileChunk",
				FileTransferInformation.class, sessionId, projectId, fileChunk);
	}

	public void transmitEMFProperty(SessionId sessionId,
			EMFStoreProperty property, ProjectId projectId)
			throws EmfStoreException {
		getConnectionProxy(sessionId).call("transmitEMFProperty", sessionId,
				property, projectId);
	}
}
