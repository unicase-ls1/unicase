/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.xmi.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.unicase.xmi.commands.ImportProjectHandler;
import org.unicase.xmi.views.listeners.ImportProjectWorkspaceListener;

/**
 * Dialog that will be shown when the user wants to import a new project.
 * @author matti, markus
 *
 */
public class ImportProjectDialog extends XMIDialog {
	
	/**
	 * Create a dialog to import a file from the workspace or filesystem.
	 * @param parent Shell where the dialog will be created in.
	 * @param handler Handler which invokes the dialog and who will receive the result upon completion.
	 */
	public ImportProjectDialog(Shell parent, ImportProjectHandler handler) {
		super(parent, "Import Project", "Please enter the name of your project-file and its location.");
		setHandler(handler);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected SelectionListener getBrowseFilesystemListener() {
		return new SelectionListener() {
		
			public void widgetDefaultSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
				String path = dialog.open();
				getTxtProjectLocation().setText(getResourceLocation(getTxtProjectName().getText(), path));
			}

			public void widgetSelected(SelectionEvent e) {
				widgetDefaultSelected(e);
			}
			
		};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected SelectionListener getBrowseWorkspaceListener() {
		return new ImportProjectWorkspaceListener(getTxtProjectName(), getTxtProjectLocation(), getShell());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void addInputListener() {
		// do nothing, because listener is not needed in this case
	}
}
