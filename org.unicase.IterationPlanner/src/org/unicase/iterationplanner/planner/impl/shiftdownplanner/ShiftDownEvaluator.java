package org.unicase.iterationplanner.planner.impl.shiftdownplanner;

import java.util.Set;

import org.unicase.iterationplanner.assigneeRecommender.IAssignee;
import org.unicase.iterationplanner.planner.AbstractEvaluationStrategy;
import org.unicase.iterationplanner.planner.AssigneeAvailabilityManager;
import org.unicase.iterationplanner.planner.IIterationPlan;
import org.unicase.iterationplanner.planner.IPlannedTask;
import org.unicase.iterationplanner.planner.PlannerParameters;
import org.unicase.iterationplanner.planner.PlannerUtil;

public class ShiftDownEvaluator extends AbstractEvaluationStrategy {

	public ShiftDownEvaluator(PlannerParameters plannerParams, AssigneeAvailabilityManager assigneeAvailabilityManager) {
		super(plannerParams, assigneeAvailabilityManager);
	}

	@Override
	public double evaluateExpertise(IIterationPlan iterPlan) {
		// avg(all experties)
		double sum = 0.0;
		Set<IPlannedTask> plannedTasks = PlannerUtil.getInstance(getPlannerParameters().getRandom()).getPlannedTasks(iterPlan);
		for (IPlannedTask pt : plannedTasks) {
			if (pt.isEvaluateExpertise()) {
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
	public double evaluateAssigneeLoad(IIterationPlan iterPlan) {
		// for assignee wie viele tasks in iter? sum(estimate for tasks for assignee)
		// compare estimate sum with avail. of dev.
		int numOfIterations = getIterationPlan().getNumOfIterations();
		double sum = 0.0;
		int count = 0;
		for (int i = 0; i < numOfIterations; i++) {
			for (IAssignee assignee : iterPlan.getAssignees()) {
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
	public double evaluteTaskPriorities(IIterationPlan iterPlan) {
		Set<IPlannedTask> plannedTasks = PlannerUtil.getInstance(getPlannerParameters().getRandom()).getPlannedTasks(iterPlan);
		// t1.priority > t2.priority ==> t1.iterationNumber < t2.iterationNumber
		// for every breaking this rule, give a -1
		int violations = 0;
		for (IPlannedTask pt1 : plannedTasks) {
			for (IPlannedTask pt2 : plannedTasks) {
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
		return (expertiseScore * getPlannerParameters().getExpertiseWeight() + taskPriorityScore
			* getPlannerParameters().getPriorityWeight() + devLoadScore
			* getPlannerParameters().getDeveloperLoadWeight()) / 3.0;
	}


}

//
//@Override
//public double evaluateAssigneeLoad(IIterationPlan iterPlan) {
//	// for assignee wie viele tasks in iter? sum(estimate for tasks for assignee)
//	// compare estimate sum with avail. of dev.
//	int numOfIterations = getIterationPlan().getNumOfIterations();
//	double sum = 0.0;
//	int count = 0;
//	for (int i = 0; i < numOfIterations; i++) {
//		for (IAssignee assignee : iterPlan.getAssignees()) {
//			// get an average for on all scores for all assignees in all iterations. (normalize: 1.0 *
//			// numOfIterations * numOfAssignees)
//			// iteration, assignee
//			// getEstimateForAssignee(iteration, assignee)
//			// compare estimateForAssignee with assigneeAvailability
//			// if(estimate > avail.) ==> return score 0 //just one violation (violation in one iteration) is enough
//			// to get you out
//			// else score = estimate / availability
//			// sum += score
//			int estimateForAssigneeInIteration = iterPlan.getSumOfEstimateForIterationAndAssignee(i, assignee);
//			int availability = getAssigneeAvailabilityManager().getAvailability(i, assignee);
//			if (estimateForAssigneeInIteration > availability) {
//				System.out.println("dev load delta: " + (availability - estimateForAssigneeInIteration));
//				return 0.0;
//			} else {
//				double scoreForAssigneeInIteration = (double) estimateForAssigneeInIteration
//					/ (double) availability;
//				sum += scoreForAssigneeInIteration;
//			}
//			count++;
//		}
//	}
//
//	double avg = sum / count;
//	// avg is already between 0 and 1. Because max scoreForAssigneeInIteration is 1.0, then the
//	// highest possible value of sum would be 1.0 * count
//	return avg;
//}






//
//
//
//
//@Override
//public double evaluateAssigneeLoad(IIterationPlan iterPlan) {
//	//for each assignee a get its workload, compare it with its availability
//	//if (workload(a) > availability(a)), give a -1 penalty
//	
//	Set<IAssignee> assignees = iterPlan.getAssignees();
//	int violations = 0;
//	for(int i = 0; i < iterPlan.getNumOfIterations(); i++){
//		for(IAssignee assignee : assignees){
//			int workload = iterPlan.getSumOfEstimateForIterationAndAssignee(i, assignee);
//			int availability = getAssigneeAvailabilityManager().getAvailability(i, assignee);
//			if(workload > availability){
//				violations ++;
//			}
//			
//		}
//	}
//	// normalize.
//	return violations == 0 ? 1.0 : 1 / (double) violations;
//}