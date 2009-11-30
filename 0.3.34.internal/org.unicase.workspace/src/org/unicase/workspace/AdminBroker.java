/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;
import org.unicase.emfstore.exceptions.EmfStoreException;

/**
 * Interface for administrative services of the EMFStore. The Adminbroker delegates the method calls to the server (
 * {@link org.unicase.emfstore.AdminEmfStore}) via {@link org.unicase.emfstore.AdminConnectionManager}.
 * 
 * @author Hodaie
 * @author Wesendonk
 */
public interface AdminBroker {

	/**
	 * Delegates call to method in {@link org.unicase.emfstore.AdminEmfStore}.
	 * 
	 * @see org.unicase.emfstore.AdminEmfStore#getProjectInfos(org.unicase.emfstore.esmodel.SessionId)
	 * @return list of project infos
	 * @throws EmfStoreException if an exceptions occurs on the server or on transport
	 */
	List<ProjectInfo> getProjectInfos() throws EmfStoreException;

	/**
	 * Delegates call to method in {@link org.unicase.emfstore.AdminEmfStore}.
	 * 
	 * @see org.unicase.emfstore.AdminEmfStore#getGroups(org.unicase.emfstore.esmodel.SessionId)
	 * @return list of groups
	 * @throws EmfStoreException if an exceptions occurs on the server or on transport
	 */
	List<ACGroup> getGroups() throws EmfStoreException;

	/**
	 * Delegates call to method in {@link org.unicase.emfstore.AdminEmfStore}.
	 * 
	 * @see org.unicase.emfstore.AdminEmfStore#getUsers(org.unicase.emfstore.esmodel.SessionId)
	 * @return list of users
	 * @throws EmfStoreException if an exceptions occurs on the server or on transport
	 */
	List<ACUser> getUsers() throws EmfStoreException;

	/**
	 * Delegates call to method in {@link org.unicase.emfstore.AdminEmfStore}.
	 * {@link org.unicase.emfstore.AdminEmfStore#getOrgUnits(org.unicase.emfstore.esmodel.SessionId)}
	 * 
	 * @return list of orgUnits
	 * @throws EmfStoreException if an exceptions occurs on the server or on transport
	 */
	List<ACOrgUnit> getOrgUnits() throws EmfStoreException;

	/**
	 * Delegates call to method in {@link org.unicase.emfstore.AdminEmfStore}.
	 * 
	 * @see org.unicase.emfstore.AdminEmfStore#createGroup(org.unicase.emfstore.esmodel.SessionId, String)
	 * @param name new name
	 * @return ACOrgUnitId
	 * @throws EmfStoreException if an exceptions occurs on the server or on transport
	 */
	ACOrgUnitId createGroup(String name) throws EmfStoreException;

	/**
	 * Delegates call to method in {@link org.unicase.emfstore.AdminEmfStore}.
	 * 
	 * @see org.unicase.emfstore.AdminEmfStore#deleteGroup(org.unicase.emfstore.esmodel.SessionId, ACOrgUnitId)
	 * @param group orgUnit id
	 * @throws EmfStoreException if an exceptions occurs on the server or on transport
	 */
	void deleteGroup(ACOrgUnitId group) throws EmfStoreException;

	/**
	 * Delegates call to method in {@link org.unicase.emfstore.AdminEmfStore}.
	 * 
	 * @see org.unicase.emfstore.AdminEmfStore#getGroups(org.unicase.emfstore.esmodel.SessionId, ACOrgUnitId)
	 * @param user orgUnit id
	 * @return list of groups
	 * @throws EmfStoreException if an exceptions occurs on the server or on transport
	 */
	List<ACGroup> getGroups(ACOrgUnitId user) throws EmfStoreException;

	/**
	 * Delegates call to method in {@link org.unicase.emfstore.AdminEmfStore}.
	 * 
	 * @see org.unicase.emfstore.AdminEmfStore#removeGroup(org.unicase.emfstore.esmodel.SessionId, ACOrgUnitId,
	 *      ACOrgUnitId)
	 * @param user orgUnit id
	 * @param group group id
	 * @throws EmfStoreException if an exceptions occurs on the server or on transport
	 */
	void removeGroup(ACOrgUnitId user, ACOrgUnitId group) throws EmfStoreException;

	/**
	 * Delegates call to method in {@link org.unicase.emfstore.AdminEmfStore}.
	 * 
	 * @see org.unicase.emfstore.AdminEmfStore#createUser(org.unicase.emfstore.esmodel.SessionId, String)
	 * @param name user's name
	 * @return ACOrgUnitId
	 * @throws EmfStoreException if an exceptions occurs on the server or on transport
	 */
	ACOrgUnitId createUser(String name) throws EmfStoreException;

	/**
	 * Delegates call to method in {@link org.unicase.emfstore.AdminEmfStore}.
	 * 
	 * @see org.unicase.emfstore.AdminEmfStore#deleteUser(org.unicase.emfstore.esmodel.SessionId, ACOrgUnitId)
	 * @param user user id
	 * @throws EmfStoreException if an exceptions occurs on the server or on transport
	 */
	void deleteUser(ACOrgUnitId user) throws EmfStoreException;

