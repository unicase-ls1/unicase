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

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.Workspace;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.observers.DeleteProjectSpaceObserver;
import org.eclipse.emf.emfstore.client.model.util.UnicaseCommand;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.unicase.ui.util.ActionHelper;
import org.unicase.ui.util.DialogHandler;

/**
 * Handler for delete project menu item.
 * 
 * @author koegel
 */
public class DeleteProjectHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ProjectSpace projectSpace = ActionHelper.getEventElementByClass(event, ProjectSpace.class);
		if (projectSpace == null) {
			return null;
		}
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				deleteProjectSpace(projectSpace);
			}
		}.run();
		return null;
	}

	private void deleteProjectSpace(final ProjectSpace projectSpace) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Do you really want to delete your local copy of project \"");
		stringBuilder.append(projectSpace.getProjectName());
		stringBuilder.append("\"");
		if (projectSpace.getBaseVersion() != null) {
			stringBuilder.append(" in version ");
			stringBuilder.append(projectSpace.getBaseVersion().getIdentifier());
		}
		stringBuilder.append("?");
		String message = stringBuilder.toString();

		MessageDialog dialog = new MessageDialog(null, "Confirmation", null, message, MessageDialog.QUESTION,
			new String[] { "Yes", "No" }, 0);
		int result = dialog.open();
		if (result == 0) {

			Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();

			// notify all registered listeners

			IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
				"org.unicase.ui.common.notify.deleteprojectspace");

			for (IConfigurationElement e : config) {
				try {
					DeleteProjectSpaceObserver o = (DeleteProjectSpaceObserver) e.createExecutableExtension("class");
					o.projectDeleted(projectSpace);
				} catch (CoreException e1) {
					WorkspaceUtil.logException("Cannot instantiate extension!", e1);
				}
			}

			try {
				currentWorkspace.deleteProjectSpace(projectSpace);
			} catch (IOException e) {
				DialogHandler.showExceptionDialog("Couldn't delete project files in file system.", e);
			}

		}
	}
}
