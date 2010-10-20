/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.meeditor.mecontrol;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.ui.test.UITestSetup;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * MEEditor Int control test. Used for setting priority, estimate etc.
 * 
 * @author Nitesh
 */
public class MEIntControlTest extends UITestSetup {

	private ActionItem actionItem;

	/**
	 * Helper method before the test cases execute.
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
	 * Test the default value of IntControl from UI and matches it with the corresponding value of ME.
	 */
	@Test
	public void testDefaultPriority() {
		openModelElement(actionItem);
		final int temporary = getBot().activeEditor().bot().spinnerWithLabel("Priority").getSelection();
		UnicaseCommand unicaseCommand = new UnicaseCommand() {

			@Override
			protected void doRun() {

				assertEquals(temporary, actionItem.getPriority());
			}
		};
		runAsnc(unicaseCommand);

	}

	/**
	 * Test if the neagtive values can be assigned and if its the same in UI as been set in the ME.
	 */
	@Test
	public void testUpdateNeagtivePriority() {
		openModelElement(actionItem);
		final int selection = -999;
		UnicaseCommand unicaseCommand = new UnicaseCommand() {

			@Override
			protected void doRun() {

				actionItem.setPriority(selection);
			}
		};
		runAsnc(unicaseCommand);

		getBot().sleep(2000);
		int temporary = getBot().activeEditor().bot().spinnerWithLabel("Priority").getSelection();
		assertEquals(selection, temporary);

	}

	/**
	 * Test if the neagtive values can be assigned and if its the same in ME as been set in the UI.
	 */
	@Test
	public void testSetNegativePriority() {
		openModelElement(actionItem);
		final int selection = -1000;
		getBot().activeEditor().bot().spinnerWithLabel("Priority").setSelection(selection);
		getBot().sleep(2000);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				assertEquals(selection, actionItem.getPriority());
			}
		}.run();
	}

	/**
	 * Test if the positive values can be assigned and if its the same in UI as been set in the ME.
	 */
	@Test
	public void testUpdatePriorityOfActionItem() {
		openModelElement(actionItem);
		final int selection = 10;
		UnicaseCommand unicaseCommand = new UnicaseCommand() {

			@Override
			protected void doRun() {

				actionItem.setPriority(selection);
			}
		};
		runAsnc(unicaseCommand);

		getBot().sleep(2000);
		int temporary = getBot().activeEditor().bot().spinnerWithLabel("Priority").getSelection();
		assertEquals(selection, temporary);

	}

	/**
	 * Test if the positive values can be assigned and if its the same in ME as been set in the UI.
	 */
	@Test
	public void testSetPriorityOfActionItem() {
		openModelElement(actionItem);
		final int selection = 5;
		getBot().activeEditor().bot().spinnerWithLabel("Priority").setSelection(selection);
		getBot().sleep(2000);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				assertEquals(selection, actionItem.getPriority());
			}
		}.run();
	}

}
