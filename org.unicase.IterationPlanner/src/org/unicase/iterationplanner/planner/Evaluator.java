package org.unicase.iterationplanner.planner;

import org.unicase.iterationplanner.entities.AssigneeAvailabilityManager;
import org.unicase.iterationplanner.entities.IIterationPlan;
import org.unicase.iterationplanner.entities.PlannerParameters;

/**
 * The evaluator evaluates an IterationPlan base on assignee expertise, task priorities, and assignee loads, and returns
 * an overall score for IterationPlan.
 * 
 * @author zardosht
 */
public abstract class Evaluator {

	private final PlannerParameters plannerParameters;
	private IIterationPlan iterationPlan;
	private AssigneeAvailabilityManager assigneeAvailabilityManager;

	public Evaluator(PlannerParameters evaluationParameters, AssigneeAvailabilityManager aam) {
		this.plannerParameters = evaluationParameters;
		this.assigneeAvailabilityManager = aam;
	}

	public double evaluate(final IIterationPlan iterationPlan) {

		this.iterationPlan = iterationPlan;
		double expertiseScore = evaluateExpertise(getIterationPlan());
		double taskPriorityScore = evaluteTaskPriorities(getIterationPlan());
		double devLoadScore = evaluateAssigneeLoad(getIterationPlan());
		double overallScore = getOverallScore(expertiseScore, taskPriorityScore, devLoadScore);
		return overallScore;
	}

	public abstract double evaluateExpertise(IIterationPlan iterPlan);

	public abstract double evaluteTaskPriorities(IIterationPlan iterPlan);

	public abstract double evaluateAssigneeLoad(IIterationPlan iterPlan);

	public abstract double getOverallScore(double expertiseScore, double taskPriorityScore, double devLoadScore);

	public PlannerParameters getPlannerParameters() {
		return plannerParameters;
	}

	protected IIterationPlan getIterationPlan() {
		return iterationPlan;
	}

	protected AssigneeAvailabilityManager getAssigneeAvailabilityManager() {
		return assigneeAvailabilityManager;
	}

}
