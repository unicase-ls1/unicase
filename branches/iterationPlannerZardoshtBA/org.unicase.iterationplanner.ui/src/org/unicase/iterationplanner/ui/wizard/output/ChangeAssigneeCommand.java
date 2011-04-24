package org.unicase.iterationplanner.ui.wizard.output;

import org.unicase.iterationplanner.assigneeRecommender.AssigneeExpertise;
import org.unicase.iterationplanner.planner.IIterationPlan;
import org.unicase.iterationplanner.planner.IPlannedTask;

public class ChangeAssigneeCommand extends AbstractChangeIterationPlanCommand {

	private final AssigneeExpertise newAssignee;
	private final AssigneeExpertise oldAssignee;
	private final IIterationPlan iterationPlan;

	public ChangeAssigneeCommand(IPlannedTask pt, AssigneeExpertise newAssignee2, AssigneeExpertise oldAssignee,
		IIterationPlan iterationPlan) {
		super(pt);
		this.newAssignee = newAssignee2;
		this.oldAssignee = oldAssignee;
		this.iterationPlan = iterationPlan;
		
	}

	@Override
	public void redo() {
		IPlannedTask pt = getPlannedTask();
		iterationPlan.setAssigneeFor(pt, newAssignee);
	}

	@Override
	public void undo() {
		IPlannedTask pt = getPlannedTask();
		iterationPlan.setAssigneeFor(pt, oldAssignee);
	}

}
