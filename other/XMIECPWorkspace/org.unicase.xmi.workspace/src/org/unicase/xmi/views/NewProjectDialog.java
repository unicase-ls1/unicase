/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.xmi.views;

import java.io.File;
import java.util.ArrayList;

import org.eclipse.core.resources.IContainer;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;
import org.unicase.xmi.commands.NewProjectHandler;
import org.unicase.xmi.workspace.XmiUtil;

/**
 * Dialog to be shown when a new project is about to be created.
 * @author matti, markus
 *
 */
public class NewProjectDialog extends XMIDialog {

	/**
	 * Create a dialog to ask the user for the informations about his new project.
	 * @param parent Parent shell the dialog is displayed in.
	 * @param handler Handler the dialog interacts with.
	 */
	public NewProjectDialog(Shell parent, NewProjectHandler handler) {
		super(parent, "Create New Project", "Please enter the name, the location and a description of the project.");
		setHandler(handler);
	}

	/**
	 * {@inheritDoc}
	 */
	protected SelectionListener getBrowseFilesystemListener() {
		return new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				// select the folder where to save the file
				DirectoryDialog dirDialog = new DirectoryDialog(getShell(), SWT.OPEN);
				
				String path = dirDialog.open();
				
				// location saving
				setProjectLocationPath(path);
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
		return new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {		
				String title = "Select a folder";
				String message = "Please select a folder where to save the file";
				String path = null;
				
				IContainer[] selectedFolders = WorkspaceResourceDialog.openFolderSelection(getShell(),
						title, message, false, null, new ArrayList<ViewerFilter>());
				if(selectedFolders.length > 0) {
					// index 0 because multi option is off and it can import only one or no files
					path = selectedFolders[0].getLocation().toOSString(); 
				}
				
				// location saving
				if(path != null) {
					setProjectLocationPath(path);
					getTxtProjectLocation().setText(getResourceLocation(getTxtProjectName().getText(), path));
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
			
		};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void addInputListener() {
		getTxtProjectName().addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				// do nothing
			}

			public void focusLost(FocusEvent e) {
				// filter path and extension from current location content
				String content = getTxtProjectLocation().getText(); 
				String extSeparator = ".";
				int extPos = new StringBuilder(content).reverse().indexOf(extSeparator);
				String ext = ".ucw";
				if(extPos != -1) {
					ext = content.substring(content.length() - extPos -1);
				}
				String path = getProjectLocationPath();
				if(!XmiUtil.validate(path)) {
					path = "";
				}
				else {
					path += File.separator;
				}
				getTxtProjectLocation().setText(path + getTxtProjectName().getText() + ext);
			}
			
		});
	}
	
} // END of class
