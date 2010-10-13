package org.unicase.iterationplanner.planner;

public abstract class Evaluator {

	private final EvaluatorParameters parameters;
	private IterationPlan iterationPlan;

	public Evaluator(EvaluatorParameters parameters) {
		this.parameters = parameters;
	}

	public double evaluate(final IterationPlan iterationPlan) {
		this.iterationPlan = iterationPlan;
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

	public EvaluatorParameters getParameters() {
		return parameters;
	}

	public IterationPlan getIterationPlan() {
		return iterationPlan;
	}

}
