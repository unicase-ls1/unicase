/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace;

/**
 * Is called when the workspace is initiated. Use this for things which have to be initiated right at beginng. It often
 * is used to register Listeners.
 * 
 * @author emueller
 * @author wesendon
 */
public interface PostWorkspaceInitiator {

	/**
	 * Is called when the workspace is initiated.
	 * 
	 * @param currentWorkspace workspace
	 */
	void workspaceInitComplete(Workspace currentWorkspace);

}
