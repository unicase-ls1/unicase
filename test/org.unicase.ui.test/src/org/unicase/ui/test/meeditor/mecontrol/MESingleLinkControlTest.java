/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.test.meeditor.mecontrol;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.allOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withRegex;
import static org.junit.Assert.assertEquals;

import org.eclipse.ui.forms.widgets.Hyperlink;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.unicase.metamodel.Project;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.organization.User;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.workspace.util.UnicaseCommand;

public class MESingleLinkControlTest extends MeControlTest {
private ActionItem actionItem;
private User user;
	
	@Before
	public void setupActionItem() {
			
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				actionItem = TaskFactory.eINSTANCE.createActionItem();
				actionItem.setName("My ActionItem");
				getLeafSection().getModelElements().add(actionItem);
				Project project = actionItem.getProject();
				user = OrganizationFactory.eINSTANCE.createUser();
				user.setName("Joker");
				project.addModelElement(user);
			}
		}.run();
	} 
	
	

	@SuppressWarnings("unchecked")
	@Test
	public void testAssigneeChange() throws Exception {
		
		openModelElement(actionItem);
		getBot().activeEditor().bot().buttonWithLabel("Assignee").click(); 
		getBot().table().select(0);
		getBot().button("OK").click();
		getBot().sleep(2000);
		final String assigneduser = "Joker";
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				assertEquals(assigneduser, actionItem.getAssignee().getName());
			}
		}.run();
		getBot().sleep(2000);
	}


	@SuppressWarnings("unchecked")
	@Test
	public void testAssigneeUpdate() throws Exception {
		
		openModelElement(actionItem);
		final String name = "Batman";
		UnicaseCommand unicaseCommand = new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				User user = OrganizationFactory.eINSTANCE.createUser();
				user.setName(name);
				actionItem.setAssignee(user);
								
			}
		};
		runAsnc(unicaseCommand);	
		
		final Matcher match = allOf(widgetOfType(Hyperlink.class), withRegex("Batman.*"));
		assertEquals(name, getBot().activeEditor().bot().widget(match).toString());
		
		//assertEquals(name, getBot().activeEditor().bot().linkWithId("User").getText());
		getBot().sleep(2000);
	

		
		
	}
	
	
}
