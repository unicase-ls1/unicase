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
package org.eclipse.emf.emfstore.client.model.util;

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.emf.emfstore.client.model.ProjectSpace;

/**
 * Class that enables to decorate a {@link ProjectSpace} with a task
 * that gets executed periodically.
 * 
 * @author emueller
 * 
 */
public abstract class PeriodicProjectSpaceTask extends TimerTask {

	public static final int DEFAULT_INTERVAL = 900000; // 15 minutes

	private ProjectSpace projectSpace;
	private long interval;
	private Timer timer;
	private boolean isStarted;

	/**
	 * Constructor.
	 * 
	 * @param projectSpace
	 *            the {@link ProjectSpace} that should get decorated
	 * @param interval
	 *            the periodic interval in which the task gets executed
	 */
	public PeriodicProjectSpaceTask(ProjectSpace projectSpace, long interval) {
		this.projectSpace = projectSpace;
		this.interval = interval;
		this.timer = new Timer();
	}

	/**
	 * Starts the task.
	 */
	public void start() {
		if (!isStarted) {
			timer.schedule(this, getInterval(), getInterval());
			isStarted = true;
		}
	}

	/**
	 * Stops the task. If once stopped, continuation is not possible
	 * 
	 * @throws
	 */
	public void stop() {
		timer.cancel();
	}

	/**
	 * Returns the decorated {@link ProjectSpace}.
	 * 
	 * @return the project space
	 */
	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}

	/**
	 * Returns the interval in which the task is executed.
	 * 
	 * @return the interval
	 */
	public long getInterval() {
		return interval;
	}
}
