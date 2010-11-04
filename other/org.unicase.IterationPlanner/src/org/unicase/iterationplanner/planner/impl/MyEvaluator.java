package org.unicase.iterationplanner.planner.impl;

import java.util.Set;

import org.unicase.iterationplanner.assigneerecommendation.Assignee;
import org.unicase.iterationplanner.planner.Evaluator;
import org.unicase.iterationplanner.planner.EvaluatorParameters;
import org.unicase.iterationplanner.planner.IterationPlan;
import org.unicase.iterationplanner.planner.PlannedTask;

public class MyEvaluator extends Evaluator {

	public MyEvaluator(EvaluatorParameters evaluationParameters) {
		super(evaluationParameters);
	}

	@Override
	public double evaluateAssigneeLoad(IterationPlan iterPlan) {
		// for assignee wie viele tasks in iter? sum(estimate for tasks for assignee)
		// compare estimate sum with avail. of dev.
		int numOfIterations = getIterationPlan().getNumOfIterations();
		double sum = 0.0;
		int count = 0;
		for (int i = 0; i < numOfIterations; i++) {
			for (Assignee assignee : iterPlan.getAssignees()) {
				// get an average for on all scores for all assignees in all iterations. (normalize: 1.0 *
				// numOfIterations * numOfAssignees)
				// iteration, assignee
				// getEstimateForAssignee(iteration, assignee)
				// compare estimateForAssignee with assigneeAvailability
				// if(estimate > avail.) ==> return score 0 //just one violation (violation in one iteration) is enough
				// to get you out
				// else score = estimate / availability
				// sum += score
				int estimateForAssigneeInIteration = iterPlan.getSumOfEstimateForIterationAndAssignee(i, assignee);
				int availability = getAssigneeAvailabilityManager().getAvailability(i, assignee);
				if (estimateForAssigneeInIteration > availability) {
					System.out.println("dev load delta: " + (availability - estimateForAssigneeInIteration));
					return 0.0;
				} else {
					double scoreForAssigneeInIteration = (double) estimateForAssigneeInIteration
						/ (double) availability;
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

	@Override
	public double evaluateExpertise(IterationPlan iterPlan) {
		// avg(all experties)
		double sum = 0.0;
		Set<PlannedTask> plannedTasks = PlannerUtil.getInstance(getEvaluationParameters().getRandom()).getPlannedTasks(iterPlan);
		for (PlannedTask pt : plannedTasks) {
			if (pt.isEvaluateExperties()) {
				sum += pt.getAssigneeExpertise().getExpertise();
			}
		}
		int size = plannedTasks.size();
		double avg = sum / size;
		// avg is already between 0 and 1. Because max expertise is 1.0, then the
		// highest possible value of sum would be 1.0 * size
		return avg;
	}

	

	@Override
	public double evaluteTaskPriorities(IterationPlan iterPlan) {
		Set<PlannedTask> plannedTasks = PlannerUtil.getInstance(getEvaluationParameters().getRandom()).getPlannedTasks(iterPlan);
		// t1.priority > t2.priority ==> t1.iterationNumber < t2.iterationNumber
		// for every breaking this rule, give a -1
		int violations = 0;
		for (PlannedTask pt1 : plannedTasks) {
			for (PlannedTask pt2 : plannedTasks) {
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
	public double getOverallScore(double expertiseScore, double taskPriorityScore, double devLoadScore) {

		// max value would be (1.0 * 1.0 + 1.0 * 1.0 + 1.0 * 1.0) = 3.0
		return (expertiseScore * getEvaluationParameters().getExpertiesWeight() + taskPriorityScore
			* getEvaluationParameters().getPriorityWeight() + devLoadScore
			* getEvaluationParameters().getDeveloperLoadWeight()) / 3.0;
	}
}
