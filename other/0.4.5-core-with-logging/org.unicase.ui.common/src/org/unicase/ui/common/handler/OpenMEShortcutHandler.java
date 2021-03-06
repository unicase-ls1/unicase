/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.ui.common.dialogs.OpenMeShortcutDialog;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * This is the (ShortcutCommand)-Handler to select model elements out of a list of elements.
 * 
 * @author Hamid
 */

public class OpenMEShortcutHandler extends AbstractHandler implements IHandler {

	private Project project;

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
		ProjectSpace projectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();

		if (projectSpace == null) {
			MessageDialog.openInformation(shell, "Information", "You must select the Project");
		} else {

			project = projectSpace.getProject();
			
			OpenMeShortcutDialog dialog = new OpenMeShortcutDialog(project);

			if (dialog.open() == Window.OK) {
				Object[] result = dialog.getResult();

				if (result.length == 1 && result[0] instanceof ModelElement) {
					ModelElement modelElement = (ModelElement) result[0];
					ActionHelper.openModelElement(modelElement, "org.unicase.ui.OpenMEShortcut");
				}
			}
		}

		return null;
	}

}
