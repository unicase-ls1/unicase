/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.meeditor.mecontrol;


import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.allOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withRegex;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withTooltip;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.organization.impl.OrganizationFactoryImpl;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.UnicaseCommandWithResult;

public class MEMultiLinkControlTest extends MeControlTest {
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
				User user2 = OrganizationFactory.eINSTANCE.createUser();
				user2.setName("Batman");
				project.addModelElement(user2);
			}
		}.run();
	} 
	
	
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testChangeAddOneInEmpty() {
		UnicaseCommandWithResult<Matcher> participantsWidgetFinderCommand = new UnicaseCommandWithResult<Matcher>() {
			@Override
			protected Matcher doRun() {
				Matcher matchwidget = allOf(widgetOfType(Widget.class), withTooltip("Link Participant"));
				return matchwidget;
			}
		};
		Matcher widgetmatcher = runAsnc(participantsWidgetFinderCommand);
		final List widgetcontrol = getBot().getFinder().findControls(widgetmatcher);
		
		
		
		UnicaseCommand widgetActivateCommand = new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				ToolItem toolItem = ((ToolItem)widgetcontrol.get(0));
				Event event = new Event();
				event.widget = ((ToolItem)widgetcontrol.get(0));
				toolItem.notifyListeners(SWT.Selection, event);		
			}
		}; runAsnc(widgetActivateCommand);
		
		
		final String participant = "Joker";
		getBot().text().setText(participant);
		getBot().button("OK").click();
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				EList<OrgUnit> list = actionItem.getParticipants();
				if(! list.isEmpty()){
				final String getparticipant1 = list.get(0).getName();
				assertEquals(participant, getparticipant1);
				
				}
				
			}
		}.run();
	}
	

	@SuppressWarnings("unchecked")
	@Test
	public void testUpdateAddOneInEmpty() {
		openModelElement(actionItem);
		UnicaseCommand unicaseCommand = new UnicaseCommand() {
			@Override
			protected void doRun() {
				Project project = actionItem.getProject();
				User user = OrganizationFactory.eINSTANCE.createUser();
				user.setName("BOND");
				project.addModelElement(user);
				actionItem.getParticipants().add(user);
				}
		};
		runAsnc(unicaseCommand);
		
		UnicaseCommandWithResult<Matcher> participantsFinderCommand = new UnicaseCommandWithResult<Matcher>() {
			@Override
			protected Matcher doRun() {
				Matcher matchwidget = allOf(widgetOfType(Widget.class), withTooltip("BOND"));
				return matchwidget;
			}
		};
		Matcher widgetmatcher = runAsnc(participantsFinderCommand);
		final List widgetcontrol = getBot().getFinder().findControls(widgetmatcher);
		String finalUser = ((Hyperlink)widgetcontrol.get(0)).getText();
		assertEquals("BOND", finalUser);
}
	
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testChangeAddMultipleInExisting() {
		openModelElement(actionItem);
		UnicaseCommand unicaseCommand = new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				Project project = actionItem.getProject();
				 EList<User> users = project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(), new BasicEList<User>());
				if(users != null){
				 actionItem.getParticipants().addAll(users);
				 User user1 = OrganizationFactoryImpl.eINSTANCE.createUser();
				 user1.setName("Tobias");
				 project.addModelElement(user1);
				 User user2 = OrganizationFactoryImpl.eINSTANCE.createUser();
				 user2.setName("Henry");
				 project.addModelElement(user2);
				 
				}
				
			}
		}; runAsnc(unicaseCommand);
		
		UnicaseCommandWithResult<Matcher> participantsWidgetFinderCommand = new UnicaseCommandWithResult<Matcher>() {
			@Override
			protected Matcher doRun() {
				Matcher matchwidget = allOf(widgetOfType(Widget.class), withTooltip("Link Participant"));
				return matchwidget;
			}
		};
		Matcher widgetmatcher = runAsnc(participantsWidgetFinderCommand);
		final List widgetcontrol = getBot().getFinder().findControls(widgetmatcher);
		
		
		
		UnicaseCommand widgetActivateCommand = new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				ToolItem toolItem = ((ToolItem)widgetcontrol.get(0));
				Event event = new Event();
				event.widget = ((ToolItem)widgetcontrol.get(0));
				toolItem.notifyListeners(SWT.Selection, event);		
			}
		}; runAsnc(widgetActivateCommand);
		
		
		final String participant1 = "Tobias";
		getBot().text().setText(participant1);
		getBot().button("OK").click();
		runAsnc(widgetActivateCommand);
		final String participant2 = "Henry";
		getBot().text().setText(participant2);
		getBot().button("OK").click();
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				EList<OrgUnit> list = actionItem.getParticipants();
				if(! list.isEmpty()){
				for( OrgUnit l : list){
					if(l.getName().equals(participant1)){
						assertEquals(participant1, l.getName());
					}else if(l.getName().equals(participant2)){
						assertEquals(participant2, l.getName());
					}
				}
			}
				
			}
		}.run();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testUpdateAddMultipleInExisting() {
		openModelElement(actionItem);
		UnicaseCommand addParticipantCommand = new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				Project project = actionItem.getProject();
				 EList<User> users = project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(), new BasicEList<User>());
				if(users != null){
				 actionItem.getParticipants().addAll(users);
				 }
				
			}
		}; runAsnc(addParticipantCommand);
		
		UnicaseCommand unicaseCommand = new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				Project project = actionItem.getProject();
				User user1 = OrganizationFactory.eINSTANCE.createUser();
				user1.setName("BOND");
				project.addModelElement(user1);
				actionItem.getParticipants().add(user1);
				User user2 = OrganizationFactory.eINSTANCE.createUser();
				user2.setName("James");
				project.addModelElement(user2);
				actionItem.getParticipants().add(user2);
							
			}
		};
		runAsnc(unicaseCommand);
		
		UnicaseCommandWithResult<Matcher> participant1FinderCommand = new UnicaseCommandWithResult<Matcher>() {
			@Override
			protected Matcher doRun() {
				Matcher matchwidget = allOf(widgetOfType(Widget.class), withTooltip("BOND"));
				return matchwidget;
			}
		};
		Matcher widgetmatcher = runAsnc(participant1FinderCommand);
		final List widgetcontrol1 = getBot().getFinder().findControls(widgetmatcher);
		String finalUser1 = ((Hyperlink)widgetcontrol1.get(0)).getText();
		assertEquals("BOND", finalUser1);
		
		UnicaseCommandWithResult<Matcher> participant2FinderCommand = new UnicaseCommandWithResult<Matcher>() {
			@Override
			protected Matcher doRun() {
				Matcher matchwidget = allOf(widgetOfType(Widget.class), withTooltip("James"));
				return matchwidget;
			}
		};
		widgetmatcher = runAsnc(participant2FinderCommand);
		final List widgetcontrol2 = getBot().getFinder().findControls(widgetmatcher);
		String finalUser2 = ((Hyperlink)widgetcontrol2.get(0)).getText();
		assertEquals("James", finalUser2);
				
}
	
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testChangeAddOneInExisting() {
		openModelElement(actionItem);
		UnicaseCommand unicaseCommand = new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				Project project = actionItem.getProject();
				 EList<User> users = project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(), new BasicEList<User>());
				if(users != null){
				 actionItem.getParticipants().addAll(users);
				 User user = OrganizationFactoryImpl.eINSTANCE.createUser();
				 user.setName("Tobias");
				 project.addModelElement(user);
				 
				}
				
			}
		}; runAsnc(unicaseCommand);
		
		UnicaseCommandWithResult<Matcher> participantsWidgetFinderCommand = new UnicaseCommandWithResult<Matcher>() {
			@Override
			protected Matcher doRun() {
				Matcher matchwidget = allOf(widgetOfType(Widget.class), withTooltip("Link Participant"));
				return matchwidget;
			}
		};
		Matcher widgetmatcher = runAsnc(participantsWidgetFinderCommand);
		final List widgetcontrol = getBot().getFinder().findControls(widgetmatcher);
		
		
		
		UnicaseCommand widgetActivateCommand = new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				ToolItem toolItem = ((ToolItem)widgetcontrol.get(0));
				Event event = new Event();
				event.widget = ((ToolItem)widgetcontrol.get(0));
				toolItem.notifyListeners(SWT.Selection, event);		
			}
		}; runAsnc(widgetActivateCommand);
		
		
		final String participant = "Tobias";
		getBot().text().setText(participant);
		getBot().button("OK").click();
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				EList<OrgUnit> list = actionItem.getParticipants();
				if(! list.isEmpty()){
				for( OrgUnit l : list){
					if(l.getName().equals(participant)){
						assertEquals(participant, l.getName());
						break;
					}
				}
			}
				
			}
		}.run();
	}
	
	

	@SuppressWarnings("unchecked")
	@Test
	public void testUpdateAddOneInExisting() {
		openModelElement(actionItem);
		UnicaseCommand addParticipantCommand = new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				Project project = actionItem.getProject();
				 EList<User> users = project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(), new BasicEList<User>());
				if(users != null){
				 actionItem.getParticipants().addAll(users);
				 }
				
			}
		}; runAsnc(addParticipantCommand);
		
		UnicaseCommand unicaseCommand = new UnicaseCommand() {
			@Override
			protected void doRun() {
				Project project = actionItem.getProject();
				User user = OrganizationFactory.eINSTANCE.createUser();
				user.setName("BOND");
				project.addModelElement(user);
				actionItem.getParticipants().add(user);
							
			}
		};
		runAsnc(unicaseCommand);
		
		UnicaseCommandWithResult<Matcher> participantsFinderCommand = new UnicaseCommandWithResult<Matcher>() {
			@Override
			protected Matcher doRun() {
				Matcher matchwidget = allOf(widgetOfType(Widget.class), withTooltip("BOND"));
				return matchwidget;
			}
		};
		Matcher widgetmatcher = runAsnc(participantsFinderCommand);
		final List widgetcontrol = getBot().getFinder().findControls(widgetmatcher);
		String finalUser1 = ((Hyperlink)widgetcontrol.get(0)).getText();
		assertEquals("BOND", finalUser1);
				
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testParticipantsChange() {
		
		openModelElement(actionItem);
		UnicaseCommandWithResult<Matcher> participantsWidgetFinderCommand = new UnicaseCommandWithResult<Matcher>() {
			@Override
			protected Matcher doRun() {
				Matcher matchwidget = allOf(widgetOfType(Widget.class), withTooltip("Link Participant"));
				return matchwidget;
			}
		};
		Matcher widgetmatcher = runAsnc(participantsWidgetFinderCommand);
		final List widgetcontrol = getBot().getFinder().findControls(widgetmatcher);
		
		
		
		UnicaseCommand widgetActivateCommand = new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				ToolItem toolItem = ((ToolItem)widgetcontrol.get(0));
				Event event = new Event();
				event.widget = ((ToolItem)widgetcontrol.get(0));
				toolItem.notifyListeners(SWT.Selection, event);		
			}
		}; runAsnc(widgetActivateCommand);
		
		
		final String participant1 = "Joker";
		final String participant2 = "Batman";
		getBot().text().setText(participant1);
		getBot().button("OK").click();
		runAsnc(widgetActivateCommand);
		getBot().text().setText(participant2);
		getBot().button("OK").click();
		
		
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				EList<OrgUnit> list = actionItem.getParticipants();
				if(! list.isEmpty()){
				final String getparticipant1 = list.get(0).getName();
				final String getparticipant2 = list.get(1).getName();
				assertEquals(participant1, getparticipant1);
				assertEquals(participant2, getparticipant2);
				}
				
			}
		}.run();
		
}
	


	@SuppressWarnings("unchecked")
	@Test
	public void testParticipantsUpdate() {
		
		openModelElement(actionItem);
		UnicaseCommand unicaseCommand = new UnicaseCommand() {
			@Override
			protected void doRun() {
				Project project = actionItem.getProject();
				User user1 = OrganizationFactory.eINSTANCE.createUser();
				user1.setName("BOND");
				project.addModelElement(user1);
				actionItem.getParticipants().add(user1);
				User user2 = OrganizationFactory.eINSTANCE.createUser();
				user2.setName("James");
				project.addModelElement(user2);
				actionItem.getParticipants().add(user2);
				
			}
		};
		runAsnc(unicaseCommand);
		
		UnicaseCommandWithResult<Matcher> participantsFinderCommand = new UnicaseCommandWithResult<Matcher>() {
			@Override
			protected Matcher doRun() {
				Matcher matchwidget = allOf(widgetOfType(Widget.class), withTooltip("BOND"));
				return matchwidget;
			}
		};
		Matcher widgetmatcher = runAsnc(participantsFinderCommand);
		final List widgetcontrol = getBot().getFinder().findControls(widgetmatcher);
		String finalUser1 = ((Hyperlink)widgetcontrol.get(0)).getText();
		assertEquals("BOND", finalUser1);
		
		
		UnicaseCommandWithResult<Matcher> participantFinderCommand = new UnicaseCommandWithResult<Matcher>() {
			@Override
			protected Matcher doRun() {
				Matcher matchwidget = allOf(widgetOfType(Widget.class), withTooltip("James"));
				return matchwidget;
			}
		};
		Matcher matcher = runAsnc(participantFinderCommand);
		final List control = getBot().getFinder().findControls(matcher);
		String finalUser2 = ((Hyperlink)control.get(0)).getText();
		assertEquals("James", finalUser2);
				
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testRemoveOneUpdate() {
		openModelElement(actionItem);
		UnicaseCommand someCommand = new UnicaseCommand() {
			@Override
			protected void doRun() {
				Project project = actionItem.getProject();
				User user = OrganizationFactory.eINSTANCE.createUser();
				user.setName("James");
					project.addModelElement(user);
					actionItem.getParticipants().add(user);
					
				}
			}; runAsnc(someCommand);
			
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
		 
		UnicaseCommand removeCommand = new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				EList<User> user = actionItem.getProject().getModelElementsByClass(OrganizationPackage.eINSTANCE.getUser(), new BasicEList<User>());
				for(User u: user){
					if(u.getName().equals("James")){
						actionItem.getParticipants().remove(u);
					}
				}
				
			}
		}; runAsnc(removeCommand);
			
				getBot().activeEditor().bot().text().setFocus();
				Matcher noOfHyperlinks = runAsnc(unicaseCommand);
				List secondList = getBot().getFinder().findControls(noOfHyperlinks);
				//Size of secondList is supposed to be 2 less than the initial value as every user added as participants
				// increases the no. of ImageHyperlink widget to 2!
				assertEquals(previousListLength, secondList.size() + 2);
		
	}
	
	

	@SuppressWarnings("unchecked")
	@Test
	public void testRemoveMultipleUpdate() {
		openModelElement(actionItem);
		UnicaseCommand someCommand = new UnicaseCommand() {
			@Override
			protected void doRun() {
					Project project = actionItem.getProject();
					EList<User> users = project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(), new BasicEList<User>());
					if(users != null){
					 actionItem.getParticipants().addAll(users);
					 }
					User user = OrganizationFactory.eINSTANCE.createUser();
					user.setName("James");
					project.addModelElement(user);
					actionItem.getParticipants().add(user);
					
				}
			}; runAsnc(someCommand);
			
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
		 
		UnicaseCommand removeCommand = new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				EList<User> user = actionItem.getProject().getModelElementsByClass(OrganizationPackage.eINSTANCE.getUser(), new BasicEList<User>());
				for(User u: user){
					if(u.getName().equals("James")){
						actionItem.getParticipants().remove(u);
					}else if(u.getName().equals("Batman")){
						actionItem.getParticipants().remove(u);
					}
				}
				
			}
		}; runAsnc(removeCommand);
			
				getBot().activeEditor().bot().text().setFocus();
				Matcher noOfHyperlinks = runAsnc(unicaseCommand);
				List secondList = getBot().getFinder().findControls(noOfHyperlinks);
				//Size of secondList is supposed to be 4 less than the initial value as every user added as participants
				// increases the no. of ImageHyperlink widget to 2 and if removed decreases the no. of ImageHyperLink to 2!
				assertEquals(previousListLength, secondList.size() + 4);
		
	}
	
	
}
