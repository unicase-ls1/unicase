/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

import java.io.File;
import java.util.Properties;

/**
 * Represents the current server configuration.
 * 
 * @author koegel
 * @author wesendonk
 */
public final class ServerConfiguration {

	private static final String BACKUPPROJECTSTATE_FILE_PREFIX = "backup_";

	private static final String CHANGEPACKAGE_FILE_PREFIX = "changepackage-";

	private static final String PROJECTSTATE_FILE_PREFIX = "projectstate-";

	private static final String VERSION_FILE_PREFIX = "version-";

	private static final String MODEL_VERSION_FILENAME = "modelReleaseNumber";

	private static final String PROJECT_PREFIX = "project-";

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
	public static final String RESOURCE_STORAGE = "emfstore.persistence.resourceStorage";

	/**
	 * Constant for the Default Resource Storage.
	 */
	public static final String RESOURCE_STORAGE_DEFAULT = "org.unicase.emfstore.storage.XMLStorage";

	/**
	 * RMI encryption property, possible values are true and false.
	 */
	public static final String RMI_ENCRYPTION = "emfstore.connection.rmi.encryption";

	/**
	 * Default RMI encryption property value.
	 */
	public static final String RMI_ENCRYTION_DEFAULT = "true";

	/**
	 * SSL password property, used for RMI encryption.
	 */
	public static final String SSL_PASSWORD = "emfstore.connection.rmi.encryption.ssl.password";

	/**
	 * Default SSL password.
	 */
	public static final String SSL_PASSWORD_DEFAULT = "av374tb$VBGGtrgwa7tosdfa";

	/**
	 * Property for projectstate persistence policy in versions. Possible values are <b>lastVersionOnly</b> and
	 * <b>everyVersion</b>. If you don't have every project state the server has to recalulate certain revisions if
	 * requested. On the other side saving every project state is quite redundant.
	 */
	public static final String PROJECTSTATE_VERSION_PERSISTENCE = "emfstore.persistence.version.projectstate";

	/**
	 * Only the project state from the first and last version is stored, the other states are calculated by the changes.
	 */
	public static final String PROJECTSTATE_VERSION_PERSISTENCE_FIRSTANDLASTVERSIONONLY = "firstAndLastVersionOnly";

	/**
	 * The projectstate of every x versions will be stored. This is used to save memory. Use x=1 to save every version.
	 */
	public static final String PROJECTSTATE_VERSION_PERSISTENCE_EVERYXVERSIONS = "everyXVersion";

	/**
	 * Property for the count of versions, needed by the everyXVersion policy.
	 */
	public static final String PROJECTSTATE_VERSION_PERSISTENCE_EVERYXVERSIONS_X = "emfstore.persistence.version.projectstate.everyxversions";

	/**
	 * Default value for the everyXVersion policy.
	 */
	public static final String PROJECTSTATE_VERSION_PERSISTENCE_EVERYXVERSIONS_X_DEFAULT = "1";

	/**
	 * Default value for projectstate persistence policy in versions.
	 */
	public static final String PROJECTSPACE_VERSION_PERSISTENCE_DEFAULT = PROJECTSTATE_VERSION_PERSISTENCE_EVERYXVERSIONS;

	/**
	 * Property for the count of versions, needed by the BACKUP everyXVersion policy.
	 */
	public static final String PROJECTSTATE_VERSION_BACKUP_PERSISTENCE_EVERYXVERSIONS_X = "emfstore.persistence.version.backup.projectstate.everyxversions";

	/**
	 * Default value for the BACKUP everyXVersion policy.
	 */
	public static final String PROJECTSTATE_VERSION_BACKUP_PERSISTENCE_EVERYXVERSIONS_X_DEFAULT = "1";

	/**
	 * Property for timeout time of a user session.
	 */
	public static final String SESSION_TIMEOUT = "emfstore.accesscontrol.session.timeout";

	/**
	 * Default timeout.
	 */
	public static final String SESSION_TIMEOUT_DEFAULT = "7200";

	/**
	 * Property for the super user.
	 */
	public static final String SUPER_USER = "emfstore.accesscontrol.authentication.superuser";

	/**
	 * Default super user name.
	 */
	public static final String SUPER_USER_DEFAULT = "super";

	/**
	 * Property for the super user's password.
	 */
	public static final String SUPER_USER_PASSWORD = "emfstore.accesscontrol.authentication.superuser.password";

	/**
	 * Default super user password.
	 */
	public static final String SUPER_USER_PASSWORD_DEFAULT = "super";

	/**
	 * Property for authentication policy used by server. E.g. ldap or property file.
	 */
	public static final String AUTHENTICATION_POLICY = "emfstore.accesscontrol.authentication.policy";

	/**
	 * Use ldap for authentication.
	 */
	public static final String AUTHENTICATION_LDAP = "ldap";

	/**
	 * Beginng tag of every ldap property. Format for ldap configuration is {@link #AUTHENTICATION_LDAP_PREFIX}
	 * .[numberOfLdapConfiguration].{ {@link #AUTHENTICATION_LDAP_URL}/ {@link #AUTHENTICATION_LDAP_BASE_DEFAULT}/
	 * {@link #AUTHENTICATION_LDAP_SEARCHDN} .
	 */
	public static final String AUTHENTICATION_LDAP_PREFIX = "emfstore.accesscontrol.authentication.ldap";

	/**
	 * Ldap url.
	 */
	public static final String AUTHENTICATION_LDAP_URL = "url";

