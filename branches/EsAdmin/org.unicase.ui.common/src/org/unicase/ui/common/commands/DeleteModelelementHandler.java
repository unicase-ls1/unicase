package org.unicase.ui.common.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.unicase.model.ModelElement;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

public class DeleteModelelementHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ModelElement me = ActionHelper.getModelElement(event);
		if (me != null) {
			deleteModelElement(me);
		}
		return null;
	}

	private void deleteModelElement(final ModelElement me) {
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {
				MessageDialog dialog = new MessageDialog(null, "Confirmation",
						null, "Do you really want to delete " + me.getName(),
						MessageDialog.QUESTION, new String[] { "Yes", "No" }, 0);
				int result = dialog.open();
				if (result == 0) {
					ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(me);
					EcoreUtil.delete(me, true);
					projectSpace.save();
				}
			}
		});

	}

}
