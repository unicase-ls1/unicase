package org.unicase.iterationplanner.planner;

import java.util.List;

public interface Selector {

	List<IterationPlan> selectForCrossover(final List<IterationPlan> population, int percentOfCrossOverParents);

	List<IterationPlan> selectForMutation(final List<IterationPlan> population, int percentOfMutationsCandidates);

	List<IterationPlan> selectForCloning(final List<IterationPlan> population, int percentOfCloneCandidates);
}
