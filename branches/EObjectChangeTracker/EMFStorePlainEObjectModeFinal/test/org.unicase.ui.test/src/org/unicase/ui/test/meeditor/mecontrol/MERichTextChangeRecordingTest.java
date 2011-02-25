package org.unicase.ui.test.meeditor.mecontrol;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.ui.test.UITestCommon;
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.util.UnicaseCommand;

public class MERichTextChangeRecordingTest extends MEEditorTest {
	private ActionItem actionItem;

	@Before
	public void setupActionItem() {
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actionItem = TaskFactory.eINSTANCE.createActionItem();
				actionItem.setName("My ActionItem");
				getLeafSection().getModelElements().add(actionItem);
			}
		}.run();
	}

	@Test
	public void hasnotificationOnSelectOnly() {
		UITestCommon.openPerspective(getBot(), "Unicase");
		openModelElement(actionItem);
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProjectSpace().getOperations().clear();

			}
		}.run();
		assertEquals(0, getProjectSpace().getOperations().size());
		getBot().activeEditor().bot().styledTextWithLabel("Description").typeText("");
		getBot().sleep(5000);
		getBot().activeEditor().bot().textWithLabel("Name").setFocus();
		// If this fails then there is a problem as ther eshould not be a set operation recorded unitl something is
		// changed!
		assertEquals(0, getProjectSpace().getOperations().size());
	}
}
