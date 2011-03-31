/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.taskmanager;

import java.util.Comparator;
import java.util.Date;

/**
 * Is needed for the {@link java.utilPriorityQueue} used in the {@link TaskManager}.
 * 
 * @param <T> a task.
 * @author wesendon
 */
public class TaskComparator<T extends Task> implements Comparator<T> {

	/**
	 * {@inheritDoc}
	 */
	public int compare(T task1, T task2) {
		Date nextRun1 = task1.getNextRun();
		Date nextRun2 = task2.getNextRun();
		if (nextRun1.equals(nextRun2)) {
			return 0;
		} else if (nextRun1.before(nextRun2)) {
			return -1;
		} else {
			return 1;
		}
	}

}
