/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.test.meeditor.mecontrol;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotStyledText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.junit.Before;
import org.junit.Test;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.workspace.util.UnicaseCommand;

public class MEDateControlTest extends MeControlTest {
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
	public void testDateChange() throws Exception {
		
		openModelElement(actionItem);
		final Date somedate = new Date(200000000);
		getBot().activeEditor().bot().textWithLabel("Due Date").setText(somedate.toString());
		
		new UnicaseCommand() {
			@Override
			protected void doRun() {
			assertEquals(somedate,actionItem.getDueDate());
			}
		}.run();
		
	}


	@SuppressWarnings("deprecation")
	@Test
	public void testDateUpdate() throws Exception {
		
		openModelElement(actionItem);
		final Date somedate = new Date(300000000);
		UnicaseCommand unicaseCommand = new UnicaseCommand() {
		
			@Override
			protected void doRun() {
				actionItem.setDueDate(somedate);
			}
		};
		runAsnc(unicaseCommand);
		
		getBot().sleep(3000);
		getBot().activeEditor().setFocus();
		assertEquals(somedate, getBot().activeEditor().bot().treeWithLabel("Due Date").getText());
		
	}
}
