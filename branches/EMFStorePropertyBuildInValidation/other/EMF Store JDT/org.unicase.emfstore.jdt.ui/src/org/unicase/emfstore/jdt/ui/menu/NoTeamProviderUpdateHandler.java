/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.ui.menu;

import java.util.Collection;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.jdt.eclipseworkspace.emfstore.EMFStoreUtil;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ui.commands.UpdateProjectHandler;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Handler to update manually a ProjectSpace for an managed file if no supported team provider is present.
 * 
 * @author Adrian Staudt
 */
public class NoTeamProviderUpdateHandler extends AbstractNoTeamProviderHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
		Object[] selectedObjects = selection.toArray();

		Collection<IFile> selectedFiles = getSelectedIFiles(selectedObjects);
		Collection<ProjectSpace> projectSpaces = getProjectSpaces(selectedFiles);

		new UpdateUnicaseCommand(projectSpaces).run(false);

		// after commit, update decorator
		for (IFile file : selectedFiles) {
			refreshUI(file);
		}

		return null;
	}

	/**
	 * Updates a set of ProjectSpaces to the latest version into a transaction.
	 */
	private static class UpdateUnicaseCommand extends UnicaseCommand {

		private final Collection<ProjectSpace> projectSpaces;

		public UpdateUnicaseCommand(Collection<ProjectSpace> projectSpaces) {
			this.projectSpaces = projectSpaces;
		}

		@Override
		protected void doRun() {
			// check that all usersessions are valid
			for (ProjectSpace projectSpace : projectSpaces) {
				EMFStoreUtil.checkSanity(projectSpace.getUsersession());
			}

			for (ProjectSpace projectSpace : projectSpaces) {
				// try to update
				try {
					UpdateProjectHandler handler = new UpdateProjectHandler();
					handler.update(projectSpace);

				} catch (EmfStoreException e) {
					ModelUtil.logException(e);
				}
			}
		}
	}

}
