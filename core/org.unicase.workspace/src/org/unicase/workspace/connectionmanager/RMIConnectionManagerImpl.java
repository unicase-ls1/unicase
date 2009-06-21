/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.connectionmanager;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.unicase.emfstore.connection.rmi.RMIConnectionHandler;
import org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade;
import org.unicase.emfstore.connection.rmi.SerializationUtil;
import org.unicase.emfstore.esmodel.ClientVersionInfo;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.HistoryQuery;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.TagVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.ClientVersionOutOfDateException;
import org.unicase.emfstore.exceptions.ConnectionException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.RMISerializationException;
import org.unicase.emfstore.exceptions.UnknownSessionException;
import org.unicase.emfstore.filetransfer.FileChunk;
import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.model.Project;
import org.unicase.workspace.ServerInfo;

/**
 * The RMIConnectionManager implements the {@link ConnectionManager} using the RMI technology. Please notice that the
 * EMF objects have to be serialized into String via {@link SerializationUtil} in order to avoid letting the EMF objects
 * implement the Serializable interface, which was discouraged from the EMF newsgroup.
 * 
 * @author Wesendonk
 */
public class RMIConnectionManagerImpl implements ConnectionManager {

	private static final String UNSUPPORTED_ENCODING = "Problem with en/decoding.";

	private static final String REMOTE = "Server could not be reached.";

	private Map<SessionId, RMIEmfStoreFacade> facadeMap;

	/**
	 * Default constructor.
	 */
	public RMIConnectionManagerImpl() {
		setFacadeMap(new HashMap<SessionId, RMIEmfStoreFacade>());
	}

	/**
	 * {@inheritDoc}
	 */
	public PrimaryVersionSpec createVersion(SessionId sessionId, ProjectId projectId,
		PrimaryVersionSpec baseVersionSpec, ChangePackage changePackage, LogMessage logMessage)
		throws EmfStoreException {

		try {

			return (PrimaryVersionSpec) SerializationUtil.stringToEObject(getFacade(sessionId).createVersion(
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
			for (String changePackage : getFacade(sessionId).getChanges(SerializationUtil.eObjectToString(sessionId),
				SerializationUtil.eObjectToString(projectId), SerializationUtil.eObjectToString(source),
				SerializationUtil.eObjectToString(target))) {

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
		RMIEmfStoreFacade facade = getFacade(sessionId);
		try {
			List<HistoryInfo> result = new ArrayList<HistoryInfo>();
			for (String str : facade.getHistoryInfo(SerializationUtil.eObjectToString(sessionId), SerializationUtil
				.eObjectToString(projectId), SerializationUtil.eObjectToString(historyQuery))) {
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
		RMIEmfStoreFacade facade = getFacade(sessionId);
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
		RMIEmfStoreFacade facade = getFacade(sessionId);
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
			return (Project) SerializationUtil.stringToEObject(getFacade(sessionId).getProject(
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
			for (String str : getFacade(sessionId).getProjectList(SerializationUtil.eObjectToString(sessionId))) {
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
			return (PrimaryVersionSpec) SerializationUtil.stringToEObject(getFacade(sessionId).resolveVersionSpec(
				SerializationUtil.eObjectToString(sessionId), SerializationUtil.eObjectToString(projectId),
				SerializationUtil.eObjectToString(versionSpec)));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectInfo createProject(SessionId sessionid, String name, String description, LogMessage logMessage)
		throws EmfStoreException {
		try {
			return (ProjectInfo) SerializationUtil.stringToEObject(getFacade(sessionid).createProject(
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
			return (ProjectInfo) SerializationUtil.stringToEObject(getFacade(sessionid).createProject(
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
			getFacade(sessionId).deleteProject(SerializationUtil.eObjectToString(sessionId),
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
			return (ACUser) SerializationUtil.stringToEObject(getFacade(sessionId).resolveUser(
				SerializationUtil.eObjectToString(sessionId), SerializationUtil.eObjectToString(id)));
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
			getFacadeMap().put(sessionId, facade);
			return sessionId;
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		} catch (NotBoundException e) {
			throw new ConnectionException("RMI Registry not available.");
		} catch (RMISerializationException e) {
			throw new ConnectionException(UNSUPPORTED_ENCODING, e);
		} catch (ClientVersionOutOfDateException e) {
			throw new ConnectionException("Client version not compatible with server. Please update your client.", e);
		} catch (AccessControlException e) {
			throw new ConnectionException("Login refused.", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void logout(SessionId sessionId) throws EmfStoreException {
		try {
			RMIEmfStoreFacade facade = getFacade(sessionId);
			facade.logout(SerializationUtil.eObjectToString(sessionId));
			facadeMap.remove(facade);
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * Returns the RMI facade for a given server, identified by the session id.
	 * 
	 * @param sessionId sessionid
	 * @return rmi facase
	 * @throws UnknownSessionException in case of failure
	 */
	protected RMIEmfStoreFacade getFacade(SessionId sessionId) throws UnknownSessionException {
		RMIEmfStoreFacade facade = getFacadeMap().get(sessionId);
		if (facade == null) {
			throw new UnknownSessionException("Session unkown to Connection manager, log in first!");
		}
		return facade;
	}

	/**
	 * {@inheritDoc}
	 */
	public FileInformation uploadFileChunk(SessionId sessionId, ProjectId projectId, FileChunk fileChunk)
		throws EmfStoreException {
		RMIEmfStoreFacade facade = getFacade(sessionId);
		try {
			return facade.uploadFileChunk(SerializationUtil.eObjectToString(sessionId), SerializationUtil
				.eObjectToString(projectId), fileChunk);
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public FileChunk downloadFileChunk(SessionId sessionId, ProjectId projectId, FileInformation fileInformation)
		throws EmfStoreException, ConnectionException {
		RMIEmfStoreFacade facade = getFacade(sessionId);
		try {
			return facade.downloadFileChunk(SerializationUtil.eObjectToString(sessionId), SerializationUtil
				.eObjectToString(projectId), fileInformation);
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	private void setFacadeMap(Map<SessionId, RMIEmfStoreFacade> facadeMap) {
		this.facadeMap = facadeMap;
	}

	/**
	 * Returns a map containing all active rmi facades.
	 * 
	 * @return map of facades.
	 */
	protected Map<SessionId, RMIEmfStoreFacade> getFacadeMap() {
		return facadeMap;
	}
}
