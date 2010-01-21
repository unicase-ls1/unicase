/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.unicasecommon.meeditor.mecontrols.uccontrol;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.allOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withRegex;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withTooltip;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.ui.test.meeditor.mecontrol.MeControlTest;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.UnicaseCommandWithResult;

/**
 * Tests the UseCase Step widget.
 */
public class UseCaseStepsControlTest extends MeControlTest {
	
	private UseCase usecase;
	/**
	 * Setup the environment for testing.
	 */
		@Before
		public void setupActionItem() {

			new UnicaseCommand() {

				@Override
				protected void doRun() {
					usecase = RequirementFactory.eINSTANCE.createUseCase();
					usecase.setName("My UseCase");
					getLeafSection().getModelElements().add(usecase);
				
				}
			}.run();
		}
		
		
/**
 * Create a USECase step from UI and check if its reflected in the model programatically!.
 */
		@SuppressWarnings("unchecked")
		@Test
		public void testStepChange() {
			openModelElement(usecase);
			
			UnicaseCommandWithResult<Matcher> widgetFinderCommand = new UnicaseCommandWithResult<Matcher>() {
				@Override
				protected Matcher doRun() {
					Matcher matchwidget = allOf(widgetOfType(Hyperlink.class), withRegex("Insert Actor Step"));
					return matchwidget;
				}
			};
			Matcher widgetmatcher = runAsnc(widgetFinderCommand);
			final List widgetcontrol = getBot().getFinder().findControls(widgetmatcher);
			getBot().activeEditor().setFocus();
			
			UnicaseCommand widgetActivateCommand = new UnicaseCommand() {
				
				@Override
				protected void doRun() {
					Hyperlink hyperlink = ((Hyperlink)widgetcontrol.get(0));
					Event event = new Event();
					event.widget = hyperlink;
					hyperlink.notifyListeners(4, event);		
				}
			}; runAsnc(widgetActivateCommand);
			getBot().sleep(7000);
		}

}
