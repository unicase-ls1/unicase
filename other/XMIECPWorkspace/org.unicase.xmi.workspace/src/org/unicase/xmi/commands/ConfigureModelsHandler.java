package org.unicase.xmi.commands;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.xmi.exceptions.XMIWorkspaceException;
import org.unicase.xmi.views.ConfigureModelsDialog;
import org.unicase.xmi.workspace.XMIMetaModelElementContext;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject;

/**
 * Handles the user's choice to add or remove a model from a FileProject
 * @author kraftm, maierma
 *
 */
public class ConfigureModelsHandler extends AbstractHandler {

	/**
	 * The list of models that is selected from user to be added to project
	 */
	private List<String> list;

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		//determine an open project
		XMIECPFileProject project = null;
		try {
			project = (XMIECPFileProject) ECPWorkspaceManager.getInstance().getWorkSpace().getActiveProject();
		} catch (NoWorkspaceException e) {
			new XMIWorkspaceException("No Workspace available.", e);
		}
		
		// open dialog
		ConfigureModelsDialog dialog = new ConfigureModelsDialog(PlatformUI
			.getWorkbench().getDisplay().getActiveShell(), this, project);
		
		//work with the result of the dialog to add or remove models from FileProject
		if (dialog.open() == Window.OK){
			XMIMetaModelElementContext context = (XMIMetaModelElementContext) project.getMetaModelElementContext();
			
			//remove all registered models
			context.clearModels();
			
			//Add all selected models
			for(String s : list){
				context.addModel(s);
			}
			
			//Add all models that are used but not selected by user
			project.completeModels();
		}
		
		return null;
	}
	
	/**
	 * Sets the selected models
	 * @param list of selected models
	 */
	public void setModelList(List<String> list){
		this.list = list;
		
	}

}
