/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.meeditor.mecontrol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotStyledText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.junit.Before;
import org.junit.Test;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.ui.test.UITestSetup;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Tests for RichTextControl, which is used for description field.
 * 
 * @author Nitesh
 */

public class MERichTextControlTest extends UITestSetup {

	private ActionItem actionItem;

	/**
	 * Helper method before the test cases run.
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
	 * Change the description from UI and confirms if with the value of underlying ME.
	 */
	@Test
	public void testDescriptionChange() {

		openModelElement(actionItem);

		SWTBotStyledText styledText = getBot().activeEditor().bot().styledTextWithLabel("Description");
		SWTBotText text = getBot().activeEditor().bot().textWithLabel("Name");
		final String newDescription = "changed text in description field by MEEditor";

		styledText.typeText(newDescription, 1);
		text.setFocus();

		getBot().sleep(3000);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				assertEquals(newDescription, actionItem.getDescription());
			}
		}.run();
	}

	/**
	 * Test existing description with line breaks. It also tests for the new description to be added at any specified
	 * place.
	 */
	@Test
	public void testExistingDescriptionChange() {
		final String newText = "This is existing description.\n";
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				actionItem.setDescription(newText);
			}
		}.run();
		openModelElement(actionItem);
		SWTBotStyledText styledText = getBot().activeEditor().bot().styledTextWithLabel("Description");
		String existingText = styledText.getText();
		assertEquals(newText, existingText);

		final String newDescription = "Changed text in description field by MEEditor in the second line.";
		styledText.typeText(1, 1, newDescription);
		getBot().activeEditor().bot().text().setFocus();
		final List<String> list = styledText.getLines();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				String linesinText = actionItem.getDescription();
				String[] lines = linesinText.split("\n");
				if (lines.length == list.size()) {
					assertEquals(list.get(0), lines[0]);
					assertEquals(list.get(1), lines[1]);
				}
			}
		}.run();

	}

	/**
	 * Test by inserting only line break in the description field from UI and validating for the same value in ME.
	 */
	@Test
	public void testDescriptionWithLineBreakOnly() {
		/*
		 * On windows system this test-case may behave differently and result in failure as the typed input is parsed as
		 * "\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n" and not "\n\n\n\n\n\n\n\n".It can be made to work properly just by
		 * substituting the expected value in the assert statement to-> "\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n"
		 */

		openModelElement(actionItem);
		SWTBotStyledText styledText = getBot().activeEditor().bot().styledTextWithLabel("Description");
		final String newDescription = "\n\n\n\n\n\n\n\n";
		styledText.typeText(newDescription);
		getBot().activeEditor().bot().text().setFocus();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				assertEquals(newDescription, actionItem.getDescription());
			}
		}.run();

	}

	/**
	 * It tests the description field to be null. Programatically it sets the description to be null and from UI it
	 * checks if its really null. The other way around it won't work as from UI it can be set to null.
	 */
	@Test
	public void testDescriptionWithNull() {
		openModelElement(actionItem);
		final String nullDescription = null;
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				actionItem.setDescription(nullDescription);

			}
		}.run();

		SWTBotStyledText styledText = getBot().activeEditor().bot().styledTextWithLabel("Description");
		if (styledText.getText().equalsIgnoreCase("")) {
			assertEquals(nullDescription, null);
		} else {
			fail("String was not null");
		}

	}

	/**
	 * Change the value in description field programattically and then confirm it with the value in UI.
	 */
	@Test
	public void testDescriptionUpdate() {

		openModelElement(actionItem);

		final String newDescription = "changed text in description field by UIThread";

		UnicaseCommand unicaseCommand = new UnicaseCommand() {

			@Override
			protected void doRun() {
				actionItem.setDescription(newDescription);
			}
		};
		runAsnc(unicaseCommand);

		getBot().sleep(3000);

		String text = getBot().activeEditor().bot().styledTextWithLabel("Description").getText();

		assertEquals(newDescription, text);
	}

}
