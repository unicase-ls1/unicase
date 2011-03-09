/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.config;

import config.impl.ConfigEntityImpl;

/**
 * EMFServer settings configuration entity.
 * 
 * @author Edgar Mueller, Fatih Ulusoy
 */
public class EMFServerSettingsConfigEntity extends ConfigEntityImpl {

	/**
	 * Name of the configuration file used.
	 */
	private static final String CFG_FILENAME = "org.unicase.rap.config.EMFServerSettingsConfigEntity";

	/**
	 * Keys.
	 */
	public class Keys {
		/** EMFServer URL. */
		public static final String EMF_SERVER_URL = "EMF_SERVER_URL";
		/** EMFServer port. */
		public static final String EMF_SERVER_PORT = "EMF_SERVER_PORT";
		/** EMFServer web client's user-name. */
		public static final String EMF_SERVER_USER_NAME = "EMF_SERVER_WEB_USER_NAME";
		/** EMFServer web client's user-password. */
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
	 * @return URL of EMFServer.
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
	 * @return Port of EMFServer.
	 */
	public int getEmfServerPort() {
		return (Integer) getProperties().get(Keys.EMF_SERVER_PORT);
	}
	
	/**
	 * Sets the user-name of the EMF-Server's web client.
	 * 
	 * @param emfServerUserName The user-name of the EMF-Server's web client.
	 */
	public void setEmfServerUserName(String emfServerUserName) {
		getProperties().put(Keys.EMF_SERVER_USER_NAME, emfServerUserName);
	}

	/**
	 * 
	 * @return The user-name of the EMF-Server's web client.
	 */
	public String getEmfServerUserName() {
		return (String) getProperties().get(Keys.EMF_SERVER_USER_NAME);
	}
	
	/**
	 * Sets the password of the EMF-Server's web client.
	 * 
	 * @param emfServerUserPassword The password of the EMF-Server's web client.
	 */
	public void setEmfServerUserPassword(String emfServerUserPassword) {
		getProperties().put(Keys.EMF_SERVER_USER_PASSWORD, emfServerUserPassword);
	}

	/**
	 * 
	 * @return The password of the EMF-Server's web client.
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

