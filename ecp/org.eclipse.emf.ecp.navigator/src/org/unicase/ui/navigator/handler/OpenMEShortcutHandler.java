/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.unicase.ui.navigator.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.workSpaceModel.ECPProject;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.navigator.Activator;
import org.unicase.ui.navigator.dialogs.OpenMeShortcutDialog;

/**
 * This is the (ShortcutCommand)-Handler to select model elements out of a list of elements.
 * 
 * @author Hamid
 */

public class OpenMEShortcutHandler extends AbstractHandler implements IHandler {

	/**
	 * Default constructor.
	 */
	public OpenMEShortcutHandler() {

	}

	/**
	 * Opens a element selection dialog. {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		ECPProject project = null;
		try {
			project = ECPWorkspaceManager.getInstance().getWorkSpace().getActiveProject();
		} catch (NoWorkspaceException e) {
			Activator.getDefault().logException(e.getMessage(), e);
		}
		if (project == null) {
			MessageDialog.openInformation(shell, "Information", "You must select the Project");
		} else {

			OpenMeShortcutDialog dialog = new OpenMeShortcutDialog(project);

			if (dialog.open() == Window.OK) {
				Object[] result = dialog.getResult();

				if (result.length == 1 && result[0] instanceof EObject) {
					EObject modelElement = (EObject) result[0];
					ActionHelper.openModelElement(modelElement, "org.unicase.ui.OpenMEShortcut");
				}
			}
		}

		return null;
	}

}
