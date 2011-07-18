/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.test.navigator;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.junit.Before;
import org.junit.Test;
import org.unicase.ui.test.UITestCommon;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

/**
 * Class to test if a project is is imported correctly user's workspace in a way that the project is successfully placed
 * within the user's workspace.
 */
public class ImportProjectUITest {

	private static Workspace currentWorkspace;
	private static SWTWorkbenchBot bot;

	/**
	 * Setup the environment for testing.
	 */

	@Before
	public void setupActionItem() {

	}

	/**
	 * This method attempts to import a project programticaly and check if it appears in the UNICSAE Navigator UI or
	 * not.
	 */
	@Test
	public void importProjectUpdate() {
		currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		bot = new SWTWorkbenchBot();
		UITestCommon.openView(bot, "Unicase", "Navigator");
		/*
		 * try { //getProjectSpace().importLocalChanges(
		 * "/user/naguib/Documents/workspaces-UItesting13oct/devloper/SampleProjects/SupermarketExampleProject.ucp"); }
		 * catch (IOException e) { }
		 */

		bot.sleep(100000);

	}
}