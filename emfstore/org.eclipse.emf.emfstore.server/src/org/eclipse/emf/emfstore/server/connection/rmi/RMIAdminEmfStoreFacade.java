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
package org.eclipse.emf.emfstore.server.connection.rmi;

// BEGIN IGNORE UNNECCESSARY IMPORT
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.eclipse.emf.emfstore.server.AdminEmfStore;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;

// END IGNORE UNNECCESSARY IMPORT
/**
 * Facade for AdminEmfstore interface for rmi transport layer.
 * 
 * @author Wesendonk
 */
public interface RMIAdminEmfStoreFacade extends Remote {

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#getProjectInfos(org.eclipse.emf.emfstore.server.model.SessionId)
	 * @param sessionId the session id
	 * @return list of projects
	 * @throws RemoteException transport related exception
	 * @throws EmfStoreException if an error in the EmfStore occurs
	 */
	List<String> getProjectInfos(String sessionId) throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#getGroups(org.eclipse.emf.emfstore.server.model.SessionId)
	 * @param sessionId the session id
	 * @return list of groups
	 * @throws RemoteException transport related exception
	 * @throws EmfStoreException if an error in the EmfStore occurs
	 */
	List<String> getGroups(String sessionId) throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#getUsers(org.eclipse.emf.emfstore.server.model.SessionId)
	 * @param sessionid the session id
	 * @return list of user
	 * @throws RemoteException transport related exception
	 * @throws EmfStoreException if an error in the EmfStore occurs
	 */
	List<String> getUsers(String sessionid) throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#getOrgUnits(org.eclipse.emf.emfstore.server.model.SessionId)
	 * @param sessionId the session id
	 * @return list of orgUnits
	 * @throws RemoteException transport related exception
	 * @throws EmfStoreException if an error in the EmfStore occurs
	 */
	List<String> getOrgUnits(String sessionId) throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#getGroups(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId)
	 * @param sessionId the session id
	 * @param user the user
	 * @return list of groups
	 * @throws RemoteException transport related exception
	 * @throws EmfStoreException if an error in the EmfStore occurs
	 */
	List<String> getGroups(String sessionId, String user) throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#removeGroup(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId,
	 *      org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId)
	 * @param sessionId the session id
	 * @param user the user
	 * @param group the group
	 * @throws RemoteException transport related exception
	 * @throws EmfStoreException if an error in the EmfStore occurs
	 */
	void removeGroup(String sessionId, String user, String group) throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#getParticipants(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.ProjectId)
	 * @param sessionId the session id
	 * @param projectId the project id
	 * @return list of orgUnits
	 * @throws RemoteException transport related exception
	 * @throws EmfStoreException if an error in the EmfStore occurs
	 */
	List<String> getParticipants(String sessionId, String projectId) throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#addParticipant(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.ProjectId,
	 *      org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId)
	 * @param sessionId the session id
	 * @param projectId the project id
	 * @param participant the orgUnit
	 * @throws RemoteException transport related exception
	 * @throws EmfStoreException if an error in the EmfStore occurs
	 */
	void addParticipant(String sessionId, String projectId, String participant) throws RemoteException,
		EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#removeParticipant(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.ProjectId,
	 *      org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId)
	 * @param sessionId the session id
	 * @param projectId the project id
	 * @param participant the orgUnit
	 * @throws RemoteException transport related exception
	 * @throws EmfStoreException if an error in the EmfStore occurs
	 */
	void removeParticipant(String sessionId, String projectId, String participant) throws RemoteException,
		EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#getRole(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.ProjectId,
	 *      org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId)
	 * @param sessionId the session id
	 * @param projectId the project id
	 * @param orgUnitId the orgUnit id
	 * @return the role
	 * @throws RemoteException transport related exception
	 * @throws EmfStoreException if an error in the EmfStore occurs
	 */
	String getRole(String sessionId, String projectId, String orgUnitId) throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#changeRole(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.ProjectId,
	 *      org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId, org.eclipse.emf.ecore.EClass)
	 * @param sessionId the session id
	 * @param projectId the project id
	 * @param orgUnitId the orgUnit id
	 * @param eClass the new role
	 * @throws RemoteException transport related exception
	 * @throws EmfStoreException if an error in the EmfStore occurs
	 */
	void changeRole(String sessionId, String projectId, String orgUnitId, String eClass) throws RemoteException,
		EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#createGroup(org.eclipse.emf.emfstore.server.model.SessionId, String)
	 * @param sessionId the session id
	 * @param name the name
	 * @return String id of created user
	 * @throws RemoteException transport related exception
	 * @throws EmfStoreException if an error in the EmfStore occurs
	 */
	String createGroup(String sessionId, String name) throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#deleteGroup(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId)
	 * @param sessionId the session id
	 * @param id the orgUnit id
	 * @throws RemoteException transport related exception
	 * @throws EmfStoreException if an error in the EmfStore occurs
	 */
	void deleteGroup(String sessionId, String id) throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#createUser(org.eclipse.emf.emfstore.server.model.SessionId, String)e
	 * @param sessionId the session id
	 * @param name the name
	 * @return String
	 * @throws RemoteException transport related exception
	 * @throws EmfStoreException if an error in the EmfStore occurs
	 */
	String createUser(String sessionId, String name) throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#deleteUser(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId)
	 * @param sessionId the session id
	 * @param id the orgUnit id
	 * @throws RemoteException transport related exception
	 * @throws EmfStoreException if an error in the EmfStore occurs
	 */
	void deleteUser(String sessionId, String id) throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#getMembers(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId)
	 * @param sessionId the sessionId
	 * @param groupId the group Id
	 * @return list of member
	 * @throws RemoteException transport related exception
	 * @throws EmfStoreException if an error in the EmfStore occurs
	 */
	List<String> getMembers(String sessionId, String groupId) throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#addMember(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId,
	 *      org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId)
	 * @param sessionId the session id
	 * @param group the group id
	 * @param member the user id
	 * @throws RemoteException transport related exception
	 * @throws EmfStoreException if an error in the EmfStore occurs
	 */
	void addMember(String sessionId, String group, String member) throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#removeMember(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId,
	 *      org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId)
	 * @param sessionId the session id
	 * @param group the group id
	 * @param member the member id
	 * @throws RemoteException transport related exception
	 * @throws EmfStoreException if an error in the EmfStore occurs
	 */
	void removeMember(String sessionId, String group, String member) throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#changeOrgUnit(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId, String, String)
	 * @param sessionId the session i d
	 * @param orgUnitId the orgUnit id
	 * @param name the name
	 * @param description the description
	 * @throws RemoteException transport related exception
	 * @throws EmfStoreException if an error in the EmfStore occurs
	 */
	void changeOrgUnit(String sessionId, String orgUnitId, String name, String description) throws RemoteException,
		EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#getOrgUnit(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId)
	 * @param sessionId the session id
	 * @param orgUnitId the orgUnit id
	 * @return an orgUnit
	 * @throws RemoteException transport related exception
	 * @throws EmfStoreException if an error in the EmfStore occurs
	 */
	String getOrgUnit(String sessionId, String orgUnitId) throws RemoteException, EmfStoreException;
}
