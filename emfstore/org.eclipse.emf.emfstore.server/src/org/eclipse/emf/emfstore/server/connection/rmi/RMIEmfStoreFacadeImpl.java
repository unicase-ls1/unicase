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

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.EmfStore;
import org.eclipse.emf.emfstore.server.accesscontrol.AuthenticationControl;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.RMISerializationException;
import org.eclipse.emf.emfstore.server.filetransfer.FileChunk;
import org.eclipse.emf.emfstore.server.filetransfer.FileTransferInformation;
import org.eclipse.emf.emfstore.server.model.ClientVersionInfo;
import org.eclipse.emf.emfstore.server.model.ProjectHistory;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.OrgUnitProperty;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery;
import org.eclipse.emf.emfstore.server.model.versioning.LogMessage;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersionSpec;

/**
 * Implementation of a RMIEmfStoreFacade.
 * 
 * @author koegel
 * @author Wesendonk
 */
public class RMIEmfStoreFacadeImpl extends AbstractEMFStoreRMIFacade implements RMIEmfStoreFacade {

	private static final long serialVersionUID = -3245554287505036114L;

	private EmfStore emfStore;

	private AuthenticationControl accessControl;

	private static final String SERIALEX = "An exception occured while serializing the objects.";

	/**
	 * Default constructor.
	 * 
	 * @param emfStore the emf store
	 * @param authenticationControl the authentication controler
	 * @throws RemoteException if an RMI problem occurs
	 * @throws FatalEmfStoreException exception within the server
	 */
	public RMIEmfStoreFacadeImpl(EmfStore emfStore, AuthenticationControl authenticationControl)
		throws RemoteException, FatalEmfStoreException {
		super(1098);
		this.emfStore = emfStore;
		this.accessControl = authenticationControl;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.connection.rmi.RMIEmfStoreFacade#createVersion(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public String createVersion(String sessionId, String projectId, String baseVersionSpec, String changePackage,
		String logMessage) throws RemoteException, EmfStoreException {

		SessionId sessionIdObject = (SessionId) SerializationUtil.stringToEObject(sessionId);
		ProjectId projectIdObject = (ProjectId) SerializationUtil.stringToEObject(projectId);
		PrimaryVersionSpec primaryVersionSpec = (PrimaryVersionSpec) SerializationUtil.stringToEObject(baseVersionSpec);
		ChangePackage changePackageObject = (ChangePackage) SerializationUtil.stringToEObject(changePackage);

		return SerializationUtil.eObjectToString(emfStore.createVersion(sessionIdObject, projectIdObject,
			primaryVersionSpec, changePackageObject, (LogMessage) SerializationUtil.stringToEObject(logMessage)));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.connection.rmi.RMIEmfStoreFacade#getChanges(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<String> getChanges(String sessionId, String projectId, String source, String target)
		throws RemoteException, EmfStoreException {
		List<String> result = new ArrayList<String>();
		for (ChangePackage cp : emfStore.getChanges((SessionId) SerializationUtil.stringToEObject(sessionId),
			(ProjectId) SerializationUtil.stringToEObject(projectId),
			(VersionSpec) SerializationUtil.stringToEObject(source),
			(VersionSpec) SerializationUtil.stringToEObject(target))) {

			result.add(SerializationUtil.eObjectToString(cp));
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getHistoryInfo(String sessionId, String projectId, String query) throws RemoteException,
		EmfStoreException {
		List<String> result = new ArrayList<String>();
		for (HistoryInfo info : emfStore.getHistoryInfo((SessionId) SerializationUtil.stringToEObject(sessionId),
			(ProjectId) SerializationUtil.stringToEObject(projectId),
			(HistoryQuery) SerializationUtil.stringToEObject(query))) {
			result.add(SerializationUtil.eObjectToString(info));
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addTag(String sessionId, String projectId, String versionSpec, String tag) throws RemoteException,
		EmfStoreException {
		emfStore.addTag((SessionId) SerializationUtil.stringToEObject(sessionId),
			(ProjectId) SerializationUtil.stringToEObject(projectId),
			(PrimaryVersionSpec) SerializationUtil.stringToEObject(versionSpec),
			(TagVersionSpec) SerializationUtil.stringToEObject(tag));
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeTag(String sessionId, String projectId, String versionSpec, String tag) throws RemoteException,
		EmfStoreException {
		emfStore.removeTag((SessionId) SerializationUtil.stringToEObject(sessionId),
			(ProjectId) SerializationUtil.stringToEObject(projectId),
			(PrimaryVersionSpec) SerializationUtil.stringToEObject(versionSpec),
			(TagVersionSpec) SerializationUtil.stringToEObject(tag));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.connection.rmi.RMIEmfStoreFacade#getProject(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	public String getProject(String sessionId, String projectId, String versionSpec) throws RemoteException,
		EmfStoreException {
		return SerializationUtil.eObjectToString(emfStore.getProject(
			(SessionId) SerializationUtil.stringToEObject(sessionId),
			(ProjectId) SerializationUtil.stringToEObject(projectId),
			(VersionSpec) SerializationUtil.stringToEObject(versionSpec)));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.connection.rmi.RMIEmfStoreFacade#getProjectList(java.lang.String)
	 */
	public List<String> getProjectList(String sessionId) throws RemoteException, EmfStoreException {
		List<String> result = new ArrayList<String>();
		for (ProjectInfo pi : emfStore.getProjectList((SessionId) SerializationUtil.stringToEObject(sessionId))) {
			result.add(SerializationUtil.eObjectToString(pi));
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.connection.rmi.RMIEmfStoreFacade#login(java.lang.String, java.lang.String,
	 *      java.lang.String)
	 */
	public String login(String username, String password, String serverInfo, String version) throws RemoteException,
		AccessControlException {
		try {
			return SerializationUtil.eObjectToString(accessControl.logIn(username, password,
				(ClientVersionInfo) SerializationUtil.stringToEObject(version)));
		} catch (RMISerializationException e) {
			throw new AccessControlException(SERIALEX);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.connection.rmi.RMIEmfStoreFacade#logout(java.lang.String)
	 */
	public void logout(String sessionId) throws RemoteException, AccessControlException {
		try {
			accessControl.logout((SessionId) SerializationUtil.stringToEObject(sessionId));
		} catch (RMISerializationException e) {
			throw new AccessControlException(SERIALEX);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.connection.rmi.RMIEmfStoreFacade#resolveVersionSpec(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	public String resolveVersionSpec(String sessionId, String projectId, String versionSpec) throws RemoteException,
		EmfStoreException {
		return SerializationUtil.eObjectToString(emfStore.resolveVersionSpec(
			(SessionId) SerializationUtil.stringToEObject(sessionId),
			(ProjectId) SerializationUtil.stringToEObject(projectId),
			(VersionSpec) SerializationUtil.stringToEObject(versionSpec)));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.connection.rmi.RMIEmfStoreFacade#createProject(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String)
	 */
	public String createProject(String sessionId, String name, String description, String logMessage)
		throws RemoteException, EmfStoreException {
		return SerializationUtil.eObjectToString(emfStore.createEmptyProject(
			(SessionId) SerializationUtil.stringToEObject(sessionId), name, description,
			(LogMessage) SerializationUtil.stringToEObject(logMessage)));
	}

	/**
	 * {@inheritDoc}
	 */
	public String createProject(String sessionId, String name, String description, String logMessage, String project)
		throws EmfStoreException, RemoteException {
		return SerializationUtil.eObjectToString(emfStore.createProject(
			(SessionId) SerializationUtil.stringToEObject(sessionId), name, description,
			(LogMessage) SerializationUtil.stringToEObject(logMessage),
			(Project) SerializationUtil.stringToEObject(project)));
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteProject(String sessionId, String projectId, boolean deleteFiles) throws EmfStoreException,
		RemoteException {
		emfStore.deleteProject((SessionId) SerializationUtil.stringToEObject(sessionId),
			(ProjectId) SerializationUtil.stringToEObject(projectId), deleteFiles);
	}

	/**
	 * {@inheritDoc}
	 */
	public String exportProjectHistoryFromServer(String sessionId, String projectId) throws EmfStoreException,
		RemoteException {
		return SerializationUtil.eObjectToString(emfStore.exportProjectHistoryFromServer(
			(SessionId) SerializationUtil.stringToEObject(sessionId),
			(ProjectId) SerializationUtil.stringToEObject(projectId)));
	}

	/**
	 * {@inheritDoc}
	 */
	public String importProjectHistoryToServer(String sessionId, String projectHistory) throws EmfStoreException,
		RemoteException {
		return SerializationUtil.eObjectToString(emfStore.importProjectHistoryToServer(
			(SessionId) SerializationUtil.stringToEObject(sessionId),
			(ProjectHistory) SerializationUtil.stringToEObject(projectHistory)));
	}

	/**
	 * {@inheritDoc}
	 */
	public String resolveUser(String sessionId, String orgUnitId) throws EmfStoreException, RemoteException {
		return SerializationUtil.eObjectToString(emfStore.resolveUser(
			(SessionId) SerializationUtil.stringToEObject(sessionId),
			(ACOrgUnitId) SerializationUtil.stringToEObject(orgUnitId)));
	}

	/**
	 * {@inheritDoc}
	 */
	public FileTransferInformation uploadFileChunk(String sessionId, String projectId, FileChunk fileChunk)
		throws EmfStoreException, RemoteException {
		return emfStore.uploadFileChunk((SessionId) SerializationUtil.stringToEObject(sessionId),
			(ProjectId) SerializationUtil.stringToEObject(projectId), fileChunk);
	}

	/**
	 * {@inheritDoc}
	 */
	public FileChunk downloadFileChunk(String sessionId, String projectId, FileTransferInformation fileInformation)
		throws EmfStoreException, RemoteException {
		return emfStore.downloadFileChunk((SessionId) SerializationUtil.stringToEObject(sessionId),
			(ProjectId) SerializationUtil.stringToEObject(projectId), fileInformation);
	}

	/**
	 * {@inheritDoc}
	 */
	public void transmitProperty(String sessionId, String changedProperty, String user, String projectId)
		throws EmfStoreException, RemoteException {
		emfStore.transmitProperty((SessionId) SerializationUtil.stringToEObject(sessionId),
			(OrgUnitProperty) SerializationUtil.stringToEObject(changedProperty),
			(ACUser) SerializationUtil.stringToEObject(user), (ProjectId) SerializationUtil.stringToEObject(projectId));
	}
}
