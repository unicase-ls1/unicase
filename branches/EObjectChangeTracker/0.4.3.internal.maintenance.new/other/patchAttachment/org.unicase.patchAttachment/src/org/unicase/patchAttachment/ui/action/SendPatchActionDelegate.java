package org.unicase.patchAttachment.ui.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.team.core.RepositoryProvider;
import org.eclipse.team.internal.ui.actions.TeamAction;
import org.eclipse.ui.PlatformUI;

import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.patchAttachment.adapter.TeamAdapterFactory;
import org.unicase.patchAttachment.commands.AttachPatchCommand;
import org.unicase.patchAttachment.exported.AbstractTeamAdapter;
import org.unicase.patchAttachment.exported.PatchAttachmentException;
import org.unicase.patchAttachment.exported.UIUtil;
import org.unicase.patchAttachment.ui.wizards.AttacheeSelectionDialog;
import org.unicase.ui.meeditor.Activator;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MELinkControl;
import org.unicase.workspace.util.WorkspaceUtil;

public class SendPatchActionDelegate extends TeamAction{

	@SuppressWarnings("restriction")
	@Override
	protected void execute(IAction action) throws InvocationTargetException,
			InterruptedException {
		//Get selected projects
		IProject[] ps = getSelectedProjects();
		
		IResource[] res = getSelectedResources();
	
	
		//None selected -> fail
		if(ps.length==0){
			error("No project selected!");
			return;

		}
		
		//Get repo provider
		RepositoryProvider provider = RepositoryProvider.getProvider(ps[0]);
		if(provider == null){
			error("No repository Provider was attached to the selected project. Your project must be shared to send patches to unicase.");
			return;
		}
		AbstractTeamAdapter adapter = TeamAdapterFactory.getInstance().getAdapter(provider.getID());
		if(adapter == null){
			error("No team adapter found for the repository provider with the followig id:\n" + provider.getID() +
					"\nPlease install the appropriate team adapter for this repository provider.");
			return;
		}
		
		
		//Wizard 
		//TODO: Replace the dialog with a wizard with the missing features
		//Get unicase project
		Project p = UIUtil.getActiveProject();
		
		//None projet active? Fail (for the moment)
		if(p==null){
			error("No unicase project active. Activate (open) a unicase project first.");
			return;
		}
		
		AttacheeSelectionDialog dialog = new AttacheeSelectionDialog(p);
		dialog.setBlockOnOpen(true);
		int result = dialog.open();
		if(result != Window.OK){
			return;
		}
		Object selection = dialog.getFirstResult();
		if(selection == null){
			error("No model element selected!");
			return;
		}
		if(!(selection instanceof UnicaseModelElement)) throw new RuntimeException("Selection is no unicase model element");
		UnicaseModelElement selectedElement = (UnicaseModelElement) selection;
	
		//Do it!
		new AttachPatchCommand(selectedElement, res, adapter).run();
	
	}
	

	protected boolean needsToSaveDirtyEditors() {
		return true;
	}

	private void error(String message){
		MessageDialog.openError(
				PlatformUI.getWorkbench().
				getActiveWorkbenchWindow().getShell(),
				"Error",
				message);
	}
}
