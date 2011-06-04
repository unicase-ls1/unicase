/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.ecp.xmiworkspace.views;

import java.io.File;

import org.eclipse.emf.ecp.xmiworkspace.XMIECPWorkspaceManager;
import org.eclipse.emf.ecp.xmiworkspace.XmiUtil;
import org.eclipse.emf.ecp.xmiworkspace.commands.XmiAbstractHandler;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.LayoutConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Offers common functionalities for the dialogs that will be used when a new
 * project is created or imported.
 * 
 * @author matti, markus
 */
public abstract class XMIDialog extends TitleAreaDialog {

	/**
	 * Name of the Project.
	 */
	private Text txtProjectName;

	/**
	 * Description of the Project.
	 */
	private Text txtProjectDescription;

	/**
	 * Location of the Project's resource.
	 */
	private Text txtProjectLocation;

	/**
	 * The path the user specified.
	 */
	private String projectLocationPath;

	/**
	 * Title of the dialog.
	 */
	private String dialogTitle;

	/**
	 * Message of the dialog.
	 */
	private String dialogMessage;

	/**
	 * Shell for listeners.
	 */
	private final Shell shell;

	/**
	 * The handler calling this dialog.
	 */
	private XmiAbstractHandler handler;

	/**
	 * Creates a new Dialog to import or create a project.
	 * 
	 * @param parentShell
	 *            Shell of the parent
	 * @param title
	 *            Title of the dialog
	 * @param message
	 *            Message for the dialog
	 */
	public XMIDialog(Shell parentShell, String title, String message) {
		super(parentShell);
		shell = parentShell;
		dialogTitle = title;
		dialogMessage = message;
	}

	// SETTER
	/**
	 * Sets the handler for the dialog(s).
	 * 
	 * @param h
	 *            Handler which invoked the dialog.
	 */
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

		// add a listener to the text field, so if it changes the name
		// will be changed too, but only in the case of a new project
		addInputListener();

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
		GridLayoutFactory.fillDefaults().numColumns(2)
				.margins(defaultMargins.x, defaultMargins.y)
				.generateLayout(contents);

		return contents;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void okPressed() {
		// check if location already exists in workspace
		// if so -> warning -> return to dialog
		boolean failed = false;

		if (XMIECPWorkspaceManager.projectPathExists(txtProjectLocation
				.getText())) {
			String warningTitle = "Duplicate Path in Workspace";
			String warningMessage = "The path you entered already exists in the workspace.";
			MessageDialog.openWarning(shell, warningTitle, warningMessage);
			failed = true;
		}

		// check for empty name
		if (!XmiUtil.validate(txtProjectName.getText())) {
			txtProjectName.setBackground(new Color(shell.getDisplay(), 205,
					106, 106));
			failed = true;
		}

		if (!failed) {
			handler.setProjectName(txtProjectName.getText());
			handler.setProjectDescription(txtProjectDescription.getText());
			handler.setProjectLocation(txtProjectLocation.getText());
			close();
		}
	}

	/**
	 * Dialog dependent method that needs to be overwritten so it can either
	 * implement a directory selection or file selection.
	 * 
	 * @return Listener that is called when the button is pressed.
	 */
	protected abstract SelectionListener getBrowseWorkspaceListener();

	/**
	 * Dialog dependent method that needs to be overwritten so it can either
	 * implement a directory selection or file selection.
	 * 
	 * @return Listener that is called when the button is pressed.
	 */
	protected abstract SelectionListener getBrowseFilesystemListener();

	/**
	 * In the process of creating the dialog you can insert a listener.
	 */
	protected abstract void addInputListener();

	/**
	 * Validates the name and path and builds the location of the project's
	 * resource.
	 * 
	 * @param name
	 *            Name of the project
	 * @param path
	 *            Path to the directory the project resource is contained in.
	 * @return Full path of the project's resource, if name was not set, only
	 *         the path
	 */
	public static final String getResourceLocation(String name, String path) {
		String location;

		// determine whether path is ok if set
		if (XmiUtil.validate(path)) {
			File projRes = new File(path);
			if (projRes.isFile() && projRes.exists()) {
				return path;
			} else if (projRes.isDirectory() && projRes.exists()) {
				location = path;
			} else {
				location = XmiUtil.DEFAULT_LOCATION;
			}
		} else {
			location = XmiUtil.DEFAULT_LOCATION;
		}

		// add seperator after path
		location += File.separator;

		// determine name
		if (XmiUtil.validate(name)) {
			location += name + ".ucw";
		}

		return location;
	}

	/**
	 * @return the txtProjectName
	 */
	public Text getTxtProjectName() {
		return txtProjectName;
	}

	/**
	 * @param txtProjectName
	 *            the txtProjectName to set
	 */
	public void setTxtProjectName(Text txtProjectName) {
		this.txtProjectName = txtProjectName;
	}

	/**
	 * @return the txtProjectDescription
	 */
	public Text getTxtProjectDescription() {
		return txtProjectDescription;
	}

	/**
	 * @param txtProjectDescription
	 *            the txtProjectDescription to set
	 */
	public void setTxtProjectDescription(Text txtProjectDescription) {
		this.txtProjectDescription = txtProjectDescription;
	}

	/**
	 * @return the txtProjectLocation
	 */
	public Text getTxtProjectLocation() {
		return txtProjectLocation;
	}

	/**
	 * @param txtProjectLocation
	 *            the txtProjectLocation to set
	 */
	public void setTxtProjectLocation(Text txtProjectLocation) {
		this.txtProjectLocation = txtProjectLocation;
	}

	/**
	 * @return the projectLocationPath
	 */
	public String getProjectLocationPath() {
		return projectLocationPath;
	}

	/**
	 * @param projectLocationPath
	 *            the projectLocationPath to set
	 */
	public void setProjectLocationPath(String projectLocationPath) {
		this.projectLocationPath = projectLocationPath;
	}

	/**
	 * @return the dialogTitle
	 */
	public String getDialogTitle() {
		return dialogTitle;
	}

	/**
	 * @param dialogTitle
	 *            the dialogTitle to set
	 */
	public void setDialogTitle(String dialogTitle) {
		this.dialogTitle = dialogTitle;
	}

	/**
	 * @return the dialogMessage
	 */
	public String getDialogMessage() {
		return dialogMessage;
	}

	/**
	 * @param dialogMessage
	 *            the dialogMessage to set
	 */
	public void setDialogMessage(String dialogMessage) {
		this.dialogMessage = dialogMessage;
	}

	/**
	 * @return the shell
	 */
	public Shell getShell() {
		return shell;
	}

	/**
	 * @return the handler
	 */
	public XmiAbstractHandler getHandler() {
		return handler;
	}
}
