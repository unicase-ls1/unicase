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
package org.eclipse.emf.emfstore.server.core;

import java.util.HashMap;

/**
 * Holds the monitor objects for synchronizing the access on the serverspace. It's implemented as a singleton.
 * 
 * @author wesendon
 */
public final class MonitorProvider {

	private static final String MAIN_MONITOR = "mainMonitor";
	private static MonitorProvider instance;
	private Object monitor;
	private HashMap<String, Object> monitors;

	private MonitorProvider() {
		monitors = new HashMap<String, Object>();
		monitor = new Object();
		monitors.put(MAIN_MONITOR, monitor);
	}

	/**
	 * Returns the instance of this singleton.
	 * 
	 * @return the instance
	 */
	public static MonitorProvider getInstance() {
		if (instance == null) {
			instance = new MonitorProvider();
		}
		return instance;
	}

	/**
	 * Returns the main monitor objects.
	 * 
	 * @return the monitor
	 */
	public synchronized Object getMonitor() {
		return monitor;
	}

	/**
	 * Returns a monitor for a given namespace.
	 * 
	 * @param namespace namespace.
	 * @return monitor object
	 */
	public synchronized Object getMonitor(String namespace) {
		if (!monitors.containsKey(namespace)) {
			monitors.put(namespace, new Object());
		}
		return monitors.get(namespace);
	}

	/**
	 * Removes a monitor of a certain namespace.
	 * 
	 * @param namespace the namespace
	 * @return true if it was deleted, false if it didn't exist anyway or if it's the main monitor, which can't be
	 *         deleted.
	 */
	public synchronized boolean removeMonitor(String namespace) {
		// can't remove main monitor!
		if (namespace.endsWith(MAIN_MONITOR)) {
			return false;
		} else {
			return (monitors.remove(namespace) != null);
		}
	}
}
