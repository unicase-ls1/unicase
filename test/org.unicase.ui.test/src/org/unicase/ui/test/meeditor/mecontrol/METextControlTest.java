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
import org.unicase.workspace.util.UnicaseCommand;

public class METextControlTest extends MeControlTest {
	
	private ActionItem actionItem;
	
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
	
	
	
	@Test
	public void testNameChange() {
		
		openModelElement(actionItem);
		
		final String newName = "changed text in name field by MEEditor";
		getBot().activeEditor().bot().textWithLabel("Name").typeText(newName,2);
		
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


	@Test
	public void testNameUpdate()  {
		
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

}
