/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
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
 * @author Wesendonk
 */
@SuppressWarnings("serial")
public class RMIAdminEmfStoreFacadeImpl extends AbstractUnicaseRMIFacade implements RMIAdminEmfStoreFacade {

	private AdminEmfStore adminEmfStore;

	/**
	 * Default constructor.
	 * 
	 * @param adminEmfStore the {@link AdminEmfStore}
	 * @param accessControl the {@link AuthenticationControl}
	 * @throws RemoteException thrown if there are rmi-related problems
	 * @throws FatalEmfStoreException exception within the server
	 */
	public RMIAdminEmfStoreFacadeImpl(AdminEmfStore adminEmfStore, AuthenticationControl accessControl)
		throws RemoteException, FatalEmfStoreException {
		super(1097);
		this.adminEmfStore = adminEmfStore;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addParticipant(String sessionId, String projectId, String participant) throws RemoteException,
		EmfStoreException {
		adminEmfStore.addParticipant((SessionId) SerializationUtil.stringToEObject(sessionId),
			(ProjectId) SerializationUtil.stringToEObject(projectId), (ACOrgUnitId) SerializationUtil
				.stringToEObject(participant));

	}

	/**
	 * {@inheritDoc}
	 */
	public void changeRole(String sessionId, String projectId, String orgUnit, String eClass) throws RemoteException,
		EmfStoreException {
		adminEmfStore.changeRole((SessionId) SerializationUtil.stringToEObject(sessionId),
			(ProjectId) SerializationUtil.stringToEObject(projectId), (ACOrgUnitId) SerializationUtil
				.stringToEObject(orgUnit), (EClass) SerializationUtil.stringToEObject(eClass));

	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getGroups(String sessionId) throws RemoteException, EmfStoreException {
		List<String> result = new ArrayList<String>();
		for (ACGroup group : adminEmfStore.getGroups((SessionId) SerializationUtil.stringToEObject(sessionId))) {
			result.add(SerializationUtil.eObjectToString(group));
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getGroups(String sessionId, String user) throws RemoteException, EmfStoreException {
		List<String> result = new ArrayList<String>();
		for (ACGroup group : adminEmfStore.getGroups((SessionId) SerializationUtil.stringToEObject(sessionId),
			(ACOrgUnitId) SerializationUtil.stringToEObject(user))) {
			result.add(SerializationUtil.eObjectToString(group));
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getOrgUnits(String sessionId) throws RemoteException, EmfStoreException {
		List<String> result = new ArrayList<String>();
		for (ACOrgUnit orgUnit : adminEmfStore.getOrgUnits((SessionId) SerializationUtil.stringToEObject(sessionId))) {
			result.add(SerializationUtil.eObjectToString(orgUnit));
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getParticipants(String sessionId, String projectId) throws RemoteException, EmfStoreException {
		List<String> result = new ArrayList<String>();
		for (ACOrgUnit orgUnit : adminEmfStore.getParticipants(
			(SessionId) SerializationUtil.stringToEObject(sessionId), (ProjectId) SerializationUtil
				.stringToEObject(projectId))) {
			result.add(SerializationUtil.eObjectToString(orgUnit));
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getMembers(String sessionId, String groupId) throws RemoteException, EmfStoreException {

		List<String> result = new ArrayList<String>();
		for (ACOrgUnit orgUnit : adminEmfStore.getMembers((SessionId) SerializationUtil.stringToEObject(sessionId),
			(ACOrgUnitId) SerializationUtil.stringToEObject(groupId))) {
			result.add(SerializationUtil.eObjectToString(orgUnit));
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getProjectInfos(String sessionId) throws RemoteException, EmfStoreException {
		List<String> result = new ArrayList<String>();
		for (ProjectInfo projectInfo : adminEmfStore.getProjectInfos((SessionId) SerializationUtil
			.stringToEObject(sessionId))) {
			result.add(SerializationUtil.eObjectToString(projectInfo));
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getRole(String sessionId, String projectId, String orgUnit) throws RemoteException, EmfStoreException {
		return SerializationUtil.eObjectToString(adminEmfStore.getRole((SessionId) SerializationUtil
			.stringToEObject(sessionId), (ProjectId) SerializationUtil.stringToEObject(projectId),
			(ACOrgUnitId) SerializationUtil.stringToEObject(orgUnit)));
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getUsers(String sessionId) throws RemoteException, EmfStoreException {
		List<String> result = new ArrayList<String>();
		for (ACUser user : adminEmfStore.getUsers((SessionId) SerializationUtil.stringToEObject(sessionId))) {
			result.add(SerializationUtil.eObjectToString(user));
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeGroup(String sessionId, String user, String group) throws RemoteException, EmfStoreException {
		adminEmfStore.removeGroup((SessionId) SerializationUtil.stringToEObject(sessionId),
			(ACOrgUnitId) SerializationUtil.stringToEObject(user), (ACOrgUnitId) SerializationUtil
				.stringToEObject(group));
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeParticipant(String sessionId, String projectId, String participant) throws RemoteException,
		EmfStoreException {
		adminEmfStore.removeParticipant((SessionId) SerializationUtil.stringToEObject(sessionId),
			(ProjectId) SerializationUtil.stringToEObject(projectId), (ACOrgUnitId) SerializationUtil
				.stringToEObject(participant));
	}

	/**
	 * {@inheritDoc}
	 */
	public String createGroup(String sessionId, String name) throws RemoteException, EmfStoreException {
		return SerializationUtil.eObjectToString(adminEmfStore.createGroup((SessionId) SerializationUtil
			.stringToEObject(sessionId), name));
	}

	/**
	 * {@inheritDoc}
	 */
	public String createUser(String sessionId, String name) throws RemoteException, EmfStoreException {
		return SerializationUtil.eObjectToString(adminEmfStore.createUser((SessionId) SerializationUtil
			.stringToEObject(sessionId), name));
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteGroup(String sessionId, String id) throws RemoteException, EmfStoreException {
		adminEmfStore.deleteGroup((SessionId) SerializationUtil.stringToEObject(sessionId),
			(ACOrgUnitId) SerializationUtil.stringToEObject(id));
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteUser(String sessionId, String id) throws RemoteException, EmfStoreException {
		adminEmfStore.deleteUser((SessionId) SerializationUtil.stringToEObject(sessionId),
			(ACOrgUnitId) SerializationUtil.stringToEObject(id));
	}

	/**
	 * {@inheritDoc}
	 */
	public void addMember(String sessionId, String group, String member) throws RemoteException, EmfStoreException {
		adminEmfStore.addMember((SessionId) SerializationUtil.stringToEObject(sessionId),
			(ACOrgUnitId) SerializationUtil.stringToEObject(group), (ACOrgUnitId) SerializationUtil
				.stringToEObject(member));
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeMember(String sessionId, String group, String member) throws RemoteException, EmfStoreException {
		adminEmfStore.removeMember((SessionId) SerializationUtil.stringToEObject(sessionId),
			(ACOrgUnitId) SerializationUtil.stringToEObject(group), (ACOrgUnitId) SerializationUtil
				.stringToEObject(member));
	}

	/**
	 * {@inheritDoc}
	 */
	public void changeOrgUnit(String sessionId, String orgUnitId, String name, String description)
		throws RemoteException, EmfStoreException {
		adminEmfStore.changeOrgUnit((SessionId) SerializationUtil.stringToEObject(sessionId),
			(ACOrgUnitId) SerializationUtil.stringToEObject(orgUnitId), name, description);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getOrgUnit(String sessionId, String orgUnitId) throws RemoteException, EmfStoreException {
		return SerializationUtil.eObjectToString(adminEmfStore.getOrgUnit((SessionId) SerializationUtil
			.stringToEObject(sessionId), (ACOrgUnitId) SerializationUtil.stringToEObject(orgUnitId)));

	}

}
