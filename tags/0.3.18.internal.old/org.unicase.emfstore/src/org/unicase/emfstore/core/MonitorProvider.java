/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.core;

/**
 * Holds the monitor object for synchronizing the access of serverspace. Is implemented as singleton.
 * 
 * @author wesendon
 */
public final class MonitorProvider {

	private static MonitorProvider instance;
	private Object monitor;

	private MonitorProvider() {
		monitor = new Object();
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
	 * Returns the monitor.
	 * 
	 * @return the monitor
	 */
	public Object getMonitor() {
		return monitor;
	}
}
