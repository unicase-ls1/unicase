package org.unicase.iterationplanner.planner.selectionstrategies;

import java.util.List;
import java.util.Random;

import org.unicase.iterationplanner.planner.IIterationPlan;
import org.unicase.iterationplanner.planner.ISelectionStrategy;
import org.unicase.iterationplanner.planner.PlannerUtil;

public class RandomSelectionStrategy implements ISelectionStrategy {

	private Random random; 
	
	
	public RandomSelectionStrategy(Random random) {
		this.random = random;
	}

	public List<IIterationPlan> selectForCloning(List<IIterationPlan> population, int percentOfCloneCandidates) {
		return PlannerUtil.getInstance(getRandom()).selectRandomElementsFromList(population, percentOfCloneCandidates);
	}

	private Random getRandom() {
		return random;
	}

	/**
	 * population is sorted.
	 * 
	 * @see org.unicase.iterationplanner.planner.ISelectionStrategy#selectForCrossover(java.util.List, int)
	 */
	public List<IIterationPlan> selectForCrossover(List<IIterationPlan> population, int percentOfCrossOverParents) {
		return PlannerUtil.getInstance(getRandom()).selectRandomElementsFromList(population, percentOfCrossOverParents);
	}

	public List<IIterationPlan> selectForMutation(List<IIterationPlan> population, int percentOfMutationsCandidates) {
		return PlannerUtil.getInstance(getRandom()).selectRandomElementsFromList(population, percentOfMutationsCandidates);
	}

}
