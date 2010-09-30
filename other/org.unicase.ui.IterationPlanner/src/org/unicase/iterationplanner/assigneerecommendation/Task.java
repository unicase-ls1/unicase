package org.unicase.iterationplanner.assigneerecommendation;

import org.unicase.model.task.WorkItem;

public class Task {
	private final WorkItem workItem;

	public Task(WorkItem workItem) {
		this.workItem = workItem;
	}

	public WorkItem getWorkItem() {
		return workItem;
	}
}
