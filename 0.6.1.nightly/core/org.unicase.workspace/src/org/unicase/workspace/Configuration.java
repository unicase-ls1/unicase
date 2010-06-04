/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.osgi.framework.Bundle;
import org.unicase.emfstore.esmodel.ClientVersionInfo;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.connectionmanager.KeyStoreManager;
import org.unicase.workspace.util.WorkspaceLocationProvider;

/**
 * Represents the current Workspace Configuration.
 * 
 * @author koegel
 */
public final class Configuration {

	private static final String TRANSACTIONAL_EDITINGDOMAIN_ID = "org.unicase.EditingDomain";
	private static final String MODEL_VERSION_FILENAME = "modelReleaseNumber";
	private static final String UPS = ".ups";
	private static final String UOC = ".uoc";
	private static final String PROJECT_FOLDER = "project";
	private static final String PS = "ps-";
	private static final String UPF = ".upf";
	private static final String PLUGIN_BASEDIR = "pluginData";
	private static boolean testing;

	private Configuration() {
		// nothing to do
	}

	// private static Map<Object, Object> resourceSaveOptions;

	/**
	 * Return the user home folder.
	 * 
	 * @return the full path as string
	 */
	public static String getUserHome() {
		StringBuffer sb = new StringBuffer();
		sb.append(System.getProperty("user.home"));
		sb.append(File.separatorChar);
		return sb.toString();
	}

	/**
	 * Get the Workspace directory.
	 * 
	 * @return the workspace directory path string
	 */
	public static String getWorkspaceDirectory() {

		IConfigurationElement[] rawExtensions = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.workspace.workspaceLocationProvider");
		if (rawExtensions.length > 0) {
			if (rawExtensions.length > 1) {
				String message = "More than one workspace location provider extension detected, defaulting to first preovider";
				ModelUtil.logWarning(message, new IllegalStateException(message));
			}
			for (IConfigurationElement extension : rawExtensions) {
				try {
					Object executableExtension = extension.createExecutableExtension("providerClass");
					if (executableExtension instanceof WorkspaceLocationProvider) {
						WorkspaceLocationProvider provider = (WorkspaceLocationProvider) executableExtension;
						String workspaceDirectory = provider.getWorkspaceDirectory();
						File workspace = new File(workspaceDirectory);
						if (!workspace.exists()) {
							workspace.mkdir();
						}
						if (!workspaceDirectory.endsWith(File.separator)) {
							return workspaceDirectory + File.separatorChar;
						}
						return workspaceDirectory;
					}
				} catch (CoreException e) {
					String message = "Error while instantiating location provider, switching to default location!";
					ModelUtil.logWarning(message, e);
				}
			}
		}

		// no valid extension registered, switching to default
		StringBuffer sb = new StringBuffer();
		sb.append(getUserHome());
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
		File workspace = new File(sb.toString());
		if (!workspace.exists()) {
			workspace.mkdir();
		}
		return sb.toString();
	}

	/**
	 * Get the Workspace file path.
	 * 
	 * @return the workspace file path string
	 */
	public static String getWorkspacePath() {
		String workSpacePath = getWorkspaceDirectory() + "workspace.ucw";
		return workSpacePath;
	}

	/**
	 * Get the default resource save options.
	 * 
	 * @return the resource save options
	 */
	public static Map<Object, Object> getResourceSaveOptions() {
		// MK: the options below should only be used with resourcemodification
		// tracking enabled
		// if (resourceSaveOptions == null) {
		// resourceSaveOptions = new HashMap<Object, Object>();
		// resourceSaveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED,
		// Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		// }
		return null;
	}

	/**
	 * Get the default server info.
	 * 
	 * @return server info
	 */
	public static List<ServerInfo> getDefaultServerInfos() {
		IConfigurationElement[] rawExtensions = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.workspace.defaultConfigurationProvider");
		for (IConfigurationElement extension : rawExtensions) {
			try {
				ConfigurationProvider provider = (ConfigurationProvider) extension
					.createExecutableExtension("providerClass");
				List<ServerInfo> defaultServerInfos = provider.getDefaultServerInfos();
				if (defaultServerInfos != null) {
					return defaultServerInfos;
				}
			} catch (CoreException e) {
				// fail silently
			}
		}

		ArrayList<ServerInfo> result = new ArrayList<ServerInfo>();
		result.add(getLocalhostServerInfo());
		return result;
	}

