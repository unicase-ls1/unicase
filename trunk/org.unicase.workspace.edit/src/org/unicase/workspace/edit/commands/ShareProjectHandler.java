package org.unicase.workspace.edit.commands;

import java.util.Collection;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.ExceptionDialogHandler;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

public class ShareProjectHandler extends ProjectActionHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {

		final ProjectSpace projectSpace = (ProjectSpace) getProjectSpace(event);
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
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
		ElementListSelectionDialog dlg = new ElementListSelectionDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
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
				Usersession usersession = (Usersession) result;
				try {
					projectSpace.shareProject(usersession);
				} catch (EmfStoreException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e) {
					ExceptionDialogHandler.showExceptionDialog(e);
				}
			}
		}
	}

}
