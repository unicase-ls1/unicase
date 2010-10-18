/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.util;

/**
 * Interface for workspace location providers. Implementing classes provide a location for the workspace files to store
 * models and other files. You may subclass {@link DefaultWorkspaceLocationProvider} in order to ease your
 * implementation. By convention, every path should end with an folder seperator char.
 * 
 * @author koegel
 * @author wesendon
 */
public interface WorkspaceLocationProvider {

	/**
	 * Get the path to the workspace directory, where the model data is stored to. This method is called only once on
	 * workspace startup to retrieve path. If you want to use profilese look at {@link DefaultWorkspaceLocationProvider}
	 * .
	 * 
	 * @return a string representing the path
	 */
	String getWorkspaceDirectory();

	/**
	 * Returns the path to a folder which holds backups of the workspaces. For example this is used to backup a
	 * workspace prior to migration.
	 * 
	 * @return a string representing the path
	 */
	String getBackupDirectory();

}
