/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.util;

import static org.unicase.workspace.Configuration.isInternalReleaseVersion;
import static org.unicase.workspace.Configuration.isReleaseVersion;
import static org.unicase.workspace.Configuration.isTesting;

import java.io.File;

import org.eclipse.core.runtime.Platform;

/**
 * This is the default workspace location provider. If no other location provider is registered, this provider is used.
 * The default location provider offers profiles, which allows to have multiple workspaces within one root folder.
 * Allowing this isn't mandatory. It is encouraged to subclass this class when implementing an own location provider,
 * since it offers convenience methods. By convention, every path should end with an folder separator char.
 * 
 * @author wesendon
 */
public class DefaultWorkspaceLocationProvider implements WorkspaceLocationProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.util.WorkspaceLocationProvider#getRootDirectory()
	 */
	public String getRootDirectory() {
		return addFolders(getUserHome(), ".unicase", "client");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.util.WorkspaceLocationProvider#getWorkspaceDirectory()
	 */
	public String getWorkspaceDirectory() {

		String parameter = getStartParameter("-profile");

		if (parameter == null) {

			parameter = "main";
			if (isTesting()) {
				parameter += "_test";
			} else if (!isReleaseVersion()) {
				if (isInternalReleaseVersion()) {
					parameter += "_internal";
				} else {
					parameter += "_dev";
				}
			}

		}

		return addFolders(getRootDirectory(), "profiles", parameter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.util.WorkspaceLocationProvider#getBackupDirectory()
	 */
	public String getBackupDirectory() {
		return addFolders(getRootDirectory(), "backup");
	}

	/**
	 * Extracts parameter from application startup arguments. It uses following pattern: parameter+"="+valueOfParameter
	 * 
	 * @param parameter name of parameter
	 * @return value of parameter as string or null
	 */
	protected String getStartParameter(String parameter) {
		String[] applicationArgs = Platform.getApplicationArgs();
		for (String arg : applicationArgs) {
			arg = arg.trim();
			if (arg.startsWith(parameter) && arg.length() > parameter.length() && arg.charAt(parameter.length()) == '=') {
				return arg.substring(parameter.length() + 1, arg.length());
			}
		}
		return null;
	}

	/**
	 * Convenience method to add folders to a string path.
	 * 
	 * @param path the path
	 * @param folders folder to add
	 * @return new path as string
	 */
	protected static String addFolders(String path, String... folders) {
		StringBuffer result = new StringBuffer(path);
		if (!path.endsWith(File.separator)) {
			result.append(File.separatorChar);
		}
		for (String folder : folders) {
			result.append(folder);
			if (!folder.endsWith(File.separator)) {
				result.append(File.separatorChar);
			}
		}
		return result.toString();
	}

	/**
	 * Return the user home folder.
	 * 
	 * @return the full path as string
	 */
	protected static String getUserHome() {
		StringBuffer sb = new StringBuffer();
		sb.append(System.getProperty("user.home"));
		sb.append(File.separatorChar);
		return sb.toString();
	}

}
