/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.prefs;

import java.util.HashMap;

/**
 * The default settings for the dashboard.
 * 
 * @author Shterev
 */
public final class DashboardDefaultPreferences {

	/**
	 * The keys for the dashboard preferences.
	 * 
	 * @author Shterev
	 */
	public enum DashboardPreferenceKey {

		/**
		 * The max. number of notifications to be shown on the dashboard.
		 */
		NOTIFICATION_SIZE

	}

	/**
	 * the singleton instance.
	 */
	public static final DashboardDefaultPreferences INSTANCE = new DashboardDefaultPreferences();

	private static HashMap<DashboardPreferenceKey, String> map;

	private DashboardDefaultPreferences() {
		map = new HashMap<DashboardPreferenceKey, String>();

		map.put(DashboardPreferenceKey.NOTIFICATION_SIZE, "1");
	}

	/**
	 * @param key the key
	 * @return the default property for this key of null if not existing.
	 */
	public static String get(DashboardPreferenceKey key) {
		return map.get(key);
	}

}
