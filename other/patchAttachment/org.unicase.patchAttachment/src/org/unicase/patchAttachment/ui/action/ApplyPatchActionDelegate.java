package org.unicase.patchAttachment.ui.action;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.team.internal.ui.actions.TeamAction;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.patchAttachment.PatchAttachment;
import org.unicase.patchAttachment.applyPatch.BasicApplyPatchMethod;

/**
 * Kann geloescht werden :)
 * @author jfinis
 *
 */
public class ApplyPatchActionDelegate extends TeamAction{
	
	public ApplyPatchActionDelegate(){
	
	}

	@SuppressWarnings("restriction")
	@Override
	protected void execute(IAction action) throws InvocationTargetException,
			InterruptedException {
		//Get selected resources
		IResource[] res = getSelectedResources();
		
		//None selected -> fail
		if(res.length==0){
			MessageDialog.openError(
					PlatformUI.getWorkbench().
					getActiveWorkbenchWindow().getShell(),
					"Error",
					"No resource selected!");
			return;

		}
		//ResourcesPlugin.getWorkspace().getRoot();
		
		
		new BasicApplyPatchMethod().applyPatch((IFile)res[0],null);
	}
	

	protected boolean needsToSaveDirtyEditors() {
		return true;
	}

}
