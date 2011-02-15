package org.unicase.iterationplanner.planner;

import java.util.List;
import java.util.Random;

import org.unicase.iterationplanner.planner.impl.IterationPlan;

public abstract class Selector {

	private final Random random;

	public Selector(Random random) {
		this.random = random;
	}

	protected abstract List<IterationPlan> selectForCrossover(final List<IterationPlan> population,
		int percentOfCrossOverParents);

	protected abstract List<IterationPlan> selectForMutation(final List<IterationPlan> population,
		int percentOfMutationsCandidates);

	protected abstract List<IterationPlan> selectForCloning(final List<IterationPlan> population,
		int percentOfCloneCandidates);

	public Random getRandom() {
		return random;
	}
}
