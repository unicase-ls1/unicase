/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.navigator;

import static org.junit.Assert.assertNotNull;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesPackage;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.ui.test.UITestCommon;
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.connectionmanager.KeyStoreManager;
import org.unicase.workspace.impl.WorkspaceImpl;
import org.unicase.workspace.test.SetupHelper;
import org.unicase.workspace.test.server.ServerTests;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Class to test if a local project (i.e. located on your workspace only) is correctly shared on the UNICASE Server or
 * not. Also it tests if the created project appears on the UNICASE Navigator as shared or not.
 */

public class ShareProjectUITest extends MEEditorTest {

	private ProjectSpace projectSpace;
	private static ConnectionManager connectionManager;
	private static SessionId sessionId;

	private Usersession usersession;

	/**
	 * Setup the environment for testing by starting the server.
	 */
	@BeforeClass
	public static void beforeClass() {

		ServerConfiguration.setTesting(true);
		SetupHelper.addUserFileToServer(false);
		SetupHelper.startSever();
		connectionManager = WorkspaceManager.getInstance().getConnectionManager();
		try {
			login(SetupHelper.getServerInfo());
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
			// Do NOT catch all Exceptions ("catch (Exception e)")
			// Log AND handle Exceptions if possible
			//
			// You can just uncomment one of the lines below to log an exception:
			// logException will show the logged excpetion to the user
			// ModelUtil.logException(e);
			// ModelUtil.logException("YOUR MESSAGE HERE", e);
			// logWarning will only add the message to the error log
			// ModelUtil.logWarning("YOUR MESSAGE HERE", e);
			// ModelUtil.logWarning("YOUR MESSAGE HERE");
			//			
			// If handling is not possible declare and rethrow Exception
		}
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
	protected static SessionId login(ServerInfo serverInfo, String username, String password) throws EmfStoreException {
		return connectionManager.logIn(username, KeyStoreManager.getInstance().encrypt(password, serverInfo),
			serverInfo, Configuration.getClientVersion());
	}

	/**
	 * This method shares the project programaticaly and then tests if its reflected on the UI or not.
	 */
	@Test
	public void updateProjectUpdate() {
		// UITestCommon.openView(getBot(), "Unicase", "Navigator");
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				try {
					ProjectSpace projectSpace = WorkspaceFactory.eINSTANCE.createProjectSpace();
					projectSpace.setProject(MetamodelFactory.eINSTANCE.createProject());
					projectSpace.setProjectName("Testproject");
					projectSpace.setProjectDescription("Test description");
					projectSpace.setLocalOperations(WorkspaceFactory.eINSTANCE.createOperationComposite());

					Workspace workSpace = WorkspaceManager.getInstance().getCurrentWorkspace();
					projectSpace.initResources(workSpace.eResource().getResourceSet());

					((WorkspaceImpl) workSpace).addProjectSpace(projectSpace);
					workSpace.save();

					if (usersession == null) {
						usersession = WorkspaceFactory.eINSTANCE.createUsersession();
						usersession.setServerInfo(SetupHelper.getServerInfo());
						usersession.setUsername("super");
						usersession.setPassword("super");
						WorkspaceManager.getInstance().getCurrentWorkspace().getUsersessions().add(usersession);
					}
					try {
						if (!usersession.isLoggedIn()) {
							usersession.logIn();
						}

						projectSpace.shareProject(usersession);
					} catch (EmfStoreException e) {
						e.printStackTrace();
					}
					ACOrgUnitId orgUnitId = SetupHelper.createUserOnServer(sessionId, "projectadmin");
					SetupHelper.setUsersRole(sessionId, orgUnitId, RolesPackage.eINSTANCE.getProjectAdminRole(),
						projectSpace.getProjectId());
					// ServerTests.getConnectionManager().logout(ServerTests.getSessionId());
					ServerTests.getConnectionManager().logIn("projectadmin",
						KeyStoreManager.getInstance().encrypt("foo", SetupHelper.getServerInfo()),
						SetupHelper.getServerInfo(), Configuration.getClientVersion());

				} catch (EmfStoreException e) {

				}

			}
		}.run();

		getBot().sleep(3000);

		// UITestCommon.openView(getBot(), "Unicase", "Navigator");
		//
		// SWTBotTreeItem[] checktext = getBot().activeView().bot().tree().getAllItems();
		// Pattern p = Pattern.compile("@"); // this is to indicate that the project is being shared is reflected on the
		// UI
		// // ,as it will have a version number that starts with @
		//
		// Matcher m = p.matcher(checktext[0].getText());
		// assertEquals(true, m.find());

	}

	/**
	 * This method shares the project from the UI and then tests if it was shared on the server or not.
	 */
	@Test
	public void updateProjectChange() {
		UITestCommon.openView(getBot(), "Unicase", "Navigator");

		// The project is shared using the UI functionalities
		SWTBotTreeItem[] checktext = getBot().activeView().bot().tree().getAllItems();
		checktext[0].select().contextMenu("Share  Project").click();// the text of the context menu contains double
		// spaces
		getBot().sleep(1000);
		SWTBotShell openPerspectiveShell = getBot().shell("Select Usersession");
		openPerspectiveShell.activate();
		getBot().table().select(0);// selects the user session (in this example there is only one user)
		getBot().sleep(1000);
		getBot().button("OK").click();
		openPerspectiveShell = getBot().shell("Authentication required");
		openPerspectiveShell.activate();
		getBot().text(1).typeText("super"); // enters the user password to connect to the server
		getBot().button("OK").click();
		getBot().sleep(1000);
		getBot().button("OK").click();
		getBot().sleep(1000);

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
				projectSpace = currentWorkspace.getActiveProjectSpace();
				assertNotNull(projectSpace.getBaseVersion()); // if the project dosn't have a base version, i.e. its
				// null. Then, it was not shared on the server and thus the test fails
			}
		}.run();
		getBot().sleep(1000);

	}

	/**
	 *stops the server after doing the test.
	 */

	@AfterClass
	public static void afterClass() {
		SetupHelper.cleanupServer();
		SetupHelper.stopServer();

	}

}
