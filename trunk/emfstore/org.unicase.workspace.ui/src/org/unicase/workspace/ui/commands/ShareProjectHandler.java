/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.commands;

import java.util.Collection;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.emfstore.client.ProjectSpace;
import org.eclipse.emf.emfstore.client.Usersession;
import org.eclipse.emf.emfstore.client.Workspace;
import org.eclipse.emf.emfstore.client.WorkspaceManager;
import org.eclipse.emf.emfstore.client.util.WorkspaceUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.util.DialogHandler;

/**
 * Share a project with the server.
 * 
 * @author koegel
 */
public class ShareProjectHandler extends ServerRequestCommandHandler {

	/**
	 * Default constructor.
	 */
	public ShareProjectHandler() {
		setTaskTitle("Sharing project...");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ui.commands.ServerRequestHandler#initUsersession()
	 */
	@Override
	protected void initUsersession() {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell();
		ElementListSelectionDialog dlg = new ElementListSelectionDialog(shell,
				new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		Workspace currentWorkspace = WorkspaceManager.getInstance()
				.getCurrentWorkspace();
		Collection<Usersession> allSessions = currentWorkspace
				.getUsersessions();
		dlg.setElements(allSessions.toArray());
		dlg.setTitle("Select Usersession");
		dlg.setBlockOnOpen(true);
		if (dlg.open() == Window.OK) {
			Object result = dlg.getFirstResult();
			if (result instanceof Usersession) {
				setUsersession((Usersession) result);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	protected Object run() throws EmfStoreException {
		final ProjectSpace projectSpace = getProjectSpace();
		try {
			createProject(projectSpace);
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (RuntimeException e) {
			DialogHandler.showExceptionDialog(e);
			WorkspaceUtil.logWarning("RuntimeException in "
					+ ShareProjectHandler.class.getName(), e);
			// throw e;
		}
		// END SUPRESS CATCH EXCEPTION
		return null;
	}

	/**
	 * @param projectSpace
	 * @throws EmfStoreException
	 */
	private void createProject(ProjectSpace projectSpace)
			throws EmfStoreException {
		projectSpace.shareProject(getUsersession());
		MessageDialog.openInformation(getShell(), null,
				"Your project was successfully shared!");
	}

}
