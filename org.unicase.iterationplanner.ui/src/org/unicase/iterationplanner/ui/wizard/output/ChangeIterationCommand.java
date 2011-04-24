package org.unicase.iterationplanner.ui.wizard.output;

import org.unicase.iterationplanner.planner.IIterationPlan;
import org.unicase.iterationplanner.planner.IPlannedTask;

public class ChangeIterationCommand extends AbstractChangeIterationPlanCommand {


	private final int newIterationNumber;
	private final int oldIterationNumber;
	private final Iteration newIteration;
	private final Iteration oldIteration;
	private final IIterationPlan iterationPlan;

	public int getOldIterationNumber() {
		return oldIterationNumber;
	}

	public int getNewIterationNumber() {
		return newIterationNumber;
	}

	

	public ChangeIterationCommand(IPlannedTask pt, int newIterationNumber2, int oldIterationNumber2,
		Iteration newIteration, Iteration oldIteration, IIterationPlan iterationPlan) {
		super(pt);
		this.newIterationNumber = newIterationNumber2;
		this.oldIterationNumber = oldIterationNumber2;
		this.newIteration = newIteration;
		this.oldIteration = oldIteration;
		this.iterationPlan = iterationPlan;
	}

	@Override
	public void redo() {
		IPlannedTask pt = getPlannedTask();
		newIteration.getPlannedTasks().add(pt);
		oldIteration.getPlannedTasks().remove(pt);
		iterationPlan.setIterationNumberFor(pt, newIterationNumber);
	}

	@Override
	public void undo() {
		IPlannedTask pt = getPlannedTask();
		newIteration.getPlannedTasks().remove(pt);
		oldIteration.getPlannedTasks().add(pt);
		iterationPlan.setIterationNumberFor(pt, oldIterationNumber);
	}

}
