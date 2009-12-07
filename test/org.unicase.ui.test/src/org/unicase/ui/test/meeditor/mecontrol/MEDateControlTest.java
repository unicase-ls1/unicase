/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.test.meeditor.mecontrol;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.allOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;

import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.swt.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotStyledText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.junit.Before;
import org.junit.Test;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.workspace.util.UnicaseCommand;

public class MEDateControlTest extends MeControlTest {
private static final KeyStroke ENTER = null;
private static final org.hamcrest.Matcher<Widget> CDateTime = null;
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
	
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Test
	public void testDateChange() throws Exception {
		
		openModelElement(actionItem);
		final Date somedate = new Date(2000,8,9);
		
		org.hamcrest.Matcher<CDateTime> match  = allOf(widgetOfType(CDateTime.class));
		getBot().activeEditor().bot().widget(match).setData(somedate);
		
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
