package org.unicase.rap.config;


/**
 * Config entity for generel settings.
 * 
 * @author emueller
 *
 */
public class GeneralSettingsConfigEntity extends AbstractConfigEntity {

	private static final String ADMIN_USER_NAME = "ADMIN_USER_NAME";
	private static final String ADMIN_PASSWORD = "ADMIN_PASSWORD";
	
	@Override
	public String getId() {
		return "org.unicase.web.config.GeneralSettingsConfigEntity";
	}

	/**
	 * Sets the username of the admin user.
	 * 
	 * @param username The username of the admin user
	 */
	public void setAdminUsername(String username) {
		properties.put(ADMIN_USER_NAME, username);
	}

	/**
	 * Returns the username of the admin.
	 * 
	 * @return
	 */
	public String getAdminUsername() {
		return (String) properties.get(ADMIN_USER_NAME);
	}
	
	/**
	 * Sets the password of the admin user.
	 * 
	 * @param password The username of the admin user
	 */
	public void setAdminPassword(String password) {
		properties.put(ADMIN_PASSWORD, password);
	}

	/**
	 * Returns the password of the admin.
	 * 
	 * @return
	 */
	// TODO: encryption
	public String getAdminPassword() {
		return (String) properties.get(ADMIN_PASSWORD);
	}
}
