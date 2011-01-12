package org.unicase.xmi.views;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
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
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.unicase.xmi.commands.ImportProjectHandler;

public class ImportProjectDialog extends TitleAreaDialog {

	private Text txtProjectName;
	private Text txtProjectLocation;

	/**
	 * Name of the project that can be set before the dialog is opened.
	 */
	private String presetName;
	
	/**
	 * The handler calling this dialog.
	 */
	private ImportProjectHandler handler;
	
	/**
	 * Default constructor.
	 * 
	 * @param parent
	 *            the parent shell
	 */
	public ImportProjectDialog(Shell parent, ImportProjectHandler handler) {
		super(parent);
		presetName = "";
		this.handler = handler;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		setTitle("Import Project");
		setMessage("Please enter the name of your project-file and its location.");
		
		Label name = new Label(contents, SWT.NULL);
		name.setText("Name:");
		txtProjectName = new Text(contents, SWT.SINGLE | SWT.BORDER);
		txtProjectName.setSize(150, 20);
		if(presetName != "") txtProjectName.setText(presetName);
		
		// Determine Location
		Label locationLabel = new Label(contents, SWT.NULL);
		locationLabel.setText("Location:");
		
		Composite location = new Composite(contents, SWT.NONE); // create new composite section to fit the 3 fields as it would be one
		location.setLayout(new FillLayout());
		txtProjectLocation = new Text(location, SWT.SINGLE | SWT.BORDER); // add text-field
		txtProjectLocation.setSize(140, 20);
		Button browseButton = new Button(location, SWT.NONE); // add browse-button
		browseButton.setText("Browse Filesystem...");
		Button wsButton = new Button(location, SWT.NONE); // add browse-workspace-button
		wsButton.setText("Browse Workspace...");
		
		// open the "select directory"-dialog when you click on "Browse Filesystem..."
		final Shell shell = super.getParentShell();
		browseButton.addSelectionListener(new SelectionListener() {

			FileDialog projectLocation = new FileDialog(shell, SWT.OPEN);
			String path = Platform.getLocation().toOSString();
		
			public void widgetDefaultSelected(SelectionEvent e) {
				
				projectLocation.setFilterNames(new String[] {"XMI Project Resources (*.ucw)",
					"XML Model Resources (*.xml)",
					"XMI Model Resources (*.xmi)"});
				projectLocation.setFilterExtensions(new String[] {"*.ucw", "*.xml", "*.xmi"});
				
				path = projectLocation.open();
				if(path == null) {
					path = Platform.getLocation().toOSString();
					
					if(txtProjectName.getText() == null || txtProjectName.getText() == "") {
						path += File.separator + System.currentTimeMillis() + ".ucw"; // prevents the system from having twice the same filename or at least it's unlikely.
					}
					else {
						path += File.separator + txtProjectName.getText() + ".ucw";
					}
				}
				txtProjectLocation.setText(path);
			}

			public void widgetSelected(SelectionEvent e) {
				widgetDefaultSelected(e);
			}
			
		});
		
		// open the "select something from workspace"-dialog when you click on "Browse Workspace..."
		wsButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				// opens up a new dialog to browse the "eclipse" workspace
				WorkspaceResourceDialog workspaceDialog = new WorkspaceResourceDialog(shell, new WorkbenchLabelProvider(), new WorkbenchContentProvider());
				workspaceDialog.setAllowMultiple(false);
				workspaceDialog.setTitle("Select a Project File");
				workspaceDialog.setMessage("Please select an XMI file with project contents.");
				workspaceDialog.loadContents();
				int dialogRes = workspaceDialog.open();
				
				// dialog results
				String fileName = null;
				if(dialogRes == WorkspaceResourceDialog.OK) {
					IFile[] selectedFiles = workspaceDialog.getSelectedFiles();
					if(selectedFiles.length != 0) {
						//TODO continue...
						//TODO toString() is the wrong method -> will not get full path!
						fileName = selectedFiles[0].toString(); // index 0 because multi option is off and it can import only one or no files 
					}
				}
				
				if(fileName == null || fileName == "") {
					String path = Platform.getLocation().toOSString();
					
					if(txtProjectName.getText() == null || txtProjectName.getText() == "") {
						path += File.separator + System.currentTimeMillis() + ".ucw"; // prevents the system from having twice the same filename or at least it's unlikely.
					}
					else {
						path += File.separator + txtProjectName.getText() + ".ucw";
					}
					
					fileName = path;
				}
				
				// set the textfield to a fitting project name
				txtProjectLocation.setText(fileName);
			}

			public void widgetSelected(SelectionEvent e) {
				widgetDefaultSelected(e);
			}
			
		});
		// END Determine Location
		
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
		handler.setProjectName(txtProjectName.getText());
		handler.setProjectLocation(txtProjectLocation.getText());
		close();
	}

	/**
	 * Sets a name for the project.
	 * @param name Name of the new project.
	 */
	public void setProjectName(String name) {
		this.presetName = name;
	}
}
