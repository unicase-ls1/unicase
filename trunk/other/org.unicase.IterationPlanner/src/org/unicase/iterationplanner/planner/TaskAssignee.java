package org.unicase.iterationplanner.planner;

import org.unicase.iterationplanner.assigneerecommendation.AssigneeExpertise;
import org.unicase.iterationplanner.assigneerecommendation.Task;

/**
 * This represents a task along with the assignee chosen by planner algorithm to do this task. The assignee is actually
 * an instance of AssigneeExperties, to experss its qualification for doing this task. The expertise will then be used
 * to evaluate IterationPlans.
 * 
 * @author zardosht
 */
public class TaskAssignee {
	private final Task task;
	private AssigneeExpertise assignee;

	public TaskAssignee(Task task) {
		this.task = task;
	}

	@Override
	public TaskAssignee clone() {
		TaskAssignee clone = new TaskAssignee(this.task);
		clone.setAssignee(this.assignee);
		return clone;
	}

	public Task getTask() {
		return task;
	}

	public void setAssignee(AssigneeExpertise assignee) {
		this.assignee = assignee;
	}

	public AssigneeExpertise getAssignee() {
		return assignee;
	}

}
