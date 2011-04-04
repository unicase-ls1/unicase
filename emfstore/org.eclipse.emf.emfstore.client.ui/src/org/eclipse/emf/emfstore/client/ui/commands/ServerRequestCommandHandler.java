/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.util.DialogHandler;
import org.eclipse.emf.ecp.common.util.UiUtil;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommandWithResult;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;

/**
 * A super class to handle all requests made to the server that require a RecordingCommand.
 * 
 * @author Shterev
 */
public abstract class ServerRequestCommandHandler extends ServerRequestHandler {

	private EObject modelElement;
	private ProjectSpace projectSpace;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		this.setEvent(event);

		// caching the modelelement, because the event loses parts of its
		// context.
		setModelElement(UiUtil.getModelElement(event));
		setProjectSpace(UiUtil.getEventElementByClass(event, ProjectSpace.class));
		final EMFStoreCommandWithResult<Object> command = new EMFStoreCommandWithResult<Object>() {

			@Override
			protected Object doRun() {
				try {
					return handleRun();
				} catch (ExecutionException e) {
					DialogHandler.showExceptionDialog(e);
					WorkspaceUtil.logWarning("Exception during login", e);
					return null;
				}
			}
		};
		return command.run(false);
	}

	private void setProjectSpace(ProjectSpace projectSpace) {
		this.projectSpace = projectSpace;

	}

	/**
	 * @return the modelelement that is in the context of the handler's execution event. It's a cached value in case the
	 *         event gets modified.
	 */
	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}

	/**
	 * @return the modelelement that is in the context of the handler's execution event. It's a cached value in case the
	 *         event gets modified.
	 */
	public EObject getModelElement() {
		return modelElement;
	}

	/**
	 * Setter for the modelElement.
	 * 
	 * @param modelElement the modelElement.
	 */
	private void setModelElement(EObject modelElement) {
		this.modelElement = modelElement;
	}
}
