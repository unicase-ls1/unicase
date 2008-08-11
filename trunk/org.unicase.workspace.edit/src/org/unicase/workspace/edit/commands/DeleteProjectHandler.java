package org.unicase.workspace.edit.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

public class DeleteProjectHandler extends ProjectActionHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ProjectSpace projectSpace = getProjectSpace(event);
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder
						.append("Do you really want to delete your local copy of project \"");
				stringBuilder.append(projectSpace.getProjectName());
				stringBuilder.append("\"");
				if (projectSpace.getBaseVersion() != null) {
					stringBuilder.append(" in version ");
					stringBuilder.append(projectSpace.getBaseVersion()
							.getIdentifier());
				}
				stringBuilder.append(".");
				String message = stringBuilder.toString();

				MessageDialog dialog = new MessageDialog(null, "Confirmation",
						null, message, MessageDialog.QUESTION, new String[] {
								"Yes", "No" }, 0);
				int result = dialog.open();
				if (result == 0) {

					Workspace currentWorkspace = WorkspaceManager.getInstance()
							.getCurrentWorkspace();
					currentWorkspace.getProjectSpaces().remove(projectSpace);
					currentWorkspace.save();
					
					//MK: also delete file
				}
			}
		});
		
		//ZH: a workaround fix for update problem in navigator
		//basically in should have been updated.
		((TreeViewer)HandlerUtil.getActivePart(event).getSite().getSelectionProvider()).refresh();
	
		return null;
	}

}
