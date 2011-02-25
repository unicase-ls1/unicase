/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.evaluator;

import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.iterationplanner.core.IterationPlannerManager;
import org.unicase.ui.iterationplanner.core.Plan;
import org.unicase.ui.iterationplanner.core.SprintPlan;
import org.unicase.ui.iterationplanner.provider.ExpertiseMap;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author hodaie
 */
public class SimpleEvaluator implements Evaluator {

	private IterationPlannerManager planningManager;
	private double firstProposalPercision;
	private double secondProposalPercision;

	/**
	 * Constructor.
	 * 
	 * @param iterationPlannerManager iteration org.unicase.ui.iterationplanner.planner manager
	 */
	public SimpleEvaluator(IterationPlannerManager iterationPlannerManager) {
		this.planningManager = iterationPlannerManager;
	}

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
	 * Temp method.
	 * 
	 * @param testSet testSet
	 */
	public void computeAccuracy(Map<WorkItem, ExpertiseMap> testSet) {
		firstProposalPercision = 0;
		secondProposalPercision = 0;
		int firstCorrectAssignments = 0;
		int secondCorrectAssignments = 0;
		int numOfWorkItems = testSet.size();

		for (WorkItem wi : testSet.keySet()) {

			OrgUnit realAssignee = wi.getAssignee();
			if (testSet.get(wi).isAllZero()) {
				continue;
			}
			List<Entry<OrgUnit, Double>> sortedProposedAssignees = testSet.get(wi).sortByExpertise();
			OrgUnit firstProposedAssignee = sortedProposedAssignees.get(0).getKey();
			OrgUnit secondProposedAssignee = sortedProposedAssignees.get(1).getKey();

			if (firstProposedAssignee.equals(realAssignee)) {
				firstCorrectAssignments++;
			} else if (secondProposedAssignee.equals(realAssignee)) {
				secondCorrectAssignments++;
			}

		}

		firstProposalPercision = ((double) firstCorrectAssignments / numOfWorkItems) * 100;
		secondProposalPercision = ((double) secondCorrectAssignments / numOfWorkItems) * 100;

	}

	/**
	 * @return firstProposalPercision
	 */
	public double getFirstProposalPercision() {
		return firstProposalPercision;
	}

	/**
	 * @return secondProposalPercision
	 */
	public double getSecondProposalPercision() {
		return secondProposalPercision;
	}

}
