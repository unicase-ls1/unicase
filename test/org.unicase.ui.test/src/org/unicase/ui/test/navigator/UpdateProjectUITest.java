/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.navigator;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.exceptions.ConnectionException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.document.LeafSection;
import org.unicase.ui.test.UITestCommon;
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.test.SetupHelper;
import org.unicase.workspace.test.server.ServerTests;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Class to test if a project is is updated correctly in a way that the project is successfully synchronized between the
 * UI and the UNICASE repository .
 */
public class UpdateProjectUITest extends MEEditorTest {

	private static ProjectSpace projectSpace;
	private static LeafSection leafSection;
	private static SessionId sessionId;

	/**
	 * Setup the environment for testing by starting the server, loging with the admin.
	 */
	@BeforeClass
	public static void beforeClass() {

		SetupHelper.startSever();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				// Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
				// projectSpace = currentWorkspace.getActiveProjectSpace();
				// Project project = projectSpace.getProject();
				try {
					sessionId = ServerTests.login(SetupHelper.getServerInfo(), "super", "super");
				} catch (EmfStoreException e1) {
					// Exception
				}
				try {
					WorkspaceManager.getInstance().getAdminConnectionManager().initConnection(
						SetupHelper.getServerInfo(), sessionId);
				} catch (ConnectionException e1) {

					// Exception
				}
				try {
					ServerTests.setupUsers();
				} catch (EmfStoreException e) {

				}

			}
		}.run();

	}

	/**
	 * Creates a project "TestProject" in the workspace and then adds a new composite and a leaf section. Then it
	 * updates the server using UNICASE command. Then a check is performed to see if the project updated within the UI
	 * or Not.
	 */

	@Test
	public void updateProjectUpdate() {
		UITestCommon.openView(getBot(), "Unicase", "Unicase Navigator");

		getBot().sleep(30000);
	}

	/**
	 * Create a project "TestProject" in the workspace and add a composite and a leaf section.
	 */

	@Test
	public void updateProjectChange() {

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
