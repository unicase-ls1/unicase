/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.connectionmanager;

import java.util.ArrayList;
import java.util.List;

import org.unicase.emfstore.EmfStoreStub;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HeadVersionSpec;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.ConnectionException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.Project;
import org.unicase.workspace.ServerInfo;

/**
 * Stub implementation of connection manager, only supports few basic
 * operations.
 * 
 * @author koegel
 * 
 */
public class StubConnectionManagerImpl implements ConnectionManager {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.EmfStore#createVersion(org.unicase.emfstore.esmodel.SessionId,
	 *      org.unicase.emfstore.esmodel.ProjectId,
	 *      org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec,
	 *      org.unicase.emfstore.esmodel.versioning.ChangePackage,
	 *      org.unicase.emfstore.esmodel.versioning.LogMessage)
	 */
	public PrimaryVersionSpec createVersion(SessionId sessionId,
			ProjectId projectId, PrimaryVersionSpec baseVersionSpec,
			ChangePackage changePackage, LogMessage logMessage)
			throws ConnectionException {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.EmfStore#getChanges(org.unicase.emfstore.esmodel.SessionId,
	 *      org.unicase.emfstore.esmodel.ProjectId,
	 *      org.unicase.emfstore.esmodel.versioning.VersionSpec,
	 *      org.unicase.emfstore.esmodel.versioning.VersionSpec)
	 */
	public List<ChangePackage> getChanges(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws ConnectionException {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.EmfStore#getHistoryInfo(org.unicase.emfstore.esmodel.SessionId,
	 *      org.unicase.emfstore.esmodel.ProjectId,
	 *      org.unicase.emfstore.esmodel.versioning.VersionSpec,
	 *      org.unicase.emfstore.esmodel.versioning.VersionSpec)
	 */
	public List<HistoryInfo> getHistoryInfo(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws ConnectionException {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.EmfStore#getProject(org.unicase.emfstore.esmodel.SessionId,
	 *      org.unicase.emfstore.esmodel.ProjectId,
	 *      org.unicase.emfstore.esmodel.versioning.VersionSpec)
	 */
	public Project getProject(SessionId sessionId, ProjectId projectId,
			VersionSpec versionSpec) throws ConnectionException {
		return EmfStoreStub.createDummyProject();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.EmfStore#getProjectList(org.unicase.emfstore.esmodel.SessionId)
	 */
	public List<ProjectInfo> getProjectList(SessionId sessionId)
			throws ConnectionException {
		List<ProjectInfo> ret = new ArrayList<ProjectInfo>();

		ProjectId projectId = EsmodelFactory.eINSTANCE.createProjectId();

		HeadVersionSpec headVersionSpec = VersioningFactory.eINSTANCE
				.createHeadVersionSpec();

		ProjectInfo projectInfo = EsmodelFactory.eINSTANCE.createProjectInfo();
		projectInfo.setName("TestProject");
		projectInfo.setDescription("A test Project");
		projectInfo.setProjectId(projectId);
		projectInfo.setVersion(resolveVersionSpec(sessionId, projectId,
				headVersionSpec));

		ret.add(projectInfo);
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.connectionmanager.ConnectionManager#logIn(java.lang.String,
	 *      java.lang.String, org.unicase.workspace.ServerInfo)
	 */
	public SessionId logIn(String username, String password,
			ServerInfo severInfo) throws ConnectionException {
		return EsmodelFactory.eINSTANCE.createSessionId();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.EmfStore#resolveVersionSpec(org.unicase.emfstore.esmodel.SessionId,
	 *      org.unicase.emfstore.esmodel.ProjectId,
	 *      org.unicase.emfstore.esmodel.versioning.VersionSpec)
	 */
	public PrimaryVersionSpec resolveVersionSpec(SessionId sessionId,
			ProjectId projectId, VersionSpec versionSpec) {
		PrimaryVersionSpec primaryVersionSpec = VersioningFactory.eINSTANCE
				.createPrimaryVersionSpec();
		primaryVersionSpec.setIdentifier(1);
		return primaryVersionSpec;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.EmfStore#createProject(org.unicase.emfstore.esmodel.SessionId,
	 *      java.lang.String, java.lang.String,
	 *      org.unicase.emfstore.esmodel.versioning.LogMessage)
	 */
	public ProjectInfo createProject(SessionId sessionid, String name,
			String description, LogMessage logMessage) throws EmfStoreException {
		throw new UnsupportedOperationException();
	}

}
