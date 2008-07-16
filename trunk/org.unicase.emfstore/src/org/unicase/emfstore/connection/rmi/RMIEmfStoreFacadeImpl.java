/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.connection.rmi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.unicase.emfstore.EmfStore;
import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.emfstore.accesscontrol.AuthenticationControl;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.Project;

/**
 * Implementation of a RMIEmfStoreFacade.
 * 
 * @author koegel
 * 
 */
public class RMIEmfStoreFacadeImpl extends UnicastRemoteObject implements
		RMIEmfStoreFacade {

	private static final long serialVersionUID = -3245554287505036114L;

	private EmfStore emfStore;

	private AuthenticationControl accessControl;

	private static final Log LOGGER = LogFactory
			.getLog(RMIEmfStoreFacade.class);
	
	private static final String SERIALEX = "An exception occured while serializing the objects."; 

	/**
	 * Default constructor.
	 * 
	 * @param emfStore
	 *            the emf store
	 * @param authenticationControl
	 *            the authentication controler
	 * @throws RemoteException
	 *             if an RMI problem occurs
	 */
	public RMIEmfStoreFacadeImpl(EmfStore emfStore,
			AuthenticationControl authenticationControl) throws RemoteException {
		super();
		this.emfStore = emfStore;
		this.accessControl = authenticationControl;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade#createVersion(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String)
	 */
	public String createVersion(String sessionId, String projectId,
			String baseVersionSpec, String changePackage, String logMessage)
			throws RemoteException, EmfStoreException {
		LOGGER.debug("Client call on createRevision RECEIVED.");
		
		try {
			SessionId sessionIdObject = (SessionId) RMIUtil.stringToEObject(sessionId);
			ProjectId projectIdObject = (ProjectId) RMIUtil.stringToEObject(projectId);
			PrimaryVersionSpec primaryVersionSpec = (PrimaryVersionSpec) RMIUtil
					.stringToEObject(baseVersionSpec);
			ChangePackage changePackageObject = (ChangePackage) RMIUtil.stringToEObject(changePackage);
			
			return RMIUtil.eObjectToString(emfStore.createVersion(
					sessionIdObject,
					projectIdObject,
					primaryVersionSpec,
					changePackageObject,
					(LogMessage) RMIUtil.stringToEObject(logMessage)));
		} catch (UnsupportedEncodingException e) {
			throw new EmfStoreException(SERIALEX,e);
		} catch (IOException e) {
			throw new EmfStoreException(SERIALEX,e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade#getChanges(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<String> getChanges(String sessionId, String projectId,
			String source, String target) throws RemoteException,
			EmfStoreException {

		LOGGER.debug("Client call on getChanges RECEIVED.");
		try {
			List<String> result = new ArrayList<String>();
			for (ChangePackage cp : emfStore.getChanges((SessionId) RMIUtil
					.stringToEObject(sessionId), (ProjectId) RMIUtil
					.stringToEObject(projectId), (VersionSpec) RMIUtil
					.stringToEObject(source), (VersionSpec) RMIUtil
					.stringToEObject(target))) {

				result.add(RMIUtil.eObjectToString(cp));
			}
			return result;
		} catch (UnsupportedEncodingException e) {
			throw new EmfStoreException(SERIALEX,e);
		} catch (IOException e) {
			throw new EmfStoreException(SERIALEX,e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade#getHistoryInfo(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<String> getHistoryInfo(String sessionId, String projectId,
			String source, String target) throws RemoteException,
			EmfStoreException {
		LOGGER.debug("Client call on getHistoryInfo RECEIVED.");
		List<String> result = new ArrayList<String>();
		try {
			for (HistoryInfo info : emfStore.getHistoryInfo((SessionId) RMIUtil
					.stringToEObject(sessionId), (ProjectId) RMIUtil
					.stringToEObject(projectId), (VersionSpec) RMIUtil
					.stringToEObject(source), (VersionSpec) RMIUtil
					.stringToEObject(target))) {
				result.add(RMIUtil.eObjectToString(info));
			}
			return result;
		} catch (UnsupportedEncodingException e) {
			throw new EmfStoreException(SERIALEX,e);
		} catch (IOException e) {
			throw new EmfStoreException(SERIALEX,e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade#getProject(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	public String getProject(String sessionId, String projectId,
			String versionSpec) throws RemoteException, EmfStoreException {
		LOGGER.debug("Client call on getProject RECEIVED.");
		try {
			return RMIUtil.eObjectToString(emfStore.getProject(
					(SessionId) RMIUtil.stringToEObject(sessionId),
					(ProjectId) RMIUtil.stringToEObject(projectId),
					(VersionSpec) RMIUtil.stringToEObject(versionSpec)));
		} catch (UnsupportedEncodingException e) {
			throw new EmfStoreException(SERIALEX,e);
		} catch (IOException e) {
			throw new EmfStoreException(SERIALEX,e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade#getProjectList(java.lang.String)
	 */
	public List<String> getProjectList(String sessionId)
			throws RemoteException, EmfStoreException {
		LOGGER.debug("Client call on getProjectList RECEIVED.");
		try {
			List<String> result = new ArrayList<String>();
			for (ProjectInfo pi : emfStore.getProjectList((SessionId) RMIUtil
					.stringToEObject(sessionId))) {
				result.add(RMIUtil.eObjectToString(pi));
			}
			return result;
		} catch (UnsupportedEncodingException e) {
			throw new EmfStoreException(SERIALEX,e);
		} catch (IOException e) {
			throw new EmfStoreException(SERIALEX,e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade#login(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	public String login(String username, String password, String serverInfo)
			throws RemoteException, AccessControlException {
		LOGGER.debug("Client call on login RECEIVED.");
		try {
			return RMIUtil.eObjectToString(accessControl.logIn(username,
					password));
		} catch (IOException e) {
			throw new AccessControlException(SERIALEX);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade#resolveVersionSpec(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	public String resolveVersionSpec(String sessionId, String projectId,
			String versionSpec) throws RemoteException, EmfStoreException {
		LOGGER.debug("Client call on resolveVersionSpec RECEIVED.");
		try {
			return RMIUtil.eObjectToString(emfStore.resolveVersionSpec(
					(SessionId) RMIUtil.stringToEObject(sessionId),
					(ProjectId) RMIUtil.stringToEObject(projectId),
					(VersionSpec) RMIUtil.stringToEObject(versionSpec)));
		} catch (UnsupportedEncodingException e) {
			throw new EmfStoreException(SERIALEX,e);
		} catch (IOException e) {
			throw new EmfStoreException(SERIALEX,e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade#createProject(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String)
	 */
	public String createProject(String sessionId, String name,
			String description, String logMessage) throws RemoteException,
			EmfStoreException {
		LOGGER.debug("Client call on createProject RECEIVED.");
		try {
			return RMIUtil.eObjectToString(emfStore.createProject(
					(SessionId) RMIUtil.stringToEObject(sessionId), name,
					description, (LogMessage) RMIUtil
							.stringToEObject(logMessage)));
		} catch (UnsupportedEncodingException e) {
			throw new EmfStoreException(SERIALEX,e);
		} catch (IOException e) {
			throw new EmfStoreException(SERIALEX,e);
		}
	}

	public String createProject(String sessionId, String name,
			String description, String logMessage, String project) throws EmfStoreException, RemoteException {
		LOGGER.debug("Client call on createProject RECEIVED.");
		try {
			return RMIUtil.eObjectToString(emfStore.createProject(
					(SessionId) RMIUtil.stringToEObject(sessionId), name,
					description, (LogMessage) RMIUtil
							.stringToEObject(logMessage), (Project) RMIUtil.stringToEObject(project)));
		} catch (UnsupportedEncodingException e) {
			throw new EmfStoreException(SERIALEX,e);
		} catch (IOException e) {
			throw new EmfStoreException(SERIALEX,e);
		}
	}
}