/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.ModelElement;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * A super class to handle all requests made to the server that require a RecordingCommand.
 * 
 * @author Shterev
 */
public abstract class ServerRequestCommandHandler extends ServerRequestHandler {

	private ModelElement modelElement;
	private ProjectSpace projectSpace;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		this.setEvent(event);

		// caching the modelelement, because the event loses parts of its context.
		setModelElement(ActionHelper.getModelElement(event));
		setProjectSpace(ActionHelper.getProjectSpace(event));
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				try {
					handleRun();
				} catch (ExecutionException e) {
					DialogHandler.showExceptionDialog(e);
					WorkspaceUtil.logException("Exception during login", e);
				}
			}
		});
		return null;
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
	public ModelElement getModelElement() {
		return modelElement;
	}

	/**
	 * Setter for the modelElement.
	 * 
	 * @param modelElement the modelElement.
	 */
	private void setModelElement(ModelElement modelElement) {
		this.modelElement = modelElement;
	}
}
