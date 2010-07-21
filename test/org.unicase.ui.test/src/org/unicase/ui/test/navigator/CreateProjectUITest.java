/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.navigator;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Before;
import org.junit.Test;
import org.unicase.metamodel.Project;
import org.unicase.ui.test.UITestCommon;
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Class to test if a project is created correctly in UNICASE or not.
 */

public class CreateProjectUITest extends MEEditorTest {
	private Project newproject;

	/**
	 * Setup the environment for testing.
	 */
	@Before
	public void setupActionItem() {

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
	}

	/**
	 * This method first creates a project programticaly and check if it appears in the UNICSAE Navigator UI or not.
	 */

	@Test
	public void createProjectUpdate() {

		UITestCommon.openPerspective(getBot(), "Unicase");

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
				ProjectSpace projectSpace = currentWorkspace.createLocalProject("CreateProjectTest",
					"Test project description");
				setNewproject(projectSpace.getProject());

			}
		}.run();

		UITestCommon.openView(getBot(), "Unicase", "Unicase Navigator");

		SWTBotTreeItem[] text = getBot().activeView().bot().tree().getAllItems();
		assertTrue(text[0].getText().startsWith("CreateProjectTest"));

	}

	/**
	 * This method first creates a project through out the UNICSAE Navigator UI and check if it was created in the user
	 * local workspace or not.
	 */

	@Test
	public void createProjectChange() {

		UITestCommon.openView(getBot(), "Unicase", "Unicase Navigator");

		getBot().sleep(4000);

		getBot().activeView().bot().tree().contextMenu("Other...").menu("New Project...").click();

		getBot().textWithLabel("Name:").typeText("testproject");
		getBot().button("OK").click();
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				String projectName = getProjectSpace().getProjectName();
				assertTrue(projectName.toLowerCase().startsWith("testproject"));
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
