/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.navigator;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Test;
import org.unicase.metamodel.Project;
import org.unicase.ui.test.UITestCommon;
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Class to test if a project is deleted correctly in UNICASE or not.
 */
public class DeleteProjectUITest extends MEEditorTest {
	private Project newproject;
	private boolean testcondition = true;

	/**
	 * This method first deletes project programticaly and check if it was deleted correctly in the UNICSAE Navigator
	 * UI.
	 */
	@Test
	public void deleteProjectUpdate() {

		UITestCommon.openPerspective(getBot(), "Unicase");

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
				try {
					currentWorkspace.deleteProjectSpace(getProjectSpace());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.run();

		UITestCommon.openView(getBot(), "Unicase", "Unicase Navigator");

		SWTBotTreeItem[] treenode = getBot().activeView().bot().tree().getAllItems();
		testcondition = treenode.length == 0;
		assertTrue(testcondition);

	}

	/**
	 * This method first deletes a project using the UNICSAE Navigator UI and check it was updated in the project
	 * workspace or not.
	 */

	@Test
	public void deleteProjectChange() {

		UITestCommon.openView(getBot(), "Unicase", "Unicase Navigator");
		SWTBotTreeItem[] treenode = getBot().activeView().bot().tree().getAllItems();
		treenode[0].select().contextMenu("Delete Project").click();
		getBot().button("Yes").click();

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
				if (currentWorkspace.getActiveProjectSpace() != null) {
					assertTrue(false);
				} else {
					assertTrue(getProjectSpace().getProject() == null);

				}

				// if(getProjectSpace().getProject()==null){ this dosen't work for some reason :(
				// assertTrue(true);}
				// else{assertTrue(false);}

			}

		}.run();

	}

	/**
	 * @param newproject is used as test project for testing the new project creation functionality This method is a
	 *            setter method for the variable newproject.
	 */

	public void setNewproject(Project newproject) {
		this.newproject = newproject;
	}

	/**
	 * getter method for the variable newproject.
	 * 
	 * @return returns the reference of the variable newproject
	 */
	public Project getNewproject() {
		return newproject;
	}
}
