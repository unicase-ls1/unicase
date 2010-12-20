package org.unicase.xmi.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.unicase.ui.util.ActionHelper;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.xmi.exceptions.XMIWorkspaceException;
import org.unicase.xmi.workspace.XMIECPWorkspace;
import org.unicase.xmi.xmiworkspacestructure.impl.XMIECPFolderImpl;

public class DeleteFolderHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		final XMIECPFolderImpl dir = ActionHelper.getEventElementByClass(event, XMIECPFolderImpl.class);
		if (dir == null) {
			new XMIWorkspaceException("Event not associated with a folder.");
			return null;
		}
		
		// Do you really want to delete the folder(-representation)?
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Do you really want to delete \"");
		stringBuilder.append(dir.getContainerName());
		stringBuilder.append("\"?");
		String message = stringBuilder.toString();
		MessageDialog dialog = new MessageDialog(null, "Confirmation", null, message, MessageDialog.QUESTION,
			new String[] { "Yes", "No" }, 0);
		int result = dialog.open();
		// check whether the user clicked "yes", otherwise do nothing
		if(result == 0) {
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					XMIECPWorkspace ws = (XMIECPWorkspace) dir.getWorkspace();
					ws.removeFolder(dir); // takes care of removal
				}
			}.run();
		}
		return null;
	}

}
