package org.unicase.ui.test.navigator;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.ui.test.UITestCommon;
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.test.SetupHelper;
import org.unicase.workspace.util.UnicaseCommand;

public class UpdateProjectUITest extends MEEditorTest {
	final CompositeSection compositeSection = DocumentFactory.eINSTANCE.createCompositeSection();
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

				getProjectSpace().getProject().addModelElement(compositeSection);
				// compositeSection.addModelElementChangeListener(listener)

				leafSection.setName("TestLeafSection");
			}
		}.run();

		UITestCommon.openView(getBot(), "Unicase", "Unicase Navigator");
		getBot().sleep(10000);

	}

	@Test
	public void updateProjectChange() {

	}

	@AfterClass
	public static void afterClass() {
		SetupHelper.stopServer();

	}
}
