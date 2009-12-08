/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.meeditor.mecontrol;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.eclipse.swt.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
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
	
	

	@SuppressWarnings("deprecation")
	@Test
	public void testDateChange() {
		
		openModelElement(actionItem);
		final Date somedate = new Date(2000,8,9);
		
		CDateTime match = getBot().widget(WidgetOfType.widgetOfType(CDateTime.class), 0);
		
		//getBot().activeEditor().bot().widget(match).setData(somedate);
		getBot().activeEditor().bot().comboBox("Due Date").setFocus();
		new UnicaseCommand() {
			
			@Override
			protected void doRun() {
		
			getBot().sleep(1000);
			assertEquals(somedate,actionItem.getDueDate());
			}
		}.run();
		
	}


	
	@Test
	public void testDateUpdate() {
		
		openModelElement(actionItem);
		final Date somedate = new Date(300000000);
		UnicaseCommand unicaseCommand = new UnicaseCommand() {
		
			@Override
			protected void doRun() {
				
				actionItem.setDueDate(somedate);
									
			}
		};
		runAsnc(unicaseCommand);
		
		assertEquals(somedate, getBot().activeEditor().bot().dateTime().getDate());
		getBot().sleep(3000);
	
	
		
	}
}
