/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.test.meeditor.mecontrol;

import static org.junit.Assert.assertEquals;

import org.eclipse.jface.bindings.keys.KeyStroke;
import org.junit.Before;
import org.junit.Test;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.workspace.util.UnicaseCommand;

public class MEIntControlTest extends MeControlTest {
	
	private static final KeyStroke UP = null;
	private static final KeyStroke FIVE = null;
	private ActionItem actionItem;
	
	@Before
	public void setupActionItem() {
			
		new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				actionItem = TaskFactory.eINSTANCE.createActionItem();
				actionItem.setName("My ActionItem");
				getLeafSection().getModelElements().add(actionItem);
				getProjectSpace().getModifiedModelElementsCache();
			}
		}.run();
	} 
	
	
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
		getBot().activeEditor().close();
		openModelElement(actionItem);
		int temporary = getBot().activeEditor().bot().spinnerWithLabel("Priority").getSelection();
		assertEquals(selection, temporary);
		
	}
		
			
	
	
	@Test
	public void testSetPriorityOfActionItem() {
		openModelElement(actionItem);
		final int selection = 5;
		getBot().activeEditor().bot().spinnerWithLabel("Priority").pressShortcut(5,'5');
		getBot().sleep(2000);
		openModelElement(actionItem);
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				assertEquals(selection, actionItem.getPriority());
			}
		}.run();
	}
	
	
}
