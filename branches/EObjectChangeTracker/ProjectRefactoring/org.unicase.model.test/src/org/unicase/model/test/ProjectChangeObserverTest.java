/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.junit.Before;
import org.junit.Test;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelFactory;
import org.unicase.model.Project;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.util.ProjectChangeObserver;

/**
 * Test the change observer.
 * @author koegel
 *
 */
public class ProjectChangeObserverTest implements ProjectChangeObserver {

	private Project project;
	private ModelElement lastAddedElement;
	private ModelElement lastDeleteStartedElement;
	private ModelElement lastDeleteCompletedElement;
	private List<Notification> lastNotifications;

	/**
	 * Setup the project.
	 */
	@Before
	public void setUp() {
		project = ModelFactory.eINSTANCE.createProject();
		project.addProjectChangeObserver(this);
		clear();
	}

	/**
	 * Test to add elements.
	 */
	@Test
	public void testAddingElements() {
		FunctionalRequirement fr1 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr2 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr21 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr22 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr212 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		fr2.getRefiningRequirements().add(fr21);
		fr2.getRefiningRequirements().add(fr22);
		fr21.getRefiningRequirements().add(fr212);
		
		project.addModelElement(fr1);
		assertEquals(fr1, lastAddedElement);
		assertEquals(0, lastNotifications.size());
		
		clear();
		
		project.addModelElement(fr2);
		assertEquals(fr2, lastAddedElement);
		assertEquals(0, lastNotifications.size());		
	}

	/**
	 * Test Deleting elements.
	 */
	@Test
	public void testDeletingElements() {
		FunctionalRequirement fr1 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr2 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr21 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr22 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr212 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		fr2.getRefiningRequirements().add(fr21);
		fr2.getRefiningRequirements().add(fr22);
		fr21.getRefiningRequirements().add(fr212);
		ActionItem actionItem = TaskFactory.eINSTANCE.createActionItem();
		project.addModelElement(actionItem);
		project.addModelElement(fr1);
		project.addModelElement(fr2);
		actionItem.getAnnotatedModelElements().add(fr21);
		actionItem.getAnnotatedModelElements().add(fr212);
	
		clear();
		
		fr1.delete();
		assertEquals(fr1,lastDeleteStartedElement);
		assertEquals(fr1,lastDeleteCompletedElement);
		assertEquals(0, lastNotifications.size());
		
		clear();
		
		fr21.delete();
		assertEquals(fr21,lastDeleteStartedElement);
		assertEquals(fr21,lastDeleteCompletedElement);
		assertEquals(6, lastNotifications.size());
		
		clear();
		
		fr2.delete();
		assertEquals(fr2,lastDeleteStartedElement);
		assertEquals(fr2,lastDeleteCompletedElement);
		assertEquals(0, lastNotifications.size());
		
		
	}
	
	/**
	 * Test moving elements.
	 */
	@Test
	public void testMovingElements() {
		FunctionalRequirement fr1 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr2 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr21 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr22 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr212 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		fr2.getRefiningRequirements().add(fr21);
		fr2.getRefiningRequirements().add(fr22);
		fr21.getRefiningRequirements().add(fr212);
		project.addModelElement(fr1);
		project.addModelElement(fr2);
		
		clear();
		fr212.setRefinedRequirement(fr22);
		assertEquals(3, lastNotifications.size());
		
		clear();
		fr212.getRefiningRequirements().add(fr1);
		assertEquals(1, lastNotifications.size());
		
		clear();
		fr212.setRefinedRequirement(fr2);
		assertEquals(3, lastNotifications.size());
		
	}
	
	/**
	 * Test changing elements without delete or add.
	 */
	@Test
	public void testChangingElements() {
		FunctionalRequirement fr1 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr2 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr21 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr22 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr212 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		fr2.getRefiningRequirements().add(fr21);
		fr2.getRefiningRequirements().add(fr22);
		fr21.getRefiningRequirements().add(fr212);
		project.addModelElement(fr1);
		project.addModelElement(fr2);
		ActionItem actionItem = TaskFactory.eINSTANCE.createActionItem();
		project.addModelElement(actionItem);
		actionItem.getAnnotatedModelElements().add(fr21);
		
		clear();
		fr1.setName("fr1");
		assertEquals(1, lastNotifications.size());
		
		clear();
		fr22.setName("fr22");
		assertEquals(1, lastNotifications.size());
		
		clear();
		fr212.getAnnotations().add(actionItem);
		assertEquals(2, lastNotifications.size());
		
		clear();
		actionItem.getAnnotatedModelElements().add(fr22);
		assertEquals(2, lastNotifications.size());
		
	}

	/**
	 * Test adding element to project with existing cross references.
	 */
	@Test (expected = IllegalStateException.class)
	public void testCrossReferenceAdd() {
		FunctionalRequirement fr2 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr21 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr22 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr212 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		fr2.getRefiningRequirements().add(fr21);
		fr2.getRefiningRequirements().add(fr22);
		fr21.getRefiningRequirements().add(fr212);
		ActionItem actionItem = TaskFactory.eINSTANCE.createActionItem();
		actionItem.getAnnotatedModelElements().add(fr21);
		project.addModelElement(actionItem);
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementAdded(org.unicase.model.Project, org.unicase.model.ModelElement)
	 */
	public void modelElementAdded(Project project, ModelElement modelElement) {
		lastAddedElement = modelElement;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementDeleteCompleted(org.unicase.model.Project, org.unicase.model.ModelElement)
	 */
	public void modelElementDeleteCompleted(Project project, ModelElement modelElement) {
		lastDeleteCompletedElement = modelElement;
		
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementDeleteStarted(org.unicase.model.Project, org.unicase.model.ModelElement)
	 */
	public void modelElementDeleteStarted(Project project, ModelElement modelElement) {
		lastDeleteStartedElement = modelElement;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.model.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification, org.unicase.model.Project, org.unicase.model.ModelElement)
	 */
	public void notify(Notification notification, Project project, ModelElement modelElement) {
		if (notification.getEventType()==Notification.REMOVE_MANY && notification.getNewValue() == null && notification.getOldValue() instanceof Collection<?>
			&& ((Collection<?>) notification.getOldValue()).isEmpty()) {
			return;
		}
		lastNotifications.add(notification);
	}
	
	private void clear() {
		this.lastAddedElement=null;
		this.lastDeleteCompletedElement=null;
		this.lastDeleteStartedElement=null;
		this.lastNotifications=new ArrayList<Notification>();
	}
}
