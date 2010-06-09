package org.unicase.ui.test.navigator;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Test;
import org.unicase.metamodel.Project;
import org.unicase.ui.test.UITestCommon;
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

public class DeleteProjectUITest extends MEEditorTest {
	Project newproject = null;
	boolean testcondition = true;

	/**
	 * Setup the environment for testing.
	 */
	@Test
	public void deleteProjectUpdate() {

		UITestCommon.openPerspective(getBot(), "Unicase");

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

		UITestCommon.openView(getBot(), "Unicase", "Unicase Navigator");

		SWTBotTreeItem[] treenode = getBot().activeView().bot().tree().getAllItems();
		testcondition = treenode.length == 0;
		assertTrue(testcondition);

	}

	@Test
	public void deleteProjectChange() {

		UITestCommon.openView(getBot(), "Unicase", "Unicase Navigator");

		getBot().sleep(4000);

		SWTBotTreeItem[] treenode = getBot().activeView().bot().tree().getAllItems();
		treenode[0].select().contextMenu("Delete Project").click();
		getBot().sleep(4000);
		getBot().button("Yes").click();

		new UnicaseCommand() {
			@Override
			protected void doRun() {

				testcondition = getProjectSpace().getProject().getAllModelElements().isEmpty();
				// assertTrue(projectName.toLowerCase().startsWith("testproject"));
			}
		}.run();

	}
}
