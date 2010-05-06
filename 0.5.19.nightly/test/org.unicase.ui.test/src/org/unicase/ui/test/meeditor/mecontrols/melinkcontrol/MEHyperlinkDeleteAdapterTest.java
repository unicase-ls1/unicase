/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.meeditor.mecontrols.melinkcontrol;
		
		import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.allOf;
		import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
		import static org.junit.Assert.assertEquals;
		
		import java.util.List;
		
		import org.eclipse.swt.SWT;
		import org.eclipse.swt.widgets.Event;
		import org.eclipse.swt.widgets.Label;
		import org.eclipse.ui.forms.widgets.ImageHyperlink;
		import org.hamcrest.Matcher;
		import org.junit.Before;
		import org.junit.Test;
		import org.unicase.metamodel.Project;
		import org.unicase.model.organization.OrganizationFactory;
		import org.unicase.model.organization.User;
		import org.unicase.model.task.ActionItem;
		import org.unicase.model.task.TaskFactory;
		import org.unicase.model.task.WorkPackage;
import org.unicase.ui.test.meeditor.MEEditorTest;
		import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.UnicaseCommandWithResult;
		
		public class MEHyperlinkDeleteAdapterTest extends MEEditorTest {
			private ActionItem actionItem;
			
			
			
			@Before
			public void setupActionItem() {
					
				new UnicaseCommand() {
					@Override
					protected void doRun() {
						actionItem = TaskFactory.eINSTANCE.createActionItem();
						actionItem.setName("My ActionItem");
		getLeafSection().getModelElements().add(actionItem);
		Project project = actionItem.getProject();
		User user1 = OrganizationFactory.eINSTANCE.createUser();
		user1.setName("Joker");
		project.addModelElement(user1);
		actionItem.setAssignee(user1);
		User user2 = OrganizationFactory.eINSTANCE.createUser();
		user2.setName("Batman");
		project.addModelElement(user2);
		actionItem.setReviewer(user2);
		WorkPackage workpackage = TaskFactory.eINSTANCE.createWorkPackage();
		workpackage.setName("Sprint1");
					project.addModelElement(workpackage);
					actionItem.setContainingWorkpackage(workpackage);
				}
			}.run();
		} 
		
		@SuppressWarnings("unchecked")
		@Test
		public void testHyperLinkDelete(){
			openModelElement(actionItem);
				
			UnicaseCommandWithResult<Matcher> unicaseCommand = new UnicaseCommandWithResult<Matcher>() {
				@Override
				protected Matcher doRun() {
					Matcher match = allOf(widgetOfType(ImageHyperlink.class));
					return match;
				}
			};
			Matcher hyperLinkMatcher = runAsnc(unicaseCommand);
			final List linksList = getBot().getFinder().findControls(hyperLinkMatcher);
			UnicaseCommand firstCommand = new UnicaseCommand() {
			@Override
			protected void doRun() {
				Event event = new Event();
				event.widget = 	((ImageHyperlink)linksList.get(6));
				((ImageHyperlink)linksList.get(6)).notifyListeners(SWT.MouseUp, event);
				
				
				}
			}; runAsnc(firstCommand);
			
			
			
			new UnicaseCommand() {
		
					@Override
					protected void doRun() {
			
						final String noReviewer = actionItem.getReviewer().getName();
						assertEquals(null, noReviewer);
					}
			}.run();
					
		}
		
		@SuppressWarnings("unchecked")
		@Test
		public void testDeleteFromMultiLink(){
			openModelElement(actionItem);
			UnicaseCommandWithResult<Matcher> unicaseCommand = new UnicaseCommandWithResult<Matcher>() {
				@Override
				protected Matcher doRun() {
					Matcher match = allOf(widgetOfType(ImageHyperlink.class));
					return match;
				}
			};
			Matcher hyperLinkMatcher = runAsnc(unicaseCommand);
			List linksList = getBot().getFinder().findControls(hyperLinkMatcher);
			int previousListLength = linksList.size();
			UnicaseCommand someCommand = new UnicaseCommand() {
				
				@Override
				protected void doRun() {
					Project project = actionItem.getProject();
					User user2 = OrganizationFactory.eINSTANCE.createUser();
					user2.setName("James");
						project.addModelElement(user2);
						actionItem.getParticipants().add(user2);
						User user3 = OrganizationFactory.eINSTANCE.createUser();
						user3.setName("Kong");
							project.addModelElement(user3);
							actionItem.getParticipants().add(user3);
							User user4 = OrganizationFactory.eINSTANCE.createUser();
							user4.setName("King");
								project.addModelElement(user4);
								actionItem.getParticipants().add(user4);
						
					}
				}; runAsnc(someCommand);
				
					getBot().activeEditor().bot().text().setFocus();
					Matcher noOfHyperlinks = runAsnc(unicaseCommand);
					final List secondList = getBot().getFinder().findControls(noOfHyperlinks);
					assertEquals(previousListLength+6, secondList.size());
				
				
					UnicaseCommand finalCommand = new UnicaseCommand() {
					@Override
					protected void doRun() {
						Event event = new Event();
						event.widget = 	((ImageHyperlink)secondList.get(8));
						((ImageHyperlink)secondList.get(8)).notifyListeners(SWT.MouseUp, event);
									
						}
					}; runAsnc(finalCommand);
					
					
						new UnicaseCommand() {
						
						@Override
						protected void doRun() {
							assertEquals(2, actionItem.getParticipants().size());
							
						}
						}.run();
					
			}
			
			
		}