	private static ServerInfo getLocalhostServerInfo() {
		ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
		serverInfo.setName("Localhost Server");
		serverInfo.setPort(8080);
		serverInfo.setUrl("localhost");
		serverInfo.setCertificateAlias(KeyStoreManager.DEFAULT_DEV_CERTIFICATE);

		Usersession superUsersession = WorkspaceFactory.eINSTANCE.createUsersession();
		superUsersession.setServerInfo(serverInfo);
		superUsersession.setPassword("super");
		superUsersession.setSavePassword(true);
		superUsersession.setUsername("super");
		serverInfo.setLastUsersession(superUsersession);

		return serverInfo;
	}

	/**
	 * Returns maximum number of model elements allowed per resource.
	 * 
	 * @return the maximum number
	 */
	public static int getMaxMECountPerResource() {
		return 100;
	}

	/**
	 * Returns maximum size of of a resource file on expand.
	 * 
	 * @return the maximum number
	 */
	public static int getMaxResourceFileSizeOnExpand() {
		return 50000;
	}

	/**
	 * Get the client version as in the org.unicase.workspace manifest file.
	 * 
	 * @return the client version number
	 */
	public static ClientVersionInfo getClientVersion() {
		ClientVersionInfo clientVersionInfo = EsmodelFactory.eINSTANCE.createClientVersionInfo();
		clientVersionInfo.setName("unicase.org eclipse client");

		Bundle emfStoreBundle = Platform.getBundle("org.unicase.workspace");
		String emfStoreVersionString = (String) emfStoreBundle.getHeaders().get(
			org.osgi.framework.Constants.BUNDLE_VERSION);

		clientVersionInfo.setVersion(emfStoreVersionString);
		return clientVersionInfo;
	}

	/**
	 * Determine if this is a release version or not.
	 * 
	 * @return true if it is a release version
	 */
	public static boolean isReleaseVersion() {
		return !isInternalReleaseVersion() && !getClientVersion().getVersion().endsWith("qualifier");
	}

	/**
	 * Determines if this is an internal release or not.
	 * 
	 * @return true if it is an internal release
	 */
	public static boolean isInternalReleaseVersion() {
		return getClientVersion().getVersion().endsWith("internal");
	}

	/**
	 * Determines if this is an developer version or not.
	 * 
	 * @return true if it is a developer version
	 */
	public static boolean isDeveloperVersion() {
		return !isReleaseVersion() && !isInternalReleaseVersion();
	}

	/**
	 * Return the file extension for project space files.
	 * 
	 * @return the file extension
	 */
	public static String getProjectSpaceFileExtension() {
		return UPS;
	}

	/**
	 * Return the file extension for operation composite files.
	 * 
	 * @return the file extension
	 */
	public static String getOperationCompositeFileExtension() {
		return UOC;
	}

	/**
	 * Return the name of the project folder.
	 * 
	 * @return the folder name
	 */
	public static String getProjectFolderName() {
		return PROJECT_FOLDER;
	}

	/**
	 * Return the prefix of the project space directory.
	 * 
	 * @return the prefix
	 */
	public static String getProjectSpaceDirectoryPrefix() {
		return PS;
	}

	/**
	 * Return project fragement file extension.
	 * 
	 * @return the file extension
	 */
	public static String getProjectFragmentFileExtension() {
		return UPF;
	}

	/**
	 * Return the name of the model release number file. This file identifies the release number of the model in the
	 * workspace.
	 * 
	 * @return the file name
	 */
	public static String getModelReleaseNumberFileName() {
		return getWorkspaceDirectory() + MODEL_VERSION_FILENAME;
	}

	/**
	 * If we are running tests. In this case the workspace will be created in USERHOME/.unicase.test.
	 * 
	 * @param testing the testing to set
	 */
	public static void setTesting(boolean testing) {
		Configuration.testing = testing;
	}

	/**
	 * @return if we are running tests. In this case the workspace will be created in USERHOME/.unicase.test.
	 */
	public static boolean isTesting() {
		return testing;
	}

	/**
	 * Return the path of the plugin data directory inside the unicase workspace (trailing file separator included).
	 * 
	 * @return the plugin data directory absolute path as string
	 */
	public static String getPluginDataBaseDirectory() {
		return getWorkspaceDirectory() + PLUGIN_BASEDIR + File.separatorChar;
	}

	/**
	 * Retrieve the unicase editing domain. Will return null until the domain is initialized by the WorkspaceManager.
	 * 
	 * @return the unicase workspace editing domain
	 */
	public static TransactionalEditingDomain getEditingDomain() {
		return TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(TRANSACTIONAL_EDITINGDOMAIN_ID);
	}
}
