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

import org.eclipse.emf.ecore.EClass;
import org.unicase.emfstore.AdminEmfStore;
import org.unicase.emfstore.accesscontrol.AuthenticationControl;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.exceptions.EmfStoreException;

/**
 * 
 * @author Wesendonk
 */
public class RMIAdminEmfStoreFacadeImpl extends UnicastRemoteObject implements
		RMIAdminEmfStoreFacade {

	private AdminEmfStore adminEmfStore;

	private static final String SERIALEX = "An exception occured while serializing the objects.";

	/**
	 * Default constructor.
	 * 
	 * @param adminEmfStore
	 *            the {@link AdminEmfStore}
	 * @param accessControl
	 *            the {@link AuthenticationControl}
	 * @throws RemoteException
	 *             thrown if there are rmi-related problems
	 */
	public RMIAdminEmfStoreFacadeImpl(AdminEmfStore adminEmfStore,
			AuthenticationControl accessControl) throws RemoteException {
		this.adminEmfStore = adminEmfStore;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addGroup(String sessionId, String user, String group)
			throws RemoteException, EmfStoreException {
		try {
			adminEmfStore.addGroup((SessionId) RMIUtil
					.stringToEObject(sessionId), (ACUser) RMIUtil
					.stringToEObject(user), (ACOrgUnitId) RMIUtil
					.stringToEObject(group));
		} catch (UnsupportedEncodingException e) {
			throw new EmfStoreException(SERIALEX, e);
		} catch (IOException e) {
			throw new EmfStoreException(SERIALEX, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void addParticipant(String sessionId, String projectId,
			String participant) throws RemoteException, EmfStoreException {
		try {
			adminEmfStore.addParticipant((SessionId) RMIUtil
					.stringToEObject(sessionId), (ProjectId) RMIUtil
					.stringToEObject(projectId), (ACOrgUnitId) RMIUtil
					.stringToEObject(participant));
		} catch (UnsupportedEncodingException e) {
			throw new EmfStoreException(SERIALEX, e);
		} catch (IOException e) {
			throw new EmfStoreException(SERIALEX, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void changeRole(String sessionId, String projectId,
			String orgUnit, String eClass) throws RemoteException,
			EmfStoreException {
		try {
			adminEmfStore.changeRole((SessionId) RMIUtil
					.stringToEObject(sessionId), (ProjectId) RMIUtil
					.stringToEObject(projectId), (ACOrgUnitId) RMIUtil
					.stringToEObject(orgUnit), (EClass) RMIUtil
					.stringToEObject(eClass));
		} catch (UnsupportedEncodingException e) {
			throw new EmfStoreException(SERIALEX, e);
		} catch (IOException e) {
			throw new EmfStoreException(SERIALEX, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getGroups(String sessionId) throws RemoteException,
			EmfStoreException {
		try {
			List<String> result = new ArrayList<String>();
			for (ACGroup group : adminEmfStore.getGroups((SessionId) RMIUtil
					.stringToEObject(sessionId))) {
				result.add(RMIUtil.eObjectToString(group));
			}
			return result;
		} catch (UnsupportedEncodingException e) {
			throw new EmfStoreException(SERIALEX, e);
		} catch (IOException e) {
			throw new EmfStoreException(SERIALEX, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getGroups(String sessionId, String user)
			throws RemoteException, EmfStoreException {
		try {
			List<String> result = new ArrayList<String>();
			for (ACGroup group : adminEmfStore.getGroups((SessionId) RMIUtil
					.stringToEObject(sessionId), (ACOrgUnitId) RMIUtil
					.stringToEObject(user))) {
				result.add(RMIUtil.eObjectToString(group));
			}
			return result;
		} catch (UnsupportedEncodingException e) {
			throw new EmfStoreException(SERIALEX, e);
		} catch (IOException e) {
			throw new EmfStoreException(SERIALEX, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getOrgUnits(String sessionId) throws RemoteException,
			EmfStoreException {
		try {
			List<String> result = new ArrayList<String>();
			for (ACOrgUnit orgUnit : adminEmfStore
					.getOrgUnits((SessionId) RMIUtil.stringToEObject(sessionId))) {
				result.add(RMIUtil.eObjectToString(orgUnit));
			}
			return result;
		} catch (UnsupportedEncodingException e) {
			throw new EmfStoreException(SERIALEX, e);
		} catch (IOException e) {
			throw new EmfStoreException(SERIALEX, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getParticipants(String sessionId, String projectId)
			throws RemoteException, EmfStoreException {
		try {
			List<String> result = new ArrayList<String>();
			for (ACOrgUnit orgUnit : adminEmfStore.getParticipants(
					(SessionId) RMIUtil.stringToEObject(sessionId),
					(ProjectId) RMIUtil.stringToEObject(projectId))) {
				result.add(RMIUtil.eObjectToString(orgUnit));
			}
			return result;
		} catch (UnsupportedEncodingException e) {
			throw new EmfStoreException(SERIALEX, e);
		} catch (IOException e) {
			throw new EmfStoreException(SERIALEX, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getProjectInfos(String sessionId)
			throws RemoteException, EmfStoreException {
		try {
			List<String> result = new ArrayList<String>();
			for (ProjectInfo projectInfo : adminEmfStore
					.getProjectInfos((SessionId) RMIUtil
							.stringToEObject(sessionId))) {
				result.add(RMIUtil.eObjectToString(projectInfo));
			}
			return result;
		} catch (UnsupportedEncodingException e) {
			throw new EmfStoreException(SERIALEX, e);
		} catch (IOException e) {
			throw new EmfStoreException(SERIALEX, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String getRole(String sessionId, String projectId, String orgUnit)
			throws RemoteException, EmfStoreException {
		try {
			return RMIUtil.eObjectToString(adminEmfStore.getRole(
					(SessionId) RMIUtil.stringToEObject(sessionId),
					(ProjectId) RMIUtil.stringToEObject(projectId),
					(ACOrgUnitId) RMIUtil.stringToEObject(orgUnit)));
		} catch (UnsupportedEncodingException e) {
			throw new EmfStoreException(SERIALEX, e);
		} catch (IOException e) {
			throw new EmfStoreException(SERIALEX, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getUsers(String sessionId) throws RemoteException,
			EmfStoreException {
		try {
			List<String> result = new ArrayList<String>();
			for (ACUser user : adminEmfStore.getUsers((SessionId) RMIUtil
					.stringToEObject(sessionId))) {
				result.add(RMIUtil.eObjectToString(user));
			}
			return result;
		} catch (UnsupportedEncodingException e) {
			throw new EmfStoreException(SERIALEX, e);
		} catch (IOException e) {
			throw new EmfStoreException(SERIALEX, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeGroup(String sessionId, String user, String group)
			throws RemoteException, EmfStoreException {
		try {
			adminEmfStore.removeGroup((SessionId) RMIUtil
					.stringToEObject(sessionId), (ACOrgUnitId) RMIUtil
					.stringToEObject(user), (ACOrgUnitId) RMIUtil
					.stringToEObject(group));
		} catch (UnsupportedEncodingException e) {
			throw new EmfStoreException(SERIALEX, e);
		} catch (IOException e) {
			throw new EmfStoreException(SERIALEX, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeParticipant(String sessionId, String projectId,
			String participant) throws RemoteException, EmfStoreException {
		try {
			adminEmfStore.removeParticipant((SessionId) RMIUtil
					.stringToEObject(sessionId), (ProjectId) RMIUtil
					.stringToEObject(projectId), (ACOrgUnitId) RMIUtil
					.stringToEObject(participant));
		} catch (UnsupportedEncodingException e) {
			throw new EmfStoreException(SERIALEX, e);
		} catch (IOException e) {
			throw new EmfStoreException(SERIALEX, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void createGroup(String sessionId, String name)
			throws RemoteException, EmfStoreException {
		try {
			adminEmfStore.createGroup((SessionId) RMIUtil
					.stringToEObject(sessionId), name);
		} catch (UnsupportedEncodingException e) {
			throw new EmfStoreException(SERIALEX, e);
		} catch (IOException e) {
			throw new EmfStoreException(SERIALEX, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void createUser(String sessionId, String name)
			throws RemoteException, EmfStoreException {
		try {
			adminEmfStore.createUser((SessionId) RMIUtil
					.stringToEObject(sessionId), name);
		} catch (UnsupportedEncodingException e) {
			throw new EmfStoreException(SERIALEX, e);
		} catch (IOException e) {
			throw new EmfStoreException(SERIALEX, e);
		}
		
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteGroup(String sessionId, String id)
			throws RemoteException, EmfStoreException {
		try {
			adminEmfStore.deleteGroup((SessionId) RMIUtil
					.stringToEObject(sessionId), (ACOrgUnitId) RMIUtil.stringToEObject(id));
		} catch (UnsupportedEncodingException e) {
			throw new EmfStoreException(SERIALEX, e);
		} catch (IOException e) {
			throw new EmfStoreException(SERIALEX, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteUser(String sessionId, String id) throws RemoteException,
			EmfStoreException {
		try {
			adminEmfStore.deleteUser((SessionId) RMIUtil
					.stringToEObject(sessionId), (ACOrgUnitId) RMIUtil.stringToEObject(id));
		} catch (UnsupportedEncodingException e) {
			throw new EmfStoreException(SERIALEX, e);
		} catch (IOException e) {
			throw new EmfStoreException(SERIALEX, e);
		}
	}

}
