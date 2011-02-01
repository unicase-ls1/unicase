package org.unicase.xmi.views;

import java.io.File;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.LayoutConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.xmi.commands.XmiAbstractHandler;
import org.unicase.xmi.exceptions.XMIWorkspaceException;
import org.unicase.xmi.workspace.XMIECPWorkspace;
import org.unicase.xmi.workspace.XmiUtil;

/**
 * @author kraftm, maierma
 * superclass for single project dialogs
 *
 */
public abstract class XMIDialog extends TitleAreaDialog {
	
	/**
	 * Name of the Project
	 */
	protected Text txtProjectName;
	
	/**
	 * Description of the Project
	 */
	protected Text txtProjectDescription;
	
	/**
	 * Location of the Project's resource
	 */
	protected Text txtProjectLocation;
	
	/**
	 * Title of the dialog
	 */
	protected String dialogTitle;
	
	/**
	 * Message of the dialog
	 */
	protected String dialogMessage;
	
	/**
	 * Shell for listeners
	 */
	protected final Shell shell;
	
	/**
	 * The handler calling this dialog.
	 */
	private XmiAbstractHandler handler;
	
	/**
	 * Creates a new Dialog to import or create a project
	 * @param parentShell Shell of the parent
	 * @param title Title of the dialog
	 * @param message Message for the dialog
	 */
	public XMIDialog(Shell parentShell, String title, String message) {
		super(parentShell);
		shell = parentShell;
		dialogTitle = title;
		dialogMessage = message;
	}
	
	// SETTER
	public void setHandler(XmiAbstractHandler h) {
		this.handler = h;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		setTitle(dialogTitle);
		setMessage(dialogMessage);

		// Ask for project name
		Label name = new Label(contents, SWT.NULL);
		name.setText("Name:");
		txtProjectName = new Text(contents, SWT.SINGLE | SWT.BORDER);
		txtProjectName.setSize(150, 20);
		
		// Determine Location
		Label locationLabel = new Label(contents, SWT.NULL);
		locationLabel.setText("Location:");
		
		Composite location = new Composite(contents, SWT.NONE);
		location.setLayout(new FillLayout());
		txtProjectLocation = new Text(location, SWT.SINGLE | SWT.BORDER); 
		txtProjectLocation.setSize(140, 20);
		Button browseButton = new Button(location, SWT.NONE);
		browseButton.setText("Browse Filesystem...");
		Button wsButton = new Button(location, SWT.NONE);
		wsButton.setText("Browse Workspace...");
		
		browseButton.addSelectionListener(getBrowseFilesystemListener());
		wsButton.addSelectionListener(getBrowseWorkspaceListener());
		
		Label desc = new Label(contents, SWT.NULL);
		desc.setText("Description:");
		txtProjectDescription = new Text(contents, SWT.MULTI | SWT.BORDER);
		txtProjectDescription.setSize(150, 60);

		// Set layout in general
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
		
		// check if location already exists in workspace
		//  if so -> warning -> return to dialog
		boolean duplicate = false;
		
		try {
			ECPWorkspace ws = ECPWorkspaceManager.getInstance().getWorkSpace();
			if(ws instanceof XMIECPWorkspace) {
				if(((XMIECPWorkspace) ws).projectPathExists(txtProjectLocation.getText())) {
					String warningTitle = "Duplicate Path in Workspace";
					String warningMessage = "The path you entered already exists in the workspace.";
					MessageDialog.openWarning(shell, warningTitle, warningMessage);
					duplicate = true;
				}
			}
			
		} catch (NoWorkspaceException e) {
			new XMIWorkspaceException("No workspace available. Please check your configuration.", e);
		}
		
		if(!duplicate) {
			handler.setProjectName(txtProjectName.getText());
			handler.setProjectDescription(txtProjectDescription.getText());
			handler.setProjectLocation(txtProjectLocation.getText());
			close();
		}
	}
	
	/**
	 * Dialog dependent method that needs to be overwritten so it can either
	 * implement a directory selection or file selection
	 * @return Listener that is called when the button is pressed.
	 */
	protected abstract SelectionListener getBrowseWorkspaceListener();
	
	/**
	 * Dialog dependent method that needs to be overwritten so it can either
	 * implement a directory selection or file selection
	 * @return Listener that is called when the button is pressed.
	 */
	protected abstract SelectionListener getBrowseFilesystemListener();
	
	/**
	 * Validates the name and path and builds the location of the project's resource.
	 * @param name Name of the project
	 * @param path Path to the directory the project resource is contained in.
	 * @return Full path of the project's resource
	 */
	public static final String getResourceLocation(String name, String path) {
		String location;
		
		// determine whether path is ok if set
		if(XmiUtil.validate(path)) {
			File projRes = new File(path);
			if(projRes.isFile() && projRes.exists()) {
				return path;
			}
			else if(projRes.isDirectory() && projRes.exists()) {
				location = path;
			}
			else location = XmiUtil.DEFAULT_LOCATION; 
		}
		else location = XmiUtil.DEFAULT_LOCATION;
		
		// add seperator after path
		location += File.separator;
		
		// determine name
		if(XmiUtil.validate(name)) location += name;
		else {
			//TODO name not set, but path -> see details
			/*
			 * return only path and set a listener on the name field to update the location field as soon as the name changes
			 * make sure the listener attaches .ucw at the end of the name
			 */
			
			location += System.currentTimeMillis(); // remove
		}
		location += ".ucw";
		
		return location;
	}
}
