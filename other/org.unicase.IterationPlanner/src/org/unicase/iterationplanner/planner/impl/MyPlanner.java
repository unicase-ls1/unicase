package org.unicase.iterationplanner.planner.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.unicase.iterationplanner.assigneerecommendation.TaskPotentialAssigneeList;
import org.unicase.iterationplanner.planner.AssigneeAvailability;
import org.unicase.iterationplanner.planner.Evaluator;
import org.unicase.iterationplanner.planner.Iteration;
import org.unicase.iterationplanner.planner.IterationPlan;
import org.unicase.iterationplanner.planner.PlannedTask;
import org.unicase.iterationplanner.planner.Planner;
import org.unicase.iterationplanner.planner.PlannerParameters;
import org.unicase.iterationplanner.planner.Selector;

public class MyPlanner extends Planner {

	public MyPlanner(int numOfIterations, List<TaskPotentialAssigneeList> taskPotentialAssigneeLists,
		Map<Integer, List<AssigneeAvailability>> assigneeAvailabilities, Evaluator iterationPlanEvaluator,
		Selector selector, PlannerParameters plannerParameters) {
		super(numOfIterations, taskPotentialAssigneeLists, assigneeAvailabilities, iterationPlanEvaluator, selector,
			plannerParameters);
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
		IterationPlan iterPlan = new IterationPlan(getNumOfIterations(), new ArrayList<TaskPotentialAssigneeList>(
			getTaskPotentialAssigneeLists()));

		// init iterations
		for (int i = 0; i < iterPlan.getNumOfIterations(); i++) {
			iterPlan.getIterations()[i] = new Iteration(new Integer(i));
		}

		while (iterPlan.getTasksToPlan().size() > 0) {
			// pick an unplanned task from iteration plan
			TaskPotentialAssigneeList taskPotentialAssigneeList = iterPlan.getTasksToPlan().get(
				random.nextInt(iterPlan.getTasksToPlan().size()));

			// set its assignee and put it into an iteration
			PlannedTask plannedTask = new PlannedTask(taskPotentialAssigneeList.getTask());
			plannedTask.setAssigneeExpertise(taskPotentialAssigneeList.getRecommendedAssignees().get(
				random.nextInt(taskPotentialAssigneeList.getRecommendedAssignees().size())));
			int iterationNumber = random.nextInt(iterPlan.getNumOfIterations());
			plannedTask.setIterationNumber(iterationNumber);
			iterPlan.getIterations()[iterationNumber].getPlannedTasks().add(plannedTask);

			// remove it from task to plan, and put in planned tasks.
			iterPlan.getTasksToPlan().remove(taskPotentialAssigneeList);
			iterPlan.getPlannedTasks().add(plannedTask);
		}

		return iterPlan;
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
		// for now just return a clone of the element
		return mutationCandidate.clone();
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
