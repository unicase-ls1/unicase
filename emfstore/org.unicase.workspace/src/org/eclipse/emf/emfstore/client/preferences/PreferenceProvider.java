/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.preferences;

import java.util.HashMap;

import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;

/**
 * Provides default properties.
 * 
 * @author Shterev
 */
public interface PreferenceProvider {

	/**
	 * @return the map of key and default preference.
	 */
	HashMap<PropertyKey, OrgUnitProperty> getPreferences();

}
