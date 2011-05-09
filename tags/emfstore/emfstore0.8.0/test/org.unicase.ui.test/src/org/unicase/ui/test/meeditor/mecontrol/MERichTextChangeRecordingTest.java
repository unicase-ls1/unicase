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
import org.unicase.ui.test.UITestCommon;
import org.unicase.ui.test.UITestSetup;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * This test class validates if just clicked in description field and not changed anything, doesn't get recorded as an
 * operation.
 * 
 * @author Nitesh
 */
public class MERichTextChangeRecordingTest extends UITestSetup {
	private ActionItem actionItem;

	/**
	 * Helper method before the test case runs.
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
	 * Click is simulated in description field and then the operation list is checked to confirm if any new operation
	 * was recordedon the project.
	 */
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
