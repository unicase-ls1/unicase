package org.unicase.iterationplanner.planner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.unicase.iterationplanner.entities.AssigneeAvailabilityManager;
import org.unicase.iterationplanner.entities.AssigneeExpertise;
import org.unicase.iterationplanner.entities.IIterationPlan;
import org.unicase.iterationplanner.entities.ITask;
import org.unicase.iterationplanner.entities.PlannerParameters;
import org.unicase.iterationplanner.entities.TaskPotentialAssigneeList;
import org.unicase.iterationplanner.planner.impl.IterationPlan;
import org.unicase.iterationplanner.planner.impl.MyEvaluator;
import org.unicase.iterationplanner.planner.impl.MySelector;

public abstract class Planner {

	private final int numOfIterations;
	private final Map<ITask, List<AssigneeExpertise>> taskPotentialAssigneeListMap;
	private final AssigneeAvailabilityManager assigneeAvailabilityManager;
	private final Evaluator evaluator;
	private final Selector selector;
	private final PlannerParameters plannerParameters;
	private List<IterationPlan> population;
	private List<IterationPlan> nextGeneration;

	/**
	 * @param numOfIterations
	 * @param taskPotentialAssigneeLists
	 * @param assigneeAvailabilities
	 * @param plannerParameters
	 */
	public Planner(int numOfIterations, List<TaskPotentialAssigneeList> taskPotentialAssigneeLists,
		AssigneeAvailabilityManager assigneeAvailabilityManager, PlannerParameters plannerParameters) {
		this.numOfIterations = numOfIterations;
		this.taskPotentialAssigneeListMap = initTaskPotenitalAssigneeListMap(taskPotentialAssigneeLists);
		this.assigneeAvailabilityManager = assigneeAvailabilityManager;
		
		this.evaluator = new MyEvaluator(plannerParameters, assigneeAvailabilityManager);;
		this.selector = new MySelector(plannerParameters.getRandom());
		this.plannerParameters = plannerParameters;

	}

	private Map<ITask, List<AssigneeExpertise>> initTaskPotenitalAssigneeListMap(
		List<TaskPotentialAssigneeList> taskPotentialAssigneeLists) {

		Map<ITask, List<AssigneeExpertise>> result = new HashMap<ITask, List<AssigneeExpertise>>();
		for (TaskPotentialAssigneeList tpal : taskPotentialAssigneeLists) {
			result.put(tpal.getTask(), tpal.getRecommendedAssignees());
		}
		return result;
	}

	/**
	 * implementation of genetic algorithm.
	 * 
	 * @return
	 */
	public List<IIterationPlan> start() {
		
		System.out.println("Starting GA: " + new Date().toString());
		population = createInitialPopulation();
		System.out.println("Initial Population created: " + new Date().toString());
		evalutate();
		Collections.sort(population);
		checkInvariants(population);

		for (int i = 0; i < plannerParameters.getMaxNumOfGenerations(); i++) {
			System.out.println("Started Generation" + i + ": " + new Date().toString());
			if (isBreakCretieriaMet()) {
				break;
			}
			createNextGeneration();
			evalutate();
			Collections.sort(population);
			checkInvariants(population);

			System.out.println("Finished Generation" + i + ": " + new Date().toString());
		}

		List<IIterationPlan> result = new ArrayList<IIterationPlan>();
		result.add(population.get(0));
		for (int i = 1; i < population.size(); i++) {
			if (result.size() == plannerParameters.getResultSize()) {
				return result;
			}
			if (!result.contains(population.get(i))) {
				result.add(population.get(i));
			}
		}
		return result;
	}
	
	protected void addToNextGeneration(IterationPlan iterPlan){
		iterPlan.checkAllInvariants();
		nextGeneration.add(iterPlan);
	}

	private void checkInvariants(List<IterationPlan> iterPlans) {
		for(IterationPlan iterPlan : iterPlans){
			iterPlan.checkAllInvariants();
		}
		
	}

	private void createNextGeneration() {
		nextGeneration = new ArrayList<IterationPlan>();

		List<IterationPlan> crossoverParents = selector.selectForCrossover(population, plannerParameters
			.getPercentOfCrossOverParents());
		List<IterationPlan> mutationCandidates = selector.selectForMutation(population, plannerParameters
			.getPercentOfMutationCandidates());
		List<IterationPlan> cloneCandidates = selector.selectForCloning(population, plannerParameters
			.getPercentOfCloneCandidates());

		copyIntoNextGeneration(cloneCandidates);
		mutateIntoNextGeneration(mutationCandidates);
		crossoverIntoNextGeneration(crossoverParents);

		if (nextGeneration.size() < plannerParameters.getPopulationSize()) {
			completeNextGeneration(nextGeneration);
		} else if (nextGeneration.size() > plannerParameters.getPopulationSize()) {
			trimNextGeneration(nextGeneration);
		}

		population.clear();
		population.addAll(nextGeneration);

	}

	/**
	 * if other creteria is met, and we don't need to go further with the run.
	 * 
	 * @return
	 */
	protected abstract boolean isBreakCretieriaMet();

	protected abstract List<IterationPlan> createInitialPopulation();

	protected abstract void trimNextGeneration(List<IterationPlan> nextGeneration);

	protected abstract void completeNextGeneration(List<IterationPlan> nextGeneration);

	protected abstract void copyIntoNextGeneration(List<IterationPlan> cloneCandidates);

	protected abstract void mutateIntoNextGeneration(List<IterationPlan> mutationCandidates);

	protected abstract void crossoverIntoNextGeneration(List<IterationPlan> parentCandidates);

	/**
	 * evaluate each iteration plan in population, and give it a score; so that population can be sorted.
	 */
	private void evalutate() {
		for (IterationPlan iterationPlan : population) {
			double score = evaluator.evaluate(iterationPlan);
			iterationPlan.setScore(score);
		}
	}

	public int getNumOfIterations() {
		return numOfIterations;
	}

	public AssigneeAvailabilityManager getAssigneeAvailabilityManager() {
		return assigneeAvailabilityManager;
	}

	public Evaluator getEvaluator() {
		return evaluator;
	}

	public PlannerParameters getPlannerParameters() {
		return plannerParameters;
	}

	public Selector getSelector() {
		return selector;
	}

	public Map<ITask, List<AssigneeExpertise>> getTaskPotentialAssigneeListMap() {
		return taskPotentialAssigneeListMap;
	}

	/**
	 * if all potential assignees for this task have the same expertise value, then this task should not be considered
	 * in evaluation of expertise for an iteration plan.
	 * 
	 * @param taskToPlan
	 * @return
	 */
	protected boolean isEvaluateExperties(ITask taskToPlan) {
		// if all potential assignees for this task have the same expertise value, then this task should not be
		// considered in evaluation of expertise for an iteration plan.
		List<AssigneeExpertise> potentialAssigneeList = taskPotentialAssigneeListMap.get(taskToPlan);
		double firstExpertise = potentialAssigneeList.get(0).getExpertise();
		for (AssigneeExpertise ae : potentialAssigneeList) {
			if (ae.getExpertise() != firstExpertise) {
				return true;
			}
		}
		return false;
	}
}
