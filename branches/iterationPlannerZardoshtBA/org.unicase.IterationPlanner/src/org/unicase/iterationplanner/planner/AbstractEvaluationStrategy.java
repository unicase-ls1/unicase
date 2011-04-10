package org.unicase.iterationplanner.planner;


/**
 * The evaluator evaluates an ShiftDownIterationPlan base on assignee expertise, task priorities, and assignee loads, and returns
 * an overall score for ShiftDownIterationPlan.
 * 
 * @author zardosht
 */
public abstract class AbstractEvaluationStrategy {

	private final PlannerParameters plannerParameters;
	private IIterationPlan iterationPlan;
	private AssigneeAvailabilityManager assigneeAvailabilityManager;

	public AbstractEvaluationStrategy(PlannerParameters evaluationParameters, AssigneeAvailabilityManager aam) {
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
