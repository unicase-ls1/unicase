package org.unicase.link.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import org.eclipse.jface.dialogs.MessageDialog;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.emfstore.esmodel.ProjectId;


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
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		UnicaseModelElement me = ActionHelper.getModelElement(event);
		ActionHelper.getProjectSpace(event);
		String meName = me.getName();
		String meId = me.getModelElementId().getId();
		me.getProject();
		ProjectSpace ps = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();
		String projectId = ps.getProjectId().getId();
		String projectName = ps.getProjectName();
		
		String link = "unicase://" + "localhost:2001/" + projectName + "%" + projectId + "/" + meName + "%" + meId;
				
		MessageDialog.openInformation(
				window.getShell(),
				"Link",
				link);
		return null;
	}
}
