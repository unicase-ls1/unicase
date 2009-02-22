/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore;

import java.io.File;
import java.util.Properties;

/**
 * Represents the current server configuration.
 * 
 * @author koegel
 * @author wesendonk
 * 
 */
public final class ServerConfiguration {

	public static final String TRUE = "true";

	public static final String FALSE = "false";

	/**
	 * Constant for the name of the Resource Storage Property.
	 */
	public static final String RESOURCE_STORAGE = "ResourceStorage";

	/**
	 * Constant for the Default Resource Storage.
	 */
	public static final String DEFAULT_RESOURCE_STORAGE = "org.unicase.emfstore.storage.XMLStorage";

	/**
	 * RMI encryption property, possible values are true and false.
	 */
	public static final String RMI_ENCRYPTION = "rmi.encryption";

	/**
	 * Default RMI encryption property value.
	 */
	public static final String RMI_ENCRYTION_DEFAULT = "true";

	public static final String SSL_PASSWORD = "rmi.encryption.ssl.password";

	public static final String SSL_PASSWORD_DEFAULT = "av374tb$VBGGtrgwa7tosdfa";

	/**
	 * Property for projectstate persistence policy in versions. Possible values
	 * are <b>lastVersionOnly</b> and <b>everyVersion</b>
	 */
	public static final String PROJECTSTATE_VERSION_PERSISTENCE = "persistence.version.projectstate";

	public static final String FIRSTANDLASTVERSIONONLY = "firstAndLastVersionOnly";

	public static final String EVERYVERSION = "everyVersion";

	/**
	 * Default value for projectstate persistence policy in versions.
	 */
	public static final String PROJECTSPACE_VERSION_PERSISTENCY_DEFAULT = EVERYVERSION;

	public static final String SESSION_TIMEOUT = "accesscontrol.session.timeout";
	
	public static final String SESSION_TIMEOUT_DEFAULT = "7200";

	public static final String SUPER_USER = "accesscontrol.authentication.superuser";

	public static final String SUPER_USER_DEFAULT = "super";

	public static final String SUPER_USER_PASSWORD = "accesscontrol.authentication.superuser.password";

	public static final String SUPER_USER_PASSWORD_DEFAULT = "super";

	public static final String AUTHENTICATION_POLICY = "accesscontrol.authentication.policy";

	public static final String AUTHENTICATION_LDAP = "ldap";

	public static final String AUTHENTICATION_SPFV = "spfv";

	public static final String AUTHENTICATION_POLICY_DEFAULT = AUTHENTICATION_LDAP;

	public static final String AUTHENTICATION_SPFV_FILEPATH = "";

	private static Properties properties;

	private ServerConfiguration() {
		// nothing to do
	}

	/**
	 * Return the configuration directory location.
	 * 
	 * @return the dir path string
	 */
	public static String getConfDirectory() {
		StringBuffer sb = new StringBuffer(getServerHome());
		sb.append(".");
		sb.append(File.separatorChar);
		sb.append("conf");
		sb.append(File.separatorChar);
		return sb.toString();
	}

	/**
	 * Return the configuration file location.
	 * 
	 * @return the file path string
	 */
	public static String getConfFile() {
		return getConfDirectory() + "es.properties";
	}

	/**
	 * Return the server home directory location.
	 * 
	 * @return the dir path string
	 */
	public static String getServerHome() {
		StringBuffer sb = new StringBuffer(getUserHome());
		sb.append(".unicase");
		sb.append(File.separatorChar);
		sb.append("emfstore");
		sb.append(File.separatorChar);
		return sb.toString();
	}

	/**
	 * Return the user home directory location.
	 * 
	 * @return the dir path string
	 */
	public static String getUserHome() {
		StringBuffer sb = new StringBuffer();
		sb.append(System.getProperty("user.home"));
		sb.append(File.separatorChar);
		return sb.toString();
	}

	/**
	 * Gets the server's properties.
	 * 
	 * @return properties
	 */
	public static Properties getProperties() {
		if (properties == null) {
			properties = new Properties();
		}
		return properties;
	}

	/**
	 * Sets the server's properties.
	 * 
	 * @param prop
	 *            properties
	 */
	public static void setProperties(Properties prop) {
		properties = prop;
	}

	/**
	 * Returns the path to the server's keystore.
	 * 
	 * @return path to keystore
	 */
	public static String getServerKeyStorePath() {
		return getServerHome() + "unicaseServer.keystore";
	}
}
