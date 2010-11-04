package org.unicase.iterationplanner.planner.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
		IterationPlan iterPlan = new IterationPlan(getNumOfIterations(), getTaskPotentialAssigneeListMap().keySet().size(), getAssigneeAvailabilityManager());

		for (Task taskToPlan : getTaskPotentialAssigneeListMap().keySet()) {
			// set assignee and put it into an iteration
			PlannedTask plannedTask = new PlannedTask(taskToPlan);
			// we must first add this task to planned tasks, so that it is considered for computing total estimate for
			// an assignee in an iteration
			iterPlan.addPlannedTask(plannedTask);
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

		//crossover returns two children, therefore numOfChildren/2
		for (int i = 0; i < numOfChildren / 2; i++) {
			IterationPlan parent1 = parentCandidates.get(random.nextInt(parentCandidates.size()));
			IterationPlan parent2 = parentCandidates.get(random.nextInt(parentCandidates.size()));
			List<IterationPlan> children = crossover(parent1, parent2);
			nextGeneration.addAll(children);
		}
	}

	/*
	 * P1 x P2 ==> C1 & C2 
	 * 1. merge first iteration of both parents and set it as first iteration (I1) of both children. Obviously task 
	 * that are common in first iteration of parents will not be duplicated.
	 * 2. in children go through task in I1 and for each of them remove it from other iteration or backlog if
	 * you find a duplicate of it there. 
	 * 3. run the Invariant correction on both C1 & C2 (i.e. shift down low priority tasks, until invariant is held).
	 * 
	 *  
	 * @param parent1
	 * @param parent2
	 * @return 2 children
	 */
	private List<IterationPlan> crossover(IterationPlan p1, IterationPlan p2) {
		List<IterationPlan> children = new ArrayList<IterationPlan>();
		
		Set<PlannedTask> tasksInP1I0 = new HashSet<PlannedTask>(); 
		tasksInP1I0.addAll(p1.getAllPlannedTasksForIteration(0));
		Set<PlannedTask> allTasksInP1 = new HashSet<PlannedTask>(); 
		allTasksInP1.addAll(PlannerUtil.getInstance(getPlannerParameters().getRandom()).getPlannedTasks(p1));
		
		Set<PlannedTask> tasksInP2I0 = new HashSet<PlannedTask>(); 
		tasksInP2I0.addAll(p2.getAllPlannedTasksForIteration(0));
		Set<PlannedTask> allTasksInP2 = new HashSet<PlannedTask>(); 
		allTasksInP2.addAll(PlannerUtil.getInstance(getPlannerParameters().getRandom()).getPlannedTasks(p2));
		
		Set<PlannedTask> tasksForI0 = new HashSet<PlannedTask>();
		tasksForI0.addAll(tasksInP1I0);
		tasksForI0.addAll(tasksInP2I0);

		IterationPlan c1 = new IterationPlan(p1.getNumOfIterations(), getTaskPotentialAssigneeListMap().keySet().size(), getAssigneeAvailabilityManager());
		IterationPlan c2 = new IterationPlan(p1.getNumOfIterations(), getTaskPotentialAssigneeListMap().keySet().size(), getAssigneeAvailabilityManager());
		c1.setCrossover(true);
		c2.setCrossover(true);
		c1.addAll(tasksForI0);
		c2.addAll(tasksForI0);
		
		//remove from all tasks of p1 and p2 those that are in tasksForI0. 
		//then add all remaining tasks of p1 to c1 and p2 to c2.
		//Because tasksForI0 is union of I0 of both parents and we don't want these to be other iterations in children.
		allTasksInP1.removeAll(tasksForI0);
		allTasksInP2.removeAll(tasksForI0);
		c1.addAll(allTasksInP1);
		c2.addAll(allTasksInP2);
		
		c1.setCrossover(false);
		c2.setCrossover(false);
		
		children.add(c1);
		children.add(c2);
		return children;
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
		// 1. well question is, for how many tasks should we do these changes?
		// 2. another question is, how to choose the tasks to mutate? random?
		// Answers:
		// 1. it will be set as a planner parameter (e.g. 10 %)
		// 2. I choose them from high priority tasks in backlog. If backlog does not have enough tasks, 
		//    then no problem. Choose as long as this 10% are in backlog, or backlog does not have any tasks 
		
		IterationPlan mutantIterationPlan = mutationCandidate.clone();
		int percentOfTasksToMutate = getPlannerParameters().getPercentOfTasksToMutate();

		Collection<PlannedTask> tasksToMutate = selectTasksToMutate(mutantIterationPlan, percentOfTasksToMutate);
		
		for (PlannedTask taskToMutate : tasksToMutate) {
			List<AssigneeExpertise> potentialAssignees = getTaskPotentialAssigneeListMap().get(taskToMutate.getTask());
			AssigneeExpertise assigneeExpertise = findAssignee(potentialAssignees);
			int iterationNumber = PlannerUtil.getInstance(getPlannerParameters().getRandom())
				.getIterationNumberProbabilistic(taskToMutate.getTask(), getNumOfIterations());
			mutantIterationPlan.setIterationNumberFor(taskToMutate, iterationNumber);
			mutantIterationPlan.setAssigneeFor(taskToMutate, assigneeExpertise);
		}

		return mutantIterationPlan;
	}


	private Collection<PlannedTask> selectTasksToMutate(IterationPlan mutantIterationPlan, int percentOfTasksToMutate) {
		Set<PlannedTask> allPlannedTasksInMutantIterationPlan = PlannerUtil.getInstance(getPlannerParameters().getRandom()).getPlannedTasks(mutantIterationPlan);
		int numOfTasksToMutate = (int) ((percentOfTasksToMutate / 100.0) * allPlannedTasksInMutantIterationPlan.size());
		Set<PlannedTask> allPlannedTasksForBacklog = mutantIterationPlan.getAllPlannedTasksForIteration(mutantIterationPlan.getBacklogNumber());
		List<PlannedTask> result = new ArrayList<PlannedTask>();
		for(int i = 0; i < numOfTasksToMutate; i++){
			if(allPlannedTasksForBacklog.size() == 0){
				return result;
			}
			if(result.size() == allPlannedTasksForBacklog.size()){
				return result;
			}
			PlannedTask highestPrioTask = selectHighestPrioTask(allPlannedTasksForBacklog);
			result.add(highestPrioTask);
			allPlannedTasksForBacklog.remove(highestPrioTask);
		}
		return result;
	}

	private PlannedTask selectHighestPrioTask(Set<PlannedTask> allPlannedTasks) {
		PlannedTask result = allPlannedTasks.toArray(new PlannedTask[allPlannedTasks.size()])[0];
		for(PlannedTask pt : allPlannedTasks){
			if(pt.getTask().getPriority() > result.getTask().getPriority()){
				result = pt;
			}
		}
		
		return result;
	}

	@Override
	protected void trimNextGeneration(List<IterationPlan> nextGeneration) {
		//for now just delete some poor random individuals
		int populationSize = getPlannerParameters().getPopulationSize();
		Random random = getPlannerParameters().getRandom();
		while (populationSize < nextGeneration.size()) {
			int currentSize = nextGeneration.size();
			nextGeneration.remove(random.nextInt(currentSize));
		}
	}
}