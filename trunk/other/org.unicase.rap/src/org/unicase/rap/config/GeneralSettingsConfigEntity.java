package org.unicase.rap.config;

import config.impl.ConfigEntityImpl;

/**
 * Config entity for generel settings.
 * 
 * @author emueller
 *
 */
public class GeneralSettingsConfigEntity extends ConfigEntityImpl {
	
	/**
	 * Name of the configuration file used.
	 */
	private static final String CFG_FILENAME = "org.unicase.rap.config.GeneralSettingsConfigEntity";

	public class Keys {
		public static final String ADMIN_USER_NAME_KEY = "ADMIN_USER_NAME";
		public static final String ADMIN_PASSWORD_KEY = "ADMIN_PASSWORD";
	}
	
	public GeneralSettingsConfigEntity() {
		super();
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
	 * @return
	 */
	public String getAdminUsername() {
		return (String) getProperties().get(Keys.ADMIN_USER_NAME_KEY);
	}

	/**
	 * Sets the password of the admin user.
	 * 
	 * @param password The username of the admin user
	 */
	public void setAdminPassword(String password) {
		getProperties().put(Keys.ADMIN_PASSWORD_KEY, password);
	}

	/**
	 * Returns the password of the admin.
	 * 
	 * @return
	 */
	// TODO: encryption
	public String getAdminPassword() {
		return (String) getProperties().get(Keys.ADMIN_PASSWORD_KEY);
	}

	public String getConfigFilename() {
		return CFG_FILENAME;
	}
}
