package org.unicase.iterationplanner.ui.wizard.output;

import org.unicase.iterationplanner.planner.IPlannedTask;

public abstract class AbstractChangeIterationPlanCommand {
	
	private IPlannedTask plannedTask;
	
	public IPlannedTask getPlannedTask() {
		return plannedTask;
	}



	public AbstractChangeIterationPlanCommand(IPlannedTask pt){
		this.plannedTask = pt;
	}
	
	
	
	public abstract void undo();
	public abstract void redo();

}
