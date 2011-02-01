package org.unicase.xmi.views;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.LayoutConstants;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ViewerFilter;
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
import org.unicase.xmi.exceptions.XMIWorkspaceException;

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
	 * Holding the projects to load.
	 */
	private XmiListViewer listViewer;
	
	/**
	 * Default constructor.
	 * 
	 * @param parent
	 *            the parent shell
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
					
					// try to load contents
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
		wsButton.addSelectionListener(new SelectionListener() {

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
					tryLoadingProjects(loadableFiles, path, getShell());
					
					// add projects to viewer
					for(String s: loadableFiles) {
						listViewer.add(s);
					}
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);				
			}
			
		});
		
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
	 */
	private static final void tryLoadingProjects(List<String> loadableFiles, String path, Shell shell) {
		
		final String dirPath = path;
		final List<String> loadableProcessedFiles = new ArrayList<String>();
		
		// build a dialog to show the status
		final ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(shell);
		
		try {
			progressDialog.run(true, true, new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					// open up the path
					File dir = new File(dirPath);
					ResourceSet resourceSet = new ResourceSetImpl();
					
					if(dir.isDirectory()) {
						// open directory
						File[] files = dir.listFiles();
						int numFiles = files.length;
						
						monitor.beginTask("Loading files", numFiles);
						
						// Go through all files of the directory and try to load them
						for(File f: files) {
							String fullPath = f.getAbsolutePath();
							
							try {
								resourceSet.getResource(URI.createFileURI(fullPath), true);
								loadableProcessedFiles.add(fullPath); // adding to list
							}
							catch(WrappedException e) {
								// ignore -> it's simply not loadable
							}
							monitor.worked(1);
						}
					}
					else {
						new XMIFileTypeException(dirPath + " is not a directory.");
					}
					monitor.done();
				}
				
			});
		} catch (InvocationTargetException e1) {
			new XMIWorkspaceException("Unable to load directory contents.", e1);
		} catch (InterruptedException e1) {
			new XMIWorkspaceException("Unable to load directory contents.", e1);
		}
		
		// write the loadable files back to the "real" list
		loadableFiles.addAll(loadableProcessedFiles);
		
	}
	
}
