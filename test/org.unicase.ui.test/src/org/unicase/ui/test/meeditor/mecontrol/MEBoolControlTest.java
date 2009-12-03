/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.test.meeditor.mecontrol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotStyledText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.junit.Before;
import org.junit.Test;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.workspace.util.UnicaseCommand;

public class MEBoolControlTest extends MeControlTest {


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
	public void testBooleanChange() throws Exception {
		
		openModelElement(actionItem);
		
		getBot().activeEditor().bot().checkBoxWithLabel("Resolved").click();
		final boolean relovedvalue = getBot().activeEditor().bot().checkBoxWithLabel("Resolved").isChecked();
		getBot().activeEditor().bot().checkBoxWithLabel("Done").click();
		final boolean donevalue = getBot().activeEditor().bot().checkBoxWithLabel("Done").isChecked();
		
		getBot().sleep(2000);
		
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				assertEquals(relovedvalue, actionItem.isResolved());
				assertEquals(donevalue, actionItem.isDone());
			}
		}.run();
		
	}


	@Test
	public void testBooleanUpdate() throws Exception {
		
		openModelElement(actionItem);
	
		final boolean setresloved = true ;
		final boolean setdone = true;
		UnicaseCommand unicaseCommand = new UnicaseCommand() {
						@Override
			protected void doRun() {
				
							actionItem.setDone(setdone);
							actionItem.setResolved(setresloved);
			}
		};
		runAsnc(unicaseCommand);
		
		getBot().sleep(3000);
		getBot().activeEditor().setFocus();
		assertEquals(setresloved, getBot().activeEditor().bot().checkBoxWithLabel("Resolved").isChecked());
		assertEquals(setdone, getBot().activeEditor().bot().checkBoxWithLabel("Done").isChecked());

}
}
