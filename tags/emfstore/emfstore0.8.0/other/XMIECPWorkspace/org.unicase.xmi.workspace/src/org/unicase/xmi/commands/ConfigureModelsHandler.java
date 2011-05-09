/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.xmi.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.xmi.exceptions.XMIWorkspaceException;
import org.unicase.xmi.workspace.XMIMetaModelElementContext;
import org.unicase.xmi.workspace.XmiUtil;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject;

/**
 * Handles the user's choice to add or remove a model from a FileProject.
 * @author kraftm, maierma
 *
 */
public class ConfigureModelsHandler extends AbstractHandler {

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
		
		// get the context from the project
		XMIMetaModelElementContext context = (XMIMetaModelElementContext) project.getMetaModelElementContext();
		
		// build dialog
		Shell activeShell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
		
		ListSelectionDialog dialog = new ListSelectionDialog(activeShell,
				XmiUtil.getAllModels().toArray(), new ArrayContentProvider(), new LabelProvider(),
				"Select the models for your project:");
		dialog.setTitle("Model Selection");
		dialog.setInitialSelections(context.getModels().toArray());
		
		// work with the result of the dialog to add or remove models from FileProject
		if (dialog.open() == Window.OK) {
			//remove all registered models
			context.clearModels();
			
			//Add all selected models
			for(Object s : dialog.getResult()) {
				if(s instanceof String)	{
					context.addModel((String) s);
				}
			}
		}
		
		return null;
	}

}
