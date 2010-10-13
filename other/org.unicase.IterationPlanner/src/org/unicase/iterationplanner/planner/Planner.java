package org.unicase.iterationplanner.planner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.unicase.iterationplanner.assigneerecommendation.TaskPotentialAssigneeList;

public abstract class Planner {

	private final int numOfIterations;
	private final List<TaskPotentialAssigneeList> taskPotentialAssigneeLists;
	private final Map<Integer, List<AssigneeAvailability>> assigneeAvailabilities;
	private final Evaluator evaluator;
	private final Selector selector;
	private final PlannerParameters plannerParameters;
	private List<IterationPlan> population;

	/**
	 * @param numOfIterations
	 * @param taskAssignees
	 * @param assigneeAvailabilities
	 * @param iterationPlanEvaluator
	 * @param selector
	 * @param plannerParameters
	 */
	public Planner(int numOfIterations, List<TaskPotentialAssigneeList> taskPotentialAssigneeLists,
		Map<Integer, List<AssigneeAvailability>> assigneeAvailabilities, Evaluator iterationPlanEvaluator,
		Selector selector, PlannerParameters plannerParameters) {
		this.numOfIterations = numOfIterations;
		this.taskPotentialAssigneeLists = taskPotentialAssigneeLists;
		this.assigneeAvailabilities = assigneeAvailabilities;
		this.evaluator = iterationPlanEvaluator;
		this.selector = selector;
		this.plannerParameters = plannerParameters;

	}

	/**
	 * implementation of genetic algorithm.
	 * 
	 * @return
	 */
	public List<IterationPlan> start() {

		createInitialPopulation();
		evalutate();
		Collections.sort(population);

		for (int i = 0; i < plannerParameters.getMaxNumOfGenerations(); i++) {
			if (isBreakCretieriaMet()) {
				break;
			}
			createNextGeneration();
			evalutate();
			Collections.sort(population);

		}

		List<IterationPlan> result = new ArrayList<IterationPlan>();
		result.addAll(population.subList(0, plannerParameters.getResultSize() - 1));

		return result;
	}

	/**
	 * if other creteria is met, and we don't need to go further with the run.
	 * 
	 * @return
	 */
	protected abstract boolean isBreakCretieriaMet();

	private void createNextGeneration() {
		List<IterationPlan> nextGeneration = new ArrayList<IterationPlan>();

		List<IterationPlan> crossoverParents = selector.selectForCrossover(population, plannerParameters
			.getPercentOfCrossOverParents());
		List<IterationPlan> mutationCandidates = selector.selectForMutation(population, plannerParameters
			.getPercentOfMutationCandidates());
		List<IterationPlan> cloneCandidates = selector.selectForCloning(population, plannerParameters
			.getPercentOfCloneCandidates());

		crossoverInto(nextGeneration, crossoverParents);
		mutateInto(nextGeneration, mutationCandidates);
		copyInto(nextGeneration, cloneCandidates);

		if (nextGeneration.size() < plannerParameters.getPopulationSize()) {
			completeNextGeneration(nextGeneration);
		} else if (nextGeneration.size() > plannerParameters.getPopulationSize()) {
			trimNextGeneration(nextGeneration);
		}

		population.clear();
		population.addAll(nextGeneration);

	}

	protected abstract void trimNextGeneration(List<IterationPlan> nextGeneration);

	protected abstract void completeNextGeneration(List<IterationPlan> nextGeneration);

	protected abstract void copyInto(List<IterationPlan> nextGeneration, List<IterationPlan> cloneCandidates);

	protected abstract void mutateInto(List<IterationPlan> nextGeneration, List<IterationPlan> mutationCandidates);

	protected abstract void crossoverInto(List<IterationPlan> nextGeneration, List<IterationPlan> parentCandidates);

	/**
	 * evaluate each iteration plan in population, and give it a score; so that population can be sorted.
	 */
	private void evalutate() {
		for (IterationPlan iterationPlan : population) {
			double score = evaluator.evaluate(iterationPlan);
			iterationPlan.setScore(score);
		}
	}

	protected abstract void createInitialPopulation();

	public int getNumOfIterations() {
		return numOfIterations;
	}

	public Map<Integer, List<AssigneeAvailability>> getAssigneeAvailabilities() {
		return assigneeAvailabilities;
	}

	public Evaluator getIterationPlanEvaluator() {
		return evaluator;
	}

	public PlannerParameters getPlannerParameters() {
		return plannerParameters;
	}

	public Selector getSelector() {
		return selector;
	}

	protected List<TaskPotentialAssigneeList> getTaskPotentialAssigneeLists() {
		return taskPotentialAssigneeLists;
	}

}
