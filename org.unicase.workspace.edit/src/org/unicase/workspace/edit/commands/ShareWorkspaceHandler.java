package org.unicase.workspace.edit.commands;

import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

public class ShareWorkspaceHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof ProjectSpace) {
			ProjectSpace projectSpace = (ProjectSpace) selection;

			ElementListSelectionDialog dlg = new ElementListSelectionDialog(
					PlatformUI.getWorkbench().getActiveWorkbenchWindow()
							.getShell(),
					new AdapterFactoryLabelProvider(
							new ComposedAdapterFactory(
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
					projectSpace.setUsersession(usersession);
				}
			}
		}
		return null;
	}

}
