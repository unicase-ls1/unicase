/**
 /**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.meeditor.mecontrols.melinkcontrol;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.allOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withRegex;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.core.runtime.AssertionFailedException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.unicase.metamodel.Project;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.organization.User;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.test.meeditor.mecontrol.MeControlTest;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.UnicaseCommandWithResult;

public class MESingleLinkControlTest extends MeControlTest {
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
				Project project = actionItem.getProject();
				user = OrganizationFactory.eINSTANCE.createUser();
				user.setName("Joker");
				project.addModelElement(user);
			}
		}.run();
	} 
	
	@SuppressWarnings("unchecked")
	@Test
	public void testReassigning()  {
		
		new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				OrgUnit user = OrganizationFactory.eINSTANCE.createUser();
				user.setName("UNICASE user");
				actionItem.setAssignee(user);
				}
		}.run();
		openModelElement(actionItem);

		getBot().activeEditor().bot().buttonWithLabel("Assignee",0).click(); 
		getBot().text().setText("Joker");
		getBot().button("OK").click();
		
		UnicaseCommand userfinder = new UnicaseCommand() {
			
			
			@Override
			protected void doRun() {
				Matcher match = allOf(widgetOfType(Hyperlink.class), withRegex("Joker"));
				final List label = getBot().getFinder().findControls(match);
				String text = ((Hyperlink)label.get(0)).getText();
				assertEquals("Joker", text);
				assertEquals("Joker", actionItem.getAssignee());
			}
		}; runAsnc(userfinder);
		
			
	}
	
	@Test
	public void testActionItemWorkPackageSet() {
		
		openModelElement(actionItem);
		new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				Project project = actionItem.getProject();
				 WorkPackage workpackage = TaskFactory.eINSTANCE.createWorkPackage();
				 workpackage.setName("Sprint1");
				 project.addModelElement(workpackage);
				
			}
		}.run();
		
		getBot().activeEditor().bot().buttonWithLabel("Containing Workpackage", 0).click();
		getBot().text().setText("Sprint1");
		getBot().button("OK").click();
		getBot().sleep(5000);
		
		new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				assertEquals("Sprint1", actionItem.getContainingWorkpackage().getName());
				
			}
		}.run();
		
	}

	@Test
	public void testActionItemWorkPackageUnSet() {
			new UnicaseCommand() {
			@Override
			protected void doRun() {
				Project project = actionItem.getProject();
				 WorkPackage workpackage = TaskFactory.eINSTANCE.createWorkPackage();
				 workpackage.setName("Sprint1");
				 project.addModelElement(workpackage);
				 actionItem.setContainingWorkpackage(workpackage);
			}
		}.run();
		openModelElement(actionItem);
		UnicaseCommand packageLinkFinder = new UnicaseCommand() {
			
			@SuppressWarnings("unchecked")
			@Override
			protected void doRun() {
			Matcher match = allOf(widgetOfType(Hyperlink.class), withRegex("Sprint1"));
			final List packageLink = getBot().getFinder().findControls(match);
			String link = ((Hyperlink)packageLink.get(0)).getText();
			assertEquals("Sprint1", link);
			getBot().sleep(2000);
			actionItem.setContainingWorkpackage(null);
			}
		}; runAsnc(packageLinkFinder);
 		
		UnicaseCommand workpackageNullCommand = new UnicaseCommand() {
			
			@SuppressWarnings("unchecked")
			@Override
			protected void doRun() {
				Matcher match  = allOf(widgetOfType(Label.class), withRegex("(Not Set)"));
				List list = getBot().getFinder().findControls(match);
			assertEquals(4, list.size());
				
			}
		}; runAsnc(workpackageNullCommand);
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testAssigneeDefault()  {
		
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
		
	
	new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				final Label label = ((Label)labelcontrols.get(1));
				Display display = label.getDisplay();
			
				display.syncExec(
					  new Runnable() {
					    public void run(){
					    String text = label.getText();
					    assertEquals("(Not Set)",text);
					    OrgUnit user = actionItem.getAssignee();
						assertEquals(null, user);
					    }
					  });
			
					}
		}.run();
	}

	
	@Test
	public void testAssigneeChange() {
		
		openModelElement(actionItem);
		getBot().activeEditor().bot().buttonWithLabel("Assignee",0).click(); 
		getBot().text().setText("Joker");
		getBot().button("OK").click();
		getBot().sleep(2000);
		final String assigneduser = "Joker";
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				assertEquals(assigneduser, actionItem.getAssignee().getName());
			}
		}.run();
	}


	
	@SuppressWarnings("unchecked")
	@Test
	public void testAssigneeUpdate()  {
		
		openModelElement(actionItem);
		final String name = "Batman";
		UnicaseCommandWithResult<Matcher> unicaseCommand = new UnicaseCommandWithResult<Matcher>() {
			
			@Override
			protected Matcher doRun() {
				User user = OrganizationFactory.eINSTANCE.createUser();
				user.setName(name);
				actionItem.setAssignee(user);
				
				Matcher match = allOf(widgetOfType(Hyperlink.class), withRegex("Batman"));
				return match;
			}
		};
		Matcher matcher = runAsnc(unicaseCommand);	
	
			
		List controls = getBot().getFinder().findControls(matcher);
		String text = ((Hyperlink)controls.get(0)).getText();
		assertEquals(name, text);
		
	}
	
	
	
	
	

}
