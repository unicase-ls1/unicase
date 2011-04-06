/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.taskmanager;

import java.util.Date;

import org.eclipse.emf.emfstore.common.model.util.ModelUtil;

/**
 * Tasks are managed by the Taskmanager and are used to run certain tasks periodically.
 * 
 * @author wesendonk
 */
public abstract class Task {

	private Date executionTime;

	private long period;

	/**
	 * Default constructor. Allows to set first execution date and a period, after which it will be repeated.
	 * 
	 * @param executionTime date of first run
	 * @param period time in ms after which the task will be executed again. If the period is 0, the task will only be
	 *            executed once.
	 */
	public Task(Date executionTime, long period) {
		this.executionTime = executionTime;
		this.period = period;
	}

	/**
	 * This constructor is used for tasks, which are supposed to run once only.
	 * 
	 * @param executionTime time execution
	 */
	public Task(Date executionTime) {
		this(executionTime, 0);
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
	 * This method executes the task and is called by the {@link TaskManager}. If you want to run this task manually use
	 * {@link #executeTask()}. After execution the next run is calculated if the task is repetitive. In this case the
	 * method returns <code>true</code> and the {@link TaskManager} will keep the task in the queue. Notice: If the next
	 * executionTime isn't updated the task will remain at the beginng in the queue and blocks other tasks this should
	 * be avoided.
	 * 
	 * @return true if task will be executed again
	 */
	protected boolean runTask() {
		// BEGIN SUPRESS CATCH EXCEPTION
		try {
			executeTask();
		} catch (Exception e) {
			ModelUtil.logException("An exception occurred while executing a server task.", e);
		}
		// END SUPRESS CATCH EXCEPTION
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
