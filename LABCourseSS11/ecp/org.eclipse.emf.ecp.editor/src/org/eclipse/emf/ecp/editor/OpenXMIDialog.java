/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 */
package org.eclipse.emf.ecp.editor;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecp.xmiworkspace.XmiUtil;
import org.eclipse.emf.ecp.xmiworkspace.views.listeners.ImportProjectWorkspaceListener;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.LayoutConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
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

/**
 * 
 * @author lee
 *
 */
public class OpenXMIDialog extends TitleAreaDialog{

	private static final String DEFAULT_LOCATION = Platform.getLocation().toOSString();


	private List<EObject> objectList;
	

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
	
	public OpenXMIDialog(Shell parentShell, String title, String message) {
		super(parentShell);
		shell = parentShell;
		dialogTitle = title;
		dialogMessage = message;
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

//		Label desc = new Label(contents, SWT.NULL);
//		desc.setText("Description:");
//		txtProjectDescription = new Text(contents, SWT.MULTI | SWT.BORDER);
//		txtProjectDescription.setSize(150, 60);

		// Set layout in general
		Point defaultMargins = LayoutConstants.getMargins();
		GridLayoutFactory.fillDefaults().numColumns(2)
				.margins(defaultMargins.x, defaultMargins.y)
				.generateLayout(contents);

		return contents;
	}

	protected SelectionListener getBrowseWorkspaceListener() {
		return new ImportProjectWorkspaceListener(txtProjectName, txtProjectLocation, getShell());
	}

	protected SelectionListener getBrowseFilesystemListener() {
		return new SelectionListener() {
			
			public void widgetDefaultSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
				String path = dialog.open();
				String[] pathField = path.split("\\\\");
				txtProjectName.setText(pathField[pathField.length - 1]);
				txtProjectLocation.setText(getResourceLocation(txtProjectName.getText(), path));
			}

			public void widgetSelected(SelectionEvent e) {
				widgetDefaultSelected(e);
			}
			
		};
	}

//	private void updateContext() {
//		final ECPWorkspace workspace = WorkSpaceModelFactoryImpl.eINSTANCE.createECPWorkspace();
//		ECPCommand command = new ECPCommand(workspace) {
//			@Override
//			protected void doRun() {
//				XMIECPFileProject project = StructureFactory.eINSTANCE
//						.createXMIECPFileProject();
//
//				// set the information of the project
//				project.setProjectName(getTxtProjectName().getText());
//				project.setXmiFilePath(getTxtProjectLocation().getText());
//				project.setProjectDescription(getTxtProjectDescription().getText());
//
//				workspace.getProjects().add(project);
//				workspace.setActiveProject(project);
//				project.loadContents();
//			}
//		};
//		command.run(true);
		
//		XMIECPFileProject project = StructureFactory.eINSTANCE
//		.createXMIECPFileProject();
//
//		// set the information of the project
//		project.setProjectName(txtProjectName.getText());
//		project.setXmiFilePath(txtProjectLocation.getText());
//		project.setProjectDescription(txtProjectDescription.getText());
//		
//		workspace.getProjects().add(project);
//		workspace.setActiveProject(project);
//		project.loadContents();
//		context = workspace.getProjects().get(0);
//	}

	@Override
	public void okPressed() {
		// check if location already exists in workspace
		// if so -> warning -> return to dialog
		boolean failed = false;

		// check for empty name
		if (!XmiUtil.validate(txtProjectName.getText())) {
			txtProjectName.setBackground(new Color(getShell().getDisplay(), 205,
					106, 106));
			failed = true;
		}
		if (!failed) {
			loadXMIFile();
			close();
		}
	}
	
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
				location = DEFAULT_LOCATION;
			}
		} else {
			location = DEFAULT_LOCATION;
		}

		// add seperator after path
		location += File.separator;

		// determine name
		if (XmiUtil.validate(name)) {
			location += name + ".ucw";
		}

		return location;
	}

	
	private void loadXMIFile() {
		// TODO Auto-generated method stub
		
		ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		BasicCommandStack commandStack = new BasicCommandStack();
		AdapterFactoryEditingDomain editingDomain = new AdapterFactoryEditingDomain(
				composedAdapterFactory, commandStack);
		ResourceSet set = editingDomain.getResourceSet();
		Resource mainResource = set.createResource(URI.createFileURI(txtProjectLocation.getText()));
//		Project proj = org.eclipse.emf.emfstore.common.model.ModelFactory.eINSTANCE.createProject();
		try {
			mainResource.load(Collections.EMPTY_MAP);
		} catch (IOException e) {
						// TODO Auto-generated catch block
						// Do NOT catch all Exceptions ("catch (Exception e)")
						// Log AND handle Exceptions if possible 
			            //
			            // You can just uncomment one of the lines below to log an exception:
						// logException will show the logged excpetion to the user
						// ModelUtil.logException(e);
						// ModelUtil.logException("YOUR MESSAGE HERE", e);
						// logWarning will only add the message to the error log
						// ModelUtil.logWarning("YOUR MESSAGE HERE", e);
						// ModelUtil.logWarning("YOUR MESSAGE HERE");
						//			
						// If handling is not possible declare and rethrow Exception
		}
		
		objectList = mainResource.getContents();
	}

	public List<EObject> getObjectList() {
		return objectList;
	}
	
}
