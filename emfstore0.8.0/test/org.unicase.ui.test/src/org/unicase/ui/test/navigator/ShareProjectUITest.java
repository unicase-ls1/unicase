/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.navigator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.metamodel.Project;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.organization.User;
import org.unicase.ui.test.UITestCommon;
import org.unicase.ui.test.UITestSetup;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.test.SetupHelper;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Class to test if a local project (i.e. located on your workspace only) is correctly shared on the UNICASE Server or
 * not. Also it tests if the created project appears on the UNICASE Navigator as shared or not.
 */

public class ShareProjectUITest extends UITestSetup {

	private ProjectSpace projectSpace;

	/**
	 * Setup the environment for testing by starting the server.
	 */
	@BeforeClass
	public static void beforeClass() {

		SetupHelper.startSever();
	}

	/**
	 * This method shares the project programaticaly and then tests if its reflected on the UI or not.
	 */
	@Test
	public void updateProjectUpdate() {
		UITestCommon.openView(getBot(), "Unicase", "Navigator");
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
				projectSpace = currentWorkspace.getActiveProjectSpace();
				Project project = projectSpace.getProject();
				User user1 = OrganizationFactory.eINSTANCE.createUser();
				user1.setName("super");
				project.addModelElement(user1);
				Usersession usersession = UITestCommon.createUsersession(user1, "super");
				try {
					usersession.logIn();
					projectSpace.shareProject(usersession); // the project has been shared programaticaly using the
					// command shareProject();
				} catch (AccessControlException e1) {

				} catch (EmfStoreException e1) {

				}

			}
		}.run();

		getBot().sleep(3000);

		UITestCommon.openView(getBot(), "Unicase", "Navigator");

		SWTBotTreeItem[] checktext = getBot().activeView().bot().tree().getAllItems();
		Pattern p = Pattern.compile("@"); // this is to indicate that the project is being shared is reflected on the UI
		// ,as it will have a version number that starts with @

		Matcher m = p.matcher(checktext[0].getText());
		assertEquals(true, m.find());

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
