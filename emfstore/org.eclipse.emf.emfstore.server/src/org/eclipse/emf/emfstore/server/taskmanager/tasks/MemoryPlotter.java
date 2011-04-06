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
package org.eclipse.emf.emfstore.server.taskmanager.tasks;

import java.util.Date;

import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.taskmanager.Task;

/**
 * Dev task which plotts available memory.
 * 
 * @author wesendon
 */
public class MemoryPlotter extends Task {

	/**
	 * Default constructor.
	 * 
	 * @param executionTime first
	 * @param period repeat
	 */
	public MemoryPlotter(Date executionTime, long period) {
		super(executionTime, period);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.taskmanager.Task#executeTask()
	 */
	@Override
	public void executeTask() {
		long freeMemory = Runtime.getRuntime().freeMemory();
		long totalMemory = Runtime.getRuntime().totalMemory();
		long usedMemory = totalMemory - freeMemory;

		ModelUtil.logInfo("Total Memory " + calcByte(totalMemory));
		ModelUtil.logInfo("Used Memory " + calcByte(usedMemory));
		ModelUtil.logInfo("Free Memory " + calcByte(freeMemory) + "\n");

	}

	private static String[] labels = { "B", "KB", "MB", "GB", "TB" };
	private static String seperator = " ";
	private static long boundaryValue = 1024L;

	private String calcByte(long size) {
		if (size <= 0) {
			return null;
		}

		if (size < boundaryValue) {
			return size + seperator + labels[0];
		}

		int power = 1;
		double tmp = size / boundaryValue;
		while (tmp > (boundaryValue - 1)) {
			tmp = tmp / boundaryValue;
			power++;
		}

		if (power < labels.length) {
			return tmp + seperator + labels[power];
		}

		return "" + size;
	}
}
