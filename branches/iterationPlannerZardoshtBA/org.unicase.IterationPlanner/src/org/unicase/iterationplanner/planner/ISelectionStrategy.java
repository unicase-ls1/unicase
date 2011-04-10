package org.unicase.iterationplanner.planner;

import java.util.List;

import org.unicase.iterationplanner.planner.impl.shiftdownplanner.ShiftDownIterationPlan;

public interface ISelectionStrategy {

	List<ShiftDownIterationPlan> selectForCrossover(final List<ShiftDownIterationPlan> population, int percentOfCrossOverParents);

	List<ShiftDownIterationPlan> selectForMutation(final List<ShiftDownIterationPlan> population, int percentOfMutationsCandidates);

	List<ShiftDownIterationPlan> selectForCloning(final List<ShiftDownIterationPlan> population, int percentOfCloneCandidates);

}
