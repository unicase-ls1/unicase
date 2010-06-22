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
 * Test cases for TextControl, as being used for Name field.
 * 
 * @author Nitesh
 */
public class METextControlTest extends MEEditorTest {

	private ActionItem actionItem;
	private ActionItem newactionItem;

	/**
	 * Helper method to set up environment before the test cases execute.
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
	 * change the name in the TextControl from UI and see if it gets updated in ME.
	 */
	@Test
	public void testNameChange() {

		openModelElement(actionItem);
		getBot().activeEditor().bot().textWithLabel("Name").selectAll();
		final String newName = "changed text in name field by MEEditor";
		getBot().activeEditor().bot().textWithLabel("Name").typeText(newName, 2);

		getBot().sleep(2000);

		SWTBotStyledText styledText = getBot().activeEditor().bot().styledTextWithLabel("Description");
		styledText.setFocus();

		getBot().sleep(2000);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				assertEquals(newName, actionItem.getName());
			}
		}.run();

	}

	/**
	 * Change the name programattically and see if it gets reflected in UI.
	 */
	@Test
	public void testNameUpdate() {

		openModelElement(actionItem);

		final String newname = "changed text in name field by UIThread";

		UnicaseCommand unicaseCommand = new UnicaseCommand() {

			@Override
			protected void doRun() {
				actionItem.setName(newname);
			}
		};
		runAsnc(unicaseCommand);

		getBot().sleep(3000);
		getBot().activeEditor().setFocus();
		assertEquals(newname, getBot().activeEditor().bot().textWithLabel("Name").getText());

	}

	/**
	 * Test the default name to be the same in UI and in the underlying ME.
	 */
	@Test
	public void testNameDefault() {
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				newactionItem = TaskFactory.eINSTANCE.createActionItem();
				getLeafSection().getModelElements().add(newactionItem);
			}
		}.run();

		openModelElement(newactionItem);

		final String defaultName = getBot().activeEditor().bot().textWithLabel("Name").getText();
		UnicaseCommand unicaseCommand = new UnicaseCommand() {

			@Override
			protected void doRun() {
				assertEquals(defaultName, newactionItem.getName());
			}
		};
		runAsnc(unicaseCommand);

	}

	/**
	 * Test if the name is set to null programatically, the UI reflects "".
	 */
	@Test
	public void testNameNull() {

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				newactionItem = TaskFactory.eINSTANCE.createActionItem();
				newactionItem.setName("Everything");
				getLeafSection().getModelElements().add(newactionItem);
			}
		}.run();

		openModelElement(newactionItem);
		final String changedName = null;

		UnicaseCommand unicaseCommand = new UnicaseCommand() {

			@Override
			protected void doRun() {
				newactionItem.setName(changedName);
			}
		};
		runAsnc(unicaseCommand);

		assertEquals("", getBot().activeEditor().bot().textWithLabel("Name").getText());

	}

	/**
	 * Test the name if set to "" from UI gets updated in ME.
	 */
	@Test
	public void testNameEmptyStringUpdate() {
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				newactionItem = TaskFactory.eINSTANCE.createActionItem();
				newactionItem.setName("something");
				getLeafSection().getModelElements().add(newactionItem);
			}
		}.run();

		openModelElement(newactionItem);
		final String changedName = "";
		UnicaseCommand unicaseCommand = new UnicaseCommand() {

			@Override
			protected void doRun() {
				newactionItem.setName(changedName);
			}
		};
		runAsnc(unicaseCommand);

		assertEquals(changedName, getBot().activeEditor().bot().textWithLabel("Name").getText());

	}

}
