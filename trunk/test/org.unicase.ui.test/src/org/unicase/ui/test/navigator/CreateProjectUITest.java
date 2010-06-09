package org.unicase.ui.test.navigator;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Before;
import org.junit.Test;
import org.unicase.metamodel.Project;
import org.unicase.ui.test.UITestCommon;
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

public class CreateProjectUITest extends MEEditorTest {
	Project newproject = null;

	/**
	 * Setup the environment for testing.
	 */
	@Before
	public void setupActionItem() {

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
				try {
					currentWorkspace.deleteProjectSpace(getProjectSpace());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.run();
	}

	@Test
	public void createProjectUpdate() {
		// Creating a project, but before lets see if there is already a project in the projectspace!

		UITestCommon.openPerspective(getBot(), "Unicase");

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
				ProjectSpace projectSpace = currentWorkspace.createLocalProject("CreateProjectTest",
					"Test project description");
				newproject = projectSpace.getProject();

			}
		}.run();

		UITestCommon.openView(getBot(), "Unicase", "Unicase Navigator");

		SWTBotTreeItem[] text = getBot().activeView().bot().tree().getAllItems();
		assertTrue(text[0].getText().startsWith("CreateProjectTest"));

	}

	@Test
	public void createProjectChange() {

		UITestCommon.openView(getBot(), "Unicase", "Unicase Navigator");
		SWTBotTreeItem[] allItems = getBot().activeView().bot().tree().getAllItems();
		if (allItems.length == 0) {
			assert false;
		}
		allItems[0].select().contextMenu("Other...").getText();
		getBot().sleep(4000);
		/*
		 * getBot().textWithLabel("Name:").typeText("testproject"); getBot().button("OK").click(); new UnicaseCommand()
		 * {
		 * @Override protected void doRun() { String projectName = getProjectSpace().getProjectName();
		 * assertTrue(projectName.startsWith("testproject")); } };
		 */

	}
}
