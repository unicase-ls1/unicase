/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
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
 * 
 * @author Hodaie
 * @author Wesendonk
 */
public interface AdminEmfStore {
	//OW: do comment
	List<ProjectInfo> getProjectInfos(SessionId sessionId) throws EmfStoreException;
	List<ACGroup> getGroups(SessionId sessionId) throws EmfStoreException;
	List<ACUser> getUsers(SessionId sessionId) throws EmfStoreException;
	List<ACOrgUnit> getOrgUnits(SessionId sessionId) throws EmfStoreException;
	ACOrgUnit getOrgUnit(SessionId sessionId, ACOrgUnitId orgUnitId) throws EmfStoreException;
	
	void createGroup(SessionId sessionId, String name) throws EmfStoreException;
	void deleteGroup(SessionId sessionId, ACOrgUnitId group) throws EmfStoreException;
	List<ACGroup> getGroups(SessionId sessionId, ACOrgUnitId user) throws EmfStoreException;
	void removeGroup(SessionId sessionId, ACOrgUnitId user, ACOrgUnitId group) throws EmfStoreException;

	List<ACOrgUnit> getMembers(SessionId sessionId, ACOrgUnitId groupId) throws EmfStoreException;
	void addMember(SessionId sessionId, ACOrgUnitId group, ACOrgUnitId member) throws EmfStoreException;
	void removeMember(SessionId sessionId, ACOrgUnitId group, ACOrgUnitId member) throws EmfStoreException;

	void createUser(SessionId sessionId, String name) throws EmfStoreException;
	void deleteUser(SessionId sessionId, ACOrgUnitId user) throws EmfStoreException;
	
	void changeOrgUnit(SessionId sessionId, ACOrgUnitId orgUnitId, String name, String description) throws EmfStoreException;
	
	List<ACOrgUnit> getParticipants(SessionId sessionId, ProjectId projectId) throws EmfStoreException;
	
	void addParticipant(SessionId sessionId, ProjectId projectId, ACOrgUnitId participant) throws EmfStoreException;
	void removeParticipant(SessionId sessionId, ProjectId projectId, ACOrgUnitId participant) throws EmfStoreException;
	
	Role getRole(SessionId sessionId, ProjectId projectId, ACOrgUnitId orgUnit) throws EmfStoreException;
	void changeRole(SessionId sessionId, ProjectId projectId, ACOrgUnitId orgUnit, EClass role) throws EmfStoreException;
}
