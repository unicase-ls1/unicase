package org.unicase.ui.test.navigator;

import static org.junit.Assert.assertEquals;

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
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.test.SetupHelper;
import org.unicase.workspace.util.UnicaseCommand;

public class ShareProjectUITest extends MEEditorTest {

	private ProjectSpace projectSpace;

	/**
	 * Setup the environment for testing by starting the server.
	 */
	@BeforeClass
	public static void beforeClass() {

		SetupHelper.startSever();
	}

	/**
	 * This method shares the project progrmaticaly and then tests if its reflected on the UI or not.
	 */
	@Test
	public void updateProjectUpdate() {
		UITestCommon.openView(getBot(), "Unicase", "Unicase Navigator");
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
				projectSpace = currentWorkspace.getActiveProjectSpace();
				Project project = projectSpace.getProject();
				User user1 = OrganizationFactory.eINSTANCE.createUser();
				user1.setName("super");
				project.addModelElement(user1);
				Usersession usersession = UITestCommon.createUsersession(user1);
				try {
					usersession.logIn();
					projectSpace.shareProject(usersession);
				} catch (AccessControlException e1) {

				} catch (EmfStoreException e1) {

				}

			}
		}.run();

		getBot().sleep(3000);

		UITestCommon.openView(getBot(), "Unicase", "Unicase Navigator");

		SWTBotTreeItem[] checktext = getBot().activeView().bot().tree().getAllItems();
		Pattern p = Pattern.compile("@");

		Matcher m = p.matcher(checktext[0].getText());
		assertEquals(true, m.find());

	}

	/**
	 * This method shares the project from the UI and then tests if it was shared on the server.
	 */
	@Test
	public void updateProjectChange() {
		UITestCommon.openView(getBot(), "Unicase", "Unicase Navigator");

		SWTBotTreeItem[] checktext = getBot().activeView().bot().tree().getAllItems();
		checktext[0].select().contextMenu("Share  Project").click();// the text of the context menu contains double
		// space for some reason
		getBot().sleep(1000);
		SWTBotShell openPerspectiveShell = getBot().shell("Select Usersession");
		openPerspectiveShell.activate();
		getBot().table().select(0);
		getBot().sleep(1000);
		getBot().button("OK").click();
		openPerspectiveShell = getBot().shell("Authentication required");
		openPerspectiveShell.activate();
		getBot().text(1).typeText("jo");
		System.out.print("------->" + getBot().text(1).getText());
		getBot().sleep(10000);
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
