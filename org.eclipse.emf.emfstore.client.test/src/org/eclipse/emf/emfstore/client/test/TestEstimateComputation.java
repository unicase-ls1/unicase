/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.common.model.ModelFactory;
import org.eclipse.emf.emfstore.common.model.Project;
import org.junit.Test;

/**
 * Test methods responsible for computation of estimates in WorkPackage and EstimateHelper.
 * 
 * @author max
 */
public class TestEstimateComputation extends TestCase {
	private Project project;
	private WorkPackage wpRoot;
	private WorkPackage wpLeafOpeners;

	private final int[] estimates = { 1, 2, 3, 4 };
	private final int[] closedEstimates = { 5 };
	private final int[] leafOpenerEstimates = { 6 };
	private final int[] leafOpenerClosedEstimates = { 7 };
	private int estimatesSum;
	private int closedEstimatesSum;
	private int leafOpenerEstimatesSum;
	private int leafOpenerClosedEstimatesSum;

	private WorkPackage createWorkPackage(EObject parent) {
		WorkPackage workPackage = TaskFactory.eINSTANCE.createWorkPackage();

		if (parent == null) {
			workPackage.setName("rootWP");
			project.addModelElement(workPackage);
			return workPackage;
		}

		if (parent instanceof WorkPackage) {
			((WorkPackage) parent).getContainedWorkItems().add(workPackage);
		}
		workPackage.setName("New WorkPackage relating " + ((UnicaseModelElement) parent).getName());
		return workPackage;

	}

	// copied from AssignNewActionItemHandler
	private ActionItem createActionItem(EObject parent) {
		ActionItem ai = TaskFactory.eINSTANCE.createActionItem();

		if (parent instanceof WorkPackage) {
			((WorkPackage) parent).getContainedWorkItems().add(ai);
		} else {
			project.addModelElement(ai);
			((UnicaseModelElement) parent).getAnnotations().add(ai);
		}
		ai.setName("New ActionItem relating " + ((UnicaseModelElement) parent).getName());
		// ai.setAssignee(user);
		return ai;

	}

	/**
	 * Create a minimal project. {@inheritDoc}
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	public void setUp() {
		project = ModelFactory.eINSTANCE.createProject();

		// WorkPackage Hierachy
		wpRoot = createWorkPackage(null);
		WorkPackage wpSub1 = createWorkPackage(wpRoot);
		WorkPackage wpSub1Sub1 = createWorkPackage(wpSub1);
		WorkPackage wpSub2 = createWorkPackage(wpRoot);
		createWorkPackage(wpRoot);

		// Open ActionItems
		List<ActionItem> actionItems = new ArrayList<ActionItem>();
		actionItems.add(createActionItem(wpRoot));
		actionItems.add(createActionItem(wpSub1));
		actionItems.add(createActionItem(wpSub1Sub1));
		actionItems.add(createActionItem(wpSub2));
		for (int i = 0; i < estimates.length; i++) {
			actionItems.get(i).setEstimate(estimates[i]);
			estimatesSum += estimates[i];
		}

		// Closed ActionItems
		List<ActionItem> closedActionItems = new ArrayList<ActionItem>();
		closedActionItems.add(createActionItem(wpSub1Sub1));
		for (int i = 0; i < closedEstimates.length; i++) {
			closedActionItems.get(i).setEstimate(closedEstimates[i]);
			closedActionItems.get(i).setDone(true);
			closedActionItems.get(i).setChecked(true);
			closedActionItems.get(i).setResolved(true);
			closedEstimatesSum += closedEstimates[i];
		}

		// Extra WorkPackage for ActionItems that are leafOpeners
		wpLeafOpeners = createWorkPackage(null);

		// Open ActionItems that are leafOpeners
		List<ActionItem> leafOpenerActionItems = new ArrayList<ActionItem>();
		leafOpenerActionItems.add(createActionItem(wpLeafOpeners));
		for (int i = 0; i < leafOpenerEstimates.length; i++) {
			leafOpenerActionItems.get(i).setEstimate(leafOpenerEstimates[i]);
			leafOpenerEstimatesSum += leafOpenerEstimates[i];
		}

		actionItems.get(0).getAnnotations().add(leafOpenerActionItems.get(0));

		// Closed ActionItems that are leafOpeners
		List<ActionItem> leafOpenerClosedActionItems = new ArrayList<ActionItem>();
		leafOpenerClosedActionItems.add(createActionItem(wpLeafOpeners));
		for (int i = 0; i < leafOpenerClosedEstimates.length; i++) {
			leafOpenerClosedActionItems.get(i).setEstimate(leafOpenerClosedEstimates[i]);
			leafOpenerClosedActionItems.get(i).setDone(true);
			leafOpenerClosedActionItems.get(i).setChecked(true);
			leafOpenerClosedActionItems.get(i).setResolved(true);
			leafOpenerClosedEstimatesSum += leafOpenerClosedEstimates[i];
		}

		actionItems.get(0).getAnnotations().add(leafOpenerClosedActionItems.get(0));

		// A Functional Requirement to connect the leafs from the two disjunct WorkPackages
		// FunctionalRequirement req = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		// UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		// req.setName("Functional Requirement");
		// ai0.getAnnotatedModelElements().add(req);
		// lai0.getAnnotatedModelElements().add(req);
	}

	/**
	 * Get number of all tasks with and without leafOpeners.
	 */
	@Test
	public void testGetAllTasks() {

		assertEquals(estimates.length + closedEstimates.length + leafOpenerEstimates.length
			+ leafOpenerClosedEstimates.length, EstimateHelper.getAllTasks(wpRoot));
		assertEquals(estimates.length + closedEstimates.length, wpRoot.getAllTasks());
	}

