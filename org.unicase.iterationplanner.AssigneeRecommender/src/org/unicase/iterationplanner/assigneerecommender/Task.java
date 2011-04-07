package org.unicase.iterationplanner.assigneerecommender;

import org.unicase.iterationplanner.assigneeRecommender.ITask;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.WorkItem;

public class Task implements Comparable<ITask>, ITask {
	
	private final WorkItem workItem;

	public Task(WorkItem workItem) throws Exception {
		if (workItem instanceof Checkable) {
			this.workItem = workItem;
		} else {
			throw new Exception("Task must be an instance of Checkable.");
		}

	}

	public WorkItem getWorkItem() {
		return workItem;
	}

	public int getPriority() {
		return workItem.getPriority();
	}

	public int compareTo(ITask otherTask) {

		return this.getPriority() - otherTask.getPriority();
	}

	public int getEstimate() {
		return workItem.getEstimate();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Task)) {
			return false;
		}

		return ((Task) obj).getWorkItem().equals(this.workItem);
		
	}


	public String getName() {
		return workItem.getName();
	}

	
	
}
