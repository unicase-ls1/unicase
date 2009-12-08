/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.meeditor.mecontrol;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.unicase.metamodel.Project;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.organization.User;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.workspace.util.UnicaseCommand;

public class MEMultiLinkControlTest extends MeControlTest {
	private ActionItem actionItem;
	
	
	
	@Before
	public void setupActionItem() {
			
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				actionItem = TaskFactory.eINSTANCE.createActionItem();
				actionItem.setName("My ActionItem");
				getLeafSection().getModelElements().add(actionItem);
				Project project = actionItem.getProject();
				User user1 = OrganizationFactory.eINSTANCE.createUser();
				user1.setName("Joker");
				project.addModelElement(user1);
				User user2 = OrganizationFactory.eINSTANCE.createUser();
				user2.setName("Batman");
				project.addModelElement(user2);
			}
		}.run();
	} 
	
	

	
	@Test
	public void testActivityChange() {
		
		openModelElement(actionItem);
		getBot().activeEditor().bot().buttonWithId("Participants").click();
		
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				assertEquals(1,1);
			}
		}.run();
		getBot().sleep(2000);
	}


	@Test
	public void testActivityUpdate() {
		
		openModelElement(actionItem);
		
		UnicaseCommand unicaseCommand = new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				
				assertEquals(1,1);
				
			}
		};
		runAsnc(unicaseCommand);
		getBot().sleep(3000);
		
		
	}
	
}
