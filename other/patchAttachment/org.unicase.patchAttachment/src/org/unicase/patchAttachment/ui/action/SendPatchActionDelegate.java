package org.unicase.patchAttachment.ui.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.team.core.RepositoryProvider;
import org.eclipse.team.internal.ui.actions.TeamAction;
import org.eclipse.ui.PlatformUI;

import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.patchAttachment.adapter.TeamAdapterRegistry;
import org.unicase.patchAttachment.commands.AttachPatchCommand;
import org.unicase.patchAttachment.exported.AbstractTeamAdapter;
import org.unicase.patchAttachment.exported.PatchAttachmentException;
import org.unicase.patchAttachment.exported.UIUtil;
import org.unicase.patchAttachment.ui.wizards.AttacheeSelectionDialog;
import org.unicase.ui.common.dialogs.ModelElementSelectionDialog;
import org.unicase.ui.common.dialogs.ModelElementSelectionDialog.ModelElementFilter;
import org.unicase.ui.meeditor.Activator;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MELinkControl;
import org.unicase.ui.navigatormeeditorbridge.NavigatorModelelementContex;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.util.UnicaseCommand;
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
		AbstractTeamAdapter adapter = TeamAdapterRegistry.getInstance().getAdapter(provider.getID());
		if(adapter == null){
			error("No team adapter found for the repository provider with the followig id:\n" + provider.getID() +
					"\nPlease install the appropriate team adapter for this repository provider.");
			return;
		}
		
		
		boolean noProjects = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces().isEmpty();
		
		//None project exists? Fail!
		if(noProjects){
			error("You do not have any unicase project checked out. Check out or create a unicase project first.");
			return;
		}
		
		AttacheeSelectionDialog dialog = new AttacheeSelectionDialog();
		dialog.setBlockOnOpen(true);
		int result = dialog.open();
		if(result != Window.OK){
			return;
		}
		final WorkItem selection = dialog.getSelectedWorkItem();
		if(selection == null){
			error("No model element selected!");
			return;
		}
		
		final ProjectSpace selectedProjectSpace = dialog.getSelectedProjectSpace();
		final Project selectedProject = selectedProjectSpace.getProject();
		
		//Check that the selected project space is shared. Otherwise, files (patches) cannot be attached.
		if(selectedProjectSpace.getProjectId() == null){
			error("The selected project is not shared. You must share your project before you can attach patches.");
			return;
		}
		
		//If the user wants to create a new model element, let him specify the destination for that item.
		if(dialog.elementIsCreateEntry(selection)){
			final String newTypeName = selection.eClass().getName();
			//Has the project a work package? If not we cannot create a new work item
			int numPackages = selectedProject.getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkPackage(),new BasicEList<WorkPackage>(),true).size();
			if(numPackages == 0){
				error("You have selected to create a new " + newTypeName + ", but the project you selected has no work package into which the newly created " + newTypeName + " could be inserted. Create a work package in the project and try again.");
				return;
			}
			
			
			ModelElementSelectionDialog destinationDialog = 
				new ModelElementSelectionDialog(new NavigatorModelelementContex(selectedProject),TaskPackage.eINSTANCE.getWorkPackage(),false){};
			destinationDialog.setTitle("Select destination for new " + newTypeName);
			destinationDialog.setMessage("Select the work package into which the created " + newTypeName + " should be inserted.");
			destinationDialog.setBlockOnOpen(true);
			result = destinationDialog.open();
			if(result != Window.OK){
				return;
			}
			final WorkPackage destination = (WorkPackage) destinationDialog.getFirstResult();
			if(destination == null){
				error("No destination selected!");
				return;
			}
			
			//Add the created element to the destination and give it a proper name
			selection.setName("new " + selection.eClass().getName());
			
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					CompositeOperationHandle operationHandle = selectedProjectSpace.beginCompositeOperation();
					
					destination.getContainedWorkItems().add(selection);
					
					try {
						operationHandle.end("Create model element for patch attachment",
								"Created a work item to attach a patch to it",selectedProject.getModelElementId(selection));
					} catch (InvalidHandleException e) {
						error("Failed to add the created " + newTypeName + " to the project.");
						return;
					}
				}
			}.run();
		
		}
		
		//Do it!
		new AttachPatchCommand(selection, res, adapter).run();
		
		
	
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
