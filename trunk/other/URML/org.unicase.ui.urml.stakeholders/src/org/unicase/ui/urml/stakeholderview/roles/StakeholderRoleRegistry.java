/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.urml.stakeholderview.roles;

import java.util.Arrays;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;
import org.unicase.metamodel.util.ModelUtil;

/**
 * Registry class for the stakeholder roles.
 * @author kterzieva
 *
 */
public class StakeholderRoleRegistry {

	private static final String PARAM_ALREADY_CREATED = "already created";
	private static final String PREFERENCE_REGISTRY_ID = null;
	private PreferenceList roleList;
	private Preferences preferences;

	/**
	 * The construct. 
	 */
	public StakeholderRoleRegistry() {
		preferences = new ConfigurationScope().getNode(PREFERENCE_REGISTRY_ID);
		if (!preferences.getBoolean(PARAM_ALREADY_CREATED, false)) {
			createDefautRoles();
		}
		roleList = new PreferenceList(preferences.node("registeredRoles"));
		// mit getList Rolenliste auslesen und für jede backedRole erstellen und load aufrufen
		// und speichern HahsMap<Name,RoleDataAccessObject>
	}

	private void createDefautRoles() {

		RoleDataAccessObject safetyEngineer = addRole("Safety Engineer");
		safetyEngineer.setName("Safety Engineer");
		safetyEngineer.setReviewSet(Arrays.asList("Danger","Requirement"));
		safetyEngineer.save();
		preferences.putBoolean(PARAM_ALREADY_CREATED, true);
		try {
			preferences.flush();
		} catch (BackingStoreException e) {
			ModelUtil.logException(e);
		}
	}

	/**
	 * Adds new role to the role list.
	 * @param roleId the role id
	 * @return .
	 */
	public PreferenceBackedRole addRole(String roleId) {
		roleList.add(roleId);
		try {
			roleList.flush();
		} catch (BackingStoreException e) {
			ModelUtil.logException(e);
		}
		return new PreferenceBackedRole(roleId);
	}

	/**
	 * Gets the role.
	 * @param roleId the role id
	 */
	public void getRole(String roleId) {
		roleList.add(roleId);
		try {
			roleList.flush();
		} catch (BackingStoreException e) {
			ModelUtil.logException(e);

		}
	}

}
