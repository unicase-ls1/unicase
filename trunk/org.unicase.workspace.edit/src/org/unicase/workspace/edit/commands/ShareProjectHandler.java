package org.unicase.workspace.edit.commands;

import java.util.Collection;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.ExceptionDialogHandler;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.edit.dialogs.LoginDialog;

public class ShareProjectHandler extends ProjectActionHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {

		final ProjectSpace projectSpace = (ProjectSpace) getProjectSpace(event);
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {
				// TODO: handle exception
				try {
					createProject(projectSpace);
				} catch (RuntimeException e) {
					ExceptionDialogHandler.showExceptionDialog(e);
					throw e;
				}
			}
		});
		return null;
	}

	/**
	 * @param projectSpace
	 */
	private void createProject(ProjectSpace projectSpace) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		ElementListSelectionDialog dlg = new ElementListSelectionDialog(shell, new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		Collection<Usersession> allSessions = currentWorkspace.getUsersessions();
		dlg.setElements(allSessions.toArray());
		dlg.setTitle("Select Usersession");
		dlg.setBlockOnOpen(true);
		if (dlg.open() == Window.OK) {
			Object result = dlg.getFirstResult();
			if (result instanceof Usersession) {
				Usersession usersession = (Usersession) result;
				LoginDialog login;
				// initially setting the status as successful in case the user
				// is already logged in
				int loginStatus = LoginDialog.SUCCESSFUL;
				if (!usersession.isLoggedIn()) {
					login = new LoginDialog(shell, usersession);
					login.open();
					loginStatus = login.getStatus();
				}
				if (loginStatus == LoginDialog.SUCCESSFUL) {
					try {
						projectSpace.shareProject(usersession);
						MessageDialog.openInformation(shell, null, "Your project was successfully shared!");
					} catch (EmfStoreException e) {
						ExceptionDialogHandler.showExceptionDialog(e);
					}
				}
			}
		}
	}

}
