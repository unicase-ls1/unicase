package org.eclipse.emf.ecp.editor;

import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.emf.ecp.common.model.ECPModelelementContext;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace;
import org.eclipse.emf.ecp.common.model.workSpaceModel.impl.ECPWorkspaceImpl;
import org.eclipse.emf.ecp.common.model.workSpaceModel.impl.WorkSpaceModelFactoryImpl;
import org.eclipse.emf.ecp.xmiworkspace.XMIECPWorkspaceManager;
import org.eclipse.emf.ecp.xmiworkspace.XmiUtil;
import org.eclipse.emf.ecp.xmiworkspace.structure.StructureFactory;
import org.eclipse.emf.ecp.xmiworkspace.structure.XMIECPFileProject;
import org.eclipse.emf.ecp.xmiworkspace.views.XMIDialog;
import org.eclipse.emf.ecp.xmiworkspace.views.listeners.ImportProjectWorkspaceListener;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class OpenXMIDialog extends XMIDialog{

	private ECPModelelementContext context;
	
	public OpenXMIDialog(Shell parentShell) {
		super(parentShell, "Import from XMI", "Please choose a location to an XMI-File");
		context = null;
	}

	@Override
	protected SelectionListener getBrowseWorkspaceListener() {
		return new ImportProjectWorkspaceListener(getTxtProjectName(), getTxtProjectLocation(), getShell());
	}

	@Override
	protected SelectionListener getBrowseFilesystemListener() {
		return new SelectionListener() {
			
			public void widgetDefaultSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
				String path = dialog.open();
				String[] pathField = path.split("\\\\");
				getTxtProjectName().setText(pathField[pathField.length - 1]);
				getTxtProjectLocation().setText(getResourceLocation(getTxtProjectName().getText(), path));
			}

			public void widgetSelected(SelectionEvent e) {
				widgetDefaultSelected(e);
			}
			
		};
	}

	private void updateContext() {
		final ECPWorkspace workspace = WorkSpaceModelFactoryImpl.eINSTANCE.createECPWorkspace();
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
		
		XMIECPFileProject project = StructureFactory.eINSTANCE
		.createXMIECPFileProject();

		// set the information of the project
		project.setProjectName(getTxtProjectName().getText());
		project.setXmiFilePath(getTxtProjectLocation().getText());
		project.setProjectDescription(getTxtProjectDescription().getText());
		
		workspace.getProjects().add(project);
		workspace.setActiveProject(project);
		project.loadContents();
		context = workspace.getProjects().get(0);
	}

	@Override
	protected void addInputListener() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void okPressed() {
		// check if location already exists in workspace
		// if so -> warning -> return to dialog
		boolean failed = false;

//		if (XMIECPWorkspaceManager.projectPathExists(txtProjectLocation
//				.getText())) {
//			String warningTitle = "Duplicate Path in Workspace";
//			String warningMessage = "The path you entered already exists in the workspace.";
//			MessageDialog.openWarning(shell, warningTitle, warningMessage);
//			failed = true;
//		}

		// check for empty name
		if (!XmiUtil.validate(getTxtProjectName().getText())) {
			getTxtProjectName().setBackground(new Color(getShell().getDisplay(), 205,
					106, 106));
			failed = true;
		}
		if (!failed) {
			updateContext();
			close();
		}
//		if (!failed) {
//			handler.setProjectName(txtProjectName.getText());
//			handler.setProjectDescription(txtProjectDescription.getText());
//			handler.setProjectLocation(txtProjectLocation.getText());
//			close();
//		}
	}

	public ECPModelelementContext getContext() {
		return context;
	}
	
}
