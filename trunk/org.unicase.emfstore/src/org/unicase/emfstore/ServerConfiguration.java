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

	/**
	 * Constant for boolean true string.
	 */
	public static final String TRUE = "true";

	/**
	 * Constant for boolean false string.
	 */
	public static final String FALSE = "false";

	/**
	 * Constant for the name of the Resource Storage Property.
	 */
	public static final String RESOURCE_STORAGE = "ResourceStorage";

	/**
	 * Constant for the Default Resource Storage.
	 */
	public static final String RESOURCE_STORAGE_DEFAULT = "org.unicase.emfstore.storage.XMLStorage";

	/**
	 * RMI encryption property, possible values are true and false.
	 */
	public static final String RMI_ENCRYPTION = "rmi.encryption";

	/**
	 * Default RMI encryption property value.
	 */
	public static final String RMI_ENCRYTION_DEFAULT = "true";

	/**
	 * SSL password property, used for RMI encryption.
	 */
	public static final String SSL_PASSWORD = "rmi.encryption.ssl.password";

	/**
	 * Default SSL password.
	 */
	public static final String SSL_PASSWORD_DEFAULT = "av374tb$VBGGtrgwa7tosdfa";

	/**
	 * Property for projectstate persistence policy in versions. Possible values
	 * are <b>lastVersionOnly</b> and <b>everyVersion</b>. If you don't have
	 * every project state the server has to recalulate certain revisions if
	 * requested. On the other side saving every project state is quite
	 * redundant.
	 */
	public static final String PROJECTSTATE_VERSION_PERSISTENCE = "persistence.version.projectstate";

	/**
	 * Only the project state from the first and last version is stored, the
	 * other states are calculated by the changes.
	 */
	public static final String PROJECTSTATE_VERSION_PERSISTENCE_FIRSTANDLASTVERSIONONLY = "firstAndLastVersionOnly";

	/**
	 * The projectstate of every version will be stored.
	 */
	public static final String PROJECTSTATE_VERSION_PERSISTENCE_EVERYVERSION = "everyVersion";

	/**
	 * Default value for projectstate persistence policy in versions.
	 */
	public static final String PROJECTSPACE_VERSION_PERSISTENCY_DEFAULT = PROJECTSTATE_VERSION_PERSISTENCE_EVERYVERSION;

	/**
	 * Property for timeout time of a user session.
	 */
	public static final String SESSION_TIMEOUT = "accesscontrol.session.timeout";

	/**
	 * Default timeout.
	 */
	public static final String SESSION_TIMEOUT_DEFAULT = "7200";

	/**
	 * Property for the super user.
	 */
	public static final String SUPER_USER = "accesscontrol.authentication.superuser";

	/**
	 * Default super user name.
	 */
	public static final String SUPER_USER_DEFAULT = "super";

	/**
	 * Property for the super user's password.
	 */
	public static final String SUPER_USER_PASSWORD = "accesscontrol.authentication.superuser.password";

	/**
	 * Default super user password.
	 */
	public static final String SUPER_USER_PASSWORD_DEFAULT = "super";

	/**
	 * Property for authentication policy used by server. E.g. ldap or property
	 * file.
	 */
	public static final String AUTHENTICATION_POLICY = "accesscontrol.authentication.policy";

	/**
	 * Use ldap for authentication.
	 */
	public static final String AUTHENTICATION_LDAP = "ldap";

	/**
	 * Use simple property file for authentication.
	 */
	public static final String AUTHENTICATION_SPFV = "spfv";

	/**
	 * Default authentication policy: ldap.
	 */
	public static final String AUTHENTICATION_POLICY_DEFAULT = AUTHENTICATION_LDAP;

	/**
	 * Path to property file for spfv authentication.
	 */
	public static final String AUTHENTICATION_SPFV_FILEPATH = "accesscontrol.authentication.spfv";

	/**
	 * Property to validate server on start up.
	 */
	public static final String VALIDATE_SERVERSPACE_ON_SERVERSTART = "emfstore.validateOnLoad";

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
