package org.unicase.codetrace.team.ui.action;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.team.core.RepositoryProvider;
import org.eclipse.team.internal.ui.actions.TeamAction;
import org.eclipse.ui.PlatformUI;
import org.unicase.codetrace.team.adapter.TeamAdapterFactory;
import org.unicase.codetrace.team.commands.AttachPatchCommand;
import org.unicase.codetrace.team.exported.AbstractTeamAdapter;
import org.unicase.codetrace.team.exported.CodetraceTeamException;
import org.unicase.codetrace.team.exported.UIUtil;
import org.unicase.codetrace.team.ui.wizards.AttacheeSelectionDialog;

import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;

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
			MessageDialog.openError(
					PlatformUI.getWorkbench().
					getActiveWorkbenchWindow().getShell(),
					"Error",
					"No project selected!");
			return;

		}
		
		//Get repo provider
		RepositoryProvider provider = RepositoryProvider.getProvider(ps[0]);
		AbstractTeamAdapter adapter = TeamAdapterFactory.getInstance().getAdapter(provider.getID());
		
		//Wizard 
		//TODO: Replace the dialog with a wizard with the missing features
		//Get unicase project
		Project p = UIUtil.getActiveProject();
		
		//None projet active? Fail (for the moment)
		if(p==null){
			MessageDialog.openError(
					PlatformUI.getWorkbench().
					getActiveWorkbenchWindow().getShell(),
					"Error",
					"No unicase project active. Activate (open) a unicase project first.");
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
			MessageDialog.openError(
					PlatformUI.getWorkbench().
					getActiveWorkbenchWindow().getShell(),
					"Error",
					"No model element selected!");
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

}
