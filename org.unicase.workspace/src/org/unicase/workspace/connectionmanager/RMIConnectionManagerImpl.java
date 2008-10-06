/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
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

import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.emfstore.connection.rmi.RMIConnectionHandler;
import org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade;
import org.unicase.emfstore.connection.rmi.RMIUtil;
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
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.exceptions.ConnectionException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.SerializationException;
import org.unicase.emfstore.exceptions.UnknownSessionException;
import org.unicase.model.Project;
import org.unicase.workspace.ServerInfo;

/**
 * The RMIConnectionManager implements the {@link ConnectionManager} using the
 * RMI technology. Please notice that the EMF objects have to be serialized into
 * String via {@link RMIUtil} in order to avoid letting the EMF objects
 * implement the Serializable interface, which was discouraged from the EMF
 * newsgroup.
 * 
 * @author Wesendonk
 */
public class RMIConnectionManagerImpl implements ConnectionManager {

	private static final String UNSUPPORTED_ENCODING = "Problem with en/decoding.";

	private static final String REMOTE = "A rmi communication-related exception.";

	private Map<SessionId, RMIEmfStoreFacade> facadeMap;

	/**
	 * Default constructor.
	 */
	public RMIConnectionManagerImpl() {
		facadeMap = new HashMap<SessionId, RMIEmfStoreFacade>();
	}

	/**
	 * {@inheritDoc}
	 */
	public PrimaryVersionSpec createVersion(SessionId sessionId,
			ProjectId projectId, PrimaryVersionSpec baseVersionSpec,
			ChangePackage changePackage, LogMessage logMessage)
			throws EmfStoreException {

		try {

			return (PrimaryVersionSpec) RMIUtil.stringToEObject(getFacade(
					sessionId).createVersion(
					RMIUtil.eObjectToString(sessionId),
					RMIUtil.eObjectToString(projectId),
					RMIUtil.eObjectToString(baseVersionSpec),
					RMIUtil.eObjectToString(changePackage),
					RMIUtil.eObjectToString(logMessage)));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ChangePackage> getChanges(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws EmfStoreException {
		List<ChangePackage> result = new ArrayList<ChangePackage>();
		try {
			for (String changePackage : getFacade(sessionId).getChanges(
					RMIUtil.eObjectToString(sessionId),
					RMIUtil.eObjectToString(projectId),
					RMIUtil.eObjectToString(source),
					RMIUtil.eObjectToString(target))) {

				ChangePackage changePackageObject = (ChangePackage) RMIUtil
						.stringToEObject(changePackage);
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
	public List<HistoryInfo> getHistoryInfo(SessionId sessionId,
			ProjectId projectId, HistoryQuery historyQuery)
			throws EmfStoreException {
		RMIEmfStoreFacade facade = getFacade(sessionId);
		try {
			List<HistoryInfo> result = new ArrayList<HistoryInfo>();
			for (String str : facade.getHistoryInfo(RMIUtil
					.eObjectToString(sessionId), RMIUtil
					.eObjectToString(projectId), RMIUtil
					.eObjectToString(historyQuery))) {
				result.add((HistoryInfo) RMIUtil.stringToEObject(str));
			}
			return result;
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		} 
	}

	/**
	 * {@inheritDoc}
	 */
	public Project getProject(SessionId sessionId, ProjectId projectId,
			VersionSpec versionSpec) throws EmfStoreException {
		try {
			return (Project) RMIUtil.stringToEObject(getFacade(sessionId)
					.getProject(RMIUtil.eObjectToString(sessionId),
							RMIUtil.eObjectToString(projectId),
							RMIUtil.eObjectToString(versionSpec)));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ProjectInfo> getProjectList(SessionId sessionId)
			throws EmfStoreException {
		try {
			List<ProjectInfo> result = new ArrayList<ProjectInfo>();
			for (String str : getFacade(sessionId).getProjectList(
					RMIUtil.eObjectToString(sessionId))) {
				result.add((ProjectInfo) RMIUtil.stringToEObject(str));
			}
			return result;
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public PrimaryVersionSpec resolveVersionSpec(SessionId sessionId,
			ProjectId projectId, VersionSpec versionSpec)
			throws EmfStoreException {
		try {
			return (PrimaryVersionSpec) RMIUtil.stringToEObject(getFacade(
					sessionId).resolveVersionSpec(
					RMIUtil.eObjectToString(sessionId),
					RMIUtil.eObjectToString(projectId),
					RMIUtil.eObjectToString(versionSpec)));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectInfo createProject(SessionId sessionid, String name,
			String description, LogMessage logMessage) throws EmfStoreException {
		try {
			return (ProjectInfo) RMIUtil.stringToEObject(getFacade(sessionid)
					.createProject(RMIUtil.eObjectToString(sessionid), name,
							description, RMIUtil.eObjectToString(logMessage)));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectInfo createProject(SessionId sessionid, String name,
			String description, LogMessage logMessage, Project project)
			throws EmfStoreException {
		try {
			return (ProjectInfo) RMIUtil.stringToEObject(getFacade(sessionid)
					.createProject(RMIUtil.eObjectToString(sessionid), name,
							description, RMIUtil.eObjectToString(logMessage),
							RMIUtil.eObjectToString(project)));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ACUser resolveUser(SessionId sessionId, ACOrgUnitId id)
			throws EmfStoreException {
		try {
			return (ACUser) RMIUtil.stringToEObject(getFacade(
					sessionId).resolveUser(
					RMIUtil.eObjectToString(sessionId),
					RMIUtil.eObjectToString(id)));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public SessionId logIn(String username, String password,
			ServerInfo serverInfo) throws ConnectionException {

		Registry registry;
		try {
			registry = LocateRegistry.getRegistry(serverInfo.getUrl(),
					serverInfo.getPort());
			RMIEmfStoreFacade facade = (RMIEmfStoreFacade) registry
					.lookup(RMIConnectionHandler.RMI_NAME);
			SessionId sessionId = (SessionId) RMIUtil.stringToEObject(facade
					.login(username, password, RMIUtil
							.eObjectToString(serverInfo)));
			facadeMap.put(sessionId, facade);
			return sessionId;
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		} catch (NotBoundException e) {
			throw new ConnectionException("RMI Registry not available.");
		} catch (SerializationException e) {
			throw new ConnectionException(UNSUPPORTED_ENCODING, e);
		} catch (AccessControlException e) {
			throw new ConnectionException("Login refused.", e);
		}
	}

	private RMIEmfStoreFacade getFacade(SessionId sessionId)
			throws UnknownSessionException {
		RMIEmfStoreFacade facade = facadeMap.get(sessionId);
		if (facade == null) {
			throw new UnknownSessionException(
					"Session unkown to Connection manager, log in first!");
		}
		return facade;
	}

}
