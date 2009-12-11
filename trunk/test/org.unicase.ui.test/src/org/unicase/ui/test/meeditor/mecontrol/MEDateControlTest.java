/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.meeditor.mecontrol;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.allOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.inGroup;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withLabel;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withRegex;
import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.swt.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.organization.User;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.UnicaseCommandWithResult;

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

	/* Seems this guy(method: testDateChange()) is still having some problem. I think i need to have 2 matchers: 1st one to match and set enable the Label with text
	 *  (Not Set) in Due Date. So that the CDatetime widget is visible to the 2nd matcher, which can then modify the date field then!
	 *  Thus this test is to be performed manually until this test case is fixed!
	 */
	@SuppressWarnings({ "unchecked" })
	@Test
	public void testDateChange() {

		openModelElement(actionItem);
		
		UnicaseCommandWithResult<Matcher> unicaseCommand = new UnicaseCommandWithResult<Matcher>() {
			@Override
			protected Matcher doRun() {
				Matcher match = allOf(widgetOfType(CDateTime.class));
				return match;
			}
		};
		Matcher matcher = runAsnc(unicaseCommand);
		
		final List controls = getBot().getFinder().findControls(matcher);
		final Date somedate = new Date(300000);
		
		
	
		
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				((CDateTime)controls.get(0)).setData(somedate);
				getBot().activeEditor().setFocus();
				assertEquals(somedate.toString(), actionItem.getDueDate().toString());
			}
		}.run();
		
	}

	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testDateUpdate() throws ParseException {


		openModelElement(actionItem);
		DateFormat dfm = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		String date = "20.12.2009 08:45";
		
			final Date somedate = dfm.parse("20.12.2009 08:45");
		
		UnicaseCommandWithResult<Matcher> unicaseCommand = new UnicaseCommandWithResult<Matcher>() {
			
			@Override
			protected Matcher doRun() {
				actionItem.setDueDate(somedate);
				getBot().activeEditor().setFocus();
				Matcher match = allOf(widgetOfType(CDateTime.class));
				return match;
			}
		};
		Matcher matcher = runAsnc(unicaseCommand);	
	
			
		List controls = getBot().getFinder().findControls(matcher);
			String changeddate = ((CDateTime)controls.get(0)).getText();
				assertEquals(date, changeddate);
	}
}
