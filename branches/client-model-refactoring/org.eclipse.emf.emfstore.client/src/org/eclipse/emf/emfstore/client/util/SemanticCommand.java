/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.util;

import org.eclipse.emf.emfstore.client.Workspace;
import org.eclipse.emf.emfstore.client.WorkspaceManager;
import org.eclipse.emf.emfstore.client.changeTracking.CompositeOperationHandle;
import org.eclipse.emf.emfstore.client.core.ProjectSpaceControllerInternal;
import org.eclipse.emf.emfstore.client.core.ProjectSpaceInternal;
import org.eclipse.emf.emfstore.client.exceptions.InvalidHandleException;
import org.eclipse.emf.emfstore.client.exceptions.UnkownProjectException;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.SemanticCompositeOperation;

/**
 * Command for executing semantic operations on a project.
 * 
 * @author koegel
 */
public class SemanticCommand extends EMFStoreCommand {

	private final Project project;
	private final SemanticCompositeOperation semanticOperation;

	/**
	 * Constructor.
	 * 
	 * @param project
	 *            the project to run the operation on.
	 * @param semanticOpertation
	 *            the operation to execute.
	 */
	public SemanticCommand(Project project,
			SemanticCompositeOperation semanticOpertation) {
		if (semanticOpertation.getName() == null
				|| semanticOpertation.getDescription() == null
				|| semanticOpertation.getModelElementId() == null) {
			throw new IllegalArgumentException(
					"Name, description or modelElementId are not set!");
		}
		this.project = project;
		this.semanticOperation = semanticOpertation;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.util.EMFStoreCommand#doRun()
	 */
	@Override
	protected void doRun() {
		Workspace currentWorkspace = WorkspaceManager.getInstance()
				.getCurrentWorkspace();
		try {
			ProjectSpaceInternal projectSpace = (ProjectSpaceInternal) currentWorkspace
					.getProjectSpace(project);
			CompositeOperationHandle handle = ((ProjectSpaceControllerInternal) projectSpace)
					.createCompositeOperation();
			semanticOperation.semanticApply(project);
			try {
				handle.end(semanticOperation);
			} catch (InvalidHandleException e) {
				WorkspaceUtil
						.logException(
								"Semantic command failed because of illegal state of composite operation handle!",
								e);
			}

		} catch (UnkownProjectException e) {
			// project is not in a projectspace, just execute operation
			semanticOperation.semanticApply(project);
			return;
		}

	}
}
