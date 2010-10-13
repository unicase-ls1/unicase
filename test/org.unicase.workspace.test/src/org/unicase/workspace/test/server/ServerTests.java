/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.server;

import java.util.HashMap;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId;
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolFactory;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesPackage;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HistoryQuery;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.TagVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.InvalidInputException;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.metamodel.util.SerializationException;
import org.unicase.projectgenerator.TestProjectGenerator;
import org.unicase.projectgenerator.TestProjectParmeters;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.connectionmanager.KeyStoreManager;
import org.unicase.workspace.test.SetupHelper;

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

	/**
	 * @return the generatedProjectVersion
	 */
	public static PrimaryVersionSpec getGeneratedProjectVersion() {
		return generatedProjectVersion;
	}

	private static SessionId sessionId;
	private static ConnectionManager connectionManager;
	private static Project generatedProject;
	private static ProjectId generatedProjectId;
	private static int projectsOnServerBeforeTest;
	private static PrimaryVersionSpec generatedProjectVersion;
	private static HashMap<Class<?>, Object> arguments;

	/**
	 * Start server and gain sessionid
	 * 
	 * @throws EmfStoreException in case of failure
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws EmfStoreException {
		ServerConfiguration.setTesting(true);
		SetupHelper.addUserFileToServer(false);
		SetupHelper.startSever();
		connectionManager = WorkspaceManager.getInstance().getConnectionManager();
		login(SetupHelper.getServerInfo());
		TestProjectGenerator projectGenerator = new TestProjectGenerator(new TestProjectParmeters());
		generatedProject = projectGenerator.generateProject();
		projectsOnServerBeforeTest = 1;
		initArguments();
	}

	public static void setupUsers() throws EmfStoreException {
		try {
			ACOrgUnitId orgUnitId = SetupHelper.createUserOnServer(getSessionId(), "reader");
			SetupHelper.setUsersRole(getSessionId(), orgUnitId, RolesPackage.eINSTANCE.getReaderRole(),
				getGeneratedProjectId());

			orgUnitId = SetupHelper.createUserOnServer(getSessionId(), "writer");
			SetupHelper.setUsersRole(getSessionId(), orgUnitId, RolesPackage.eINSTANCE.getWriterRole(),
				getGeneratedProjectId());

			orgUnitId = SetupHelper.createUserOnServer(getSessionId(), "projectadmin");
			SetupHelper.setUsersRole(getSessionId(), orgUnitId, RolesPackage.eINSTANCE.getProjectAdminRole(),
				getGeneratedProjectId());
		} catch (InvalidInputException e) {
			// do nothing, user already exists.
		}
	}

	/**
	 * Sets the connection manager.
	 * 
	 * @param cm connection manager
	 */
	protected static void setConnectionManager(ConnectionManager cm) {
		connectionManager = cm;
	}

	/**
	 * @param serverInfo serverinfo
	 * @throws EmfStoreException in case of failure
	 */
	protected static void login(ServerInfo serverInfo) throws EmfStoreException {
		sessionId = login(serverInfo, "super", "super");
		WorkspaceManager.getInstance().getAdminConnectionManager().initConnection(serverInfo, sessionId);
	}

	/**
	 * @param serverInfo serverinfo
	 * @param username username
	 * @param password password
	 * @return sessionId
	 * @throws EmfStoreException in case of failure
	 */
	public static SessionId login(ServerInfo serverInfo, String username, String password) throws EmfStoreException {
		return connectionManager.logIn(username, KeyStoreManager.getInstance().encrypt(password, serverInfo),
			serverInfo, Configuration.getClientVersion());
	}

	/**
	 * Shuts down server after testing.
	 */
	@AfterClass
	public static void tearDownAfterClass() {
		SetupHelper.stopServer();
		// SetupHelper.cleanupServer();
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
		ProjectInfo projectInfo = connectionManager.createProject(sessionId, "initialProject", "TestProject",
			SetupHelper.createLogMessage("super", "a logmessage"), generatedProject);
		generatedProjectId = projectInfo.getProjectId();
		generatedProjectVersion = projectInfo.getVersion();
		setupUsers();
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

	/**
	 * Creates a historyquery.
	 * 
	 * @param ver1 source
	 * @param ver2 target
	 * @return historyquery
	 */
	public static HistoryQuery createHistoryQuery(PrimaryVersionSpec ver1, PrimaryVersionSpec ver2) {
		HistoryQuery historyQuery = VersioningFactory.eINSTANCE.createHistoryQuery();
		historyQuery.setSource((PrimaryVersionSpec) EcoreUtil.copy(ver1));
		historyQuery.setTarget((PrimaryVersionSpec) EcoreUtil.copy(ver2));
		return historyQuery;
	}

	private static void initArguments() {
		arguments = new HashMap<Class<?>, Object>();
		arguments.put(boolean.class, false);
		arguments.put(String.class, new String());
		arguments.put(SessionId.class, EcoreUtil.copy(getSessionId()));
		arguments.put(ProjectId.class, EsmodelFactory.eINSTANCE.createProjectId());
		arguments.put(PrimaryVersionSpec.class, VersioningFactory.eINSTANCE.createPrimaryVersionSpec());
		arguments.put(VersionSpec.class, VersioningFactory.eINSTANCE.createPrimaryVersionSpec());
		arguments.put(TagVersionSpec.class, VersioningFactory.eINSTANCE.createTagVersionSpec());
		arguments.put(LogMessage.class, VersioningFactory.eINSTANCE.createLogMessage());
		arguments.put(Project.class, MetamodelFactory.eINSTANCE.createProject());
		arguments.put(ChangePackage.class, VersioningFactory.eINSTANCE.createChangePackage());
		arguments.put(HistoryQuery.class, VersioningFactory.eINSTANCE.createHistoryQuery());
		arguments.put(ChangePackage.class, VersioningFactory.eINSTANCE.createChangePackage());
		arguments.put(ACOrgUnitId.class, AccesscontrolFactory.eINSTANCE.createACOrgUnitId());
	}

	/**
	 * Get a default Parameter.
	 * 
	 * @param clazz parameter type
	 * @param b if false, null is returned
	 * @return parameter
	 */
	protected static Object getParameter(Class<?> clazz, boolean b) {
		if (clazz.equals(boolean.class)) {
			return false;
		}
		return (b) ? arguments.get(clazz) : null;
	}
}