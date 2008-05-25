package org.unicase.workspace.connectionmanager;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.emfstore.connection.rmi.RMIConnectionHandler;
import org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade;
import org.unicase.emfstore.connection.rmi.RMIUtil;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.esmodel.ProjectId;
import org.unicase.esmodel.ProjectInfo;
import org.unicase.esmodel.SessionId;
import org.unicase.esmodel.changemanagment.ChangePackage;
import org.unicase.esmodel.changemanagment.HistoryInfo;
import org.unicase.esmodel.changemanagment.LogMessage;
import org.unicase.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.esmodel.changemanagment.VersionSpec;
import org.unicase.model.Project;
import org.unicase.workspace.ServerInfo;

public class RMIConnectionManagerImpl implements ConnectionManager {

	private RMIEmfStoreFacade facade;

	public RMIConnectionManagerImpl() throws ConnectionException{
		Registry registry;
		try {
			registry = LocateRegistry.getRegistry();
			facade = (RMIEmfStoreFacade) registry.lookup(RMIConnectionHandler.RMI_NAME);
		} catch (RemoteException e) {
			throw new ConnectionException("Connection to server refused.");
		} catch (NotBoundException e) {
			throw new ConnectionException("RMI Registry not available.");
		}
	}

	public PrimaryVersionSpec createVersion(SessionId sessionId,
			ProjectId projectId, PrimaryVersionSpec baseVersionSpec,
			ChangePackage changePackage, LogMessage logMessage)
			throws ConnectionException {

		try {
			return (PrimaryVersionSpec) RMIUtil.stringToEObject(facade
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
			throws ConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HistoryInfo> getHistoryInfo(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws ConnectionException {
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

	public Project getProject(SessionId sessionId, ProjectId projectId,
			VersionSpec versionSpec) throws ConnectionException {
		try {
			return (Project) RMIUtil.stringToEObject(facade.getProject(RMIUtil
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
			for (String str : facade.getProjectList(RMIUtil
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
			return (PrimaryVersionSpec) RMIUtil.stringToEObject(facade
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

		try {
			return (SessionId) RMIUtil.stringToEObject(facade.login(username,
					password, RMIUtil.eObjectToString(serverInfo)));
		}
		 catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
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

	public void sendString(String str) {
		try {
			facade.sendString(str);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
