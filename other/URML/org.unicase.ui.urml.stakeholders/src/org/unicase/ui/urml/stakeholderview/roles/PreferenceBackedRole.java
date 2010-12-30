/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholderview.roles;

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

/**
 * Class for storing the role information through preference tree.
 * 
 * @author kterzieva
 */
public class PreferenceBackedRole extends RoleDataAccessObject {

	private static final String NAME_DEFAULT = "<< unnamed role >>";
	private static final String PREFERENCE_FOLDER_ID = "org.unicase.ui.urml.stakeholderview.test";
	private static final String PARAM_REVIEW_SET = "reviewSet";
	private static final String PARAM_NAME = "name";

	/**
	 * The construct.
	 * 
	 * @param roleId the role name
	 */
	public PreferenceBackedRole(String roleId) {
		super(roleId);
	}

	@Override
	public void load() {
		Preferences preferences = new ConfigurationScope().getNode(PREFERENCE_FOLDER_ID);
		try {
			if (!preferences.nodeExists(getRoleId())) {
				throw new RuntimeException("Role '" + getRoleId() + "' does not exist");
			}
			Preferences role = preferences.node(getRoleId());

			setName(role.get(PARAM_NAME, NAME_DEFAULT));
			Preferences reviewSetNode = role.node(PARAM_REVIEW_SET);
			setReviewSet(new PreferenceList(reviewSetNode).getList());

		} catch (BackingStoreException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save() {
		Preferences preferences = new ConfigurationScope().getNode(PREFERENCE_FOLDER_ID);
		Preferences role = preferences.node(getRoleId());
		role.put(PARAM_NAME, getName());
		Preferences reviewSetNode = role.node(PARAM_REVIEW_SET);
		new PreferenceList(reviewSetNode).setList(getReviewSet());
		try {
			preferences.flush();
		} catch (BackingStoreException e) {
			throw new RuntimeException(e);
		}
	}

	

}
