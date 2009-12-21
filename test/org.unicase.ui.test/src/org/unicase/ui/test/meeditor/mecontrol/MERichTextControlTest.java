/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.meeditor.mecontrol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

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
	
	
	
	/**
	 * Test existing description with line breaks.
	 * It also tests for the new description to be added at any specified place.
	 */
	@Test
	public void testExistingDescriptionChange(){
		final String newText = "This is existing description.\n";
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				actionItem.setDescription(newText);
			}
		}.run();
		openModelElement(actionItem);
		SWTBotStyledText styledText = getBot().activeEditor().bot().styledTextWithLabel("Description");
		String existingText = styledText.getText();
		assertEquals(newText, existingText);
		
		
		final String newDescription = "Changed text in description field by MEEditor in the second line.";
		styledText.typeText(1, 1, newDescription);
		getBot().activeEditor().bot().text().setFocus();
		final List<String> list = styledText.getLines();
		new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				String linesinText  = actionItem.getDescription();
				String[] lines = linesinText.split("\n");
				 if(lines.length == list.size()){
					 assertEquals(list.get(0), lines[0]);
					 assertEquals(list.get(1), lines[1]);
				 }
			}
		}.run();
	
	 
 }
	
	@Test
	public void testDescriptionWithLineBreakOnly(){
		openModelElement(actionItem);
		SWTBotStyledText styledText = getBot().activeEditor().bot().styledTextWithLabel("Description");
		final String newDescription = "\n\n\n\n\n\n\n\n";
		styledText.typeText(newDescription);
		getBot().activeEditor().bot().text().setFocus();
		new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				String linebreaks  = actionItem.getDescription();
				assertEquals(newDescription, linebreaks);
			}
		}.run();
	
	 
 }
	
	@Test
	public void testDescriptionWithNull(){
		openModelElement(actionItem);
		final String nullDescription = null;
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				actionItem.setDescription(nullDescription);
				
			}
		}.run();
	
		SWTBotStyledText styledText = getBot().activeEditor().bot().styledTextWithLabel("Description");
		if(styledText.getText().equalsIgnoreCase("")){
			assertEquals(nullDescription, null);
		}else{
			fail("String was not null");
		}
		
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
