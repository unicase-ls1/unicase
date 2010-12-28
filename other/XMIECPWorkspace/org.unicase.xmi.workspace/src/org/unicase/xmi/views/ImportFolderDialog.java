package org.unicase.xmi.views;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.PackageNotFoundException;
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
import org.unicase.xmi.exceptions.XMIFileTypeException;

public class ImportFolderDialog extends TitleAreaDialog {

	/**
	 * Location of the folder
	 */
	private Text txtFolderLocation;

	/**
	 * The handler calling the dialog.
	 */
	private ImportFolderHandler handler;
	
	/**
	 * List of resources that can be loaded.
	 */
	private List<String> loadableFiles;
	
	/**
	 * Default constructor.
	 * 
	 * @param parent
	 *            the parent shell
	 */
	public ImportFolderDialog(Shell parent, ImportFolderHandler handler) {
		super(parent);
		this.handler = handler;
		loadableFiles = new ArrayList<String>();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		setTitle("Import Projects from Folder");
		setMessage("Please enter the location of the folder containing the projects.");
		
		// Determine Location
		Label locationLabel = new Label(contents, SWT.NULL);
		locationLabel.setText("Location:");
		
		Composite location = new Composite(contents, SWT.NONE);
		location.setLayout(new FillLayout());
		txtFolderLocation = new Text(location, SWT.SINGLE | SWT.BORDER); 
		txtFolderLocation.setSize(200, 20);
		Button browseButton = new Button(location, SWT.NONE);
		browseButton.setText("Browse...");
		final Shell shell = super.getParentShell();
		
		// add action when button pressed
		browseButton.addSelectionListener(new SelectionListener() {
			
			public void widgetDefaultSelected(SelectionEvent e) {
				DirectoryDialog dirDialog = new DirectoryDialog(shell, SWT.OPEN);
				String path = null;
				
				// ask for a path until the user enters one
				while(path == null || path.equals("")) {
					path = dirDialog.open();
				}
				
				// set the path to the text field
				txtFolderLocation.setText(path);
				
				// try to load contents
				
				try {
					tryLoadingProjects(path);
				} catch (PackageNotFoundException e1) { //TODO catching this exception does not work!
					// ignore unknown packages
				}
			}

			/**
			 * Tries to load the resources of the folder,
			 * if it can load a resource it adds the path of the 
			 * resource to a global list of loadable paths. 
			 * @param path Folder path containing the resources.
			 */
			private void tryLoadingProjects(String path) throws PackageNotFoundException {
				File dir = new File(path);
				ResourceSet resourceSet = new ResourceSetImpl();
				
				if(dir.isDirectory()) {
					File[] files = dir.listFiles();
					
					// Go through all files of the directory and try to load them
					for(File f: files) {
						String fullPath = f.getAbsolutePath();
						Resource res = resourceSet.getResource(URI.createFileURI(fullPath), true);
						try {
							res.load(Collections.EMPTY_MAP); // loading
							loadableFiles.add(fullPath); // adding to list
						}
						catch(Exception e) {
							// do nothing -> ignore
						}
					}
				}
				else {
					new XMIFileTypeException(path + " is not a directory.");
				}
			}

			public void widgetSelected(SelectionEvent e) {
				widgetDefaultSelected(e);
			}
			
		});
		browseButton.setEnabled(true);
		
		//TODO display available projects in a new widget
		/*
		 * Let the user choose the projects he wants.
		 */

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
		handler.addLoadableFiles(loadableFiles);
		close();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void cancelPressed() {
		close();
	}
}
