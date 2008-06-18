/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
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
import org.unicase.emfstore.esmodel.changemanagment.ChangePackage;
import org.unicase.emfstore.esmodel.changemanagment.HistoryInfo;
import org.unicase.emfstore.esmodel.changemanagment.LogMessage;
import org.unicase.emfstore.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.changemanagment.VersionSpec;
import org.unicase.emfstore.exceptions.EmfStoreException;

/**
 * Implementation of a RMIEmfStoreFacade.
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

	/**
	 * Default constructor.
	 * @param emfStore the emf store
	 * @param authenticationControl the authentication controler
	 * @throws RemoteException if an RMI problem occurs
	 */
	public RMIEmfStoreFacadeImpl(EmfStore emfStore,
			AuthenticationControl authenticationControl) throws RemoteException {
		super();
		this.emfStore = emfStore;
		this.accessControl = authenticationControl;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade#createVersion(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public String createVersion(String sessionId, String projectId,
			String baseVersionSpec, String changePackage, String logMessage)
			throws RemoteException, EmfStoreException {
		LOGGER.debug("Client call on createRevision RECEIVED.");
		try {
			return RMIUtil.eObjectToString(emfStore.createVersion(
					(SessionId) RMIUtil.stringToEObject(sessionId),
					(ProjectId) RMIUtil.stringToEObject(projectId),
					(PrimaryVersionSpec) RMIUtil
							.stringToEObject(baseVersionSpec),
					(ChangePackage) RMIUtil.stringToEObject(changePackage),
					(LogMessage) RMIUtil.stringToEObject(logMessage)));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade#getChanges(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade#getHistoryInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
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
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade#getProject(java.lang.String, java.lang.String, java.lang.String)
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/** 
	 * {@inheritDoc}
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade#login(java.lang.String, java.lang.String, java.lang.String)
	 */
	public String login(String username, String password, String serverInfo)
			throws RemoteException, AccessControlException {
		LOGGER.debug("Client call on login RECEIVED.");
		try {
			return RMIUtil.eObjectToString(accessControl.logIn(username,
					password));
		} catch (IOException e) {
			throw new RemoteException();
		}
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade#resolveVersionSpec(java.lang.String, java.lang.String, java.lang.String)
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade#createProject(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade#sendString(java.lang.String)
	 */
	public void sendString(String str) throws RemoteException {
		System.out.println("....");
		System.out.println(str);
		System.out.println("....");
	}

}