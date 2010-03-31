package org.unicase.rap.config;

import config.impl.ConfigEntityImpl;

/**
 * 
 * 
 * @author fxulusoy
 */
public class EMFServerSettingsConfigEntity extends ConfigEntityImpl {

	/**
	 * Name of the configuration file used.
	 */
	private static final String CFG_FILENAME = "org.unicase.rap.config.EMFServerSettingsConfigEntity";

	public class Keys {
		public static final String EMF_SERVER_URL = "EMF_SERVER_URL";
		public static final String EMF_SERVER_PORT = "EMF_SERVER_PORT";
		public static final String EMF_SERVER_USER_NAME = "EMF_SERVER_WEB_USER_NAME";
		public static final String EMF_SERVER_USER_PASSWORD = "EMF_SERVER_WEB_USER_PASSWORD";
	}

	/**
	 * Sets the URL of the EMF-Server.
	 * 
	 * @param emfServerUrl The URL of the EMF-Server
	 */
	public void setEmfServerUrl(String emfServerUrl) {
		getProperties().put(Keys.EMF_SERVER_URL, emfServerUrl);
	}

	/**
	 * Returns the URL of the EMF-Server.
	 * 
	 * @return
	 */
	public String getEmfServerUrl() {
		return (String) getProperties().get(Keys.EMF_SERVER_URL);
	}
	
	/**
	 * Sets the port of the EMF-Server.
	 * 
	 * @param emfServerPort The URL of the EMF-Server
	 */
	public void setEmfServerPort(int emfServerPort) {
		getProperties().put(Keys.EMF_SERVER_PORT, emfServerPort);
	}

	/**
	 * Returns the port of the EMF-Server.
	 * 
	 * @return
	 */
	public int getEmfServerPort() {
		return (Integer) getProperties().get(Keys.EMF_SERVER_PORT);
	}
	
	/**
	 * Sets the user-name of the EMF-Server's web client.
	 * 
	 * @param emfServerPort The URL of the EMF-Server
	 */
	public void setEmfServerUserName(String emfServerPort) {
		getProperties().put(Keys.EMF_SERVER_USER_NAME, emfServerPort);
	}

	/**
	 * Returns the user-name of the EMF-Server's web client.
	 * 
	 * @return
	 */
	public String getEmfServerUserName() {
		return (String) getProperties().get(Keys.EMF_SERVER_USER_NAME);
	}
	
	/**
	 * Sets the password of the EMF-Server's web client.
	 * 
	 * @param emfServerPort The URL of the EMF-Server
	 */
	public void setEmfServerUserPassword(String emfServerPort) {
		getProperties().put(Keys.EMF_SERVER_USER_PASSWORD, emfServerPort);
	}

	/**
	 * Returns the password of the EMF-Server's web client.
	 * 
	 * @return
	 */
	public String getEmfServerUserPassword() {
		return (String) getProperties().get(Keys.EMF_SERVER_USER_PASSWORD);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getConfigFilename() {
		return CFG_FILENAME;
	}
	
}

