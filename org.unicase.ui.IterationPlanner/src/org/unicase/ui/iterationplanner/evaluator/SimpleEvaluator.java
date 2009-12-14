/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.evaluator;

import org.unicase.model.organization.User;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.iterationplanner.IterationPlannerManager;
import org.unicase.ui.iterationplanner.planner.Plan;
import org.unicase.ui.iterationplanner.planner.SprintPlan;

/**
 * @author hodaie
 */
public class SimpleEvaluator implements Evaluator {

	private double secondProposalPercision;

	/**
	 * Constructor.
	 * 
	 * @param iterationPlannerManager iteration org.unicase.ui.iterationplanner.planner manager
	 */
	public SimpleEvaluator(IterationPlannerManager iterationPlannerManager) {}

	/**
	 * {@inheritDoc}
	 */
	public double evaluate(Plan plan) {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	public double evaluateAssignment(WorkItem task, User assignee) {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	public double evaluateSprintPlan(SprintPlan sprintPlan) {
		return 0;
	}

	/**
	 * @return secondProposalPercision
	 */
	public double getSecondProposalPercision() {
		return secondProposalPercision;
	}

}
