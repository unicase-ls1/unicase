/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.connection.rmi;

import java.rmi.RemoteException;
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
import org.unicase.emfstore.exceptions.FatalEmfStoreException;

/**
 * 
 * @author Wesendonk
 */
@SuppressWarnings("serial")
public class RMIAdminEmfStoreFacadeImpl extends AbstractUnicaseRMIFacade
		implements RMIAdminEmfStoreFacade {

	private AdminEmfStore adminEmfStore;

	/**
	 * Default constructor.
	 * 
	 * @param adminEmfStore
	 *            the {@link AdminEmfStore}
	 * @param accessControl
	 *            the {@link AuthenticationControl}
	 * @throws RemoteException
	 *             thrown if there are rmi-related problems
	 * @throws FatalEmfStoreException
	 *             exception within the server
	 */
	public RMIAdminEmfStoreFacadeImpl(AdminEmfStore adminEmfStore,
			AuthenticationControl accessControl) throws RemoteException,
			FatalEmfStoreException {
		this.adminEmfStore = adminEmfStore;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addParticipant(String sessionId, String projectId,
			String participant) throws RemoteException, EmfStoreException {
		adminEmfStore.addParticipant((SessionId) RMIUtil
				.stringToEObject(sessionId), (ProjectId) RMIUtil
				.stringToEObject(projectId), (ACOrgUnitId) RMIUtil
				.stringToEObject(participant));

	}

	/**
	 * {@inheritDoc}
	 */
	public void changeRole(String sessionId, String projectId, String orgUnit,
			String eClass) throws RemoteException, EmfStoreException {
		adminEmfStore.changeRole(
				(SessionId) RMIUtil.stringToEObject(sessionId),
				(ProjectId) RMIUtil.stringToEObject(projectId),
				(ACOrgUnitId) RMIUtil.stringToEObject(orgUnit),
				(EClass) RMIUtil.stringToEObject(eClass));

	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getGroups(String sessionId) throws RemoteException,
			EmfStoreException {
		List<String> result = new ArrayList<String>();
		for (ACGroup group : adminEmfStore.getGroups((SessionId) RMIUtil
				.stringToEObject(sessionId))) {
			result.add(RMIUtil.eObjectToString(group));
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getGroups(String sessionId, String user)
			throws RemoteException, EmfStoreException {
		List<String> result = new ArrayList<String>();
		for (ACGroup group : adminEmfStore.getGroups((SessionId) RMIUtil
				.stringToEObject(sessionId), (ACOrgUnitId) RMIUtil
				.stringToEObject(user))) {
			result.add(RMIUtil.eObjectToString(group));
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getOrgUnits(String sessionId) throws RemoteException,
			EmfStoreException {
		List<String> result = new ArrayList<String>();
		for (ACOrgUnit orgUnit : adminEmfStore.getOrgUnits((SessionId) RMIUtil
				.stringToEObject(sessionId))) {
			result.add(RMIUtil.eObjectToString(orgUnit));
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getParticipants(String sessionId, String projectId)
			throws RemoteException, EmfStoreException {
		List<String> result = new ArrayList<String>();
		for (ACOrgUnit orgUnit : adminEmfStore.getParticipants(
				(SessionId) RMIUtil.stringToEObject(sessionId),
				(ProjectId) RMIUtil.stringToEObject(projectId))) {
			result.add(RMIUtil.eObjectToString(orgUnit));
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getMembers(String sessionId, String groupId)
			throws RemoteException, EmfStoreException {

		List<String> result = new ArrayList<String>();
		for (ACOrgUnit orgUnit : adminEmfStore.getMembers((SessionId) RMIUtil
				.stringToEObject(sessionId), (ACOrgUnitId) RMIUtil
				.stringToEObject(groupId))) {
			result.add(RMIUtil.eObjectToString(orgUnit));
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getProjectInfos(String sessionId)
			throws RemoteException, EmfStoreException {
		List<String> result = new ArrayList<String>();
		for (ProjectInfo projectInfo : adminEmfStore
				.getProjectInfos((SessionId) RMIUtil.stringToEObject(sessionId))) {
			result.add(RMIUtil.eObjectToString(projectInfo));
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getRole(String sessionId, String projectId, String orgUnit)
			throws RemoteException, EmfStoreException {
		return RMIUtil.eObjectToString(adminEmfStore.getRole(
				(SessionId) RMIUtil.stringToEObject(sessionId),
				(ProjectId) RMIUtil.stringToEObject(projectId),
				(ACOrgUnitId) RMIUtil.stringToEObject(orgUnit)));
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getUsers(String sessionId) throws RemoteException,
			EmfStoreException {
		List<String> result = new ArrayList<String>();
		for (ACUser user : adminEmfStore.getUsers((SessionId) RMIUtil
				.stringToEObject(sessionId))) {
			result.add(RMIUtil.eObjectToString(user));
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeGroup(String sessionId, String user, String group)
			throws RemoteException, EmfStoreException {
		adminEmfStore.removeGroup((SessionId) RMIUtil
				.stringToEObject(sessionId), (ACOrgUnitId) RMIUtil
				.stringToEObject(user), (ACOrgUnitId) RMIUtil
				.stringToEObject(group));
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeParticipant(String sessionId, String projectId,
			String participant) throws RemoteException, EmfStoreException {
		adminEmfStore.removeParticipant((SessionId) RMIUtil
				.stringToEObject(sessionId), (ProjectId) RMIUtil
				.stringToEObject(projectId), (ACOrgUnitId) RMIUtil
				.stringToEObject(participant));
	}

	/**
	 * {@inheritDoc}
	 */
	public void createGroup(String sessionId, String name)
			throws RemoteException, EmfStoreException {
		adminEmfStore.createGroup((SessionId) RMIUtil
				.stringToEObject(sessionId), name);
	}

	/**
	 * {@inheritDoc}
	 */
	public void createUser(String sessionId, String name)
			throws RemoteException, EmfStoreException {
		adminEmfStore.createUser(
				(SessionId) RMIUtil.stringToEObject(sessionId), name);
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteGroup(String sessionId, String id)
			throws RemoteException, EmfStoreException {
		adminEmfStore.deleteGroup((SessionId) RMIUtil
				.stringToEObject(sessionId), (ACOrgUnitId) RMIUtil
				.stringToEObject(id));
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteUser(String sessionId, String id) throws RemoteException,
			EmfStoreException {
		adminEmfStore.deleteUser(
				(SessionId) RMIUtil.stringToEObject(sessionId),
				(ACOrgUnitId) RMIUtil.stringToEObject(id));
	}

	/**
	 * {@inheritDoc}
	 */
	public void addMember(String sessionId, String group, String member)
			throws RemoteException, EmfStoreException {
		adminEmfStore.addMember((SessionId) RMIUtil.stringToEObject(sessionId),
				(ACOrgUnitId) RMIUtil.stringToEObject(group),
				(ACOrgUnitId) RMIUtil.stringToEObject(member));
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeMember(String sessionId, String group, String member)
			throws RemoteException, EmfStoreException {
		adminEmfStore.removeMember((SessionId) RMIUtil
				.stringToEObject(sessionId), (ACOrgUnitId) RMIUtil
				.stringToEObject(group), (ACOrgUnitId) RMIUtil
				.stringToEObject(member));
	}

	/**
	 * {@inheritDoc}
	 */
	public void changeOrgUnit(String sessionId, String orgUnitId, String name,
			String description) throws RemoteException, EmfStoreException {
		adminEmfStore.changeOrgUnit((SessionId) RMIUtil
				.stringToEObject(sessionId), (ACOrgUnitId) RMIUtil
				.stringToEObject(orgUnitId), name, description);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getOrgUnit(String sessionId, String orgUnitId)
			throws RemoteException, EmfStoreException {
		return RMIUtil.eObjectToString(adminEmfStore.getOrgUnit(
				(SessionId) RMIUtil.stringToEObject(sessionId),
				(ACOrgUnitId) RMIUtil.stringToEObject(orgUnitId)));

	}

}
