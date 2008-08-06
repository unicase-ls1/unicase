package org.unicase.workspace.connectionmanager;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.unicase.emfstore.connection.rmi.RMIAdminConnectionHandler;
import org.unicase.emfstore.connection.rmi.RMIAdminEmfStoreFacade;
import org.unicase.emfstore.connection.rmi.RMIUtil;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;
import org.unicase.emfstore.exceptions.ConnectionException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.UnknownSessionException;
import org.unicase.workspace.ServerInfo;

/**
 * @author Wesendonk
 */
public class RMIAdminConnectionManagerImpl implements AdminConnectionManager {

	private HashMap<SessionId, RMIAdminEmfStoreFacade> adminFacadeMap;

	private static final String UNSUPPORTED_ENCODING = "Problem with en/decoding.";

	private static final String REMOTE = "A rmi communication-related exception.";

	/**
	 * Default constructor.
	 */
	public RMIAdminConnectionManagerImpl() {
		adminFacadeMap = new HashMap<SessionId, RMIAdminEmfStoreFacade>();
	}

	public void addParticipant(SessionId sessionId, ProjectId projectId,
			ACOrgUnitId participant) throws EmfStoreException {
		try {
			getFacade(sessionId).addParticipant(
					RMIUtil.eObjectToString(sessionId),
					RMIUtil.eObjectToString(projectId),
					RMIUtil.eObjectToString(participant));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		} catch (IOException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	public void changeRole(SessionId sessionId, ProjectId projectId,
			ACOrgUnitId orgUnit, EClass role) throws EmfStoreException {
		try {
			getFacade(sessionId).changeRole(RMIUtil.eObjectToString(sessionId),
					RMIUtil.eObjectToString(projectId),
					RMIUtil.eObjectToString(orgUnit),
					RMIUtil.eObjectToString(role));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		} catch (IOException e) {
			throw new ConnectionException(REMOTE, e);
		}

	}

	public List<ACGroup> getGroups(SessionId sessionId)
			throws EmfStoreException {
		try {
			List<ACGroup> result = new ArrayList<ACGroup>();
			for (String str : getFacade(sessionId).getGroups(
					RMIUtil.eObjectToString(sessionId))) {
				result.add((ACGroup) RMIUtil.stringToEObject(str));
			}
			return result;
		} catch (UnsupportedEncodingException e) {
			throw new ConnectionException(UNSUPPORTED_ENCODING, e);
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		} catch (IOException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	public List<ACGroup> getGroups(SessionId sessionId, ACOrgUnitId user)
			throws EmfStoreException {
		try {
			List<ACGroup> result = new ArrayList<ACGroup>();
			for (String str : getFacade(sessionId).getGroups(
					RMIUtil.eObjectToString(sessionId),
					RMIUtil.eObjectToString(user))) {
				result.add((ACGroup) RMIUtil.stringToEObject(str));
			}
			return result;
		} catch (UnsupportedEncodingException e) {
			throw new ConnectionException(UNSUPPORTED_ENCODING, e);
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		} catch (IOException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	public List<ACOrgUnit> getOrgUnits(SessionId sessionId)
			throws EmfStoreException {
		try {
			List<ACOrgUnit> result = new ArrayList<ACOrgUnit>();
			for (String str : getFacade(sessionId).getOrgUnits(
					RMIUtil.eObjectToString(sessionId))) {
				result.add((ACOrgUnit) RMIUtil.stringToEObject(str));
			}
			return result;
		} catch (UnsupportedEncodingException e) {
			throw new ConnectionException(UNSUPPORTED_ENCODING, e);
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		} catch (IOException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	public List<ACOrgUnit> getParticipants(SessionId sessionId,
			ProjectId projectId) throws EmfStoreException {
		try {
			List<ACOrgUnit> result = new ArrayList<ACOrgUnit>();
			for (String str : getFacade(sessionId).getParticipants(
					RMIUtil.eObjectToString(sessionId),
					RMIUtil.eObjectToString(projectId))) {
				result.add((ACOrgUnit) RMIUtil.stringToEObject(str));
			}
			return result;
		} catch (UnsupportedEncodingException e) {
			throw new ConnectionException(UNSUPPORTED_ENCODING, e);
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		} catch (IOException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	public List<ProjectInfo> getProjectInfos(SessionId sessionId)
			throws EmfStoreException {
		try {
			List<ProjectInfo> result = new ArrayList<ProjectInfo>();
			for (String str : getFacade(sessionId).getProjectInfos(
					RMIUtil.eObjectToString(sessionId))) {
				result.add((ProjectInfo) RMIUtil.stringToEObject(str));
			}
			return result;
		} catch (UnsupportedEncodingException e) {
			throw new ConnectionException(UNSUPPORTED_ENCODING, e);
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		} catch (IOException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	public Role getRole(SessionId sessionId, ProjectId projectId,
			ACOrgUnitId orgUnit) throws EmfStoreException {
		try {
			return (Role) RMIUtil.stringToEObject(getFacade(sessionId).getRole(
					RMIUtil.eObjectToString(sessionId),
					RMIUtil.eObjectToString(projectId),
					RMIUtil.eObjectToString(orgUnit)));
		} catch (UnsupportedEncodingException e) {
			throw new ConnectionException(UNSUPPORTED_ENCODING, e);
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		} catch (IOException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	public List<ACUser> getUsers(SessionId sessionId) throws EmfStoreException {
		try {
			List<ACUser> result = new ArrayList<ACUser>();
			for (String user : getFacade(sessionId).getUsers(
					RMIUtil.eObjectToString(sessionId))) {
				result.add((ACUser) RMIUtil.stringToEObject(user));
			}
			return result;
		} catch (UnsupportedEncodingException e) {
			throw new ConnectionException(UNSUPPORTED_ENCODING, e);
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		} catch (IOException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	public void removeGroup(SessionId sessionId, ACOrgUnitId user,
			ACOrgUnitId group) throws EmfStoreException {
		try {
			getFacade(sessionId).removeGroup(
					RMIUtil.eObjectToString(sessionId),
					RMIUtil.eObjectToString(user),
					RMIUtil.eObjectToString(group));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		} catch (IOException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	public void removeParticipant(SessionId sessionId, ProjectId projectId,
			ACOrgUnitId participant) throws EmfStoreException {
		try {
			getFacade(sessionId).removeParticipant(
					RMIUtil.eObjectToString(sessionId),
					RMIUtil.eObjectToString(projectId),
					RMIUtil.eObjectToString(participant));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		} catch (IOException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	public void createGroup(SessionId sessionId, String name)
			throws EmfStoreException {
		try {
			getFacade(sessionId).createGroup(
					RMIUtil.eObjectToString(sessionId), name);
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		} catch (IOException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	public void createUser(SessionId sessionId, String name)
			throws EmfStoreException {
		try {
			getFacade(sessionId).createUser(RMIUtil.eObjectToString(sessionId),
					name);
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		} catch (IOException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	public void deleteGroup(SessionId sessionId, ACOrgUnitId group)
			throws EmfStoreException {
		try {
			getFacade(sessionId).deleteGroup(
					RMIUtil.eObjectToString(sessionId),
					RMIUtil.eObjectToString(group));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		} catch (IOException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	public void deleteUser(SessionId sessionId, ACOrgUnitId user)
			throws EmfStoreException {
		try {
			getFacade(sessionId).deleteUser(RMIUtil.eObjectToString(sessionId),
					RMIUtil.eObjectToString(user));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		} catch (IOException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	private RMIAdminEmfStoreFacade getFacade(SessionId sessionId)
			throws EmfStoreException {
		RMIAdminEmfStoreFacade facade = adminFacadeMap.get(sessionId);
		if (facade == null) {
			throw new UnknownSessionException(
					"Session unkown to AdminConnectionManager, either log in first or init connection!");
		}
		return facade;
	}

	public void initConnection(ServerInfo serverInfo, SessionId id)
			throws ConnectionException {
		Registry registry;
		RMIAdminEmfStoreFacade facade;
		try {
			registry = LocateRegistry.getRegistry(serverInfo.getUrl(),
					serverInfo.getPort());
			facade = (RMIAdminEmfStoreFacade) registry
					.lookup(RMIAdminConnectionHandler.RMI_NAME);
		} catch (RemoteException e) {
			throw new ConnectionException("todo");
		} catch (NotBoundException e) {
			throw new ConnectionException("Registry not available.");
		}
		adminFacadeMap.put(id, facade);
	}

	public void addMember(SessionId sessionId, ACOrgUnitId group,
			ACOrgUnitId member) throws EmfStoreException {
		try {
			getFacade(sessionId).addMember(RMIUtil.eObjectToString(sessionId),
					RMIUtil.eObjectToString(group),
					RMIUtil.eObjectToString(member));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		} catch (IOException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	public void removeMember(SessionId sessionId, ACOrgUnitId group,
			ACOrgUnitId member) throws EmfStoreException {
		try {
			getFacade(sessionId).removeMember(
					RMIUtil.eObjectToString(sessionId),
					RMIUtil.eObjectToString(group),
					RMIUtil.eObjectToString(member));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		} catch (IOException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	public void changeOrgUnit(SessionId sessionId, ACOrgUnitId orgUnitId,
			String name, String description) throws EmfStoreException {
		try {
			getFacade(sessionId).changeOrgUnit(
					RMIUtil.eObjectToString(sessionId),
					RMIUtil.eObjectToString(orgUnitId), name, description);
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		} catch (IOException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}
}
