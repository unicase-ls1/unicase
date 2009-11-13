package org.unicase.link.handlers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import org.eclipse.jface.dialogs.MessageDialog;


import org.unicase.ui.common.util.ActionHelper;
import org.unicase.model.UnicaseModelElement;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.WorkspaceManager;


/**
 * This handler handles "create unicase link" button click events. 
 * It generates an UNICASE url link to the model element
 * currently shown in the MEEditor
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
		
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		UnicaseModelElement me = ActionHelper.getModelElement(event);
		//remove spaces from the model element name
		String meName = me.getName().replaceAll(" ", "");;				
		String meId = me.getModelElementId().getId();
		
		ProjectSpace ps = WorkspaceManager.getInstance().getCurrentWorkspace()
			.getActiveProjectSpace();
				
		//remove spaces from the project name
		String projectName = ps.getProjectName().replaceAll(" ", "");;
		String projectId = ps.getProjectId().getId();
				
		String serverUrl  = ps.getUsersession().getServerInfo().getUrl();
		int serverPort = ps.getUsersession().getServerInfo().getPort();
		
		String link = "unicase://" + serverUrl + ":" + serverPort + "/" + projectName + "%" 
			+ projectId + "/" + meName + "%" + meId;

		//place the link on the system clipboard
		StringSelection stringSelection = new StringSelection(link);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents( stringSelection, stringSelection);

		
		MessageDialog.openInformation(
				window.getShell(),
				"Link",
				link);
		
		return null;
	}
}
