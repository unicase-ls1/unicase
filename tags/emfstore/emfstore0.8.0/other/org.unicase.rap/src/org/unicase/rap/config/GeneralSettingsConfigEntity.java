/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.config;

import config.impl.ConfigEntityImpl;

/**
 * Configuration entity for general settings.
 * 
 * @author Edgar Müller
 */
public class GeneralSettingsConfigEntity extends ConfigEntityImpl {
	
	/**
	 * Name of the configuration file used.
	 */
	private static final String CFG_FILENAME = "org.unicase.rap.config.GeneralSettingsConfigEntity";
	
	/**  */
	public static final String DEFAULT_ADMIN_USERNAME = "admin";
	
	/**  */
	public static final String DEFAULT_ADMIN_PASSWORD = "admin";

	/**
	 * Keys.
	 */
	public class Keys {
		/**  */
		public static final String ADMIN_USER_NAME_KEY = "ADMIN_USER_NAME";
		/**  */
		public static final String ADMIN_PASSWORD_KEY = "ADMIN_PASSWORD";
	}
	
	/**
	 * Sets the username of the admin user.
	 * 
	 * @param username The username of the admin user
	 */
	public void setAdminUsername(String username) {
		getProperties().put(Keys.ADMIN_USER_NAME_KEY, username);
	}

	/**
	 * Returns the username of the admin.
	 * 
	 * @return Admin's user name.
	 */
	public String getAdminUsername() {
		return (String) getProperties().get(Keys.ADMIN_USER_NAME_KEY);
	}

	/**
	 * Sets the password of the admin user.
	 * 
	 * @param password The user name of the admin user
	 */
	public void setAdminPassword(String password) {
		getProperties().put(Keys.ADMIN_PASSWORD_KEY, password);
	}

	/**
	 * Returns the password of the admin.
	 * NOTE: Currently no encryption is used to persist the password!.
	 * @return The password of the admin.
	 */
	public String getAdminPassword() {
		return (String) getProperties().get(Keys.ADMIN_PASSWORD_KEY);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getConfigFilename() {
		return CFG_FILENAME;
	}
}
