package org.unicase.iterationplanner.planner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.unicase.iterationplanner.assigneerecommendation.TaskPotentialAssigneeList;

public class Planner {

	private final int numOfIterations;
	private final List<TaskPotentialAssigneeList> taskAssignees;
	private final Map<Integer, List<AssigneeAvailability>> assigneeAvailabilities;
	private Evaluator evaluator;
	private Selector selector;
	private PlannerParameters parameters;
	private List<IterationPlan> population;

	public Planner(int numOfIterations, List<TaskPotentialAssigneeList> taskAssignees,
		Map<Integer, List<AssigneeAvailability>> assigneeAvailabilities, Evaluator iterationPlanEvaluator,
		Selector selector, PlannerParameters parameters) {
		this.numOfIterations = numOfIterations;
		this.taskAssignees = taskAssignees;
		this.assigneeAvailabilities = assigneeAvailabilities;
		this.evaluator = iterationPlanEvaluator;
		this.selector = selector;
		this.setParameters(parameters);

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

		for (int i = 0; i < parameters.getMaxNumOfIterations(); i++) {
			if (isBreakCretieriaMet()) {
				break;
			}
			createNextGeneration();
			evalutate();
			Collections.sort(population);

		}

		List<IterationPlan> result = new ArrayList<IterationPlan>();
		result.addAll(population.subList(0, parameters.getResultSize() - 1));

		return result;
	}

	/**
	 * if other creteria is met, and we don't need to go further with the run.
	 * 
	 * @return
	 */
	private boolean isBreakCretieriaMet() {
		return false;
	}

	private void createNextGeneration() {
		List<IterationPlan> nextGeneration = new ArrayList<IterationPlan>();

		List<IterationPlan> parents = selector
			.selectForCrossover(population, parameters.getPercentOfCrossOverParents());
		List<IterationPlan> mutationCandidates = selector.selectForMutation(population, parameters
			.getPercentOfMutationCandidates());
		List<IterationPlan> clones = selector.selectForCloning(population, parameters.getPercentOfCloneCandidates());

		crosOverInto(nextGeneration, parents);
		mutateInto(nextGeneration, mutationCandidates);
		copyInto(nextGeneration, clones);

		population.clear();
		population.addAll(nextGeneration);

	}

	private void copyInto(List<IterationPlan> nextGeneration, List<IterationPlan> clones) {

	}

	private void mutateInto(List<IterationPlan> nextGeneration, List<IterationPlan> mutationCandidates) {
		// TODO Auto-generated method stub

	}

	private void crosOverInto(List<IterationPlan> nextGeneration, List<IterationPlan> parents) {
		// TODO Auto-generated method stub

	}

	private void evalutate() {
		for (IterationPlan iterationPlan : population) {
			evaluator.evaluate(iterationPlan);
		}
	}

	private void createInitialPopulation() {
		population = new ArrayList<IterationPlan>();
	}

	public int getNumOfIterations() {
		return numOfIterations;
	}

	public List<TaskPotentialAssigneeList> getTaskAssignees() {
		return taskAssignees;
	}

	public Map<Integer, List<AssigneeAvailability>> getAssigneeAvailabilities() {
		return assigneeAvailabilities;
	}

	public void setIterationPlanEvaluator(Evaluator iterationPlanEvaluator) {
		this.evaluator = iterationPlanEvaluator;
	}

	public Evaluator getIterationPlanEvaluator() {
		return evaluator;
	}

	public PlannerParameters getParameters() {
		return parameters;
	}

	public void setParameters(PlannerParameters parameters) {
		this.parameters = parameters;
	}

	public void setSelector(Selector selector) {
		this.selector = selector;
	}

	public Selector getSelector() {
		return selector;
	}

}
