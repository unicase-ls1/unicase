/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.meeditor.mecontrols.melinkcontrol;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.allOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withTooltip;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.organization.impl.OrganizationFactoryImpl;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.UnicaseCommandWithResult;

/**
 * Test the multilink control for MEEditor.
 * 
 * @author Nitesh
 */
public class MEMultiLinkControlTest extends MEEditorTest {
	private ActionItem actionItem;

	/**
	 * Setup helper method for setting environment.
	 */
	@Before
	public void setupActionItem() {

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				actionItem = TaskFactory.eINSTANCE.createActionItem();
				actionItem.setName("My ActionItem");
				getLeafSection().getModelElements().add(actionItem);
				Project project = ModelUtil.getProject(actionItem);
				User user1 = OrganizationFactory.eINSTANCE.createUser();
				user1.setName("Joker");
				project.addModelElement(user1);
				User user2 = OrganizationFactory.eINSTANCE.createUser();
				user2.setName("Batman");
				project.addModelElement(user2);
			}
		}.run();
	}

	/**
	 * Add one cross-reference in empty multi-link widget from UI and verifies the changes in underlying ME.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testChangeAddOneInEmpty() {
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
				ToolItem toolItem = ((ToolItem) widgetcontrol.get(0));
				Event event = new Event();
				event.widget = ((ToolItem) widgetcontrol.get(0));
				toolItem.notifyListeners(SWT.Selection, event);
			}
		};
		runAsnc(widgetActivateCommand);

		final String participant = "Joker";
		getBot().text().setText(participant);
		getBot().button("OK").click();
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				EList<OrgUnit> list = actionItem.getParticipants();
				if (!list.isEmpty()) {
					final String getparticipant1 = list.get(0).getName();
					assertEquals(participant, getparticipant1);

				}

			}
		}.run();
	}

	/**
	 * Add one cross-reference in an empty multi-link widget programattically and verify the changes in UI.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testUpdateAddOneInEmpty() {
		openModelElement(actionItem);
		UnicaseCommand unicaseCommand = new UnicaseCommand() {
			@Override
			protected void doRun() {
				Project project = ModelUtil.getProject(actionItem);
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
		String finalUser = ((Hyperlink) widgetcontrol.get(0)).getText();
		assertEquals("BOND", finalUser);
	}

	/**
	 * Add multiple cross-references in a multi-link widget(from UI) which is already having existing cross-references.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testChangeAddMultipleInExisting() {
		openModelElement(actionItem);
		UnicaseCommand unicaseCommand = new UnicaseCommand() {

			@Override
			protected void doRun() {
				Project project = ModelUtil.getProject(actionItem);
				EList<User> users = project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(),
					new BasicEList<User>());
				if (users != null) {
					actionItem.getParticipants().addAll(users);
					User user1 = OrganizationFactoryImpl.eINSTANCE.createUser();
					user1.setName("Tobias");
					project.addModelElement(user1);
					User user2 = OrganizationFactoryImpl.eINSTANCE.createUser();
					user2.setName("Henry");
					project.addModelElement(user2);

				}

			}
		};
		runAsnc(unicaseCommand);

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
				ToolItem toolItem = ((ToolItem) widgetcontrol.get(0));
				Event event = new Event();
				event.widget = ((ToolItem) widgetcontrol.get(0));
				toolItem.notifyListeners(SWT.Selection, event);
			}
		};
		runAsnc(widgetActivateCommand);

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
				if (!list.isEmpty()) {
					for (OrgUnit l : list) {
						if (l.getName().equals(participant1)) {
							assertEquals(participant1, l.getName());
						} else if (l.getName().equals(participant2)) {
							assertEquals(participant2, l.getName());
						}
					}
				}

			}
		}.run();
	}

	/**
	 * Add multiple cross-references in a multi-link widget( programattically ) which is already having existing
	 * cross-references.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testUpdateAddMultipleInExisting() {
		openModelElement(actionItem);
		UnicaseCommand addParticipantCommand = new UnicaseCommand() {

			@Override
			protected void doRun() {
				Project project = ModelUtil.getProject(actionItem);
				EList<User> users = project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(),
					new BasicEList<User>());
				if (users != null) {
					actionItem.getParticipants().addAll(users);
				}

			}
		};
		runAsnc(addParticipantCommand);

		UnicaseCommand unicaseCommand = new UnicaseCommand() {

			@Override
			protected void doRun() {
				Project project = ModelUtil.getProject(actionItem);
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
		String finalUser1 = ((Hyperlink) widgetcontrol1.get(0)).getText();
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
		String finalUser2 = ((Hyperlink) widgetcontrol2.get(0)).getText();
		assertEquals("James", finalUser2);

	}

	/**
	 * Add one cross-reference in a multi-link widget(from UI) which already have multiple existing cross-references.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testChangeAddOneInExisting() {
		openModelElement(actionItem);
		UnicaseCommand unicaseCommand = new UnicaseCommand() {

			@Override
			protected void doRun() {
				Project project = ModelUtil.getProject(actionItem);
				EList<User> users = project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(),
					new BasicEList<User>());
				if (users != null) {
					actionItem.getParticipants().addAll(users);
					User user = OrganizationFactoryImpl.eINSTANCE.createUser();
					user.setName("Tobias");
					project.addModelElement(user);

				}

			}
		};
		runAsnc(unicaseCommand);

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
				ToolItem toolItem = ((ToolItem) widgetcontrol.get(0));
				Event event = new Event();
				event.widget = ((ToolItem) widgetcontrol.get(0));
				toolItem.notifyListeners(SWT.Selection, event);
			}
		};
		runAsnc(widgetActivateCommand);

		final String participant = "Tobias";
		getBot().text().setText(participant);
		getBot().button("OK").click();
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				EList<OrgUnit> list = actionItem.getParticipants();
				if (!list.isEmpty()) {
					for (OrgUnit l : list) {
						if (l.getName().equals(participant)) {
							assertEquals(participant, l.getName());
							break;
						}
					}
				}

			}
		}.run();
	}

	/**
	 * Add one cross-reference in a multi-link widget(programattically) which already have multiple existing
	 * cross-references.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testUpdateAddOneInExisting() {
		openModelElement(actionItem);
		UnicaseCommand addParticipantCommand = new UnicaseCommand() {

			@Override
			protected void doRun() {
				Project project = ModelUtil.getProject(actionItem);
				EList<User> users = project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(),
					new BasicEList<User>());
				if (users != null) {
					actionItem.getParticipants().addAll(users);
				}

			}
		};
		runAsnc(addParticipantCommand);

		UnicaseCommand unicaseCommand = new UnicaseCommand() {
			@Override
			protected void doRun() {
				Project project = ModelUtil.getProject(actionItem);
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
		String finalUser1 = ((Hyperlink) widgetcontrol.get(0)).getText();
		assertEquals("BOND", finalUser1);

	}

	/**
	 * Add 2 participants in an ActioItem from UI and see if its the same programattically.
	 */
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
				ToolItem toolItem = ((ToolItem) widgetcontrol.get(0));
				Event event = new Event();
				event.widget = ((ToolItem) widgetcontrol.get(0));
				toolItem.notifyListeners(SWT.Selection, event);
			}
		};
		runAsnc(widgetActivateCommand);

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
				if (!list.isEmpty()) {
					final String getparticipant1 = list.get(0).getName();
					final String getparticipant2 = list.get(1).getName();
					assertEquals(participant1, getparticipant1);
					assertEquals(participant2, getparticipant2);
				}

			}
		}.run();

	}

	/**
	 * Add 2 participants in an ActioItem programattically and see if its the same in UI.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testParticipantsUpdate() {

		openModelElement(actionItem);
		UnicaseCommand unicaseCommand = new UnicaseCommand() {
			@Override
			protected void doRun() {
				Project project = ModelUtil.getProject(actionItem);
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
		String finalUser1 = ((Hyperlink) widgetcontrol.get(0)).getText();
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
		String finalUser2 = ((Hyperlink) control.get(0)).getText();
		assertEquals("James", finalUser2);

	}

	/**
	 * Remove a cross-reference programattically and see if the UI gets updated.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testRemoveOneUpdate() {
		openModelElement(actionItem);
		UnicaseCommand someCommand = new UnicaseCommand() {
			@Override
			protected void doRun() {
				Project project = ModelUtil.getProject(actionItem);
				User user = OrganizationFactory.eINSTANCE.createUser();
				user.setName("James");
				project.addModelElement(user);
				actionItem.getParticipants().add(user);

			}
		};
		runAsnc(someCommand);

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
				EList<User> user = ModelUtil.getProject(actionItem).getModelElementsByClass(
					OrganizationPackage.eINSTANCE.getUser(), new BasicEList<User>());
				for (User u : user) {
					if (u.getName().equals("James")) {
						actionItem.getParticipants().remove(u);
					}
				}

			}
		};
		runAsnc(removeCommand);

		getBot().activeEditor().bot().text().setFocus();
		Matcher noOfHyperlinks = runAsnc(unicaseCommand);
		List secondList = getBot().getFinder().findControls(noOfHyperlinks);
		// Size of secondList is supposed to be 2 less than the initial value as every user added as participants
		// increases the no. of ImageHyperlink widget to 2!
		assertEquals(previousListLength, secondList.size() + 2);

	}

	/**
	 * Remove multiple cross-reference programatically and see if the UI reflects them all properly.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testRemoveMultipleUpdate() {
		openModelElement(actionItem);
		UnicaseCommand someCommand = new UnicaseCommand() {
			@Override
			protected void doRun() {
				Project project = ModelUtil.getProject(actionItem);
				EList<User> users = project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(),
					new BasicEList<User>());
				if (users != null) {
					actionItem.getParticipants().addAll(users);
				}
				User user = OrganizationFactory.eINSTANCE.createUser();
				user.setName("James");
				project.addModelElement(user);
				actionItem.getParticipants().add(user);

			}
		};
		runAsnc(someCommand);

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
				EList<User> user = ModelUtil.getProject(actionItem).getModelElementsByClass(
					OrganizationPackage.eINSTANCE.getUser(), new BasicEList<User>());
				for (User u : user) {
					if (u.getName().equals("James")) {
						actionItem.getParticipants().remove(u);
					} else if (u.getName().equals("Batman")) {
						actionItem.getParticipants().remove(u);
					}
				}

			}
		};
		runAsnc(removeCommand);

		getBot().activeEditor().bot().text().setFocus();
		Matcher noOfHyperlinks = runAsnc(unicaseCommand);
		List secondList = getBot().getFinder().findControls(noOfHyperlinks);
		// Size of secondList is supposed to be 4 less than the initial value as every user added as participants
		// increases the no. of ImageHyperlink widget to 2 and if removed decreases the no. of ImageHyperLink to 2!
		assertEquals(previousListLength, secondList.size() + 4);

	}

}
