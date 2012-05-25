/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.xmi.views;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.LayoutConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unicase.xmi.commands.ImportFolderHandler;
import org.unicase.xmi.exceptions.XMIWorkspaceException;
import org.unicase.xmi.views.listeners.ImportFolderWorkspaceListener;
import org.unicase.xmi.views.listeners.ProgressMonitorThread;

/**
 * Dialog that will ask for a path that will then be loaded
 * and the available and loadable projects will be displayed
 * to choose from.
 * If the user clicks OK, his selection will be saved in the handler.
 * @author matti, markus
 *
 */
public class ImportFolderDialog extends TitleAreaDialog {

	/**
	 * Location of the folder.
	 */
	private Text txtFolderLocation;

	/**
	 * The handler calling the dialog.
	 */
	private ImportFolderHandler handler;
	
	/**
	 * Holding the projects to load.
	 */
	private XmiListViewer listViewer;
	
	/**
	 * Create a dialog to ask the user.
	 * @param parent Shell in which the dialog is displayed.
	 * @param handler Handler invoking the dialog.
	 */
	public ImportFolderDialog(Shell parent, ImportFolderHandler handler) {
		super(parent);
		this.handler = handler;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// set title and message
		String message = "Please enter the location of the folder containing the projects.\n";
		message += "Then select all the project you want to import.";
		setMessage(message);
		setTitle("Import Projects from Folder");
		
		// Determine Location
		Label locationLabel = new Label(contents, SWT.NULL);
		locationLabel.setText("Location:");
		
		Composite location = new Composite(contents, SWT.NONE);
		location.setLayout(new FillLayout());
		txtFolderLocation = new Text(location, SWT.SINGLE | SWT.BORDER); 
		txtFolderLocation.setSize(140, 20);
		Button browseButton = new Button(location, SWT.NONE);
		browseButton.setText("Browse Filesystem...");
		Button wsButton = new Button(location, SWT.NONE);
		wsButton.setText("Browse Workspace...");
		
		// Let the user choose the projects he wants.
		Label projectsLabel = new Label(contents, SWT.NONE);
		projectsLabel.setText("Projects: ");
		final List<String> loadableFiles = new ArrayList<String>(); // the files that can be loaded as projects
		
		listViewer = new XmiListViewer(contents);
		
		// add action when browse filesystem button pressed
		final Shell shell = super.getParentShell();
		
		browseButton.addSelectionListener(new SelectionListener() {
			
			public void widgetDefaultSelected(SelectionEvent e) {
				// ask the user for the path in the filesystem
				DirectoryDialog dirDialog = new DirectoryDialog(shell, SWT.OPEN);
				String path = dirDialog.open();
				
				// set the path to the text field
				if(path != null && path != "") {
					txtFolderLocation.setText(path);
					
					tryLoadingProjects(loadableFiles, path, getShell());
					
					// add projects to viewer
					for(String s: loadableFiles) {
						listViewer.add(s);
					}
				}
			}

			public void widgetSelected(SelectionEvent e) {
				widgetDefaultSelected(e);
			}
			
		});

		// add action when browse workspace button is pressed
		ImportFolderWorkspaceListener importFolderWorkspaceListener = new ImportFolderWorkspaceListener(
				getShell(), txtFolderLocation, loadableFiles, listViewer);
		wsButton.addSelectionListener(importFolderWorkspaceListener);
		
		// finaly layout
		Point defaultMargins = LayoutConstants.getMargins();
		GridLayoutFactory.fillDefaults().numColumns(2).margins(
				defaultMargins.x, defaultMargins.y).generateLayout(contents);

		return contents;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void okPressed() {		
		// give the handler a list of project paths	
		handler.addLoadableFiles(listViewer.listGetSelection());
		close();
	}

	/**
	 * Tries to load the resources of the folder,
	 * if it can load a resource it adds the path of the 
	 * resource to a global list of loadable paths. 
	 * @param loadableFiles Files that can be loaded.
	 * @param path Folder path containing the resources.
	 * @param shell Shell where to create the progress bar dialog.
	 */
	public static void tryLoadingProjects(List<String> loadableFiles, String path, Shell shell) {
		
		final String dirPath = path;
		final List<String> loadableProcessedFiles = new ArrayList<String>();
		
		// build a dialog to show the status
		final ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(shell);
		
		try {
			progressDialog.run(true, true, new ProgressMonitorThread(dirPath, loadableProcessedFiles));
		} catch (InvocationTargetException e1) {
			new XMIWorkspaceException("Unable to load directory contents.", e1);
		} catch (InterruptedException e1) {
			new XMIWorkspaceException("Unable to load directory contents.", e1);
		}
		
		// write the loadable files back to the "real" list
		loadableFiles.addAll(loadableProcessedFiles);
		
	}
	
}