	/**
	 * Delegates call to method in {@link org.unicase.emfstore.AdminEmfStore}.
	 * 
	 * @see org.unicase.emfstore.AdminEmfStore#getMembers(org.unicase.emfstore.esmodel.SessionId, ACOrgUnitId)
	 * @param groupId group id
	 * @return list of members
	 * @throws EmfStoreException if an exceptions occurs on the server or on transport
	 */
	List<ACOrgUnit> getMembers(ACOrgUnitId groupId) throws EmfStoreException;

	/**
	 * Delegates call to method in {@link org.unicase.emfstore.AdminEmfStore}.
	 * 
	 * @see org.unicase.emfstore.AdminEmfStore#getOrgUnit(org.unicase.emfstore.esmodel.SessionId, ACOrgUnitId)
	 * @param orgUnitId orgUnit id
	 * @return orgUnit
	 * @throws EmfStoreException if an exceptions occurs on the server or on transport
	 */
	ACOrgUnit getOrgUnit(ACOrgUnitId orgUnitId) throws EmfStoreException;

	/**
	 * Delegates call to method in {@link org.unicase.emfstore.AdminEmfStore}.
	 * 
	 * @see org.unicase.emfstore.AdminEmfStore#addMember(org.unicase.emfstore.esmodel.SessionId, ACOrgUnitId,
	 *      ACOrgUnitId)
	 * @param group group id
	 * @param member member id
	 * @throws EmfStoreException if an exceptions occurs on the server or on transport
	 */
	void addMember(ACOrgUnitId group, ACOrgUnitId member) throws EmfStoreException;

	/**
	 * Delegates call to method in {@link org.unicase.emfstore.AdminEmfStore}.
	 * 
	 * @see org.unicase.emfstore.AdminEmfStore#removeMember(org.unicase.emfstore.esmodel.SessionId, ACOrgUnitId,
	 *      ACOrgUnitId)
	 * @param group group id
	 * @param member member id
	 * @throws EmfStoreException if an exceptions occurs on the server or on transport
	 */
	void removeMember(ACOrgUnitId group, ACOrgUnitId member) throws EmfStoreException;

	/**
	 * Delegates call to method in {@link org.unicase.emfstore.AdminEmfStore}.
	 * 
	 * @see org.unicase.emfstore.AdminEmfStore#changeOrgUnit(org.unicase.emfstore.esmodel.SessionId, ACOrgUnitId,
	 *      String, String)
	 * @param orgUnitId orgUnit id
	 * @param name new name
	 * @param description new description
	 * @throws EmfStoreException if an exceptions occurs on the server or on transport
	 */
	void changeOrgUnit(ACOrgUnitId orgUnitId, String name, String description) throws EmfStoreException;

	/**
	 * Delegates call to method in {@link org.unicase.emfstore.AdminEmfStore}.
	 * 
	 * @see org.unicase.emfstore.AdminEmfStore#getParticipants(org.unicase.emfstore.esmodel.SessionId, ProjectId)
	 * @param projectId project id
	 * @return list of participating orgUnits
	 * @throws EmfStoreException if an exceptions occurs on the server or on transport
	 */
	List<ACOrgUnit> getParticipants(ProjectId projectId) throws EmfStoreException;

	/**
	 * Delegates call to method in {@link org.unicase.emfstore.AdminEmfStore}.
	 * 
	 * @see org.unicase.emfstore.AdminEmfStore#addParticipant(org.unicase.emfstore.esmodel.SessionId, ProjectId,
	 *      ACOrgUnitId)
	 * @param projectId project id
	 * @param participant orgUnit id
	 * @throws EmfStoreException if an exceptions occurs on the server or on transport
	 */
	void addParticipant(ProjectId projectId, ACOrgUnitId participant) throws EmfStoreException;

	/**
	 * Delegates call to method in {@link org.unicase.emfstore.AdminEmfStore}.
	 * 
	 * @see org.unicase.emfstore.AdminEmfStore#removeParticipant(org.unicase.emfstore.esmodel.SessionId, ProjectId,
	 *      ACOrgUnitId)
	 * @param projectId project id
	 * @param participant orgUnit id
	 * @throws EmfStoreException if an exceptions occurs on the server or on transport
	 */
	void removeParticipant(ProjectId projectId, ACOrgUnitId participant) throws EmfStoreException;

	/**
	 *Delegates call to method in {@link org.unicase.emfstore.AdminEmfStore}.
	 * 
	 * @see org.unicase.emfstore.AdminEmfStore#getRole(org.unicase.emfstore.esmodel.SessionId, ProjectId, ACOrgUnitId)
	 * @param projectId project id
	 * @param orgUnit orgUnit id
	 * @return the role
	 * @throws EmfStoreException if an exceptions occurs on the server or on transport
	 */
	Role getRole(ProjectId projectId, ACOrgUnitId orgUnit) throws EmfStoreException;

	/**
	 * Delegates call to method in {@link org.unicase.emfstore.AdminEmfStore}.
	 * 
	 * @see org.unicase.emfstore.AdminEmfStore#changeRole(org.unicase.emfstore.esmodel.SessionId, ProjectId,
	 *      ACOrgUnitId, EClass)
	 * @param projectId the project id
	 * @param orgUnit orgUnit id
	 * @param role new role
	 * @throws EmfStoreException if an exceptions occurs on the server or on transport
	 */
	void changeRole(ProjectId projectId, ACOrgUnitId orgUnit, EClass role) throws EmfStoreException;

}
