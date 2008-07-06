package org.unicase.emfstore.connection.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.exceptions.EmfStoreException;

/**
 * 
 * @author Wesendonk
 */
public interface RMIAdminEmfStoreFacade extends Remote {
//	EList<ProjectInfo> getProjectInfos(SessionId sessionId);
	EList<String> getProjectInfos(String sessionId) throws RemoteException, EmfStoreException;
//	EList<ACGroup> getGroups(SessionId sessionId);
	EList<String> getGroups(String sessionId) throws RemoteException, EmfStoreException;
//	EList<ACUser> getUsers(SessionId sessionId);
	EList<String> getUsers(String session) throws RemoteException, EmfStoreException; 
//	EList<ACOrgUnit> getOrgUnits(SessionId sessionId);
	EList<String> getOrgUnits(String sessionId) throws RemoteException, EmfStoreException;
//	EList<ACGroup> getGroups(SessionId sessionId, ACUser user);
	EList<String> getGroups(String sessionId, String user) throws RemoteException, EmfStoreException;
//	void addGroup(SessionId sessionId, ACUser user, ACGroup group);
	void addGroup(String sessionId, String user, String group) throws RemoteException, EmfStoreException;
//	void removeGroup(SessionId sessionId, ACUser user, ACGroup group);
	void removeGroup(String sessionId, String user, String group) throws RemoteException, EmfStoreException;
//	EList<ACOrgUnit> getParticipants(SessionId sessionId, ProjectInfo project);
	EList<String> getParticipants(String sessionId, String projectInfo) throws RemoteException, EmfStoreException;
//	void addParticipant(SessionId sessionId, ProjectInfo project, ACOrgUnit participant);
	void addParticipant(String sessionId, String projectInfo, String participant) throws RemoteException, EmfStoreException;
//	void removeParticipant(SessionId sessionId, ProjectInfo project, ACOrgUnit participant);
	void removeParticipant(String sessionId, String projectInfo, String participant) throws RemoteException, EmfStoreException;
//	Role getRole(SessionId sessionId, ProjectInfo project, ACOrgUnit orgUnit);
	String getRole(String sessionId, String projectInfo, String orgUnit) throws RemoteException, EmfStoreException;
//	void changeRole(SessionId sessionId, ProjectInfo projectInfo, ACOrgUnit orgUnit, EClass role);
	void changeRole(String sessionId, String projectInfo, String orgUnit, String eClass) throws RemoteException, EmfStoreException;
}
