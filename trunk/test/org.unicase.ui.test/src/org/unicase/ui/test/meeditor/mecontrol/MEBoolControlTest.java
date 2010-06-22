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
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * @author koegel
 */
public class MEBoolControlTest extends MEEditorTest {

	private ActionItem actionItem;

	/**
	 * Helper method to setup environment.
	 */
	@Before
	public void setupActionItem() {

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actionItem = TaskFactory.eINSTANCE.createActionItem();
				actionItem.setName("My ActionItem");
				actionItem.setDone(true);
				actionItem.setResolved(false);
				getLeafSection().getModelElements().add(actionItem);
			}
		}.run();
	}

	/**
	 * Test the boolean value by changing it in UI and then the validating it with the underlying modelelement.
	 */
	@Test
	public void testBooleanChange() {

		openModelElement(actionItem);

		getBot().activeEditor().bot().checkBoxWithLabel("Resolved").click();
		final boolean resolvedValue = getBot().activeEditor().bot().checkBoxWithLabel("Resolved").isChecked();
		getBot().activeEditor().bot().checkBoxWithLabel("Done").click();
		final boolean doneValue = getBot().activeEditor().bot().checkBoxWithLabel("Done").isChecked();

		getBot().sleep(2000);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				assertEquals(true, resolvedValue);
				assertEquals(false, doneValue);
				assertEquals(resolvedValue, actionItem.isResolved());
				assertEquals(doneValue, actionItem.isDone());
			}
		}.run();

	}

	/**
	 * Change the boolean value in the underlying model element and check if it gets reflected in the UI.
	 */
	@Test
	public void testBooleanUpdate() {

		openModelElement(actionItem);

		final boolean newResolvedValue = true;
		final boolean newDoneValue = false;
		UnicaseCommand unicaseCommand = new UnicaseCommand() {
			@Override
			protected void doRun() {

				actionItem.setDone(newDoneValue);
				actionItem.setResolved(newResolvedValue);
			}
		};
		runAsnc(unicaseCommand);

		getBot().sleep(3000);

		getBot().activeEditor().setFocus();
		assertEquals(newResolvedValue, getBot().activeEditor().bot().checkBoxWithLabel("Resolved").isChecked());
		assertEquals(newDoneValue, getBot().activeEditor().bot().checkBoxWithLabel("Done").isChecked());

	}
}
