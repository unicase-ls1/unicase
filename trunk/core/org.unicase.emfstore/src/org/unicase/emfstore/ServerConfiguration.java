/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.unicase.metamodel.util.ModelUtil;

/**
 * Represents the current server configuration.
 * 
 * @author koegel
 * @author wesendonk
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
	public static final String RMI_ENCRYPTION_DEFAULT = "true";

	/**
	 * Option for defining port of XML RPC.
	 */
	public static final String XML_RPC_PORT = "emfstore.connection.xmlrpc.port";

	/**
	 * Default port for XML RPC.
	 */
	public static final String XML_RPC_PORT_DEFAULT = "8443";

	/**
	 * Default port for XML RPC if running developer version. This port differs to the normal default port due to port
	 * binding restriction under unix based operating systems.
	 */
	public static final String XML_RPC_PORT_DEVELOPER_DEFAULT = "8080";

	/**
	 * Password of keystore, in which the certificate for rmi encryption and password decryption is saved.
	 * 
	 * @see #KEYSTORE_ALIAS
	 */
	public static final String KEYSTORE_PASSWORD = "emfstore.keystore.password";

	/**
	 * Default keystore password.
	 */
	public static final String KEYSTORE_PASSWORD_DEFAULT = "av374tb$VBGGtrgwa7tosdfa";

	/**
	 * Alias for certificate in keystore.
	 * 
	 * @see #KEYSTORE_PASSWORD
	 */
	public static final String KEYSTORE_ALIAS = "emfstore.keystore.alias";

	/**
	 * Default alias, intentioned for developers.
	 */
	public static final String KEYSTORE_ALIAS_DEFAULT = "testkeygeneratedbyotto";

	/**
	 * Type of server certificate used for encryption.
	 */
	public static final String KEYSTORE_CERTIFICATE_TYPE = "emfstore.keystore.certificate.type";

	/**
	 * Default certificate.
	 */
	public static final String KEYSTORE_CERTIFICATE_TYPE_DEFAULT = "SunX509";

	/**
	 * Type of cipher algorithm used for encryption.
	 */
	public static final String KEYSTORE_CIPHER_ALGORITHM = "emfstore.keystore.cipher.algorithm";

	/**
	 * Default cipher algorithm.
	 */
	public static final String KEYSTORE_CIPHER_ALGORITHM_DEFAULT = "RSA";

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
	@Deprecated
	public static final String PROJECTSTATE_VERSION_BACKUP_PERSISTENCE_EVERYXVERSIONS_X = "emfstore.persistence.version.backup.projectstate.everyxversions";

	/**
	 * Default value for the BACKUP everyXVersion policy.
	 */
	@Deprecated
	public static final String PROJECTSTATE_VERSION_BACKUP_PERSISTENCE_EVERYXVERSIONS_X_DEFAULT = "1";

	/**
	 * Property for timeout time of a user session.
	 */
	public static final String SESSION_TIMEOUT = "emfstore.accesscontrol.session.timeout";

	/**
	 * Default timeout (=30 min).
	 */
	public static final String SESSION_TIMEOUT_DEFAULT = "1800000";

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
	 * 
	 * @deprecated use {@link #getDefaultSPFVFilePath()}
	 */
	@Deprecated
	public static final String AUTHENTICATION_SPFV_FILEPATH_DEFAULT = getConfDirectory() + "user.properties";

	/**
	 * Property to validate server on start up.
	 */
	public static final String VALIDATE_SERVERSPACE_ON_SERVERSTART = "emfstore.validation";

	/**
	 * Sets the level of validation. The level is set via bitmask, use the values
	 * {@link org.unicase.emfstore.startup.EmfStoreValidator#RESOLVEALL},
	 * {@link org.unicase.emfstore.startup.EmfStoreValidator#MODELELEMENTID} and
	 * {@link org.unicase.emfstore.startup.EmfStoreValidator#PROJECTGENERATION}. E.g.: If you want to resolve all
	 * elements and check use the modelelement id validation, you have to set the level to <code>1 | 2</code>, which is
	 * 3.
	 */
	public static final String VALIDATION_LEVEL = "emfstore.validation.level";

	/**
	 * Default validation level.
	 */
	public static final String VALIDATION_LEVEL_DEFAULT = "7";

	/**
	 * Exclude projects from validation, use {@link #MULTI_PROPERTY_SEPERATOR} to seperate them.
	 */
	public static final String VALIDATION_PROJECT_EXCLUDE = "emfstore.validation.exclude";

	/**
	 * By default, no project is excluded.
	 */
	public static final String VALIDATION_PROJECT_EXCLUDE_DEFAULT = "";

	/**
	 * Property for loading startup listeners from extension point.
	 */
	public static final String LOAD_STARTUP_LISTENER = "emfstore.startup.loadlistener";

	/**
	 * Property for loading post startup listeners from extension point.
	 */
	public static final String LOAD_POST_STARTUP_LISTENER = "emfstore.startup.post.loadlistener";

	/**
	 * Default value for {@link #LOAD_STARTUP_LISTENER}.
	 */
	public static final String LOAD_STARTUP_LISTENER_DEFAULT = FALSE;

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

	/*
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

	/*
	 * FILE PREFIXES
	 */

	/**
	 * File prefix for file: backup projectstate.
	 */
	@Deprecated
	public static final String FILE_PREFIX_BACKUPPROJECTSTATE = "backup_";

	/**
	 * File prefix for file: changepackage.
	 */
	public static final String FILE_PREFIX_CHANGEPACKAGE = "changepackage-";

	/**
	 * File prefix for file: projectstate.
	 */
	public static final String FILE_PREFIX_PROJECTSTATE = "projectstate-";

	/**
	 * File prefix for file: version.
	 */
	public static final String FILE_PREFIX_VERSION = "version-";

	/**
	 * File prefix for folder: project.
	 */
	public static final String FILE_PREFIX_PROJECTFOLDER = "project-";

	/**
	 * File name for model release number.
	 */
	public static final String MODEL_VERSION_FILENAME = "modelReleaseNumber";

	/**
	 * Prefix for EMFStore Home Startup Argument.
	 */
	public static final String EMFSTORE_HOME = "-EMFStoreHome";

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

	private static String serverHome;

	/**
	 * Return the server home directory location.
	 * 
	 * @return the dir path string
	 */
	public static String getServerHome() {
		if (serverHome != null) {
			return serverHome;
		}
		String[] applicationArgs = Platform.getApplicationArgs();
		for (String arg : applicationArgs) {
			if (arg.startsWith(EMFSTORE_HOME) && arg.length() > EMFSTORE_HOME.length()) {
				String path = arg.substring(arg.indexOf("=") + 1, arg.length());
				if (!path.endsWith(File.separator)) {
					path = path + File.separator;
				}
				File file = new File(path);
				if (file.exists() && file.isDirectory()) {
					serverHome = path;
					return serverHome;
				} else if (file.exists() && !file.isDirectory()) {
					String errorMessage = "Illegal EMFStore home path received:" + path;
					ModelUtil.log(errorMessage, new IllegalStateException("The path exists as file already."),
						IStatus.ERROR);
					System.err.println(errorMessage);
				}
				boolean created = file.mkdir();
				if (!created) {
					// log and switch to default
					String errorMessage = "Illegal EMFStore home path received:" + path;
					ModelUtil.log(errorMessage, new IllegalStateException("The path can not be created."),
						IStatus.ERROR);
					System.err.println(errorMessage);
					break;
				}
				serverHome = path;
				return serverHome;
			}
		}
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
		System.out.println("Using default path for EMFStore home:" + sb.toString());
		serverHome = sb.toString();
		return serverHome;
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
	 * Default filepath for spfv authentication.
	 * 
	 * @return path as string
	 */
	public static String getDefaultSPFVFilePath() {
		return getConfDirectory() + "user.properties";
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
	 * This method calls {@link Properties#getProperty(String)} and splits the resulting string, using
	 * {@link #MULTI_PROPERTY_SEPERATOR}.
	 * 
	 * @param property property key
	 * @return String array or null
	 */
	public static String[] getSplittedProperty(String property) {
		String result = getProperties().getProperty(property);
		return (result == null) ? null : splitProperty(result);
	}

	/**
	 * This method calls {@link Properties#getProperty(String, String)} and splits the resulting string, using
	 * {@link #MULTI_PROPERTY_SEPERATOR}.
	 * 
	 * @param property property key
	 * @param defaultValue default value
	 * @return String array or null
	 */
	public static String[] getSplittedProperty(String property, String defaultValue) {
		String result = getProperties().getProperty(property, defaultValue);
		return (result == null) ? null : splitProperty(result);
	}

	private static String[] splitProperty(String property) {
		ArrayList<String> result = new ArrayList<String>();
		for (String str : property.split(ServerConfiguration.MULTI_PROPERTY_SEPERATOR)) {
			result.add(str.trim());
		}
		return result.toArray(new String[result.size()]);
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
