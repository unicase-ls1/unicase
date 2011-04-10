package org.unicase.iterationplanner.planner.selectionstrategies;

import java.util.List;
import java.util.Random;

import org.unicase.iterationplanner.planner.ISelectionStrategy;
import org.unicase.iterationplanner.planner.PlannerUtil;
import org.unicase.iterationplanner.planner.impl.shiftdownplanner.ShiftDownIterationPlan;

public class RankBasedSelectionStrategy implements ISelectionStrategy {

	private Random random; 
	
	
	public RankBasedSelectionStrategy(Random random) {
		this.random = random;
	}

	public List<ShiftDownIterationPlan> selectForCloning(List<ShiftDownIterationPlan> population, int percentOfCloneCandidates) {
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
	public List<ShiftDownIterationPlan> selectForCrossover(List<ShiftDownIterationPlan> population, int percentOfCrossOverParents) {
		//return PlannerUtil.getInstance(getRandom()).selectRandomElementsFromList(population, percentOfCrossOverParents);
		return PlannerUtil.getInstance(getRandom()).selectFirstElementsFromSortedList(population, percentOfCrossOverParents);
	}

	public List<ShiftDownIterationPlan> selectForMutation(List<ShiftDownIterationPlan> population, int percentOfMutationsCandidates) {
		//return PlannerUtil.getInstance(getRandom()).selectRandomElementsFromList(population, percentOfMutationsCandidates);
		return PlannerUtil.getInstance(getRandom()).selectFirstElementsFromSortedList(population, percentOfMutationsCandidates);
	}

}
