/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.server;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.ConnectionException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.ModelFactory;
import org.unicase.model.Project;
import org.unicase.model.util.ModelUtil;
import org.unicase.model.util.SerializationException;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.connectionmanager.KeyStoreManager;
import org.unicase.workspace.test.SetupHelper;

/**
 * This TestCase tests all methods in the main {@link org.unicase.emfstore.EmfStore} interface.
 * 
 * @author wesendon
 */
public class ServerInterfaceTest {

	private static SessionId sessionId;
	private static ConnectionManager connectionManager;

	/**
	 * Start server and gain sessionid.
	 * 
	 * @throws EmfStoreException in case of failure
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws EmfStoreException {
		SetupHelper.startSever();
		connectionManager = WorkspaceManager.getInstance().getConnectionManager();
		login(SetupHelper.getServerInfo());
	}

	private static void login(ServerInfo serverInfo) throws ConnectionException, AccessControlException {
		sessionId = connectionManager.logIn("super", KeyStoreManager.getInstance().encrypt("super", serverInfo),
			serverInfo, Configuration.getClientVersion());
	}

	/**
	 * Shuts down server after testing.
	 */
	@AfterClass
	public static void tearDownAfterClass() {
		SetupHelper.stopServer();
		SetupHelper.cleanupServer();
	}

	/**
	 * Compares two projects.
	 * 
	 * @param expected expected
	 * @param compare to be compared
	 */
	public static void assertEqual(Project expected, Project compare) {
		try {
			if (!ModelUtil.eObjectToString(expected).equals(ModelUtil.eObjectToString(compare))) {
				throw new AssertionError("Projects are not equal.");
			}
		} catch (SerializationException e) {
			throw new AssertionError("Couldn't compare projects.");
		}
	}

	/**
	 * If the user is logged in, the result of resolve user mustn't be null.
	 * 
	 * @see org.unicase.emfstore.EmfStore#resolveUser(SessionId, org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId)
	 * @throws EmfStoreException in case of failure
	 */
	@Test
	public void resolveUserTest() throws EmfStoreException {
		assertTrue(connectionManager.resolveUser(sessionId, null) != null);

		// TODO: test with orgunitid argument
	}

	/**
	 * Creates a project on the server and then deletes it.
	 * 
	 * @see org.unicase.emfstore.EmfStore#createProject(SessionId, String, String,
	 *      org.unicase.emfstore.esmodel.versioning.LogMessage)
	 * @see org.unicase.emfstore.EmfStore#getProjectList(SessionId)
	 * @see org.unicase.emfstore.EmfStore#deleteProject(SessionId, org.unicase.emfstore.esmodel.ProjectId, boolean)
	 * @throws EmfStoreException in case of failure.
	 */
	@Test
	public void createEmptyProjectAndDelete() throws EmfStoreException {
		assertTrue(connectionManager.getProjectList(sessionId).size() == 0);

		ProjectInfo projectInfo = connectionManager.createProject(sessionId, "createEmptyProjectAndDelete",
			"TestProject", SetupHelper.getLogMessage("super", "a logmessage"));

		assertTrue(connectionManager.getProjectList(sessionId).size() == 1);

		connectionManager.deleteProject(sessionId, projectInfo.getProjectId(), false);

		assertTrue(connectionManager.getProjectList(sessionId).size() == 0);
	}

	/**
	 * Creates a project, shares it with the server and then deletes it.
	 * 
	 * @see org.unicase.emfstore.EmfStore#createProject(SessionId, String, String,
	 *      org.unicase.emfstore.esmodel.versioning.LogMessage, Project)
	 * @see org.unicase.emfstore.EmfStore#getProjectList(SessionId)
	 * @see org.unicase.emfstore.EmfStore#deleteProject(SessionId, org.unicase.emfstore.esmodel.ProjectId, boolean)
	 * @throws EmfStoreException in case of failure.
	 */
	@Test
	public void shareProjectAndDelete() throws EmfStoreException {
		assertTrue(connectionManager.getProjectList(sessionId).size() == 0);

		Project project = ModelFactory.eINSTANCE.createProject();

		ProjectInfo projectInfo = connectionManager.createProject(sessionId, "createProjectAndDelete", "TestProject",
			SetupHelper.getLogMessage("super", "a logmessage"), project);

		assertNotNull(project);
		assertTrue(connectionManager.getProjectList(sessionId).size() == 1);
		assertEqual(project, connectionManager.getProject(sessionId, projectInfo.getProjectId(),
			VersionSpec.HEAD_VERSION));

		connectionManager.deleteProject(sessionId, projectInfo.getProjectId(), false);

		assertTrue(connectionManager.getProjectList(sessionId).size() == 0);
	}

	/**
	 * Deletes session on server and creates new one.
	 * 
	 * @throws EmfStoreException in case of failure
	 */
	@Test
	public void logOutTest() throws EmfStoreException {
		Assert.assertNotNull(connectionManager.resolveUser(sessionId, null));
		connectionManager.logout(sessionId);
		try {
			connectionManager.resolveUser(sessionId, null);
			// if no exception is thrown at this point, the test fails.
			Assert.assertTrue(false);
		} catch (AccessControlException e) {
			Assert.assertTrue(true);
		}
		// relogin for next test
		login(SetupHelper.getServerInfo());
		Assert.assertNotNull(connectionManager.resolveUser(sessionId, null));
	}

	//
	// /**
	// *
	// * @throws EmfStoreException in case of failure
	// */
	// @Test
	// public void createVersion() throws EmfStoreException {
	// assertTrue(connectionManager.getProjectList(sessionId).size() == 0);
	//
	// ProjectInfo projectInfo = connectionManager.createProject(sessionId, "createVersion", "TestProject",
	// SetupHelper.getLogMessage("super", "a logmessage"));
	//
	// assertTrue(connectionManager.getProjectList(sessionId).size() == 1);
	//
	// ChangePackage changePackage = VersioningFactory.eINSTANCE.createChangePackage();
	// AttributeOperation operation = OperationsFactory.eINSTANCE.createAttributeOperation();
	// operation.setFeatureName("bla");
	// operation.setModelElementId(ModelUtil.createModelElementId("bla"));
	// }
}
