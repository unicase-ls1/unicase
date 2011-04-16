/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.ecp.xmiworkspace.views.listeners;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.ecp.xmiworkspace.views.ImportFolderDialog;
import org.eclipse.emf.ecp.xmiworkspace.views.XmiListViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Selection Listener for the "browse workspace" button.
 * @author matti, markus
 *
 */
public class ImportFolderWorkspaceListener implements SelectionListener {
	
	private Shell shell;
	private Text txtFolderLocation;
	private final List<String> loadableFiles;
	private final XmiListViewer viewer;
	
	/**
	 * Creates a new selection listener for the "browse workspace" button.
	 * @param shell Shell where the progress bar will be opened.
	 * @param txtFolderLocation Textfield for the location.
	 * @param loadableFiles List of files that can be loaded from the folder.
	 * @param viewer Widget that shows the loadable files.
	 */
	public ImportFolderWorkspaceListener(Shell shell, Text txtFolderLocation,
			List<String> loadableFiles, XmiListViewer viewer) {
		
		this.shell = shell;
		this.txtFolderLocation = txtFolderLocation;
		this.loadableFiles = loadableFiles;
		this.viewer = viewer;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void widgetSelected(SelectionEvent e) {
		// open up workspace folder selection
		String title = "Select a folder";
		String message = "Please select a folder from the workspace";
		IContainer[] folders = WorkspaceResourceDialog.openFolderSelection(shell, title, message,
			false, null, new ArrayList<ViewerFilter>());
		
		String path = null;
		if(folders.length > 0) {
			// select first entry -> multiple false
			path = folders[0].getLocation().toOSString();
			
			// set the path to the text field
			txtFolderLocation.setText(path);
			
			// try to load contents					
			ImportFolderDialog.tryLoadingProjects(loadableFiles, path, shell);
			
			// add projects to viewer
			for(String s: loadableFiles) {
				viewer.add(s);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void widgetDefaultSelected(SelectionEvent e) {
		widgetSelected(e);				
	}

}
