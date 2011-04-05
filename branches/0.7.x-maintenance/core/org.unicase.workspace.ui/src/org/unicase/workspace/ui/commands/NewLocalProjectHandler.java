/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;
import org.unicase.workspace.ui.views.emfstorebrowser.views.CreateProjectDialog;

/**
 * This is a handler for new local project command. It shows new project dialog
 * and the user can create a new project with out being logged in to server.
 * 
 * @author hodaie
 * 
 */
public class NewLocalProjectHandler extends AbstractHandler {

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		CreateProjectDialog dialog = new CreateProjectDialog(PlatformUI
				.getWorkbench().getDisplay().getActiveShell(), null);

		dialog.open();

		return null;
	}

}