	/**
	 * Get number of all closed tasks with and without leafOpeners.
	 */
	@Test
	public void testGetClosedTasks() {
		assertEquals(closedEstimates.length + leafOpenerClosedEstimates.length, EstimateHelper.getClosedTasks(wpRoot));
		assertEquals(closedEstimates.length, wpRoot.getClosedTasks());
	}

	/**
	 * Get aggregated estimate of all tasks with and without leafOpeners.
	 */
	@Test
	public void testGetAggregatedEstimate() {
		assertEquals(estimatesSum + closedEstimatesSum + leafOpenerEstimatesSum + leafOpenerClosedEstimatesSum,
			EstimateHelper.getAggregatedEstimate(wpRoot));
		assertEquals(estimatesSum + closedEstimatesSum, wpRoot.getAggregatedEstimate());
	}

	/**
	 * Get aggregated estimate of all closed tasks with and without leafOpeners.
	 */
	@Test
	public void testGetClosedAggregatedEstimate() {
		assertEquals(closedEstimatesSum + leafOpenerClosedEstimatesSum,
			EstimateHelper.getClosedAggregatedEstimate(wpRoot));
		assertEquals(closedEstimatesSum, wpRoot.getClosedAggregatedEstimate());
	}

	/**
	 * Get aggregated estimate of all open tasks with and without leafOpeners.
	 */
	@Test
	public void testGetRemainingEstimate() {
		assertEquals(estimatesSum + leafOpenerEstimatesSum, EstimateHelper.getRemainingEstimate(wpRoot));
		assertEquals(estimatesSum, wpRoot.getRemainingEstimate());
	}

	/**
	 * This tests and documents the overflow behavior with extreme values for estimates.
	 */
	@Test
	public void testExtremeValues() {
		final int bigEstimate = 2147483647;
		final int smallEstimate = 1;
		final int overflow = -2147483648;

		WorkPackage wpAnotherRoot = createWorkPackage(null);
		ActionItem veryBig = createActionItem(wpAnotherRoot);
		ActionItem verySmall = createActionItem(wpAnotherRoot);
		veryBig.setEstimate(bigEstimate);
		verySmall.setEstimate(smallEstimate);

		assertEquals(overflow, wpAnotherRoot.getAggregatedEstimate());
		assertEquals(overflow, EstimateHelper.getAggregatedEstimate(wpAnotherRoot));
	}
}
