package org.unicase.ui.test.navigator;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.unicase.metamodel.Project;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.ui.test.UITestCommon;
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.test.SetupHelper;
import org.unicase.workspace.util.UnicaseCommand;

public class UpdateProjectUITest extends MEEditorTest {
	Project newproject = null;
	final LeafSection leafSection = DocumentFactory.eINSTANCE.createLeafSection();

	/**
	 * Setup the environment for testing.
	 */

	@BeforeClass
	public static void beforeClass() throws Exception {

		SetupHelper.startSever();
	}

	@Test
	public void updateProjectUpdate() {

		UITestCommon.openPerspective(getBot(), "Unicase");

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				leafSection.setName("TestLeafSection");
				getProjectSpace().getProject().addModelElement(leafSection);
			}
		}.run();

		UITestCommon.openView(getBot(), "Unicase", "Unicase Navigator");

	}

	@Test
	public void updateProjectChange() {

	}

	@AfterClass
	public static void afterClass() {
		SetupHelper.stopServer();

	}
}
