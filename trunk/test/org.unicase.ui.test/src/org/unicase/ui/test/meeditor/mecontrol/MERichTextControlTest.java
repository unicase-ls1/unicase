/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.meeditor.mecontrol;

import static org.junit.Assert.assertEquals;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotStyledText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.junit.Before;
import org.junit.Test;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.workspace.util.UnicaseCommand;



public class MERichTextControlTest extends MeControlTest {

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
	
	
	
	@Test
	public void testDescriptionUpdate()  {
		
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
