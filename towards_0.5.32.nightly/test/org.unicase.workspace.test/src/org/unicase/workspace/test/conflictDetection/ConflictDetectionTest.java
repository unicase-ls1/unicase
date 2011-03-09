/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.conflictDetection;

import org.unicase.emfstore.conflictDetection.ConflictDetectionStrategy;
import org.unicase.emfstore.conflictDetection.IndexSensitiveConflictDetectionStrategy;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.test.WorkspaceTest;
import org.unicase.workspace.util.UnicaseCommandWithResult;

/**
 * Abstract super class for operation tests, contains setup.
 * 
 * @author chodnick
 */
public abstract class ConflictDetectionTest extends WorkspaceTest {

	/**
	 * Clones a project pace including the project.
	 * 
	 * @param ps the projectspace to clone
	 * @return the new projectspace
	 */
	public ProjectSpace cloneProjectSpace(final ProjectSpace ps) {

		final Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		ProjectSpace result = new UnicaseCommandWithResult<ProjectSpace>() {
			@Override
			protected ProjectSpace doRun() {
				Project clonedProject = ModelUtil.clone(ps.getProject());
				return workspace.importProject(clonedProject, "clonedProject", "cloned Project");
			}
		}.run();
		return result;
	}

	/**
	 * Returns a conflict detection strategy to use.
	 * 
	 * @return a conflict detection strategy
	 */

	public ConflictDetectionStrategy getConflictDetectionStrategy() {
		return new IndexSensitiveConflictDetectionStrategy();
	}
}