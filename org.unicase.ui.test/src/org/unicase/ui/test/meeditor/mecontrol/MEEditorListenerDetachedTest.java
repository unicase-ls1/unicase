/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.meeditor.mecontrol;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.organization.User;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.ui.test.UITestCommon;
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Test if the listeners attached to all the controls gets detached once the MEEditor is closed.
 * 
 * @author Nitesh
 */
public class MEEditorListenerDetachedTest extends MEEditorTest {
	private ActionItem actionItem;
	private User user;

	/**
	 * Helper method to setup the enviroment.
	 */
	@Before
	public void setupActionItem() {

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actionItem = TaskFactory.eINSTANCE.createActionItem();
				actionItem.setName("My ActionItem");
				getLeafSection().getModelElements().add(actionItem);
				user = OrganizationFactory.eINSTANCE.createUser();
				user.setName("Some user");
				getLeafSection().getModelElements().add(user);
			}
		}.run();
	}

	/**
	 * This method tests if the listeners are getting removed once the editor is closed. It does so by opening a ME in
	 * the editor and then closing it and modifying the values programatically. If no exception is thrown saying widget
	 * disposed, everything is going as expected.
	 */
	@Test
	public void listenersDetachedTest() {
		UITestCommon.openPerspective(getBot(), "Unicase");
		openModelElement(actionItem);
		getBot().activeEditor().close();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actionItem.setName("Do nothing today!");
				actionItem.setDescription("This is all about doing nothing");
				actionItem.setAssignee(user);
				actionItem.setDone(false);
				actionItem.setResolved(false);
				actionItem.setReviewer(user);
				actionItem.setEffort(0);
				actionItem.setDueDate(new Date());
				actionItem.setPriority(0);
				ActionItem annotatedAI = TaskFactory.eINSTANCE.createActionItem();
				annotatedAI.setName("Some one just annotated ME!");
				getLeafSection().getModelElements().add(annotatedAI);
				actionItem.getAnnotatedModelElements().add(annotatedAI);
				actionItem.setDescription(null);
			}
		}.run();

		openModelElement(actionItem);
		String meassage = "If you are seeing this and didn't get any Widget disposed Error then the test case worked "
			+ "and if you got Widget disposed error then there was a listener which was not detached when the editor was"
			+ "closed for the first time. You should probably debug the UincaseCommand in this test case@";
		getBot().activeEditor().bot().styledTextWithLabel("Description").typeText(meassage, 2);
	}

}
