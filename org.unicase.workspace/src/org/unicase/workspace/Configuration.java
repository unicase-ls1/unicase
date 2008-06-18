/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * Represents the current Workspace Configuration.
 * @author koegel
 *
 */
public final class Configuration {
	
	private Configuration() {
		//nothing to do
	}

	private static Map<Object, Object> resourceSaveOptions;

	/**
	 * Get the Workspace directory.
	 * @return the workspace directory path string
	 */
	public static String getWorkspaceDirectory() {
		StringBuffer sb = new StringBuffer();
		sb.append(System.getProperty("user.home"));
		sb.append(File.separatorChar);
		sb.append(".unicase");
		sb.append(File.separatorChar);
		File workspace = new File(sb.toString());
		if (!workspace.exists()) {
			workspace.mkdir();
		}
		return sb.toString();
	}
	
	/**
	 * Get the Workspace file path.
	 * @return the workspace file path string
	 */
	public static String getWorkspacePath() {
		String workSpacePath = getWorkspaceDirectory() + "workspace";
		return workSpacePath;
	}

	/**
	 * Get the default resource save options.
	 * @return the resource save options
	 */
	public static Map<Object, Object> getResourceSaveOptions() {
		if (resourceSaveOptions == null) {
			resourceSaveOptions = new HashMap<Object, Object>();
			resourceSaveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED,
					Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		}
		return resourceSaveOptions;
	}

	/**
	 * Get the default server info.
	 * 
	 * @return server info
	 */
	public static ServerInfo getDefaultServerInfo() {
		ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
		serverInfo.setDisplayName("DefaultServer");
		serverInfo.setName("EmfStoreOne");
		serverInfo.setPort(1099);
		serverInfo.setUrl("localhost");
		return serverInfo;
	}
}
