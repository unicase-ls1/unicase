/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.meeditor.mecontrol;

import static org.junit.Assert.assertEquals;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotStyledText;
import org.junit.Before;
import org.junit.Test;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Test the description page for an ME.
 * 
 * @author Nitesh
 */
public class MEDescriptionPageTest extends MEEditorTest {

	private ActionItem actionItem;

	/**
	 * Helper method to be run before test cases within this class.
	 */
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

	/**
	 * Test the desription by changing it from UI and then validating the input in underlying ME.Also confirms if the
	 * description page have the same text as in Description field of that ME.
	 */
	@Test
	public void testDescriptionChange() {
		openModelElement(actionItem);
		final String newDescription = "Hello...now i am changing the description from the description tab";
		getBot().activeEditor().bot().cTabItem("Description").activate();
		getBot().activeEditor().bot().styledText().typeText(newDescription);
		getBot().activeEditor().bot().cTabItem("Standard View").activate();
		SWTBotStyledText styledText = getBot().activeEditor().bot().styledTextWithLabel("Description");
		String existingText = styledText.getText();
		assertEquals(newDescription, existingText);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				String finalDescription = actionItem.getDescription();
				assertEquals(newDescription, finalDescription);
			}
		}.run();

	}

	/**
	 * Change the description from background and see if it gets reflected in UI.
	 */
	@Test
	public void testDescriptionUpdate() {
		openModelElement(actionItem);
		final String newDescription = "Hello...now i am changing the description programatically.";
		getBot().activeEditor().bot().cTabItem("Description").activate();
		getBot().sleep(2000);
		UnicaseCommand unicaseCommand = new UnicaseCommand() {
			@Override
			protected void doRun() {
				actionItem.setDescription(newDescription);
			}
		};
		runAsnc(unicaseCommand);

		String existingText = getBot().activeEditor().bot().styledText().getText();
		assertEquals(newDescription, existingText);

		getBot().activeEditor().bot().cTabItem("Standard View").activate();
		String descriptionfromSV = getBot().activeEditor().bot().styledText().getText();
		assertEquals(newDescription, descriptionfromSV);
		getBot().sleep(2000);
	}

}
