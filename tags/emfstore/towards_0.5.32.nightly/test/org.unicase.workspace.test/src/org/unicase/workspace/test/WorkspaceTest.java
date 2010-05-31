/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.test;

import org.junit.After;
import org.junit.Before;
import org.unicase.metamodel.Project;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Abstract Superclass for WOrkspace Tests. Provides Setup and Tear-down.
 * 
 * @author koegel
 */
public abstract class WorkspaceTest {
	private Project project;
	private ProjectSpace projectSpace;

	/**
	 * Setup a dummy project for testing.
	 */
	@Before
	public void setupProjectSpace() {
		Configuration.setTesting(true);
		final Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		new UnicaseCommand() {

			@Override
			protected void doRun() {

				ProjectSpace localProject = workspace.createLocalProject("testProject", "test Project");
				setProjectSpace(localProject);
				setProject(getProjectSpace().getProject());
			}
		}.run();

	}

	/**
	 * Clean workspace.
	 */
	@After
	public void cleanProjectSpace() {
		SetupHelper.cleanupWorkspace();
	}

	/**
	 * @param project the project to set
	 */
	private void setProject(Project project) {
		this.project = project;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param projectSpace the projectSpace to set
	 */
	private void setProjectSpace(ProjectSpace projectSpace) {
		this.projectSpace = projectSpace;
	}

	/**
	 * @return the projectSpace
	 */
	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}

	/**
	 * Clear all operations from project space.
	 */
	protected void clearOperations() {
		getProjectSpace().getOperations().clear();
	}
}
