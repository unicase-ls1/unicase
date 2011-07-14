/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.taskmanager;

import java.util.PriorityQueue;

/**
 * Manages tasks which are to be executed at a specific point in time. It's a scheduler working with only one thread, no
 * thread pool.
 * 
 * @author wesendonk
 */
public final class TaskManager extends Thread {

	private static TaskManager instance;

	private PriorityQueue<Task> tasks;

	private static final int MAX_SLEEP = 10000;

	private TaskManager() {
		super("TaskManager");
		tasks = new PriorityQueue<Task>(10, new TaskComparator<Task>());
	}

	/**
	 * Returns an instance of the TaskManager.
	 * 
	 * @return the task manager
	 */
	public static TaskManager getInstance() {
		if (instance == null) {
			instance = new TaskManager();
		}
		return instance;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (!isInterrupted()) {
			try {
				long millis;
				synchronized (this) {
					millis = (tasks.size() == 0) ? MAX_SLEEP : handleTask();
				}
				sleep(millis);
			} catch (InterruptedException e) {
			}
		}
	}

	private long handleTask() {
		Task task = tasks.peek();
		if (task == null) {
			return MAX_SLEEP;
		}
		long time = task.getNextRun().getTime() - System.currentTimeMillis();
		if (time <= 0) {
			// removing and adding the task again is necessary so that the
			// repetitive task with updated executionTiime is sorted in
			// correctly into the task queue.
			task = tasks.poll();
			if (task.runTask()) {
				tasks.add(task);
			}
			// handle nextTask before sleeping
			return handleTask();
		}
		return (time > MAX_SLEEP) ? MAX_SLEEP : time;
	}

	/**
	 * Adds a task to the queue.
	 * 
	 * @param task the task
	 */
	public synchronized void addTask(Task task) {
		tasks.add(task);
	}

	/**
	 * Removes a task from the queue.
	 * 
	 * @param task the task
	 */
	public synchronized void removeTask(Task task) {
		tasks.remove(task);
	}
}
