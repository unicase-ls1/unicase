/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.server;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.Project;
import org.unicase.workspace.test.SetupHelper;

/**
 * This TestCase tests all methods in the main {@link org.unicase.emfstore.EmfStore} interface.
 * 
 * @author wesendon
 */
public class ServerInterfaceTest extends ServerTests {

	/**
	 * If the user is logged in, the result of resolve user mustn't be null.
	 * 
	 * @see org.unicase.emfstore.EmfStore#resolveUser(SessionId, org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId)
	 * @throws EmfStoreException in case of failure
	 */
	@Test
	public void resolveUserTest() throws EmfStoreException {
		assertTrue(getConnectionManager().resolveUser(getSessionId(), null) != null);

		// TODO: test with orgunitid argument
	}

	/**
	 * Gets a project from the server.
	 * 
	 * @throws EmfStoreException in case of failure
	 */
	@Test
	public void getProjectTest() throws EmfStoreException {
		Project project = getConnectionManager().getProject(getSessionId(), getGeneratedProjectId(),
			VersionSpec.HEAD_VERSION);
		assertEqual(getGeneratedProject(), project);
	}

	/**
	 * Creates a project on the server and then deletes it.
	 * 
	 * @see org.unicase.emfstore.EmfStore#createProject(SessionId, String, String,
	 *      org.unicase.emfstore.esmodel.versioning.LogMessage)
	 * @see org.unicase.emfstore.EmfStore#getProjectList(SessionId)
	 * @throws EmfStoreException in case of failure.
	 */
	@Test
	public void createEmptyProjectTest() throws EmfStoreException {
		assertTrue(getConnectionManager().getProjectList(getSessionId()).size() == getProjectsOnServerBeforeTest());

		getConnectionManager().createProject(getSessionId(), "createEmptyProjectAndDelete", "TestProject",
			SetupHelper.getLogMessage("super", "a logmessage"));

		assertTrue(getConnectionManager().getProjectList(getSessionId()).size() == getProjectsOnServerBeforeTest() + 1);
	}

	/**
	 * Creates a project, shares it with the server and then deletes it.
	 * 
	 * @see org.unicase.emfstore.EmfStore#createProject(SessionId, String, String,
	 *      org.unicase.emfstore.esmodel.versioning.LogMessage, Project)
	 * @see org.unicase.emfstore.EmfStore#getProjectList(SessionId)
	 * @throws EmfStoreException in case of failure.
	 */
	@Test
	public void shareProjectTest() throws EmfStoreException {
		assertTrue(getConnectionManager().getProjectList(getSessionId()).size() == getProjectsOnServerBeforeTest());

		ProjectInfo projectInfo = getConnectionManager().createProject(getSessionId(), "createProjectAndDelete",
			"TestProject", SetupHelper.getLogMessage("super", "a logmessage"), getGeneratedProject());

		assertTrue(getConnectionManager().getProjectList(getSessionId()).size() == getProjectsOnServerBeforeTest() + 1);
		assertNotNull(getGeneratedProject());
		assertEqual(getGeneratedProject(), getConnectionManager().getProject(getSessionId(),
			projectInfo.getProjectId(), VersionSpec.HEAD_VERSION));
	}

	/**
	 * Deletes a project on the server.
	 * 
	 * @throws EmfStoreException in case of failure
	 */
	@Test
	public void deleteProjectTest() throws EmfStoreException {
		assertTrue(getConnectionManager().getProjectList(getSessionId()).size() == getProjectsOnServerBeforeTest());

		getConnectionManager().deleteProject(getSessionId(), getGeneratedProjectId(), false);
		try {
			getConnectionManager().getProject(getSessionId(), getGeneratedProjectId(), VersionSpec.HEAD_VERSION);
			assertTrue(false);
		} catch (EmfStoreException e) {
			assertTrue(true);
		}
		assertTrue(getConnectionManager().getProjectList(getSessionId()).size() == getProjectsOnServerBeforeTest() - 1);
	}

	/**
	 * Deletes session on server and creates new one.
	 * 
	 * @throws EmfStoreException in case of failure
	 */
	@Test
	public void logOutTest() throws EmfStoreException {
		Assert.assertNotNull(getConnectionManager().resolveUser(getSessionId(), null));
		getConnectionManager().logout(getSessionId());
		try {
			getConnectionManager().resolveUser(getSessionId(), null);
			// if no exception is thrown at this point, the test fails.
			Assert.assertTrue(false);
		} catch (AccessControlException e) {
			Assert.assertTrue(true);
		}
		// relogin for next test
		login(SetupHelper.getServerInfo());
		Assert.assertNotNull(getConnectionManager().resolveUser(getSessionId(), null));
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