	/**
	 * Ldap base.
	 */
	public static final String AUTHENTICATION_LDAP_BASE = "base";

	/**
	 * Searchdn for ldap.
	 */
	public static final String AUTHENTICATION_LDAP_SEARCHDN = "searchdn";

	/**
	 * Use simple property file for authentication.
	 */
	public static final String AUTHENTICATION_SPFV = "spfv";

	/**
	 * Default authentication policy: ldap.
	 */
	public static final String AUTHENTICATION_POLICY_DEFAULT = AUTHENTICATION_SPFV;

	/**
	 * Path to property file for spfv authentication.
	 */
	public static final String AUTHENTICATION_SPFV_FILEPATH = "emfstore.accesscontrol.authentication.spfv";

	/**
	 * Default filepath for spfv authentication.
	 */
	public static final String AUTHENTICATION_SPFV_FILEPATH_DEFAULT = getConfDirectory() + "user.properties";

	/**
	 * Property to validate server on start up.
	 */
	public static final String VALIDATE_SERVERSPACE_ON_SERVERSTART = "emfstore.validateOnLoad";

	/**
	 * Property name of accepted client versions. Enter the version's names or any, seperate multiple entries with
	 * {@link #MULTI_PROPERTY_SEPERATOR}.
	 */
	public static final String ACCEPTED_VERSIONS = "emfstore.acceptedversions";

	/**
	 * Allow any client version.
	 */
	public static final String ACCEPTED_VERSIONS_ANY = "any";

	/**
	 * Seperator for multiple properties. E.g. acceptedversions = 0.1,0.2
	 */
	public static final String MULTI_PROPERTY_SEPERATOR = ",";

	/**
	 * FILE EXTENSIONS
	 */

	/**
	 * File extension for main file: unicase server storage.
	 */
	public static final String FILE_EXTENSION_MAINSTORAGE = ".uss";

	/**
	 * File extension for main file: unicase project historyF.
	 */
	public static final String FILE_EXTENSION_PROJECTHISTORY = ".uph";

	/**
	 * File extension for main file: unicase project version.
	 */
	public static final String FILE_EXTENSION_VERSION = ".upv";

	/**
	 * File extension for main file: unicase project state.
	 */
	public static final String FILE_EXTENSION_PROJECTSTATE = ".ups";

	/**
	 * File extension for main file: unicase change package.
	 */
	public static final String FILE_EXTENSION_CHANGEPACKAGE = ".ucp";

	private static boolean testing;

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
		if (testing) {
			sb.append(".test");
		} else if (!isReleaseVersion()) {
			if (isInternalReleaseVersion()) {
				sb.append(".internal");
			} else {
				sb.append(".dev");
			}
		}
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
	 * @param prop properties
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

	/**
	 * Get the server version as in the org.unicase.emfstore manifest file.
	 * 
	 * @return the server version number
	 */
	public static String getServerVersion() {

		Bundle emfStoreBundle = Platform.getBundle("org.unicase.emfstore");
		String emfStoreVersionString = (String) emfStoreBundle.getHeaders().get(
			org.osgi.framework.Constants.BUNDLE_VERSION);
		return emfStoreVersionString;
	}

	/**
	 * Determine if this is a release version or not.
	 * 
	 * @return true if it is a release version
	 */
	public static boolean isReleaseVersion() {
		return !getServerVersion().endsWith("qualifier") && !isInternalReleaseVersion();
	}

	/**
	 * Determines if this is an internal release or not.
	 * 
	 * @return true if it an internal release
	 */
	public static boolean isInternalReleaseVersion() {
		return getServerVersion().endsWith("internal");
	}

	/**
	 * Returns path to emfstore's main file.
	 * 
	 * @return path
	 */
	public static String getServerMainFile() {
		return getServerHome() + "storage" + FILE_EXTENSION_MAINSTORAGE;
	}

	/**
	 * Return the name of the model release number file. This file identifies the release number of the model in the
	 * workspace.
	 * 
	 * @return the file name
	 */
	public static String getModelReleaseNumberFileName() {
		return getServerHome() + MODEL_VERSION_FILENAME;
	}

	/**
	 * Return prefix for project directory name.
	 * 
	 * @return the prefix string
	 */
	public static String getProjectDirectoryPrefix() {
		return PROJECT_PREFIX;
	}

	/**
	 * Return prefix for version file name.
	 * 
	 * @return the prefix string
	 */
	public static String getVersionFilePrefix() {
		return VERSION_FILE_PREFIX;
	}

	/**
	 * Return prefix for projectstate file name.
	 * 
	 * @return the prefix string
	 */
	public static String getProjectStatePrefix() {
		return PROJECTSTATE_FILE_PREFIX;
	}

	/**
	 * Return prefix for change package file name.
	 * 
	 * @return the prefix string
	 */
	public static String getChangePackageFilePrefix() {
		return CHANGEPACKAGE_FILE_PREFIX;
	}

	/**
	 * Return prefix for the backup project state file name.
	 * 
	 * @return the prefix string
	 */
	public static String getBackupStatePrefix() {
		return BACKUPPROJECTSTATE_FILE_PREFIX;
	}

	/**
	 * @param testing if server is running for testing
	 */
	public static void setTesting(boolean testing) {
		ServerConfiguration.testing = testing;
	}

	/**
	 * @return if server is running for testing
	 */
	public static boolean isTesting() {
		return testing;
	}

}
