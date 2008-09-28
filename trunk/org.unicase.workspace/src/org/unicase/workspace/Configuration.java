/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * Represents the current Workspace Configuration.
 * 
 * @author koegel
 * 
 */
public final class Configuration {

	private Configuration() {
		// nothing to do
	}

	private static Map<Object, Object> resourceSaveOptions;

	/**
	 * Get the Workspace directory.
	 * 
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
	 * 
	 * @return the workspace file path string
	 */
	public static String getWorkspacePath() {
		String workSpacePath = getWorkspaceDirectory() + "workspace";
		return workSpacePath;
	}

	/**
	 * Get the default resource save options.
	 * 
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
	public static List<ServerInfo> getDefaultServerInfos() {
		List<ServerInfo> serverInfos = new ArrayList<ServerInfo>();
		
		ServerInfo serverInfo1 = WorkspaceFactory.eINSTANCE.createServerInfo();
		serverInfo1.setDisplayName("Localhost Server");
		serverInfo1.setName("Localhost Server");
		serverInfo1.setPort(1099);
		serverInfo1.setUrl("localhost");
		Usersession superUsersession = WorkspaceFactory.eINSTANCE.createUsersession();
		superUsersession.setPassword("super");
		superUsersession.setSavePassword(true);
		superUsersession.setServerInfo(serverInfo1);
		superUsersession.setUsername("super");
		serverInfo1.setLastUsersession(superUsersession);
		serverInfos.add(serverInfo1);
				
		ServerInfo serverInfo2 = WorkspaceFactory.eINSTANCE.createServerInfo();
		serverInfo2.setDisplayName("unicase Server");
		serverInfo2.setName("unicase Server");
		serverInfo2.setPort(1099);
		serverInfo2.setUrl("sysiphus.in.tum.de");
		serverInfos.add(serverInfo2);
		
		return serverInfos;
	}
	
	public static int getMaxMECountPerResource() {
		return 100;
	}
	
	public static int getMaxResourceFileSizeOnExpand() {
		return 50000;
	}
}
