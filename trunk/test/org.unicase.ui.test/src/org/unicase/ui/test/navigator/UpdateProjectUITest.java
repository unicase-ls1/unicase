package org.unicase.ui.test.navigator;

import org.junit.Before;
import org.junit.Test;
import org.unicase.metamodel.Project;
import org.unicase.ui.test.UITestCommon;
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.test.SetupHelper;
import org.unicase.workspace.util.UnicaseCommand;

public class UpdateProjectUITest extends MEEditorTest {
	Project newproject = null;

	/**
	 * Setup the environment for testing.
	 */
	@Before
	public void setupActionItem() {

		SetupHelper.startSever();
	}

	@Test
	public void updateProjectUpdate() {

		UITestCommon.openPerspective(getBot(), "Unicase");

		new UnicaseCommand() {

			@Override
			protected void doRun() {

			}
		}.run();

		UITestCommon.openView(getBot(), "Unicase", "Unicase Navigator");

	}

	@Test
	public void updateProjectChange() {

	}
}
