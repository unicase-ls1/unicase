/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.server;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.Project;
import org.unicase.model.util.ModelUtil;
import org.unicase.model.util.SerializationException;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.connectionmanager.KeyStoreManager;
import org.unicase.workspace.test.SetupHelper;
import org.unicase.workspace.test.projectGenerator.TestProjectGenerator;
import org.unicase.workspace.test.projectGenerator.TestProjectParmeters;

/**
 * Superclass for server tests.
 * 
 * @author wesendon
 */
public class ServerTests {

	/**
	 * @return the sessionId
	 */
	public static SessionId getSessionId() {
		return sessionId;
	}

	/**
	 * @return the connectionManager
	 */
	public static ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	/**
	 * @return the generatedProject
	 */
	public static Project getGeneratedProject() {
		return generatedProject;
	}

	/**
	 * @return the generatedProjectId
	 */
	public static ProjectId getGeneratedProjectId() {
		return generatedProjectId;
	}

	/**
	 * @return the projectsOnServerBeforeTest
	 */
	public static int getProjectsOnServerBeforeTest() {
		return projectsOnServerBeforeTest;
	}

	private static SessionId sessionId;
	private static ConnectionManager connectionManager;
	private static Project generatedProject;
	private static ProjectId generatedProjectId;
	private static int projectsOnServerBeforeTest;

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
		TestProjectGenerator projectGenerator = new TestProjectGenerator(new TestProjectParmeters());
		generatedProject = projectGenerator.generateProject();
		projectsOnServerBeforeTest = 1;
	}

	/**
	 * @param serverInfo serverinfo
	 * @throws EmfStoreException in case of failure
	 */
	protected static void login(ServerInfo serverInfo) throws EmfStoreException {
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
	 * Adds a project to the server before test.
	 * 
	 * @throws EmfStoreException in case of failure
	 */
	@Before
	public void beforeTest() throws EmfStoreException {
		generatedProjectId = connectionManager.createProject(sessionId, "initialProject", "TestProject",
			SetupHelper.getLogMessage("super", "a logmessage"), generatedProject).getProjectId();
	}

	/**
	 * Removes all projects from server after test.
	 * 
	 * @throws EmfStoreException in case of failure
	 */
	@After
	public void afterTest() throws EmfStoreException {
		for (ProjectInfo info : connectionManager.getProjectList(sessionId)) {
			connectionManager.deleteProject(sessionId, info.getProjectId(), true);
		}
	}
}