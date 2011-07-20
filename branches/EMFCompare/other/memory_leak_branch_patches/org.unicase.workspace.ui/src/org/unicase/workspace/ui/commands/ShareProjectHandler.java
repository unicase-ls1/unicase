/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.commands;

import java.util.Collection;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.util.DialogHandler;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.WorkspaceUtil;

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

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
		ElementListSelectionDialog dlg = new ElementListSelectionDialog(shell, labelProvider);
		Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		Collection<Usersession> allSessions = currentWorkspace.getUsersessions();
		dlg.setElements(allSessions.toArray());
		dlg.setTitle("Select Usersession");
		dlg.setBlockOnOpen(true);
		if (dlg.open() == Window.OK) {
			Object result = dlg.getFirstResult();
			if (result instanceof Usersession) {
				setUsersession((Usersession) result);
			}
		}
		adapterFactory.dispose();
		labelProvider.dispose();
		dlg.close();
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
			WorkspaceUtil.logWarning("RuntimeException in " + ShareProjectHandler.class.getName(), e);
			// throw e;
		}
		// END SUPRESS CATCH EXCEPTION
		return null;
	}

	/**
	 * @param projectSpace
	 * @throws EmfStoreException
	 */
	private void createProject(ProjectSpace projectSpace) throws EmfStoreException {
		projectSpace.shareProject(getUsersession());
		MessageDialog.openInformation(getShell(), null, "Your project was successfully shared!");
	}

}
