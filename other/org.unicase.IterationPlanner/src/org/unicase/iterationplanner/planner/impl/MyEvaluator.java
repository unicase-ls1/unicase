package org.unicase.iterationplanner.planner.impl;

import org.unicase.iterationplanner.planner.Evaluator;
import org.unicase.iterationplanner.planner.EvaluatorParameters;

public class MyEvaluator extends Evaluator {

	public MyEvaluator(EvaluatorParameters evaluationParameters) {
		super(evaluationParameters);
	}

	@Override
	protected double evaluateAssigneeLoad() {
		return 0;
	}

	@Override
	protected double evaluateExpertise() {
		return 0;
	}

	@Override
	protected double evaluteTaskPriorities() {
		return 0;
	}

	@Override
	protected double getOverallScore(double expertiseScore, double taskPriorityScore, double devLoadScore) {
		return 0;
	}

}
