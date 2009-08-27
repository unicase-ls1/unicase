/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.iterationplanner.core;

import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.iterationplanner.evaluator.Evaluator;
import org.unicase.ui.iterationplanner.evaluator.SimpleEvaluator;
import org.unicase.ui.iterationplanner.planner.Planner;
import org.unicase.ui.iterationplanner.planner.SimplePlanner;
import org.unicase.ui.iterationplanner.provider.AssigneeProvider;
import org.unicase.ui.iterationplanner.provider.ImperativeAssigneePrediction;
import org.unicase.ui.iterationplanner.provider.RequirementProvider;
import org.unicase.ui.iterationplanner.provider.TaskProvider;

import java.util.List;

/**
 * This is a facade for iteration planning functions. It takes inputs to problem (requirements, tasks, assignee,
 * assignee availabilities) and delegates planning to Planner.
 * 
 * @author hodaie
 */
public class IterationPlannerManager {

	// sprint attributes
	private WorkPackage sprint;

	private AssigneeProvider assigneeProvider;
	private TaskProvider taskProvider;

	private Planner planner;

	private RequirementProvider requirementProvider;

	private Evaluator evaluator;

	/**
	 * Constructor.
	 * 
	 * @param lastSprint last sprint
	 * @param includedWorkPackages work packages to be included in planning
	 * @param requirements requirements to be included in planning
	 */
	public IterationPlannerManager(WorkPackage lastSprint, List<WorkPackage> includedWorkPackages,
		List<FunctionalRequirement> requirements) {

		assigneeProvider = new AssigneeProvider(this, new ImperativeAssigneePrediction(), lastSprint);
		assigneeProvider.initAssigneeAvailabilities();

		taskProvider = new TaskProvider(this, lastSprint, includedWorkPackages);

		requirementProvider = new RequirementProvider(this, requirements);

		planner = new SimplePlanner();

		evaluator = new SimpleEvaluator(this);

	}

	/**
	 * Constructor.
	 */
	public IterationPlannerManager() {
		assigneeProvider = new AssigneeProvider(this, new ImperativeAssigneePrediction());
		taskProvider = new TaskProvider(this);
		requirementProvider = new RequirementProvider(this);
		planner = new SimplePlanner();
		evaluator = new SimpleEvaluator(this);
	}

	/**
	 * returns the assignee provider.
	 * 
	 * @return assignee provider
	 */
	public AssigneeProvider getAssigneeProvider() {
		return assigneeProvider;
	}

	/**
	 * returns task provider.
	 * 
	 * @return task provider
	 */
	public TaskProvider getTaskProvider() {
		return taskProvider;
	}

	/**
	 * returns org.unicase.ui.iterationplanner.planner.
	 * 
	 * @return org.unicase.ui.iterationplanner.planner
	 */
	public Planner getPlanner() {
		return planner;
	}

	/**
	 * Sets the org.unicase.ui.iterationplanner.planner strategy (EA or Simple).
	 * 
	 * @param org.unicase.ui.iterationplanner.planner org.unicase.ui.iterationplanner.planner
	 */
	public void setPlanner(Planner planner) {
		this.planner = planner;
	}

	/**
	 * tmp.
	 * 
	 * @return sprint
	 */
	public WorkPackage getSprint() {
		return sprint;
	}

	/**
	 * requirements provider.
	 * 
	 * @return requirements provider.
	 */
	public RequirementProvider getRequirementProvider() {
		return requirementProvider;
	}

	/**
	 * Set evaluator.
	 * 
	 * @param evaluator evaluator
	 */
	public void setEvaluator(Evaluator evaluator) {
		this.evaluator = evaluator;
	}

	/**
	 * evaluator.
	 * 
	 * @return evaluator.
	 */
	public Evaluator getEvaluator() {
		return evaluator;
	}

}
