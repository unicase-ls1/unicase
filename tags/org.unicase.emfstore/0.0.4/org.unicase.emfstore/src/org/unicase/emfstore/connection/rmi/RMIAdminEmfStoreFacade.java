/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.connection.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.unicase.emfstore.exceptions.EmfStoreException;

/**
 * 
 * @author Wesendonk
 *
 */
public interface RMIAdminEmfStoreFacade extends Remote {
//	EList<ProjectInfo> getProjectInfos(SessionId sessionId);
	List<String> getProjectInfos(String sessionId) throws RemoteException, EmfStoreException;
//	EList<ACGroup> getGroups(SessionId sessionId);
	List<String> getGroups(String sessionId) throws RemoteException, EmfStoreException;
//	EList<ACUser> getUsers(SessionId sessionId);
	List<String> getUsers(String session) throws RemoteException, EmfStoreException; 
//	EList<ACOrgUnit> getOrgUnits(SessionId sessionId);
	List<String> getOrgUnits(String sessionId) throws RemoteException, EmfStoreException;
//	EList<ACGroup> getGroups(SessionId sessionId, ACUser user);
	List<String> getGroups(String sessionId, String user) throws RemoteException, EmfStoreException;
//	void removeGroup(SessionId sessionId, ACUser user, ACGroup group);
	void removeGroup(String sessionId, String user, String group) throws RemoteException, EmfStoreException;
//	EList<ACOrgUnit> getParticipants(SessionId sessionId, ProjectInfo project);
	List<String> getParticipants(String sessionId, String projectId) throws RemoteException, EmfStoreException;
//	void addParticipant(SessionId sessionId, ProjectInfo project, ACOrgUnit participant);
	void addParticipant(String sessionId, String projectId, String participant) throws RemoteException, EmfStoreException;
//	void removeParticipant(SessionId sessionId, ProjectInfo project, ACOrgUnit participant);
	void removeParticipant(String sessionId, String projectId, String participant) throws RemoteException, EmfStoreException;
//	Role getRole(SessionId sessionId, ProjectInfo project, ACOrgUnit orgUnit);
	String getRole(String sessionId, String projectId, String orgUnitId) throws RemoteException, EmfStoreException;
//	void changeRole(SessionId sessionId, ProjectInfo projectInfo, ACOrgUnit orgUnit, EClass role);
	void changeRole(String sessionId, String projectId, String orgUnitId, String eClass) throws RemoteException, EmfStoreException;
	
	void createGroup(String sessionId, String name) throws RemoteException, EmfStoreException;
	void deleteGroup(String sessionId, String id) throws RemoteException, EmfStoreException;
	
	void createUser(String sessionId, String name) throws RemoteException, EmfStoreException;
	void deleteUser(String sessionId, String id) throws RemoteException, EmfStoreException;
	
	List<String> getMembers(String sessionId, String groupId) throws RemoteException, EmfStoreException;
	void addMember(String sessionId, String group, String member) throws RemoteException, EmfStoreException;
	void removeMember(String sessionId, String group, String member) throws RemoteException, EmfStoreException;
	
	void changeOrgUnit(String sessionId, String orgUnitId, String name, String description) throws RemoteException, EmfStoreException;
	String getOrgUnit(String sessionId, String orgUnitId) throws RemoteException, EmfStoreException;
}
