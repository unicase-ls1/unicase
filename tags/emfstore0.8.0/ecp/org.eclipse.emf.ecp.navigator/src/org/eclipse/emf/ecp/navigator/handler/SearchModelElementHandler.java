/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.navigator.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.model.ECPWorkspaceManager;
import org.eclipse.emf.ecp.common.model.NoWorkspaceException;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPProject;
import org.eclipse.emf.ecp.common.util.ActionHelper;
import org.eclipse.emf.ecp.navigator.Activator;
import org.eclipse.emf.ecp.navigator.dialogs.SearchModelElementDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;

/**
 * This is the handler to search and select a model element out of a list of model elements.
 * 
 * @author emueller
 */
public class SearchModelElementHandler extends AbstractHandler implements IHandler {

	/**
	 * Default constructor.
	 */
	public SearchModelElementHandler() { }

	/**
	 * Opens a element selection dialog.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {	
		
		ECPProject project = null;
		
		try {
			 project = ECPWorkspaceManager.getInstance().getWorkSpace().getActiveProject();
		} catch (NoWorkspaceException e) {
			Activator.getDefault().logException(e.getMessage(), e);
		}		

		if (project == null) {
			MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), 
				"Information", "You must first select the Project.");
		} else {
			SearchModelElementDialog dialog = new SearchModelElementDialog(project);

			if (dialog.open() == Window.OK) {
				Object[] selections = dialog.getResult();

				if (selections != null && selections.length == 1 && selections[0] instanceof EObject) {
					ActionHelper.openModelElement((EObject) selections[0], 
						"org.eclipse.emf.ecp.navigator.handler.SearchModelElementHandler");
				}
			}
		}

		return null;
	}
}
