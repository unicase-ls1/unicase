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
import java.util.Map;

import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.emfstore.connection.rmi.RMIConnectionHandler;
import org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade;
import org.unicase.emfstore.connection.rmi.RMIUtil;
import org.unicase.emfstore.exceptions.ConnectionException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.UnknownSessionException;
import org.unicase.emfstore.model.ProjectId;
import org.unicase.emfstore.model.ProjectInfo;
import org.unicase.emfstore.model.SessionId;
import org.unicase.emfstore.model.changemanagment.ChangePackage;
import org.unicase.emfstore.model.changemanagment.HistoryInfo;
import org.unicase.emfstore.model.changemanagment.LogMessage;
import org.unicase.emfstore.model.changemanagment.PrimaryVersionSpec;
import org.unicase.emfstore.model.changemanagment.VersionSpec;
import org.unicase.model.Project;
import org.unicase.workspace.ServerInfo;

public class RMIConnectionManagerImpl implements ConnectionManager {

	private Map<SessionId, RMIEmfStoreFacade> facadeMap;

	public RMIConnectionManagerImpl() throws ConnectionException{
		facadeMap = new HashMap<SessionId, RMIEmfStoreFacade>();
	}

	public PrimaryVersionSpec createVersion(SessionId sessionId,
			ProjectId projectId, PrimaryVersionSpec baseVersionSpec,
			ChangePackage changePackage, LogMessage logMessage)
			throws ConnectionException {

		try {
			return (PrimaryVersionSpec) RMIUtil.stringToEObject(getFacade(sessionId)
					.createVersion(RMIUtil.eObjectToString(sessionId), RMIUtil
							.eObjectToString(projectId), RMIUtil
							.eObjectToString(baseVersionSpec), RMIUtil
							.eObjectToString(changePackage), RMIUtil
							.eObjectToString(logMessage)));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<ChangePackage> getChanges(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws EmfStoreException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HistoryInfo> getHistoryInfo(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws EmfStoreException {
	RMIEmfStoreFacade facade = getFacade(sessionId);
		try {
			List<HistoryInfo> result = new ArrayList<HistoryInfo>();
			for (String str : facade.getHistoryInfo(RMIUtil
					.eObjectToString(sessionId), RMIUtil
					.eObjectToString(projectId), RMIUtil
					.eObjectToString(source), RMIUtil.eObjectToString(target))) {
				result.add((HistoryInfo) RMIUtil.stringToEObject(str));
			}

			return result;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private RMIEmfStoreFacade getFacade(SessionId sessionId) throws UnknownSessionException {
		RMIEmfStoreFacade facade = facadeMap.get(sessionId);
		if (facade==null) {
			throw new UnknownSessionException("Session unkown to Connection manager, log in first!");
		}
		return facade;
	}

	public Project getProject(SessionId sessionId, ProjectId projectId,
			VersionSpec versionSpec) throws EmfStoreException {
		try {
			return (Project) RMIUtil.stringToEObject(getFacade(sessionId).getProject(RMIUtil
					.eObjectToString(sessionId), RMIUtil
					.eObjectToString(projectId), RMIUtil
					.eObjectToString(versionSpec)));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<ProjectInfo> getProjectList(SessionId sessionId) {
		try {
			List<ProjectInfo> result = new ArrayList<ProjectInfo>();
			for (String str : getFacade(sessionId).getProjectList(RMIUtil
					.eObjectToString(sessionId))) {
				result.add((ProjectInfo) RMIUtil.stringToEObject(str));
			}
			return result;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public PrimaryVersionSpec resolveVersionSpec(SessionId sessionId,
			VersionSpec versionSpec) {
		try {
			return (PrimaryVersionSpec) RMIUtil.stringToEObject(getFacade(sessionId)
					.resolveVersionSpec(RMIUtil.eObjectToString(sessionId),
							RMIUtil.eObjectToString(versionSpec)));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public SessionId logIn(String username, String password,
			ServerInfo serverInfo) throws ConnectionException {

		Registry registry;
		try {
			registry = LocateRegistry.getRegistry(serverInfo.getUrl(),serverInfo.getPort());
			RMIEmfStoreFacade facade = (RMIEmfStoreFacade) registry.lookup(RMIConnectionHandler.RMI_NAME);
			SessionId sessionId = (SessionId) RMIUtil.stringToEObject(facade.login(username,
						password, RMIUtil.eObjectToString(serverInfo)));
			facadeMap.put(sessionId, facade);
			return sessionId;
		} catch (RemoteException e) {
			throw new ConnectionException("Connection to server refused.", e);
		} catch (NotBoundException e) {
			throw new ConnectionException("RMI Registry not available.");
		}
		 catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AccessControlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
