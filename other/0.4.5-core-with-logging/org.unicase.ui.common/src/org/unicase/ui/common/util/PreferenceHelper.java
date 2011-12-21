/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.common.util;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.osgi.service.prefs.BackingStoreException;
import org.unicase.metamodel.util.ModelUtil;

/**
 * The preference helper aids storing {key, value} pairs.
 * 
 * @author pfeifferc
 *
 */
public final class PreferenceHelper {


	private static final String PREFERENCE_NODE = "ecp";

	/**
	 * Get a preference value for a specific key.
	 * 
	 * @param key the
	 * @param defaultValue the
	 * @return the value if it exists, otherwise the defaultValue
	 */
	public static String getPreference(String key, String defaultValue) {
		String value = Platform.getPreferencesService().getRootNode().node(ConfigurationScope.SCOPE).node(PREFERENCE_NODE).get(key, defaultValue);
		return value;
	}

	/**
	 * Set the preference value for a specific key. Key and value must not equal null.
	 * 
	 * @param key the
	 * @param value the
	 */
	public static void setPreference(String key, String value) {
		if(key != null && value != null) {
			Platform.getPreferencesService().getRootNode().node(ConfigurationScope.SCOPE).node(PREFERENCE_NODE).put(key, value);
			try {
				Platform.getPreferencesService().getRootNode().node(ConfigurationScope.SCOPE).node(PREFERENCE_NODE).flush();
			} catch (BackingStoreException e) {
				ModelUtil.logException("Could not persist the preference change: {" + key + ", " + value + "}", e);
			}
		}
	}

}
