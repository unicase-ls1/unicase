/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.test.navigator;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.unicase.ui.test.UITestCommon;
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Class to test if a project is is imported correctly user's workspace in a way that the project is successfully placed
 * within the user's workspace.
 */
public class ImportProjectUITest extends MEEditorTest {

	private static Workspace currentWorkspace;

	/**
	 * Setup the environment for testing.
	 */
	@Before
	public void setupActionItem() {

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
				try {
					currentWorkspace.deleteProjectSpace(getProjectSpace());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.run();
	}

	/**
	 * This method attempts to import a project programticaly and check if it appears in the UNICSAE Navigator UI or
	 * not.
	 */
	@Test
	public void importProjectUpdate() {

		UITestCommon.openView(getBot(), "Unicase", "Navigator");
		/*
		 * try { //getProjectSpace().importLocalChanges(
		 * "/user/naguib/Documents/workspaces-UItesting13oct/devloper/SampleProjects/SupermarketExampleProject.ucp"); }
		 * catch (IOException e) { }
		 */

		getBot().sleep(100000);

	}
}