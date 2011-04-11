package org.unicase.iterationplanner.planner;

import java.util.List;

public interface ISelectionStrategy {

	List<IIterationPlan> selectForCrossover(final List<IIterationPlan> population, int percentOfCrossOverParents);

	List<IIterationPlan> selectForMutation(final List<IIterationPlan> population, int percentOfMutationsCandidates);

	List<IIterationPlan> selectForCloning(final List<IIterationPlan> population, int percentOfCloneCandidates);

}
