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

	public List<Task> getTasksToPlan() {
		return tasks;
	}

	/**
	 * all done tasks in project done tasks are those that are resolved or checked
	 * 
	 * @return
	 */
	private List<Task> getAllDoneTasks() {
		return null;
	}

	/**
	 * get related tasks (using all done tasks, predecessors, successors, requirements, refining requirements, refined
	 * requirements) this is used for Model Based Assignee Recommendation
	 * 
	 * @return
	 */
	public List<Task> getRelatedTasks(Task task) {
		getAllDoneTasks();
		return null;
	}

}
