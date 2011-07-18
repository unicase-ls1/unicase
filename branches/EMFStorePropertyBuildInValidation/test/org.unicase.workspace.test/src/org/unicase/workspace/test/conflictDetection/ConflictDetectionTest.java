/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.conflictDetection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.unicase.emfstore.conflictDetection.ConflictDetectionStrategy;
import org.unicase.emfstore.conflictDetection.IndexSensitiveConflictDetectionStrategy;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
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
	 * Clones a project space including the project.
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
		}.run(false);
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

	/**
	 * Convenience to get an operation by type.
	 * 
	 * @param clazz class of operation
	 * @return operation
	 */
	protected AbstractOperation checkAndGetOperation(Class<? extends AbstractOperation> clazz) {
		assertEquals(getProjectSpace().getOperations().size(), 1);
		assertTrue(clazz.isInstance(getProjectSpace().getOperations().get(0)));
		AbstractOperation operation = getProjectSpace().getOperations().get(0);
		clearOperations();
		assertEquals(getProjectSpace().getOperations().size(), 0);
		return operation;
	}

	/**
	 * Convenience method for conflict detection.
	 * 
	 * @param opA operation
	 * @param opB operation
	 * @return boolean
	 */
	protected boolean doConflict(AbstractOperation opA, AbstractOperation opB) {
		return getConflictDetectionStrategy().doConflict(opB, opA);
	}
}
