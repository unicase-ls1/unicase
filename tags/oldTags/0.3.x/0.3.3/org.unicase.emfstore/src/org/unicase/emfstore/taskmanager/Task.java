package org.unicase.emfstore.taskmanager;

import java.util.Date;

/**
 * Tasks are managed by the Taskmanager and are used to run certain tasks
 * periodically.
 * 
 * @author wesendonk
 */
public abstract class Task {

	private Date executionTime;

	private long period;

	/**
	 * Default constructor.
	 * 
	 * @param executionTime date
	 * @param period in ms, has to bigger than 0 to be cyclic
	 */
	public Task(Date executionTime, long period) {
		this.executionTime = executionTime;
		this.period = period;
	}

	/**
	 * Returns the time when the task shall be executed.
	 * 
	 * @return next execution date
	 */
	public Date getNextRun() {
		return executionTime;
	}

	/**
	 * This method executes the task and is called by the {@link TaskManager}.
	 * If you want to run this task manually use {@link #executeTask()}.
	 * 
	 * After execution the next run is calculated if the task is repetitive. In
	 * this case the method returns <code>true</code> and the
	 * {@link TaskManager} will keep the task in the queue.
	 * 
	 * Notice: If the next executionTime isn't updated the task will remain at
	 * the beginng in the queue and blocks other tasks this should be avoided.
	 * 
	 * @return true if task will be executed again
	 */
	protected boolean runTask() {
		executeTask();
		return calculateNextRun();
	}

	private boolean calculateNextRun() {
		if (period > 0) {
			executionTime.setTime(executionTime.getTime() + period);
			return true;
		}
		return false;
	}

	/**
	 * Runs the task.
	 */
	public abstract void executeTask();
}
