/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.diagram.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.unicase.ui.common.commands.DeleteModelElementCommand;

/**
 * Command to remove a diagram element from the project's model.
 * 
 * @author denglerm
 */
public class DeleteFromModelCommand extends DestroyElementCommand {

	/**
	 * Constructs a new command to delete the model behind a diagram element.
	 * 
	 * @param request the destroy element request
	 */
	public DeleteFromModelCommand(DestroyElementRequest request) {
		super(request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		new DeleteModelElementCommand(getElementToDestroy()).run();
		return CommandResult.newOKCommandResult();
	}

}
