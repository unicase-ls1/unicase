package org.unicase.iterationplanner.assigneerecommendation;

import java.util.List;

public class TaskPool {

	private static TaskPool instance;
	private List<Task> tasks;

	public static TaskPool getInstance() {
		if (instance == null) {
			instance = new TaskPool();
		}
		return instance;
	}

	private TaskPool() {
		initTaskPool();
	}

	private void initTaskPool() {

	}

	public List<Task> getTasks() {
		return tasks;
	}

}
