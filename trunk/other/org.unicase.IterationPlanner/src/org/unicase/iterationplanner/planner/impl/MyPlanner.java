package org.unicase.iterationplanner.planner.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.unicase.iterationplanner.assigneerecommendation.AssigneeExpertise;
import org.unicase.iterationplanner.assigneerecommendation.Task;
import org.unicase.iterationplanner.assigneerecommendation.TaskPotentialAssigneeList;
import org.unicase.iterationplanner.planner.AssigneeAvailabilityManager;
import org.unicase.iterationplanner.planner.Evaluator;
import org.unicase.iterationplanner.planner.IterationPlan;
import org.unicase.iterationplanner.planner.PlannedTask;
import org.unicase.iterationplanner.planner.Planner;
import org.unicase.iterationplanner.planner.PlannerParameters;
import org.unicase.iterationplanner.planner.Selector;

public class MyPlanner extends Planner {

	public MyPlanner(int numOfIterations, List<TaskPotentialAssigneeList> taskPotentialAssigneeLists,
		AssigneeAvailabilityManager assigneeAvailabilityManager, Evaluator iterationPlanEvaluator, Selector selector,
		PlannerParameters plannerParameters) {
		super(numOfIterations, taskPotentialAssigneeLists, assigneeAvailabilityManager, iterationPlanEvaluator,
			selector, plannerParameters);
	}

	@Override
	protected void completeNextGeneration(List<IterationPlan> nextGeneration) {
		// for now just clone some of individuals
		int numOfIndividualsToAdd = getPlannerParameters().getPopulationSize() - nextGeneration.size();
		Random random = getPlannerParameters().getRandom();
		for (int i = 0; i < numOfIndividualsToAdd; i++) {
			IterationPlan cloneCandidate = nextGeneration.get(random.nextInt(nextGeneration.size()));
			nextGeneration.add(cloneCandidate.clone());
		}
	}

	@Override
	protected void copyInto(List<IterationPlan> nextGeneration, List<IterationPlan> cloneCandidates) {
		Random random = getPlannerParameters().getRandom();
		int numOfClones = (int) ((getPlannerParameters().getPercentOfClones() / 100.0) * getPlannerParameters()
			.getPopulationSize());
		for (int i = 0; i < numOfClones; i++) {
			IterationPlan clone = cloneCandidates.get(random.nextInt(cloneCandidates.size()));
			// we don't need to clone the object here.
			nextGeneration.add(clone);
		}
	}

	@Override
	protected List<IterationPlan> createInitialPopulation() {
		List<IterationPlan> initPopulation = new ArrayList<IterationPlan>();
		int populationSize = getPlannerParameters().getPopulationSize();
		for (int i = 0; i < populationSize; i++) {
			IterationPlan iterPlan = createIterationPlan();
			initPopulation.add(iterPlan);
		}

		return initPopulation;
	}

	private IterationPlan createIterationPlan() {
		Random random = getPlannerParameters().getRandom();
		IterationPlan iterPlan = new IterationPlan(getNumOfIterations(), getAssigneeAvailabilityManager());

		for (Task taskToPlan : getTaskPotentialAssigneeListMap().keySet()) {
			// set assignee and put it into an iteration
			PlannedTask plannedTask = new PlannedTask(taskToPlan);
			// we must first add this task to planned tasks, so that it is considered for computing total estimate for
			// an assignee in an iteration
			iterPlan.getPlannedTasks().add(plannedTask);
			int iterationNumber = PlannerUtil.getInstance(random).getIterationNumberProbabilistic(taskToPlan,
				getNumOfIterations());
			iterPlan.setIterationNumberFor(plannedTask, iterationNumber);

			plannedTask.setEvaluateExperties(isEvaluateExperties(taskToPlan));
			List<AssigneeExpertise> potentialAssignees = getTaskPotentialAssigneeListMap().get(taskToPlan);
			AssigneeExpertise assignee = findAssignee(potentialAssignees);
			iterPlan.setAssigneeFor(plannedTask, assignee);

		}

		return iterPlan;
	}

	private AssigneeExpertise findAssignee(List<AssigneeExpertise> potentialAssignees) {

		return PlannerUtil.getInstance(getPlannerParameters().getRandom()).getAssigneeProbabilistic(potentialAssignees);
	}

