/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.test.meeditor.mecontrol;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.allOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.inGroup;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withRegex;
import static org.junit.Assert.assertEquals;

import java.awt.Button;
import java.util.Date;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotLink;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotStyledText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.hamcrest.Matcher;
import org.hamcrest.core.AnyOf;
import org.junit.Before;
import org.junit.Test;
import org.eclipse.swtbot.swt.finder.matchers.*;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelElementChangeListener;
import org.unicase.model.Annotation;
import org.unicase.model.Attachment;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.organization.User;
import org.unicase.model.profile.StereotypeInstance;
import org.unicase.model.rationale.Comment;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.util.CircularDependencyException;
import org.unicase.model.task.util.MEState;
import org.unicase.workspace.util.UnicaseCommand;

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
	public void testAssigneeChange() throws Exception {
		
		openModelElement(actionItem);
		getBot().activeEditor().bot().buttonWithLabel("Assignee").click(); 
		getBot().table().select(0);
		getBot().button("OK").click();
		getBot().sleep(2000);
		final String assigneduser = "Joker";
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				assertEquals(assigneduser, actionItem.getAssignee().getName());
			}
		}.run();
		getBot().sleep(2000);
	}


	@SuppressWarnings("unchecked")
	@Test
	public void testAssigneeUpdate() throws Exception {
		
		openModelElement(actionItem);
		final String name = "Batman";
		UnicaseCommand unicaseCommand = new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				User user = OrganizationFactory.eINSTANCE.createUser();
				user.setName(name);
				actionItem.setAssignee(user);
								
			}
		};
		runAsnc(unicaseCommand);	
		
		final Matcher match = allOf(widgetOfType(Hyperlink.class), withRegex("Batman.*"));
		assertEquals(name, getBot().activeEditor().bot().widget(match).toString());
		
		//assertEquals(name, getBot().activeEditor().bot().linkWithId("User").getText());
		getBot().sleep(2000);
	

		
		
	}
	
	
}
