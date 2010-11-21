/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.meeditor.mecontrol;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.allOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withRegex;
import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.UnicaseCommandWithResult;
/**
 * Class to test the MEDateControl.
 */
public class MEDateControlTest extends MEEditorTest {

	private ActionItem actionItem;
/**
 * Setup the environment for testing.
 */
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

	/**  
	 * This method first look for the label with text "(Not Set)" and then activates the label to get the
	 * CDateTime widget and finally changes the DueDate for actionItem through UI.
	 * 
	 * @throws ParseException while parsing date..
	 */
	@SuppressWarnings("unchecked")
	@Test 
	public void testDateChange() throws ParseException {

		openModelElement(actionItem);
		
		UnicaseCommandWithResult<Matcher> labelFinderCommand = new UnicaseCommandWithResult<Matcher>() {
			@Override
			protected Matcher doRun() {
				Matcher matchlabel = allOf(widgetOfType(Label.class), withRegex("(Not Set)"));
				return matchlabel;
			}
		};
		
		Matcher labelmatcher = runAsnc(labelFinderCommand);
		final List labelcontrols = getBot().getFinder().findControls(labelmatcher);
		
		
		UnicaseCommand labelActivateCommand = new UnicaseCommand() {
				
				@Override
				protected void doRun() {
					Label label = ((Label)labelcontrols.get(3));
					Event event = new Event();
					event.widget = ((Label)labelcontrols.get(3));
					label.notifyListeners(SWT.MouseUp, event);
					
				}
			}; runAsnc(labelActivateCommand);
		
		
		
		UnicaseCommandWithResult<Matcher> unicaseDateWidgetFinderCommand = new UnicaseCommandWithResult<Matcher>() {
			@Override
			protected Matcher doRun() {
				Matcher match = allOf(widgetOfType(CDateTime.class));
				return match;
			}
		};
		
		Matcher datematcher = runAsnc(unicaseDateWidgetFinderCommand);
		
		
		final List controls = getBot().getFinder().findControls(datematcher);
		DateFormat dfm = new SimpleDateFormat("MMM dd, yyyy");
		final String sdate = "Oct 10, 2007";
		final Date somedate = dfm.parse(sdate);
		
		
		UnicaseCommand setdateCommand = new UnicaseCommand() {
			@Override
			protected void doRun() {
				CDateTime date = (CDateTime) controls.get(0);
				date.setSelection(somedate);
				Event event = new Event();
				event.widget = (CDateTime) controls.get(0);
				date.notifyListeners(SWT.FocusOut, event);
							
			}
		}; runAsnc(setdateCommand);
		
	
	
		UnicaseCommand getDateCommand = new UnicaseCommand() {
			@Override
			protected void doRun() {
				final String tempdate = DateFormat.getDateInstance().format((actionItem.getDueDate()));
				assertEquals(sdate, tempdate);
				
			}
		};runAsnc(getDateCommand);
		
		
	}

	
	/**
	 * This method sets the DueDate Programmatically and then checks it to be reflected in UI.
	 * 
	 * @throws ParseException can throw this exception while parsing the date.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testDateUpdate() throws ParseException {


		openModelElement(actionItem);
		DateFormat dfm = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		String date = "20.12.2008 08:45";
		final Date somedate = dfm.parse(date);
		
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
