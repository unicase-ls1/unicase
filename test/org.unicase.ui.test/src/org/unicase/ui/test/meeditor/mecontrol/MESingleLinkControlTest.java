/**
 /**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.meeditor.mecontrol;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.allOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.inGroup;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withText;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.swt.widgets.Composite;
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
import org.unicase.workspace.util.UnicaseCommandWithResult;

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
	
	

	@Test
	public void testAssigneeChange() {
		
		openModelElement(actionItem);
		getBot().activeEditor().bot().buttonWithLabel("Assignee",1).click(); 
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
	}


	
	@SuppressWarnings("unchecked")
	@Test
	public void testAssigneeUpdate()  {
		
		openModelElement(actionItem);
		final String name = "Batman";
		UnicaseCommandWithResult<Matcher> unicaseCommand = new UnicaseCommandWithResult<Matcher>() {
			
			@Override
			protected Matcher doRun() {
				User user = OrganizationFactory.eINSTANCE.createUser();
				user.setName(name);
				actionItem.setAssignee(user);
				Matcher match = allOf(widgetOfType(Hyperlink.class));
				// withText("<a>Batman</a>"), inGroup(allOf(withText("User")))
				return match;
			}
		};
		Matcher matcher = runAsnc(unicaseCommand);	
		//System.out.println(getBot().activeEditor().bot().linkInGroup("<a>Batman</a>", "Assignee").getText());
			
		List controls = getBot().getFinder().findControls(matcher);
				assertEquals(name, getBot().activeEditor().bot().widget(matcher).getData().toString());
				String text = ((Hyperlink)controls.get(2)).getText();
				controls.get(1);
		
	}
	
	
}