	@Override
	protected void crossoverInto(List<IterationPlan> nextGeneration, List<IterationPlan> parentCandidates) {
		// do for numOfChildren
		// get two parents
		// child = crossOver(parent1, parent2);
		// nextGeneration.add(child);
		Random random = getPlannerParameters().getRandom();
		int numOfChildren = (int) ((getPlannerParameters().getPercentOfCrossOverChildren() / 100.0) * getPlannerParameters()
			.getPopulationSize());

		for (int i = 0; i < numOfChildren; i++) {
			IterationPlan parent1 = parentCandidates.get(random.nextInt(parentCandidates.size()));
			IterationPlan parent2 = parentCandidates.get(random.nextInt(parentCandidates.size()));
			IterationPlan child = crossover(parent1, parent2);
			nextGeneration.add(child);
		}
	}

	private IterationPlan crossover(IterationPlan parent1, IterationPlan parent2) {
		// for now just return a clone of one of them
		int nextInt = getPlannerParameters().getRandom().nextInt(2);
		if (nextInt == 0) {
			return parent1.clone();
		} else {
			return parent2.clone();
		}
	}

	@Override
	protected boolean isBreakCretieriaMet() {
		return false;
	}

	@Override
	protected void mutateInto(List<IterationPlan> nextGeneration, List<IterationPlan> mutationCandidates) {
		Random random = getPlannerParameters().getRandom();
		int numOfMutants = (int) ((getPlannerParameters().getPrecentOfMutants() / 100.0) * getPlannerParameters()
			.getPopulationSize());

		for (int i = 0; i < numOfMutants; i++) {
			IterationPlan mutationCandidate = mutationCandidates.get(random.nextInt(mutationCandidates.size()));
			IterationPlan mutant = mutate(mutationCandidate);
			nextGeneration.add(mutant);
		}
	}

	private IterationPlan mutate(IterationPlan mutationCandidate) {
		// mutation possibilities: 1. change iteration of a task, change assignee of a task
		// well question is, for how many tasks should we do these changes?
		// another question is, how to choose the tasks to mutate? random?
		// another question is how to mutate tasks?
		IterationPlan mutantIterationPlan = mutationCandidate.clone();
		int percentOfTasksToMutate = getPlannerParameters().getPercentOfTasksToMutate();

		Collection<PlannedTask> tasksToMutate = PlannerUtil.getInstance(getPlannerParameters().getRandom())
			.selectRandomElementsFromSet(mutationCandidate.getPlannedTasks(), percentOfTasksToMutate);
		mutantIterationPlan.getPlannedTasks().removeAll(tasksToMutate);

		for (PlannedTask taskToMutate : tasksToMutate) {
			PlannedTask mutatedTask = mutateTask(taskToMutate, taskToMutate.getIterationNumber(), mutantIterationPlan);
			mutantIterationPlan.getPlannedTasks().add(mutatedTask);
		}

		return mutantIterationPlan;
	}

	private PlannedTask mutateTask(PlannedTask taskToMutate, int oldIterationNumber, IterationPlan mutantIterationPlan) {
		// mutation possibilities: 1. change iteration of a task, change assignee of a task
		PlannedTask mutatedTask = new PlannedTask(taskToMutate.getTask());
		List<AssigneeExpertise> potentialAssignees = getTaskPotentialAssigneeListMap().get(taskToMutate.getTask());
		// how to select assignee for mutated task? the best? random?
		AssigneeExpertise assigneeExpertise = findAssignee(potentialAssignees);
		int iterationNumber = PlannerUtil.getInstance(getPlannerParameters().getRandom())
			.getIterationNumberProbabilistic(mutatedTask.getTask(), getNumOfIterations());
		mutantIterationPlan.setIterationNumberFor(mutatedTask, iterationNumber);
		mutantIterationPlan.setAssigneeFor(mutatedTask, assigneeExpertise);

		return mutatedTask;
	}

	@Override
	protected void trimNextGeneration(List<IterationPlan> nextGeneration) {
		int populationSize = getPlannerParameters().getPopulationSize();
		Random random = getPlannerParameters().getRandom();
		while (populationSize < nextGeneration.size()) {
			int currentSize = nextGeneration.size();
			nextGeneration.remove(random.nextInt(currentSize));
		}
	}
}
