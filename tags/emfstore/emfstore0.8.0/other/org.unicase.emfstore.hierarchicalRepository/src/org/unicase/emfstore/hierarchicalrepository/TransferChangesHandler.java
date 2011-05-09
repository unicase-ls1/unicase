package org.unicase.emfstore.hierarchicalrepository;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.ui.commands.ServerRequestCommandHandler;

public class TransferChangesHandler extends ServerRequestCommandHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object run() throws EmfStoreException {

		// show compare dialog
		ProjectSpace projSpace = WorkspaceManager.getInstance()
		.getCurrentWorkspace().getActiveProjectSpace();

		TransferChangesDialog compareDialog = new TransferChangesDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), projSpace);
		compareDialog.create();
		compareDialog.open();
		return null;
	}

}
