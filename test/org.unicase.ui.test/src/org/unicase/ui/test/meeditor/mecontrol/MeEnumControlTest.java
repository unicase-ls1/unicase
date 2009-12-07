/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.test.meeditor.mecontrol;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.allOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.junit.Assert.assertEquals;

import org.eclipse.swt.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Widget;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.unicase.metamodel.Project;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.organization.User;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.ActivityType;
import org.unicase.model.task.TaskFactory;
import org.unicase.workspace.util.UnicaseCommand;

public class MeEnumControlTest extends MeControlTest {
	private ActionItem actionItem;
	private User user;
		
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
		
		

		@SuppressWarnings("unchecked")
		@Test
		public void testActivityChange() throws Exception {
			
			openModelElement(actionItem);
			getBot().activeEditor().bot().comboBoxWithLabel("Activity").setSelection(1);
			getBot().sleep(2000);
			
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					assertEquals("Analysis".toLowerCase(), actionItem.getActivity().getName().toLowerCase());
				}
			}.run();
			getBot().sleep(2000);
		}


		@Test
		public void testActivityUpdate() throws Exception {
			
			openModelElement(actionItem);
			final String changed = "Management";
			UnicaseCommand unicaseCommand = new UnicaseCommand() {
				
				@Override
				protected void doRun() {
					
					actionItem.setActivity(ActivityType.MANAGEMENT);
					
					
				}
			};
			runAsnc(unicaseCommand);
			getBot().sleep(3000);
			assertEquals(changed,getBot().activeEditor().bot().comboBoxWithLabel("Activity").getText());
			
		}
		
		
	}
