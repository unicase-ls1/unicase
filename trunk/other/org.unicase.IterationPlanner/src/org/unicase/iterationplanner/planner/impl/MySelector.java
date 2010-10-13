package org.unicase.iterationplanner.planner.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.unicase.iterationplanner.planner.IterationPlan;
import org.unicase.iterationplanner.planner.Selector;

public class MySelector extends Selector {

	public MySelector(Random random) {
		super(random);
	}

	@Override
	public List<IterationPlan> selectForCloning(List<IterationPlan> population, int percentOfCloneCandidates) {
		return selectRandomElementsFromList(population, percentOfCloneCandidates);
	}

	/**
	 * population is sorted.
	 * 
	 * @see org.unicase.iterationplanner.planner.Selector#selectForCrossover(java.util.List, int)
	 */
	@Override
	public List<IterationPlan> selectForCrossover(List<IterationPlan> population, int percentOfCrossOverParents) {
		return selectRandomElementsFromList(population, percentOfCrossOverParents);
	}

	@Override
	public List<IterationPlan> selectForMutation(List<IterationPlan> population, int percentOfMutationsCandidates) {
		return selectRandomElementsFromList(population, percentOfMutationsCandidates);
	}

	private List<IterationPlan> selectRandomElementsFromList(List<IterationPlan> list, int percentOfReturnElements) {
		List<IterationPlan> result = new ArrayList<IterationPlan>();
		Random random = getRandom();
		int numOfElements = (int) ((percentOfReturnElements / 100.0) * list.size());
		for (int i = 0; i < numOfElements; i++) {
			IterationPlan parent = list.get(random.nextInt(list.size()));
			result.add(parent);
		}
		return result;

	}

}
