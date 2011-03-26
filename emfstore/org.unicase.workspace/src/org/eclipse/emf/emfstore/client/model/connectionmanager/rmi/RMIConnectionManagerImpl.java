/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.model.connectionmanager.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.connectionmanager.AbstractConnectionManager;
import org.eclipse.emf.emfstore.client.model.connectionmanager.ConnectionManager;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.connection.rmi.RMIConnectionHandler;
import org.eclipse.emf.emfstore.server.connection.rmi.RMIEmfStoreFacade;
import org.eclipse.emf.emfstore.server.connection.rmi.SerializationUtil;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.exceptions.ClientVersionOutOfDateException;
import org.eclipse.emf.emfstore.server.exceptions.ConnectionException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.RMISerializationException;
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
 * The RMIConnectionManager implements the {@link ConnectionManager} using the RMI technology. Please notice that the
 * EMF objects have to be serialized into String via {@link SerializationUtil} in order to avoid letting the EMF objects
 * implement the Serializable interface, which was discouraged from the EMF newsgroup.
 * 
 * @author Wesendonk
 */
public class RMIConnectionManagerImpl extends AbstractConnectionManager<RMIEmfStoreFacade> implements ConnectionManager {

	/**
	 * {@inheritDoc}
	 */
	public PrimaryVersionSpec createVersion(SessionId sessionId, ProjectId projectId,
		PrimaryVersionSpec baseVersionSpec, ChangePackage changePackage, LogMessage logMessage)
		throws EmfStoreException {

		try {

			return (PrimaryVersionSpec) SerializationUtil.stringToEObject(getConnectionProxy(sessionId).createVersion(
				SerializationUtil.eObjectToString(sessionId), SerializationUtil.eObjectToString(projectId),
				SerializationUtil.eObjectToString(baseVersionSpec), SerializationUtil.eObjectToString(changePackage),
				SerializationUtil.eObjectToString(logMessage)));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ChangePackage> getChanges(SessionId sessionId, ProjectId projectId, VersionSpec source,
		VersionSpec target) throws EmfStoreException {
		List<ChangePackage> result = new ArrayList<ChangePackage>();
		try {
			for (String changePackage : getConnectionProxy(sessionId).getChanges(
				SerializationUtil.eObjectToString(sessionId), SerializationUtil.eObjectToString(projectId),
				SerializationUtil.eObjectToString(source), SerializationUtil.eObjectToString(target))) {

				ChangePackage changePackageObject = (ChangePackage) SerializationUtil.stringToEObject(changePackage);
				result.add(changePackageObject);
			}

		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<HistoryInfo> getHistoryInfo(SessionId sessionId, ProjectId projectId, HistoryQuery historyQuery)
		throws EmfStoreException {
		RMIEmfStoreFacade facade = getConnectionProxy(sessionId);
		try {
			List<HistoryInfo> result = new ArrayList<HistoryInfo>();
			for (String str : facade.getHistoryInfo(SerializationUtil.eObjectToString(sessionId),
				SerializationUtil.eObjectToString(projectId), SerializationUtil.eObjectToString(historyQuery))) {
				result.add((HistoryInfo) SerializationUtil.stringToEObject(str));
			}
			return result;
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void addTag(SessionId sessionId, ProjectId projectId, PrimaryVersionSpec versionSpec, TagVersionSpec tag)
		throws EmfStoreException {
		RMIEmfStoreFacade facade = getConnectionProxy(sessionId);
		try {
			facade.addTag(SerializationUtil.eObjectToString(sessionId), SerializationUtil.eObjectToString(projectId),
				SerializationUtil.eObjectToString(versionSpec), SerializationUtil.eObjectToString(tag));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void removeTag(SessionId sessionId, ProjectId projectId, PrimaryVersionSpec versionSpec, TagVersionSpec tag)
		throws EmfStoreException {
		RMIEmfStoreFacade facade = getConnectionProxy(sessionId);
		try {
			facade.removeTag(SerializationUtil.eObjectToString(sessionId),
				SerializationUtil.eObjectToString(projectId), SerializationUtil.eObjectToString(versionSpec),
				SerializationUtil.eObjectToString(tag));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Project getProject(SessionId sessionId, ProjectId projectId, VersionSpec versionSpec)
		throws EmfStoreException {
		try {
			return (Project) SerializationUtil.stringToEObject(getConnectionProxy(sessionId).getProject(
				SerializationUtil.eObjectToString(sessionId), SerializationUtil.eObjectToString(projectId),
				SerializationUtil.eObjectToString(versionSpec)));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ProjectInfo> getProjectList(SessionId sessionId) throws EmfStoreException {
		try {
			List<ProjectInfo> result = new ArrayList<ProjectInfo>();
			for (String str : getConnectionProxy(sessionId)
				.getProjectList(SerializationUtil.eObjectToString(sessionId))) {
				result.add((ProjectInfo) SerializationUtil.stringToEObject(str));
			}
			return result;
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public PrimaryVersionSpec resolveVersionSpec(SessionId sessionId, ProjectId projectId, VersionSpec versionSpec)
		throws EmfStoreException {
		try {
			return (PrimaryVersionSpec) SerializationUtil.stringToEObject(getConnectionProxy(sessionId)
				.resolveVersionSpec(SerializationUtil.eObjectToString(sessionId),
					SerializationUtil.eObjectToString(projectId), SerializationUtil.eObjectToString(versionSpec)));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectInfo createEmptyProject(SessionId sessionid, String name, String description, LogMessage logMessage)
		throws EmfStoreException {
		try {
			return (ProjectInfo) SerializationUtil.stringToEObject(getConnectionProxy(sessionid).createProject(
				SerializationUtil.eObjectToString(sessionid), name, description,
				SerializationUtil.eObjectToString(logMessage)));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectInfo createProject(SessionId sessionid, String name, String description, LogMessage logMessage,
		Project project) throws EmfStoreException {
		try {
			return (ProjectInfo) SerializationUtil.stringToEObject(getConnectionProxy(sessionid).createProject(
				SerializationUtil.eObjectToString(sessionid), name, description,
				SerializationUtil.eObjectToString(logMessage), SerializationUtil.eObjectToString(project)));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteProject(SessionId sessionId, ProjectId projectId, boolean deleteFiles) throws EmfStoreException {
		try {
			getConnectionProxy(sessionId).deleteProject(SerializationUtil.eObjectToString(sessionId),
				SerializationUtil.eObjectToString(projectId), deleteFiles);
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ACUser resolveUser(SessionId sessionId, ACOrgUnitId id) throws EmfStoreException {
		try {
			return (ACUser) SerializationUtil.stringToEObject(getConnectionProxy(sessionId).resolveUser(
				SerializationUtil.eObjectToString(sessionId), SerializationUtil.eObjectToString(id)));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectHistory exportProjectHistoryFromServer(SessionId sessionId, ProjectId projectId)
		throws EmfStoreException {
		try {
			return (ProjectHistory) SerializationUtil.stringToEObject(getConnectionProxy(sessionId)
				.exportProjectHistoryFromServer(SerializationUtil.eObjectToString(sessionId),
					SerializationUtil.eObjectToString(projectId)));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectId importProjectHistoryToServer(SessionId sessionId, ProjectHistory projectHistory)
		throws EmfStoreException {
		try {
			return (ProjectId) SerializationUtil.stringToEObject(getConnectionProxy(sessionId)
				.importProjectHistoryToServer(SerializationUtil.eObjectToString(sessionId),
					SerializationUtil.eObjectToString(projectHistory)));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public SessionId logIn(String username, String password, ServerInfo serverInfo, ClientVersionInfo clientVersionInfo)
		throws ConnectionException {

		Registry registry;
		try {
			registry = LocateRegistry.getRegistry(serverInfo.getUrl(), serverInfo.getPort());
			RMIEmfStoreFacade facade = (RMIEmfStoreFacade) registry.lookup(RMIConnectionHandler.RMI_NAME);
			SessionId sessionId = (SessionId) SerializationUtil.stringToEObject(facade.login(username, password,
				SerializationUtil.eObjectToString(serverInfo), SerializationUtil.eObjectToString(clientVersionInfo)));
			addConnectionProxy(sessionId, facade);
			return sessionId;
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		} catch (NotBoundException e) {
			throw new ConnectionException("RMI Registry not available.");
		} catch (RMISerializationException e) {
			throw new ConnectionException(UNSUPPORTED_ENCODING, e);
		} catch (ClientVersionOutOfDateException e) {
			throw new ConnectionException(INCOMPATIBLE_VERSION, e);
		} catch (AccessControlException e) {
			throw new ConnectionException(LOGIN_REFUSED, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void logout(SessionId sessionId) throws EmfStoreException {
		try {
			RMIEmfStoreFacade facade = getConnectionProxy(sessionId);
			facade.logout(SerializationUtil.eObjectToString(sessionId));
			removeConnectionProxy(sessionId);
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public FileTransferInformation uploadFileChunk(SessionId sessionId, ProjectId projectId, FileChunk fileChunk)
		throws EmfStoreException {
		RMIEmfStoreFacade facade = getConnectionProxy(sessionId);
		try {
			return facade.uploadFileChunk(SerializationUtil.eObjectToString(sessionId),
				SerializationUtil.eObjectToString(projectId), fileChunk);
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public FileChunk downloadFileChunk(SessionId sessionId, ProjectId projectId, FileTransferInformation fileInformation)
		throws EmfStoreException, ConnectionException {
		RMIEmfStoreFacade facade = getConnectionProxy(sessionId);
		try {
			return facade.downloadFileChunk(SerializationUtil.eObjectToString(sessionId),
				SerializationUtil.eObjectToString(projectId), fileInformation);
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void transmitProperty(SessionId sessionId, OrgUnitProperty changedProperty, ACUser user, ProjectId projectId)
		throws EmfStoreException, ConnectionException {
		RMIEmfStoreFacade facade = getConnectionProxy(sessionId);
		try {
			facade.transmitProperty(SerializationUtil.eObjectToString(sessionId),
				SerializationUtil.eObjectToString(changedProperty), SerializationUtil.eObjectToString(user),
				SerializationUtil.eObjectToString(projectId));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}
}
