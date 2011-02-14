package org.unicase.iterationplanner.planner;

/**
 * The evaluator evaluates an IterationPlan base on assignee expertise, task priorities, and assignee loads, and returns
 * an overall score for IterationPlan.
 * 
 * @author zardosht
 */
public abstract class Evaluator {

	private final PlannerParameters plannerParameters;
	private IterationPlan iterationPlan;
	private AssigneeAvailabilityManager assigneeAvailabilityManager;

	public Evaluator(PlannerParameters evaluationParameters, AssigneeAvailabilityManager aam) {
		this.plannerParameters = evaluationParameters;
		this.assigneeAvailabilityManager = aam;
	}

	public double evaluate(final IterationPlan iterationPlan) {

		this.iterationPlan = iterationPlan;
		double expertiseScore = evaluateExpertise(getIterationPlan());
		double taskPriorityScore = evaluteTaskPriorities(getIterationPlan());
		double devLoadScore = evaluateAssigneeLoad(getIterationPlan());
		double overallScore = getOverallScore(expertiseScore, taskPriorityScore, devLoadScore);
		return overallScore;
	}

	public abstract double evaluateExpertise(IterationPlan iterPlan);

	public abstract double evaluteTaskPriorities(IterationPlan iterPlan);

	public abstract double evaluateAssigneeLoad(IterationPlan iterPlan);

	public abstract double getOverallScore(double expertiseScore, double taskPriorityScore, double devLoadScore);

	public PlannerParameters getPlannerParameters() {
		return plannerParameters;
	}

	protected IterationPlan getIterationPlan() {
		return iterationPlan;
	}

	protected AssigneeAvailabilityManager getAssigneeAvailabilityManager() {
		return assigneeAvailabilityManager;
	}

}
