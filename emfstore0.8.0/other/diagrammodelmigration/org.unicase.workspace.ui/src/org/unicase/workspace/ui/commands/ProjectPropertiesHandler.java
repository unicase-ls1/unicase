/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.unicase.workspace.WorkspaceManager;

/**
 * Opens the user settings for this project.
 * 
 * @author Shterev
 */
public class ProjectPropertiesHandler extends AbstractHandler {

	/**
	 * Default constructor.
	 */
	public ProjectPropertiesHandler() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		PreferenceDialog propertyDialog = PreferencesUtil
				.createPropertyDialogOn(Display.getCurrent().getActiveShell(),
						WorkspaceManager.getInstance().getCurrentWorkspace()
								.getActiveProjectSpace().getProject(), null,
						null, null);
		propertyDialog.open();
		return null;
	}

}