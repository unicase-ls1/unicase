/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;
import org.unicase.emfstore.exceptions.EmfStoreException;

/**
 * AdminEmfStore offers an interface for administrating the users and their rights.
 * 
 * @author Hodaie
 * @author Wesendonk
 */
public interface AdminEmfStore extends EmfStoreInterface {

	/**
	 * Returns a list of available project.
	 * 
	 * @param sessionId the session id for authentication
	 * @return list of project infos
	 * @throws EmfStoreException if any error in the EmfStore occurs
	 */
	List<ProjectInfo> getProjectInfos(SessionId sessionId) throws EmfStoreException;

	/**
	 * Returns all groups on the server.
	 * 
	 * @param sessionId the session id for authentication
	 * @return list of groups
	 * @throws EmfStoreException if any error in the EmfStore occurs
	 */
	List<ACGroup> getGroups(SessionId sessionId) throws EmfStoreException;

	/**
	 * Returns all users on the server.
	 * 
	 * @param sessionId the session id for authentication
	 * @return list of user
	 * @throws EmfStoreException if any error in the EmfStore occurs
	 */
	List<ACUser> getUsers(SessionId sessionId) throws EmfStoreException;

	/**
	 * Returns all orgUnits on the server.
	 * 
	 * @param sessionId the session id for authentication
	 * @return list of orgUnits
	 * @throws EmfStoreException if any error in the EmfStore occurs
	 */
	List<ACOrgUnit> getOrgUnits(SessionId sessionId) throws EmfStoreException;

	/**
	 * Returns an orgUnit with the specified orgUnitId.
	 * 
	 * @param orgUnitId the orgUnitId
	 * @param sessionId the session id for authentication
	 * @return an orgUnit
	 * @throws EmfStoreException if any error in the EmfStore occurs
	 */
	ACOrgUnit getOrgUnit(SessionId sessionId, ACOrgUnitId orgUnitId) throws EmfStoreException;

	/**
	 * Creates a group on the server.
	 * 
	 * @param sessionId the session id for authentication
	 * @param name the name for the group
	 * @return ACOrgUnitId
	 * @throws EmfStoreException if any error in the EmfStore occurs
	 */
	ACOrgUnitId createGroup(SessionId sessionId, String name) throws EmfStoreException;

	/**
	 * Deletes a group on the server.
	 * 
	 * @param sessionId the session id for authentication
	 * @param group orgUnitId of the group
	 * @throws EmfStoreException if any error in the EmfStore occurs
	 */
	void deleteGroup(SessionId sessionId, ACOrgUnitId group) throws EmfStoreException;

	/**
	 * Returns a list of all groups in which the specified user is member of.
	 * 
	 * @param sessionId the session id for authentication
	 * @param user the users orgUnitId
	 * @return a list of groups
	 * @throws EmfStoreException if any error in the EmfStore occurs
	 */
	List<ACGroup> getGroups(SessionId sessionId, ACOrgUnitId user) throws EmfStoreException;

	/**
	 * Removes a user from a group.
	 * 
	 * @param sessionId the session id for authentication
	 * @param user the user's orgUnitId
	 * @param group the group's orgUnitId
	 * @throws EmfStoreException if any error in the EmfStore occurs
	 */
	void removeGroup(SessionId sessionId, ACOrgUnitId user, ACOrgUnitId group) throws EmfStoreException;

	/**
	 * Returns all members from a group.
	 * 
	 * @param sessionId the session id for authentication
	 * @param groupId the group's orgUnitId
	 * @return a list of orgUnits
	 * @throws EmfStoreException if any error in the EmfStore occurs.
	 */
	List<ACOrgUnit> getMembers(SessionId sessionId, ACOrgUnitId groupId) throws EmfStoreException;

	/**
	 * Adds an orgUnit to a group.
	 * 
	 * @param sessionId the session id for authentication
	 * @param group the group's orgUnitId
	 * @param member the members orgUnitId
	 * @throws EmfStoreException if any error in the EmfStore occurs
	 */
	void addMember(SessionId sessionId, ACOrgUnitId group, ACOrgUnitId member) throws EmfStoreException;

	/**
	 * Removes a orgUnit from a group.
	 * 
	 * @param sessionId the session id for authentication
	 * @param group the group's orgUnitId
	 * @param member the members orgUnitId
	 * @throws EmfStoreException if any error in the EmfStore occurs
	 */
	void removeMember(SessionId sessionId, ACOrgUnitId group, ACOrgUnitId member) throws EmfStoreException;

	/**
	 * Creates a user on the server.
	 * 
	 * @param sessionId the session id for authentication
	 * @param name the user's name
	 * @return ACOrgUnitId
	 * @throws EmfStoreException if any in the EmfStore occurs
	 */
	ACOrgUnitId createUser(SessionId sessionId, String name) throws EmfStoreException;

	/**
	 * Deletes a user from the server.
	 * 
	 * @param sessionId the session id for authentication
	 * @param user the user's orgUnitId
	 * @throws EmfStoreException if any error in the EmfStore occurs
	 */
	void deleteUser(SessionId sessionId, ACOrgUnitId user) throws EmfStoreException;

	/**
	 * Changes the orgUnit's name and description.
	 * 
	 * @param sessionId the session id for authentication.
	 * @param orgUnitId the orgUnitId
	 * @param name the new name
	 * @param description the new description
	 * @throws EmfStoreException if any error in the EmfStore occurs
	 */
	void changeOrgUnit(SessionId sessionId, ACOrgUnitId orgUnitId, String name, String description)
		throws EmfStoreException;

	/**
	 * Returns all orgUnits which are attached to the given project.
	 * 
	 * @param sessionId the session id for authentication
	 * @param projectId project's id
	 * @return a list of orgUnits
	 * @throws EmfStoreException if any error in the EmfStore occurs
	 */
	List<ACOrgUnit> getParticipants(SessionId sessionId, ProjectId projectId) throws EmfStoreException;

	/**
	 * Adds an orgUnit to a project.
	 * 
	 * @param sessionId the session id for authentication
	 * @param projectId the project's id
	 * @param participant the orgUnit's id
	 * @throws EmfStoreException if any error in the EmfStore occurs
	 */
	void addParticipant(SessionId sessionId, ProjectId projectId, ACOrgUnitId participant) throws EmfStoreException;

	/**
	 * Removes an orgUnits from a project.
	 * 
	 * @param sessionId the session id for authentication
	 * @param projectId the project's id
	 * @param participant the orgUnit's id
	 * @throws EmfStoreException if any error in the EmfStore occurs
	 */
	void removeParticipant(SessionId sessionId, ProjectId projectId, ACOrgUnitId participant) throws EmfStoreException;

	/**
	 * Returns an orgUnit's role for a specified project.
	 * 
	 * @param sessionId the session id for authentication
	 * @param projectId the project's id
	 * @param orgUnit the orgUnit's id
	 * @return a role the user's role
	 * @throws EmfStoreException if any error in the EmfStore occurs
	 */
	Role getRole(SessionId sessionId, ProjectId projectId, ACOrgUnitId orgUnit) throws EmfStoreException;

	/**
	 * Changes the role for an orgUnit in a specified project.
	 * 
	 * @param sessionId the session id for authentication
	 * @param projectId the project's id
	 * @param orgUnit the orgUnit
	 * @param role new role for orgUnit
	 * @throws EmfStoreException if any error in the EmfStore occurs.
	 */
	void changeRole(SessionId sessionId, ProjectId projectId, ACOrgUnitId orgUnit, EClass role)
		throws EmfStoreException;
}
