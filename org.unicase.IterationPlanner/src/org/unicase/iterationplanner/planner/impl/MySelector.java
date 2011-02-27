package org.unicase.iterationplanner.planner.impl;

import java.util.List;
import java.util.Random;

import org.unicase.iterationplanner.planner.PlannerUtil;
import org.unicase.iterationplanner.planner.Selector;

public class MySelector extends Selector {

	public MySelector(Random random) {
		super(random);
	}

	@Override
	public List<IterationPlan> selectForCloning(List<IterationPlan> population, int percentOfCloneCandidates) {
		return PlannerUtil.getInstance(getRandom()).selectRandomElementsFromList(population, percentOfCloneCandidates);
	}

	/**
	 * population is sorted.
	 * 
	 * @see org.unicase.iterationplanner.planner.Selector#selectForCrossover(java.util.List, int)
	 */
	@Override
	public List<IterationPlan> selectForCrossover(List<IterationPlan> population, int percentOfCrossOverParents) {
		//return PlannerUtil.getInstance(getRandom()).selectRandomElementsFromList(population, percentOfCrossOverParents);
		return PlannerUtil.getInstance(getRandom()).selectFirstElementsFromSortedList(population, percentOfCrossOverParents);
	}

	@Override
	public List<IterationPlan> selectForMutation(List<IterationPlan> population, int percentOfMutationsCandidates) {
		//return PlannerUtil.getInstance(getRandom()).selectRandomElementsFromList(population, percentOfMutationsCandidates);
		return PlannerUtil.getInstance(getRandom()).selectFirstElementsFromSortedList(population, percentOfMutationsCandidates);
	}

}
