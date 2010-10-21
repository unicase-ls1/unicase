package org.unicase.iterationplanner.planner;

import java.util.List;
import java.util.Map;

/**
 * The evaluator evaluates an IterationPlan base on assignee expertise, task priorities, and assignee loads, and returns
 * an overall score for IterationPlan.
 * 
 * @author zardosht
 */
public abstract class Evaluator {

	private final EvaluatorParameters evaluationParameters;
	private IterationPlan iterationPlan;
	private Map<Integer, List<AssigneeAvailability>> assigneeAvailabilities;

	public Evaluator(EvaluatorParameters evaluationParameters) {
		this.evaluationParameters = evaluationParameters;
	}

	public double evaluate(final IterationPlan iterationPlan,
		final Map<Integer, List<AssigneeAvailability>> assigneeAvailabilities) {
		this.iterationPlan = iterationPlan;
		this.assigneeAvailabilities = assigneeAvailabilities;
		double expertiseScore = evaluateExpertise();
		double taskPriorityScore = evaluteTaskPriorities();
		double devLoadScore = evaluateAssigneeLoad();
		double overallScore = getOverallScore(expertiseScore, taskPriorityScore, devLoadScore);
		return overallScore;
	}

	protected abstract double evaluateExpertise();

	protected abstract double evaluteTaskPriorities();

	protected abstract double evaluateAssigneeLoad();

	protected abstract double getOverallScore(double expertiseScore, double taskPriorityScore, double devLoadScore);

	public EvaluatorParameters getEvaluationParameters() {
		return evaluationParameters;
	}

	protected IterationPlan getIterationPlan() {
		return iterationPlan;
	}

	protected Map<Integer, List<AssigneeAvailability>> getAssigneeAvailabilities() {
		return assigneeAvailabilities;
	}

}
