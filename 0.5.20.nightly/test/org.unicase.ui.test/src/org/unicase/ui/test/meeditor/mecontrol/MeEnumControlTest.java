/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
			package org.unicase.ui.test.meeditor.mecontrol;
			
			import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
			
			import org.junit.Before;
			import org.junit.Test;
			import org.unicase.model.task.ActionItem;
			import org.unicase.model.task.ActivityType;
			import org.unicase.model.task.TaskFactory;
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.util.UnicaseCommand;
			
			public class MeEnumControlTest extends MEEditorTest {
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
			public void testActivityDefault() {
				
				openModelElement(actionItem);
				final String defaultActivity = getBot().activeEditor().bot().comboBoxWithLabel("Activity").getText();
				
				new UnicaseCommand() {
					@Override
					protected void doRun() {
						int fromUIThread = actionItem.getActivity().getValue();
						if (defaultActivity.equals("<please select>")){
							assertEquals( 0 ,fromUIThread);
						}else{
							fail();
						}
					}
				}.run();
			}
			
			@Test
			public void testActivityNull() {
				
				openModelElement(actionItem);
					String firstActivity = getBot().activeEditor().bot().comboBoxWithLabel("Activity").getText();
				
				new UnicaseCommand() {
					@Override
					protected void doRun() {
						actionItem.setActivity(null);
					}
				}.run();
				String finalActivity = getBot().activeEditor().bot().comboBoxWithLabel("Activity").getText();
				assertEquals(firstActivity, finalActivity);
				
			}
			
			
			@Test
			public void testActivityChange() {
				
				openModelElement(actionItem);
				getBot().activeEditor().bot().comboBoxWithLabel("Activity").setSelection(1);
			
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					assertEquals("Analysis".toLowerCase(), actionItem.getActivity().getName().toLowerCase());
					}
				}.run();
			}
			
			
			@Test
			public void testActivityUpdate()  {
				
				openModelElement(actionItem);
				final String changed = "Management";
			UnicaseCommand unicaseCommand = new UnicaseCommand() {
				
				@Override
				protected void doRun() {
					
					actionItem.setActivity(ActivityType.MANAGEMENT);
				}
			};
			runAsnc(unicaseCommand);
			
			assertEquals(changed,getBot().activeEditor().bot().comboBoxWithLabel("Activity").getText());
					
				}
				
				
			}
