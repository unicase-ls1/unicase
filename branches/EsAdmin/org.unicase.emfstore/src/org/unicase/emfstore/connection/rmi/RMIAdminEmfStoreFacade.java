package org.unicase.emfstore.connection.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.unicase.emfstore.exceptions.EmfStoreException;

/**
 * 
 * @author Wesendonk
 */
public interface RMIAdminEmfStoreFacade extends Remote {
//	List<ProjectInfo> getProjectInfos(SessionId sessionId);
	List<String> getProjectInfos(String sessionId) throws RemoteException, EmfStoreException;
//	List<ACGroup> getGroups(SessionId sessionId);
	List<String> getGroups(String sessionId) throws RemoteException, EmfStoreException;
//	List<ACUser> getUsers(SessionId sessionId);
	List<String> getUsers(String session) throws RemoteException, EmfStoreException; 
//	List<ACOrgUnit> getOrgUnits(SessionId sessionId);
	List<String> getOrgUnits(String sessionId) throws RemoteException, EmfStoreException;
//	List<ACGroup> getGroups(SessionId sessionId, ACUser user);
	List<String> getGroups(String sessionId, String user) throws RemoteException, EmfStoreException;
//	void addGroup(SessionId sessionId, ACUser user, ACGroup group);
	void addGroup(String sessionId, String user, String group) throws RemoteException, EmfStoreException;
//	void removeGroup(SessionId sessionId, ACUser user, ACGroup group);
	void removeGroup(String sessionId, String user, String group) throws RemoteException, EmfStoreException;
//	List<ACOrgUnit> getParticipants(SessionId sessionId, ProjectInfo project);
	List<String> getParticipants(String sessionId, String projectInfo) throws RemoteException, EmfStoreException;
//	void addParticipant(SessionId sessionId, ProjectInfo project, ACOrgUnit participant);
	void addParticipant(String sessionId, String projectInfo, String participant) throws RemoteException, EmfStoreException;
//	void removeParticipant(SessionId sessionId, ProjectInfo project, ACOrgUnit participant);
	void removeParticipant(String sessionId, String projectInfo, String participant) throws RemoteException, EmfStoreException;
//	Role getRole(SessionId sessionId, ProjectInfo project, ACOrgUnit orgUnit);
	String getRole(String sessionId, String projectInfo, String orgUnit) throws RemoteException, EmfStoreException;
//	void changeRole(SessionId sessionId, ProjectInfo projectInfo, ACOrgUnit orgUnit, EClass role);
	void changeRole(String sessionId, String projectInfo, String orgUnit, String eClass) throws RemoteException, EmfStoreException;
}
