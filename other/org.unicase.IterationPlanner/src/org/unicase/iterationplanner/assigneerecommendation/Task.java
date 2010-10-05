package org.unicase.iterationplanner.assigneerecommendation;

import org.unicase.model.task.Checkable;
import org.unicase.model.task.WorkItem;

public class Task {
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
}
