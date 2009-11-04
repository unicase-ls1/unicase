package org.unicase.link.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.model.UnicaseModelElement;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.WorkspaceManager;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 *  
 * @author svetlana
 */
public class UnicaseLinkHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public UnicaseLinkHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		int port = 1099; // default port
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		UnicaseModelElement me = ActionHelper.getModelElement(event);
		String meName = me.getName();
		String meId = me.getModelElementId().getId();
		ProjectSpace ps = WorkspaceManager.getInstance().getCurrentWorkspace()
			.getActiveProjectSpace();
		String projectId = ps.getProjectId().getId();
		String projectName = ps.getProjectName();
		
		EList<ServerInfo> servers = WorkspaceManager.getInstance()
			.getCurrentWorkspace().getServerInfos();
		
		if (servers.size() > 0) {
			for (ServerInfo server : servers) {
				if (server.getUrl().equalsIgnoreCase("localhost")) {
					port = server.getPort();
				}
			}
		}
		
		String link = "unicase://" + "localhost:" + port + "/" + projectName + "%" 
			+ projectId + "/" + meName + "%" + meId;
				
		MessageDialog.openInformation(
				window.getShell(),
				"Link",
				link);
		
		return null;
	}
}
