package org.unicase.iterationplanner.planner.impl;

import java.util.List;

import org.unicase.iterationplanner.assigneerecommendation.Assignee;
import org.unicase.iterationplanner.planner.AssigneeAvailability;
import org.unicase.iterationplanner.planner.Evaluator;
import org.unicase.iterationplanner.planner.EvaluatorParameters;
import org.unicase.iterationplanner.planner.PlannedTask;

public class MyEvaluator extends Evaluator {

	public MyEvaluator(EvaluatorParameters evaluationParameters) {
		super(evaluationParameters);
	}

	@Override
	protected double evaluateAssigneeLoad() {
		// for assignee wie viele tasks in iter? sum(estimate for tasks for assignee)
		// compare estimate sum with avail. of dev.
		int numOfIterations = getIterationPlan().getNumOfIterations();
		if (numOfIterations != getAssigneeAvailabilities().keySet().size()) {
			throw new RuntimeException(
				"Number of iterations in iteration plan, and number of iterations in assignee availabilites map do not match.");
		}

		double sum = 0.0;
		int count = 0;
		for (Integer i : getAssigneeAvailabilities().keySet()) {
			for (AssigneeAvailability av : getAssigneeAvailabilities().get(i)) {
				// get an average for on all scores for all assignees in all iterations. (normalize: 1.0 *
				// numOfIterations * numOfAssignees)
				// iteration, assignee
				// getEstimateForAssignee(iteration, assignee)
				// compare estimateForAssignee with assigneeAvailability
				// if(estimate > avail.) ==> return score 0 //just one violation (violation in one iteration) is enough
				// to get you out
				// else score = estimate / availability
				// sum += score
				int estimateForAssigneeInIteration = getEstimateForAssigneeInIteration(i.intValue(), av.getAssignee());
				int availability = av.getAvailability();
				if (estimateForAssigneeInIteration > availability) {
					return 0.0;
				} else {
					double scoreForAssigneeInIteration = estimateForAssigneeInIteration / availability;
					sum += scoreForAssigneeInIteration;
				}
				count++;
			}
		}

		double avg = sum / count;
		// avg is already between 0 and 1. Because max scoreForAssigneeInIteration is 1.0, then the
		// highest possible value of sum would be 1.0 * count
		return avg;
	}

	private int getEstimateForAssigneeInIteration(int iterNumber, Assignee assignee) {
		int result = 0;
		List<PlannedTask> tasksForIterationAndAssignee = getIterationPlan().getAllPlannedTasksForIterationAndAssignee(
			iterNumber, assignee);
		for (PlannedTask pt : tasksForIterationAndAssignee) {
			result += pt.getTask().getEstimate();
		}
		return result;
	}

	@Override
	protected double evaluateExpertise() {
		// avg(all experties)
		double sum = 0.0;
		for (PlannedTask pt : getIterationPlan().getPlannedTasks()) {
			if (pt.isEvaluateExperties()) {
				sum += pt.getAssigneeExpertise().getExpertise();
			}
		}
		int size = getIterationPlan().getPlannedTasks().size();
		double avg = sum / size;
		// avg is already between 0 and 1. Because max expertise is 1.0, then the
		// highest possible value of sum would be 1.0 * size
		return avg;
	}

	@Override
	protected double evaluteTaskPriorities() {
		// t1.priority > t2.priority ==> t1.iterationNumber < t2.iterationNumber
		// for every breaking this rule, give a -1
		int violations = 0;
		for (PlannedTask pt1 : getIterationPlan().getPlannedTasks()) {
			for (PlannedTask pt2 : getIterationPlan().getPlannedTasks()) {
				if (pt1.getTask().getPriority() > pt2.getTask().getPriority()) {
					if (pt1.getIterationNumber() > pt2.getIterationNumber()) {
						violations += 1;
					}
				}
			}
		}
		// normalize.
		return violations == 0 ? 1.0 : 1 / (double) violations;
	}

	@Override
	protected double getOverallScore(double expertiseScore, double taskPriorityScore, double devLoadScore) {

		// max value would be (1.0 * 1.0 + 1.0 * 1.0 + 1.0 * 1.0) = 3.0
		return (expertiseScore * getEvaluationParameters().getExpertiesWeight() + taskPriorityScore
			* getEvaluationParameters().getPriorityWeight() + devLoadScore
			* getEvaluationParameters().getDeveloperLoadWeight()) / 3.0;
	}
}
