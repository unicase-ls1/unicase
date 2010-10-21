package org.unicase.iterationplanner.assigneerecommendation;

import org.unicase.model.task.Checkable;
import org.unicase.model.task.WorkItem;

public class Task implements Comparable<Task> {
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

	public int compareTo(Task o) {

		return this.getPriority() - o.getPriority();
	}

	public int getEstimate() {
		return workItem.getEstimate();
	}
}
